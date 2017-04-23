package com.pet.model;

public class User
{
	private int id;
	private String username;
	private String password;
	private String nickname;
	private String sex;
	private String address;
	private String adoptedPets;
	private String icon;
	
	public User()
	{
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getNickname()
	{
		return nickname;
	}

	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getAdoptedPets()
	{
		return adoptedPets;
	}

	public void setAdoptedPets(String adoptedPets)
	{
		this.adoptedPets = adoptedPets;
	}
	
	

	public String getIcon()
	{
		return icon;
	}

	public void setIcon(String icon)
	{
		this.icon = icon;
	}

	@Override
	public String toString()
	{
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", nickname=" + nickname
				+ ", sex=" + sex + ", address=" + address + ", adoptedPets=" + adoptedPets + ", icon=" + icon + "]";
	}

}	
