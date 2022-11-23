package ir.roshd.miscellaneous;

import java.net.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ProxyManagement {
    private List<Proxy> proxies;
    public final Selector<Proxy> randomSelect = new RandomSelector<>();

    public final Selector<Proxy> orderSelect = new OrderedSelector<>();



    private ProxyManagement(){
        proxies = new ArrayList<>();
    }
    private static ProxyManagement pm;

    public static ProxyManagement instance(){
        if(pm==null){
            pm = new ProxyManagement();
        }
        return pm;
    }

    public void add(Proxy... prxis){
        proxies.addAll(Arrays.asList(prxis));
    }

    public Proxy choose(Selector<Proxy> selector){
        Proxy p = selector.select(proxies);
        return p;
    }



}
