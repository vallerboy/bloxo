package pl.oskarpolak.bloxo.models.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.oskarpolak.bloxo.models.CommentEntity;
import pl.oskarpolak.bloxo.models.PostEntity;
import pl.oskarpolak.bloxo.models.UserEntity;
import pl.oskarpolak.bloxo.models.forms.CommentForm;
import pl.oskarpolak.bloxo.models.repositories.CommentRepository;

@Service
public class CommentService {
    final CommentRepository commentRepository;
    final SessionService sessionService;

    @Autowired
    public CommentService(CommentRepository commentRepository, SessionService sessionService) {
        this.commentRepository = commentRepository;
        this.sessionService = sessionService;
    }

    public void addComment(CommentForm commentForm, int postId){
        CommentEntity commentEntity = createCommentEntity(commentForm, postId);
        commentRepository.save(commentEntity);
    }

    private CommentEntity createCommentEntity(CommentForm commentForm, int postId) {
        CommentEntity commentEntity = new CommentEntity();
        PostEntity postEntity = new PostEntity();
        UserEntity userEntity = new UserEntity();

        postEntity.setId(postId);
        userEntity.setId(sessionService.getUserEntity().getId());

        commentEntity.setContext(commentForm.getContext());
        commentEntity.setPost(postEntity);
        commentEntity.setUser(userEntity);
        return commentEntity;
    }


}
