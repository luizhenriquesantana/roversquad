package br.com.stefanini.roversquad.model;

import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import br.com.stefanini.roversquad.exceptions.RegisterException;

public class Plateau implements Observer {
	
	private Position upCornerRight;

	private LinkedList<Rover> vehicles;

	public Plateau(String in) {
			upCornerRight = parse(in);
			if ((upCornerRight.x < 0) || (upCornerRight.y < 0)) {
				throw new RuntimeException("Plateau information is incorrect!");
			}
			vehicles = new LinkedList<Rover>();
	}

	public static Position parse(String in) {
		String[] tokens = in.split("\\s");
		if (2 == tokens.length) {
			final int x = Integer.parseInt(tokens[0]);
			final int y = Integer.parseInt(tokens[1]);
			return new Position(x, y);
		}
		throw new RuntimeException("An error occurred while trying to parse the Plateau information!");
	}

	public void register(final Rover current) throws RegisterException {
		vehicles.add(current);
		current.addObserver(this);
		check(current);
	}

//	public void update(Observable o, Object arg) {
//		if (o instanceof Rover) {
//			Rover changed = (Rover) o;
//			try {
//				check(changed);
//			} catch (RegisterException e) {
//				if (arg instanceof RegisterException.Wrapper) {
//					RegisterException.Wrapper reporter = (RegisterException.Wrapper) arg;
//					reporter.set(e);
//				}
//			}
//		}
//	}

	private void check(Rover current) throws RegisterException {
		if (! isInside(current.getPosition())) {
			throw new RegisterException("The vehicle of position " + current.getPosition() + "is out of the Plateau!");
		}
		for (Rover other : vehicles) {
			if ((current != other) && (current.getPosition().equals(other.getPosition()))) {
				throw new RegisterException("Problem with vehicles " + current.getPosition());
			}
		}
	}

	private boolean isInside(final Position in) {
		return (in.x >= 0) && (in.x <= upCornerRight.x) &&
			   (in.y >= 0) && (in.y <= upCornerRight.y);
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}
}
