package Repos;

import Computer.Profile;

import java.util.List;

public interface IProfileRepository extends IRepository<Profile>{
    public List<Profile> profiles(String name);
}
