package com.Aishopssh.Imp.ManagerImp;

import com.Aishopssh.Entites.Admin;

import java.util.List;

public interface ManageSelfDaoImp {
    public List<Admin> GetManager(int id);
    public int UpdateManager(Admin mgr);
}
