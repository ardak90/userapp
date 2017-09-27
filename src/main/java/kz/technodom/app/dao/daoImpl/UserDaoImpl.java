package kz.technodom.app.dao.daoImpl;

import kz.technodom.app.dao.UserDao;
import kz.technodom.app.dto.UserDto;
import kz.technodom.app.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by ardak on 9/22/17.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public UserDto findByUserId(String id) {

        Query q = em.createQuery("SELECT u FROM User u WHERE u.personalId = :username", User.class).setParameter("username", id);
        if(q.getResultList().size()>0) {
            User user = (User) q.getSingleResult();
            if (user != null) {
                return UserDto.fromUser(em.find(User.class, user.getId()));
            }
        }
        return null;
    }

    @Override
    public UserDto persistUser(UserDto user) {
        User u = UserDto.toUser(user);
        em.persist(u);
        return UserDto.fromUser(u);
    }
}
