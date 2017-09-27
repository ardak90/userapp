package kz.technodom.app.dto;

import kz.technodom.app.model.Status;
import kz.technodom.app.model.User;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ardak on 9/27/17.
 */
public class StatusDto {

    public Long id;
    public Date createdDate;
    public Status.Condition condition;
    public UserDto userDto;
    public StatusDto previousStatus;

    public static StatusDto fromStatus(Status s){
        StatusDto status = new StatusDto();
        status.id = s.getId();
        status.createdDate = s.getCreatedDate();
        status.condition = s.getCondition();
        status.userDto = UserDto.fromUser(s.getUser());
        return status;
    }

    public static Status toStatus(StatusDto s){
        if(s==null){
            return null;
        }
        else {
            Status status = new Status();
            status.setId(s.id);
            status.setCondition(s.condition);
            status.setCreatedDate(s.createdDate);
            status.setUser(UserDto.toUser(s.userDto));
            return status;
        }
    }

    public static List<StatusDto> fromStatuses(List<Status> statuses){
        return statuses.stream().map(s -> fromStatus(s)).collect(Collectors.toList());
    }

}
