package de.awacademy.linkz.link;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Link {

    @Id
    @GeneratedValue
    private long id;

    private String title;

    private String url;

    private int points;

    public Link() {
        // Default constructor for JPA
    }

    public Link(String title, String url) {
        this.title = title;
        this.url = url;
        this.points = 0;
    }

    public Link(String title, String url, int points) {
        this.title = title;
        this.url = url;
        this.points = points;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public int getPoints() {
        return points;
    }
}
