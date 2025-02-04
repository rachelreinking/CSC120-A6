/**
 * This creates a Library that extends Building to be more specific
 * This keeps track of the names of all of the titles in the library's collection and whether they are available to be checked out
 * The titles can be added, removed, checked in, or checked out of the collection
 * This class also has methods that check whether a collection has a title, whether the title is available, and
 * and can print a full roster of all titles in the collection
 * @author Rachel Reinking
 * @version 30 March 2023
 */

import java.util.Hashtable;
import java.util.Objects;
import java.util.Enumeration;

public class Library extends Building{

    private Hashtable<String, Boolean> collection;

    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection = new  Hashtable<String, Boolean>();
    }

    /**
     * This method adds a title to the library's collection
     * @param title of the book
     */
    public void addTitle(String title) {
      if(this.collection.containsKey(title)) {
        throw new RuntimeException(this.name + " already contains the title " + title);
      }
      this.collection.put(title, true);
    }

    /**
     * This method removes a title from the library's collection
     * @param title of the book
     * @return The title of the book being removed
     */
    public String removeTitle(String title) {
      if(!this.collection.containsKey(title)) {
        throw new RuntimeException(this.name + " does not contains the title " + title);
      }
      this.collection.remove(title);
      return title;
    }

    /**
     * This method allows patrons to check out a title from the library's collection
     * @param title of the book
     */
    public void checkOut(String title) {
      if(!this.collection.containsKey(title)) {
        throw new RuntimeException(this.name + " does not contains the title " + title);
      }
      if(Objects.equals(this.collection.get(title), false)) {
        throw new RuntimeException(title + " is already checked out of " + this.name);
      }
      this.collection.replace(title, false);
    }

    /**
     * This method allows patrons to return a title to the library's collection
     * @param title of the book
     */
    public void returnBook(String title) {
      if(!this.collection.containsKey(title)) {
        throw new RuntimeException(this.name + " does not contains the title " + title);
      }
      if(Objects.equals(this.collection.get(title), true)) {
        throw new RuntimeException(title + " is not checked out of " + this.name);
      }
      this.collection.replace(title, true);
    }

    /**
     * This method takes in a title of a book and tells us whether the title is a key in the library's collection
     * @param title of the book
     * @return T/F: whether or not a book is in the libary's collection
     */
    public boolean containsTitle(String title) {
      if(this.collection.containsKey(title)) {
        return true;
      }
      return false;
    } 
    
    /**
     * This method takes in the title of a book and tells us whether the title is available to be checked out
     * @param title of the book
     * @return T/F: whether or not a book is able to be checked out of the collection
     */
    public boolean isAvailable(String title) {
      if(!this.collection.containsKey(title)) {
        throw new RuntimeException(this.name + " does not contains the title " + title);
      }
      if(Objects.equals(this.collection.get(title), true)) {
        System.out.println(title + " is available at " + this.name);
        return true;
      }
      return false;
    } 

    /**
     * This method prints out all titles that are in the library's collection and their corresponding availability to be checked out
     */
    public void printCollection() {
      System.out.println("This collection");
      Enumeration<String> keys = this.collection.keys();
      Enumeration<Boolean> values = this.collection.elements();
      for(int i = 0; i < this.collection.size(); i++) {
        System.out.println("Title: " + keys.nextElement() + ", Available: " + values.nextElement());
      }
    }
  
    public static void main(String[] args) {
      
    }
  
  }