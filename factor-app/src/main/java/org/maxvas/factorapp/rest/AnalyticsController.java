package org.maxvas.factorapp.rest;

import lombok.AllArgsConstructor;
import org.maxvas.factorapp.repository.ArticleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/analitics")
@AllArgsConstructor
public class AnalyticsController {

    final ArticleRepository articleRepository;

    @GetMapping(value = "/test")
    public String test(){
        return "Analytics controller test";
    }

    @GetMapping(value = "/count")
    public String count(){
        return "Articles count: ".concat(String.valueOf(articleRepository.count()));
    }

}
