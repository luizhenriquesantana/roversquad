package br.com.stefanini.roversquad.exceptions;

import java.text.ParseException;

/**
 * Class to throw the parse exceptions.
 * 
 * @author luizhenriquesantana
 *
 */
public class CommandParseException extends ParseException {

	private static final long serialVersionUID = 9012043883724338781L;

	public CommandParseException(String string, Integer position) {
		super(string, position);
	}

}
