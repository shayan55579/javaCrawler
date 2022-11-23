package ir.roshd.crawler;

import ir.roshd.cssQuery.FirstPaginationStyle;
import ir.roshd.cssQuery.PaginationStyle;
import ir.roshd.cssQuery.SecondPaginationStyle;

import java.util.ArrayList;
import java.util.List;

public class CrawlerManager {
    private CrawlerManager(){

    }
    private static CrawlerManager cm;

    public static CrawlerManager instance(){
        if(cm == null){
            cm = new CrawlerManager();
        }

        return cm;
    }

    private List<Crawler> liveCrawlers = new ArrayList<>();
    private void handleArticleCrawler(String url,String type,PaginationStyle style ){
        ArticleCrawler articleCrawler = new ArticleCrawler(url,type,style);
        Thread th = new Thread(articleCrawler);
        th.start();

    }

    public void stopCrawler(String crawlerId){
        Crawler theCrawler = null;
        for(Crawler c : liveCrawlers){
            if(c.getcrawlerId().equals(crawlerId)){
                theCrawler = c;
                break;
            }
        }
        if(theCrawler != null){
            theCrawler.setLive(false);
        }
    }

    public void addCrawler(Crawler c){
        liveCrawlers.add(c);
    }

    public void removeCrawler(Crawler c){
        liveCrawlers.remove(c);
    }



    public void startNewsCrawler(){
        String url = "https://ecomotive.ir/category/news/";
        String type = "news";

        PaginationStyle style = new FirstPaginationStyle();
        handleArticleCrawler(url,type,style);
    }

    public void startEventsCrawler(){
        String url = "https://ecomotive.ir/category/events/";
        String type = "events";
        PaginationStyle style = new FirstPaginationStyle();
        handleArticleCrawler(url,type,style);
    }


    public void startExperienceCrawler(){
        String url = "https://ecomotive.ir/category/exprience/";
        String type = "exprience";
        PaginationStyle style = new FirstPaginationStyle();
        handleArticleCrawler(url,type,style);
    }


    public void startFailureStoryCrawler(){
        String url = "https://ecomotive.ir/category/failure-story/";
        String type = "failure-story";
        PaginationStyle style = new SecondPaginationStyle();
        handleArticleCrawler(url,type,style);
    }


    public void startIdeaCrawler(){
        String url = "https://ecomotive.ir/category/idea/";
        String type = "idea";
        PaginationStyle style = new SecondPaginationStyle();
        handleArticleCrawler(url,type,style);
    }


    public void startArticleCrawler(){
        String url = "https://ecomotive.ir/category/article/";
        String type = "article";
        PaginationStyle style = new FirstPaginationStyle();
        handleArticleCrawler(url,type,style);
    }


    public void startEcosystemCrawler(){
        String url = "https://ecomotive.ir/category/ecosystem/";
        String type = "ecosystem";
        PaginationStyle style = new FirstPaginationStyle();
        handleArticleCrawler(url,type,style);
    }


    public void startBrandMarketCrawler(){
        String url = "https://ecomotive.ir/category/school/branding-marketing/";
        String type = "school_branding-marketing";
        PaginationStyle style = new FirstPaginationStyle();
        handleArticleCrawler(url,type,style);
    }


    public void startTeamCrawler(){
        String url = "https://ecomotive.ir/category/school/team/";
        String type = "school_team";
        PaginationStyle style = new FirstPaginationStyle();
        handleArticleCrawler(url,type,style);
    }


    public void startPersonalManagementCrawler(){
        String url = "https://ecomotive.ir/category/school/personal-management/";
        String type = "school_personal-management";
        PaginationStyle style = new FirstPaginationStyle();
        handleArticleCrawler(url,type,style);
    }


    public void startCommunicationCrawler(){
        String url = "https://ecomotive.ir/category/school/communication/";
        String type = "communication";
        PaginationStyle style = new FirstPaginationStyle();
        handleArticleCrawler(url,type,style);
    }


    public void startChangeCrawler(){
        String url = "https://ecomotive.ir/category/school/change/";
        String type = "change";
        PaginationStyle style = new FirstPaginationStyle();
        handleArticleCrawler(url,type,style);
    }


    public void startSchoolCrawler(){
        String url = "https://ecomotive.ir/category/school/";
        String type = "school";
        PaginationStyle style = new FirstPaginationStyle();
        handleArticleCrawler(url,type,style);
    }


    public void startSlideCrawler(){
        String url = "https://ecomotive.ir/category/multimedia/slide/";
        String type = "slide";
        PaginationStyle style = new FirstPaginationStyle();
        handleArticleCrawler(url,type,style);
    }


    public void startVideoCrawler(){
        String url = "https://ecomotive.ir/category/multimedia/video/";
        String type = "video";
        PaginationStyle style = new SecondPaginationStyle();
        handleArticleCrawler(url,type,style);
    }


    public void startInfographicCrawler(){
        String url = "https://ecomotive.ir/category/multimedia/infographic/";
        String type = "infographic";
        PaginationStyle style = new FirstPaginationStyle();
        handleArticleCrawler(url,type,style);
    }




}
