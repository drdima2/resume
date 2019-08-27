package net.devstudy.resume.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="education")
public class Education extends AbstractEntity<Long> implements Serializable, ProfileEntity {


    private static final long serialVersionUID = 528835192799491310L;


    @Id
    @SequenceGenerator(name = "EDUCATION_ID_GENERATOR",sequenceName = "EDUCATION_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "EDUCATION_ID_GENERATOR")
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, length = 255)
    private String faculty;


    @Column(nullable = false, length = 100)
    private String summary;


    @Column(nullable = false, length = 2147483647)
    private String university;




    @Column(name="begin_year", nullable = false)
    private Date beginYear;


    @Column(name="finish_year", nullable = false)
    private Date finishYear;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profile",nullable = false)
    private Profile profile;


    public Education() {
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Date getBeginYear() {
        return beginYear;
    }

    public void setBeginYear(Date beginYear) {
        this.beginYear = beginYear;
    }

    public Date getFinishYear() {
        return finishYear;
    }

    public void setFinishYear(Date finishYear) {
        this.finishYear = finishYear;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
