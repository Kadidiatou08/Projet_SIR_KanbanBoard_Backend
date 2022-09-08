package fr.istic.taa.jaxrs.dto.request;

import fr.istic.taa.jaxrs.domain.Section;
import fr.istic.taa.jaxrs.domain.Tag;
import fr.istic.taa.jaxrs.domain.User;

import java.sql.Date;
import java.util.List;

public class CardToUpdateDto {
    private Long id;
    private String name;
    private String noteOfExplanation;
    private Double realizationTime;
    private String Location;
    private Date deadline;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNoteOfExplanation() {
        return noteOfExplanation;
    }

    public void setNoteOfExplanation(String noteOfExplanation) {
        this.noteOfExplanation = noteOfExplanation;
    }

    public Double getRealizationTime() {
        return realizationTime;
    }

    public void setRealizationTime(Double realizationTime) {
        this.realizationTime = realizationTime;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
