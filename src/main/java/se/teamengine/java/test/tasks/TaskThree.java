package se.teamengine.java.test.tasks;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;
import se.teamengine.java.test.util.Logger;


import java.io.File;

public class TaskThree {

    Logger log = new Logger();

    // TODO Your task is to print the table of content in "example_file.pdf". Your code should work for any pdf file!
    private boolean run() {
        try {
            File examplePDF = new File(System.getProperty("user.dir") + File.separator + "example_file.pdf");
            PDDocument doc = PDDocument.load(examplePDF);
            PDDocumentOutline tableContents = doc.getDocumentCatalog().getDocumentOutline();

            if (tableContents != null) {
                printTableOfContents(tableContents.getFirstChild(), "");
            } else {
                log.info("No table of contents found in the pdf document.");
            }

            doc.close();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void printTableOfContents(PDOutlineItem item, String indent) {

        while (item != null) {
            log.info(indent + item.getTitle());
            printTableOfContents(item.getFirstChild(), indent + "    ");
            item = item.getNextSibling();
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
