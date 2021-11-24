package org.maxvas.factorapp.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Map;

@Document(collection = "factors")
@Data
public class Factor {
    @Id
    private String id;

    /**
     * Идентификтор Article._id
     */
    private String articleId;

    /**
     * Дата публикации.
     */
    private LocalDate date;

    /**
     * Ссылка на статью.
     */
    private String link;


    /**
     * Данные по статистикам
     */
    private Map<String, Stat> stats;
}
