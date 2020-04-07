package org.iitbact.erp.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.TypeDef;

import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;


/**
 * The persistent class for the facility_assets database table.
 * 
 */
@Entity
@Table(name="temp")
@NamedQuery(name="Temp.findAll", query="SELECT t FROM Temp t")
@TypeDef(
	    typeClass = JsonBinaryType.class, 
	    defaultForType = JsonNode.class
	)
public class Temp implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)  
	int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private String data;
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}


}