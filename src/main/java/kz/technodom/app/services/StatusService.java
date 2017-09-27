package kz.technodom.app.services;

import kz.technodom.app.dao.StatusDao;
import kz.technodom.app.dao.UserDao;
import kz.technodom.app.dto.StatusDto;
import kz.technodom.app.dto.UserDto;
import kz.technodom.app.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by ardak on 9/27/17.
 */

@Transactional
@Service
public class StatusService {

    @Autowired
    StatusDao statusDao;

    @Autowired
    UserDao userDao;

    public StatusDto persistStatus(String status, String userId){
        UserDto user = userDao.findByUserId(userId);
        if(user!=null) {
            StatusDto s = new StatusDto();
            if (status.equalsIgnoreCase("online")) {
                s.condition = Status.Condition.ONLINE;
            } else if (status.equalsIgnoreCase("offline")) {
                s.condition = Status.Condition.OFFLINE;
            } else {
                return null;
            }
            s.createdDate = new Date();
            s.userDto = user;
            return statusDao.persistStatus(s);
        }
        return null;
    }

    public List<StatusDto> getListByStatus(String status){
        if(status.equalsIgnoreCase("online")){
            return statusDao.getListByStatus(Status.Condition.ONLINE);
        }
        if(status.equalsIgnoreCase("offline")){
            return statusDao.getListByStatus(Status.Condition.OFFLINE);
        }
        return null;
    }

    public List<StatusDto> getAll(){
        return statusDao.getAll();
    }
}

