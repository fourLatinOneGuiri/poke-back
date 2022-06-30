package com.ironhack.pokeapp.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    private String name;
    private int age;
    private String hobby;
    private String photo;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "teams",
            joinColumns = @JoinColumn(name = "trainer_id"),
            inverseJoinColumns = @JoinColumn(name = "pokemon_id"))
    private List <Pokemon> pokemonList = new ArrayList<>();

    public Trainer(String name, int age, String hobby, String photo) {
        setName(name);
        setAge(age);
        setHobby(hobby);
        setPhoto(photo);

    }

    public Trainer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        if(photo == null || photo.equals("")) this.photo = "https://i.pinimg.com/564x/6f/f3/2d/6ff32de2ab1621cddf0e74b74f04fae9.jpg";
       else this.photo = photo;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public long getId() {
        return id;
    }

}
