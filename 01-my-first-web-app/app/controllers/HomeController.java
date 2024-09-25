package controllers;

import form.PostForm;
import jakarta.inject.Inject;
import model.Post;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import service.PostService;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    private final PostService postService;
    private final FormFactory formFactory;

    @Inject
    public HomeController(PostService postService, FormFactory formFactory) {
        this.postService = postService;
        this.formFactory = formFactory;
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

    public Result getPosts(Integer postId, Http.Request request) {

        List<Post> posts;
        if (postId == null) {
            posts = postService.getPosts();

        } else {
            posts = postService.getPost(postId)
                    .map(List::of)
                    .orElse(Collections.emptyList());
        }
        return ok(views.html.posts.render(posts, request));
    }

    public Result getPostsJson() {
        return ok(Json.toJson(Map.of("index", 123, "title", "Post title 1", "athor", "Art")));
    }

    public Result createPost(Http.Request request) {

        Form<PostForm> boundForm = formFactory.form(PostForm.class).bindFromRequest(request);

        PostForm postData = boundForm.get();
        postService.createPost(postData);
        return redirect(routes.HomeController.getPosts(null));
    }
}
