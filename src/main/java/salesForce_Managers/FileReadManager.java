package salesForce_Managers;

import salesForce_Configuration.ConfogFileReader;

public class FileReadManager {
	
	private FileReadManager () {
		
	}
private static FileReadManager fileReadManager= new FileReadManager();

public static FileReadManager getInstance() {
	return fileReadManager;	
}
ConfogFileReader confogFileReader;
public ConfogFileReader getConfigReader() {
	return (confogFileReader==null)? new ConfogFileReader():confogFileReader;
	
}
}
