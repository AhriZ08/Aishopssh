package com.Aishopssh.Imp.ManagerServiceImp;

import com.Aishopssh.Entites.User;

import java.util.List;

public interface ManageUserServiceImp {
    public List<User> GetAllUser();
    public List<User> GetUser(int id);
    public int DeleteUser(int id);
    public int FreezeUser(User user);
}
