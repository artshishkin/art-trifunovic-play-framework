package model;

import form.PostForm;
import jakarta.inject.Inject;
import jakarta.persistence.TypedQuery;
import play.db.jpa.JPAApi;

import java.util.List;
import java.util.Optional;

public class PostRepositoryImpl implements PostRepository {

    private final JPAApi jpaApi;
    private final DbExecutionContext executionContext;

    @Inject
    public PostRepositoryImpl(JPAApi jpaApi, DbExecutionContext executionContext) {
        this.jpaApi = jpaApi;
        this.executionContext = executionContext;
    }

    @Override
    public List<Post> getAll() {
        return jpaApi.withTransaction(em -> {
            TypedQuery<Post> query = em.createQuery("select p from Post p", Post.class);
            return query.getResultList();
        });
    }

    @Override
    public Optional<Post> findById(int postId) {
        return Optional.empty();
    }

    @Override
    public Post createPost(PostForm postForm) {
        return null;
    }
}
