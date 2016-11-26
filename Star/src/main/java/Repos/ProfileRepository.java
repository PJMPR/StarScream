package Repos;

import Main.Computer.Account.Profile;
import Main.Computer.Repair;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfileRepository {
    private Connection connection;

    private String CreateTableSQL = "CREATE TABLE Profile(" +
            "ID int GENERATED BY DEFAULT AS IDENTITY" +
            "Name VARCHAR (30)" +
            "Surname VARCHAR(40)" +
            "Email VARCHAR(50)" +
            "Password VARCHAR (18)" +
            "TotalPrice int" +
            ")";

    private Statement createTable;

    private String InsertSQL = "INSERT INTO Profile(Name, Surname, Email, Password, TotalPrice) VALUES (?, ?, ?, ?, ?)";
    private String DeleteSQL = "DELETE FROM Profile WHERE ID = ?";
    private String UpdateSQL = "UPDATE Profile set Name = ?, Surname = ?, Email = ?, Password = ?, TotalPrice = ?";
    private String SelectByIdSQL = "SELECT * FROM Profile WHERE ID=?";
    private String SelectAllSQL = "SELECT * FROM Profile";

    private PreparedStatement Insert;
    private PreparedStatement Delete;
    private PreparedStatement Update;
    private PreparedStatement SelectByID;
    private PreparedStatement SelectAll;

    public ProfileRepository(Connection connection){
        this.connection = connection;

        try{
            createTable = connection.createStatement();

            boolean tableExists = false;
            ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
            while (rs.next()){
                if(rs.getString("TABLE_NAME").equalsIgnoreCase("Repair")){
                    tableExists = true;
                    break;
                }
            }
            if(!tableExists){
                createTable.executeUpdate(CreateTableSQL);
                Insert = connection.prepareStatement(InsertSQL);
                Delete = connection.prepareStatement(DeleteSQL);
                Update = connection.prepareStatement(UpdateSQL);
                SelectByID = connection.prepareStatement(SelectByIdSQL);
                SelectAll = connection.prepareStatement(SelectAllSQL);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Profile get(int ProfileID){
        try {
            SelectByID.setInt(1, ProfileID);
            ResultSet rs = SelectByID.executeQuery();
            while (rs.next()){
                Profile result = new Profile();
                result.setID(ProfileID);
                result.setName(rs.getString("Name"));
                result.setSurname(rs.getString("Surname"));
                result.setEmail(rs.getString("Email"));
                result.setPassword(rs.getString("Password"));
                result.setTotalPrice(rs.getInt("TotalPrice"));
                return result;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Profile> getAll(){
        try {
            List<Profile> result = new ArrayList<Profile>();
            ResultSet rs = SelectAll.executeQuery();
            while (rs.next()){
                Profile p = new Profile();
                p.setID(rs.getInt("ID"));
                p.setName(rs.getString("Name"));
                p.setSurname(rs.getString("Surname"));
                p.setEmail(rs.getString("Email"));
                p.setPassword(rs.getString("Password"));
                p.setTotalPrice(rs.getInt("TotalPrice"));
                result.add(p);
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public void Delete (Profile P){
        try{
            Delete.setInt(1, P.getID());
            Delete.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void Add (Profile P){
        try {
            Insert.setString(1, P.getName());
            Insert.setString(2, P.getSurname());
            Insert.setString(3, P.getEmail());
            Insert.setString(4, P.getPassword());
            Insert.setInt(5, P.getTotalPrice());
            Insert.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void Update (Profile P){
        try {
            Update.setString(1, P.getName());
            Update.setString(2, P.getSurname());
            Update.setString(3, P.getEmail());
            Update.setString(4, P.getPassword());
            Update.setInt(5, P.getTotalPrice());
            Update.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}