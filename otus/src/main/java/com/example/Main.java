package com.example;

import java.util.ArrayList;
import objects.Animal;
import tables.AnimalTable;
import zoo.animal.AbsAnimal;
import zoo.animal.exceptons.AnimalNotSupported;
import zoo.data.AnimalData;
import zoo.data.ColorData;
import zoo.data.TeamsData;
import zoo.factory.AnimalFactory;
import zoo.utilit.EnamConvecters;
import zoo.utilit.Validators;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.validation.Validator;

public class Main{
    public static void main (String args[]) throws AnimalNotSupported{
        Scanner sc = new Scanner(System.in);
        Validators validators = new Validators();
        EnamConvecters enamConvecters =new EnamConvecters();
        List<AbsAnimal>animals=new ArrayList<>();
        AnimalTable animalTable=new AnimalTable();

        while (true) {
            System.out.println(String.format("Введите одну команду из %s",enamConvecters.getNamesEnam(TeamsData.class, "/")));
            String commandStr=  sc.next().toUpperCase().trim();

            if(!validators.checkValuesInEnam(TeamsData.class, commandStr)){
                System.out.println(String.format("Комманда %s некорректна,введение корректную команду", commandStr));
                continue;
            };
            TeamsData teamsData=TeamsData.valueOf(commandStr);
            switch(teamsData){
                case ADD:
                    {
                    String typeAnimalsStr ="";
                    while (true) {
                        System.out.println(String.format("Введите  тип животного  из %s",enamConvecters.getNamesEnam(AnimalData.class, "/")));
                        typeAnimalsStr = sc.next().toUpperCase().trim();

                        if(validators.checkValuesInEnam(AnimalData.class, typeAnimalsStr)){
                            break;
                        }
                        System.out.println(String.format("Данного вида  %s животного нет на этой ферме,выберите другой вид из ", typeAnimalsStr));
                        }

                        AbsAnimal animal = new AnimalFactory().create(AnimalData.valueOf( typeAnimalsStr));

                        animal.setName(sc);

                        animal.setAge(sc);

                        animal.setWeight(sc);

                        animal.setColor(sc);
                    
    //---------------------------- добавление в список и БД
                        animals.add(animal);
                        Animal animalDB=new Animal(typeAnimalsStr,animal.getName(),animal.getColorData(),animal.getWeight(),animal.getAge());

                        animalTable.insert(animalDB);

                        System.out.printf("животное %s внесено в БД \n", animal.getName());
                    }
                    break;
                case LIST:
                    {
                        for (AbsAnimal animal : animals) {
                            System.out.println(animal.toString());
                        }

                        ArrayList<Animal> animalsDB=animalTable.selectAllAnimals();
                        animalsDB=animalTable.selectAllAnimals();
                        for (Animal animal : animalsDB) {
                        System.out.println(animal.toString());
                        };
                        break;
                    }
                case ANIMALFILTER:
                    {
                        String filterTypeAnimal;
                        System.out.println(String.format("Введите  тип животных  из %s",enamConvecters.getNamesEnam(AnimalData.class, "/")));
                        filterTypeAnimal = sc.next().toUpperCase().trim();
                
                        if(validators.checkValuesInEnam(AnimalData.class, filterTypeAnimal))
                            {
                                ArrayList<Animal> animalsDbFilret=animalTable.selectAnimalType(filterTypeAnimal);
                                animalsDbFilret=animalTable.selectAnimalType(filterTypeAnimal);
                                for (Animal animal : animalsDbFilret) {
                                System.out.println(animal.toString());
                                }
                            
                            };
                            break;
                    }
                    
                case UPDATE:
                    {   
                        int idUpdateNew;
                        while (true) {
                            System.out.println("Введите номер id, целое положительное число");
                            String idUpdate=sc.next();
                            if (validators.isAgeNimbers(idUpdate)&&Integer.parseInt(idUpdate)>=0){
                                idUpdateNew= Integer.parseInt(idUpdate);
                                break;
                            }
                            System.out.println("не корректрый id");
                        }
                        String newName="";
                        while (true) {
                            System.out.println("Введите новое имя ");
                            newName=sc.next();
                            if (validators.isStringChars(newName)){
                                break;
                            }
                            System.out.println("Введите имя буквами");
                        }
                        AbsAnimal animalNewNAme= animals.get(idUpdateNew);
                        animalNewNAme.setName(newName);
                        Animal animal=new Animal(animalNewNAme.getTypa(),newName,animalNewNAme.getColorData(),animalNewNAme.getWeight(),animalNewNAme.getAge());
                        animalTable.update(animal);
                    }
                case EXIT:{
                    System.exit(0);
                }
                case DELETE:{

                }
            }
        }
        //animalTable.update(animalTable, 2);
        // AnimalTable animalTable=new AnimalTable();
                // ArrayList<Animal> animals=animalTable.selectAllAnimals();
                //     if (animals.isEmpty()) {
                //     animalTable.insert(new Animal(animalDB));
                //     animals=animalTable.selectAllAnimals();
                //     }
                }
                
}
    
    

