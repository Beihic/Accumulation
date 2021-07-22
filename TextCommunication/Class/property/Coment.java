package TextCommunication.property;

import java.io.Serializable;
import java.sql.Timestamp;

public class Coment implements Serializable{
	private int id;
	private String name;
	private String coment;
	private Timestamp timestamp;
	public Coment(){}
	public void setComent(int id, String name, String coment, Timestamp timestamp){
		this.id=id;
		this.name=name;
		this.coment=coment;
		this.timestamp=timestamp;
	}
	public int getId(){return id;}
	public String getName(){return name;}
	public String getComent(){return coment;}
	public Timestamp getTimestamp(){return timestamp;}
}
