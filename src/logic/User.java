package logic;

public class User 
{
	private String uID;       //user id
	private String uName;     //user name
	private String password;  //user password
	private int isLoggedIn;   //0 if user isn't logged in already, 1 else
	
	public User(String uID, String uName, String password) {
		super();
		this.uID = uID;
		this.uName = uName;
		this.password = password;
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
