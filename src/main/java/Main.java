import Computer.Profile;
import Computer.Repair;
import Repos.UOW.UnitOfWork;
import Repos.RepositoryCatalog;
import java.util.List;
import java.sql.Date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main( String[] args ){
        String URL = "jdbc:hsqldb:hsql://localhost/workdb";

        try {
            Connection connection = DriverManager.getConnection(URL);

            RepositoryCatalog catalog = new RepositoryCatalog(new UnitOfWork(connection), connection);

            Repair device = new Repair();

            device.setProfileID(1);
            device.setStartRepairDate(Date(2014-03-02));
            device.setEndRepairDate(2014-03-02);
            device.setNameOfDeviceInRepair("Samsung");
            device.setPrice(50);

            catalog.repairs().Add(device);

            List<Repair> repairs = catalog.repairs().repairs("Samsung");

            System.out.println("Zapisuję urządzenie");

            catalog.saveAndClose();
        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("The end");
    }
}
