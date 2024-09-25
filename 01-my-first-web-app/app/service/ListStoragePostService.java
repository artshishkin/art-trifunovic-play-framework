package service;

import model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListStoragePostService implements PostService {

    private List<Post> posts = new ArrayList<>(
            List.of(
                    new Post(1, "Covid-19", "It is the regular disease now"),
                    new Post(2, "War in Ukraine", "russia must be stopped")
            )
    );

    @Override
    public List<Post> getPosts() {
        return posts;
    }

    @Override
    public Optional<Post> getPost(int postId) {
        return posts.stream()
                .filter(p -> p.getId() == postId)
                .findAny();
    }
}
