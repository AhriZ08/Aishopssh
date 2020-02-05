package com.Aishop.Action.GoodsAction.GoodsComments;

import com.Aishopssh.Entites.Comments;
import com.Aishopssh.Imp.GoodsServiceImp;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Scope("prototype")
public class getAllComments extends ActionSupport {
    private int id;
    private int curr;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCurr() {
        return curr;
    }

    public void setCurr(int curr) {
        this.curr = curr;
    }

    private List<Comments> commentsList;

    public List<Comments> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comments> commentsList) {
        this.commentsList = commentsList;
    }

    @Autowired
    @Qualifier("GoodsService")
    GoodsServiceImp goodsService;
    @Override
    public String execute() throws Exception {
        commentsList = goodsService.getAllComments(id, curr);
        return null;
    }
}
