import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;


public class GUI {

	private JFrame frame;
	private JTextField textField_weight;
	private JTextField textField_gps;
	private JTextField textField_special;
	private JLabel lbl_special;
	private JComboBox comboBox_dental;
	private JComboBox comboBox_sex;
	private JComboBox comboBox_species;
	
	ArrayList<Animal> animalList = new ArrayList<Animal>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 606, 363);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "name_371979642591499");
		panel.setLayout(null);
		
		comboBox_species = new JComboBox();
		comboBox_species.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_species.getSelectedIndex() == 0){
					lbl_special.setText("Blood Pressure in KPA format:");
					comboBox_dental.setVisible(false);
					textField_special.setVisible(true);}
				else if(comboBox_species.getSelectedIndex() == 1){
					lbl_special.setText("Number of Spots:");
					comboBox_dental.setVisible(false);
					textField_special.setVisible(true);}
				else if(comboBox_species.getSelectedIndex() == 2){
					lbl_special.setText("Dental Health:");
					textField_special.setVisible(false);
					comboBox_dental.setVisible(true);}
		}});
		comboBox_species.setModel(new DefaultComboBoxModel(new String[]{"Penguin", "Sea Lion", "Walrus"}));
		comboBox_species.setBounds(21, 108, 119, 26);
		panel.add(comboBox_species);
		
		comboBox_sex = new JComboBox();
		comboBox_sex.setModel(new DefaultComboBoxModel(Sex.values()));
		comboBox_sex.setBounds(202, 108, 119, 26);
		panel.add(comboBox_sex);
		
		textField_weight = new JTextField();
		textField_weight.setBounds(21, 219, 119, 26);
		panel.add(textField_weight);
		textField_weight.setColumns(10);
		
		textField_gps = new JTextField();
		textField_gps.setBounds(202, 219, 119, 26);
		panel.add(textField_gps);
		textField_gps.setColumns(10);
		
		JLabel lbl_species = new JLabel("Species: Please Select");
		lbl_species.setBounds(21, 71, 210, 26);
		panel.add(lbl_species);
		
		JLabel lbl_sex = new JLabel("Sex: Please Select");
		lbl_sex.setBounds(202, 71, 181, 26);
		panel.add(lbl_sex);
		
		JLabel lbl_weight = new JLabel("Weight: Enter weight ");
		lbl_weight.setBounds(21, 182, 181, 26);
		panel.add(lbl_weight);
		
		JLabel lbl_gps = new JLabel("GPS Coordinates in DD Format:");
		lbl_gps.setBounds(202, 179, 210, 29);
		panel.add(lbl_gps);
		
		JButton btn_add = new JButton("Add");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Animal animal = null;
				if(comboBox_species.getSelectedIndex() == 0 && validInt(textField_weight.getText()) && validDouble(textField_special.getText()) && validGPS(textField_gps.getText())){
					animal = new Penguin(Sex.values()[comboBox_sex.getSelectedIndex()], textField_weight.getText(), textField_gps.getText(), Double.parseDouble(textField_special.getText()));
					animalList.add(animal);
					JOptionPane.showMessageDialog(null, "Added!");
				}else if (comboBox_species.getSelectedIndex() == 1 && validInt(textField_weight.getText()) && validInt(textField_special.getText()) && validGPS(textField_gps.getText())){
					animal = new SeaLion(Sex.values()[comboBox_sex.getSelectedIndex()], textField_weight.getText(), textField_gps.getText(), Integer.parseInt(textField_special.getText()));
					animalList.add(animal);
					JOptionPane.showMessageDialog(null, "Added!");
				}else if (comboBox_species.getSelectedIndex() == 2 && validInt(textField_weight.getText()) && validGPS(textField_gps.getText())){
					animal = new Walrus(Sex.values()[comboBox_sex.getSelectedIndex()], textField_weight.getText(), textField_gps.getText(), (DentalHealth.values()[comboBox_dental.getSelectedIndex()]));
					animalList.add(animal);
					JOptionPane.showMessageDialog(null, "Added!");
				}
				else
					JOptionPane.showMessageDialog(null, "Please Enter correct information");
				clearForm();
				
			}
		});
		btn_add.setBounds(392, 293, 89, 23);
		panel.add(btn_add);
		
		JButton btn_done = new JButton("Done");
		btn_done.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FileHandler fileIO = new FileHandler();
				fileIO.writeAnimals(animalList);
				JOptionPane.showMessageDialog(null, fileIO.readAnimals());
				System.exit(0);
			}
		});
		btn_done.setBounds(491, 293, 89, 23);
		panel.add(btn_done);
		
		comboBox_dental = new JComboBox();
		comboBox_dental.setModel(new DefaultComboBoxModel(DentalHealth.values()));
		comboBox_dental.setVisible(false);
		comboBox_dental.setBounds(439, 151, 119, 26);
		panel.add(comboBox_dental);
		
		lbl_special = new JLabel("Blood Pressure in KPA format:");
		lbl_special.setBounds(392, 103, 188, 37);
		panel.add(lbl_special);
		
		textField_special = new JTextField();
		textField_special.setBounds(439, 153, 119, 23);
		panel.add(textField_special);
		textField_special.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("KG");
		lblNewLabel.setBounds(150, 225, 46, 14);
		panel.add(lblNewLabel);
	}
	
	public void clearForm(){
		textField_weight.setText("");
		textField_gps.setText("");
		textField_special.setText("");
		comboBox_dental.setSelectedIndex(0);
		comboBox_sex.setSelectedIndex(0);
		comboBox_sex.setSelectedIndex(0);
		comboBox_species.setSelectedIndex(0);
		
	}//end clearForm
	
	public boolean validDouble(String dub){
		if (dub.matches("[0-9]{1,13}(\\.[0-9]*)?")){
			return true;
		}
		return false;
	}//end validDouble
	
	public boolean validInt(String integ){
		if (integ.matches("\\d+")){
			return true;
		}
		return false;
	}//end validInt
	
	public boolean validGPS(String gps){
		if (gps.matches("^(\\-?\\d+(\\.\\d+)?),\\s*(\\-?\\d+(\\.\\d+)?)$")){
			return true;
		}
		else return false;
	}
}
