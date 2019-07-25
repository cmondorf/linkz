package de.awacademy.linkz.link;

import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;

public class LinkDTO {

    @NotEmpty
    private final String title;

    @URL
    private final String url;

    public LinkDTO(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}

