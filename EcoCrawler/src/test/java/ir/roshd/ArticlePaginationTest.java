package ir.roshd;

import ir.roshd.crawler.ParseArticlePagination;
import ir.roshd.cssQuery.FirstPaginationStyle;
import ir.roshd.cssQuery.SecondPaginationStyle;
import ir.roshd.log.ConsoleLog;
import ir.roshd.log.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ArticlePaginationTest {


    @BeforeAll
    public static void init(){
        Logger.log = new ConsoleLog();
    }

    @Test
    public void checkLinks(){

//        String url = "https://ecomotive.ir/category/news/";
//        String url = "https://ecomotive.ir/category/events/";
//        String url = "https://ecomotive.ir/category/exprience/";
        String url = "https://ecomotive.ir/category/failure-story/"; // failed-> 2 is oK
//        String url = "https://ecomotive.ir/category/idea/"; // failed-> 2 is oK
//        String url = "https://ecomotive.ir/category/article/";
//        String url = "https://ecomotive.ir/category/ecosystem/";
//        String url = "https://ecomotive.ir/category/school/branding-marketing/";
//        String url = "https://ecomotive.ir/category/school/team/";
//        String url = "https://ecomotive.ir/category/school/personal-management/";
//        String url = "https://ecomotive.ir/category/school/communication/";
//        String url = "https://ecomotive.ir/category/school/change/";
//        String url = "https://ecomotive.ir/category/school/";
//        String url = "https://ecomotive.ir/category/multimedia/video/"; // failed -> 2 is oK
//        String url = "https://ecomotive.ir/category/multimedia/slide/";
//        String url = "https://ecomotive.ir/category/multimedia/infographic/"; // failed -> 2 is oK

        ParseArticlePagination pap = new ParseArticlePagination(url,"news",new SecondPaginationStyle());
        List<String> links = pap.getLinks();

        Logger.info("Links: " + links);
        Assertions.assertEquals(links.size(),10);

    }
}
