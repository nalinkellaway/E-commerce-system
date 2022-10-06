package coursework;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;

public class AdminPage extends JFrame {

	private JPanel contentPane;

//this page runs when an admin is logged in
	
	public AdminPage(Admin a, List<Product> stockList) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(360, 50, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(100, 182, 790, 420);
		contentPane.add(scrollPane);
		
		JTextArea resultArea = new JTextArea();
		resultArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPane.setViewportView(resultArea);
		// sorts the stock in order of descending stock number
		Collections.sort(stockList, new StockSorter());
		String textToPrint = "";
		// prints the stock for the user to see
		for (int i=0;i<stockList.size();i++) {
			Product p = stockList.get(i);
			textToPrint = p.printAllAdmin(textToPrint);
		}
		resultArea.setText(textToPrint);
		resultArea.setCaretPosition(0);
		resultArea.setEditable(false);
		
		// exits the program
		JButton btnExitButton = new JButton("EXIT");
		btnExitButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExitButton.setBounds(800, 650, 200, 70);
		contentPane.add(btnExitButton);
		
		JLabel lblAdminTitle = new JLabel("ADMIN");
		lblAdminTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminTitle.setFont(new Font("Tahoma", Font.PLAIN, 64));
		lblAdminTitle.setBounds(400, 57, 400, 129);
		contentPane.add(lblAdminTitle);
		
		// goes back to the login page
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
		
		// goes to the add items page
		JButton btnAddItems = new JButton("ADD ITEMS");
		btnAddItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddProduct prodWindow;
				try {
					prodWindow = new AddProduct(a, stockList);
					setVisible(false);
					prodWindow.setVisible(true);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAddItems.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAddItems.setBounds(969, 182, 136, 53);
		contentPane.add(btnAddItems);
	}
}
