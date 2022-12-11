package Site;

import inputFiles.User;

public class Current {
    private User user;
    private Page page;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Current(User user, Page page) {
        this.user = user;
        this.page = page;
    }
}
