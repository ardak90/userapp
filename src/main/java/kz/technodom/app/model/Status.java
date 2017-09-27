package kz.technodom.app.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ardak on 9/27/17.
 */

@Entity
@Table(name="app_status")
public class Status {

    @Id
    @Column(name="ID_")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="CREATED_DATE_", nullable = false)
    private Date createdDate;

    @Column(name="CONDITION_", nullable = false)
    private Condition condition;

    @ManyToOne
    @JoinColumn(name="USER_", nullable = false)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public enum Condition {
        ONLINE,
        OFFLINE
    }
}
