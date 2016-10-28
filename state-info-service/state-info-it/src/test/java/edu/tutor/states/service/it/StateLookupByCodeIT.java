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
 * Tests for StateLookup.getByCode() method.
 * 
 * @author sboylan
 *
 */
@RunWith(value = Parameterized.class)
public class StateLookupByCodeIT
{
	@Parameters(name = "{index}: state country={0}, code={1} => name={2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"US", "CT", "Connecticut"},
                {"US", "MD", "Maryland"},
                {"US", "NH", "New Hampshire"}
        });
    }
    
    private String country;
    private String code;
    private String name;
    
    private StateLookup lookup;

	public StateLookupByCodeIT(String country, String code, String name)
	{
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
		State observed = lookup.getByCode(country, code);
		
		Assert.assertEquals("country", country, observed.getCountry());
		Assert.assertEquals("code", code, observed.getCode());
		Assert.assertEquals("name", name, observed.getName());
	}

}
