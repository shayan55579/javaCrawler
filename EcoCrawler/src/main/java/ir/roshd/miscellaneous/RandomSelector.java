package ir.roshd.miscellaneous;

import java.util.List;
import java.util.Random;

public class RandomSelector<T> implements Selector<T> {
    @Override
    public T select(List<T> proxis) {
        if(proxis == null || proxis.size() == 0){
            return null;
        }
        Random r = new Random();
        int n = r.nextInt(proxis.size());

        return proxis.get(n);
    }
}
