package solution.designpatterns.singletonpattern;

public class DatabaseConnection {
	
	private static DatabaseConnection theInstance;
	
	// Singleton implemented according to double-checking idiom.
	public static DatabaseConnection getInstance() {
		
		// Avoid synchronization lock in common case. 
		if (theInstance == null) {

			// Synchronize against multiple threads.
			synchronized (DatabaseConnection.class) {
				
				// Just in case another thread got in before we synch'd... 
				if (theInstance == null) {

					// Create single instance.
					theInstance = new DatabaseConnection();
				}
			}
		}
		
		return theInstance;
	}
	
	private DatabaseConnection() {
	}
	
	public int someQuery() {
		return 42;
	}
}
