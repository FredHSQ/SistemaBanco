package exceptions;

public class ContaExceptions extends Exception{

    private static final long serialVersionUID = 1L;

    public ContaExceptions() {
            super();
        }

    public ContaExceptions(String message) {
            super(message);
        }

    public ContaExceptions(String message, Throwable cause) {
            super(message, cause);
        }

    public ContaExceptions(Throwable cause) {
            super(cause);
        }

}