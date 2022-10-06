package coursework;

import java.io.BufferedWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

// this is for all methods relating to text files

public class FileManager {
	private String stockFile;
	private String usersFile;
	
	public FileManager() {
		this.stockFile = "Stock.txt";
		this.usersFile = "UserAccounts.txt";
	}
	
	// creates a list of admins and returns it
	public static List<Admin> createAdmins() throws FileNotFoundException {
		File userAccounts = new File("UserAccounts.txt");
        Scanner fileScanner = new Scanner(userAccounts);
        List<Customer> customers = new ArrayList<>();
        List<Admin> admins = new ArrayList<>();
        
        while (fileScanner.hasNextLine()) {
            String[] details = fileScanner.nextLine().split(",");

            int id = Integer.parseInt(details[0].trim());
            String userName = details[1].trim();
            String surname = details[2].trim();
            String accountType = details[6].trim();
            
            int houseNumber = Integer.parseInt(details[3].trim());
            String postCode = details[4].trim();
            String city = details[5].trim();

            Address address = new Address(houseNumber, postCode, city);
            if (accountType.equals("admin"))
                admins.add(new Admin(id, userName, surname, address));            
        }
        
        fileScanner.close();
        return admins;
	}
	
	// creates a list of customers and returns it
	public static List<Customer> createCustomers() throws FileNotFoundException {
		File userAccounts = new File("UserAccounts.txt");
        Scanner fileScanner = new Scanner(userAccounts);
        List<Customer> customers = new ArrayList<>();
        
        while (fileScanner.hasNextLine()) {
            String[] details = fileScanner.nextLine().split(",");

            int id = Integer.parseInt(details[0].trim());
            String userName = details[1].trim();
            String surname = details[2].trim();
            String accountType = details[6].trim();
            
            int houseNumber = Integer.parseInt(details[3].trim());
            String postCode = details[4].trim();
            String city = details[5].trim();

            Address address = new Address(houseNumber, postCode, city);
            if (accountType.equals("customer")) {
            	customers.add(new Customer(id, userName, surname, address));
            }
        }
        
        fileScanner.close();
        return customers;
	}
	// creates a list of all stock
	public static List<Product> createStockList() throws FileNotFoundException {
		File stock = new File("Stock.txt");
        Scanner stockScanner = new Scanner(stock);
        List<Product> stockList = new ArrayList<>();
        
        while (stockScanner.hasNextLine()) {
        	String[] splitStock = stockScanner.nextLine().split(",");
        	
        	boolean wireless;
        	
        	String type = "";
      	       	
        	try {
        		type = splitStock[1].trim();
        	} catch (ArrayIndexOutOfBoundsException e) {
        		break;
        	}
        	
        	int barcode = Integer.parseInt(splitStock[0].trim());
        	String brand = splitStock[3].trim();
        	String colour = splitStock[4].trim();
        	if (splitStock[5].trim().equals("wireless")) {
        		wireless = true;
        	} else {
        		wireless = false;
        	}
        	int stockNum = Integer.parseInt(splitStock[6].trim());
        	float originalCost = Float.parseFloat(splitStock[7].trim());
        	float retailPrice = Float.parseFloat(splitStock[8].trim());
        	
        	if (type.toLowerCase().equals("keyboard")) {
        
        		KeyboardLayout keyboardLayout;
        		KeyboardType keyboardType;
        		
        		if (splitStock[2].trim().toLowerCase().equals("standard")) {
        			keyboardType = KeyboardType.STANDARD;
        		} else if (splitStock[2].trim().toLowerCase().equals("internet")) {
        			keyboardType = KeyboardType.INTERNET;
        		} else if (splitStock[2].trim().toLowerCase().equals("gaming")) {
        			keyboardType = KeyboardType.GAMING;
        		} else {
        			keyboardType = KeyboardType.FLEXIBLE;
        		}

        		if (splitStock[9].trim().toUpperCase().equals("UK")) {
        			keyboardLayout = KeyboardLayout.UK;
        		} else {
        			keyboardLayout = KeyboardLayout.US;
        		}
        		
        		stockList.add(new Keyboard(barcode, brand, colour, wireless, stockNum, originalCost, retailPrice, keyboardType, keyboardLayout));
        		
        	} else {
        		
        		MouseType mouseType;
        		
        		if (splitStock[2].trim().toLowerCase().equals("standard")) {
        			mouseType = MouseType.STANDARD;
        		} else {
        			mouseType = MouseType.GAMING;
        		}	
        		
        		int numOfButtons = Integer.parseInt(splitStock[9].trim());
        		stockList.add(new Mouse(barcode, brand, colour, wireless, stockNum, originalCost, retailPrice, mouseType, numOfButtons));
        	} 
        }
        stockScanner.close();
        return stockList;
	}
	
	// writes a new product to the stock file
	public static void addNewProduct(List<Product> stockList) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("Stock.txt", true));
		
		Product p = stockList.get(stockList.size()-1);
		
		String mkb = "";
		String extra = "";
		String type = "";
		String connect = "";
		String lineToAdd = "";
		
		int barcode = p.getBarcode();
		String brand = p.getBrand();
		String colour = p.getColour().toLowerCase();
		int stockNum = p.getStockNum();
		float cost = p.getOriginalCost();
		float price = p.getRetailPrice();
		
		System.out.println(price);
		
		if (p.getWireless()) {
			connect = "wireless";
		} else {
			connect = "wired";
		}
		
		if (p instanceof Keyboard) {
			extra = ((Keyboard) p).getKeyboardLayout().toString();
			mkb = "keyboard";
			type = ((Keyboard) p).getKeyboardType().toString().toLowerCase();
		} else if (p instanceof Mouse) {
			extra = Integer.toString(((Mouse) p).getNumOfButtons());
			mkb = "mouse";
			type = ((Mouse) p).getMouseType().toString().toLowerCase();
		}
		
		lineToAdd += barcode + ", ";
		lineToAdd += mkb + ", ";
		lineToAdd += type + ", ";
		lineToAdd += brand + ", ";
		lineToAdd += colour + ", ";
		lineToAdd += connect + ", ";
		lineToAdd += stockNum + ", ";
		lineToAdd += cost + ", ";
		lineToAdd += price + ", ";
		lineToAdd += extra;
		
		bw.write(lineToAdd);
		bw.newLine();
		bw.close();	
	}
	
	public static List<String> fileToString() throws FileNotFoundException {
		File userAccounts = new File("ActivityLog.txt");
        Scanner fileScanner = new Scanner(userAccounts);
        List<String> fileList = new ArrayList<String>();
        while (fileScanner.hasNextLine()) {
        	fileList.add(fileScanner.nextLine());
        }
        fileScanner.close();
        return fileList;
	}
	
	// writes a new log to to the log file
	public static void writeNewLog(List<String> fileList, Customer c, HashMap<Integer, Integer> prodWithQuantity, List<Product> stockList, String action, String paymentType) throws Exception {
		File userAccounts = new File("ActivityLog.txt");
        Scanner fileScanner = new Scanner(userAccounts);
        BufferedWriter bw = new BufferedWriter(new FileWriter("ActivityLog.txt", false));
		String newLog = "";
		// gets and formats the current date
		String format = "dd-MM-yyyy";
		String date = new SimpleDateFormat(format).format(new Date());
		// the false in file writer overwrites the current file. the new logs are added first
		for (Integer i : prodWithQuantity.keySet()) {
			for (int j=0;j<stockList.size();j++) {
				if (stockList.get(j).getBarcode() == i) {
					newLog += c.getUserID() + ", " + c.getAddress().getPostcode() + ", " + i + ", " + stockList.get(j).getRetailPrice() + ", " + prodWithQuantity.get(i) + ", " + action + ", " + paymentType + ", " + date;
					userAccounts.delete();
					bw.write(newLog);
					bw.newLine();	
					newLog = "";
				}
			}
		}
		// the older logs are added here
		for (int i=0;i<fileList.size();i++) {
			bw.write(fileList.get(i));
			bw.newLine();
		}
		fileScanner.close();
		bw.close();
	}
	
	// adds all stock to a string and returns it
	public static List<String> stockToString() throws FileNotFoundException {
		File stocks = new File("Stock.txt");
        Scanner fileScanner = new Scanner(stocks);
        List<String> stockFile = new ArrayList<String>();
        while (fileScanner.hasNextLine()) {
        	stockFile.add(fileScanner.nextLine());
        }
        fileScanner.close();
        return stockFile;
	}
	
	// updates the stock file when a purchase happens
	public static void newStocks(List<Product> stockList) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("Stock.txt", false));
		for (int i=0;i<stockList.size();i++) {
			Product p = stockList.get(i);
			String connect;
			if (p.getWireless()) {
				connect = "wireless";
			} else {
				connect = "wired";
			}
			String newLine = p.getBarcode() + ", " + p.getProductType().toLowerCase() + ", " + p.getType() + ", " + p.getBrand() + ", " + p.getColour() + ", " + connect + ", " + p.getStockNum() + ", " + p.getOriginalCost() + ", " + p.getRetailPrice() + ", " + p.getExtraDetail();
			bw.write(newLine);
			bw.newLine();
		}
		bw.close();
	}
}
