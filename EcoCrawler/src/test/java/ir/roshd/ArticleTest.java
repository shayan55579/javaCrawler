package ir.roshd;

import ir.roshd.crawler.ParseArticle;
import ir.roshd.cssQuery.FirstArticleStyle;
import ir.roshd.dba.DBManagement;
import ir.roshd.dba.entities.Article;
import ir.roshd.log.ConsoleLog;
import ir.roshd.log.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ArticleTest {

    @BeforeAll
    public static void init(){
        Logger.log = new ConsoleLog();
    }

    @Test
    public void checkCreateArticle(){
//        String url = "https://ecomotive.ir/1399/11/30/home-appliance-industry/";
//        String url = "https://ecomotive.ir/1399/05/12/data-approach-revealing-secrets-of-billion-dollar-startups/";
//        String url = "https://ecomotive.ir/1399/11/15/technology-investment-meeting-2/";
//        String url = "https://ecomotive.ir/1399/06/04/civitas-interview/";
        String url = "https://ecomotive.ir/1396/10/05/%d9%88%d8%b6%d8%b9%db%8c%d8%aa-%d8%aa%d9%88%d8%b3%d8%b9%d9%87-%d8%a7%d8%b3%d8%aa%d8%a7%d8%b1%d8%aa%d8%a7%d9%be-%d9%87%d8%a7%db%8c-%d8%a7%db%8c%d8%b1%d8%a7%d9%86%db%8c-%d8%af%d8%b1-%d8%ad%d9%88%d8%b2/";
//        String url = "https://ecomotive.ir/1399/05/29/%d8%b1%d9%82%d8%a7%d8%a8%d8%aa-%d8%ae%d9%88%d8%a8-%d8%a7%d8%b3%d8%aa-%db%8c%d8%a7-%d8%a8%d8%af%d8%9f-%d8%a7%d9%86%d8%ad%d8%b5%d8%a7%d8%b1-%da%86%d8%b7%d9%88%d8%b1%d8%9f/";
//        String url = "https://ecomotive.ir/1399/11/28/%d8%a7%d9%87%d9%85%db%8c%d8%aa-%d9%86%d9%88%d8%a2%d9%88%d8%b1%db%8c-%d8%a8%d8%b1%d8%a7%db%8c-%d8%b1%d8%b4%d8%af/";
        String type = "news";
        FirstArticleStyle fas = new FirstArticleStyle();
        ParseArticle pa = new ParseArticle(url,type,fas);

        Article art =  pa.createArticle();

        Logger.info("Art: " + art.getTags());

        Assertions.assertEquals(art.getTags().size(),1);


    }

    @Test
    public void testMain(){

    }

    @Test
    public void checkregularExp(){
//        String str = "background-position: 50% 50%; background-size: cover; background-repeat: no-repeat; background-image: url(\"https://ecomotive.ir/wp-content/uploads/2019/02/%D8%A2%D8%B4%D9%86%D8%A7%DB%8C%DB%8C-%D8%A8%D8%A7-%D8%A8%D8%B1%D8%AA%D8%B1%DB%8C%D9%86-%D8%A7%D8%B3%D8%AA%D8%A7%D8%B1%D8%AA%D8%A7%D9%BE-%D9%87%D8%A7%DB%8C-%D8%AF%D9%86%DB%8C%D8%A7-%D8%AF%D8%B1-%D8%AD%D9%88%D8%B2%D9%87-%D8%B3%D9%84%D8%A7%D9%85%D8%AA-%D8%AC%D8%B3%D9%85%D8%A7%D9%86%DB%8C.jpg\"); position: fixed; top: 0px; left: 0px; width: 1385px; height: 609px; overflow: hidden; pointer-events: none; margin-top: -58.5px; transform: translateY(-138.5px) translateZ(0px);";
//
//        Pattern pt = Pattern.compile("background-image: url\\(\"(.*)\"\\);.*");
//
//        Matcher m = pt.matcher(str);
//
//        if(m.find()){
//            System.out.println("Group Count: " + m.groupCount());
//            System.out.println(m.group(1));
//        }

//        String line = "This order was placed for QT3000! OK?";
//        String pattern = "(.*)ple(\\d+)T(.*)";
//
//        // Create a Pattern object
//        Pattern r = Pattern.compile(pattern);
//
//        // Now create matcher object.
//        Matcher m = r.matcher(line);
//
//        if (m.find( )) {
//            System.out.println("GroupCount: " + m.groupCount());
//            System.out.println("Found value: " + m.group(0) );
//            System.out.println("Found value: " + m.group(1) );
//            System.out.println("Found value: " + m.group(2) );
//        } else {
//            System.out.println("NO MATCH");
//        }


        String url = "https://ecomotive.ir/1399/11/15/top-startups-for-sports-and-physical-health/";
//        String url = "https://ecomotive.ir/1396/10/05/%d9%88%d8%b6%d8%b9%db%8c%d8%aa-%d8%aa%d9%88%d8%b3%d8%b9%d9%87-%d8%a7%d8%b3%d8%aa%d8%a7%d8%b1%d8%aa%d8%a7%d9%be-%d9%87%d8%a7%db%8c-%d8%a7%db%8c%d8%b1%d8%a7%d9%86%db%8c-%d8%af%d8%b1-%d8%ad%d9%88%d8%b2/";
//        String url = "https://ecomotive.ir/1399/05/29/%d8%b1%d9%82%d8%a7%d8%a8%d8%aa-%d8%ae%d9%88%d8%a8-%d8%a7%d8%b3%d8%aa-%db%8c%d8%a7-%d8%a8%d8%af%d8%9f-%d8%a7%d9%86%d8%ad%d8%b5%d8%a7%d8%b1-%da%86%d8%b7%d9%88%d8%b1%d8%9f/";
//        String url = "https://ecomotive.ir/1399/11/28/%d8%a7%d9%87%d9%85%db%8c%d8%aa-%d9%86%d9%88%d8%a2%d9%88%d8%b1%db%8c-%d8%a8%d8%b1%d8%a7%db%8c-%d8%b1%d8%b4%d8%af/";
        String type = "news";
        FirstArticleStyle fas = new FirstArticleStyle();
        ParseArticle pa = new ParseArticle(url,type,fas);

        Article art =  pa.createArticle();

        Logger.info("ArtSize: " + art.getPictureLinks().size());
        for(String s : art.getPictureLinks())
            Logger.info(s);

        DBManagement.instance().saveArticle(art);

        Assertions.assertEquals(100,art.getPictureLinks().size());

    }
}
