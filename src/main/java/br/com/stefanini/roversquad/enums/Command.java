package br.com.stefanini.roversquad.enums;

import br.com.stefanini.roversquad.exceptions.CommandParseException;

public enum Command {

	TURN_LEFT, TURN_RIGHT, MOVE_ON;

	public static Command[] parse(String str) throws CommandParseException {
		final int size = str.length();
		Command[] command = new Command[size];
		for (int idx = 0; idx < size; ++idx) {
			switch (str.charAt(idx)) {
			case 'L':
				command[idx] = TURN_LEFT;
				break;
			case 'R':
				command[idx] = TURN_RIGHT;
				break;
			case 'M':
				command[idx] = MOVE_ON;
				break;
			default:
				throw new CommandParseException("An error ocurred when the application tried run the parse at position",
						idx);
			}
		}
		return command;
	}
}
