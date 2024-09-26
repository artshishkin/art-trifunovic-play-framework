package service;

import form.PostForm;
import jakarta.inject.Inject;
import model.Post;
import model.PostRepository;

import java.util.List;
import java.util.Optional;

public class PersistenceH2PostService implements PostService {

    private final PostRepository postRepository;

    @Inject
    public PersistenceH2PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getPosts() {
        return postRepository.getAll();
    }

    @Override
    public Optional<Post> getPost(int postId) {
        return postRepository.findById(postId);
    }

    @Override
    public Post createPost(PostForm postForm) {
        return postRepository.createPost(postForm);
    }
}
