package br.com.stefanini.roversquad.exceptions;

/**
 * Exception for registration attempts
 * @author luizhenriquesantana
 *
 */
public class RegisterException extends Exception {

	private static final long serialVersionUID = 7770209547280610314L;

	public RegisterException(String msg) {
		super(msg);
	}

	public RegisterException(String msg, Throwable t) {
		super(msg, t);
	}

	public interface Wrapper {
		public void set(RegisterException exception);
	}
}
