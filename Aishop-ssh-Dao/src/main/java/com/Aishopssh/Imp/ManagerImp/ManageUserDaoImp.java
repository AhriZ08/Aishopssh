package com.Aishopssh.Imp.ManagerImp;

import com.Aishopssh.Entites.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ManageUserDaoImp {
    public List<User> GetAllUser();
    public List<User> GetUser(int id);
    public int DeleteUser(int id);
    public int FreezeUser(User user);
}
