package com.Aishopssh.Imp.ManagerServiceImp;

import com.Aishopssh.Entites.Admin;

import java.util.List;

public interface ManageSelfServiceImp {
    public List<Admin> GetManager(int id);
    public int UpdateManager(Admin mgr);
}
