
import java.awt.Dimension;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.*;

public class UIManager291 extends JFrame{
	
	// Global variables
	DBManager291 db;
	JTextPane output = new JTextPane();
	JPanel middlePane = new JPanel();
	// each contextPane represents a different functional requirement
	JPanel contextPane1 = new JPanel(); // Get Parts List Context
	JPanel contextPane2 = new JPanel(); // Create PO Context
	JPanel contextPane3 = new JPanel(); // Create Line Context
	JPanel contextPane4 = new JPanel(); // Get Lines by poID Context
	JPanel contextPane5 = new JPanel(); // Get POs by clientID Context
	
	
	public UIManager291(){
		db = new DBManager291(this);
	}
	
	// Creates and organizes all UI elements
	public void setup291() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,700);
		setVisible(true);
		setTitle("CSCI 4140 A2");
		setLocation(10,50);
		setResizable(false);
		
		JPanel content = new JPanel();
		content.setLayout(new BoxLayout(content,BoxLayout.PAGE_AXIS));
		
		JPanel topPane = new JPanel();
		
		JScrollPane outPane = new JScrollPane(output);
		outPane.setPreferredSize(new Dimension(900,300));
		output.setEditable(false);
		output.setText("Console:");
		
		JButton c1_button1 = new JButton("Get Parts List");
		c1_button1.addActionListener(e -> getParts291());
		
		
		JButton c2_button = new JButton("Submit");
		JTextField c2_poNo = new JTextField();
		c2_poNo.setPreferredSize(new Dimension(70,25));
		JLabel c2_poLabel = new JLabel();
		c2_poLabel.setText("PO#");
		JTextField c2_status = new JTextField();
		c2_status.setPreferredSize(new Dimension(100,25));
		JLabel c2_statusLabel = new JLabel();
		c2_statusLabel.setText("Status:");
		JTextField c2_client = new JTextField();
		c2_client.setPreferredSize(new Dimension(70,25));
		JLabel c2_clientLabel = new JLabel();
		c2_clientLabel.setText("Client#");
		JSpinner c2_date = new JSpinner();
		SpinnerDateModel c2_dateModel = new SpinnerDateModel();
		c2_dateModel.setCalendarField(Calendar.DATE);
		c2_date.setModel(c2_dateModel);
		c2_date.setEditor(new JSpinner.DateEditor(c2_date, "yyyy-MM-dd"));
		JLabel c2_dateLabel = new JLabel();
		c2_dateLabel.setText("Date:");
		c2_button.addActionListener(e -> createPO291(c2_poNo.getText(),c2_date,c2_status.getText(),c2_client.getText()));
		
		
		JButton c3_button = new JButton("Submit");
		JTextField c3_qty = new JTextField();
		c3_qty.setPreferredSize(new Dimension(70,25));
		JLabel c3_qtyLabel = new JLabel();
		c3_qtyLabel.setText("QTY:");
		JTextField c3_price = new JTextField();
		c3_price.setPreferredSize(new Dimension(70,25));
		JLabel c3_priceLabel = new JLabel();
		c3_priceLabel.setText("Price:");
		JTextField c3_partNo = new JTextField();
		c3_partNo.setPreferredSize(new Dimension(70,25));
		JLabel c3_partLabel = new JLabel();
		c3_partLabel.setText("PartNo:");
		JTextField c3_poNo = new JTextField();
		c3_poNo.setPreferredSize(new Dimension(70,25));
		JLabel c3_poLabel = new JLabel();
		c3_poLabel.setText("PO#");
		JTextField c3_LineNo = new JTextField();
		c3_LineNo.setPreferredSize(new Dimension(70,25));
		JLabel c3_lineLabel = new JLabel();
		c3_lineLabel.setText("Line:");
		c3_button.addActionListener(e -> createPOLine291(c3_poNo.getText(),c3_partNo.getText()
				,c3_qty.getText(),c3_price.getText(),c3_LineNo.getText()));
		
		
		JButton c4_button = new JButton("Submit");
		JTextField c4_input = new JTextField();
		c4_input.setPreferredSize(new Dimension(200,25));
		JLabel c4_hint = new JLabel();
		c4_hint.setText("enter PO# to query");
		c4_button.addActionListener(e -> getPOLines291(c4_input.getText()));
		
		JButton c5_button = new JButton("Submit");
		JTextField c5_input = new JTextField();
		c5_input.setPreferredSize(new Dimension(200,25));
		JLabel c5_hint = new JLabel();
		c5_hint.setText("enter ClientID to query");
		c5_button.addActionListener(e -> getPOs291(c5_input.getText()));
		
		
		JButton changeContext1 = new JButton("Parts List");
		changeContext1.addActionListener(e -> changeContext291(1));
		JButton changeContext2 = new JButton("Create Purchase Order");
		changeContext2.addActionListener(e -> changeContext291(2));
		JButton changeContext3 = new JButton("Creat PO line");
		changeContext3.addActionListener(e -> changeContext291(3));
		JButton changeContext4 = new JButton("Get Lines by POId");
		changeContext4.addActionListener(e -> changeContext291(4));
		JButton changeContext5 = new JButton("Get POs by client");
		changeContext5.addActionListener(e -> changeContext291(5));
		
		topPane.add(changeContext1);
		topPane.add(changeContext2);
		topPane.add(changeContext3);
		topPane.add(changeContext4);
		topPane.add(changeContext5);
		
		contextPane1.add(c1_button1);
		
		contextPane2.add(c2_poLabel);
		contextPane2.add(c2_poNo);
		contextPane2.add(c2_dateLabel);
		contextPane2.add(c2_date);
		contextPane2.add(c2_statusLabel);
		contextPane2.add(c2_status);
		contextPane2.add(c2_clientLabel);
		contextPane2.add(c2_client);
		contextPane2.add(c2_button);
		
		
		contextPane3.add(c3_poLabel);
		contextPane3.add(c3_poNo);
		contextPane3.add(c3_lineLabel);
		contextPane3.add(c3_LineNo);
		contextPane3.add(c3_partLabel);
		contextPane3.add(c3_partNo);
		contextPane3.add(c3_qtyLabel);
		contextPane3.add(c3_qty);
		contextPane3.add(c3_priceLabel);
		contextPane3.add(c3_price);
		contextPane3.add(c3_button);
		
		contextPane4.add(c4_hint);
		contextPane4.add(c4_input);
		contextPane4.add(c4_button);
		
		contextPane5.add(c5_hint);
		contextPane5.add(c5_input);
		contextPane5.add(c5_button);
		
		middlePane.add(contextPane1);
		
		content.add(topPane);
		content.add(middlePane);
		content.add(outPane);
		
		getContentPane().add(content);
		
		validate();
	}

	// Methods for getting data from the DBManager and writing it to the UI
	private void getParts291() {
		ArrayList<ArrayList<String>> queryResponse = db.partsQuery291();
		if(queryResponse.isEmpty()) {
			println291("No data returned");
			return;
		}
		println291("PartId\tName\tprice");
		print2DArray291(queryResponse);
	}
	private void getPOLines291(String poNum291) {
		if(poNum291.isEmpty()) {
			println291("One or more inputs are invalid");
			return;
		}
		ArrayList<ArrayList<String>> queryResponse = db.POLineQuery291(Integer.parseInt(poNum291));
		if(queryResponse.isEmpty()) {
			println291("No data returned");
			return;
		}
		println291("PO#\tLineNo\tPartId\tQTY\tPrice");
		print2DArray291(queryResponse);
	}
	private void getPOs291(String clientID291) {
		if(clientID291.isEmpty()) {
			println291("One or more inputs are invalid");
			return;
		}
		ArrayList<ArrayList<String>> queryResponse = db.POsQuery291(Integer.parseInt(clientID291));
		if(queryResponse.isEmpty()) {
			println291("No data returned");
			return;
		}
		println291("PO#\tDate\tStatus\tClientId");
		print2DArray291(queryResponse);
	}
	// Methods for sending data to the DBManager to modify the Database and printing success/fail message
	private void createPO291(String poNo291, JSpinner dateSpinner291, String status291, String clientId291) {
		if(poNo291.isBlank() || clientId291.isBlank()) {
			println291("One or more inputs are blank");
			return;
		}
		
		Date date = new Date(((java.util.Date)dateSpinner291.getValue()).getTime());
		
		if(db.addPO291(Integer.parseInt(poNo291), date, status291, Integer.parseInt(clientId291))) {
			println291("Created new Purchase Order successfully");
		}else {
			println291("failed to create PO");
		}
	}
	private void createPOLine291(String poNo291, String partNo291, String qty291, String price291, String lineNo291) {
		
		if(poNo291.isBlank() || partNo291.isBlank() || qty291.isBlank() || price291.isBlank() || lineNo291.isBlank()) {
			println291("One or more inputs are blank");
			return;
		}
		
		if(db.addLine291(Integer.parseInt(poNo291), Integer.parseInt(partNo291), Integer.parseInt(qty291)
				, Double.parseDouble(price291), Integer.parseInt(lineNo291))){
			println291("Created new line in PO");
		}else {
			println291("Failed to create Line");
		}
	}
	
	// Switches the active UI components to a different context
	private void changeContext291(int context291) {
		switch(context291) {
			case 1:
				middlePane.removeAll();
				middlePane.add(contextPane1);
				repaint();
				validate();
				break;
			case 2:
				middlePane.removeAll();
				middlePane.add(contextPane2);
				repaint();
				validate();
				break;
			case 3:
				middlePane.removeAll();
				middlePane.add(contextPane3);
				repaint();
				validate();
				break;
			case 4:
				middlePane.removeAll();
				middlePane.add(contextPane4);
				repaint();
				validate();
				break;
			case 5:
				middlePane.removeAll();
				middlePane.add(contextPane5);
				repaint();
				validate();
				break;
		}
	}
	
	// Three methods for printing to the output pane in the UI
	public void print291(String text291) {
		output.setText(output.getText().concat(text291));
	}
	public void println291(String text291) {
		output.setText(output.getText().concat("\n"+text291));
	}
	private void print2DArray291(ArrayList<ArrayList<String>> data291) {
		for(ArrayList<String> row: data291) {
			print291("\n");
			for(String e: row) {
				print291(e + "\t");
			}
		}
	}
	

}
