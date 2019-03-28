import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Table;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.*;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class Login_GUI {
	private JFrame frame;
	private JPanel main;		
	private JLabel fname_lbl;
	private JLabel lname_lbl;
	private JLabel sid_lbl;
	private JLabel email_lbl;	
	private JTextField fname_txt;
	private JTextField lname_txt;
	private JTextField sid_txt;
	private JTextField email_txt;
	private JButton submit;

	
	public Login_GUI() {
		initialize();
	}
	
	private void initialize() {
		main = new JPanel();
		main.setLayout(new GridBagLayout());
		main.setBackground(new Color(187,252,151));
		add_MainComponents();
		
		frame = new JFrame("Rise Institute: Maker Space Sign In");
		frame.setBounds(100, 100, 800, 800);
		frame.add(main);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}
	
	private void add_MainComponents() {
//welcome messages		
		GridBagConstraints constraints = new GridBagConstraints();

		Font welcomeFont = new Font("SansSerif", Font.BOLD, 25);
        JLabel welcome1 = new JLabel("Welcome to the Rise Institute: Maker Space!");
        JLabel welcome2 = new JLabel("Please Sign In!");
        welcome1.setFont(welcomeFont);
        welcome2.setFont(welcomeFont);
        
		constraints.insets = new Insets(0,0,500,0);
		constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;
        main.add(welcome1, constraints);
        
        constraints.insets = new Insets(0,0,400,0);
		constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;
        main.add(welcome2, constraints);
        
//text fields
        fname_lbl = new JLabel("First Name:");
        lname_lbl = new JLabel("Last Name:");
        sid_lbl = new JLabel("SID:");
        email_lbl = new JLabel("BC Email:");
        Font myFont = new Font("SansSerif", Font.BOLD, 15);
        fname_lbl.setFont(myFont); lname_lbl.setFont(myFont);sid_lbl.setFont(myFont);email_lbl.setFont(myFont);
        
        fname_txt = new JTextField();
		fname_txt.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				changed();
			}
			public void removeUpdate(DocumentEvent e) {
				changed();
			}
			public void insertUpdate(DocumentEvent e) {
				changed();
			}
			public void changed() {
				if (fname_txt.getText().equals("")){
					submit.setEnabled(false);
				}else if(!fname_txt.getText().equals("") &&
						 !lname_txt.getText().equals("") &&
						 !sid_txt.getText().equals("")   &&
						 !email_txt.getText().equals("")) {
					submit.setEnabled(true);
				}else {
					submit.setEnabled(false);
				}
			}
		});
        
        lname_txt = new JTextField();
        lname_txt.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				changed();
			}
			public void removeUpdate(DocumentEvent e) {
				changed();
			}
			public void insertUpdate(DocumentEvent e) {
				changed();
			}
			public void changed() {
				if (lname_txt.getText().equals("")){
					submit.setEnabled(false);
				}else if(!fname_txt.getText().equals("") &&
						 !lname_txt.getText().equals("") &&
						 !sid_txt.getText().equals("")   &&
						 !email_txt.getText().equals("")) {
					submit.setEnabled(true);
				}else {
					submit.setEnabled(false);
				}
			}
		});
        
        sid_txt = new JTextField();
        sid_txt.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				changed();
			}
			public void removeUpdate(DocumentEvent e) {
				changed();
			}
			public void insertUpdate(DocumentEvent e) {
				changed();
			}
			public void changed() {
				if (sid_txt.getText().equals("")){
					submit.setEnabled(false);
				}else if(!fname_txt.getText().equals("") &&
						 !lname_txt.getText().equals("") &&
						 !sid_txt.getText().equals("")   &&
						 !email_txt.getText().equals("") &&
						 sid_txt.getText().trim().length() == 9 &&
						 (email_txt.getText().trim().toLowerCase().endsWith("@bellevuecollege.edu") ||
						 email_txt.getText().trim().toLowerCase().endsWith("@bc.edu"))) {
					submit.setEnabled(true);
				}else {
					submit.setEnabled(false);
				}
			}
		});
        
        email_txt = new JTextField();
        email_txt.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				changed();
			}
			public void removeUpdate(DocumentEvent e) {
				changed();
			}
			public void insertUpdate(DocumentEvent e) {
				changed();
			}
			public void changed() {
				if (email_txt.getText().equals("")){
					submit.setEnabled(false);
				}else if(!fname_txt.getText().equals("") &&
						 !lname_txt.getText().equals("") &&
						 !sid_txt.getText().equals("")   &&
						 !email_txt.getText().equals("") &&
						 sid_txt.getText().trim().length() == 9 &&
						 (email_txt.getText().trim().toLowerCase().endsWith("@bellevuecollege.edu") ||
						 email_txt.getText().trim().toLowerCase().endsWith("@bc.edu"))) {
					submit.setEnabled(true);
				}else {
					submit.setEnabled(false);
				}
			}
		});
        
        constraints.insets = new Insets(200,0,300,350);
		constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;
        main.add(fname_lbl, constraints);
        
      	constraints.insets = new Insets(200,200,300,20);
        constraints.gridheight = 1;
        constraints.gridwidth = 4;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;	
      	main.add(fname_txt, constraints);
        
        constraints.insets = new Insets(200,70,200,300);
		constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;
        main.add(lname_lbl, constraints);
        
        constraints.insets = new Insets(200,200,200,20);
        constraints.gridheight = 1;
        constraints.gridwidth = 4;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
      	main.add(lname_txt, constraints);
        
        constraints.insets = new Insets(200,117,100,300);
		constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;
        main.add(sid_lbl, constraints);
        
        constraints.insets = new Insets(200,200,100,20);
        constraints.gridheight = 1;
        constraints.gridwidth = 4;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
      	main.add(sid_txt, constraints);
        
        constraints.insets = new Insets(200,80,0,300);
		constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;
        main.add(email_lbl, constraints);
        
        constraints.insets = new Insets(200,200,0,20);
        constraints.gridheight = 1;
        constraints.gridwidth = 4;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
      	main.add(email_txt, constraints);

//submit button
      	submit = new JButton("submit");
      	submit.setEnabled(false);
        constraints.insets = new Insets(400,200,0,300);
		constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;
        main.add(submit, constraints);
                
        submit.addActionListener(
    		new ActionListener() {
    			
    			@Override
    			public void actionPerformed(ActionEvent e) { 
    				try {   
        		        String fname = fname_txt.getText().trim().toLowerCase();
        		        String lname = lname_txt.getText().trim().toLowerCase();
        		        String sid = sid_txt.getText().trim().toLowerCase();
        		        String fix_email = email_txt.getText().trim().toLowerCase().replaceAll("@bc.edu", "@bellevuecollege.edu");
        		        Calendar cal = Calendar.getInstance();
        		               		            			        				
    					Database db = DatabaseBuilder.open(new File("C:\\Users\\Pazuz\\Documents\\RISE SIGN IN\\sign_in.accdb"));
    					Table table = db.getTable("sign_in");
    					table.addRow(fname,lname,sid,fix_email,cal);
    					db.close();		      
    				}catch(Exception err) {
    					err.printStackTrace(System.err);
    				}
    				//resets submit button
    				fname_txt.setText("");
    				lname_txt.setText("");
    				sid_txt.setText("");
    				email_txt.setText("");
    				submit.setEnabled(false);
    			}
    		});
	}
}
