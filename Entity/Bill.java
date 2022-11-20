package ra.Model.Entity;

import java.time.LocalDate;
import java.util.Date;

public class Bill {
    private int billID ;
    private int foodID;
    private int drinksID;
    private int tableID;
    private boolean billStatus;
    private int price;
    private Date created;

    public Bill() {
    }

    public Bill(int billID, int foodID, int drinksID, int tableID, boolean billStatus, int price, Date created) {
        this.billID = billID;
        this.foodID = foodID;
        this.drinksID = drinksID;
        this.tableID = tableID;
        this.billStatus = billStatus;
        this.price = price;
        this.created = created;
    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public int getDrinksID() {
        return drinksID;
    }

    public void setDrinksID(int drinksID) {
        this.drinksID = drinksID;
    }

    public int getTableID() {
        return tableID;
    }

    public void setTableID(int tableID) {
        this.tableID = tableID;
    }

    public boolean isBillStatus() {
        return billStatus;
    }

    public void setBillStatus(boolean billStatus) {
        this.billStatus = billStatus;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
