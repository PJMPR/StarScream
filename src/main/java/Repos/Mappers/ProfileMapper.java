package Repos.Mappers;

import Computer.Profile;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfileMapper implements IMapRSIntoEntity<Profile> {
    public Profile map(ResultSet rs) throws SQLException{
        Profile p = new Profile();
        p.setID(rs.getInt("ID"));
        p.setName(rs.getString("Name"));
        p.setSurname(rs.getString("Surname"));
        p.setEmail(rs.getString("Email"));
        p.setPassword(rs.getString("Password"));
        p.setTotalPrice(rs.getInt("TotalPrice"));
        return p;
    }
}