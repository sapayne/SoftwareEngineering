package Database;

//written by Samuel Payne

import java.io.File;

public class DatabaseReader {
	
	//used to read the file into memory unless the file doesn't exist and then it returns null
	protected File read(String fileName, String fileType) {
		File file = null;
		File dir = new File(fileName);

		switch(fileType) {
		case "item":
			try {
				String filePath = dir.getAbsolutePath();
				file = new File(filePath.substring(0,dir.getAbsolutePath().lastIndexOf(fileName)) + "src//" + fileName);
			} catch(NullPointerException error) {
				return null;
			}
			break;
		case "user":
			try {
				String filePath = dir.getAbsolutePath();
				file = new File(filePath.substring(0,dir.getAbsolutePath().lastIndexOf(fileName)) + "src//users//" + fileName);
			} catch(NullPointerException error) {
				return null;
			}
			break;	
		case "pass":
			try {
				String filePath = dir.getAbsolutePath();
				file = new File(filePath.substring(0,dir.getAbsolutePath().lastIndexOf(fileName)) + "src//" + fileName);
			} catch(NullPointerException error) {
				return null;
			}
			break;	
		case "image":
			try {
				String filePath = dir.getAbsolutePath();
				file = new File(filePath.substring(0,dir.getAbsolutePath().lastIndexOf(fileName)) + "src//itemImages//" + fileName);
			} catch(NullPointerException error) {
				return null;
			}
			break;	
		}
		return file;
	}
}
