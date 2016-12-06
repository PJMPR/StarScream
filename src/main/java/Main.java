import Computer.Profile;
import Computer.Repair;
import Repos.UOW.UnitOfWork;
import Repos.RepositoryCatalog;
import java.util.List;

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
            device.setNameOfDeviceInRepair("Samsung Galaxy S5");

            catalog.repairs().Add(device);

            System.out.println("Zapisuję urządzenie");

            catalog.saveAndClose();

        }catch (SQLException e){
            e.printStackTrace();
        }

        System.out.println("The end");
    }
}
