package se.teamengine.java.test.models;

public class UserSession {

    private String userName;
    private String userIdentifier;
    private long sessionExpiery;

    public UserSession(String userName, String userIdentifier, long sessionExpiery) {
        this.userName = userName;
        this.userIdentifier = userIdentifier;
        this.sessionExpiery = sessionExpiery;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public long getSessionExpiery() {
        return sessionExpiery;
    }

    @Override
    public String toString() {
        return "UserName: " + userName + ", UserIdentifier: " + userIdentifier + ", sessionExpiery: " + sessionExpiery;
    }
}
