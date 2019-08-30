package net.devstudy.resume.entity;







import net.devstudy.resume.annotation.constraints.Adulthood;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="profile")
public class Profile extends AbstractEntity<Long> implements Serializable {


    private static final long serialVersionUID = -6195441619896070563L;

    @Id
    @SequenceGenerator(name="PROFILE_ID_GENERATOR",sequenceName = "PROFILE_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROFILE_ID_GENERATOR")
    @Column(unique = true, nullable = false)
    private Long id;


    @Column(name = "birth_day")
    private Date birthDay;


    @Column
    private String city;


    @Column
    private String country;

    @Column(name="first_name", nullable = false, length = 50)
    private String firstName;


    @Column(name="last_name", nullable = false, length = 50)
    private String lastName;


    @Column(length = 2147483647)
    private String objective;

    @Column(name="large_photo", length = 255)
    private String largePhoto;


    @Column(name="small_photo", length = 255)
    private String smallPhoto;




    @Column(length = 20)
    private String phone;

    @Column(length = 100)
    private String email;

    @Column
    private String info;

    @Column(length = 2147483647)
    private String summary;

    @Column(nullable = false, length = 100)
    private String uid;


    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false)
    private boolean completed;


    @Column(insertable = false)
    private Timestamp created;





    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Certificate> certificates;



    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @OrderBy("finishYear DESC, beginYear DESC, id DESC")
    private List<Education> educations;


    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @OrderBy("name ASC")
    private List<Hobby> hobbies;


    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Language> languages;

//    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
//    private List<Language> languages = new ArrayList<>();

//     @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
//    private List<Language> languages;




    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @OrderBy("finishDate DESC")
    private List<Practic> practics;


    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @OrderBy("id ASC")
    private List<Skill> skills;



    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @OrderBy("finishDate DESC")
    private List<Course> courses;


    @Embedded
    private Contacts contacts;


    public Profile(){
    }






    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getBirthDay() {
        return birthDay;
    }



    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }



    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }


    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getLargePhoto() {
        return largePhoto;
    }

    public void setLargePhoto(String largePhoto) {
        this.largePhoto = largePhoto;
    }

    public String getSmallPhoto() {
        return smallPhoto;
    }

    public void setSmallPhoto(String smallPhoto) {
        this.smallPhoto = smallPhoto;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public List<Practic> getPractics() {
        return practics;
    }

    public void setPractics(List<Practic> practics) {
        this.practics = practics;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Language> getLanguages() {
        System.out.println("getLanguages");
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }







}
