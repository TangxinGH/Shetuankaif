package kunpeng.controller;

import entity.Admin;
import entity.User;
import kunpeng.bean.CodeMsg;
import kunpeng.bean.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import service.AdminService;
import service.UserService;

@RestController
@RequestMapping("/api")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/toIndex")
    public String show() {
        return "index";
    }

    @RequestMapping(value = "/loginAdmin", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> login(@RequestParam String adName, @RequestParam String adPassword) {

        Admin admin = adminService.adminLogin(adName, adPassword);
        if (admin == null) {

            return Result.error(CodeMsg.DATA_ERROR);
        } else if (StringUtils.isEmpty(admin.getAdName())) {
            return Result.error(CodeMsg.USERNAME_NO_EXIST);

        } else if (StringUtils.isEmpty(admin.getAdPassword())) {
            return Result.error(CodeMsg.USER_PASSWORD_ERROR);
        } else {
            return Result.success(true);
        }

    }
/*    @RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> addAComment(@RequestParam String sno, @RequestParam String sname, @RequestParam String commentContent, @RequestParam String actID){
        if(!sno.matches(IDRegex)){
            return Result.error(CodeMsg.HOME_WRONG_STUDENT_NUMBER_FORMAT);
        }
        else if (sname.isEmpty()){
            return Result.error(CodeMsg.USERNAME_NO_EXIST);
        }
        else if (!actID.matches(IDRegex)){
            return Result.error(CodeMsg.BAD_ACTIVITYID_FORMAT);
        }
        else if (commentContent.equals("") || commentContent.isEmpty()){
            return Result.error(CodeMsg.HOME_STUDENT_COMMENT_CONTENT_EMPTY);
        }
        System.out.println("Adding a comment");
        Comment comment = new Comment();
        comment.setCmt_Sname(sname);
        comment.setCmt_Date(new Date());
        comment.setCmt_Content(commentContent);
        comment.setSno(Integer.valueOf(sno));
        comment.setActID(Integer.valueOf(actID));
        try {
            commentService.addAComment(comment);
            System.out.println("插入成功！");
        }
        catch (Exception e){
            if (e instanceof DataIntegrityViolationException){//外键出现问题，证明用户/活动不在对应数据库
                return Result.error(CodeMsg.DATA_ERROR);
            }

            else {
                return Result.error(CodeMsg.HOME_STUDENT_COMMENT_ADD_ERROR);
            }
        }
        return Result.success(CodeMsg.ADD_COMMENT_SUCCESSFULLY);
    }*/

    /*@RequestMapping(value = "/getComments",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getAllCommentsOfAnActivity(@RequestParam String actID){
        Map<String,Object> resultMap = new HashMap<>();
        if(!actID.matches(IDRegex)){
            resultMap.put("resultCode",CodeMsg.BAD_ACTIVITYID_FORMAT);
            resultMap.put("comments",null);
            return resultMap;
        }
        try {
            List<Comment> comments = commentService.getCommentByActivityID(Integer.valueOf(actID));
            resultMap.put("resultCode",CodeMsg.GET_COMMENTS_SUCCESSFULLY);
            resultMap.put("comments",comments);
            return resultMap;
        }
        catch (Exception e){
            resultMap.put("resultCode",CodeMsg.UNKNOWN_ERROR);
            resultMap.put("comments",null);
            return resultMap;
        }
    }


    @RequestMapping(value = "/DelComment",method = RequestMethod.GET)
    @ResponseBody
    public Result<Boolean> DeleteAComment(String commentID){
        if (!commentID.matches(IDRegex)){
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
        }*/



    }
