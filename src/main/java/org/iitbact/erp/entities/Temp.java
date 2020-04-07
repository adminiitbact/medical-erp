package org.iitbact.erp.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the temp database table.
 * 
 */
@Entity
@Table(name="temp")
@NamedQuery(name="Temp.findAll", query="SELECT t FROM Temp t")
public class Temp implements Serializable {
	private static final long serialVersionUID = 1L;

	private Object data;
	
	@Id
	private int id;

	private Timestamp timestamp;

	public Temp() {
	}

	public Object getData() {
		return this.data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

}