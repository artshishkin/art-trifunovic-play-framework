package controllers;

import form.PostForm;
import jakarta.inject.Inject;
import model.Post;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import service.PostService;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    private final PostService postService;
    private final FormFactory formFactory;
    private final HttpExecutionContext httpExecutionContext;

    @Inject
    public HomeController(PostService postService, FormFactory formFactory, HttpExecutionContext httpExecutionContext) {
        this.postService = postService;
        this.formFactory = formFactory;
        this.httpExecutionContext = httpExecutionContext;
    }

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(views.html.index.render());
    }

    public CompletionStage<Result> getPosts(Integer postId, Http.Request request) {
        CompletionStage<List<Post>> postsFuture;
        if (postId == null) {
            postsFuture = postService.getPosts();

        } else {
            postsFuture = CompletableFuture.supplyAsync(() -> postService.getPost(postId)
                    .map(List::of)
                    .orElse(Collections.emptyList())
            );
        }
        return postsFuture.thenApplyAsync(posts -> ok(
                        views.html.posts.render(
                                posts,
                                formFactory.form(PostForm.class),
                                request
                        )
                ),
                httpExecutionContext.current()
        );
    }

    public Result getPostsJson() {
        return ok(Json.toJson(Map.of("index", 123, "title", "Post title 1", "athor", "Art")));
    }

    public Result createPost(Http.Request request) {

        Form<PostForm> boundForm = formFactory.form(PostForm.class).bindFromRequest(request);

        if (boundForm.hasErrors()) {
            return badRequest(views.html.posts.render(List.of(), boundForm, request));
        }

        PostForm postData = boundForm.get();
        Post postCreated = postService.createPost(postData);
        return redirect(routes.HomeController.getPosts(null));
    }
}
