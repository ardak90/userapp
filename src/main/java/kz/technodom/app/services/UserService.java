package kz.technodom.app.services;


import kz.technodom.app.dao.UserDao;
import kz.technodom.app.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ardak on 9/22/17.
 */
@Transactional
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public UserDto findByUserId(String id){
        UserDto user = userDao.findByUserId(id);
        if(user!=null){
            return user;
        }
        return null;
    }

    public UserDto persistUser(UserDto user){
        return userDao.persistUser(user);
    }

}

