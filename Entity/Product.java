package ra.Model.Entity;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private int productID;
    private String catalogID;
    private String productName;
    private int price ;
    private String title;
    private String description;
    private boolean productStatus;
    private String productImg;
    private List<String> listImgLinks = new ArrayList<>();

    public Product() {
    }

    public Product(int productID, String catalogID, String productName, int price, String title, String description, boolean productStatus, String productImg, List<String> listImgLinks) {
        this.productID = productID;
        this.catalogID = catalogID;
        this.productName = productName;
        this.price = price;
        this.title = title;
        this.description = description;
        this.productStatus = productStatus;
        this.productImg = productImg;
        this.listImgLinks = listImgLinks;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getCatalogID() {
        return catalogID;
    }

    public void setCatalogID(String catalogID) {
        this.catalogID = catalogID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public List<String> getListImgLinks() {
        return listImgLinks;
    }

    public void setListImgLinks(List<String> listImgLinks) {
        this.listImgLinks = listImgLinks;
    }
}
