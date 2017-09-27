package kz.technodom.app.dao;


import kz.technodom.app.dto.UserDto;

/**
 * Created by ardak on 9/21/17.
 */
public interface UserDao {

    UserDto findByUserId(String id);
    UserDto persistUser(UserDto user);

}
