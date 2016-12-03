package Repos;
import Repos.UOW.IUnitOfWork

import java.sql.Connection;
import java.sql.SQLException;

public class RepositoryCatalog implements IRepositoryCatalog{
    IUnitOfWork uow;
    Connection connection;


    public RepositoryCatalog(IUnitOfWork uow, Connection connection) {
        super();
        this.uow = uow;
        this.connection = connection;
    }


    public IPersonRepository people() {
        return new PersonRepository(connection, new PersonMapper(), uow);
    }

    public IRepairRepository accounts() {
        return new AccountRepository(connection, new AccountMapper(), people(), uow);
    }

    public IEnumRepository dictionaries() {
        return new EnumDictionaryRepository(connection, new EnumDirectoryMapper(), uow);
    }

    public IHistoryRepository history() {
        return new HistoryLogRepository(connection, new HistoryLogMapper(), uow);
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
