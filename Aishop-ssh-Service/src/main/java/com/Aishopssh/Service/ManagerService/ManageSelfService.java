package com.Aishopssh.Service.ManagerService;

import com.Aishopssh.Entites.Admin;
import com.Aishopssh.Imp.ManagerImp.ManageSelfDaoImp;
import com.Aishopssh.Imp.ManagerServiceImp.ManageSelfServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ManageSelfService")
public class ManageSelfService implements ManageSelfServiceImp {
    @Autowired
    @Qualifier("ManageSelfDao")
    private ManageSelfDaoImp manageSelfDao;


    @Override
    public List<Admin> GetManager(int id) {
        return manageSelfDao.GetManager(id);
    }

    @Override
    public int UpdateManager(Admin mgr) {
        manageSelfDao.UpdateManager(mgr);
        return 0;
    }
}
