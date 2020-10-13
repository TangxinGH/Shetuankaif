package kunpeng.controller;

import entity.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.ActivityService;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @RequestMapping("/query/activity")
    @ResponseBody
    public List<Activity> findAll() { //return userService.findAll();
        List<Activity> activities = activityService.findAll();
        return activities;
    }
    @RequestMapping("/queryactivity")
    @ResponseBody
    public List<String>getAllActivitiesTitles() { //return userService.findAll();
        List<String> allActivitiesTitles = activityService.getAllActivitiesTitles();
        return allActivitiesTitles;
    }

}
