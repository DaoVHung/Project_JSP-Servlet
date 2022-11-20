package ra.Model.Entity;

import javax.lang.model.element.NestingKind;
import java.util.ArrayList;
import java.util.List;

public class Table {
    private int tableID;
    private String tableName;
    private int tableSeat;
    private boolean tableStatus;
    private String description ;

    private String tableImg;
    private List<String> stringListImg = new ArrayList<>();

    public Table() {
    }

    public Table(int tableID, String tableName, int tableSeat, boolean tableStatus, String description, String tableImg, List<String> stringListImg) {
        this.tableID = tableID;
        this.tableName = tableName;
        this.tableSeat = tableSeat;
        this.tableStatus = tableStatus;
        this.description = description;
        this.tableImg = tableImg;
        this.stringListImg = stringListImg;
    }

    public int getTableID() {
        return tableID;
    }

    public void setTableID(int tableID) {
        this.tableID = tableID;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getTableSeat() {
        return tableSeat;
    }

    public void setTableSeat(int tableSeat) {
        this.tableSeat = tableSeat;
    }

    public boolean isTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(boolean tableStatus) {
        this.tableStatus = tableStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTableImg() {
        return tableImg;
    }

    public void setTableImg(String tableImg) {
        this.tableImg = tableImg;
    }

    public List<String> getStringListImg() {
        return stringListImg;
    }

    public void setStringListImg(List<String> stringListImg) {
        this.stringListImg = stringListImg;
    }
}
