package Computer;

import java.util.Date;

public class Repair extends PriceList {

    private double Price;
    private Date StartRepairDate;
    private Date EndRepairDate;
    private String NameOfDeviceInRepair;

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
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
}
