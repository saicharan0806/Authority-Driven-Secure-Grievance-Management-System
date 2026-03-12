import java.util.Scanner;
import model.Complaint;
import service.ComplaintService;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Authority Driven Secure Grievance System ===");

        while (true) {

            System.out.println("\n1. Register Complaint");
            System.out.println("2. Track Complaint");
            System.out.println("3. Update Complaint Status");
            System.out.println("4. View All Complaints");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("Enter User ID: ");
                String userId = sc.nextLine();

                System.out.print("Enter Category (Faculty/Bus/Hostel): ");
                String category = sc.nextLine();

                System.out.print("Enter Description: ");
                String description = sc.nextLine();

                String complaintId = "CMP" + System.currentTimeMillis();

                Complaint complaint = new Complaint(
                        complaintId,
                        userId,
                        category,
                        description,
                        "Pending"
                );

                ComplaintService.registerComplaint(complaint);

            }

            else if (choice == 2) {

                System.out.print("Enter Complaint ID: ");
                String id = sc.nextLine();

                Complaint complaint = ComplaintService.trackComplaint(id);

                if (complaint != null) {

                    System.out.println("\nComplaint Found");
                    System.out.println("Complaint ID: " + complaint.getComplaintId());
                    System.out.println("User ID: " + complaint.getUserId());
                    System.out.println("Category: " + complaint.getCategory());
                    System.out.println("Description: " + complaint.getDescription());
                    System.out.println("Status: " + complaint.getStatus());

                } 
                else {

                    System.out.println("Complaint Not Found");

                }

            }

            else if (choice == 3) {

                System.out.print("Enter Complaint ID: ");
                String id = sc.nextLine();

                System.out.print("Enter New Status (Pending/Resolved): ");
                String status = sc.nextLine();

                ComplaintService.updateStatus(id, status);

            }

            else if (choice == 4) {

                ComplaintService.viewAllComplaints();

            }

            else if (choice == 5) {

                System.out.println("Exiting system...");
                break;

            }

            else {

                System.out.println("Invalid choice. Try again.");

            }

        }

        sc.close();
    }
}