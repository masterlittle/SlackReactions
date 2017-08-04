import com.fasterxml.jackson.databind.ObjectMapper;
import com.slack.history.*;
import com.slack.users.Member;
import com.slack.users.Users;
import org.apache.commons.io.FileUtils;
import rx.Observable;
import rx.Subscriber;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by grofers on 03/08/17.
 */
public class Main {

    private static File file = new File("RawMessages.csv");
    private static File file2 = new File("FrequencyOfAllWords.csv");
    private static File file3 = new File("MostReactionsByUser.csv");
    private static File file4 = new File("UsersWhoHaveReactedMost.csv");
    private static File file5 = new File("MostMessagesByUser.csv");
    private static File file6 = new File("MostPopularUser.csv");

    public static void main(String args[]) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            LeaveHistory leaveHistory = objectMapper.readValue(new File("json/slack.json"), LeaveHistory.class);
            Users users = objectMapper.readValue(new File("json/users.json"), Users.class);

            getRawMessages(leaveHistory);
            getFrequencyOfAllWords(leaveHistory);
            getMostReactionsByUser(leaveHistory);
            getUsersWhoHaveReactedMost(leaveHistory, users);
            getMostMessagesByUser(leaveHistory);
            getUsersWhoseMessagesHaveMostReactions(leaveHistory, users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getUsersWhoseMessagesHaveMostReactions(LeaveHistory leaveHistory, Users users) {
        Observable.from(leaveHistory.getMessages())
                .filter(message -> message.getReactions() != null && message.getReactions().size() > 0)
                .flatMap(message -> {
                    System.out.println(message.getUser());
                        String user = message.getUser();
                         return Observable.from(message.getReactions())
                                .map(Reaction::getCount)
                                .reduce((aLong, aLong2) -> aLong + aLong2)
                                 .map(aLong -> {
                                     TrimmedUsers trimmedUsers = new TrimmedUsers();
                                     trimmedUsers.setCount(aLong);
                                     trimmedUsers.setUserId(user);
                                     return trimmedUsers;
                                 });

                })
                .map(trimmedUsers -> {
                    for (Member member : users.getMembers()) {
                        if (member.getId().equalsIgnoreCase(trimmedUsers.getUserId())) {
                            TrimmedUsers trimmedUsers1 = new TrimmedUsers();
                            trimmedUsers1.setUserId(member.getName());
                            trimmedUsers1.setCount(trimmedUsers.getCount());
                            return trimmedUsers1;
                        }
                    }
                    return new TrimmedUsers();
                })
                .groupBy(TrimmedUsers::getUserId)
                .flatMap(groups -> groups.collect(TrimmedUsers::new, (r, trimmedUsers) -> {
                    r.setUserId(trimmedUsers.getUserId());
                    r.setCount(r.getCount() + trimmedUsers.getCount());
                }))
                .sorted((trimmedUsers, trimmedUsers2) -> (int) (trimmedUsers.getCount() - trimmedUsers2.getCount()))
                .subscribe(new Subscriber<TrimmedUsers>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(TrimmedUsers trimmedUsers) {
                        try {
                            FileUtils.write(file6, trimmedUsers + "\n", true);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

    }

    private static void getRawMessages(LeaveHistory leaveHistory) {
        Observable.from(leaveHistory.getMessages())
                .map(message -> formatWords(message.getText()))
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        try {
                            FileUtils.write(file, s + "\n", true);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    private static void getFrequencyOfAllWords(LeaveHistory leaveHistory) {
        Observable.from(leaveHistory.getMessages())
                .flatMap(message -> {
                    String[] a = message.getText().split(" ");
                    return Observable.from(Arrays.asList(a));
                })
                .groupBy(s -> s)
                .flatMap(groups -> groups.collect(Words::new, (r, word) -> {
                    r.setWord(formatWords(word));
                    r.setCount(r.getCount() + 1);
                }))
                .sorted((words, words2) -> (int) (words.getCount() - words2.getCount()))
                .subscribe(new Subscriber<Words>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Words words) {
                        try {
                            FileUtils.write(file2, words + "\n", true);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

    }

    private static String formatWords(String word) {
        return word.replace(".", "")
                .replace(",", "")
                .replace(",", "")
                .replace(":", "")
                .replace("'", "");
    }

    private static void getMostMessagesByUser(LeaveHistory leaveHistory) {
        Observable.from(leaveHistory.getMessages())
                .map(Message::getUser)
                .groupBy(s -> s)
                .flatMap(groups -> groups.collect(TrimmedUsers::new, (r, trimmedUsers) -> {
                    r.setUserId(trimmedUsers);
                    r.setCount(r.getCount() + 1);
                }))
                .sorted((trimmedUsers, trimmedUsers2) -> (int) (trimmedUsers.getCount() - trimmedUsers2.getCount()))
                .subscribe(new Subscriber<TrimmedUsers>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(TrimmedUsers trimmedUsers) {
                        try {
                            FileUtils.write(file5, trimmedUsers + "\n", true);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    private static void getUsersWhoHaveReactedMost(LeaveHistory leaveHistory, Users users) {
        Observable.from(leaveHistory.getMessages())
                .filter(message -> message.getReactions() != null)
                .map(Message::getReactions)
                .flatMap(reactions -> Observable.from(reactions).flatMap(reaction -> Observable.from(reaction.getUsers())))
                .groupBy(s -> s)
                .flatMap(groups -> groups.collect(TrimmedUsers::new, (r, trimmedUsers) -> {
                    r.setUserId(trimmedUsers);
                    r.setCount(r.getCount() + 1);
                }))
                .map(trimmedUsers -> {
                    for (Member member : users.getMembers()) {
                        if (member.getId().equalsIgnoreCase(trimmedUsers.getUserId())) {
                            TrimmedUsers trimmedUsers1 = new TrimmedUsers();
                            trimmedUsers1.setUserId(member.getName());
                            trimmedUsers1.setCount(trimmedUsers.getCount());
                            return trimmedUsers1;
                        }
                    }
                    return new TrimmedUsers();
                })
                .sorted((trimmedUsers, trimmedUsers2) -> (int) (trimmedUsers.getCount() - trimmedUsers2.getCount()))
                .subscribe(new Subscriber<TrimmedUsers>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(TrimmedUsers trimmedUsers) {
                        try {
                            FileUtils.write(file4, trimmedUsers + "\n", true);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    private static void getMostReactionsByUser(LeaveHistory leaveHistory) {
        Observable.from(leaveHistory.getMessages())
                .filter(message -> message.getReactions() != null)
                .map(Message::getReactions)
                .flatMap(reactions -> Observable.from(reactions)
                        .map(reaction -> {
                            TrimmedReaction trimmedReaction = new TrimmedReaction();
                            trimmedReaction.setReaction(formatWords(reaction.getName()));
                            trimmedReaction.setCount(reaction.getCount());
                            return trimmedReaction;
                        }))
                .groupBy(TrimmedReaction::getReaction)
                .flatMap(groups -> groups.collect(TrimmedReaction::new, (r, trimmedReaction) -> {
                    r.setReaction(trimmedReaction.getReaction());
                    r.setCount(r.getCount() + trimmedReaction.getCount());
                }))
                .sorted((trimmedReaction, trimmedReaction2) -> (int) (trimmedReaction.getCount() - trimmedReaction2.getCount()))
                .subscribe(new Subscriber<TrimmedReaction>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(TrimmedReaction trimmedReaction) {
                        try {
                            FileUtils.write(file3, trimmedReaction + "\n", true);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
