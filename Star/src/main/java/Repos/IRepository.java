package Repos;

import Computer.IHaveID;
import java.util.List;

public interface IRepository<Entity extends IHaveID> {
    public Entity get(int ProfileID);

    public List<Entity> getAll();

    public void Add(Entity entity);

    public void Update(Entity entity);

    public void Delete(Entity entity);
}