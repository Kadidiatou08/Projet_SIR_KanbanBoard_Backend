package fr.istic.taa.jaxrs.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Card implements Serializable {

    private Long id;
    private String name;
    private String noteOfExplanation;
    private Double realizationTime;
    private String Location;
    private List<User> usersAssigned;
    private User userCreated;
    private List<Tag> tags;
    private Date deadline;
    private Section section;


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

    @ManyToMany
    //@JsonIgnore
    public List<User> getUsersAssigned() {
        return usersAssigned;
    }

    public void setUsersAssigned(List<User> usersAssigned) {
        this.usersAssigned = usersAssigned;
    }

    @ManyToOne
    //@JsonIgnore
    public User getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(User userCreated) {
        this.userCreated = userCreated;
    }

    @ManyToMany(mappedBy = "cards")
    //@JsonIgnore
    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @ManyToOne
    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public void contains(Tag tag){
        this.tags.add(tag);
        tag.getCards().add(this);
    }
    @Override
    public String toString() {
        return "Card [id=" + id + ", name=" + name +"]";
    }
}
