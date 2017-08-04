
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
    "ok",
    "latest",
    "oldest",
    "messages",
    "has_more"
})
public class LeaveHistory {

    @JsonProperty("ok")
    private boolean ok;
    @JsonProperty("latest")
    private String latest;
    @JsonProperty("oldest")
    private String oldest;
    @JsonProperty("messages")
    private List<Message> messages = null;
    @JsonProperty("has_more")
    private boolean hasMore;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ok")
    public boolean isOk() {
        return ok;
    }

    @JsonProperty("ok")
    public void setOk(boolean ok) {
        this.ok = ok;
    }

    @JsonProperty("latest")
    public String getLatest() {
        return latest;
    }

    @JsonProperty("latest")
    public void setLatest(String latest) {
        this.latest = latest;
    }

    @JsonProperty("oldest")
    public String getOldest() {
        return oldest;
    }

    @JsonProperty("oldest")
    public void setOldest(String oldest) {
        this.oldest = oldest;
    }

    @JsonProperty("messages")
    public List<Message> getMessages() {
        return messages;
    }

    @JsonProperty("messages")
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @JsonProperty("has_more")
    public boolean isHasMore() {
        return hasMore;
    }

    @JsonProperty("has_more")
    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
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
        return new HashCodeBuilder().append(ok).append(latest).append(oldest).append(messages).append(hasMore).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LeaveHistory) == false) {
            return false;
        }
        LeaveHistory rhs = ((LeaveHistory) other);
        return new EqualsBuilder().append(ok, rhs.ok).append(latest, rhs.latest).append(oldest, rhs.oldest).append(messages, rhs.messages).append(hasMore, rhs.hasMore).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
