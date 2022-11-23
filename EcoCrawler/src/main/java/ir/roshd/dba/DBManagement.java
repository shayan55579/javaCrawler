package ir.roshd.dba;

import com.mongodb.MongoClient;
import ir.roshd.dba.entities.Article;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.util.ArrayList;
import java.util.List;

public class DBManagement {

    private static String DB_NAME = "Ecomotive";
    private static DBManagement dbm;
    private Datastore datastore;
    private DBManagement(){

    }
    public static DBManagement instance(){
        if(dbm==null){
            dbm = new DBManagement();
            Morphia mo = new Morphia();
            mo.mapPackageFromClass(Article.class);

            dbm.datastore = mo.createDatastore(new MongoClient("127.0.0.1",27017),DB_NAME);

            dbm.datastore.ensureIndexes();
        }
        return dbm;
    }

    public <T> void saveArticle(T object){
        dbm.datastore.save(object);
    }

    public List<Article> getArticlesByType(String type){
        return datastore.find(Article.class).field("type").equal(type).asList();
    }

    public List<String> filterExistingArticles(List<String> links,String type){
        List<String> filteredList = new ArrayList<>();

        links.forEach(link ->{
            if(datastore.find(Article.class).field("url").equal(link).field("type").equal(type).get() ==null){
                filteredList.add(link);
            }
        });

        return filteredList;
    }
}
