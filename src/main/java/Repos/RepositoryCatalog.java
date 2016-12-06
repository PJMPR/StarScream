package Repos;
import Repos.Mappers.ProfileMapper;
import Repos.Mappers.RepairMapper;
import Repos.UOW.IUnitOfWork;

import java.sql.Connection;
import java.sql.SQLException;

public class RepositoryCatalog {
    IUnitOfWork uow;
    Connection connection;

    public RepositoryCatalog(IUnitOfWork uow, Connection connection) {
        super();
        this.uow = uow;
        this.connection = connection;
    }

    public IProfileRepository profiles() {
        return new ProfileRepository(connection, new ProfileMapper(), uow);
    }

    public IRepairRepository repairs() {
        return new RepairRepository(connection, new RepairMapper(), uow);
    }

    public void saveAndClose() {
        try{
            uow.commit();
            connection.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
