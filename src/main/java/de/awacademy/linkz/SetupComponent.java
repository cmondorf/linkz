package de.awacademy.linkz;

import de.awacademy.linkz.link.Link;
import de.awacademy.linkz.link.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Random;

@Component
public class SetupComponent {

    private final LinkRepository linkRepository;

    @Autowired
    public SetupComponent(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @EventListener
    @Transactional
    public void handleApplicationReady(ApplicationReadyEvent event) {
        if (linkRepository.count() == 0) {
            Random r = new Random();
            linkRepository.save(new Link("Academic Work Academy", "https://www.awacademy.de", r.nextInt(100)));
            linkRepository.save(new Link("Wikipedia", "https://de.wikipedia.org/", r.nextInt(100)));
            linkRepository.save(new Link("IntelliJ IDEA", "https://www.jetbrains.com/idea/", r.nextInt(100)));
            linkRepository.save(new Link("Canvas", "https://canvas.academy.se/", r.nextInt(100)));
            linkRepository.save(new Link("Thymeleaf", "https://www.thymeleaf.org/", r.nextInt(100)));
            linkRepository.save(new Link("Angular", "https://angular.io/", r.nextInt(100)));
            linkRepository.save(new Link("Mozilla Developer Network", "https://developer.mozilla.org", r.nextInt(100)));
            linkRepository.save(new Link("Bulma", "https://bulma.io/", r.nextInt(100)));
            linkRepository.save(new Link("Spring Framework", "https://spring.io/", r.nextInt(100)));
            linkRepository.save(new Link("HackerRank", "https://www.hackerrank.com/", r.nextInt(100)));
            linkRepository.save(new Link("CodeSignal", "https://codesignal.com/", r.nextInt(100)));
            linkRepository.save(new Link("Spring Security - Getting Started", "https://spring.io/guides/gs/securing-web/", 100));
        }
    }
}
