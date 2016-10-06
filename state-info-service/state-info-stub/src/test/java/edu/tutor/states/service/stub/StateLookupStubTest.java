package edu.tutor.states.service.stub;

import org.junit.runners.Parameterized;

import edu.tutor.states.service.State;
import edu.tutor.states.service.StateNotFoundException;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class StateLookupStubTest
{
	@Parameterized.Parameters(name = "{index}: id={0}, code={2}")
	public static Collection<Object[]> testData()
	{
		return Arrays.asList(new Object[][]
			{
				{ 1, "US", "DE", "Delaware", "1787-12-07", "State of Delaware" },
				{ 5, "US", "CT", "Connecticut", "1788-01-09", "State of Connecticut" },
				{ 13, "US", "RI", "Rhode Island", "1790-05-29", "State of Rhode Island and Providence Plantations" },
				{ 29, "US", "IA", "Iowa", "1846-12-28", "State of Iowa" },
				{ 47, "US", "NM", "New Mexico", "1912-01-06", "State of New Mexico" }
	      });
	}

	// Test parameters
	private long stateId;
	private String country;
	private String code;
	private String name;
	private String date;
	private String formalName;

	// Component being tested
	private StateLookupStub stateLookup;

	public StateLookupStubTest(long stateId, String country, String code, String name,
			String date, String formalName)
	{
		this.stateId = stateId;
		this.country = country;
		this.code = code;
		this.name = name;
		this.date = date;
		this.formalName = formalName;
	}

	@Before
	public void obtainLookup()
	{
		stateLookup = new StateLookupStub();
	}

	@Test
	public void testLookupById() throws StateNotFoundException
	{
		State state = stateLookup.getById(stateId);
		
		validateState("testLookupById", state);
	}

	@Test
	public void testLookupByCode() throws StateNotFoundException
	{
		State state = stateLookup.getByCode(country, code);
		
		validateState("testLookupByCode", state);
	}

	private void validateState(String test, State state)
	{
		Assert.assertEquals("stateId", stateId, state.getId());
		Assert.assertEquals("country", country, state.getCountry());
		Assert.assertEquals("code", code, state.getCode());
		Assert.assertEquals("name", name, state.getName());
	}

}
