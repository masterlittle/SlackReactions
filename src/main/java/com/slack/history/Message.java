
package com.slack.history;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "user",
    "text",
    "ts",
    "reactions",
    "edited",
    "thread_ts",
    "parent_user_id",
    "reply_count",
    "replies",
    "subscribed",
    "last_read",
    "unread_count"
})
public class Message {

    @JsonProperty("type")
    private String type;
    @JsonProperty("user")
    private String user;
    @JsonProperty("text")
    private String text;
    @JsonProperty("ts")
    private String ts;
    @JsonProperty("reactions")
    private List<Reaction> reactions = null;
    @JsonProperty("edited")
    private Edited edited;
    @JsonProperty("thread_ts")
    private String threadTs;
    @JsonProperty("parent_user_id")
    private String parentUserId;
    @JsonProperty("reply_count")
    private long replyCount;
    @JsonProperty("replies")
    private List<Reply> replies = null;
    @JsonProperty("subscribed")
    private boolean subscribed;
    @JsonProperty("last_read")
    private String lastRead;
    @JsonProperty("unread_count")
    private long unreadCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("user")
    public String getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(String user) {
        this.user = user;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("ts")
    public String getTs() {
        return ts;
    }

    @JsonProperty("ts")
    public void setTs(String ts) {
        this.ts = ts;
    }

    @JsonProperty("reactions")
    public List<Reaction> getReactions() {
        return reactions;
    }

    @JsonProperty("reactions")
    public void setReactions(List<Reaction> reactions) {
        this.reactions = reactions;
    }

    @JsonProperty("edited")
    public Edited getEdited() {
        return edited;
    }

    @JsonProperty("edited")
    public void setEdited(Edited edited) {
        this.edited = edited;
    }

    @JsonProperty("thread_ts")
    public String getThreadTs() {
        return threadTs;
    }

    @JsonProperty("thread_ts")
    public void setThreadTs(String threadTs) {
        this.threadTs = threadTs;
    }

    @JsonProperty("parent_user_id")
    public String getParentUserId() {
        return parentUserId;
    }

    @JsonProperty("parent_user_id")
    public void setParentUserId(String parentUserId) {
        this.parentUserId = parentUserId;
    }

    @JsonProperty("reply_count")
    public long getReplyCount() {
        return replyCount;
    }

    @JsonProperty("reply_count")
    public void setReplyCount(long replyCount) {
        this.replyCount = replyCount;
    }

    @JsonProperty("replies")
    public List<Reply> getReplies() {
        return replies;
    }

    @JsonProperty("replies")
    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    @JsonProperty("subscribed")
    public boolean isSubscribed() {
        return subscribed;
    }

    @JsonProperty("subscribed")
    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
    }

    @JsonProperty("last_read")
    public String getLastRead() {
        return lastRead;
    }

    @JsonProperty("last_read")
    public void setLastRead(String lastRead) {
        this.lastRead = lastRead;
    }

    @JsonProperty("unread_count")
    public long getUnreadCount() {
        return unreadCount;
    }

    @JsonProperty("unread_count")
    public void setUnreadCount(long unreadCount) {
        this.unreadCount = unreadCount;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(type).append(user).append(text).append(ts).append(reactions).append(edited).append(threadTs).append(parentUserId).append(replyCount).append(replies).append(subscribed).append(lastRead).append(unreadCount).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Message) == false) {
            return false;
        }
        Message rhs = ((Message) other);
        return new EqualsBuilder().append(type, rhs.type).append(user, rhs.user).append(text, rhs.text).append(ts, rhs.ts).append(reactions, rhs.reactions).append(edited, rhs.edited).append(threadTs, rhs.threadTs).append(parentUserId, rhs.parentUserId).append(replyCount, rhs.replyCount).append(replies, rhs.replies).append(subscribed, rhs.subscribed).append(lastRead, rhs.lastRead).append(unreadCount, rhs.unreadCount).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
