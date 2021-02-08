package models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import javax.persistence.*;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Entity
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Le nom ne peut pas être vide !")
    @Basic(optional = false)
    @Column
    private String nom;

    @NotBlank(message = "La rue ne peut pas être vide !")
    @Basic(optional = false)
    @Column
    private String rue;

    @NotBlank(message = "Le code postal ne peut pas être vide !")
    @Basic(optional = false)
    @Column
    private String codePostal;

    @NotBlank(message = "La ville ne peut pas être vide !")
    @Basic(optional = false)
    @Column
    private String ville;

    @NotBlank(message = "Le numéro de téléphone ne peut pas être vide !")
    @Basic(optional = false)
    @Column
    private String num_telephone;

    @NotBlank(message = "Le siret ne peut pas être vide !")
    @Basic(optional = false)
    @Column
    private String num_siret;

    //relation entre voiture et garage
    @OneToMany(mappedBy = "garageCar")
    private List<Car> cars;

    public void addColor(Car c){
        this.cars.add(c);
    }

    public void removeColor(Car c){
        this.cars.remove(c);
    }

    public List<Car> getCars(){
        return this.cars;
    }
    //fin relation entre voiture et garage

    //relation entre user et garage
    @OneToMany(mappedBy = "garage")
    private List<User> users;

    private Garage(){
        this.users = Collections.emptyList();
        this.cars = Collections.emptyList();
    }

    public void addUser(User u){
        this.users.add(u);
    }

    public void removeUser(User u){
        this.users.remove(u);
    }

    public List<User> getUsers(){
        return this.users;
    }
    //fin relation entre user et garage

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getNum_telephone() {
        return num_telephone;
    }

    public void setNum_telephone(String num_telephone) {
        this.num_telephone = num_telephone;
    }

    public String getNum_siret() {
        return num_siret;
    }

    public void setNum_siret(String num_siret) {
        this.num_siret = num_siret;
    }
}
