package edu.tutor.states.service.stub;

import edu.tutor.states.service.State;

public class StateDataRecord
{
	private long id = State.INVALID_STATE_ID;
	private String country;
	private String code;
	private String name;
	private String date;
	private String formalName;

	public StateDataRecord(long id, String country, String code, String name, String date, String formalName)
	{
		this.id = id;
		this.country = country;
		this.code = code;
		this.name = name;
		this.date = date;
		this.formalName = formalName;
	}
	
	public State toState()
	{
		State state = new State();
		
		state.setId(id);
		state.setCountry(country);
		state.setCode(code);
		state.setName(name);
		
		return (state);
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFormalName() {
		return formalName;
	}

	public void setFormalName(String formalName) {
		this.formalName = formalName;
	}

}
