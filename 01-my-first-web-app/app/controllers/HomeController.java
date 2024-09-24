package controllers;

import model.Post;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;
import java.util.Map;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(views.html.index.render());
    }

    public Result getPosts() {

        List<Post> posts = List.of(
                new Post("title1", "content1"),
                new Post("title2", "content2")
        );

        return ok(views.html.posts.render(posts));
    }

    public Result getPostsJson() {
        return ok(Json.toJson(Map.of("index", 123, "title", "Post title 1", "athor", "Art")));
    }

}
