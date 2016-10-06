package edu.tutor.states.service;

public class State
{
	public static final long INVALID_STATE_ID = -1;

	private long id = INVALID_STATE_ID;
	private String country;
	private String code;
	private String name;

	public State()
	{
		;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
