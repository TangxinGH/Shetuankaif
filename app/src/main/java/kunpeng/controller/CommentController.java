package kunpeng.controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.w3c.dom.Comment;
import service.CommentService;
import entity.Comment;

import java.util.Date;
import java.sql.SQLException;

@Controller
public class CommentController {

    @Autowired
    CommentService commentService;

    @RequestMapping("/addComment")
    @ResponseBody
    public Integer addAComment(@RequestParam String sno,@RequestParam String sName,@RequestParam String commentContent,@RequestParam String actID){
        //return "42";
        Integer code = 0;
        System.out.println("Adding a comment");
        Comment comment = new Comment();
        //comment.setCmt_Sname(user.getSname());
        //comment.setSno(user.getSno());
        comment.setCmt_Sname(sName);
        comment.setCmt_Date(new Date());
        comment.setCmt_Content(commentContent);
        try {
            comment.setSno(Integer.parseInt(sno));
            comment.setActID(Integer.parseInt(actID));
            commentService.addAComment(comment);
            code = 40;
            System.out.println("插入成功！");
        }
        catch (Exception e){
            if (e instanceof DataIntegrityViolationException || e instanceof ArithmeticException){
                code = 41;
            }
            else {
                code = 42;
            }
        }
        return code; //不知道返回什么
    }

}
