package Repos;

import Computer.IHaveID;

import java.util.List;

public interface IRepository<TEntity extends IHaveID> {
    public TEntity get(int ProfileID);

    public List<TEntity> getAll();

    public void Add(TEntity entity);

    public void Update(TEntity entity);

    public void Delete(TEntity entity);
}