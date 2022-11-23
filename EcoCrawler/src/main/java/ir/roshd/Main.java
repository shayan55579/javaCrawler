package ir.roshd;

import ir.roshd.crawler.CrawlerManager;
import ir.roshd.dba.DBManagement;
import ir.roshd.log.ConsoleLog;
import ir.roshd.log.Logger;

public class Main {
    static {
        Logger.log = new ConsoleLog();
    }
    public static void main(String[] args) throws InterruptedException {

        DBManagement.instance();
        Thread.sleep(4000);

//        CrawlerManager.instance().startNewsCrawler();
//        CrawlerManager.instance().startNewsCrawler();
//        CrawlerManager.instance().startNewsCrawler();
//        CrawlerManager.instance().startNewsCrawler();
//        CrawlerManager.instance().startNewsCrawler();
//        CrawlerManager.instance().startNewsCrawler();
//        CrawlerManager.instance().startNewsCrawler();
//        CrawlerManager.instance().startNewsCrawler();
//        CrawlerManager.instance().startNewsCrawler();
//        CrawlerManager.instance().startNewsCrawler();

//        CrawlerManager.instance().startEventsCrawler();
//        CrawlerManager.instance().startInfographicCrawler();
//        CrawlerManager.instance().startVideoCrawler();
//        CrawlerManager.instance().startArticleCrawler();
//        CrawlerManager.instance().startChangeCrawler();
//        CrawlerManager.instance().startBrandMarketCrawler();
//        CrawlerManager.instance().startCommunicationCrawler();

        CrawlerManager.instance().startEcosystemCrawler();
        CrawlerManager.instance().startExperienceCrawler();
        CrawlerManager.instance().startFailureStoryCrawler();
        CrawlerManager.instance().startIdeaCrawler();
        CrawlerManager.instance().startPersonalManagementCrawler();
        CrawlerManager.instance().startSchoolCrawler();
        CrawlerManager.instance().startSlideCrawler();
        CrawlerManager.instance().startTeamCrawler();


    }
}
