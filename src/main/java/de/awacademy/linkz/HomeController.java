package de.awacademy.linkz;

import de.awacademy.linkz.link.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final LinkRepository linkRepository;

    @Autowired
    public HomeController(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("links", linkRepository.findAllByOrderByPointsDesc());
        return "home";
    }
}
