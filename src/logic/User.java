package logic;

public class User 
{
	private String uID;
	private String uName;
	private String password;
	private int isLoggedIn;
	
	public User(String uID, String uName, String password, int isLoggedIn) {
		super();
		this.uID = uID;
		this.uName = uName;
		this.password = password;
		this.isLoggedIn = isLoggedIn;
	}
	
	public String getuID() {
		return uID;
	}
	public void setuID(String uID) {
		this.uID = uID;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIsLoggedIn() {
		return isLoggedIn;
	}
	public void setIsLoggedIn(int isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	
	
}
