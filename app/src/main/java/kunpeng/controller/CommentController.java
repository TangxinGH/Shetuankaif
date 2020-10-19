package kunpeng.controller;

import entity.User;
import kunpeng.bean.CodeMsg;
import kunpeng.bean.Result;
import kunpeng.until.RegexUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
//import org.w3c.dom.Comment;
import service.CommentService;
import entity.Comment;
import java.util.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentService commentService;
    //private static final String IDRegex = "[1-9]\\d*";

    @RequestMapping(value = "/addComment", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> addAComment(@RequestBody Comment comment){//添加评论
        try {
            comment.setCmtDate(new Date());
            commentService.addAComment(comment);
            System.out.println("插入成功！");
        }
        catch (Exception e){
            if (e instanceof DataIntegrityViolationException){//外键出现问题，证明用户/活动不在对应数据库
                throw e;
            }

            else {
                return Result.error(CodeMsg.HOME_STUDENT_COMMENT_ADD_ERROR);
            }
        }
        return Result.success(CodeMsg.ADD_COMMENT_SUCCESSFULLY);
    }

    @RequestMapping(value = "/getComments",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getAllCommentsOfAnActivity(@RequestParam String actID){//获取单个活动的全部评论
        Map<String,Object> resultMap = new HashMap<>();
        if(!actID.matches(RegexUtil.IDRegex)){
            resultMap.put("code",CodeMsg.BAD_ACTIVITYID_FORMAT);
            resultMap.put("comments",null);
            return resultMap;
        }
        try {
            List<Comment> comments = commentService.getCommentByActivityID(Integer.valueOf(actID));
            resultMap.put("code",CodeMsg.GET_COMMENTS_SUCCESSFULLY);
            resultMap.put("comments",comments);
            return resultMap;
        }
        catch (Exception e){
            resultMap.put("code",CodeMsg.UNKNOWN_ERROR);
            resultMap.put("comments",null);
            return resultMap;
        }
    }


    @RequestMapping(value = "/DelComment",method = RequestMethod.GET)
    @ResponseBody
    public Result<Boolean> DeleteAComment(@RequestParam String commentID){//删除评论
        if (!commentID.matches(RegexUtil.IDRegex)){
            return Result.error(CodeMsg.BAD_ACTIVITYID_FORMAT);
        }
        try {
            int affected = commentService.deleteACommentByCommentID(Integer.parseInt(commentID));
            if (affected >= 1){
                return Result.success(CodeMsg.DELETE_COMMENT_SUCCESSFULLY);
            }
            else {
                return Result.error(CodeMsg.DELETE_COMMENT_ERROR);
            }
        }
        catch (Exception e){
            return Result.error(CodeMsg.UNKNOWN_ERROR);
        }

    }

    @RequestMapping(value = "/getAllComments",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getAllComments(){//获取单个活动的全部评论
        Map<String,Object> resultMap = new HashMap<>();
        try {
            List<Comment> comments = commentService.getAllComments();
            resultMap.put("code", comments.size() == 0 ? Result.success(CodeMsg.GET_COMMENTS_EMPTY) : Result.success(CodeMsg.GET_COMMENTS_SUCCESSFULLY));
            resultMap.put("comments",comments);
            return resultMap;
        }
        catch (Exception e){
            resultMap.put("code",Result.error(CodeMsg.GET_COMMENTS_FAILED));
            resultMap.put("comments",null);
            return resultMap;
        }
    }

}

