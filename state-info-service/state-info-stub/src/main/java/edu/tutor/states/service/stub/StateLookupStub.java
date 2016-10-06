package edu.tutor.states.service.stub;

import java.util.ArrayList;
import java.util.List;

import edu.tutor.states.service.State;
import edu.tutor.states.service.StateLookup;
import edu.tutor.states.service.StateNotFoundException;

public class StateLookupStub implements StateLookup
{
	private static final StateDataRecord[] stateRecords =
		{
			new StateDataRecord(1, "US", "DE", "Delaware", "1787-12-07", "State of Delaware"),
			new StateDataRecord(2, "US", "PA", "Pennsylvania", "1781-12-12", "Commonwealth of Pennsylvania"),
			new StateDataRecord(3, "US", "NJ", "New Jersey", "1787-12-18", "State of New Jersey"),
			new StateDataRecord(4, "US", "GA", "Georgia", "1788-01-02", "State of Georgia"),
			new StateDataRecord(5, "US", "CT", "Connecticut", "1788-01-09", "State of Connecticut"),
			new StateDataRecord(6, "US", "MA", "Massachusetts", "1788-02-06", "Commonwealth of Massachusetts"),
			new StateDataRecord(7, "US", "MD", "Maryland", "1788-04-28", "State of Maryland"),
			new StateDataRecord(8, "US", "SC", "South Carolina", "1788-05-23", "State of South Carolina"),
			new StateDataRecord(9, "US", "NH", "New Hampshire", "1788-06-21", "State of New Hampshire"),
			new StateDataRecord(10, "US", "VA", "Virginia", "1788-06-25", "Commonwealth of Virginia"),
			new StateDataRecord(11, "US", "NY", "New York", "1788-07-26", "State of New York"),
			new StateDataRecord(12, "US", "NC", "North Carolina", "1789-11-21", "State of North Carolina"),
			new StateDataRecord(13, "US", "RI", "Rhode Island", "1790-05-29", "State of Rhode Island and Providence Plantations"),
			new StateDataRecord(14, "US", "VT", "Vermont", "1791-03-04", "State of Vermont"),
			new StateDataRecord(15, "US", "KY", "Kentucky", "1792-06-01", "Commonwealth of Kentucky"),
			new StateDataRecord(16, "US", "TN", "Tennessee", "1796-06-01", "State of Tennessee"),
			new StateDataRecord(17, "US", "OH", "Ohio", "1803-03-01", "State of Ohio"),
			new StateDataRecord(18, "US", "LA", "Louisiana", "1812-04-30", "State of Louisiana"),
			new StateDataRecord(19, "US", "IN", "Indiana", "1816-12-11", "State of Indiana"),
			new StateDataRecord(20, "US", "MS", "Mississippi", "1817-12-10", "State of Mississippi"),
			new StateDataRecord(21, "US", "IL", "Illinois", "1818-12-03", "State of Illinois"),
			new StateDataRecord(22, "US", "AL", "Alabama", "1819-12-14", "State of Alabama"),
			new StateDataRecord(23, "US", "ME", "Maine", "1820-03-15", "State of Maine"),
			new StateDataRecord(24, "US", "MO", "Missouri", "1821-08-10", "State of Missouri"),
			new StateDataRecord(25, "US", "AR", "Arkansas", "1836-06-15", "State of Arkansas"),
			new StateDataRecord(26, "US", "MI", "Michigan", "1837-01-26", "State of Michigan"),
			new StateDataRecord(27, "US", "FL", "Florida", "1845-03-03", "State of Florida"),
			new StateDataRecord(28, "US", "TX", "Texas", "1845-12-29", "State of Texas"),
			new StateDataRecord(29, "US", "IA", "Iowa", "1846-12-28", "State of Iowa"),
			new StateDataRecord(30, "US", "WI", "Wisconsin", "1848-05-29", "State of Wisconsin"),
			new StateDataRecord(31, "US", "CA", "California", "1850-09-09", "State of California"),
			new StateDataRecord(32, "US", "MN", "Minnesota", "1858-05-11", "State of Minnesota"),
			new StateDataRecord(33, "US", "OR", "Oregon", "1859-02-14", "State of Oregon"),
			new StateDataRecord(34, "US", "KS", "Kansas", "1861-01-29", "State of Kansas"),
			new StateDataRecord(35, "US", "WV", "West Virginia", "1863-06-20", "State of West Virginia"),
			new StateDataRecord(36, "US", "NV", "Nevada", "1864-10-31", "State of Nevada"),
			new StateDataRecord(37, "US", "NE", "Nebraska", "1867-03-01", "State of Nebraska"),
			new StateDataRecord(38, "US", "CO", "Colorado", "1876-08-01", "State of Colorado"),
			new StateDataRecord(39, "US", "ND", "North Dakota", "1889-11-02", "State of North Dakota"),
			new StateDataRecord(40, "US", "SD", "South Dakota", "1889-11-02", "State of South Dakota"),
			new StateDataRecord(41, "US", "MT", "Montana ", "1889-11-08", "State of Montana"),
			new StateDataRecord(42, "US", "WA", "Washington", "1889-11-11", "State of Washington"),
			new StateDataRecord(43, "US", "ID", "Idaho", "1890-07-03", "State of Idaho"),
			new StateDataRecord(44, "US", "WY", "Wyoming", "1890-07-10", "State of Wyoming"),
			new StateDataRecord(45, "US", "UT", "Utah", "1896-01-04", "State of Utah"),
			new StateDataRecord(46, "US", "OK", "Oklahoma", "1907-11-16", "State of Oklahoma"),
			new StateDataRecord(47, "US", "NM", "New Mexico", "1912-01-06", "State of New Mexico"),
			new StateDataRecord(48, "US", "AZ", "Arizona", "1912-02-14", "State of Arizona"),
			new StateDataRecord(49, "US", "AK", "Alaska", "1959-01-03", "State of Alaska"),
			new StateDataRecord(50, "US", "HI", "Hawaii", "1959-08-21", "State of Hawaii")
		};
	
	public StateLookupStub()
	{
		;
	}

	@Override
	public State getById(long id) throws StateNotFoundException
	{
		for (StateDataRecord curState : stateRecords)
		{
			if (curState.getId() == id)
			{
				return (curState.toState());
			}
		}
		
		throw new StateNotFoundException(String.format("State ID %d not found", id));
	}

	@Override
	public State getByCode(String country, String code) throws StateNotFoundException
	{
		for (StateDataRecord curState : stateRecords)
		{
			if ((curState.getCountry().equals(country)) && (curState.getCode().equals(code)))
			{
				return (curState.toState());
			}
		}
		
		throw new StateNotFoundException(String.format("State with country=%s and code=%s not found", country, code));
	}

	@Override
	public Iterable<State> findByCountry(String country) throws StateNotFoundException
	{
		List<State> answer = new ArrayList<State>();

		for (StateDataRecord curState : stateRecords)
		{
			if (curState.getCountry().equals(country))
			{
				answer.add(curState.toState());
			}
		}

		return (answer);
	}

	@Override
	public Iterable<State> findByCode(String code) throws StateNotFoundException
	{
		List<State> answer = new ArrayList<State>();

		for (StateDataRecord curState : stateRecords)
		{
			if (curState.getCode().equals(code))
			{
				answer.add(curState.toState());
			}
		}

		return (answer);
	}

}
