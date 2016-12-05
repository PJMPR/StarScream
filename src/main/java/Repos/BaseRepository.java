package Repos;

import Computer.IHaveID;
import Repos.Mappers.IMapRSIntoEntity;
import Repos.UOW.IUnitOfWork;
import Repos.UOW.IUnitOfWorkRepository;
import Repos.UOW.Entity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseRepository <TEntity extends IHaveID>
        implements IRepository<TEntity>, IUnitOfWorkRepository{
    protected Connection connection;
    protected IUnitOfWork uow;
    protected Statement CreateTable;

    protected PreparedStatement Insert;
    protected PreparedStatement Delete;
    protected PreparedStatement Update;
    protected PreparedStatement SelectByID;
    protected PreparedStatement SelectAll;

    protected IMapRSIntoEntity<TEntity> mapper;

    protected BaseRepository (Connection connection, IMapRSIntoEntity<TEntity> mapper, IUnitOfWork uow){
        this.uow = uow;
        this.connection = connection;
        this.mapper = mapper;
        try {
            CreateTable = connection.createStatement();
            createTableIfNotExists();
            Insert = connection.prepareStatement(InsertSQL());
            Delete = connection.prepareStatement(DeleteSQL());
            Update = connection.prepareStatement(UpdateSQL());
            SelectByID = connection.prepareStatement(SelectByIdSQL());
            SelectAll = connection.prepareStatement(SelectAllSQL());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public TEntity get(int ProfileID){
        try{
            SelectByID.setInt(1, ProfileID);
            ResultSet rs = SelectByID.executeQuery();
            while(rs.next()){
                return mapper.map(rs);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public List<TEntity> getAll(){
        try{
            List<TEntity> result = new ArrayList<TEntity>();
            ResultSet rs = SelectAll.executeQuery();
            while(rs.next()){
                result.add(mapper.map(rs));
            }
            return result;
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public void Add(TEntity entity){
        try {
            setupInsert(entity);
            Insert.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void Update(TEntity entity){
        try {
            setupUpdate(entity);
            Update.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void Delete(TEntity entity){
        try{
            Delete.setInt(1, entity.getID());
            Delete.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void persistAdd(Entity entity){
        try{
            setupInsert((TEntity)entity.getEntity());
            Insert.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }

    }

    public void persistUpdate(Entity entity){
        try{
            setupUpdate((TEntity)entity.getEntity());
            Update.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }

    }

    public void persistDelete(Entity entity){
        try{
            Delete.setInt(1, ((TEntity)entity.getEntity()).getID());
            Delete.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    private void createTableIfNotExists()
            throws SQLException {
        boolean tableExists = false;
        ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
        while(rs.next()){
            if(rs.getString("TABLE_NAME").equalsIgnoreCase(tableName())){
                tableExists=true;
                break;
            }
        }
        if(!tableExists)
            CreateTable.executeUpdate(CreateTableSQL());
    }

    protected String DeleteSQL() {
        return "DELETE FROM "
                + tableName()
                + " WHERE id = ?";
    }

    protected String SelectByIdSQL() {
        return "SELECT * FROM "
                + tableName()
                + " WHERE id=?";
    }

    protected String SelectAllSQL() {
        return "SELECT * FROM " + tableName();
    }

    protected abstract void setupInsert(TEntity entity) throws SQLException;
    protected abstract void setupUpdate(TEntity entity) throws SQLException;
    protected abstract String tableName();
    protected abstract String CreateTableSQL();
    protected abstract String InsertSQL();
    protected abstract String UpdateSQL();
}
