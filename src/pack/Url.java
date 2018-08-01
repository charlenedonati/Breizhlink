package pack;

import java.sql.Date;
import java.util.Random;

public class Url 
{
	public String url;
	public String url_racc;
	public Date date_crea;
	public int nb_vues;

	public Url(){}
	
	public Url(String url)
	{
		this.url = url;
	}
	
	public String getUrl()
	{
		return this.url;
	}
	
	public String getUrl_racc()
	{
		return this.url_racc;
	}
	
	public Date getDate_crea()
	{
		return this.date_crea;
	}
	
	public int getNb_vues()
	{
		return this.nb_vues;
	}
	public void setUrl(String url2)
	{
		this.url = url2;
	}
	
	public void setUrl_racc(String url_racc2)
	{
		this.url_racc = url_racc2;
	}
	
	public void setDate_crea(Date date_crea2)
	{
		this.date_crea = date_crea2;
	}
	
	public void setNb_vues(int nb_vues2)
	{
		this.nb_vues = nb_vues2;
	}
	
	public String transformURL()
	{
		try 
		{
		    String alphanum = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789+@";
		    StringBuilder test = new StringBuilder();
		    Random rand = new Random();
		    
		    //length of the random string.
		    while (test.length() < 10) { 
	            int index = (int) (rand.nextFloat() * test.length());
	            test.append(alphanum.charAt(index));
	        }
	        this.url_racc = test.toString();
		}
		catch(Exception ex) 
		{
			System.out.println("Erreur pendant la conversation de l'url");
		}
		
		return this.url_racc;
	}
}