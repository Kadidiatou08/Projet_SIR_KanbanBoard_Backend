package fr.istic.taa.jaxrs.dao.implement;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.dao.generic.EntityManagerHelper;
import fr.istic.taa.jaxrs.domain.User;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDao extends AbstractJpaDao<Long, User> {

   protected EntityManager em;

    public UserDao() {
        super(User.class);
        this.em = EntityManagerHelper.getEntityManager();
    }

    public User findByEmailAndPwd(String email, String pwd){
        List<User> users = em.createQuery("select u from User u where u.email = :email and u.password = :pwd", User.class)
                .setParameter("email",email)
                .setParameter("pwd",pwd)
                .getResultList();

        return users.isEmpty() ? null : users.remove(0);

    }

}
