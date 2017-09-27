package kz.technodom.app.dto;

import kz.technodom.app.model.User;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ardak on 9/21/17.
 */
public class UserDto {

    public Long id;
    public String personalId;
    public String name;
    public String email;
    public String imageUrl;

    public static UserDto fromUser(User u){
        UserDto user = new UserDto();
        user.id = u.getId();
        user.name = u.getName();
        user.email = u.getEmail();
        user.imageUrl = u.getImageUrl();
        user.personalId = u.getPersonalId();
        return user;
    }

    public static User toUser(UserDto u){
        if(u==null){
            return null;
        }
        else {
            User user = new User();
            user.setPersonalId(u.personalId);
            user.setName(u.name);
            user.setEmail(u.email);
            user.setImageUrl(u.imageUrl);
            user.setId(u.id);
            return user;
        }
    }

    public static List<UserDto> fromUsers(List<User> users){
        return users.stream().map(u -> fromUser(u)).collect(Collectors.toList());
    }
}
