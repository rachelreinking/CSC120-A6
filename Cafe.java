/**
 * This creates a Cafe that extends Building to be more specific
 * This keeps track of the number of ounces of coffee, sugar packets, splashes of cream, and cups in the inventory of the store
 * A coffee can be sold that decreases the inventory of the cafe
 * The inventory can also be restocked if there are insufficient amounts to make the coffee being sold
 * @author Rachel Reinking
 * @version 30 March 2023
 */

public class Cafe extends Building{

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: " + this.name);
    }
    
    /**
     * This method decreases the remaining inventory of the store based on the specifications of the coffee sold
     * Calls restock() method if necessary to restock inventory
     * @param size of drink in ounces of coffee
     * @param number of Sugar Packets
     * @param number of creams
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if(this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups < 1) {
            this.restock(size, nSugarPackets, nCreams, 1);
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
    }
    
    /**
     * This method increases the remaining inventory of the store based on what is needed based on the specifications of the coffee sold
     * @param number of ounces of coffee
     * @param number of sugar packets
     * @param number of creams
     * @param number of cups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    } 

    public static void main(String[] args) {
        
    }
    
}
