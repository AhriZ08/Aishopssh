package com.Aishopssh.Imp.GoodsImp;

import com.Aishopssh.Entites.Comments;

import java.util.List;

public interface GoodsCommentsImp {
    /**
     * 获取指定商品评论
     * @param id 指定商品id
     * @return 评论列表
     */
    public List<Comments> GetAllCommentBySpId(int id);
}
