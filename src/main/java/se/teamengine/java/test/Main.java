package se.teamengine.java.test;

import se.teamengine.java.test.tasks.TaskOne;
import se.teamengine.java.test.tasks.TaskThree;
import se.teamengine.java.test.tasks.TaskTwo;
import se.teamengine.java.test.util.Logger;

public class Main {

    Logger log = new Logger();

    public static void main(String[] args) {
        new Main().run();
    }

    void run() {
        log.info("Starting application");

        TaskOne tOne = new TaskOne();
        TaskTwo tTwo = new TaskTwo();
        TaskThree tThree = new TaskThree();

        boolean tOneResult = tOne.verify();
        boolean tTwoResult = tTwo.verify();
        boolean tThreeResult = tThree.verify();

        log.info("Task one passed? " + tOneResult);
        log.info("Task two passed? " + tTwoResult);
        log.info("Task three passed? Manual check");


        log.info("Done.");
    }
}
