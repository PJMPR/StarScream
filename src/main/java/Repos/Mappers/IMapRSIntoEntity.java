package Repos.Mappers;

import Computer.IHaveID;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IMapRSIntoEntity<TEntity extends IHaveID> {
    public TEntity map(ResultSet rs) throws SQLException;
}
