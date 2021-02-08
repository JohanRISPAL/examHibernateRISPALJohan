package models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Entity
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Le libelle ne peut pas être blanc !")
    @Basic(optional = false)
    @Column
    private String libelle;

    //relation entre voiture et couleur
    @ManyToMany(mappedBy = "colors")
    private List<Car> cars;

    public Color(){
        this.cars = Collections.emptyList();
    }

    public void addColor(Car c){
        this.cars.add(c);
    }

    public void removeColor(Car c){
        this.cars.remove(c);
    }

    public List<Car> getCars(){
        return this.cars;
    }
    //fin relation entre voiture et couleur

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
