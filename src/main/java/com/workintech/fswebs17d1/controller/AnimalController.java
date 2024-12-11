package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/workintech/animal")
public class AnimalController {
    private Map<Integer, Animal> animals;

    // @PostConstruct proje ayağa kalkarken içindeki işlemleri yapar
    @PostConstruct
    public void loadAll(){
        System.out.println("postconstruct çalıştı.");
        System.out.println("Hayvan eklendi");
        System.out.println("*******");
        this.animals = new HashMap<>();
        this.animals.put(1, new Animal(1, "Aslan"));
    }

    @GetMapping
    public List<Animal> getAnimals(){
        System.out.println("---animals get all triggered---");
        return new ArrayList<>(animals.values());
    }
    @GetMapping("{id}")
    public Animal getAnimal(@PathVariable int id){
        return this.animals.get(id);
    }

    @PostMapping
    public void addAnimals(@RequestBody Animal animal){
        this.animals.put(animal.getId(), animal);
    }

    @PutMapping("{id}")
    public Animal updateAnimal(@PathVariable int id, @RequestBody Animal newAnimal){
        this.animals.replace(id, newAnimal);
        return this.animals.get(id);
    }

    @DeleteMapping("{id}")
    public void deleteAnimal(@PathVariable int id){
        this.animals.remove(id);

    }

}
