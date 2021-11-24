package org.maxvas.factorapp.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Идентификатор проведенного среза или анализа
 */
@Document(collection = "statistics")
@Data
public class Statistics {
    private String id;
    private String description;
    private Date analysisDate;
}
