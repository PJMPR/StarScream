package Account;

import java.util.List;

public class Profile {
    private int ID;
    private String Name;
    private String Surname;
    private List<Accounts> AccountList;
    private String Email;
    private String Password;

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

    public List<Accounts> getAccountList() {
        return AccountList;
    }

    public void setAccountList(List<Accounts> accountList) {
        AccountList = accountList;
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
}
