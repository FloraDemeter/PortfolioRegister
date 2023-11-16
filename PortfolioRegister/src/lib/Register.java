package lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Class for Register and required methods
 * 
 * @author demeterflora
 */

public class Register implements Iterable<Name>{
	
	//fields
	private ArrayList<Name> register;
	private int roomCap = 0;
	
	//Constructors

	/**
	 * default constructor with default values.
	 * default value being an empty ArrayList and the roomCap set to 20.
	 */
	public Register() {
		register = new ArrayList<>();
		roomCap = 20;
	}
	
	/**
	 * Custom constructor with default and defined values
	 * @param i = for room capacity
	 */
	public Register(int i) {
		this.register = new ArrayList<>();
		this.roomCap = i;
	}

	//Methods
	/**
	 * Method to return if there are existing elements in the register
	 * @return boolean, true if empty, false if it has values
	 */
	public boolean isRegisterEmpty() {
		return register.isEmpty();
	}

	/**
	 * Method to return the size of the register
	 * @return integer, size of register
	 */
	public int sizeOfRegister() {
		return register.size();
	}
	
	/**
	 * Method to return the room capacity
	 * @return integer, roomCapacity
	 */
	public int getRoomCapacity() {
		return roomCap;
	}

	/**
	 * Adds the parameter passed through the method only if the roomCap is not exceeded
	 * will check if the size of the register not the same as the room capacity
	 * @param name = Name
	 */
	public void addName(Name name) {
		if (register.size() != roomCap) {
			register.add(name);
		}
	}

	/**
	 * Adds the parameter passed through as a collection only if the roomCap is not exceeded
	 * New variable to store the available capacity
	 * it will check if the size of the collection to be added fits into the available capacity
	 * if true add, if false ignore
	 * @param names = ArrayList of Name
	 */
	public void addNames(ArrayList<Name> names) {
		int availableCap = roomCap - register.size();	
		if (names.size() <= availableCap) {
			for (int i = 0; i < names.size(); i++) {
				register.add(names.get(i));
			}
		}
	}

	/**
	 * return a name from the register in a certain position
	 * @param i, represents the index within the ArrayList
	 * @return Name, value stored in the defined indexed
	 */
	public Name getName(int i) {
		return register.get(i);
	}

	/**
	 * Removes name at a certain index defined in the parameter
	 * @param i, position of the element to be removed
	 * @return, the register - the name that was removed
	 */
	public Name removeName(int i) {
		return register.remove(i);
	}

	/**
	 * Clears all elements out of the register
	 */
	public void clearRegister() {
		register.clear();
		
	}

	/**
	 * The register is searched for values that match the parameter at the index 0
	 * @param c = character to search
	 * @return = boolean, true if found, false if not found
	 */
	public boolean searchRegisterByFirstNameInitial(char c) {
		boolean found = false;
		for (Name n : register) {
			if (c == n.getFirstName().charAt(0)) {
				found = true;
			} else {
				if (!found) {
					found = false;
				}
			}
		} return found;
	}

	/**
	 * The register is searched for all occurrences of the parameter passed through 
	 * @param nameToSeach = String to search
	 * @return count = int of all occurrences
	 */
	public int countFirstNameOccurrences(String nameToSearch) {
		int count = 0;
		for (Name n : register) {
			if (nameToSearch.toLowerCase().equals(n.getFirstName().toLowerCase())) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * toString method overwritten to follow outlined standard
	 */
	@Override
	public String toString() {
		return "Register:[roomCap: " + roomCap + ", register: " + register + "]";
	}

	/**
	 * New iterator method to implement Iterator
	 */
	@Override
	public Iterator<Name> iterator() {
		return register.iterator();
	}

	/**
	 * Will sort register ArrayList into an ascending order
	 */
	public void sortRegister() {
		Collections.sort(register);
		
	}
	
}
