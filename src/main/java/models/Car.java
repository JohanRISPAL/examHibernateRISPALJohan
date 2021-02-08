package models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "La marque ne peut pas être blanc !")
    @Basic(optional = false)
    @Column
    private String marque;

    @NotBlank(message = "Le modele ne peut pas être blanc !")
    @Basic(optional = false)
    @Column
    private String modele;

    @NotBlank(message = "Le carburant ne peut pas être blanc !")
    @Basic(optional = false)
    @Column
    private String carburant;

    @NotBlank(message = "L'année ne peut pas être blanc !")
    @Basic(optional = false)
    @Column
    private Integer annee;

    @NotBlank(message = "Le kilometrage ne peut pas être blanc !")
    @Basic(optional = false)
    @Column
    private Integer kilometrage;

    @NotBlank(message = "Le prix ne peut pas être blanc !")
    @Basic(optional = false)
    @Column
    private Integer prix;

    @NotBlank(message = "La date_d'ajout ne peut pas être blanc !")
    @Basic(optional = false)
    @Column
    private Date date_ajout;

    @NotBlank(message = "La description ne peut pas être blanc !")
    @Basic(optional = false)
    @Type(type="text")
    @Column
    private String description;

    //relation entre voiture et garage
    @ManyToOne(optional = true)
    @JoinColumn(name = "garage_id", referencedColumnName = "id")
    private Garage garageCar;

    public Garage getGarage() {
        return this.garageCar;
    }

    public void setGarage(Garage g){
        this.garageCar = g;
    }
    //fin relation entre voiture et garage

    //relation entre voiture et couleur
    @ManyToMany
    @JoinTable(
            name = "color_car",
            joinColumns = {@JoinColumn(name = "car_id")},
            inverseJoinColumns = {@JoinColumn(name = "color_id")}
    )
    private List<Color> colors;

    public Car(Integer id, @NotNull(message = "Le champ nom ne peut pas être null") @NotBlank(message = "Le champ ne peut pas être blanc !") String marque, String modele, String carburant, Integer annee, Integer kilometrage, Integer prix, Date date_ajout, String description, Garage garageCar) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.carburant = carburant;
        this.annee = annee;
        this.kilometrage = kilometrage;
        this.prix = prix;
        this.date_ajout = date_ajout;
        this.description = description;
        this.garageCar = garageCar;
        this.colors = Collections.emptyList();
    }

    public void addColor(Color c){
        this.colors.add(c);
    }

    public void removeColor(Color c){
        this.colors.remove(c);
    }

    public List<Color> getColors(){
        return this.colors;
    }
    //fin relation entre voiture et couleur

    public Car(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public Integer getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(Integer kilometrage) {
        this.kilometrage = kilometrage;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public Date getDate_ajout() {
        return date_ajout;
    }

    public void setDate_ajout(Date date_ajout) {
        this.date_ajout = date_ajout;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return marque;
    }
}
