package model;

import com.google.inject.ImplementedBy;
import form.PostForm;

import java.util.List;
import java.util.Optional;

@ImplementedBy(PostRepositoryImpl.class)
public interface PostRepository {

    List<Post> getAll();

    Optional<Post> findById(int postId);

    Post createPost(PostForm postForm);

}
