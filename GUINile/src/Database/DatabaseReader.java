package Database;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class DatabaseReader {

	public File read(String fileName, String fileType) {
		File file = null;
		// checks to see if the file exists
		if("../" + fileName != null || "../users/" + fileName != null) {
			switch(fileType) {
			case "item":
				return file = new File("../" + fileName);
			case "user":
				return file = new File("../users/" + fileName);
			case "pass":
				return file = new File("../" + fileName);
			
			}
		}
		return file;
	}
}
