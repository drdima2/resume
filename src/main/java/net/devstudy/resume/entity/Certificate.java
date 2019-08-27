package net.devstudy.resume.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="certificate")
public class Certificate extends AbstractEntity<Long> implements Serializable, ProfileEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "CERTIFICATE_ID_GENERATOR",sequenceName = "CERTIFICATE_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CERTIFICATE_ID_GENERATOR")
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "large_url" , nullable = false, length = 255)
    private String largeUrl;


    @Column(name = "small_url" , nullable = false, length = 255)
    private String smallUrl;

    @Column(nullable = false, length = 255)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profile",nullable = false)
    private Profile profile;


    public Certificate() {
    }

    @Override
    public Long getId() {
        return this.id;
    }

    public String getLargeUrl() {
        return largeUrl;
    }

    public void setLargeUrl(String largeUrl) {
        this.largeUrl = largeUrl;
    }

    public String getSmallUrl() {
        return smallUrl;
    }

    public void setSmallUrl(String smallUrl) {
        this.smallUrl = smallUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
