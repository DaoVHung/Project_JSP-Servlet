package ra.Model.Entity;

public class Catalog {
    private int catalogID;
    private String catalogName;
    private String title;
    private boolean catalogStatus;

    public Catalog() {
    }

    public Catalog(int catalogID, String catalogName, String title, boolean catalogStatus) {
        this.catalogID = catalogID;
        this.catalogName = catalogName;
        this.title = title;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogID() {
        return catalogID;
    }

    public void setCatalogID(int catalogID) {
        this.catalogID = catalogID;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }
}
