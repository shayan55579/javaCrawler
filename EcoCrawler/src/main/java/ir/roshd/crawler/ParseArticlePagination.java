package ir.roshd.crawler;

import ir.roshd.cssQuery.FirstArticleStyle;
import ir.roshd.cssQuery.PaginationStyle;
import ir.roshd.dba.entities.Article;
import ir.roshd.log.Logger;

import java.util.ArrayList;
import java.util.List;

public class ParseArticlePagination extends AbstractParser {
    private String type;
    private PaginationStyle style;
    private ParseArticlePagination(String url) {
        super(url);
    }

    public ParseArticlePagination(String url,String type,PaginationStyle ps){
        this(url);
        this.style  = ps;
        this.type = type;
    }

    public List<String> getLinks(){

        List<String> links = new ArrayList<>();

        document.select(style.getUrlLink()).forEach( a ->{
          String s = getAttributeOfElement(a,"href");
          if(s != null)
              links.add(s);
        });

        return links;
    }

    public List<Article> getArticles(List<String> links){
        List<Article> artcles = new ArrayList<>();

        links.forEach(link -> {
            Logger.info("Visiting Page: " + link);
            artcles.add(new ParseArticle(link,type,new FirstArticleStyle()).createArticle());
        });


        return artcles;
    }

    public String getNextPage(){
        return getAttributeOfElement(document.selectFirst(style.getNextUrlLink()),"href");
    }





}
