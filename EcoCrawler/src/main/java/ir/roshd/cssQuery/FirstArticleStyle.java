package ir.roshd.cssQuery;

import java.util.List;

public class FirstArticleStyle implements ArticleStyle {
    @Override
    public String getTitleStyle() {
        return "h1.post-title";
    }

    @Override
    public String getSummaryStyle() {
        return ".entry-sub-title";
    }

    @Override
    public String getContentStyle() {
        return ".entry-content > p";
    }

    @Override
    public String getAuthorStyle() {
        return "a.author-name";
    }

    @Override
    public String getTagStyle() {
        return "#the-post > div.entry-content.entry.clearfix > div.post-bottom-meta.post-bottom-tags.post-tags-modern > span.tagcloud > a";
    }

    @Override
    public String getVideoLinkStyle() {
        return "video";
    }

    @Override
    public String getPictureLinks() {
        return "#the-post img";
    }

    @Override
    public String getPrallexPic() {
        return "#tie-wrapper > div.fullwidth-entry-title.single-big-img.full-width-area.tie-parallax";
    }

    @Override
    public String getSourceStyle() {
        return "#the-post > div.entry-content.entry.clearfix > div.post-bottom-meta.post-bottom-source > span.tagcloud > a";

    }

    @Override
    public String getCatgeoryStyle() {
        return "#breadcrumb > a";
    }

    @Override
    public CommentStyle getCommentStyle() {
        return new FirstCommentStyle();
    }
}
