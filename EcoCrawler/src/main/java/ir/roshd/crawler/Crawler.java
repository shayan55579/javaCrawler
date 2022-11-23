package ir.roshd.crawler;

import java.util.UUID;

public abstract class Crawler implements Runnable {

    protected String id = UUID.randomUUID().toString();
    protected boolean live = true;
    protected long savedEntities = 0;

    public String getcrawlerId(){
        return id;
    }

    public long getSavedEntities() {
        return savedEntities;
    }

    public void setSavedEntities(long savedEntities) {
        this.savedEntities = savedEntities;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    protected abstract void crawl();

    @Override
    public void run() {
        CrawlerManager.instance().addCrawler(this);
        crawl();
        CrawlerManager.instance().removeCrawler(this);
    }
}
