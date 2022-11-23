package ir.roshd.dba.entities;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.List;

@Entity
public class Article {
    @Id
    private String id;

    private String title;
    private String summary;
    private String content;
    private String url;
    private String author;
    private String type;
    private List<String> tags;
    private List<String> videoLinks;
    private List<String> pictureLinks;
    private List<String> source;
    @Embedded
    private Category category;
    @Embedded
    private List<Comment> comments;


    public List<String> getPictureLinks() {
        return pictureLinks;
    }

    public void setPictureLinks(List<String> pictureLinks) {
        this.pictureLinks = pictureLinks;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getVideoLinks() {
        return videoLinks;
    }

    public void setVideoLinks(List<String> videoLinks) {
        this.videoLinks = videoLinks;
    }

    public List<String> getSource() {
        return source;
    }

    public void setSource(List<String> source) {
        this.source = source;
    }


    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                ", url='" + url + '\'' +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                ", tags=" + tags +
                ", videoLinks=" + videoLinks +
                ", source=" + source +
                ", category=" + category +
                ", comments=" + comments +
                '}';
    }
}
