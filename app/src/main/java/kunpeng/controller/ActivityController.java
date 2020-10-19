
package kunpeng.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Activity;
import kunpeng.bean.CodeMsg;
import kunpeng.bean.Result;
import kunpeng.until.RegexUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedCheckedException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;
import service.ActivityService;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")

public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @RequestMapping(value = "/addAnActivity",method = RequestMethod.POST)
    public Result<Boolean> addActivity(@RequestBody Activity activity){
        int affected;
        try{
            affected = activityService.addAnActivity(activity);
        }
        catch (Exception e){
            if (e instanceof DataIntegrityViolationException)
                throw e;
            else {
                return Result.error(CodeMsg.UNKNOWN_ERROR);
            }
        }
        return affected > 0 ? Result.success(CodeMsg.ADD_ACTIVITY_SUCCESSFULLY) : Result.error(CodeMsg.ADD_ACTIVITY_FAILED);
    }

    @RequestMapping(value = "/deleteAcivityByID" ,method = RequestMethod.GET)
    public Result<Boolean> deleteAnActivityByID(@RequestParam String actID){
        if (!actID.matches(RegexUtil.IDRegex)){
            return Result.error(CodeMsg.BAD_ACTIVITYID_FORMAT);
        }
        int affected;
        try {
            affected = activityService.deleteActivityByID(Integer.parseInt(actID));
        }
        catch (Exception e){
            if (e instanceof DataIntegrityViolationException){
                throw e;
            }
            else {
                return Result.error(CodeMsg.UNKNOWN_ERROR);
            }
        }
        return affected > 0 ? Result.success(CodeMsg.DELETE_ACTIVITY_SUCCESSFULLY) : Result.error(CodeMsg.DELETE_ACTIVITY_FAILED);
    }

    @RequestMapping (value = "/updateAnActivity",method = RequestMethod.POST)
    public Result<Boolean> updateAnActivity(@RequestBody Activity activity){
        /*System.out.println(s);
        Activity activity = new Activity();
        ObjectMapper objectMapper=new ObjectMapper();
         try {
              activity = objectMapper.readValue(s, Activity.class);// 可以用第三方的进行调试
         } catch (JsonProcessingException e) {
             e.printStackTrace();
         }
         return activity.toString();*/
        int affected;
        activity.setActPublishTime(new Date());
        try{
            affected = activityService.updateActivityByID(activity);
        }
        catch (Exception e){
            if (e instanceof DataIntegrityViolationException)
                throw e;
            else {
                return Result.error(CodeMsg.UNKNOWN_ERROR);
            }
        }
        return affected > 0 ? Result.success(CodeMsg.UPDATE_ACTIVITY_SUCCESSFULLY) : Result.error(CodeMsg.UPDATE_ACTIVITY_FAILED);
    }

    @RequestMapping ("/findAllActivities")
    public Map<String,Object> getAllActivities(){
        Map<String,Object> resultMap = new HashMap<>();
        try{
            List<Activity> activities = activityService.getAllActivities();
            resultMap.put("code", activities.size() > 0 ? Result.success(CodeMsg.QUERY_ACTIVITY_SUCCESSFULLY).getCode() : Result.error(CodeMsg.QUERY_ACTIVITY_NOT_EXIST).getCode());
            resultMap.put("activities",activities);
        }
        catch (Exception e){
            resultMap.put("code", CodeMsg.UNKNOWN_ERROR.getCode());
            resultMap.put("notices",null);
            throw e;
        }
        return resultMap;
    }
    @RequestMapping("/queryactivity")
    @ResponseBody
    public List<String>getAllActivitiesTitles() { //return userService.findAll();
        List<String> allActivitiesTitles = activityService.getAllActivitiesTitles();
        return allActivitiesTitles;
    }

    @RequestMapping ("/getActivitybyID")
    public Activity getActivityByID(@RequestParam String actID){
        return activityService.getActivityByID(Integer.parseInt(actID));
    }
}

