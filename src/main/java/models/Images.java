package models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import javax.persistence.*;

@Entity
public class Images {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Le nom ne peut pas être blanc !")
    @Basic(optional = false)
    @Column
    private String nom;

    //relation entre images et voiture
    @OneToOne(optional = true)
    private Car car;

    public Car getCar() {
        return this.car;
    }

    public void setCar(Car c){
        this.car = c;
    }
    //fin relation entre images et voiture

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
}
