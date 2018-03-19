package picsso;

public class Account {
	
	private Profile profile;
	private String email;
	private String password;
	private static int identificalNumber = 0;
	public final int PERSONAL_ID;
	
	public Account(String email, String password) {

		this.profile = new Profile();
		this.email = email;
		this.password = password;
		identificalNumber++;
		this.PERSONAL_ID = Account.identificalNumber;
	}


	public void editProfile(String names, String username, String path, String website, String phone){
		this.profile.names(names).username(username).photo(path).website(website).phone(phone);
	}

	
	public String getUsername() {
		return this.profile.getUsername();
	}
	

	public String showProfilePage() {
		return this.profile.showProfileInfo();
	}
	
	private void changeEmail(String email) {
		if(email.toLowerCase().matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")){
			// if the mail is not in the database -> change
			this.email = email;
		}
	}

	private void changePassword(String password) {
		if(password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$") && (!password.equals(this.password))){
			this.password = password;
		}
		
		
	}
}
