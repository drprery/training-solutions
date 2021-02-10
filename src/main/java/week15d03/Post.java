package week15d03;

import java.time.LocalDate;

public class Post {
    private String title;
    private LocalDate publishedAt;
    private String content;
    private String owner;

    public String getTitle() {
        return title;
    }

    public LocalDate getPublishedAt() {
        return publishedAt;
    }

    public String getContent() {
        return content;
    }

    public String getOwner() {
        return owner;
    }
}
