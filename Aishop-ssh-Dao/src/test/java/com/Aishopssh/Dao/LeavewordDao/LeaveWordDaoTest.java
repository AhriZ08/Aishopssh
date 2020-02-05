package com.Aishopssh.Dao.LeavewordDao;

import com.Aishopssh.Imp.LeavewordImp.LeaveWordImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext_Dao.xml")
public class LeaveWordDaoTest {

    @Autowired
    LeaveWordImp leaveWordImp;
    @Test
    public void getAllLeaveWordByUid() {
        System.out.println(leaveWordImp.GetAllLeaveWordByUid(1).get(0).getTitle());
    }

    @Test
    public void getLeaveWordByLid() {
        System.out.println(leaveWordImp.getLeaveWordByLid(1).getContent());
    }

    @Test
    public void getReplyById() {

    }
}