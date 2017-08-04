
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
    "avatar_hash",
    "real_name",
    "real_name_normalized",
    "image_24",
    "image_32",
    "image_48",
    "image_72",
    "image_192",
    "image_512",
    "team",
    "first_name",
    "last_name",
    "title",
    "phone",
    "skype",
    "status_text",
    "status_emoji",
    "image_1024",
    "image_original",
    "always_active",
    "fields"
})
public class Profile {

    @JsonProperty("avatar_hash")
    private String avatarHash;
    @JsonProperty("real_name")
    private String realName;
    @JsonProperty("real_name_normalized")
    private String realNameNormalized;
    @JsonProperty("image_24")
    private String image24;
    @JsonProperty("image_32")
    private String image32;
    @JsonProperty("image_48")
    private String image48;
    @JsonProperty("image_72")
    private String image72;
    @JsonProperty("image_192")
    private String image192;
    @JsonProperty("image_512")
    private String image512;
    @JsonProperty("team")
    private String team;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("title")
    private String title;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("skype")
    private String skype;
    @JsonProperty("status_text")
    private String statusText;
    @JsonProperty("status_emoji")
    private String statusEmoji;
    @JsonProperty("image_1024")
    private String image1024;
    @JsonProperty("image_original")
    private String imageOriginal;
    @JsonProperty("always_active")
    private boolean alwaysActive;
    @JsonProperty("fields")
    private Object fields;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("avatar_hash")
    public String getAvatarHash() {
        return avatarHash;
    }

    @JsonProperty("avatar_hash")
    public void setAvatarHash(String avatarHash) {
        this.avatarHash = avatarHash;
    }

    @JsonProperty("real_name")
    public String getRealName() {
        return realName;
    }

    @JsonProperty("real_name")
    public void setRealName(String realName) {
        this.realName = realName;
    }

    @JsonProperty("real_name_normalized")
    public String getRealNameNormalized() {
        return realNameNormalized;
    }

    @JsonProperty("real_name_normalized")
    public void setRealNameNormalized(String realNameNormalized) {
        this.realNameNormalized = realNameNormalized;
    }

    @JsonProperty("image_24")
    public String getImage24() {
        return image24;
    }

    @JsonProperty("image_24")
    public void setImage24(String image24) {
        this.image24 = image24;
    }

    @JsonProperty("image_32")
    public String getImage32() {
        return image32;
    }

    @JsonProperty("image_32")
    public void setImage32(String image32) {
        this.image32 = image32;
    }

    @JsonProperty("image_48")
    public String getImage48() {
        return image48;
    }

    @JsonProperty("image_48")
    public void setImage48(String image48) {
        this.image48 = image48;
    }

    @JsonProperty("image_72")
    public String getImage72() {
        return image72;
    }

    @JsonProperty("image_72")
    public void setImage72(String image72) {
        this.image72 = image72;
    }

    @JsonProperty("image_192")
    public String getImage192() {
        return image192;
    }

    @JsonProperty("image_192")
    public void setImage192(String image192) {
        this.image192 = image192;
    }

    @JsonProperty("image_512")
    public String getImage512() {
        return image512;
    }

    @JsonProperty("image_512")
    public void setImage512(String image512) {
        this.image512 = image512;
    }

    @JsonProperty("team")
    public String getTeam() {
        return team;
    }

    @JsonProperty("team")
    public void setTeam(String team) {
        this.team = team;
    }

    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("skype")
    public String getSkype() {
        return skype;
    }

    @JsonProperty("skype")
    public void setSkype(String skype) {
        this.skype = skype;
    }

    @JsonProperty("status_text")
    public String getStatusText() {
        return statusText;
    }

    @JsonProperty("status_text")
    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    @JsonProperty("status_emoji")
    public String getStatusEmoji() {
        return statusEmoji;
    }

    @JsonProperty("status_emoji")
    public void setStatusEmoji(String statusEmoji) {
        this.statusEmoji = statusEmoji;
    }

    @JsonProperty("image_1024")
    public String getImage1024() {
        return image1024;
    }

    @JsonProperty("image_1024")
    public void setImage1024(String image1024) {
        this.image1024 = image1024;
    }

    @JsonProperty("image_original")
    public String getImageOriginal() {
        return imageOriginal;
    }

    @JsonProperty("image_original")
    public void setImageOriginal(String imageOriginal) {
        this.imageOriginal = imageOriginal;
    }

    @JsonProperty("always_active")
    public boolean isAlwaysActive() {
        return alwaysActive;
    }

    @JsonProperty("always_active")
    public void setAlwaysActive(boolean alwaysActive) {
        this.alwaysActive = alwaysActive;
    }

    @JsonProperty("fields")
    public Object getFields() {
        return fields;
    }

    @JsonProperty("fields")
    public void setFields(Object fields) {
        this.fields = fields;
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
        return new HashCodeBuilder().append(avatarHash).append(realName).append(realNameNormalized).append(image24).append(image32).append(image48).append(image72).append(image192).append(image512).append(team).append(firstName).append(lastName).append(title).append(phone).append(skype).append(statusText).append(statusEmoji).append(image1024).append(imageOriginal).append(alwaysActive).append(fields).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Profile) == false) {
            return false;
        }
        Profile rhs = ((Profile) other);
        return new EqualsBuilder().append(avatarHash, rhs.avatarHash).append(realName, rhs.realName).append(realNameNormalized, rhs.realNameNormalized).append(image24, rhs.image24).append(image32, rhs.image32).append(image48, rhs.image48).append(image72, rhs.image72).append(image192, rhs.image192).append(image512, rhs.image512).append(team, rhs.team).append(firstName, rhs.firstName).append(lastName, rhs.lastName).append(title, rhs.title).append(phone, rhs.phone).append(skype, rhs.skype).append(statusText, rhs.statusText).append(statusEmoji, rhs.statusEmoji).append(image1024, rhs.image1024).append(imageOriginal, rhs.imageOriginal).append(alwaysActive, rhs.alwaysActive).append(fields, rhs.fields).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
