package net.devstudy.resume.entity;

import net.devstudy.resume.model.LanguageLevel;
import net.devstudy.resume.model.LanguageType;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="language")
public class Language extends AbstractEntity<Long> implements Serializable, ProfileEntity {

    private static final long serialVersionUID = -1L;


    @Id
    @SequenceGenerator(name = "LANGUAGE_ID_GENERATOR",sequenceName = "LANGUAGE_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "LANGUAGE_ID_GENERATOR")
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    @Convert(converter = LanguageLevel.PersistJPAConverter.class)
    private LanguageLevel level;








    @Column(nullable = false, length = 30)
    private String name;


    @Column(nullable = false)
    @Convert(converter = LanguageType.PersistJPAConverter.class)
    private LanguageType type;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profile",nullable = false)
    private Profile profile;



    public Language(){

    }

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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;

    }


    public LanguageLevel getLevel() {
        return level;
    }

    public void setLevel(LanguageLevel level) {
        this.level = level;
    }

    public LanguageType getType() {
        return type;
    }

    public void setType(LanguageType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Language language = (Language) o;

        if (!id.equals(language.id)) return false;
        if (level != language.level) return false;
        if (!name.equals(language.name)) return false;
        return type == language.type;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + level.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }
}
