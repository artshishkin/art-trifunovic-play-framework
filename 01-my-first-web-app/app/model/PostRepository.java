package model;

import com.google.inject.ImplementedBy;
import form.PostForm;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletionStage;

@ImplementedBy(PostRepositoryImpl.class)
public interface PostRepository {

    CompletionStage<List<Post>> getAll();

    Optional<Post> findById(int postId);

    Post createPost(PostForm postForm);

}
