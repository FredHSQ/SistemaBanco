package exceptions;

public class MenuExceptions extends Exception {
	  private static final long serialVersionUID = 1L;

	    public MenuExceptions() {
	            super();
	        }

	    public MenuExceptions(String message) {
	            super(message);
	        }

	    public MenuExceptions(String message, Throwable cause) {
	            super(message, cause);
	        }

	    public MenuExceptions(Throwable cause) {
	            super(cause);
	        }

}
