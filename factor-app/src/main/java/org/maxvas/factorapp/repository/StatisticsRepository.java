package org.maxvas.factorapp.repository;

import org.maxvas.factorapp.entity.Statistics;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StatisticsRepository  extends CrudRepository<Statistics, Integer> {
    List<Statistics> findAll();
}
