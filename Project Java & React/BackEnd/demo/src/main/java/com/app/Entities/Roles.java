package com.app.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;


@Entity
public class Roles {

	@Id
	@Column(name="Role_Id" , nullable = false)
	private int roleId;
	
	@Column(name = "Role_name", nullable = false)
	private String roleName;
	
	@ManyToMany(mappedBy = "roles")
	List<User> users = new ArrayList<User>();

	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Roles(int roleId, String roleName, List<User> users) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.users = users;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
}