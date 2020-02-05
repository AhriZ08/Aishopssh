package com.Aishopssh.Service;

import com.Aishopssh.Dao.LeavewordDao.LeaveWordDao;
import com.Aishopssh.Entites.AdminReply;
import com.Aishopssh.Entites.Leaveword;
import com.Aishopssh.Imp.LeavewordImp.LeaveWordImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Maredb
 * @date 2019-12-24 - 14:27
 */
@Service("LeaveWordService")
public class LeaveWordService implements LeaveWordImp {

    @Autowired
    LeaveWordService leaveWord;

    //根据用户ID获得留言信息
    public List<Leaveword> GetAllLeaveWordByUid(int id) {
        return leaveWord.GetAllLeaveWordByUid(id);
    }

    //根据留言ID获取留言信息
    public Leaveword getLeaveWordByLid(int id) {
        return leaveWord.getLeaveWordByLid(id);
    }

    //根据留言ID获取回复信息
    public AdminReply getReplyById(int id) {
        return leaveWord.getReplyById(id);
    }

    @Override
    public void insert(Leaveword leaveword) {
        leaveWord.insert(leaveword);
    }

    @Override
    public int getMaxid() {
        leaveWord.getMaxid();
        return 0;
    }
}
