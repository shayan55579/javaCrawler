package ir.roshd.cssQuery;

public class FirstCommentStyle implements CommentStyle {
    @Override
    public String getAuthorStyle() {
        return "div.comment-author.vcard > b";
    }

    @Override
    public String getDateStyle() {
        return "time";
    }

    @Override
    public String getContentStyle() {
        return "div.comment-content";
    }

    @Override
    public String getAllCommentsStyle() {
        return "article.comment-body";
    }
}
