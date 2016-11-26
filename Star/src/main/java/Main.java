import Computer.Profile;
import Computer.Repair;
import Repos.Mappers.IMapRSIntoEntity;
import Repos.Mappers.ProfileMapper;
import Repos.Mappers.RepairMapper;
import Repos.ProfileRepository;
import Repos.RepairRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main( String[] args ){
        String URL = "jdbc:hsqldb:hsql://localhost/testdb";
        try {
            Connection connection = DriverManager.getConnection(URL);
            IMapRSIntoEntity<Repair> repairMapper = new RepairMapper();
            IMapRSIntoEntity<Profile> profileMapper = new ProfileMapper();

            RepairRepository repo = new RepairRepository(connection, repairMapper);
            ProfileRepository repo1 = new ProfileRepository(connection, profileMapper);

            Repair SamsungGalaxyS5 = new Repair();
            SamsungGalaxyS5.setNameOfDeviceInRepair("Samsung Galaxy S5");
            SamsungGalaxyS5.setPrice(50);

            System.out.println("Adding the device to the database");
            repo.Add(SamsungGalaxyS5);
        }catch (SQLException e){
            e.printStackTrace();
        }

        System.out.println("The end");
    }
}
