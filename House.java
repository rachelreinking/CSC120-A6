/**
 * This creates a House that extends Building to be more specific
 * This keeps track of the names of all of the residents of the house and whether the house has a dining room
 * The residents can move in or out of the house
 * This class also has methods that are accessors for the resident roster, dining room status, and number of residents, 
 * and a method for whether or not a certain individual is a resident of the house
 * @author Rachel Reinking
 * @version 30 March 2023
 */

import java.util.ArrayList;

public class House extends Building {

  private ArrayList<String> residents;
  private boolean hasDiningRoom;

  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
  }

/** Accessor for hasDiningRoom */
public boolean hasDiningRoom() {
  return this.hasDiningRoom;
}

/** Accessor for number of residents */
public int nResidents() {
  return this.residents.size();
}

/**
 * This method moves a person into a house as long as they are not already moved into the house
 * @param name The name of the person
 */
public void moveIn(String name) {
  //check if this.residents contains name
  if(this.residents.contains(name)) {
    //  if so: throw an exception
    throw new RuntimeException(name + " is already a resident of " + this.name);
  }
  //append name to this.residents
  this.residents.add(name);
}

/**
 * This method moves a person out of a house as long as they are not already moved out of the house
 * @param name 
 * @return The name of the person who moved out
 */
public String moveOut(String name) {
  if(!this.residents.contains(name)) {
    throw new RuntimeException(name + "does not live in this house");
  }
  this.residents.remove(name);
  return name;
}

/**
 * This method tells us whether or not a given person is a resident of the specified House
 * @param person The name of the person
 * @return T/F: whether a not a person is a resident of the house
 */
public boolean isResident(String person) {
  return residents.contains(person);
}

  public static void main(String[] args) {
    
  }

}