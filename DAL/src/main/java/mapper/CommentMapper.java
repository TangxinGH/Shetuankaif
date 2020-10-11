package mapper;

import entity.Comment;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CommentMapper {
    List<String> getAllCommentTitles();
    List<Comment> getAllComments();
    Comment getCommentByCommentTitle(String Title);
    int addAComment(Comment Comment);
    int deleteACommentByTitle(String Title);
    int updateACommentByTitle(Comment Comment);
}
