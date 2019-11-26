package io.pivotal.education.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/timesheets")
public class TimesheetController {
    private TimesheetRepository repository;

    public TimesheetController(TimesheetRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Timesheet> create(@RequestBody Timesheet timesheetToCreate) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(repository.save(timesheetToCreate));
    }
}
