package Account;

import Computer.Repair;

import java.util.List;

public class Accounts {
    private int ID;
    private int ProfileID;
    private List<Repair> Repair;

    public int getID() {
        return ID;
    }

    public void setID(int _ID) {
        this.ID = _ID;
    }

    public int getProfileID() {
        return ProfileID;
    }

    public void setProfileID(int profileID) {
        ProfileID = profileID;
    }

    public List<Computer.Repair> getRepair() {
        return Repair;
    }

    public void setRepair(List<Computer.Repair> repair) {
        Repair = repair;
    }
}
