package softwareEngineering;

public class arrayDatabase {
	private int nameSize = 0;
	String [][] userInformation;
	public void userInformation() {
		userInformation = new String[4][5];
	}
	
	public void addName(String name) {
		userInformation[0][getNameSize()] = name;
		nameSize++;
	}
	
	public void remove(String name) {
		int index = find(name);
		userInformation[0][index] = null;
        --nameSize;		
		
	}
	
	public int find(String name) {
		int index = 0; 
		for (int i = 0; i < userInformation[0].length; i++) {
			if (userInformation[0][i] == name)
				index = i;
			else
				System.out.println("Name does not exist");
		}
		return index;
	}
	
	public int getNameSize(){
		return nameSize;
	}
	
	public String getName(int index) {
		return userInformation[0][index];
	}
}
