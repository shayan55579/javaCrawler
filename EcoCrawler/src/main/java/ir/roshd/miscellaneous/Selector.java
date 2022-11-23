package ir.roshd.miscellaneous;

import java.net.Proxy;
import java.util.List;

public interface Selector<T> {
    public T select(List<T> proxis);
}
