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

import java.util.List;
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
         Integer Sn = Integer.valueOf(Sno);
        // int i = Integer.parseInt(Sno);
         System.out.println("username:" + Sn + ", password:" +Password);
         User user = userService.login(Sn, Password);
        if (user == null) {

            return Result.error(CodeMsg.DATA_ERROR);
        } else if (StringUtils.isEmpty(user.getSname())){
            return Result.error(CodeMsg.USERNAME_NO_EXIST);

        }else if (StringUtils.isEmpty(user.getPassword())){
            return Result.error(CodeMsg.User_PASSWORD_ERROR);
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
     public String Register(@RequestBody Usertest uste) {
         System.out.println("xx");
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
         int register = 1;
         if (register==1) {

             return "30";
         } else {
             return "32";
         }
     }
     @RequestMapping("/updateUser")
     @ResponseBody
     public String Update(@RequestBody User user) {

         int register = userService.register(user);
         if (register==1) {

             return "loginsucess";
         } else {
             return "loginError";
         }
     }
     @RequestMapping("/user/{id}")
     @ResponseBody
     public User check(@PathVariable Integer id) {

         User user = userService.findById(id);
       return user;
     }
    @RequestMapping("/findAll")
    @ResponseBody
    public List<User> findAll(){ //return userService.findAll();
        return   userService.findAll();

    }

}
