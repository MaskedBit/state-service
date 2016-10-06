package edu.tutor.states.demo;

import edu.tutor.states.service.State;
import edu.tutor.states.service.StateLookup;
import edu.tutor.states.service.StateNotFoundException;
import edu.tutor.states.service.stub.StateLookupStub;

public class FindState
{
	public static StateLookup stateLookup;
	
	public static void main(String[] args)
	{
		System.out.println("FindState demo");
		
		stateLookup = new StateLookupStub();
		
		if (args.length < 1)
		{
			System.out.println("*** No state codes provided");
		}
		else
		{
			processStateCodes(args);
		}
	}

	private static void processStateCodes(String[] args)
	{
		for (String curCode : args)
		{
			State state;

			try
			{
				state = stateLookup.getByCode("US", curCode);
				
				System.out.format("State code=\"%s\", name=\"%s\"%n", state.getCode(), state.getName());
			}
			catch (StateNotFoundException e)
			{
				System.out.format("State code \"%s\" not found - error was:  %s%n", curCode, e.getMessage());
			}
		}
	}

}
