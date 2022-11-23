package ir.roshd.crawler;

import ir.roshd.log.Logger;
import ir.roshd.miscellaneous.ProxyManagement;
import ir.roshd.miscellaneous.UserAgentManagement;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.net.Proxy;

public abstract class AbstractParser {

    protected String url;
    protected Document document;

    protected AbstractParser(String url) {
        this.url = url;
        parsePage();
    }

    protected String getTextOfElement(Element e){
        if(e == null)
            return "NULL";
        else
            return e.text();
    }

    protected String getAttributeOfElement(Element e,String attr){
        if(e == null)
            return "NULL";
        else
            return e.attr(attr);
    }

    private void parsePage(){
        try {
            Logger.debug("parsePage method in AbstractParser class for: " + url);
            Proxy p = ProxyManagement.instance().choose(ProxyManagement.instance().orderSelect);
            String agent = UserAgentManagement.instance().getAnItem(UserAgentManagement.instance().randomSelector);
            if(p==null) {
                if (agent == null)
                    document = Jsoup.connect(url).get();
                else
                    document = Jsoup.connect(url).userAgent(agent).get();
            }
            else{
                if (agent == null)
                    document = Jsoup.connect(url).proxy(p).get();
                else
                    document = Jsoup.connect(url).proxy(p).userAgent(agent).get();
            }
        }catch (Exception e){
            Logger.error(e.toString());
        }
    }

}
