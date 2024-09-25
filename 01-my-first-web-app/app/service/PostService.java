package service;

import com.google.inject.ImplementedBy;
import form.PostForm;
import model.Post;

import java.util.List;
import java.util.Optional;

@ImplementedBy(ListStoragePostService.class)
public interface PostService {

    List<Post> getPosts();

    Optional<Post> getPost(int postId);

    Post createPost(PostForm postForm);
}
