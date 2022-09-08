package fr.istic.taa.jaxrs.utlis;

import fr.istic.taa.jaxrs.dao.implement.BoardDao;
import fr.istic.taa.jaxrs.dao.implement.SectionDao;
import fr.istic.taa.jaxrs.dao.implement.UserDao;
import fr.istic.taa.jaxrs.domain.Board;
import fr.istic.taa.jaxrs.domain.Section;
import fr.istic.taa.jaxrs.domain.User;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Utils {

    static UserDao userDao = new UserDao();
    static SectionDao sectionDao = new SectionDao();
    static BoardDao boardDao = new BoardDao();

    public static Optional<User> userExist(Long id){
        User userSearched = userDao.findOne(id);
        if(userSearched == null){
            return Optional.of(null);
        }

        return Optional.of(userSearched);
    }

    public static List<User> usersListExist(List<Long> ids){
        User userSearched;
        List<User> usersFound = new ArrayList<>();
        for(long id : ids){
            userSearched = userDao.findOne(id);
            if(userSearched != null){
                usersFound.add(userSearched);
            }
        }
        return usersFound;
    }

    public static Optional<Section> sectionExist(Long id){
        System.out.println("sectionExist "+ id);
        Section sectionSearched = sectionDao.findOne(id); //Pb sur le controle
        //sectionSearched.toString();
        if(sectionSearched == null){
            return Optional.of(null);
        }
        return Optional.of(sectionSearched);
    }

    public static List<Section> sectionListExist(List<Long> ids){
        Section sectionSearched;
        List<Section> sectionFound = new ArrayList<>();
        for(long id : ids){
            sectionSearched = sectionDao.findOne(id);
            if(sectionSearched != null){
                sectionFound.add(sectionSearched);
            }
        }
        return sectionFound;
    }

    public static Optional<Board> boardExist(Long id){
        Board boardSearched = boardDao.findOne(id);
        if(boardSearched == null){
            return Optional.of(null);
        }
        return Optional.of(boardSearched);
    }

}
