package site;

import java.util.ArrayList;

/**
 * The type of a basic page
 * All of the pages in the site are an extension of this class
 */
public class Page {
    private String pageType;
    private ArrayList<String> availablePages = new ArrayList<>();

    /**
     * Get the pages available to navigate to from this page
     *
     * @return
     */
    public ArrayList<String> getAvailablePages() {
        return availablePages;
    }

    /**
     * add a new page to navigate to from the current page
     *
     * @param s
     */
    public void setAvailablePages(final String s) {
        availablePages.add(s);
    }

    /**
     * empty constructor
     */
    public Page() {
    }

    /**
     * set the type of the page
     *
     * @param pageType
     */
    public void setPageType(final String pageType) {
        this.pageType = pageType;
    }

    /**
     * get the page type for the verification of the page instance
     *
     * @return
     */
    public String getPageType() {
        return pageType;
    }
}
