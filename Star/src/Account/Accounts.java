package Account;

import java.util.List;

public class Accounts {
    private int ID;
    private int ProfileID;
    private List<History> History;

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

    public List<Account.History> getHistory() {
        return History;
    }

    public void setHistory(List<Account.History> history) {
        History = history;
    }
}
