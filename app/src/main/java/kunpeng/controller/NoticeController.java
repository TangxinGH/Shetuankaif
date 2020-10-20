package kunpeng.controller;

import entity.Notice;
import kunpeng.bean.CodeMsg;
import kunpeng.bean.Result;
import kunpeng.until.RegexUtil;
import org.omg.CORBA.UNKNOWN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;
import service.NoticeService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;


    @RequestMapping(value = "/publishANotice",method = RequestMethod.POST)
    public Result<Boolean> addANotice(@RequestBody Notice notice){
        //noticeService.addANotice(notice);
        /*try {
            noticeService.addANotice(notice);
        }
        catch (Exception e){
            return Result.error(CodeMsg.ADD_NOTICE_FAILED);
        }
        return noticeService.addANotice(notice) > 0 ? Result.success(CodeMsg.ADD_NOTICE_SUCCESSFULLY) : Result.error(CodeMsg.ADD_NOTICE_FAILED);
    */
        int affected;
        try {
            affected = noticeService.addANotice(notice);
        }
        catch (Exception e){
            if (e instanceof DataIntegrityViolationException){
                throw e;
            }
            else {
                return Result.error(CodeMsg.UNKNOWN_ERROR);
            }
        }
        return affected > 0 ? Result.success(CodeMsg.ADD_NOTICE_SUCCESSFULLY) : Result.error(CodeMsg.ADD_NOTICE_FAILED);
    }


    @RequestMapping(value = "/getNoticebyID")
    public Notice getAllNoticesTitles(@RequestParam String ntID){//获取公告
        return noticeService.getNoticeByID(Integer.parseInt(ntID));
    }

    @RequestMapping(value = "/delNotice")
    public Result<Boolean> deleteANotice(@RequestParam String ntID){
        int affected;
        try {
            affected = noticeService.deleteNoticeByID(Integer.parseInt(ntID));
        }
        catch (Exception e){
            return Result.error(CodeMsg.UNKNOWN_ERROR);
        }
        return affected > 0 ? Result.success(CodeMsg.DELETE_NOTICE_SUCCESSFULLY) : Result.error(CodeMsg.DELETE_NOTICE_FAILED);
    }

    @RequestMapping(value = "/updateANotice",method = RequestMethod.POST)
    public Result<Boolean> updateANotice(@RequestBody Notice notice){
        int affected;
        try {
            notice.setNtPublishTime(new Date());
            affected = noticeService.updateNoticeByID(notice);
        }
        catch (Exception e){
            return Result.error(CodeMsg.UNKNOWN_ERROR);
        }
        return affected > 0 ? Result.success(CodeMsg.UPDATE_NOTICE_SUCCESSFULLY) : Result.error(CodeMsg.UPDATE_NOTICE_FAILED);

        /*notice.setNtPublishTime(new Date());
        return noticeService.updateNoticeByID(notice) > 0 ? Result.success(CodeMsg.UPDATE_NOTICE_SUCCESSFULLY) : Result.error(CodeMsg.UPDATE_NOTICE_FAILED);
    */
    }

    @RequestMapping(value = "/getNotices")
    public Map<String,Object> getAllNotices(){
        Map<String,Object> resultMap = new HashMap<>();
        try{
            List<Notice> notices = noticeService.getAllNotices();
            resultMap.put("code", notices.size() > 0 ? Result.success(CodeMsg.QUERY_NOTICE_SUCCESSFULLY).getCode() : Result.error(CodeMsg.QUERY_NOTICE_NOT_EXIST).getCode());
            resultMap.put("notices",notices);
        }
        catch (Exception e){
            resultMap.put("code", CodeMsg.UNKNOWN_ERROR.getCode());
            resultMap.put("notices",null);
        }
        return resultMap;
    }

}
