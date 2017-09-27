package kz.technodom.app.controllers;

import kz.technodom.app.dto.StatusDto;
import kz.technodom.app.services.StatusService;
import kz.technodom.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by ardak on 9/27/17.
 */
@RestController
@RequestMapping(value = "/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @RequestMapping(value = "/{status}/{userId}", method = RequestMethod.GET)
    public ResponseEntity persistStatus(@PathVariable String status, @PathVariable String userId){
        StatusDto s = statusService.persistStatus(status, userId);
        if(s!=null){
            return new ResponseEntity(s, HttpStatus.OK);
        }
        else {
            return new ResponseEntity("Something Wrong. User not found or u gave wrong status", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{status}", method = RequestMethod.GET)
    public ResponseEntity getListByStatus(@PathVariable String status){
        List<StatusDto> s = statusService.getListByStatus(status);
        if(s!=null){
            return new ResponseEntity(s, HttpStatus.OK);
        }
        else {
            return new ResponseEntity("Nothind found", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll(){
        List<StatusDto> s = statusService.getAll();
        if(s!=null){
            return new ResponseEntity(s, HttpStatus.OK);
        }
        else {
            return new ResponseEntity("Nothind found", HttpStatus.BAD_REQUEST);
        }
    }

}
