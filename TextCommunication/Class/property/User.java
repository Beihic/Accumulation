package TextCommunication.property;

import java.io.Serializable;

public class User implements Serializable{
	private int id;
	private String name;
	private String pass;
	private boolean login;

	public User(){}
	public User(int id, String pass){
		this.id = id;
		this.pass = pass;
	}
	public void setUser(int id, String name, String pass, boolean login){
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.login = login;
	}
	public int getId(){return id;}
	public String getName(){return name;}
	public String getPass(){return pass;}
	public boolean getLogin(){return login;}
}
