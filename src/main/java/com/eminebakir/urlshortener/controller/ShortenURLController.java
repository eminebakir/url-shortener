package com.eminebakir.urlshortener.controller;

import com.eminebakir.urlshortener.service.ShortenUrlService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ShortenURLController {

    private ShortenUrlService shortenUrlService;

    public ShortenURLController(ShortenUrlService shortenUrlService) {
        this.shortenUrlService = shortenUrlService;
    }

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String loadIndex(Model model) {
        model.addAttribute("urls",shortenUrlService.getAllshortenurls());
        return "urlshortener";
    }


    //handler method to handle list url and return and view
    @GetMapping("/shortenerurl/delete/{id}")
    public String deleteUrl(@PathVariable long id){
        shortenUrlService.deleteUrlById(id);
        return "redirect:/";
    }

    

}
