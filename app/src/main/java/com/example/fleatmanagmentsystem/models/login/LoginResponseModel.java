package com.example.fleatmanagmentsystem.models.login;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class LoginResponseModel implements Parcelable {

    @SerializedName("access_token")
    @Expose
    private String accessToken;
    @SerializedName("token_type")
    @Expose
    private String tokenType;
    @SerializedName("refresh_token")
    @Expose
    private String refreshToken;
    @SerializedName("expires_in")
    @Expose
    private Integer expiresIn;
    @SerializedName("scope")
    @Expose
    private String scope;
    @SerializedName("mobileAppFunctionalitiesAccess")
    @Expose
    private MobileAppFunctionalitiesAccess mobileAppFunctionalitiesAccess;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("functionalitiesAccess")
    @Expose
    private FunctionalitiesAccess functionalitiesAccess;
    public final static Creator<LoginResponseModel> CREATOR = new Creator<LoginResponseModel>() {


        @SuppressWarnings({
                "unchecked"
        })
        public LoginResponseModel createFromParcel(android.os.Parcel in) {
            return new LoginResponseModel(in);
        }

        public LoginResponseModel[] newArray(int size) {
            return (new LoginResponseModel[size]);
        }

    }
            ;

    protected LoginResponseModel(android.os.Parcel in) {
        this.accessToken = ((String) in.readValue((String.class.getClassLoader())));
        this.tokenType = ((String) in.readValue((String.class.getClassLoader())));
        this.refreshToken = ((String) in.readValue((String.class.getClassLoader())));
        this.expiresIn = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.scope = ((String) in.readValue((String.class.getClassLoader())));
        this.mobileAppFunctionalitiesAccess = ((MobileAppFunctionalitiesAccess) in.readValue((MobileAppFunctionalitiesAccess.class.getClassLoader())));
        this.user = ((User) in.readValue((User.class.getClassLoader())));
        this.functionalitiesAccess = ((FunctionalitiesAccess) in.readValue((FunctionalitiesAccess.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public LoginResponseModel() {
    }

    /**
     *
     * @param expiresIn
     * @param scope
     * @param mobileAppFunctionalitiesAccess
     * @param accessToken
     * @param tokenType
     * @param user
     * @param refreshToken
     * @param functionalitiesAccess
     */
    public LoginResponseModel(String accessToken, String tokenType, String refreshToken, Integer expiresIn, String scope, MobileAppFunctionalitiesAccess mobileAppFunctionalitiesAccess, User user, FunctionalitiesAccess functionalitiesAccess) {
        super();
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.refreshToken = refreshToken;
        this.expiresIn = expiresIn;
        this.scope = scope;
        this.mobileAppFunctionalitiesAccess = mobileAppFunctionalitiesAccess;
        this.user = user;
        this.functionalitiesAccess = functionalitiesAccess;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public MobileAppFunctionalitiesAccess getMobileAppFunctionalitiesAccess() {
        return mobileAppFunctionalitiesAccess;
    }

    public void setMobileAppFunctionalitiesAccess(MobileAppFunctionalitiesAccess mobileAppFunctionalitiesAccess) {
        this.mobileAppFunctionalitiesAccess = mobileAppFunctionalitiesAccess;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public FunctionalitiesAccess getFunctionalitiesAccess() {
        return functionalitiesAccess;
    }

    public void setFunctionalitiesAccess(FunctionalitiesAccess functionalitiesAccess) {
        this.functionalitiesAccess = functionalitiesAccess;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(accessToken);
        dest.writeValue(tokenType);
        dest.writeValue(refreshToken);
        dest.writeValue(expiresIn);
        dest.writeValue(scope);
        dest.writeValue(mobileAppFunctionalitiesAccess);
        dest.writeValue(user);
        dest.writeValue(functionalitiesAccess);
    }

    public int describeContents() {
        return 0;
    }


    /*private String access_token;
    private String token_type;
    private String refresh_token;
    private Integer expires_in;
    private String scope;
    private Object mobileAppFunctionalitiesAccess;

    public Object getMobileAppFunctionalitiesAccess() {
        return mobileAppFunctionalitiesAccess;
    }

    public void setMobileAppFunctionalitiesAccess(Object mobileAppFunctionalitiesAccess) {
        this.mobileAppFunctionalitiesAccess = mobileAppFunctionalitiesAccess;
    }

    private User user;
    private Object functionalitiesAccess;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<LoginResponseModel> CREATOR = new Creator<LoginResponseModel>() {


        @SuppressWarnings({
                "unchecked"
        })
        public LoginResponseModel createFromParcel(android.os.Parcel in) {
            return new LoginResponseModel(in);
        }

        public LoginResponseModel[] newArray(int size) {
            return (new LoginResponseModel[size]);
        }

    }
            ;

    protected LoginResponseModel(android.os.Parcel in) {
        this.access_token = ((String) in.readValue((String.class.getClassLoader())));
        this.token_type = ((String) in.readValue((String.class.getClassLoader())));
        this.refresh_token = ((String) in.readValue((String.class.getClassLoader())));
        this.expires_in = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.scope = ((String) in.readValue((String.class.getClassLoader())));
        this.mobileAppFunctionalitiesAccess = ((Object) in.readValue((Object.class.getClassLoader())));
        this.user = ((User) in.readValue((User.class.getClassLoader())));
        this.functionalitiesAccess = ((Object) in.readValue((Object.class.getClassLoader())));
        this.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
    }

    public LoginResponseModel() {
    }

    public String getAccessToken() {
        return access_token;
    }

    public void setAccessToken(String access_token) {
        this.access_token = access_token;
    }

    public String getTokenType() {
        return token_type;
    }

    public void setTokenType(String token_type) {
        this.token_type = token_type;
    }

    public String getRefreshToken() {
        return refresh_token;
    }

    public void setRefreshToken(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public Integer getExpiresIn() {
        return expires_in;
    }

    public void setExpiresIn(Integer expires_in) {
        this.expires_in = expires_in;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Object getFunctionalitiesAccess() {
        return functionalitiesAccess;
    }

    public void setFunctionalitiesAccess(Object functionalitiesAccess) {
        this.functionalitiesAccess = functionalitiesAccess;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(access_token);
        dest.writeValue(token_type);
        dest.writeValue(refresh_token);
        dest.writeValue(expires_in);
        dest.writeValue(scope);
        dest.writeValue(mobileAppFunctionalitiesAccess);
        dest.writeValue(user);
        dest.writeValue(functionalitiesAccess);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return 0;
    }*/
}
