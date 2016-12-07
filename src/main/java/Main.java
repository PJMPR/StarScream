import Computer.Profile;
import Computer.Repair;
import Repos.UOW.UnitOfWork;
import Repos.RepositoryCatalog;

import java.text.ParseException;
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
            try {
				device.setStartRepairDate(20140302);
			} catch (ParseException e) {
				e.printStackTrace();
			}
            try {
				device.setEndRepairDate(20140302);
			} catch (ParseException e) {
				e.printStackTrace();
			}
            device.setNameOfDeviceInRepair("Samsung");
            device.setPrice(50);

            catalog.repairs().Add(device);

            List<Repair> repairs = catalog.repairs().repairs("Samsung");

            System.out.println("Zapisuję urządzenie");
            
            Profile profile = new Profile();
            
            profile.setName("Jan");
            profile.setSurname("Miętki");
            profile.setEmail("email@gmail.com");
            profile.setPassword("qwerty");
            profile.setTotalPrice(50);
            
            catalog.profiles().Add(profile);
            
            System.out.println("Zapisuję profil");

            catalog.saveAndClose();
        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("The end");
    }
}
