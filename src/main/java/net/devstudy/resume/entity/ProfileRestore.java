package net.devstudy.resume.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "profile")
public class ProfileRestore extends AbstractEntity<Long> implements Serializable {

    private static final long serialVersionUID = 5094096434661299368L;

    @Id
    @Column(unique = true, nullable = false)
    private Long id;



    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="id",nullable = false)
    private Profile profile;

    @Column(nullable = false, unique = true,length = 100)
    private String token;

    public ProfileRestore() {
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
