package br.com.stefanini.roversquad.model;

import java.util.Observable;

import br.com.stefanini.roversquad.enums.Command;
import br.com.stefanini.roversquad.enums.Direction;
import br.com.stefanini.roversquad.exceptions.CommandParseException;
import br.com.stefanini.roversquad.exceptions.DirectionException;
import br.com.stefanini.roversquad.exceptions.RegisterException;

/**
 * The model class for the Rover
 * @author luizhenriquesantana
 *
 */
public class Rover extends Observable {
	
	private Direction direction;

	private Position  position;

	protected Rover(Position pos, Direction dir) {
		super();
		position = pos;
		direction = dir;
	}

	public Rover(String in) {
		super();
		String[] tokens = in.split("\\s");
		if (3 != tokens.length) {
			throw new RuntimeException("Can't parse rover initial position");
		}
		{
			final int x  = Integer.parseInt(tokens[0]);
			final int y  = Integer.parseInt(tokens[1]);
			setPosition(new Position(x, y));
		}
		{
			Direction d = null;
			try {
				d = Direction.parse(tokens[2]);
			} catch (CommandParseException e) {
				e.printStackTrace();
			}
			setDirection(d);
		}
	}

	public void control(final Command c) throws RegisterException, DirectionException {
		switch (c) {
		case TURN_LEFT:
			setDirection(Direction.left(getDirection()));
			break;
		case TURN_RIGHT:
			setDirection(Direction.right(getDirection()));
			break;
		case MOVE_ON:
			position.step(getDirection());
			setChanged();
			break;
		default:
			throw new Error("switch out of sync with declaration");
		}
		check();
	}

	private void check() throws RegisterException {
		class ErrorReport implements RegisterException.Wrapper {
			private RegisterException exception;

			ErrorReport() {
				exception = null;
			}

			public void set(RegisterException exception) {
				this.exception = exception;
			}

			public void raise() throws RegisterException {
				if (null != exception) {
					throw exception;
				}
			}
		}
		ErrorReport error = new ErrorReport();
		notifyObservers(error);
		error.raise();
	}

	public String getCoordinate() {
		return direction + " " + position.x + " " + position.y;
	}

	public Direction getDirection() {
		return direction;
	}

	public Position getPosition() {
		return position;
	}

	protected void setDirection(final Direction in) {
		this.direction = in;
		setChanged();
	}

	protected void setPosition(final Position in) {
		this.position = in;
		setChanged();
	}
}