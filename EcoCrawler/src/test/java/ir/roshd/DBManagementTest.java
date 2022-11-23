package ir.roshd;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ir.roshd.dba.DBManagement;
import ir.roshd.dba.entities.Article;
import ir.roshd.log.ConsoleLog;
import ir.roshd.log.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.util.List;

public class DBManagementTest {

    @BeforeAll
    public static void init(){
        Logger.log = new ConsoleLog();
    }

    @Test
    public void saveArticles(){
        String mainPath = "/home/roshd/Documents/Ecomotive";
        String type = "news";
        String path = mainPath + "/" + type + "/";
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        File f = new File(path);
        f.mkdirs();
        List<Article> articles = DBManagement.instance().getArticlesByType(type);

        for(Article article : articles){
            try (FileWriter fw = new FileWriter(path + article.getId() + ".json")) {
                fw.write(gson.toJson(article));
            }catch (Exception e){
                Logger.error(e.toString());
            }
        }

    }
}
