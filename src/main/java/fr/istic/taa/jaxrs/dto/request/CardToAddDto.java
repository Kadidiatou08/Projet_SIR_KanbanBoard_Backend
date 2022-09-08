package fr.istic.taa.jaxrs.dto.request;

import java.sql.Date;
import java.util.List;

public class CardToAddDto {
    private String name;
    private String noteOfExplanation;
    private Double realizationTime;
    private String location;
    private List<Long> idUsersAssigned;
    private Long idUserCreated;
    private Date deadline; //
    private Long idSection;

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
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Long> getIdUsersAssigned() {
        return idUsersAssigned;
    }

    public void setIdUsersAssigned(List<Long> idUsersAssigned) {
        this.idUsersAssigned = idUsersAssigned;
    }

    public Long getIdUserCreated() {
        return idUserCreated;
    }

    public void setIdUserCreated(Long idUserCreated) {
        this.idUserCreated = idUserCreated;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Long getIdSection() {
        return idSection;
    }

    public void setIdSection(Long idSection) {
        this.idSection = idSection;
    }
}
