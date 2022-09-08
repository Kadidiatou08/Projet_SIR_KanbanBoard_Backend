package fr.istic.taa.jaxrs.services;

import fr.istic.taa.jaxrs.dao.implement.UserDao;
import fr.istic.taa.jaxrs.domain.User;

import java.util.List;
import java.util.Optional;

public class UserService {

    UserDao userDao;

    public UserService(){
        userDao = new UserDao();
    }

    public List<User> getAll(){
        return userDao.findAll();
    }

    public User find(Long id){
        User result = userDao.findOne(id);
        return result;
    }
    public boolean insert(User u){
         userDao.save(u);
         return true;
    }

    public boolean update(User u){
        userDao.update(u);
        return true;
    }

    public boolean delete(Long id){
        userDao.deleteById(id);
        return true;
    }
    /*
    public Optional<User> login(String email, String pwd){
        User userFound = userDao.findByEmailAndPwd(email,pwd);

        if(userFound == null){
            return Optional.ofNullable(userFound);
        }

        return  Optional.of(userFound);
    }
    */

    public User login(String email, String pwd){
        System.out.println("Le suis dans login service avant userFound");
        User userFound = userDao.findByEmailAndPwd(email,pwd);
        return  userFound;
    }

}
