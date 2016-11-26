package Repos.Mappers;

import Main.Computer.Repair;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RepairMapper {
    public Repair map(ResultSet rs) throws SQLException{
        Repair r = new Repair();
        r.setID(rs.getInt("ID"));
        r.setProfileID(rs.getInt("ProfileID"));
        r.setNameOfDeviceInRepair(rs.getString("NameOfDevice"));
        r.setStartRepairDate(rs.getDate("DateOfAcceptance"));
        r.setStartRepairDate(rs.getDate("ExpectedDateOfReception"));
        r.setPrice(rs.getInt("Price"));
        return r;
    }
}
