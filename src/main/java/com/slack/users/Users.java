
package com.slack.users;

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
    "members",
    "cache_ts"
})
public class Users {

    @JsonProperty("ok")
    private boolean ok;
    @JsonProperty("members")
    private List<Member> members = null;
    @JsonProperty("cache_ts")
    private long cacheTs;
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

    @JsonProperty("members")
    public List<Member> getMembers() {
        return members;
    }

    @JsonProperty("members")
    public void setMembers(List<Member> members) {
        this.members = members;
    }

    @JsonProperty("cache_ts")
    public long getCacheTs() {
        return cacheTs;
    }

    @JsonProperty("cache_ts")
    public void setCacheTs(long cacheTs) {
        this.cacheTs = cacheTs;
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
        return new HashCodeBuilder().append(ok).append(members).append(cacheTs).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Users) == false) {
            return false;
        }
        Users rhs = ((Users) other);
        return new EqualsBuilder().append(ok, rhs.ok).append(members, rhs.members).append(cacheTs, rhs.cacheTs).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
