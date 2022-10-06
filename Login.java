package coursework;

import java.awt.EventQueue;

//this file acts like the main file and is what is run to start the program

import java.io.FileNotFoundException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;

	// creates the window
	public static void main(String[] args) {
       		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Login() throws FileNotFoundException {
		
		// creating lists of customers, admins and stock. These are used throughout the code
		        
        List<Customer> customers = FileManager.createCustomers();
        List<Admin> admins = FileManager.createAdmins();
        List<Product> stockList = FileManager.createStockList();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(360, 50, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginLabel = new JLabel("LOGIN");
		lblLoginLabel.setFont(new Font("Tahoma", Font.PLAIN, 64));
		lblLoginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginLabel.setBounds(400, 57, 400, 129);
		contentPane.add(lblLoginLabel);
		
		JComboBox loginOps = new JComboBox();
		// adding the users to the combobox, so if new users are added they will automatically appear
		for (int i=0;i<admins.size();i++) {
			Admin a = admins.get(i);
			loginOps.addItem(a.getUsername());
		}
		for (int i=0;i<customers.size();i++) {
			Customer c = customers.get(i);
			loginOps.addItem(c.getUsername());
		}
		loginOps.setSelectedItem(null);
		loginOps.setBounds(509, 280, 182, 57);
		contentPane.add(loginOps);
		
		JLabel lblUsersTitle = new JLabel("Choose User:");
		lblUsersTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsersTitle.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblUsersTitle.setBounds(120, 270, 271, 79);
		contentPane.add(lblUsersTitle);
		
		JButton btnSelectButton = new JButton("SELECT");
		btnSelectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isAdmin = false;
				boolean isCustomer = false;
				try {
					// checks if user is admin
					String chosenUser = (String)loginOps.getSelectedItem();
					for (int i=0;i<admins.size();i++) {
						Admin a = admins.get(i);
						if (a.getUsername().equals(chosenUser)) {
							isAdmin = true;
							break;
						}
					}
					// checks if user is customer
					for (int i=0;i<customers.size();i++) {
						Customer c = customers.get(i);
						if (c.getUsername().equals(chosenUser)) {
							isCustomer = true;
							break;
						}
					}
					// wont do anything if nothing selected
					if (chosenUser.isEmpty()) {
					}
					//runs admin if user is admin
					else if (isAdmin) {
						for (int i=0;i<admins.size();i++) {
							Admin a = admins.get(i);
							if (a.getUsername().equals(chosenUser)) {
								// send a here
								AdminPage adPage = new AdminPage(a, stockList);
								setVisible(false);
								adPage.setVisible(true);
								break;
							}
						}
						// runs customer if user is customer
					} else if (isCustomer) {
						for (int i=0;i<customers.size();i++) {
							Customer c = customers.get(i);
							if (c.getUsername().equals(chosenUser)) {
								CustomerPage cusPage = new CustomerPage(c, stockList);
								setVisible(false);
								cusPage.setVisible(true);
								break;
							}
						}
					} 
				}
				catch (NullPointerException e1) {
				}
			}
		});
		btnSelectButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSelectButton.setBounds(200, 650, 200, 70);
		contentPane.add(btnSelectButton);
		
		JButton btnExitButton = new JButton("EXIT");
		btnExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExitButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExitButton.setBounds(800, 650, 200, 70);
		contentPane.add(btnExitButton);
	}
}
