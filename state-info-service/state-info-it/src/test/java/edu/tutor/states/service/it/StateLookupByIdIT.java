package edu.tutor.states.service.it;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import edu.tutor.states.service.State;
import edu.tutor.states.service.StateLookup;
import edu.tutor.states.service.StateNotFoundException;
import edu.tutor.states.service.stub.StateLookupStub;

/**
 * Tests for StateLookup.getById() method.
 * CAUTION - FRAGILE TEST:  State IDs are not guaranteed to remain constant
 * across different API implementations.
 * 
 * @author sboylan
 *
 */
@RunWith(value = Parameterized.class)
public class StateLookupByIdIT
{
	@Parameters(name = "{index}: state ID={0} => country={1}, code={2}, name={3}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {5, "US", "CT", "Connecticut"},
                {7, "US", "MD", "Maryland"},
                {9, "US", "NH", "New Hampshire"}
        });
    }
    
    private long stateId;
    private String country;
    private String code;
    private String name;
    
    private StateLookup lookup;

	public StateLookupByIdIT(long stateId, String country, String code, String name)
	{
		this.stateId = stateId;
		this.country = country;
		this.code = code;
		this.name = name;
	}

	@Before
	public void connectToData()
	{
		lookup = new StateLookupStub();
	}

	@Test
	public void testGetById() throws StateNotFoundException
	{
		State observed = lookup.getById(stateId);
		
		Assert.assertEquals("country", country, observed.getCountry());
		Assert.assertEquals("code", code, observed.getCode());
		Assert.assertEquals("name", name, observed.getName());
	}

}
