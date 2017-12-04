package Database;

//written by Samuel Payne

import java.io.File;

public class DatabaseReader {
	
	//used to read the file into memory unless the file doesn't exist and then it returns null
	protected File read(String fileName, String fileType) {
		File file = new File(fileName);
		String filePath = file.getAbsolutePath();
		switch(fileType) {
		case "item":
			try {
				return file = new File(filePath.substring(0,file.getAbsolutePath().lastIndexOf(fileName)) + "src//" + fileName);
			} catch(NullPointerException error) {
				return null;
			}
		case "user":
			try {
				return file = new File(filePath.substring(0,file.getAbsolutePath().lastIndexOf(fileName)) + "src//users//" + fileName);
			} catch(NullPointerException error) {
				return null;
			}
		case "pass":
			try {
				return file = new File(filePath.substring(0,file.getAbsolutePath().lastIndexOf(fileName)) + "src//" + fileName);
			} catch(NullPointerException error) {
				return null;
			}
		case "image":
			try {
				return file = new File(filePath.substring(0,file.getAbsolutePath().lastIndexOf(fileName)) + "src//itemImages//" + fileName);
			} catch(NullPointerException error) {
				return null;
			}	
		}
		return file;
	}
}
