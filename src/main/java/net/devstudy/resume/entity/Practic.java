package net.devstudy.resume.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name="practic")
public class Practic extends AbstractFinishDateEntity<Long> implements Serializable, ProfileEntity {


    private static final long serialVersionUID = 6793209394959930006L;


    @Id
    @SequenceGenerator(name = "PRACTIC_ID_GENERATOR",sequenceName = "PRACTIC_SEQ",allocationSize = 1)
    private Long id;


    @Column(nullable = false, length = 2147483647)
    private String name;



    @Column(name="begin_date", nullable = false)
    private Date beginDate;

    @Transient
    private Integer beginDateMonth;

    @Transient
    private Integer beginDateYear;




    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profile",nullable = false)
    private Profile profile;


    @Override
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


    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
