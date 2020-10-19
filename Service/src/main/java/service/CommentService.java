package service;

import entity.Comment;
import mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class CommentService {

    @Autowired
    CommentMapper commentMapper;

    public int addAComment(Comment comment){
        //return 0;
        return commentMapper.addAComment(comment);
    }

    public int deleteACommentBySno(Integer cmtID){
        return commentMapper.deleteACommentBySno(cmtID);
    }

    public int deleteACommentByCommentID(Integer cmtID){
        return commentMapper.deleteACommentByCommentID(cmtID);
    }

    public List<Comment> getAllComments(){
        return commentMapper.getAllComments();
    }

    public List<Comment> getCommentBySno(Integer sno){
        return commentMapper.getCommentBySno(sno);
    }


    public List<Comment> getCommentByActivityID(Integer actID){
        return commentMapper.getCommentByActivityID(actID);
    }

    public int updateACommentBySno(Comment comment){
        return commentMapper.updateACommentBySno(comment);
    }

}
