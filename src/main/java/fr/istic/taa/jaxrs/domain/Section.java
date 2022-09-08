package fr.istic.taa.jaxrs.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Section implements Serializable {

    private Long id;
    private String name;
    private List<Card> cards;
    private List<Board> boards;


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

    @OneToMany(mappedBy = "section")
    @JsonIgnore
    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @ManyToMany
    @JsonIgnore
    public List<Board> getBoards() {
        return boards;
    }

    public void setBoards(List<Board> borads) {
        this.boards = borads;
    }


    public void contains(Card card){
        this.cards.add(card);
        card.setSection(this);
    }
    @Override
    public String toString() {
        return "Section [id=" + id + ", name=" + name +"]";
    }
}
