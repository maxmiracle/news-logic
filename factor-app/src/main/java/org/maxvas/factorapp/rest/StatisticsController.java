package org.maxvas.factorapp.rest;

import lombok.AllArgsConstructor;
import org.maxvas.factorapp.entity.Statistics;
import org.maxvas.factorapp.service.StatisticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/statistics")
@AllArgsConstructor
public class StatisticsController {

    private final StatisticsService statisticsService;

    @GetMapping(value = "/")
    public List<Statistics> findAll(){
        return statisticsService.findAll();
    }

    @PutMapping(value = "/{word}")
    public String addStatistics(String word){
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync( () ->
                statisticsService.calculateStatistics(word));
        return "Process started";
    }
}
