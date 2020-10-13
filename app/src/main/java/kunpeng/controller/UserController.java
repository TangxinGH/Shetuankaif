package kunpeng.controller;

import POJO.Iml.Usertest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.User;
import kunpeng.bean.CodeMsg;
import kunpeng.bean.Result;
import kunpeng.until.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController  {

    @Autowired
    private UserService userService;

      @RequestMapping("/toIndex")
     public String show() {
         return "index";
     }

     @RequestMapping (value = "/login", method = RequestMethod.POST)
     @ResponseBody
     public Result<Boolean>  login(@RequestParam String Sno, @RequestParam String Password) {

         System.out.println("username:" + Sno + ", password:" +Password);
         User user = userService.login(Sno, Password);
        if (user == null) {

            return Result.error(CodeMsg.DATA_ERROR);
        } else if (StringUtils.isEmpty(user.getSname())){
            return Result.error(CodeMsg.USERNAME_NO_EXIST);

        }else if (StringUtils.isEmpty(user.getPassword())){
            return Result.error(CodeMsg.USER_PASSWORD_ERROR);
        }else
        {
            return  Result.success(true);
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
            int affected = userService.update(user);
            if (affected >=1){
                return Result.success(CodeMsg.UPDATE_USER_SUCCESS);
            }
            else {
                return Result.error(CodeMsg.UPDATE_USER_EORROR);
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
        User user = userService.findBySno(sno);
      map.put("code",CodeMsg.USER_INFO);
      map.put("userinfo",user);
      return map;
    }
    @RequestMapping("/findAll")
    @ResponseBody
    public List<User> findAll(){ //return userService.findAll();
        return   userService.findAll();

    }

    @RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
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
                return Result.error(CodeMsg.DELETE_USER_EORROR);
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
