package org.maxvas.factorapp.health;

import lombok.AllArgsConstructor;
import org.maxvas.factorapp.repository.ArticleRepository;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ArticleHealthIndicator implements HealthIndicator {

    private static final String HEALTH_DETAIL_ARTICLES_COUNT = "articlesCount";
    private final ArticleRepository articleRepository;

    @Override
    public Health health() {
        try {
            long count = articleRepository.count();
            if (count > 0) {
                return Health.up().status(Status.UP).withDetail(HEALTH_DETAIL_ARTICLES_COUNT, count).build();
            } else {
                return Health.unknown().status(Status.UNKNOWN).withDetail(HEALTH_DETAIL_ARTICLES_COUNT, count).build();
            }
        } catch (Exception exception) {
            return Health.down().status(Status.DOWN).build();
        }
    }
}
