package ir.roshd.crawler;

import ir.roshd.log.Logger;

import java.util.TimerTask;

public class TimerForCrawler extends TimerTask {

    private Crawler crawler;
    private long period;

    public TimerForCrawler(Crawler crawler, long peroid) {
        this.crawler = crawler;
        this.period = peroid;
    }

    @Override
    public void run() {
        new Thread(()->{
            try {
                Thread.sleep(period);
                crawler.setLive(false);
            } catch (InterruptedException e) {
                Logger.error(e.toString());
            }

        }).start();
        crawler.run();
    }


}
