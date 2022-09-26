package Animals;

import Field.Field;
import Field.Location;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Predator extends Animal{
    protected int foodLevel;

    public Predator(boolean startWithRandomAge, int maxAge){
        super(startWithRandomAge, maxAge);
        if(startWithRandomAge){
            foodLevel = (int)(Math.random()*Rabbit.getFoodValue());
        }
    }
    public void act(Field currentField, Field updatedField, ArrayList<Animal> Animals){
        System.out.println("this shouldn't happen");
    }
//    protected Location findFood(Field field, Location location) {
//        List<Location> adjacentLocations = field.adjacentLocations(location);
//
//        for (Location where : adjacentLocations) {
//            Object animal = field.getObjectAt(where);
//            if(isEdible(animal)){
//                Animal animal1 = (Animal) animal;
//                if (animal1.isAlive()){
//                    animal1.setEaten();
//                }
//            }
//        }
//        return null;
//    }
//    private boolean isEdible(Object animal){
//        for(int i = 0; i < consumables.size(); i++){
//            Class a = consumables.get(i);
//            if(animal.getClass().equals(a)) return true;
//        }
//        return false;
//    }

    public void setFoodLevel(int fl) {
        this.foodLevel = fl;
    }
    protected void incrementHunger() {
        foodLevel--;
        if (foodLevel <= 0) {
            alive = false;
        }
    }
}
