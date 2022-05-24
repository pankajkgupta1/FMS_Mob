package com.example.fleatmanagmentsystem.models.login;

import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User implements Parcelable {

    private Object _id;
    private String emailId;
    private String firstName;
    private String lastName;
    private Object clientId;
    private String organizationId;
    private String organizationName;
    private String organizationIdName;
    private String address;
    private String password;
    private List<String> roles = new ArrayList<String>();
    private String accessType;
    private String country;
    private Object userId;
    private Object phoneNo;
    private Object city;
    private Object pincode;
    private Object state;
    private Object createdBy;
    private Object createdOn;
    private Object resetToken;
    private Object tokenExpiry;
    private Boolean status;
    private Object grantedAuthorities;
    private Boolean isAccountNonExpired;
    private Boolean isAccountNonLocked;
    private Boolean isCredentialsNonExpired;
    private Boolean isEnabled;
    private Boolean enabled;
    private Boolean accountNonExpired;
    private Boolean accountNonLocked;
    private Boolean credentialsNonExpired;
    private Object authorities;
    private String username;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<User> CREATOR = new Creator<User>() {


        @SuppressWarnings({
                "unchecked"
        })
        public User createFromParcel(android.os.Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return (new User[size]);
        }

    }
            ;

    protected User(android.os.Parcel in) {
        this._id = ((Object) in.readValue((Object.class.getClassLoader())));
        this.emailId = ((String) in.readValue((String.class.getClassLoader())));
        this.firstName = ((String) in.readValue((String.class.getClassLoader())));
        this.lastName = ((String) in.readValue((String.class.getClassLoader())));
        this.clientId = ((Object) in.readValue((Object.class.getClassLoader())));
        this.organizationId = ((String) in.readValue((String.class.getClassLoader())));
        this.organizationName = ((String) in.readValue((String.class.getClassLoader())));
        this.organizationIdName = ((String) in.readValue((String.class.getClassLoader())));
        this.address = ((String) in.readValue((String.class.getClassLoader())));
        this.password = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.roles, (java.lang.String.class.getClassLoader()));
        this.accessType = ((String) in.readValue((String.class.getClassLoader())));
        this.country = ((String) in.readValue((String.class.getClassLoader())));
        this.userId = ((Object) in.readValue((Object.class.getClassLoader())));
        this.phoneNo = ((Object) in.readValue((Object.class.getClassLoader())));
        this.city = ((Object) in.readValue((Object.class.getClassLoader())));
        this.pincode = ((Object) in.readValue((Object.class.getClassLoader())));
        this.state = ((Object) in.readValue((Object.class.getClassLoader())));
        this.createdBy = ((Object) in.readValue((Object.class.getClassLoader())));
        this.createdOn = ((Object) in.readValue((Object.class.getClassLoader())));
        this.resetToken = ((Object) in.readValue((Object.class.getClassLoader())));
        this.tokenExpiry = ((Object) in.readValue((Object.class.getClassLoader())));
        this.status = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.grantedAuthorities = ((Object) in.readValue((Object.class.getClassLoader())));
        this.isAccountNonExpired = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.isAccountNonLocked = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.isCredentialsNonExpired = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.isEnabled = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.enabled = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.accountNonExpired = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.accountNonLocked = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.credentialsNonExpired = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.authorities = ((Object) in.readValue((Object.class.getClassLoader())));
        this.username = ((String) in.readValue((String.class.getClassLoader())));
        this.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
    }

    public User() {
    }

    public Object getId() {
        return _id;
    }

    public void setId(Object _id) {
        this._id = _id;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Object getClientId() {
        return clientId;
    }

    public void setClientId(Object clientId) {
        this.clientId = clientId;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationIdName() {
        return organizationIdName;
    }

    public void setOrganizationIdName(String organizationIdName) {
        this.organizationIdName = organizationIdName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Object getUserId() {
        return userId;
    }

    public void setUserId(Object userId) {
        this.userId = userId;
    }

    public Object getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Object phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Object getCity() {
        return city;
    }

    public void setCity(Object city) {
        this.city = city;
    }

    public Object getPincode() {
        return pincode;
    }

    public void setPincode(Object pincode) {
        this.pincode = pincode;
    }

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }

    public Object getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Object createdBy) {
        this.createdBy = createdBy;
    }

    public Object getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Object createdOn) {
        this.createdOn = createdOn;
    }

    public Object getResetToken() {
        return resetToken;
    }

    public void setResetToken(Object resetToken) {
        this.resetToken = resetToken;
    }

    public Object getTokenExpiry() {
        return tokenExpiry;
    }

    public void setTokenExpiry(Object tokenExpiry) {
        this.tokenExpiry = tokenExpiry;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Object getGrantedAuthorities() {
        return grantedAuthorities;
    }

    public void setGrantedAuthorities(Object grantedAuthorities) {
        this.grantedAuthorities = grantedAuthorities;
    }

    public Boolean getIsAccountNonExpired() {
        return isAccountNonExpired;
    }

    public void setIsAccountNonExpired(Boolean isAccountNonExpired) {
        this.isAccountNonExpired = isAccountNonExpired;
    }

    public Boolean getIsAccountNonLocked() {
        return isAccountNonLocked;
    }

    public void setIsAccountNonLocked(Boolean isAccountNonLocked) {
        this.isAccountNonLocked = isAccountNonLocked;
    }

    public Boolean getIsCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public void setIsCredentialsNonExpired(Boolean isCredentialsNonExpired) {
        this.isCredentialsNonExpired = isCredentialsNonExpired;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public Boolean getAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public Boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public Object getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Object authorities) {
        this.authorities = authorities;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(_id);
        dest.writeValue(emailId);
        dest.writeValue(firstName);
        dest.writeValue(lastName);
        dest.writeValue(clientId);
        dest.writeValue(organizationId);
        dest.writeValue(organizationName);
        dest.writeValue(organizationIdName);
        dest.writeValue(address);
        dest.writeValue(password);
        dest.writeList(roles);
        dest.writeValue(accessType);
        dest.writeValue(country);
        dest.writeValue(userId);
        dest.writeValue(phoneNo);
        dest.writeValue(city);
        dest.writeValue(pincode);
        dest.writeValue(state);
        dest.writeValue(createdBy);
        dest.writeValue(createdOn);
        dest.writeValue(resetToken);
        dest.writeValue(tokenExpiry);
        dest.writeValue(status);
        dest.writeValue(grantedAuthorities);
        dest.writeValue(isAccountNonExpired);
        dest.writeValue(isAccountNonLocked);
        dest.writeValue(isCredentialsNonExpired);
        dest.writeValue(isEnabled);
        dest.writeValue(enabled);
        dest.writeValue(accountNonExpired);
        dest.writeValue(accountNonLocked);
        dest.writeValue(credentialsNonExpired);
        dest.writeValue(authorities);
        dest.writeValue(username);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return 0;
    }

}
