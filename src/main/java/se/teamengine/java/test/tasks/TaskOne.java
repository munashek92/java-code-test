package se.teamengine.java.test.tasks;

import com.google.gson.Gson;
import se.teamengine.java.test.models.TaskOneRequest;
import se.teamengine.java.test.models.UserSession;
import se.teamengine.java.test.util.HMacUtil;

import java.util.Date;

public class TaskOne {

    private Gson gson = new Gson();
    private static final long TWO_HOURS_MS = 1000 * 60 * 60 * 2;

    /***
     * Task: add code that makes this method return true by modifying the jsonString variable.
     *
     * @return
     */
    private boolean run() {
        String jsonString = "";
        // TODO keep your code changes below this comment
        UserSession userSession = new UserSession("tester@example.com", "s1337", new Date().getTime() + TWO_HOURS_MS - 1);
        String userSessionString = userSession.toString();
        String hmac = HMacUtil.generateHMAC(userSessionString);

        TaskOneRequest request = new TaskOneRequest(userSession, hmac);
        jsonString = gson.toJson(request);

        // TODO keep your code changes above this comment
        return receiver(jsonString);
    }


    private boolean receiver(String jsonString) {
        if (jsonString == null || jsonString.isEmpty()) {
            return false;
        }
        TaskOneRequest request = gson.fromJson(jsonString, TaskOneRequest.class);
        HMacUtil.assertHMacValid(request.getUserSession().toString(), request.getHmac());

        return isSessionValid(request.getUserSession());
    }

    private boolean isSessionValid(UserSession session) {
        long currentTime = new Date().getTime();
        return session != null && session.getUserIdentifier().equals("s1337") && session.getUserName().equals("tester@example.com") &&
                session.getSessionExpiery() > currentTime && session.getSessionExpiery() < currentTime + TWO_HOURS_MS;
    }

    public boolean verify() {
        try {
            return run();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}