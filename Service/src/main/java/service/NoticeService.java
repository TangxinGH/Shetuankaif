package service;

import entity.Notice;
import mapper.NoticeMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class NoticeService {

    @Autowired
    NoticeMapper noticeMapper;

    public int addANotice(Notice notice){
        //return 0;
        return noticeMapper.addANotice(notice);
    }

    public int deleteNoticeByID(Integer title){
        return noticeMapper.deleteANoticeByTitle(title);
    }

    public Notice getNoticeByTitle(String title){
        return noticeMapper.getNoticeByNoticeTitle(title);
    }

    public List<Notice> getAllNotices(){
        return noticeMapper.getAllNotices();
    }

    public List<String> getAllNoticesTitles(){
        return noticeMapper.getAllNoticeTitles();
    }

    public int updateNoticeByID(Notice notice){
        return noticeMapper.updateANoticeByTitle(notice);
    }

}
