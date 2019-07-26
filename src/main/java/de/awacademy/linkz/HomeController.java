package de.awacademy.linkz;

import de.awacademy.linkz.link.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private final LinkRepository linkRepository;

    @Autowired
    public HomeController(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @GetMapping("/")
    public String home(Model model, @RequestParam(defaultValue = "false") boolean linkSubmitted,
                       @RequestParam(defaultValue = "false") boolean voted,
                       @RequestParam(defaultValue = "false") boolean registered,
                       @RequestParam(defaultValue = "false") boolean deleted) {
        model.addAttribute("links", linkRepository.findAllByOrderByPointsDesc());
        model.addAttribute("linkSubmitted", linkSubmitted);
        model.addAttribute("voted", voted);
        model.addAttribute("registered", registered);
        model.addAttribute("deleted", deleted);
        return "home";
    }
}
