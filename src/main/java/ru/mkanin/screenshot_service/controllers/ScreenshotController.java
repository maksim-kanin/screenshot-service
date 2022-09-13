package ru.mkanin.screenshot_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mkanin.screenshot_service.entities.Screenshot;
import ru.mkanin.screenshot_service.repository.ScreenshotRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static ru.mkanin.screenshot_service.JacksonUtils.asString;

@RestController
@RequestMapping("/screenshot")
public class ScreenshotController {
    @Autowired
    private ScreenshotRepository repository;

    @GetMapping(value = "/all", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAll() {
        List<Screenshot> screenshots = repository.findAll();
        return screenshots.isEmpty() ?
                responseWithBody(OK, "[]") :
                responseWithBody(OK, asString(screenshots));
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getById(@PathVariable("id") String id) {
        Optional<Screenshot> screenshot = repository.findById(id);
        return screenshot.isEmpty() ?
                responseWithBody(BAD_REQUEST, "Screenshot with id: " + id + " wasn't found in database!") :
                responseWithBody(OK, asString(screenshot.get()));
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@Valid @RequestBody Screenshot screenshot) {
        String id = screenshot.getId();
        if (repository.findById(id).isPresent()) {
            return responseWithBody(BAD_REQUEST, "Screenshot with id: " + id + " already present in database!");
        }
        repository.save(screenshot);
        return responseWithBody(CREATED, "Screenshot with id: " + id + " was successfully added!");
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id) {
        Optional<Screenshot> screenshot = repository.findById(id);
        if (screenshot.isEmpty()) {
            return responseWithBody(BAD_REQUEST, "Screenshot with id: " + id + " wasn't found in database!");
        }
        repository.delete(screenshot.get());
        return responseWithBody(OK, "Screenshot with id: " + id + " was successfully deleted!");
    }

    @GetMapping(value = "/delete/all")
    public ResponseEntity<String> deleteAll() {
        repository.deleteAll();
        return responseWithBody(OK, "");
    }

    private ResponseEntity<String> responseWithBody(HttpStatus status, String body) {
        return ResponseEntity.status(status).body(body);
    }
}
