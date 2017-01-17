package br.com.stefanini.roversquad.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.stefanini.roversquad.enums.Command;
import br.com.stefanini.roversquad.exceptions.DirectionException;
import br.com.stefanini.roversquad.exceptions.RegisterException;
import br.com.stefanini.roversquad.model.Rover;

/**
 * Test the rovers
 * 
 * @author luizhenriquesantana
 *
 */
public class RoverTest {

	@Test
	public void checkByPosition() {
		Rover rover = new Rover("3 1 N");
		assertEquals( "3 1 N", rover.getPosition());
	}
	
	@Test
	public void checkBycommand() throws RegisterException, DirectionException {
		Rover rover = new Rover("3 1 N");
		rover.control(Command.MOVE_ON);
	}

}
