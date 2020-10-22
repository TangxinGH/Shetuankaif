package kunpeng.controller;

import POJO.Iml.Usertest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Activity;
import entity.Notice;
import entity.User;
import kunpeng.bean.CodeMsg;
import kunpeng.bean.Result;
import kunpeng.until.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.ActivityService;
import service.NoticeService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController  {

    @Autowired
    private UserService userService;
    @Autowired
    private ActivityService activityService;
    @Autowired
    private NoticeService noticeService;

    @RequestMapping(value="/index",method=RequestMethod.GET)
    public  Map<String, Object> index(){
        Map<String,Object> map=new HashMap<String,Object>();
        try{
            List<Activity> allActivities = activityService.getAllActivities();
            List<Notice> allNotices = noticeService.getAllNotices();
            map.put("Activities",allActivities);
            map.put("Notices", allNotices);
            return map;
        }catch (Exception e){
            map.put("code",CodeMsg.Unknown_ERROR);
            return map;
        }

    }

     @RequestMapping (value = "/login", method = RequestMethod.POST)
     @ResponseBody
     public Map<String, Object>  login(@RequestParam String Sno, @RequestParam String Password) {
         Map<String,Object> map=new HashMap<String,Object>();
         String password = DigestUtils.md5DigestAsHex(Password.getBytes());
         System.out.println("username:" + Sno + ", password:" +Password);
         User user =userService.findBySno(Sno);
         if (user == null) {
             map.put("code",CodeMsg.USER_NAME_NO_EXIST);
            return map;
        } else if (user.getPassword().equals(password)){
             map.put("code",CodeMsg.LOGIN_SUCCESS);
             map.put("user",user);
             return  map;
        }else {
             map.put("code",CodeMsg.USER_PASSWORD_ERROR);
            return map;
        }
       /*if(user !=null) {
           return "20";
       }else {
           return "21";
       }*/
     }

     @RequestMapping(value = "/register",method = RequestMethod.POST)
     public Result<Boolean>  Register(@RequestBody User user) {

             if(user == null){
               return Result.error(CodeMsg.USER_INFO_EMPTY);
             }
       /*  if(StringUtils.isEmpty(user.getSno())){

             return Result.error(CodeMsg.User_SNO_EMPTY);
         }
         if(StringUtils.isEmpty(user.getSname())){

             return Result.error(CodeMsg.USER_USERNAME_EMPTY);
         }
		if(StringUtils.isEmpty(user.getPassword())){

            return Result.error(CodeMsg.USER_PASSWORD_EMPTY);

	}if(StringUtils.isEmpty(user.getScollege())){

             return Result.error(CodeMsg.User_SCOLLEGE_EMPTY);

         }if(StringUtils.isEmpty(user.getSex())){

             return Result.error(CodeMsg.User_SEX_EMPTY);
         }
         if(StringUtils.isEmpty(user.getAge())){

             return Result.error(CodeMsg.User_AGE_EMPTY);
         }*/
         String s = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
         user.setPassword(s);
         if(isExist(user.getSno())){

             return Result.error(CodeMsg.USER_SNO_IS_EXIST);
         }
         if(userService.register(user) <= 0){

             return Result.error(CodeMsg.Unknown_ERROR);
         }

         return Result.success(CodeMsg.REGISTER_SUCCESS);


//         Usertest usertest;
//         ObjectMapper objectMapper=new ObjectMapper();
//         try {
//              usertest=objectMapper.readValue(sj,Usertest.class);  // 可以用第三方的进行调试
//         } catch (JsonProcessingException e) {
//             e.printStackTrace();
//         }

/*  user 有改动 ，你改回去就行。
java 转 kotlin 时会自动小写。
增加了jackjson 用于调试而已
如果有办法开户 spring内置的json debug信息 抛出 则不用第三方的也行
*
*
* *///         System.out.println(user.getSex());
        /* int register = 1;*/
    /* if (register==1) {

             return "30";
         } else {
             return "32";
         }*/
     }
    @RequestMapping("/edit")
    @ResponseBody
    public Result<Boolean> Update(@RequestBody User user) {
          if (user==null){
            return Result.error(CodeMsg.Unknown_ERROR);
        }
        try {
            int affected = userService.updateUser(user);
            if (affected >=1){
                return Result.success(CodeMsg.UPDATE_USER_SUCCESS);
            }
            else {
                return Result.error(CodeMsg.UPDATE_USER_ERROR);
            }
        }
        catch (Exception e){
            return Result.error(CodeMsg.Unknown_ERROR);
        }
    }
    @RequestMapping(value = "/userinfo",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> check(@RequestParam String sno) {
      Map<String,Object> map=new HashMap<String,Object>();
      try{
        User user = userService.findBySno(sno);
      map.put("code",CodeMsg.USER_INFO);
      map.put("userinfo",user);
      return map;}catch (Exception e){
          map.put("code",CodeMsg.Unknown_ERROR);
          return map;
      }
    }


    @RequestMapping("/getUsers")
    @ResponseBody
    public Map<String, Object> findAllUser(){ //return userService.findAll();
        Map<String,Object> map=new HashMap<String,Object>();
        try{
        List<User> user = userService.findAllUser();
        map.put("code",CodeMsg.USERS_INFO);
        map.put("userinfo",user);
        return map;}catch (Exception e){
            map.put("code",CodeMsg.Unknown_ERROR);
            return map;
        }
    }

    @RequestMapping("/getMembers")
    @ResponseBody
    public Map<String, Object> findtMembers(){ //return userService.findAll();
        Map<String,Object> map=new HashMap<String,Object>();
        try{
        List<User> members = userService.findMembers();
        map.put("code",CodeMsg.MEMBERS_INFO);
        map.put("memberInfo",members);
        return map;
        } catch (Exception e){
            map.put("code",CodeMsg.Unknown_ERROR);
           return map;
        }
    }

    @RequestMapping(value = "/delUser",method = RequestMethod.DELETE)
    @ResponseBody
    public Result<Boolean> DeleteUser(String sno){
        if (sno==null){
            return Result.error(CodeMsg.Unknown_ERROR);
        }
        try {
            int affected = userService.deleteUser(sno);
            if (affected >=1){
                return Result.success(CodeMsg.DELETE_USER_SUCCESS);
            }
            else {
                return Result.error(CodeMsg.DELETE_USER_ERROR);
            }
        }
        catch (Exception e){
            return Result.error(CodeMsg.Unknown_ERROR);
        }

      }

    @RequestMapping(value = "/joinCommunity",method = RequestMethod.GET)
    @ResponseBody
    public Result<Boolean> joinCommunity( @RequestParam String sno){
        if (sno==null){
            return Result.error(CodeMsg.Unknown_ERROR);
        }
        try {
            int affected = userService.joinCommunity(sno);
            if (affected >=1){
                return Result.success(CodeMsg.joinCommunity_SUCCESS);
            }
            else {
                return Result.error(CodeMsg.joinCommunity_EORROR);
            }
        }
        catch (Exception e){
            return Result.error(CodeMsg.Unknown_ERROR);
        }

    }
    @RequestMapping(value = "/rejectJoin",method = RequestMethod.DELETE)
    @ResponseBody
    public Result<Boolean> rejectJoin( @RequestParam String sno){
        if (sno==null){
            return Result.error(CodeMsg.Unknown_ERROR);
        }
        try {
            int affected = userService.rejectJoin(sno);
            if (affected >=1){
                return Result.success(CodeMsg.rejectJoin_SUCCESS);
            }
            else {
                return Result.error(CodeMsg.rejectJoin_ERROR);
            }
        }
        catch (Exception e){
            return Result.error(CodeMsg.Unknown_ERROR);
        }

    }
    @RequestMapping(value = "/acceptJoin",method = RequestMethod.DELETE)
    @ResponseBody
    public Result<Boolean> acceptJoin( @RequestParam String sno){
        if (sno==null){
            return Result.error(CodeMsg.Unknown_ERROR);
        }
        try {
            int affected = userService.acceptJoin(sno);
            if (affected >=1){
                return Result.success(CodeMsg.acceptJoin_SUCCESS);
            }
            else {
                return Result.error(CodeMsg. acceptJoin_ERROR);
            }
        }
        catch (Exception e){
            return Result.error(CodeMsg.Unknown_ERROR);
        }

    }


    private boolean isExist(String sno){
        User user = userService.findBySno(sno);
        if(user == null)return false;
        return true;
    }

}
