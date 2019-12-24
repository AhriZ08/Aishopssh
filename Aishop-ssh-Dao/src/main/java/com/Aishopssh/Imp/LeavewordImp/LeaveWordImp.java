package com.Aishopssh.Imp.LeavewordImp;

import com.Aishopssh.Entites.AdminReply;
import com.Aishopssh.Entites.Leaveword;
import java.util.List;

/**
 * @author Maredb
 * @date 2019-12-23 - 10:43
 */
public interface LeaveWordImp {
    /**
     * 根据用户id获取用户留言
     * @param id 用户id
     * @return 留言列表
     */
    public List<Leaveword> GetAllLeaveWordByUid(int id);

    /**
     * 根据留言id获取用户留言
     * @param id 留言id
     * @return 留言列表
     */
    public Leaveword getLeaveWordByLid(int id);

    /**
     * 根据留言id获取回复信息
     * @param id 留言id
     * @return 回复信息
     */
    public AdminReply getReplyById(int id);

}
