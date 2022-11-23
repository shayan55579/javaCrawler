package ir.roshd.miscellaneous;

import java.net.Proxy;
import java.util.List;

public class OrderedSelector<T> implements Selector<T> {
    private int n = 0;
    @Override
    public T select(List<T> proxis) {
        if(proxis == null || proxis.size() == 0)
            return null;
        T p = proxis.get(n++ % proxis.size());

        return p;
    }
}
