package org.pcpt.sdk.testdata;

/**
 * Class to map the users.json
 */
public class UsersLoader {
	public String firstname;
	public String lastname;
	public String email;
	public String username;
	public String password;

	/**
	 * Constructor
	 * 
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param username
	 * @param password
	 */
	public UsersLoader(String firstname, String lastname, String email, String username, String password) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public UsersLoader() {
	}
}
