package WealthManager;

public class Identity {
    private String adharId;
    private String panId;
    public Identity(String adharId, String panId) {
        this.adharId = adharId;
        this.panId = panId;
    }
    public String getPanId() {
        return panId;
    }
    public String getAdharId() {
        return adharId;
    }
}
