package ir.roshd.crawler;

import ir.roshd.cssQuery.ArticleStyle;
import ir.roshd.dba.entities.Article;
import ir.roshd.dba.entities.Category;
import ir.roshd.dba.entities.Comment;
import ir.roshd.log.Logger;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ParseArticle extends AbstractParser{
    private String type;
    private ArticleStyle style;
    private ParseArticle(String url) {
        super(url);
    }
    public ParseArticle(String url,String type, ArticleStyle as){
        this(url);
        this.type = type;
        style = as;
    }


    private String getTitle(){
        if(style.getTitleStyle() == null)
            return null;
        return getTextOfElement(document.selectFirst(style.getTitleStyle()));
    }

    private String getSummary(){
        if(style.getSummaryStyle() == null)
            return null;
        return getTextOfElement(document.selectFirst(style.getSummaryStyle()) );
    }

    private String getContent(){
        if(style.getContentStyle() == null)
            return null;
        return document.select(style.getContentStyle()).eachText().stream().collect(Collectors.joining("\n"));
    }

    private String getAuthor(){
        if(style.getAuthorStyle() == null)
            return null;
        return getTextOfElement(document.selectFirst(style.getAuthorStyle()));
    }

    private List<String> getSource(){
        if(style.getSourceStyle() == null)
            return null;

        List<String> sources = new ArrayList<>();
        sources.addAll(document.select(style.getSourceStyle()).eachText());
        if(sources.size() == 0){
            sources.add("NULL");
        }
        return sources;
    }

    private List<String> getVideoLinks(){
        if(style.getVideoLinkStyle() == null)
            return null;
        List<String> links = new ArrayList<>();
        Logger.debug("before Video");
        document.select(style.getVideoLinkStyle()).forEach(e -> {
            links.add(getTextOfElement(e.selectFirst("a")));
        });

        if(links.size() == 0){
            links.add("NULL");
        }
        return links;
    }

    private List<String> getTags(){
        if(style.getTagStyle() == null)
            return null;
        List<String> tags = new ArrayList<>();
        tags.addAll(document.select(style.getTagStyle()).eachText());
        if(tags.size() == 0){
            tags.add("NULL");
        }

        return tags;
    }

    private Category getCategory(){
        if(style.getCatgeoryStyle() == null)
            return null;
        Category p = new Category();
        Category t = p;
        List<String> list = document.select(style.getCatgeoryStyle()).eachText();
        int i;
        for( i=0;i<list.size()-1;i++){
            t.setName(list.get(i));
            Category tt = new Category();
            t.setSubCategory(tt);
            t = tt;
        }
        t.setName(list.get(i));

        return p;
    }

    public List<Comment> getComments(){
        if(style.getCommentStyle() == null)
            return null;
        List<Comment> comments = new ArrayList<>();
        AtomicInteger ai = new AtomicInteger(0);
        Logger.debug("Before each comments");
        document.select(style.getCommentStyle().getAllCommentsStyle()).forEach(e ->{
            Comment com = new Comment();
            comments.add(com);
            Logger.debug(ai.getAndIncrement() + " checked!!");
            com.setContent(getTextOfElement(e.selectFirst(style.getCommentStyle().getContentStyle())));
            com.setAuthorName(getTextOfElement(e.selectFirst(style.getCommentStyle().getAuthorStyle())));
            com.setDate(getAttributeOfElement(e.selectFirst(style.getCommentStyle().getDateStyle()),"datetime"));
        });

        if(comments.size() == 0){
            Comment com = new Comment();
            com.setContent("NULL");
            com.setAuthorName("NULL");
            com.setDate("NULL");
            comments.add(com);
        }
        return comments;
    }

    public List<String> getPictures(){
        if(style.getPictureLinks() == null || style.getPrallexPic() == null)
            return null;

        final List<String> links = new ArrayList<>();

        document.select(style.getPictureLinks()).forEach(img -> {
//            Logger.info("Image is: " + img.toString());
            String imageUrl = getAttributeOfElement(img,"src");
            if(imageUrl.startsWith("http")){
                links.add(imageUrl);
            }

        });

        Element parallex = document.selectFirst(style.getPrallexPic());
        String pStyle = getAttributeOfElement(parallex,"style");
        if(pStyle != null && pStyle.length()>0){
            Pattern pt = Pattern.compile("url\\((.*)\\).*");

            Matcher m = pt.matcher(pStyle);

            if(m.find()){
                Logger.debug("match found for pStyle: " + m.group(1)  );
                links.add(m.group(1));
            }
        }

        if(links.size() == 0)
            links.add("NULL");
        return links;

    }



    public Article createArticle(){
        Article article = new Article();

        article.setTitle(getTitle());
        article.setSummary(getSummary());
        article.setContent(getContent());

        article.setAuthor(getAuthor());
        article.setType(type);
        article.setTags(getTags());

        article.setSource(getSource());
        article.setUrl(url);
        article.setVideoLinks(getVideoLinks());

        article.setCategory(getCategory());
        article.setComments(getComments());
        article.setPictureLinks(getPictures());


        return article;
    }


}
