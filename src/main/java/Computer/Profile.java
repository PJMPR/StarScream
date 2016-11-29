package Computer;

import java.util.List;

public class Profile implements IHaveID {
//TotalPrice = getPrice of all devices on the list
    private int ID;
    private String Name;
    private String Surname;
    private List<Repair> DevicesInRepair;
    private String Email;
    private String Password;
    private int TotalPrice;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public List<Repair> getDevicesInRepair() {
        return DevicesInRepair;
    }

    public void setDevicesInRepair(List<Repair> devicesInRepair) {
        DevicesInRepair = devicesInRepair;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        TotalPrice = totalPrice;
    }
}
