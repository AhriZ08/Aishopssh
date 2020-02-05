package com.Aishopssh.Service;

import com.Aishopssh.Entites.Leaveword;
import com.Aishopssh.Entites.Notice;
import com.Aishopssh.Entites.User;
import com.Aishopssh.Imp.UserImp.UserLoginImp;
import com.Aishopssh.Imp.LeavewordImp.LeaveWordImp;
import com.Aishopssh.Imp.UserImp.UserannouncementImp;
import com.Aishopssh.Imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service("UserService")
public class UserService implements UserServiceImp {


    @Autowired
    @Qualifier("UserInfoDao")
    UserLoginImp UserInfoDao;

    @Autowired
    @Qualifier("LeaveWordDao")
    LeaveWordImp LeaveWordDao;

    @Autowired
    @Qualifier("UserannouncementDao")
    UserannouncementImp UserannouncementDao;



    public void UserUpdate(User user) {
        UserInfoDao.update(user);
    }

    public void UserInsert(User user) {
        UserInfoDao.insert(user);
    }

    public User GetUserbyName(String username) {
        User user;
        user = UserInfoDao.GetUserbyName(username);
        return user;
    }

    public int Usernumber() {
        int number=0;
        number = UserInfoDao.getNo();
        return number;
    }

    public void IeavewordInsert(Leaveword leaveword){
        LeaveWordDao.insert(leaveword);
    }

    public User GetUserbyId(int id) {
        User user;
        user = UserInfoDao.GetUserbyId(id);
        return user;
    }

    public int GetLeavewordMaxid(){
        return LeaveWordDao.getMaxid();
    }

    public ArrayList<Notice> getall(){
        return UserannouncementDao.getAll();
    }
}
