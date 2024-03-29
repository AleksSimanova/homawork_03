package com.example;

import java.util.ArrayList;
import objects.Animal;
import tables.AnimalTable;
public class Main {
    public static void main(String[] args) {

        AnimalTable animalTable=new AnimalTable();
        ArrayList<Animal> animals=animalTable.selectAllAnimals();
        if (animals.isEmpty()) {
            animalTable.insert(new Animal("кошка", "бфрсик", "hfhf", 2, 2));
            animals=animalTable.selectAllAnimals();
        }

        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }
}