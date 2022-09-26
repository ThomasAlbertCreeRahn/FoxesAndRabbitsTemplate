package Animals;

import Animals.*;
import Field.*;
import Graph.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple model of a fox. Foxes age, move, eat rabbits, and die.
 * 
 * @author David J. Barnes and Michael Kolling.  Modified by David Dobervich 2007-2022
 */
public class Fox extends Predator{
	private static final int MAX_AGE = 100;
	private static int FOOD_VALUE = 6;
	public static int getFoodValue(){
		return FOOD_VALUE;
	}
	// ----------------------------------------------------
	// Characteristics shared by all foxes (static fields).
	// ----------------------------------------------------
	// A shared random number generator to control breeding.

	// -----------------------------------------------------
	// Individual characteristics (attributes).
	// -----------------------------------------------------
	// The fox's age.
	// The fox's position
	// The fox's food level, which is increased by eating rabbits.


	/**
	 * Create a fox. A fox can be created as a new born (age zero and not
	 * hungry) or with random age.
	 * 
	 * @param startWithRandomAge
	 *            If true, the fox will have random age and hunger level.
	 */
	public Fox(boolean startWithRandomAge) {
		super(startWithRandomAge, MAX_AGE);
		FOOD_VALUE = 6;
		BREEDING_AGE = 3;
		MAX_LITTER_SIZE = 4;
		BREEDING_PROBABILITY = 0.1;
	}

	/**
	 * This is what the fox does most of the time: it hunts for rabbits. In the
	 * process, it might breed, die of hunger, or die of old age.
	 * 
	 * @param currentField
	 *            The field currently occupied.
	 * @param updatedField
	 *            The field to transfer to.
	 * @param babyFoxStorage
	 *            A list to add newly born foxes to.
	 */
	public void act(Field currentField, Field updatedField, ArrayList<Animal> babyFoxStorage) {
		incrementAge();
		incrementHunger();
		if (alive) {
			// New foxes are born into adjacent locations.
			int births = breed();
			for (int b = 0; b < births; b++) {
				Fox newFox = new Fox(false);
				newFox.setFoodLevel(this.foodLevel);
				babyFoxStorage.add(newFox);
				Location loc = updatedField.randomAdjacentLocation(location);
				newFox.setLocation(loc);
				updatedField.put(newFox, loc);
			}
			// Move towards the source of food if found.
			Location newLocation = findFood(currentField, location);
			if (newLocation == null) { // no food found - move randomly
				newLocation = updatedField.freeAdjacentLocation(location);
			}
			if (newLocation != null) {
				setLocation(newLocation);
				updatedField.put(this, newLocation);
			} else {
				// can neither move nor stay - overcrowding - all locations
				// taken
				alive = false;
			}
		}
	}

	/**
	 * Increase the age. This could result in the fox's death.
	 */

	/**
	 * Make this fox more hungry. This could result in the fox's death.
	 */

	/**
	 * Tell the fox to look for rabbits adjacent to its current location. Only
	 * the first live rabbit is eaten.
	 * 
	 * @param field
	 *            The field in which it must look.
	 * @param location
	 *            Where in the field it is located.
	 * @return Where food was found, or null if it wasn't.
	 */
	private Location findFood(Field field, Location location) {
		List<Location> adjacentLocations = field.adjacentLocations(location);

		for (Location where : adjacentLocations) {
			Object animal = field.getObjectAt(where);
			if (animal instanceof Rabbit) {
				Rabbit rabbit = (Rabbit) animal;
				if (rabbit.isAlive()) {
					rabbit.setEaten();
					foodLevel = Rabbit.getFoodValue();
					return where;
				}
			}
		}

		return null;
	}

	/**
	 * Generate a number representing the number of births, if it can breed.
	 * 
	 * @return The number of births (may be zero).
	 */

	/**
	 * A fox can breed if it has reached the breeding age.
	 */

	/**
	 * Check whether the fox is alive or not.
	 * 
	 * @return True if the fox is still alive.
	 */

	/**
	 * Set the animal's location.
	 * 
	 * @param row
	 *            The vertical coordinate of the location.
	 * @param col
	 *            The horizontal coordinate of the location.
	 */

	/**
	 * Set the fox's location.
	 * 
	 * @param location
	 *            The fox's location.
	 */
}
