package coursework;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.awt.event.ActionEvent;

public class CheckoutPage extends JFrame {
	
	// this page is for when the user is buying a product

	private JPanel contentPane;
	private JTextField emailField;
	private JTextField cardNumField;
	private JTextField cardSecField;

	public CheckoutPage(Customer c, List<Product> stockList, HashMap<Integer, Integer> prodWithQuantity) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(360, 50, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHECKOUT");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 64));
		lblNewLabel.setBounds(400, 57, 400, 129);
		contentPane.add(lblNewLabel);
		
		// goes back to customer page
		JButton btnBackButton = new JButton("BACK");
		btnBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerPage cusPage = new CustomerPage(c, stockList);
				dispose();
				cusPage.setVisible(true);
			}
		});
		btnBackButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBackButton.setBounds(200, 650, 200, 70);
		contentPane.add(btnBackButton);
		
		// quits program
		JButton btnExitButton = new JButton("EXIT");
		btnExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExitButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExitButton.setBounds(800, 650, 200, 70);
		contentPane.add(btnExitButton);
		
		JLabel lblMessage = new JLabel("");
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setBounds(450, 462, 300, 117);
		contentPane.add(lblMessage);
		
		JLabel lblPayPalTitle = new JLabel("Pay With PayPal");
		lblPayPalTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPayPalTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblPayPalTitle.setBounds(150, 218, 200, 34);
		contentPane.add(lblPayPalTitle);
		
		JLabel lblCardTitle = new JLabel("Pay With Card");
		lblCardTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCardTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblCardTitle.setBounds(850, 218, 200, 34);
		contentPane.add(lblCardTitle);
		
		JLabel lblEmail = new JLabel("Enter PayPal Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(30, 303, 185, 34);
		contentPane.add(lblEmail);
		
		emailField = new JTextField();
		emailField.setBounds(225, 303, 249, 34);
		contentPane.add(emailField);
		emailField.setColumns(10);
		
		// if user tries to pay with paypal
		JButton btnPayPal = new JButton("Pay With PayPal");
		btnPayPal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// create payment class
				PayPal paymentMethod = new PayPal(emailField.getText());
				// if valid format, go ahead with payment
				if (paymentMethod.validatePayment()) {
					String basketText = "Payment Complete";
					lblMessage.setText(basketText);
					try {
						HashMap<Integer, Integer> prodWithQuantity = c.getBasketWithQuantity();
						List<String> fileList = FileManager.fileToString();
						try {
							// updates the activity log and stock files
							paymentMethod.completeTransaction(prodWithQuantity, stockList);
							FileManager.writeNewLog(fileList, c, prodWithQuantity, stockList, "purchased", "PayPal");	
						} catch (Exception e1) {
						}
					} catch (FileNotFoundException e1) {
					}
					c.clearBasket();				
				} else {
					System.out.println("Invalid Inputs");
				}
			}
		});
		btnPayPal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPayPal.setBounds(163, 380, 187, 51);
		contentPane.add(btnPayPal);
		
		JLabel lblEnterCardNumber = new JLabel("Enter Card Number:");
		lblEnterCardNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEnterCardNumber.setBounds(615, 303, 185, 34);
		contentPane.add(lblEnterCardNumber);
		
		JLabel lblEnterSecurityNumber = new JLabel("Enter Security Number:");
		lblEnterSecurityNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterSecurityNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEnterSecurityNumber.setBounds(586, 348, 214, 34);
		contentPane.add(lblEnterSecurityNumber);
		
		cardNumField = new JTextField();
		cardNumField.setColumns(10);
		cardNumField.setBounds(820, 303, 249, 34);
		contentPane.add(cardNumField);
		
		cardSecField = new JTextField();
		cardSecField.setColumns(10);
		cardSecField.setBounds(820, 348, 249, 34);
		contentPane.add(cardSecField);
		
		// if the user chooses to pay with card. Is identical to paypal method
		JButton btnPayWithCard = new JButton("Pay With Card");
		btnPayWithCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Card paymentMethod = new Card(Long.parseLong(cardNumField.getText()), Integer.parseInt(cardSecField.getText()));
				if (paymentMethod.validatePayment()) {
					String basketText = "Payment Complete";
					lblMessage.setText(basketText);
					try {
						HashMap<Integer, Integer> prodWithQuantity = c.getBasketWithQuantity();
						List<String> fileList = FileManager.fileToString();
						try {
							paymentMethod.completeTransaction(prodWithQuantity, stockList);
							FileManager.writeNewLog(fileList, c, prodWithQuantity, stockList, "purchased", "Credit Card");		
						} catch (Exception e1) {
						}
					} catch (FileNotFoundException e1) {
					}
					c.clearBasket();
				} else {
					System.out.println("Invalid Inputs");
				}
			}
		});
		btnPayWithCard.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPayWithCard.setBounds(850, 418, 187, 51);
		contentPane.add(btnPayWithCard);
		
	}
}
