package fr.istic.taa.jaxrs.services;

import fr.istic.taa.jaxrs.dao.implement.CardDao;
import fr.istic.taa.jaxrs.dao.implement.UserDao;
import fr.istic.taa.jaxrs.domain.Card;
import fr.istic.taa.jaxrs.domain.Section;
import fr.istic.taa.jaxrs.domain.User;
import fr.istic.taa.jaxrs.dto.request.CardSectionDto;
import fr.istic.taa.jaxrs.dto.request.CardToAddDto;
import fr.istic.taa.jaxrs.dto.request.CardToUpdateDto;
import fr.istic.taa.jaxrs.dto.request.CardUserDto;
import fr.istic.taa.jaxrs.utlis.Utils;

import java.util.ArrayList;
import java.util.List;

public class CardService {
    CardDao cardDao;
    UserDao userDao;

    public CardService(){
        cardDao = new CardDao();
        userDao = new UserDao();
    }

    public List<Card> getAll(){

        return cardDao.findAll();
    }
    public Card find(Long id){

        return cardDao.findOne(id);
    }
    public boolean insert(CardToAddDto cartDto){

        User userSearched = Utils.userExist(cartDto.getIdUserCreated()).get();
        List<User> usersFound = Utils.usersListExist(cartDto.getIdUsersAssigned());
        Section sectionSearched = Utils.sectionExist(cartDto.getIdSection()).get();

        if(userSearched == null || sectionSearched == null ){
             return false;
        }

        Card card = new Card();
        card.setName(cartDto.getName());
        card.setNoteOfExplanation(cartDto.getNoteOfExplanation());
        card.setRealizationTime(cartDto.getRealizationTime());
        card.setLocation(cartDto.getLocation());
        card.setUserCreated(userSearched);
        card.setUsersAssigned(usersFound);
        card.setDeadline(cartDto.getDeadline()); // revoir ca
        card.setSection(sectionSearched);

        cardDao.save(card);


        return true;

    }

    public boolean update(CardToUpdateDto cardToUpdateDto){

        Card card = cardDao.findOne(cardToUpdateDto.getId());
        if(card == null){
            return false;
        }
        card.setName(cardToUpdateDto.getName());
        card.setNoteOfExplanation(cardToUpdateDto.getNoteOfExplanation());
        card.setRealizationTime(cardToUpdateDto.getRealizationTime());
        card.setLocation(cardToUpdateDto.getLocation());
        card.setDeadline(cardToUpdateDto.getDeadline());

        cardDao.update(card);

        return true;

    }

    public boolean delete(Long id){
        cardDao.deleteById(id);
        return true;
    }

    public boolean changeSection(CardSectionDto cardSectionDto){
        Section section = Utils.sectionExist(cardSectionDto.getIdSection()).get();
        System.out.println(section.toString());
        Card card = cardDao.findOne(cardSectionDto.getIdCard());

        if(section == null || card == null){
            return false;
        }
        card.setSection(section);
        cardDao.update(card);
        return true;
    }

    public boolean userToCard(CardUserDto cardUserDto, boolean assigned){
        Card card = cardDao.findOne(cardUserDto.getIdCard());
        List<User> usersFound = Utils.usersListExist(cardUserDto.getIdUsersAssigned());

        if(usersFound.isEmpty() || card == null){
            return false;
        }
        List<User> usersCardAssigned = card.getUsersAssigned();// Attention revoir ca


        //Assigned new users to the card if assigned == true. Remove users to the cards if assigned == false

        if(assigned){
           // System.out.println("usersCardAssigned init");
            /*
            for(User u :usersCardAssigned){
                System.out.println(u.getId()+" "+u.getName());
            }
            System.out.println("usersFound");

             */
            for(User userFound : usersFound){
               // System.out.println(userFound.getId()+" "+userFound.getName());
                if(!usersCardAssigned.contains(userFound)){
                    System.out.println(userFound.getId()+" "+userFound.getName()+" n est pas dans la liste");
                    usersCardAssigned.add(userFound);
                }
                else{
                    System.out.println(userFound.getId()+" "+userFound.getName()+" est dans la liste");
                }
            }
            //System.out.println("usersCardAssigned final");
            /*
            for(User u :usersCardAssigned){
                System.out.println(u.getId()+" "+u.getName());
            }

             */
        }
        else{
            for(User userFound : usersFound){
                // System.out.println(userFound.getId()+" "+userFound.getName());
                if(!usersCardAssigned.contains(userFound)){
                    System.out.println(userFound.getId()+" "+userFound.getName()+" n est pas dans la liste");
                    //usersCardAssigned.add(userFound);
                }
                else{
                    System.out.println(userFound.getId()+" "+userFound.getName()+" est dans la liste");
                    usersCardAssigned.remove(userFound);
                }
            }
        }


       // card.setUsersAssigned(usersCard);
        cardDao.update(card);
        return true;
    }

    /*
    public boolean assignedUserToCard(CardUserDto cardUserDto){
        Card card = cardDao.findOne(cardUserDto.getIdCard());
        List<User> usersFound = Utils.usersListExist(cardUserDto.getIdUsersAssigned());
        List<User> usersCard;
        if(usersFound.isEmpty() || card == null){
            return false;
        }
        usersCard = card.getUsersAssigned();
        for(User user : usersFound){
            if(!usersCard.contains(user)){
                usersCard.add(user);
            }
        }
        card.setUsersAssigned(usersCard);
        cardDao.update(card);
        return true;
    }

    public boolean removedUserToCard(CardUserDto cardUserDto){
        Card card = cardDao.findOne(cardUserDto.getIdCard());
        List<User> usersFound = Utils.usersListExist(cardUserDto.getIdUsersAssigned());
        List<User> usersCard;
        if(usersFound.isEmpty() || card == null){
            return false;
        }
        usersCard = card.getUsersAssigned();
        for(User user : usersFound){
            if(!usersCard.contains(user)){
                usersCard.add(user);
                user.getCardsAssigned().remove(card);
            }
        }


    }

     */
}
