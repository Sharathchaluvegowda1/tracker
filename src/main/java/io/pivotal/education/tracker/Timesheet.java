package io.pivotal.education.tracker;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.Objects;

public class Timesheet {
    @Id
    private Long id;
    private Long projectId;
    private Long userId;
    private LocalDate date;
    private Integer hours;

    public Timesheet() { }

    public Timesheet(Long projectId, Long userId, LocalDate date, Integer hours) {
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public Timesheet(Long id, Long projectId, Long userId, LocalDate date, Integer hours) {
        this.id = id;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public Long getId() {
        return id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public Long getUserId() {
        return userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public Integer getHours() {
        return hours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timesheet timesheet = (Timesheet) o;
        return id.equals(timesheet.id) &&
                projectId.equals(timesheet.projectId) &&
                userId.equals(timesheet.userId) &&
                date.equals(timesheet.date) &&
                hours.equals(timesheet.hours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectId, userId, date, hours);
    }

    @Override
    public String toString() {
        return "Timesheet{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", userId=" + userId +
                ", date=" + date +
                ", hours=" + hours +
                '}';
    }
}
