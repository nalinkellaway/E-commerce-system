package coursework;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

// this page is for adding admins adding a new product

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class AddProduct extends JFrame {

	private JPanel contentPane;
	private JTextField barcodeField;
	private JTextField brandField;
	private JTextField colourField;
	private JTextField stockField;
	private JTextField costField;
	private JTextField priceField;
	private JTextField buttonsField;

	public AddProduct(Admin a, List<Product> stockList) throws FileNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(360, 50, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitleLabel = new JLabel("ADD PRODUCT");
		lblTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 64));
		lblTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleLabel.setBounds(350, 57, 500, 129);
		contentPane.add(lblTitleLabel);
		
////////////////////////////////////////////////////////////////////////////////////////////////
		
		// section contains all the labels and fields needed
		
		JLabel lblBarcodeLabel = new JLabel("BARCODE:");
		lblBarcodeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBarcodeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarcodeLabel.setBounds(100, 217, 146, 25);
		contentPane.add(lblBarcodeLabel);
		
		barcodeField = new JTextField();
		barcodeField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		barcodeField.setBounds(255, 217, 200, 25);
		contentPane.add(barcodeField);
		barcodeField.setColumns(10);
		
		JLabel lblProductLabel = new JLabel("PRODUCT:");
		lblProductLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblProductLabel.setBounds(100, 253, 146, 25);
		contentPane.add(lblProductLabel);
		
		JComboBox productBox = new JComboBox();
		productBox.addItem("Keyboard");
		productBox.addItem("Mouse");
		productBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		productBox.setBounds(255, 253, 200, 25);
		productBox.setSelectedItem(null);
		contentPane.add(productBox);
				
		JLabel lblType = new JLabel("TYPE:");
		lblType.setHorizontalAlignment(SwingConstants.CENTER);
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblType.setBounds(100, 289, 146, 25);
		contentPane.add(lblType);
		
		JComboBox typeBox = new JComboBox();
		typeBox.addItem("STANDARD");
		typeBox.addItem("INTERNET");
		typeBox.addItem("GAMING");
		typeBox.addItem("FLEXIBLE");
		typeBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		typeBox.setBounds(255, 289, 200, 25);
		typeBox.setSelectedItem(null);
		contentPane.add(typeBox);
			
		JLabel lblBrand = new JLabel("BRAND:");
		lblBrand.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrand.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBrand.setBounds(100, 325, 146, 25);
		contentPane.add(lblBrand);
		
		brandField = new JTextField();
		brandField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		brandField.setColumns(10);
		brandField.setBounds(255, 325, 200, 25);
		contentPane.add(brandField);
		
		JLabel lblColour = new JLabel("COLOUR:");
		lblColour.setHorizontalAlignment(SwingConstants.CENTER);
		lblColour.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblColour.setBounds(100, 361, 146, 25);
		contentPane.add(lblColour);
		
		colourField = new JTextField();
		colourField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		colourField.setColumns(10);
		colourField.setBounds(255, 361, 200, 25);
		contentPane.add(colourField);
		
		JLabel lblConnectivity = new JLabel("CONNECTIVITY:");
		lblConnectivity.setHorizontalAlignment(SwingConstants.CENTER);
		lblConnectivity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblConnectivity.setBounds(100, 397, 146, 25);
		contentPane.add(lblConnectivity);
		
		JComboBox connectivityBox = new JComboBox();
		connectivityBox.addItem("Wireless");
		connectivityBox.addItem("Wired");
		connectivityBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		connectivityBox.setBounds(255, 397, 200, 25);
		connectivityBox.setSelectedItem(null);
		contentPane.add(connectivityBox);
		
		JLabel lblNumberInStock = new JLabel("NUMBER IN STOCK:");
		lblNumberInStock.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumberInStock.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNumberInStock.setBounds(64, 433, 182, 25);
		contentPane.add(lblNumberInStock);
		
		stockField = new JTextField();
		stockField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		stockField.setColumns(10);
		stockField.setBounds(255, 433, 200, 25);
		contentPane.add(stockField);
		
		JLabel lblOriginalPrice = new JLabel("ORIGINAL COST:");
		lblOriginalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblOriginalPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOriginalPrice.setBounds(74, 469, 172, 25);
		contentPane.add(lblOriginalPrice);
		
		costField = new JTextField();
		costField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		costField.setColumns(10);
		costField.setBounds(255, 469, 200, 25);
		contentPane.add(costField);
		
		JLabel lblRetailPrice = new JLabel("RETAIL PRICE:");
		lblRetailPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblRetailPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRetailPrice.setBounds(100, 505, 146, 25);
		contentPane.add(lblRetailPrice);
		
		priceField = new JTextField();
		priceField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		priceField.setColumns(10);
		priceField.setBounds(255, 505, 200, 25);
		contentPane.add(priceField);
		
		JLabel lblKbLayout = new JLabel("KB LAYOUT:");
		lblKbLayout.setHorizontalAlignment(SwingConstants.CENTER);
		lblKbLayout.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblKbLayout.setBounds(100, 541, 146, 25);
		contentPane.add(lblKbLayout);
		
		JComboBox layoutBox = new JComboBox();
		layoutBox.addItem("UK");
		layoutBox.addItem("US");
		layoutBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		layoutBox.setBounds(255, 541, 200, 25);
		layoutBox.setSelectedItem(null);
		contentPane.add(layoutBox);
		
		JLabel lblNumberOfButtons = new JLabel("NUMBER OF BUTTONS:");
		lblNumberOfButtons.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumberOfButtons.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNumberOfButtons.setBounds(40, 577, 206, 25);
		contentPane.add(lblNumberOfButtons);
		
		buttonsField = new JTextField();
		buttonsField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonsField.setColumns(10);
		buttonsField.setBounds(255, 577, 200, 25);
		contentPane.add(buttonsField);
		
		JLabel lblKBWARN = new JLabel("Only fill this out if the product is a keyboard");
		lblKBWARN.setHorizontalAlignment(SwingConstants.LEFT);
		lblKBWARN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKBWARN.setBounds(465, 543, 324, 25);
		contentPane.add(lblKBWARN);
		
		JLabel lblMouseWarn = new JLabel("Only fill this out if the product is a mouse");
		lblMouseWarn.setHorizontalAlignment(SwingConstants.LEFT);
		lblMouseWarn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMouseWarn.setBounds(465, 579, 324, 25);
		contentPane.add(lblMouseWarn);
		
		JLabel lblError = new JLabel("");
		lblError.setBounds(800, 314, 351, 39);
		contentPane.add(lblError);
		
		
/////////////////////////////////////////////////////////////////////////////////////////////////		
		
		// quit the program
		JButton btnExitButton = new JButton("EXIT");
		btnExitButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExitButton.setBounds(800, 650, 200, 70);
		contentPane.add(btnExitButton);
		
		// return to admin page
		JButton btnBackButton = new JButton("BACK");
		btnBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPage adPage = new AdminPage(a, stockList);
				dispose();
				adPage.setVisible(true);
			}
		});
		btnBackButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBackButton.setBounds(200, 650, 200, 70);
		contentPane.add(btnBackButton);
		
		JButton btnAddItem = new JButton("ADD ITEM");
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean canProcede = true;
				
				try {
					// getting the values of new prod from the fields
					boolean wireless;
					String keyboardLayout;
					int numOfButtons;
					
					int barcode = Integer.parseInt(barcodeField.getText());
					String product = (String) productBox.getSelectedItem();
					String type = (String) typeBox.getSelectedItem();
					String brand = brandField.getText();
					String colour = colourField.getText();
					int stockNum = Integer.parseInt(stockField.getText());
					float originalCost = Float.parseFloat(costField.getText());
					float retailPrice = Float.parseFloat(priceField.getText());
					
					if (connectivityBox.getSelectedItem().equals("Wireless")) {
						wireless = true;
					} else {
						wireless = false;
					}
					
					// some simple error checking
					if (Integer.toString(barcode).length() != 6) {
						canProcede = false;
						lblError.setText("Barcode Invalid Length");
					}
					
					for (int i=0;i<stockList.size();i++) {
						if (stockList.get(i).getBarcode() == barcode) {
							canProcede = false;
							lblError.setText("Error - Barcode already exists");
						}
					}
					
					if (product.equals("Mouse") && (type.equals("INTERNET") || type.equals("FLEXIBLE"))) {
						canProcede = false;
						lblError.setText("Mouse type must be standard or gaming");
					}
					
					// adding a new mouse
					if (product.equals("Mouse")) {
						
						MouseType mouseType;
						numOfButtons = Integer.parseInt(buttonsField.getText());
						
						if (type.equals("STANDARD")) {
							mouseType = MouseType.STANDARD;
						} else {
							mouseType = MouseType.GAMING;
						}

						stockList.add(new Mouse(barcode, brand, colour, wireless, stockNum, originalCost, retailPrice, mouseType, numOfButtons));
						
					// adding a new keyboard
					} else if (product.equals("Keyboard")) {
						
						keyboardLayout = (String) layoutBox.getSelectedItem();
						if (canProcede) {	
							KeyboardType keyboardType;
							KeyboardLayout layout;
							
							if (type.equals("FLEXIBLE")) {
								keyboardType = KeyboardType.FLEXIBLE;
							} else if (type.equals("STANDARD")) {
								keyboardType = KeyboardType.STANDARD;
							} else if (type.equals("GAMING")) {
								keyboardType = KeyboardType.GAMING;
							} else {
								keyboardType = KeyboardType.INTERNET;
							}
							
							if (keyboardLayout.equals("UK")) {
								layout = KeyboardLayout.UK;
							} else {
								layout = KeyboardLayout.US;
							}
							
							stockList.add(new Keyboard(barcode, brand, colour, wireless, stockNum, originalCost, retailPrice, keyboardType, layout));
						}
					}
					
				// catches when not all fields are entered into
				} catch (Exception e1) {
					lblError.setText("Make sure all fields are filled out correctly");
					canProcede = false;
				}
				
				// updating the stock list
				if (canProcede) {
					lblError.setText("Successfully Added Product");
					try {
						FileManager.addNewProduct(stockList);
					} catch (IOException e1) {
						lblError.setText("Error");
					}
				}
			}
		});
		btnAddItem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAddItem.setBounds(800, 230, 200, 70);
		contentPane.add(btnAddItem);
		
	}
}
