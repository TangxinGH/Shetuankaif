package service;

import entity.Notice;
import mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    public int addANotice(Notice notice){
        //return 0;
        return noticeMapper.addANotice(notice);
    }

    public int deleteNoticeByTitle(String title){
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

    public int updateNoticeByTitle(Notice notice){
        return noticeMapper.updateANoticeByTitle(notice);
    }

}
