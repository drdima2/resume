package net.devstudy.resume.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="skill")
public class Skill extends AbstractEntity<Long> implements Serializable, ProfileEntity {


    private static final long serialVersionUID = -4514463570928285225L;

    @Id
    @SequenceGenerator(name="SKILL_ID_GENERATOR",sequenceName = "SKILL_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SKILL_ID_GENERATOR")
    @Column(unique = true,nullable = false)
    private Long id;


    @Column (nullable = false, length = 50)
    private String categoy;

    @Column(nullable = false, length = 2147483647)
    private String value;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profile",nullable = false)
    private Profile profile;


    public Skill(){
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "categoy")
    public String getCategoy() {
        return categoy;
    }

    public void setCategoy(String categoy) {
        this.categoy = categoy;
    }

    @Basic
    @Column(name = "value")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Skill skill = (Skill) o;

        if (id != null ? !id.equals(skill.id) : skill.id != null) return false;
        if (categoy != null ? !categoy.equals(skill.categoy) : skill.categoy != null) return false;
        if (value != null ? !value.equals(skill.value) : skill.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (categoy != null ? categoy.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
