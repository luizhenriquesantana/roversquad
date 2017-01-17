package br.com.stefanini.roversquad.test;

import org.junit.Test;

import br.com.stefanini.roversquad.exceptions.RegisterException;
import br.com.stefanini.roversquad.model.Plateau;
import br.com.stefanini.roversquad.model.Rover;

/**
 * Test the plateau
 * 
 * @author luizhenriquesantana
 *
 */
public class PlateauTest {

	@Test
	public void checkAnPosition() throws RegisterException {
		Plateau plateau = new Plateau("5 5");

		Rover rover = new Rover("6 6 N");
		plateau.register(rover);
	}

	public void checkAnUsedPosition() throws RegisterException {
		Plateau plateau = new Plateau("5 5");
		Rover rover1 = new Rover("1 1 N");
		plateau.register(rover1);

		Rover rover2 = new Rover("1 1 N");
		plateau.register(rover2);
	}

}
