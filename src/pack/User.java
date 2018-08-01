package pack;

public class User 
{
	String email;
	String password;
	String login;

	public User(String login2, String email2, String password2) 
	{
		this.login = login2;
		this.password = password2;
		this.email = email2;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	public String getLogin()
	{
		return this.login;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public void setEmail(String email2)
	{
		this.email = email2;
	}
	
	public void setlogin(String login2)
	{
		this.email = login2;
	}
	
	public void setpassword(String password2)
	{
		this.email = password2;
	}
	
	public Boolean enregistre()
	{
		UserBD userBDD = new UserBD(this.login, this.email, this.password);
		return userBDD.createContact();
	}
	
	public User recupere(String login2)
	{
		UserBD userBDD = new UserBD(login2, "", "");
		return userBDD.load(login2);
	}	
}