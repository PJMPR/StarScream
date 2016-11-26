package Main.Computer;

import java.sql.Date;
import java.util.List;

public class Repair implements IHaveID {
//Price = get.somethingFromPriceList
    private int ID;
    private int ProfileID;
    private int Price;
    private Date StartRepairDate;
    private Date EndRepairDate;
    private String NameOfDeviceInRepair;
    private List<Repair> Repairs;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getProfileID() {
        return ProfileID;
    }

    public void setProfileID(int profileID) {
        ProfileID = profileID;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public Date getStartRepairDate() {
        return StartRepairDate;
    }

    public void setStartRepairDate(Date startRepairDate) {
        StartRepairDate = startRepairDate;
    }

    public Date getEndRepairDate() {
        return EndRepairDate;
    }

    public void setEndRepairDate(Date endRepairDate) {
        EndRepairDate = endRepairDate;
    }

    public String getNameOfDeviceInRepair() {
        return NameOfDeviceInRepair;
    }

    public void setNameOfDeviceInRepair(String nameOfDeviceInRepair) {
        NameOfDeviceInRepair = nameOfDeviceInRepair;
    }

    public List<Repair> getRepairs() {
        return Repairs;
    }

    public void setRepairs(List<Repair> repairs) {
        Repairs = repairs;
    }
}
