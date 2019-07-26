package de.awacademy.linkz.link;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class LinkController {

    private final LinkRepository linkRepository;

    @Autowired
    public LinkController(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @GetMapping("/submit")
    public String submit(Model model) {
        model.addAttribute("link", new LinkDTO("", ""));
        return "submit";
    }

    @PostMapping("/submit")
    public String submit(@Valid @ModelAttribute("link") LinkDTO linkDTO, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "submit";
        }

        Link link = new Link(linkDTO.getTitle(), linkDTO.getUrl());
        linkRepository.save(link);

        redirectAttributes.addAttribute("linkSubmitted", true);
        return "redirect:/";
    }

    @PostMapping("/vote")
    public String upvote(VoteDTO voteDTO, RedirectAttributes redirectAttributes) {
        Link link = linkRepository.findById(voteDTO.getLinkId()).orElseThrow();

        if (voteDTO.isUp()) {
            link.upvote();
        }
        else {
            link.downvote();
        }

        linkRepository.save(link);

        redirectAttributes.addAttribute("voted", true);
        return "redirect:/";
    }

    @PostMapping("/delete/{linkId}")
    public String delete(@PathVariable long linkId, RedirectAttributes redirectAttributes) {
        linkRepository.deleteById(linkId);
        redirectAttributes.addAttribute("deleted", true);
        return "redirect:/";
    }
}
