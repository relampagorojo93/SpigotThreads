package relampagorojo93.LibsCollection.SpigotThreads.Exceptions;

public class AlreadyStartedException extends Exception {
	
	private static final long serialVersionUID = 870914626789147422L;
	
	@Override
	public String getMessage() {
		return "This thread is already running!";
	}
}
