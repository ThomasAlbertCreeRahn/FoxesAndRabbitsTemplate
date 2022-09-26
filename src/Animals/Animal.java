package Animals;

import Field.Field;
import Field.Location;

import java.util.ArrayList;

public class Animal {
    protected int maxAge = 0;
    protected int BREEDING_AGE;
    protected double BREEDING_PROBABILITY;
    protected int MAX_LITTER_SIZE;
    protected int age;
    protected Location location;
    protected boolean alive;
    public Animal(boolean startWithRandomAge, int maxAge){
        age = 0;
        alive = true;
        this.maxAge = maxAge;
        if(startWithRandomAge) {
            age = (int)(Math.random()*maxAge);
        }
    }
    protected void incrementAge()
    {
        age++;
        if(age > maxAge) {
            alive = false;
        }
    }
    protected int breed()
    {
        int births = 0;
        if(canBreed() && Math.random() <= BREEDING_PROBABILITY) {
            births = (int)(Math.random()*MAX_LITTER_SIZE) + 1;
        }
        return births;
    }
    public void act(Field a, Field b, ArrayList<Animal> Animals){
        System.out.println("bruh this is the wrong place");
    }
    private boolean canBreed()
    {
        return age >= BREEDING_AGE;
    }
    public boolean isAlive() {
        return alive;
    }
    public void setLocation(int row, int col) {
        this.location = new Location(row, col);
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public void setEaten(){
        alive = false;
    }

}
