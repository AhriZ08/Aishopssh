package com.Aishopssh.Imp.UserDaoImp;

import com.Aishopssh.Entites.User;

import java.util.List;

public interface UserCRUDImp {
    public User getOneUserByID(int id);
    public boolean insertOneUser(User user);
    public boolean deleteOneUserByID(int id);
    public boolean updateOneUser(User user);
    public List<User> getUserList();
}
