package edu.tutor.states.service;

public interface StateLookup
{
	State getById(long id) throws StateNotFoundException;
	State getByCode(String country, String code) throws StateNotFoundException;
	Iterable<State> findByCountry(String country) throws StateNotFoundException;
	Iterable<State> findByCode(String code) throws StateNotFoundException;
}
