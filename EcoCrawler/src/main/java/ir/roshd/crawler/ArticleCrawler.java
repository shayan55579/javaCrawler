package ir.roshd.crawler;

import ir.roshd.cssQuery.PaginationStyle;
import ir.roshd.dba.DBManagement;
import ir.roshd.dba.entities.Article;
import ir.roshd.log.Logger;

import java.util.*;

public class ArticleCrawler extends Crawler {


    private String url;
    private String type;
    private PaginationStyle style;
    private static Set<String> visistedPages = new HashSet<>();

    public ArticleCrawler(String url, String type, PaginationStyle style) {
        this.url = url;
        this.type = type;
        this.style = style;
    }


    @Override
    public void crawl() {
        while(isLive()){
            Logger.info("Visiting Pagination: " + url);

            ParseArticlePagination pap = new ParseArticlePagination(url,type,style);

            synchronized (visistedPages){
                if(visistedPages.contains(url)){
                    url = pap.getNextPage();

                    if(url == null || url.length() < 10)
                        break;

                    continue;
                }
                visistedPages.add(url);
            }

            List<String> links = pap.getLinks();

            links = DBManagement.instance().filterExistingArticles(links,type);

            List<Article> articles = pap.getArticles(links);

            articles.forEach(a->{
                DBManagement.instance().saveArticle(a);
            });

            savedEntities += articles.size();

            url = pap.getNextPage();

            if(url == null || url.length() < 10)
                break;
        }
    }
}
