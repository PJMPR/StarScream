package Repos.Mappers;

import Computer.IHaveID;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IMapRSIntoEntity<Entity> extends IHaveID {
    public Entity map(ResultSet rs) throws SQLException;
}
