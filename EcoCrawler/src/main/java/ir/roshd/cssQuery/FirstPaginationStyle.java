package ir.roshd.cssQuery;

public class FirstPaginationStyle implements PaginationStyle {

    @Override
    public String getUrlLink() {
        return "#posts-container > li > a";
    }

    @Override
    public String getNextUrlLink() {
        return "li.the-next-page > a";
    }

    @Override
    public String getPreviousUrllink() {
        return "li.the-prev-page > a";
    }

    @Override
    public String getFirstPage() {
        return "li.first-page > a";
    }

    @Override
    public String getLastPage() {
        return "li.last-page > a";
    }
}
