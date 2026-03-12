package model;

public class Complaint {
   

    private String complaintId;
    private String userId;
    private String category;
    private String description;
    private String status;

    public Complaint(String complaintId, String userId, String category, String description, String status) {
        this.complaintId = complaintId;
        this.userId = userId;
        this.category = category;
        this.description = description;
        this.status = status;
    }

    public String getComplaintId() {
        return complaintId;
    }

    public String getUserId() {
        return userId;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String toString() {
        return complaintId + "," + userId + "," + category + "," + description + "," + status;
    }
}

