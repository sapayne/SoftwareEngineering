package Database;

//written by Samuel Payne

import java.io.File;

public class DatabaseReader {
	
	//used to read the file into memory unless the file doesn't exist and then it returns null
	public File read(String fileName, String fileType) {
		File file = null;

		switch(fileType) {
		case "item":
			try {
				file = new File("../" + fileName);
			} catch(NullPointerException error) {
				return null;
			}
			break;
		case "user":
			try {
				file = new File("../users/" + fileName);
			} catch(NullPointerException error) {
				return null;
			}
			break;	
		case "pass":
			try {
				file = new File("../" + fileName);
			} catch(NullPointerException error) {
				return null;
			}
			break;	
		}
		return file;
	}
}
