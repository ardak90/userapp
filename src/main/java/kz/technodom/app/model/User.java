package kz.technodom.app.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by ardak on 9/27/17.
 */
@Entity
@Table(name="app_user")
public class User implements Serializable {




    @Id
    @Column(name="ID_")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name="PERSONAL_ID",length = 50, unique = true, nullable = false)
    private String personalId;

    @Column(name="NAME_")
    private String name;

    @Column(name="EMAIL_")
    private String email;

    @Column(name="IMAGE_URL_")
    private String imageUrl;

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
