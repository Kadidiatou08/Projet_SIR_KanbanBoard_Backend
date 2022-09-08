package fr.istic.taa.jaxrs.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User implements Serializable {

    private Long id;
    private String name;
    private String email;
    private String password;
    private List<Card> cardsAssigned;
    private List<Card> cardsCreated;

    /*
    public User(){}
    public User(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
        cardsAssigned = new ArrayList<>();
        cardsCreated = new ArrayList<>();
    }

     */

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToMany(mappedBy = "usersAssigned")
    @JsonIgnore
    public List<Card> getCardsAssigned() {
        return cardsAssigned;
    }

    public void setCardsAssigned(List<Card> cardsAssigned) {
        this.cardsAssigned = cardsAssigned;
    }

    @OneToMany(mappedBy = "userCreated",cascade = CascadeType.REMOVE)
    @JsonIgnore
    public List<Card> getCardsCreated() {
        return cardsCreated;
    }

    public void setCardsCreated(List<Card> cardsCreated) {
        this.cardsCreated = cardsCreated;
    }

    public void isOwner(Card card){
        this.cardsCreated.add(card);
        card.setUserCreated(this);
    }

    public void isAssigned(Card card){
        this.cardsAssigned.add(card);
        card.getUsersAssigned().add(this);
    }
    /*
    @Override
    public int hashCode(){
       // int intId = ;
        return Math.toIntExact(this.id);
    }

     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId().equals(user.getId());
    }
}
