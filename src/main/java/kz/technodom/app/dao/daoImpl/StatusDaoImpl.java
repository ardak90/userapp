package kz.technodom.app.dao.daoImpl;

import kz.technodom.app.dao.StatusDao;
import kz.technodom.app.dto.StatusDto;
import kz.technodom.app.model.Status;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by ardak on 9/27/17.
 */

@Repository
public class StatusDaoImpl implements StatusDao {
    @PersistenceContext
    EntityManager em;

    @Override
    public StatusDto persistStatus(StatusDto statusDto) {
        Status status = StatusDto.toStatus(statusDto);
        StatusDto previousStatus = getPreviousStatus(statusDto.userDto.personalId);
        em.persist(status);
        StatusDto s = StatusDto.fromStatus(status);
        s.previousStatus = previousStatus;
        return s;
    }

    @Override
    public StatusDto getPreviousStatus(String userId){
        Query q = em.createQuery("SELECT s FROM Status s WHERE s.user.personalId = :username ORDER BY s.createdDate DESC").setParameter("username", userId);
        List<Status> statusList = q.getResultList();
        if(statusList.size()>0){
            return StatusDto.fromStatus(statusList.get(0));
        }
        return null;
    }

    @Override
    public List<StatusDto> getListByStatus(Status.Condition condition){
            Query q = em.createQuery("SELECT s FROM Status s WHERE s.condition = :condition ORDER BY s.createdDate DESC").setParameter("condition", condition);
            List<Status> statuses = q.getResultList();
            if(statuses.size()>0){
                return StatusDto.fromStatuses(statuses);
            }
            else return null;
    }
    @Override
    public List<StatusDto> getAll(){
        Query q = em.createQuery("SELECT s FROM Status s ORDER BY s.createdDate DESC");
        List<Status> statuses = q.getResultList();
        if(statuses.size()>0){
            return StatusDto.fromStatuses(statuses);
        }
        else return null;
    }
}
