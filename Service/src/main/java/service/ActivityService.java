package service;

import entity.Activity;
import mapper.ActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component
public class ActivityService {
    
    @Autowired
    private ActivityMapper activityMapper;
    public int addAnActivity(Activity activity){
        //return 0;
        return activityMapper.addAnActivity(activity);
    }

    public int deleteActivityByTitle(String title){
        return activityMapper.deleteAnActivityByTitle(title);
    }

    public Activity getActivityByTitle(String title){
        return activityMapper.getActivityByActivityTitle(title);
    }

    public List<Activity> getAllActivities(){
        return activityMapper.getAllActivities();
    }

    public List<String> getAllActivitiesTitles(){
        return activityMapper.getAllActivityTitles();
    }

    public int updateActivityByTitle(Activity activity){
        return activityMapper.updateAnActivityByTitle(activity);
    }
    
}
