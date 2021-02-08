package models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;

    @NotBlank(message = "Le username ne peut pas être blanc !")
    @Basic(optional = false)
    @Column
    private String username;

    @NotBlank(message = "Le role ne peut pas être blanc !")
    @Type(type="text")
    @Basic(optional = false)
    @Column
    private String roles;

    @NotBlank(message = "Le mot de passe ne peut pas être blanc !")
    @Basic(optional = false)
    @Column
    private String password;

    @NotBlank(message = "L'email ne peut pas être blanc !")
    @Basic(optional = false)
    @Email
    @Column
    private String email;

    @NotBlank(message = "Le nom ne peut pas être blanc !")
    @Basic(optional = false)
    @Column
    private String nom;

    @NotBlank(message = "Le prenom ne peut pas être blanc !")
    @Basic(optional = false)
    @Column
    private String prenom;

    @NotBlank(message = "Le numéro de téléphone ne peut pas être blanc !")
    @Basic(optional = false)
    @Column
    private String num_telephone;

    //relation entre user et garage
    @ManyToOne(optional = true)
    @JoinColumn(name = "garage_id", referencedColumnName = "id")
    private Garage garage;
    //fin relation entre user et garage

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNum_telephone() {
        return num_telephone;
    }

    public void setNum_telephone(String num_telephone) {
        this.num_telephone = num_telephone;
    }
}
