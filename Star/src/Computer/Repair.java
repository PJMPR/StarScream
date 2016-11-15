package Computer;

import java.util.Date;

public class Repair {

    private float Price;
    private Date StartRepairDate;
    private Date EndRepairDate;

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

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }
}

