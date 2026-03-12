package util;

import java.io.FileWriter;
import java.io.IOException;
import model.Complaint;

public class FileHandler {

    private static final String FILE_PATH = "backend/data/complaints.txt";

    public static void saveComplaint(Complaint complaint) {

        try {
            FileWriter writer = new FileWriter(FILE_PATH, true);
            writer.write(complaint.toString() + "\n");
            writer.close();
        } 
        catch (IOException e) {
            System.out.println("Error saving complaint.");
        }

    }

}
