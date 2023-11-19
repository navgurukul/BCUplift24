package org;

public class Identity {
    private String aadharId;
    private String pancardId;

    public Identity(String aadharId, String pancardId) {
        this.aadharId = aadharId;
        this.pancardId = pancardId;
    }

    public String getAadharId() {
        return aadharId;
    }

    public String getPancardId() {
        return pancardId;
    }
}

