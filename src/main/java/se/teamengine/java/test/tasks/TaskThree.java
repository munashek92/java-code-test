package se.teamengine.java.test.tasks;

import org.apache.pdfbox.pdmodel.PDDocument;


import java.io.File;

public class TaskThree {

    // TODO Your task is to print the table of content in "example_file.pdf"
    private boolean run() {
        try {
            File examplePDF = new File(System.getProperty("user.dir") + File.separator + "example_file.pdf");
            PDDocument doc = PDDocument.load(examplePDF);



            doc.close();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
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
