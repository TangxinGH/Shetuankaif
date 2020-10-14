package mapper;

import entity.Activity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActivityMapper {
   List<String> getAllActivityTitles();
   List<Activity> getAllActivities();
   Activity getActivityByActivityTitle(String Title);
   int addAnActivity(Activity activity);
   int deleteAnActivityByID(Integer ID);
   int updateAnActivityByID(Activity activity);
}
