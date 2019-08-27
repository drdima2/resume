package net.devstudy.resume.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "course")
public class Course extends AbstractFinishDateEntity<Long> implements Serializable,ProfileEntity {

    private static final long serialVersionUID = 5094096434661299368L;

    @Id
    @SequenceGenerator(name="COURSE_ID_GENERATOR",sequenceName = "COURSE_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "COURSE_ID_GENERATOR")
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(length = 60)
    private String name;

    @Column(length = 60)
    private String school;




    // bi-directional many-to-one assosiation to Profile
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profile",nullable = false)
    private Profile profile;


    @Column(name="start_date", nullable = false)
    private Date startDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
