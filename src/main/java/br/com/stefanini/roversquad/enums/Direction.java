package br.com.stefanini.roversquad.enums;

import br.com.stefanini.roversquad.exceptions.CommandParseException;
import br.com.stefanini.roversquad.exceptions.DirectionException;

/**
 * Enum with the possible directions
 * 
 * @author luizhenriquesantana
 *
 */
public enum Direction {

	NORTH, SOUTH, EAST, WEST;

	static public Direction parse(String in) throws CommandParseException {
		if (1 == in.length()) {
			switch (in.charAt(0)) {
			case 'N':
				return Direction.NORTH;
			case 'S':
				return Direction.SOUTH;
			case 'E':
				return Direction.EAST;
			case 'W':
				return Direction.WEST;
			}
		}
		throw new CommandParseException("An error occurred while trying to read the direction", 0);
	}

	public static Direction left(final Direction in) throws DirectionException {
		switch (in) {
		case NORTH:
			return Direction.WEST;
		case SOUTH:
			return Direction.EAST;
		case EAST:
			return Direction.NORTH;
		case WEST:
			return Direction.SOUTH;
		}
		throw new DirectionException("An error occurred while trying to read the direction");
	}

	public static Direction right(final Direction in) throws DirectionException {
		switch (in) {
		case NORTH:
			return Direction.EAST;
		case SOUTH:
			return Direction.WEST;
		case EAST:
			return Direction.SOUTH;
		case WEST:
			return Direction.NORTH;
		}
		throw new DirectionException("An error occurred while trying to read the direction");
	}

	@Override
	public String toString() {
		switch (this) {
		case NORTH:
			return "N";
		case SOUTH:
			return "S";
		case EAST:
			return "E";
		case WEST:
			return "W";
		}
		throw new Error("An error occurred while trying to show the direction");
	}

}
