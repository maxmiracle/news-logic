package org.maxvas.batchnews.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

/**
 * Статья.
 */
@Document(collection = "articles")
@Data
public class Article {

    @Id
    private String _id;
    /**
     * Дата публикации.
     */
    private LocalDate date;

    /**
     * Ссылка на статью.
     */
    private String link;

    /**
     * Заголовок статьи.
     */
    private String title;

    /**
     * Текст статьи.
     */
    private String text;

    /**
     * Дата импорта из интернета.
     */
    private LocalDate importDate;

    /**
     * Название источника информации.
     */
    private String dataSource;
}
