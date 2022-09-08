package fr.istic.taa.jaxrs.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Board implements Serializable {

    private Long id;
    private String name;
    private List<Section> sections;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
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

    @ManyToMany(mappedBy = "boards") // ATTENTION SUIVRE ATTENTIVEMENT cascade = CascadeType.REMOVE
    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public void contains(Section section){
        this.sections.add(section);
        section.getBoards().add(this);
    }
}
