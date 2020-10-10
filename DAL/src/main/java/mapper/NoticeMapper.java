package mapper;

import entity.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Component
public interface NoticeMapper {
   List<String> getAllNoticeTitles();
   List<Notice> getAllNotices();
   Notice getNoticeByNoticeTitle(String Title);
   int addANotice(Notice notice);
   int deleteANoticeByTitle(String Title);
   int updateANoticeByTitle(Notice notice);
}
