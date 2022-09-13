package ru.mkanin.screenshot_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mkanin.screenshot_service.entities.Screenshot;

import java.util.Optional;

public interface ScreenshotRepository extends JpaRepository<Screenshot, Long> {
    Optional<Screenshot> findById(String id);
}