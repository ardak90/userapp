package kz.technodom.app.dao;

import kz.technodom.app.dto.StatusDto;
import kz.technodom.app.model.Status;

import java.util.List;

/**
 * Created by ardak on 9/27/17.
 */
public interface StatusDao {

    StatusDto persistStatus(StatusDto statusDto);
    StatusDto getPreviousStatus(String userId);
    List<StatusDto> getListByStatus(Status.Condition condition);
    List<StatusDto> getAll();
}
