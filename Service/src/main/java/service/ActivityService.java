package service;

import entity.Activity;
import mapper.ActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component
public class ActivityService {

    @Autowired
    ActivityMapper activityMapper;

    public int addAnActivity(Activity activity){
        //return 0;
        return activityMapper.addAnActivity(activity);
    }

    public int deleteActivityByID(Integer actID){
        return activityMapper.deleteAnActivityByID(actID);
    }

    public Activity getActivityByID(Integer actID){
        return activityMapper.getActivityByActivityID(actID);
    }

    public List<Activity> getAllActivities(){
        return activityMapper.getAllActivities();
    }

    public List<String> getAllActivitiesTitles(){
        return activityMapper.getAllActivityTitles();
    }

    public int updateActivityByID(Activity activity){
        return activityMapper.updateAnActivityByID(activity);
    }

}
