package net.devstudy.resume.entity;


import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="hobby")
public class Hobby extends AbstractEntity<Long> implements Serializable, Comparable<Hobby>,ProfileEntity {

    @Id
    @SequenceGenerator(name = "HOBBY_ID_GENERATOR",sequenceName = "HOBBY_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "HOBBY_ID_GENERATOR")
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profile",nullable = false)
    private Profile profile;

    @Transient
    private boolean selected;


    public Hobby() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Hobby hobby = (Hobby) o;

        if (selected != hobby.selected) return false;
        if (!id.equals(hobby.id)) return false;
        return name.equals(hobby.name);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (selected ? 1 : 0);
        return result;
    }


    @Override
    public int compareTo(@NotNull Hobby o) {
        if (o==null || getName() == null){
            return 1;
        }
        else{
            return getName().compareTo(o.getName());
        }

    }

    @Override
    public String toString() {
        return String.format("Hobby [name=%s]",name);
    }
}
