package br.com.stefanini.roversquad.exceptions;

public class RegisterException extends Exception {

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
