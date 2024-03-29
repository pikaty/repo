package domain;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="contact")
public class Contact implements Serializable {
    private Long id;
    private int version;
    private String firstName;
    private String lastName;
    private DateTime birthDate;
    private String description;
    private byte[] photo;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    public Long getId(){
        return id;
    }

    @Version
    @Column(name = "VERSION")
    public int getVersion(){
        return version;
    }

    @NotEmpty(message="{validation.firstname.NotEmpty.message}")
    @Size(min=3, max=60, message="{validation.firstname.Size.message}")
    @Column(name = "FIRST_NAME")
    public String getFirstName(){
        return firstName;
    }

    @NotEmpty(message="{validation.lastname.NotEmpty.message}")
    @Size(min=1, max=40, message="{validation.lastname.Size.message}")
    @Column(name = "LAST_NAME")
    public String getLastName(){
        return lastName;
    }

    @Column(name = "BIRTH_DATE")
    //@Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    public DateTime getBirthDate(){
        return birthDate;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription(){
        return description;
    }

    @Basic(fetch=FetchType.LAZY)
    @Lob @Column(name = "PHOTO")
    public byte[] getPhoto(){
        return photo;
    }

    @Transient
    public String getBirthDateString(){
        String birthDateString = "";
        if (birthDate != null)
            birthDateString = org.joda.time.format.DateTimeFormat.forPattern("yyyy-MM-dd").print(birthDate);

        return birthDateString;
    }

    public String toString(){
        return "Contact - ID: " + id + ", First name: " + firstName + ", Last name: "
                + lastName + ", Birthday: " + birthDate + ", Description: " + description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(DateTime birthDate) {
        this.birthDate = birthDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
