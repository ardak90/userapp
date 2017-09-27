package kz.technodom.app.controllers;

import kz.technodom.app.dto.UserDto;
import kz.technodom.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ardak on 9/26/17.
 */

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "user/", method = RequestMethod.POST)
    public ResponseEntity persistUser(@RequestBody UserDto userDto){

        UserDto user = userService.persistUser(userDto);
        if(user!=null){
            return new ResponseEntity(user, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "user/{userId}", method = RequestMethod.GET)
    public ResponseEntity findByUserId(@PathVariable String userId){

        UserDto user = userService.findByUserId(userId);
        if(user!=null){
            return new ResponseEntity(user, HttpStatus.OK);
        }
        return new ResponseEntity("User not found", HttpStatus.BAD_REQUEST);
    }
}
