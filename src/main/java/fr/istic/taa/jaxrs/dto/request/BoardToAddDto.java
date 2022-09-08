package fr.istic.taa.jaxrs.dto.request;

import java.util.List;

public class BoardToAddDto {
    private String name;
    private List<Long> idSections;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getIdSections() {
        return idSections;
    }

    public void setIdSections(List<Long> idSections) {
        this.idSections = idSections;
    }
}
