package org.maxvas.factorapp.rest;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.maxvas.factorapp.entity.Factor;
import org.maxvas.factorapp.repository.FactorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/factor")
@AllArgsConstructor
@Slf4j
public class FactorController {
    final FactorRepository factorRepository;

    final MeterRegistry meterRegistry;

    final static private String GET_FACTOR_METRIC = "factors";
    final static private String STATUS_TAG = "status";
    final static private String STATUS_OK = "ok";
    final static private String STATUS_FAIL = "fail";


    @GetMapping(value = "/")
    public List<Factor> findAll() {
        Timer.Sample sample = Timer.start();
        try{
           List<Factor> list = factorRepository.findAll();
           sample.stop(meterRegistry.timer(GET_FACTOR_METRIC, STATUS_TAG, STATUS_OK));
           return list;
        }
        catch (Exception exception){
            log.error("Get all factors error.", exception);
            sample.stop(meterRegistry.timer(GET_FACTOR_METRIC, STATUS_TAG, STATUS_FAIL));
            throw exception;
        }
    }
}
