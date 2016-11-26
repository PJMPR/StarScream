package Repos;

import Computer.IHaveID;
import Repos.Mappers.IMapRSIntoEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseRepository <Entity extends IHaveID> implements IRepository{
    protected Connection connection;

    protected Statement CreateTable;

    protected PreparedStatement Insert;
    protected PreparedStatement Delete;
    protected PreparedStatement Update;
    protected PreparedStatement SelectByID;
    protected PreparedStatement SelectAll;

    protected IMapRSIntoEntity<Entity> mapper;

    protected BaseRepository (Connection connection, IMapRSIntoEntity<Entity> mapper){
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

    public Entity get(int ProfileID){
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

    public List<Entity> getAll(){
        try{
            List<Entity> result = new ArrayList<Entity>();
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

    public void Add(Entity entity){
        try {
            setupInsert(entity);
            Insert.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void Update(Entity entity){
        try{
            setupUpdate(entity);
            Update.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }


    public void Delete(Entity entity){
        try{
            Delete.setInt(1, entity.getID());
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

    protected abstract void setupInsert(Entity entity) throws SQLException;
    protected abstract void setupUpdate(Entity entity) throws SQLException;
    protected abstract String tableName();
    protected abstract String CreateTableSQL();
    protected abstract String InsertSQL();
    protected abstract String UpdateSQL();
}
