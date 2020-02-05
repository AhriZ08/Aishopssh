package com.Aishopssh.Imp.UserImp;

import com.Aishopssh.Entites.Admin;
import com.Aishopssh.Entites.User;

public interface UserLoginImp {
    /**
     * 根据用户username获取用户信息
     * @param username 用户name
     * @return 用户信息
     */
    public User GetUserbyName(String username);
    /**
     * 根据用户信息添加用户
     * @param user 用户信息
     * @return 1 成功
     */
    public void insert(User user);
    /**
     * 根据用户信息更新用户信息
     * @param user 用户信息
     * @return 1 成功
     */
    public int update(User user);
    /**
     *
     *
     * @return 用户个数
     */
    public int getNo();
    /**
     *
     *
     * @return 管理员信息
     */
    public Admin getadmin();
    /**
     * 根据用户id获取用户信息
     * @param id 用户id
     * @return 用户信息
     */
    public User GetUserbyId(int id);
}
