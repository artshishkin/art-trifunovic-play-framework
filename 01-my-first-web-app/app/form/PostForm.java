package form;

import play.data.validation.Constraints;

public class PostForm {

    @Constraints.Required
    @Constraints.MinLength(3)
    private String title;

    @Constraints.Required
    @Constraints.MinLength(5)
    @Constraints.MaxLength(200)
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
