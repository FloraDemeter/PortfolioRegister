package main;

import lib.Name;
import lib.Register;


public class RegisterApp {
	
	/**
	 * Remove name at index 1, which would be the second name in the register
	 * Adds name that is passed through as a parameter
	 * 
	 * To create email
	 * for each name in the register
	 * check if it contains a or e then
	 * extract the first letter of the First name and the first 3 letters of the Surname and combine the two
	 * 	for example f.dem
	 * then concatenates the user with the email
	 * 
	 * all emails that meet the criteria will be combined into one string
	 * 
	 * @param nm, Name to be added
	 * @param regst, Register, list of names#
	 * @return emails, a string of concatenated emails
	 */
	public static String execute(Name nm, Register regst) {
		
		regst.removeName(1);
		regst.addName(nm);
		
		String email = "@email.com";
		String emails = "";
		
		for (Name n : regst) {
			if (n.getFullName().toLowerCase().contains("a")| n.getFullName().toLowerCase().contains("e")) {
				String user = n.getFirstName().charAt(0) + "." + n.getFamilyName().substring(0, 3);
				user = user.toLowerCase();
				emails += user + email + "\n";
			}
		}
		
		return emails;
	}
}