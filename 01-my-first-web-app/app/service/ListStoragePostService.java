package service;

import form.PostForm;
import model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class ListStoragePostService implements PostService {

    private List<Post> posts = new ArrayList<>(
            List.of(
                    new Post(1, "Covid-19", "It is the regular disease now"),
                    new Post(2, "War in Ukraine", "russia must be stopped")
            )
    );

    @Override
    public CompletionStage<List<Post>> getPosts() {
        return CompletableFuture.completedFuture(posts);
    }

    @Override
    public Optional<Post> getPost(int postId) {
        return posts.stream()
                .filter(p -> p.getId() == postId)
                .findAny();
    }

    @Override
    public Post createPost(PostForm postForm) {
        int maxIdx = posts.stream()
                .mapToInt(Post::getId)
                .max()
                .orElse(0);
        Post newPost = new Post(maxIdx + 1, postForm.getTitle(), postForm.getContent());
        posts.add(newPost);
        return newPost;
    }
}
