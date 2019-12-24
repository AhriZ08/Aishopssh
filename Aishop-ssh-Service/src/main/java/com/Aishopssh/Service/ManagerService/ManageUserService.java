package com.Aishopssh.Service.ManagerService;

import com.Aishopssh.Entites.User;
import com.Aishopssh.Imp.ManagerImp.ManageUserDaoImp;
import com.Aishopssh.Imp.ManagerServiceImp.ManageUserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ManageUserService")
public class ManageUserService implements ManageUserServiceImp {
    @Autowired
    @Qualifier("ManageUserDao")
    private ManageUserDaoImp manageUserDao;

    @Override
    public List<User> GetAllUser() {
        return manageUserDao.GetAllUser();
    }

    @Override
    public List<User> GetUser(int id) {
        return manageUserDao.GetUser(id);
    }

    @Override
    public int DeleteUser(int id) {
        manageUserDao.DeleteUser(id);
        return 0;
    }

    @Override
    public int FreezeUser(User user) {
        manageUserDao.FreezeUser(user);
        return 0;
    }
}
