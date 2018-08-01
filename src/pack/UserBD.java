package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserBD
{
	String email, password, login, user = "root", pass = "", strUrl = "jdbc:mysql://localhost:3306/project_breizhlink";
	Connection conn= null;
	Statement stat= null;
	String sql_ajout = "insert into user VALUES (?,?,?) ";
	String sql_affichage = "select login from user where login = ?";

	public UserBD(String login2, String email2, String password2) 
	{
		this.email = email2;
		this.login = login2;
		this.password = password2;
	}
	
	public boolean createContact()
	{
		try 
		{
			// chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// récupération de la connection
			conn = DriverManager.getConnection(strUrl,user,pass);
			// création dun statement
			stat = conn.createStatement();
			
			PreparedStatement pst2 = conn.prepareStatement(sql_affichage);
			pst2.setString(1, this.login);
			ResultSet rs = pst2.executeQuery();
			
			if (rs.next())
			{
				return false;
			}
			else
			{
				PreparedStatement pst = conn.prepareStatement(sql_ajout);
				pst.setString(1, this.login);
				pst.setString(2, this.email);
				pst.setString(3, this.password);
				pst.execute();
				return true;
			}
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;} 
		catch (SQLException e) {
			e.printStackTrace();
			return false;}
	}
	
	public User load(String login2)
	{
		try 
		{
			// chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// récupération de la connection
			conn = DriverManager.getConnection(strUrl,user,pass);
			// création dun statement
			stat = conn.createStatement();
			
			PreparedStatement pst2 = conn.prepareStatement(sql_affichage);
			pst2.setString(1, login2);
			ResultSet rs = pst2.executeQuery();
			
			return new User(rs.getString(1), rs.getString(2), rs.getString(3));
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;} 
		catch (SQLException e) {
			e.printStackTrace();
			return null;}
	}
	
	public void addURL(String urlBDD, String urlRacc)
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String urlRac = "https://" + urlRacc + ".com";
		
		try 
		{
			String strClassName = "com.mysql.jdbc.Driver";
			Class.forName(strClassName);
			Connection conn = DriverManager.getConnection(strUrl, user, pass);
			String strInsert = "INSERT INTO url " + "(url, url_racc, date_crea) " + "VALUES ('" + urlBDD + "', '" + urlRac + "', ' " + dateFormat.format(date) + "');";
			Statement stAddUser = conn.createStatement(); 
			stAddUser.executeUpdate(strInsert); 
			conn.close();
		}
		catch(ClassNotFoundException e) { 
			System.err.println("Driver non chargé !"); 
			e.printStackTrace(); 
		} catch(SQLException e) { 
			System.err.println("Problème avec SQL !"); 
			e.printStackTrace(); 
		}  
	}
	
	public ResultSet getShortUrl(String longUrl)
	{
		ResultSet rsLogin = null;
		try 
		{
			
			String strClassName = "com.mysql.jdbc.Driver"; 
			Class.forName(strClassName);
			Connection conn = DriverManager.getConnection(strUrl, user, pass);
			
			String strSelect = "Select * From url where url = '"+ longUrl + "';"; 
			Statement stLogin = conn.createStatement(); 
			rsLogin = stLogin.executeQuery(strSelect);
			
			while(rsLogin.next())
			{ 
				String urlLong = rsLogin.getString("url");
				String urlShort = rsLogin.getString("url_racc");	
				
				conn.close(); 
			}
		}
		catch(ClassNotFoundException e) { 
			System.err.println("Driver non chargé !"); 
			e.printStackTrace(); 
		} catch(SQLException e) { 
			System.err.println("Problème avec SQL !"); 
			e.printStackTrace(); 
		}
		return rsLogin;
	}
}