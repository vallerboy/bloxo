package pl.oskarpolak.bloxo.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.oskarpolak.bloxo.models.PostEntity;
import pl.oskarpolak.bloxo.models.UserEntity;
import pl.oskarpolak.bloxo.models.forms.PostForm;
import pl.oskarpolak.bloxo.models.repositories.PostRepository;

@Service
public class PostService {

    final SessionService sessionService;
    final PostRepository postRepository;

    @Autowired
    public PostService(SessionService sessionService, PostRepository postRepository) {
        this.sessionService = sessionService;
        this.postRepository = postRepository;
    }

    public void addPost(PostForm postForm){
        PostEntity postEntity = createEntityFromForm(postForm);
        postRepository.save(postEntity);
    }

    private PostEntity createEntityFromForm(PostForm postForm) {
        PostEntity postEntity = new PostEntity();
        postEntity.setContext(postForm.getContext());
        postEntity.setTitle(postForm.getTitle());
        postEntity.setUser(sessionService.getUserEntity());
        return postEntity;
    }

    public Iterable<PostEntity> getAllPosts(){
        return postRepository.findAll();
    }
}
