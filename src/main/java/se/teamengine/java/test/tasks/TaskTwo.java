package se.teamengine.java.test.tasks;


import org.apache.commons.codec.digest.DigestUtils;

import java.util.HashMap;

public class TaskTwo {

    private HashMap<String, String> userPasswordDatabase;


    /***
     * Task: add code that makes this method return true by modifying the pwHash variable.
     *
     * @param username
     * @param password
     * @return
     */
    private boolean verifyUser(String username, String password) {
        String pwHash = "";
        // TODO add your code below this comment

        String saltedPassword = username + password;
        pwHash = DigestUtils.sha1Hex(saltedPassword);

        // TODO add your code above this comment
        return userPasswordDatabase.get(username).equals(pwHash);
    }

    private boolean run() {
        return verifyUser("tester@example.com", "¤%&/(hjkassdfals");
    }

    private void initDB() {
        // Add entry to database, username & password hash.
        // Password hashes are created by first prepending the username as a salt to the password, and then sha1 hashed
        userPasswordDatabase = new HashMap<String, String>();
        userPasswordDatabase.put("tester@example.com","cdb78f62ddd9d1bf4ad40ad961ab0f3240fc9b1f" );
    }

    public boolean verify() {
        initDB();
        try {
            return run();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
