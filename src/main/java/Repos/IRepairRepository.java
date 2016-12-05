package Repos;

import Computer.Repair;

import java.util.List;

public interface IRepairRepository extends IRepository<Repair>{
    public List<Repair> repairs(String repair);
}
