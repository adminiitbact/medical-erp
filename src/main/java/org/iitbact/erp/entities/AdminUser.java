package org.iitbact.erp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the admin_users database table.
 * 
 */
@Entity
@Table(name = "admin_users")
@NamedQuery(name = "AdminUser.findAll", query = "SELECT h FROM AdminUser h")
public class AdminUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "email_id")
	private String emailId;

	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@Column(name = "user_id")
	private String userId;

	private String deisgnation;

	public String getDeisgnation() {
		return deisgnation;
	}

	public void setDeisgnation(String deisgnation) {
		this.deisgnation = deisgnation;
	}

	public AdminUser() {
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}