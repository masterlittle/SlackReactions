
package com.slack.users;

import java.util.HashMap;
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
    "id",
    "team_id",
    "name",
    "deleted",
    "profile",
    "is_bot",
    "updated",
    "is_app_user",
    "color",
    "real_name",
    "tz",
    "tz_label",
    "tz_offset",
    "is_admin",
    "is_owner",
    "is_primary_owner",
    "is_restricted",
    "is_ultra_restricted"
})
public class Member {

    @JsonProperty("id")
    private String id;
    @JsonProperty("team_id")
    private String teamId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("deleted")
    private boolean deleted;
    @JsonProperty("profile")
    private Profile profile;
    @JsonProperty("is_bot")
    private boolean isBot;
    @JsonProperty("updated")
    private long updated;
    @JsonProperty("is_app_user")
    private boolean isAppUser;
    @JsonProperty("color")
    private String color;
    @JsonProperty("real_name")
    private String realName;
    @JsonProperty("tz")
    private Object tz;
    @JsonProperty("tz_label")
    private String tzLabel;
    @JsonProperty("tz_offset")
    private long tzOffset;
    @JsonProperty("is_admin")
    private boolean isAdmin;
    @JsonProperty("is_owner")
    private boolean isOwner;
    @JsonProperty("is_primary_owner")
    private boolean isPrimaryOwner;
    @JsonProperty("is_restricted")
    private boolean isRestricted;
    @JsonProperty("is_ultra_restricted")
    private boolean isUltraRestricted;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("team_id")
    public String getTeamId() {
        return teamId;
    }

    @JsonProperty("team_id")
    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("deleted")
    public boolean isDeleted() {
        return deleted;
    }

    @JsonProperty("deleted")
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @JsonProperty("profile")
    public Profile getProfile() {
        return profile;
    }

    @JsonProperty("profile")
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @JsonProperty("is_bot")
    public boolean isIsBot() {
        return isBot;
    }

    @JsonProperty("is_bot")
    public void setIsBot(boolean isBot) {
        this.isBot = isBot;
    }

    @JsonProperty("updated")
    public long getUpdated() {
        return updated;
    }

    @JsonProperty("updated")
    public void setUpdated(long updated) {
        this.updated = updated;
    }

    @JsonProperty("is_app_user")
    public boolean isIsAppUser() {
        return isAppUser;
    }

    @JsonProperty("is_app_user")
    public void setIsAppUser(boolean isAppUser) {
        this.isAppUser = isAppUser;
    }

    @JsonProperty("color")
    public String getColor() {
        return color;
    }

    @JsonProperty("color")
    public void setColor(String color) {
        this.color = color;
    }

    @JsonProperty("real_name")
    public String getRealName() {
        return realName;
    }

    @JsonProperty("real_name")
    public void setRealName(String realName) {
        this.realName = realName;
    }

    @JsonProperty("tz")
    public Object getTz() {
        return tz;
    }

    @JsonProperty("tz")
    public void setTz(Object tz) {
        this.tz = tz;
    }

    @JsonProperty("tz_label")
    public String getTzLabel() {
        return tzLabel;
    }

    @JsonProperty("tz_label")
    public void setTzLabel(String tzLabel) {
        this.tzLabel = tzLabel;
    }

    @JsonProperty("tz_offset")
    public long getTzOffset() {
        return tzOffset;
    }

    @JsonProperty("tz_offset")
    public void setTzOffset(long tzOffset) {
        this.tzOffset = tzOffset;
    }

    @JsonProperty("is_admin")
    public boolean isIsAdmin() {
        return isAdmin;
    }

    @JsonProperty("is_admin")
    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @JsonProperty("is_owner")
    public boolean isIsOwner() {
        return isOwner;
    }

    @JsonProperty("is_owner")
    public void setIsOwner(boolean isOwner) {
        this.isOwner = isOwner;
    }

    @JsonProperty("is_primary_owner")
    public boolean isIsPrimaryOwner() {
        return isPrimaryOwner;
    }

    @JsonProperty("is_primary_owner")
    public void setIsPrimaryOwner(boolean isPrimaryOwner) {
        this.isPrimaryOwner = isPrimaryOwner;
    }

    @JsonProperty("is_restricted")
    public boolean isIsRestricted() {
        return isRestricted;
    }

    @JsonProperty("is_restricted")
    public void setIsRestricted(boolean isRestricted) {
        this.isRestricted = isRestricted;
    }

    @JsonProperty("is_ultra_restricted")
    public boolean isIsUltraRestricted() {
        return isUltraRestricted;
    }

    @JsonProperty("is_ultra_restricted")
    public void setIsUltraRestricted(boolean isUltraRestricted) {
        this.isUltraRestricted = isUltraRestricted;
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
        return new HashCodeBuilder().append(id).append(teamId).append(name).append(deleted).append(profile).append(isBot).append(updated).append(isAppUser).append(color).append(realName).append(tz).append(tzLabel).append(tzOffset).append(isAdmin).append(isOwner).append(isPrimaryOwner).append(isRestricted).append(isUltraRestricted).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Member) == false) {
            return false;
        }
        Member rhs = ((Member) other);
        return new EqualsBuilder().append(id, rhs.id).append(teamId, rhs.teamId).append(name, rhs.name).append(deleted, rhs.deleted).append(profile, rhs.profile).append(isBot, rhs.isBot).append(updated, rhs.updated).append(isAppUser, rhs.isAppUser).append(color, rhs.color).append(realName, rhs.realName).append(tz, rhs.tz).append(tzLabel, rhs.tzLabel).append(tzOffset, rhs.tzOffset).append(isAdmin, rhs.isAdmin).append(isOwner, rhs.isOwner).append(isPrimaryOwner, rhs.isPrimaryOwner).append(isRestricted, rhs.isRestricted).append(isUltraRestricted, rhs.isUltraRestricted).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
