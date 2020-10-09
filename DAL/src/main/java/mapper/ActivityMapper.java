package mapper;

import entity.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActivityMapper {
   List<String> getAllActivityTitles();
   List<Notice> getAllActivities();
   Notice getNoticeByActivityTitle(String Title);
   int addAnActivity(Notice notice);
   int deleteAnActivityByTitle(String Title);
   int updateAnActivityByTitle(String Title);
}
