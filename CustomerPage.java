package coursework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

// this page is shown when a customer logs in

public class CustomerPage extends JFrame {

	private JPanel contentPane;
	private JTextField quantityField;


	public CustomerPage(Customer c, List<Product> stockList) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(360, 50, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCustomerLabel = new JLabel("CUSTOMER");
		lblCustomerLabel.setFont(new Font("Tahoma", Font.PLAIN, 64));
		lblCustomerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerLabel.setBounds(400, 57, 400, 129);
		contentPane.add(lblCustomerLabel);
		
		// creates combobox, adding all the brands that can be seached
		JComboBox searchBox = new JComboBox();
		List<String> brandList = new ArrayList<String>();
		searchBox.addItem("");
		for (int i=0;i<stockList.size();i++) {
			if (brandList.contains(stockList.get(i).getBrand())) {
			} else {
				brandList.add(stockList.get(i).getBrand());
				searchBox.addItem(stockList.get(i).getBrand());
			}
		}
		searchBox.setBounds(253, 183, 139, 25);
		contentPane.add(searchBox);
		
		JLabel lblSearch = new JLabel("Search Brands");
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSearch.setBounds(100, 183, 133, 25);
		contentPane.add(lblSearch);
		
		JCheckBox chckbxUK = new JCheckBox("UK Keyboards");
		chckbxUK.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxUK.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxUK.setBounds(470, 171, 150, 40);
		contentPane.add(chckbxUK);
		
		JLabel lblMessageLabel = new JLabel("");
		lblMessageLabel.setBounds(444, 649, 207, 71);
		contentPane.add(lblMessageLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(100, 215, 753, 348);
		contentPane.add(scrollPane);
		
		// where the products/results are printed
		JTextArea resultArea = new JTextArea();
		resultArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPane.setViewportView(resultArea);
		Collections.sort(stockList, new StockSorter());
		String textToPrint = "";
		for (int i=0;i<stockList.size();i++) {
			Product p = stockList.get(i);
			textToPrint = p.printAll(textToPrint);
		}
		resultArea.setText(textToPrint);
		resultArea.setCaretPosition(0);
		resultArea.setEditable(false);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// gets the values from the checkbox and combobox, and passes them into a search function
				List<Product> searchResults = new ArrayList<Product>();
				String brand = searchBox.getSelectedItem().toString();
				boolean uk = chckbxUK.isSelected();
				for (int i=0;i<stockList.size();i++) {
					Product p = stockList.get(i);
					boolean result = p.getSearchResult(p, brand, uk);
					if (result) {
						searchResults.add(p);
					}
				}

				// gets the results and prints them here
				String textToPrint = "";
				if (searchResults.size() > 0) {
					for (int i=0;i<searchResults.size();i++) {
						Product p = searchResults.get(i);
						String type = p.getType();
						String prodType = p.getProductType();
						String connect = p.getConnectivity();
						textToPrint += "Barcode: " + p.getBarcode() + "          Product Type: " + prodType + "          Type: " + type + "\n";
						textToPrint += "Brand:     " + p.getBrand() + "          Colour: " + p.getColour() + "                       Connectivity: " + connect + "\n";
						if (prodType.equals("Keyboard")) { 
							textToPrint += "Number in stock: " + p.getStockNum() + "       Price £" + String.format("%.2f", p.getRetailPrice()) + "                            Details: " + p.getExtraDetail() + " Layout";
						} else {
							textToPrint += "Number in stock: " + p.getStockNum() + "       Price £" + String.format("%.2f", p.getRetailPrice()) + "                            Details: " + p.getExtraDetail() + " Buttons";
						}
						textToPrint += "\n \n";
					}
				} else {
					textToPrint += "No results";
				}
				resultArea.setEditable(true);
				resultArea.setText(textToPrint);
				resultArea.setCaretPosition(0);
				resultArea.setEditable(false);
				
				
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSearch.setBounds(984, 179, 116, 25);
		contentPane.add(btnSearch);
		
		// goes back to login page
		JButton btnBackButton = new JButton("BACK");
		btnBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login frame;
				try {
					frame = new Login();
					dispose();
					frame.setVisible(true);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnBackButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBackButton.setBounds(200, 650, 200, 70);
		contentPane.add(btnBackButton);
		
		// exits the program
		JButton btnExitButton = new JButton("EXIT");
		btnExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExitButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExitButton.setBounds(800, 650, 200, 70);
		contentPane.add(btnExitButton);
		
		JLabel lblBarcodeLabel = new JLabel("Enter Barcode:");
		lblBarcodeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBarcodeLabel.setBounds(10, 586, 149, 25);
		contentPane.add(lblBarcodeLabel);
		
		// adds all the barcodes so the user can choose when adding to basket
		JComboBox barcodeBox = new JComboBox();
		for (int i=0;i<stockList.size();i++) {
			barcodeBox.addItem(stockList.get(i).getBarcode());
		}
		barcodeBox.setBounds(150, 586, 171, 25);
		barcodeBox.setSelectedItem(null);
		contentPane.add(barcodeBox);
		
		JLabel lblQuantityLabel = new JLabel("Quantity: ");
		lblQuantityLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantityLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQuantityLabel.setBounds(331, 586, 102, 25);
		contentPane.add(lblQuantityLabel);
		
		quantityField = new JTextField();
		quantityField.setText("1");
		quantityField.setBounds(431, 586, 49, 25);
		contentPane.add(quantityField);
		quantityField.setColumns(10);
		
		JTextArea basketArea = new JTextArea();
		basketArea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		basketArea.setBounds(881, 215, 219, 348);
		String basketText = "Basket\n";
		basketArea.setText(basketText);
		contentPane.add(basketArea);
		
		JButton btnBasketButton = new JButton("Add To Basket");
		btnBasketButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i=0;i<stockList.size();i++) {
					Product p = stockList.get(i);
					try {
						// if barcode is selected, and quantity is not greater than the number in stock, item is added
						if (p.getBarcode() == Integer.parseInt(barcodeBox.getSelectedItem().toString())) {
							int quantity = 0;
							try {
								quantity = Integer.parseInt(quantityField.getText());
							} catch (NumberFormatException e1) {
								lblMessageLabel.setText("Quantity must be numeric");
							}
							if (quantity <= p.getStockNum()) {
								for (int j=0;j<quantity;j++) {
									c.addToBasket(p);
									lblMessageLabel.setText("Added to basket");
								}
							} else {
								lblMessageLabel.setText("There aren't enough items in stock to complete this");
							}
						}
					} catch(NullPointerException e1) {
					}
				}
				// used to display the basket to the user
				HashMap<Integer, Integer> prodWithQuantity = c.getBasketWithQuantity();
				String basketText = "Basket\n";
				basketText += c.stringBasket(prodWithQuantity, stockList);
				basketArea.setText(basketText);
			}
		});
		btnBasketButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBasketButton.setBounds(490, 586, 161, 25);
		contentPane.add(btnBasketButton);
		
		// this removes all search parameters and shows all items again
		JButton btnClear = new JButton("CLEAR SEARCH");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textToPrint = "";
				for (int i=0;i<stockList.size();i++) {
					Product p = stockList.get(i);
					textToPrint = p.printAll(textToPrint);
				}
				resultArea.setEditable(true);
				resultArea.setText(textToPrint);
				resultArea.setCaretPosition(0);
				resultArea.setEditable(false);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnClear.setBounds(682, 179, 171, 25);
		contentPane.add(btnClear);
		
		// this clears the basket and updates the log file
		JButton btnClearBasket = new JButton("Clear Basket");
		btnClearBasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String basketText = "Basket\n";
				basketArea.setText(basketText);
				try {
					HashMap<Integer, Integer> prodWithQuantity = c.getBasketWithQuantity();
					List<String> fileList = FileManager.fileToString();
					try {
						FileManager.writeNewLog(fileList, c, prodWithQuantity, stockList, "cancelled", "");
					} catch (Exception e1) {
					}
				} catch (FileNotFoundException e1) {
				}
				c.clearBasket();
			}
		});
		btnClearBasket.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnClearBasket.setBounds(661, 586, 150, 25);
		contentPane.add(btnClearBasket);
		
		// saves the basket and updates the log file
		JButton btnSaveBasket = new JButton("Save Basket");
		btnSaveBasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String basketText = "Basket\n";
				basketArea.setText(basketText);
				try {
					HashMap<Integer, Integer> prodWithQuantity = c.getBasketWithQuantity();
					List<String> fileList = FileManager.fileToString();
					try {
						FileManager.writeNewLog(fileList, c, prodWithQuantity, stockList, "saved", "");
					} catch (Exception e1) {
					}
				} catch (FileNotFoundException e1) {
				}
				c.clearBasket();
			}
		});
		btnSaveBasket.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSaveBasket.setBounds(821, 586, 150, 25);
		contentPane.add(btnSaveBasket);
		
		// goes to the checkout page
		JButton btnBuy = new JButton("BUY");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckoutPage check = new CheckoutPage(c, stockList, c.getBasketWithQuantity());
				setVisible(false);
				check.setVisible(true);
			}
		});
		btnBuy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBuy.setBounds(984, 586, 116, 25);
		contentPane.add(btnBuy);
	}
}
