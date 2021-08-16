package br.com.blog.commons.lang;

/**
 * Usado nas validações de regras de negócios da aplicação.
 */
public class ValidationException extends ServiceException {

	private static final long serialVersionUID = 3707650890079280332L;

	public ValidationException(String message) {
		super(message);
	}

	public ValidationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidationException(Throwable cause) {
		super(cause);
	}

	public boolean isValidation() {
		return Boolean.TRUE;
	}

}
