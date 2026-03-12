package service;

import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

import model.Complaint;
import util.FileHandler;

public class ComplaintService {

    private static HashMap<String, Complaint> complaintMap = new HashMap<>();
    private static Queue<Complaint> complaintQueue = new LinkedList<>();

    // Register complaint
    public static void registerComplaint(Complaint complaint) {

        complaintMap.put(complaint.getComplaintId(), complaint);
        complaintQueue.add(complaint);

        FileHandler.saveComplaint(complaint);

        System.out.println("Complaint Registered Successfully!");
        System.out.println("Your Complaint ID: " + complaint.getComplaintId());
    }

    // Track complaint
    public static Complaint trackComplaint(String complaintId) {

        return complaintMap.get(complaintId);
    }

    // Update complaint status
    public static void updateStatus(String complaintId, String newStatus) {

        Complaint complaint = complaintMap.get(complaintId);

        if (complaint != null) {

            complaint.setStatus(newStatus);

            System.out.println("Complaint status updated successfully.");

        } 
        else {

            System.out.println("Complaint not found.");

        }

    }
// View all complaints
public static void viewAllComplaints() {

    if (complaintQueue.isEmpty()) {

        System.out.println("No complaints found.");
        return;

    }

    System.out.println("\n---- All Complaints ----");

    for (Complaint c : complaintQueue) {

        System.out.println("Complaint ID: " + c.getComplaintId());
        System.out.println("User ID: " + c.getUserId());
        System.out.println("Category: " + c.getCategory());
        System.out.println("Description: " + c.getDescription());
        System.out.println("Status: " + c.getStatus());
        System.out.println("------------------------");

    }

}
}