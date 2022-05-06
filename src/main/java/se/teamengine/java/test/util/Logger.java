package se.teamengine.java.test.util;

import java.util.Date;

public class Logger {

    public void info(String s) {
        logMsg("[INFO] - " + s);
    }

    private void logMsg(String s) {
        System.out.println(new Date().toLocaleString() + " - " + s);
    }
}
