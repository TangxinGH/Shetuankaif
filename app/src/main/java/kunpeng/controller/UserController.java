package kunpeng.controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;

public class UserController  {

    @Autowired
    private UserService userService;

    @RequestMapping("/toIndex")
    public String show() {
        return "index";
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestParam String username, @RequestParam String password) {
        System.out.println("username:" + username + ", password:" + password);
        //User user = userService.login(username, password);
        User user = new User();
        if (user != null) {

            return "loginsucess";
        } else {
            return "loginError";
        }
    }
}
