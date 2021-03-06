package Database;

//written by Samuel Payne

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DatabaseWriter {
	
	protected boolean add(String fileName, item[] item) {
		if(item == null) {
			try {
				File dir = new File(fileName);
				String filePath = dir.getAbsolutePath();
				File file = new File(filePath.substring(0,dir.getAbsolutePath().lastIndexOf(fileName)) + "src//" + fileName);
				FileWriter fileWriter = new FileWriter(file);
				BufferedWriter writer = new BufferedWriter(fileWriter);
				writer.write("");
				writer.close();
				return true;
			} catch(IOException error) {
				return false;
			}
			
		} else {
			try {
				File dir = new File(fileName);
				String filePath = dir.getAbsolutePath();
				File file = new File(filePath.substring(0,dir.getAbsolutePath().lastIndexOf(fileName)) + "src//" + fileName);
				FileWriter fileWriter = new FileWriter(file);
				BufferedWriter writer = new BufferedWriter(fileWriter);
				for(int i = 0; i < item.length; i++) {
					item itemToWrite = item[i];
					writer.write(itemToWrite.getName() + "," + itemToWrite.getBrand() + "," + itemToWrite.getCategory() + "," + itemToWrite.getDescription() + "," + itemToWrite.getImage() + "," + itemToWrite.getPrice() + "," + itemToWrite.getWeight() + "," + itemToWrite.getQuantity() + "," + itemToWrite.getNumberSold() + "," + itemToWrite.getPopularity() + "," + itemToWrite.getNumReviewed());
					writer.newLine();
				}
				writer.close();
				return true;
			} catch (IOException error) {
				return false;
			}
		}
	}
	
	//writes all of the users information to a unique user file
	protected boolean add(String fileName, user user) {
		if(user == null) {
			try {
				File dir = new File(fileName);
				String filePath = dir.getAbsolutePath();
				File file = new File(filePath.substring(0,dir.getAbsolutePath().lastIndexOf(fileName)) + "src//users//" + fileName);
				FileWriter fileWriter = new FileWriter(file);
				BufferedWriter writer = new BufferedWriter(fileWriter);
				writer.write("");
				writer.close();
				return true;
			}catch(IOException error) {
				return false;
			}
		} else {
			try {
				File dir = new File(fileName);
				String filePath = dir.getAbsolutePath();
				File file = new File(filePath.substring(0,dir.getAbsolutePath().lastIndexOf(fileName)) + "src//users//" + fileName);
				FileWriter fileWriter = new FileWriter(file);
				BufferedWriter writer = new BufferedWriter(fileWriter);
				
				//writes username (email address) and password index into the file
				writer.write("username: " + user.getUserName());
				writer.newLine();
				writer.write("password: " + user.getPassword());
				writer.newLine();
				
				//customer names file writing section
				writer.write("name: ");
				for(int i = 0; i < user.getNameSize(); i++) {
					writer.write(user.getName(i));
					if(i != user.getNameSize()-1) {
						writer.write(", ");
					}
				}
				writer.newLine();
				
				//shipping address file writing section
				writer.write("shipping: ");
				for(int i = 0; i < user.getShippingSize(); i++) {
					writer.write(user.getShipping(i));
					if(i != user.getShippingSize()-1) {
						writer.write(", ");
					}
				}
				writer.newLine();
				
				//billing address file writing section 
				writer.write("billing: ");
				for(int i = 0; i < user.getBillingSize(); i++) {
					writer.write(user.getBilling(i));
					if(i != user.getBillingSize()-1) {
						writer.write(", ");
					}
				}
				writer.newLine();
				
				//credit card file writing section
				writer.write("card: ");
				for(int i = 0; i < user.getCreditCardSize(); i++) {
					writer.write(user.getCreditCard(i));
					if(i != user.getCreditCardSize()-1) {
						writer.write(", ");
					}
				}
				writer.newLine();
				
				//format the previous orders correctly easiest format would probably be 
				//[order info],[order info],...,[order info] will probably need 2 for loops
				writer.write("previousOrders: ");
				String[][] ordersToWrite = user.getAllPreviousOrders();
				for(int i = 0; i < ordersToWrite.length; i++) {
					//writer.write("[");
					for(int j = 0; j < 5; j++) {
						writer.write(ordersToWrite[i][j]);
						//if(j != 4) {
							writer.write(",");
						//}
					}
					/*writer.write("]");
					if(i != ordersToWrite.length - 1) {
						writer.write(",");
					}*/
				}
				//closing file
				writer.close();
				return true;
			} catch (IOException error) {
				return false;
			}
		}
	}
	
	//used to write all the passwords in order to the file
	protected boolean add(String fileName, Password[] passwords) {
		/*
	 File dir = new File(fileName);
        String filePath = dir.getAbsolutePath();
			try {
				File file = new File(filePath.substring(0,dir.getAbsolutePath().lastIndexOf(fileName)) + "src//itemImages//" + fileName);
				return image;
			} catch (IOException error) {
				System.out.println("no image display");
				return null;
			}
		 */
		if(passwords == null) {
			try {
				File dir = new File(fileName);
				String filePath = dir.getAbsolutePath();
				File file = new File(filePath.substring(0,dir.getAbsolutePath().lastIndexOf(fileName)) + "src//" + fileName);
				FileWriter fileWriter = new FileWriter(file);
				BufferedWriter writer = new BufferedWriter(fileWriter);
				writer.write("");
				writer.close();
				return true;
			}catch(IOException error) {
				return false;
			}
		} else {
			try {
				File dir = new File(fileName);
				String filePath = dir.getAbsolutePath();
				File file = new File(filePath.substring(0,dir.getAbsolutePath().lastIndexOf(fileName)) + "src//" + fileName);
				FileWriter fileWriter = new FileWriter(file);
				BufferedWriter writer = new BufferedWriter(fileWriter);
				for(int i =0; i < passwords.length; i++) {
					writer.write(passwords[i].getPassword() + ", " + passwords[i].getQuantity());
					if(i != passwords.length - 1) {
						writer.newLine();	
					}
				}
				writer.close();
				return true;
			}catch (IOException error) {
				return false;
			}	
		}
	}

	//not currently used
	/*protected boolean remove(String category, int index) {
		return true;
	}*/
}
