package com.Aishopssh.Imp;

import com.Aishopssh.Entites.Leaveword;
import com.Aishopssh.Entites.Notice;
import com.Aishopssh.Entites.User;

import java.util.ArrayList;

public interface UserServiceImp {
    public void UserUpdate (User user);
    public void UserInsert (User user);
    public User GetUserbyName(String username);
    public int Usernumber();
    public void IeavewordInsert(Leaveword leaveword);
    public User GetUserbyId(int id);
    public int GetLeavewordMaxid();
    public ArrayList<Notice> getall();
}
