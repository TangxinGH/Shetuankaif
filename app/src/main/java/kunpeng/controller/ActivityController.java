/*
package kunpeng.controller;

import entity.Activity;
import kunpeng.bean.CodeMsg;
import kunpeng.bean.Result;
import kunpeng.until.RegexUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
    @ResponseBody
    public Result<Boolean> addActivity(@RequestBody Activity activity){
        return activityService.addAnActivity(activity) > 0 ? Result.success(CodeMsg.ADD_ACTIVITY_SUCCESSFULLY) : Result.error(CodeMsg.ADD_ACTIVITY_FAILED);
    }

    @RequestMapping(value = "/deleteAcivityByID" ,method = RequestMethod.GET)
    @ResponseBody
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
    @ResponseBody
    public Result<Boolean> updateAnActivity(Activity activity){
        activity.setAct_Publish_Time(new Date());
        return activityService.updateActivityByID(activity) > 0 ? Result.success(CodeMsg.UPDATE_ACTIVITY_SUCCESSFULLY) : Result.error(CodeMsg.UPDATE_ACTIVITY_FAILED);
    }

    @RequestMapping (value = "/findAllActivities")
    @ResponseBody
    public Map<String,Object> getAllActivities(){
        Map<String,Object> resultMap = new HashMap<>();
        try{
            List<Activity> notices = activityService.getAllActivities();
            resultMap.put("resultCode", notices.size() > 0 ? Result.success(CodeMsg.QUERY_ACTIVITY_SUCCESSFULLY) : Result.error(CodeMsg.QUERY_ACTIVITY_NOT_EXIST));
            resultMap.put("notices",notices);
        }
        catch (Exception e){
            resultMap.put("resultCode", CodeMsg.UNKNOWN_ERROR);
            resultMap.put("notices",null);
        }
        return resultMap;
    }
    @RequestMapping("/queryactivity")
    @ResponseBody
    public List<String>getAllActivitiesTitles() { //return userService.findAll();
        List<String> allActivitiesTitles = activityService.getAllActivitiesTitles();
        return allActivitiesTitles;
    }

}
*/
