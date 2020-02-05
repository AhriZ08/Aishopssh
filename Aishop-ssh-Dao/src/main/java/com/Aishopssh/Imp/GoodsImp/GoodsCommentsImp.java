package com.Aishopssh.Imp.GoodsImp;

import com.Aishopssh.Entites.Comments;

import java.util.List;

public interface GoodsCommentsImp {
    /**
     * 获取指定商品评论，并分页
     * @param gid,curr 指定商品id
     * @return 评论列表
     */
    public List<Comments> GetAllCommentBySpId(int gid, int curr);
    public int addComments(int uid, int gid, String Title, String Content, String currDate);
}
