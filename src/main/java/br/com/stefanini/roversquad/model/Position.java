package br.com.stefanini.roversquad.model;

import br.com.stefanini.roversquad.enums.Direction;

public class Position {

	public int x;

	public int y;

	Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void step(final Direction d) {
		switch (d) {
		case NORTH:
			++y;
			break;
		case SOUTH:
			--y;
			break;
		case EAST:
			++x;
			break;
		case WEST:
			--x;
			break;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position anotherPosition = (Position) obj;
		if (x != anotherPosition.x)
			return false;
		if (y != anotherPosition.y)
			return false;
		return true;
	}
}
