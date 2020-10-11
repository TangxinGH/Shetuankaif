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

    public int deleteCommentByTitle(String title){
        return commentMapper.deleteACommentByTitle(title);
    }

    public Comment getCommentByTitle(String title){
        return commentMapper.getCommentByCommentTitle(title);
    }

    public List<Comment> getAllComments(){
        return commentMapper.getAllComments();
    }

    public List<String> getAllCommentsTitles(){
        return commentMapper.getAllCommentTitles();
    }

    public int updateCommentByTitle(Comment comment){
        return commentMapper.updateACommentByTitle(comment);
    }

}
