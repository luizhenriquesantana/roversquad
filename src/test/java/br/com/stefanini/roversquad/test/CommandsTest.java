package br.com.stefanini.roversquad.test;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import br.com.stefanini.roversquad.enums.Command;
import br.com.stefanini.roversquad.exceptions.CommandParseException;

/**
 * Test the commands
 * 
 * @author luizhenriquesantana
 *
 */
public class CommandsTest {

	@Test
	public void testDirection() throws CommandParseException {
		Command[] cmd = { Command.TURN_LEFT, Command.TURN_RIGHT, Command.MOVE_ON, Command.MOVE_ON, Command.TURN_RIGHT,
				Command.TURN_LEFT };
		assertArrayEquals(cmd, Command.parse("LRMMRL"));
	}

}
