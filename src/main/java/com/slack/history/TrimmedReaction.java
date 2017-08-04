package com.slack.history;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.*;

/**
 * Created by grofers on 03/08/17.
 */

public class TrimmedReaction {
    String reaction;
    long count;

    public String getReaction() {
        return reaction;
    }

    public void setReaction(String reaction) {
        this.reaction = reaction;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return reaction + "," + count;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
