package se.teamengine.java.test.models;

public class TaskOneRequest {
    private UserSession userSession;
    private String hmac;

    public TaskOneRequest(UserSession userSession, String hmac) {
        this.userSession = userSession;
        this.hmac = hmac;
    }

    public UserSession getUserSession() {
        return userSession;
    }

    public String getHmac() {
        return hmac;
    }
}
