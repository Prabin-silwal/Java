package Gui;

import Model.Movies;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.FileChooserUI;
import Model.Database;

//import com.sun.java.util.jar.pack.Package.File;

import Model.Database;

public class AddMovies1 extends JFrame implements ActionListener{
	final JFileChooser fc = new JFileChooser();
    byte[] photo=null;
	JFrame frame1;
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5,button6;
	JPanel panel;
	String imagepath;
	
	JTextField text1,text2,text3;
	
	JLabel label1,label2,label3,label4,label5,label7;

	private Component label;
	private Object path;
	public void addMovies() {
		JFrame frame=new JFrame();
		
		setTitle("Add movies");
		setBounds(400, 100, 600,500);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label1=new JLabel("Enter the name of movie:-");
		text1=new JTextField();
		label1.setBounds(200, 20, 200, 30);
		text1.setBounds(200, 50, 200, 30);
		label4=new JLabel("Select Release Date:");
		label2=new JLabel("Choose image");
		label2.setBounds(200, 200, 100, 30);
		label4.setBounds(200, 75, 400, 30);
		text2=new JTextField();
		text2.setBounds(200, 105, 200, 30);
		button4 =new JButton("Save");
		button5=new JButton("Exit");
		button4.setBounds(450, 400, 100, 30);
		button5.setBounds(50, 400, 100, 30);
		label5=new JLabel("Price:");
		text3=new JTextField();
		text3.setBounds(200, 155, 200, 30);		
		label5.setBounds(200, 130, 100, 30);
		button6=new JButton("Browse");
		button6.setBounds(300, 200, 100, 30);
		label7=new JLabel();
		label7.setBounds(200, 250, 200, 200);
		add(label1);
		add(button6);
		add(text1);
		add(label4);
		add(text2);
		add(button4);
		add(button5);
		add(label5);
		add(text3);
		add(label2);
		add(label7);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		 String action = e.getActionCommand();
		 if(action.equals("Save"))
		 {	String moviename=text1.getText();
			String releasedate=text2.getText();
			int price=Integer.parseInt(text3.getText());
			String imageaddress=(String) path;
			Movies m=new Movies();
			Model.Database db;
		try {
			db = new Model.Database();
			m=new Movies(moviename,releasedate,price,imageaddress);
			 db.addmovies(m);   
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		JOptionPane.showMessageDialog(this, "Successfully Saved(~ ~)"); 
		setVisible(false);
		return;
		 }
		 else if(action.contentEquals("Exit"))
		 {
			int yesno= JOptionPane.showConfirmDialog(this, "Are You sure");
			if(yesno==0)
			{
			 System.exit(0);
		 }
		 else {
			 
		 }
		 }
		 else if(action.equals("Browse"))
		 {
			 JFileChooser file = new JFileChooser();
	          file.setCurrentDirectory(new File(System.getProperty("user.home")));
	          FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
	          file.addChoosableFileFilter(filter);
	          int result = file.showSaveDialog(null);
	          if(result == JFileChooser.APPROVE_OPTION){  
	               File selectedFile=file.getSelectedFile();
	               String  path=selectedFile.getAbsolutePath();
	               label7.setIcon(ResizeImage(path));
				
	          }
	          else if(result == JFileChooser.CANCEL_OPTION){
	             JOptionPane.showMessageDialog(this, "No File Select");
	          }
	        }
			   } 
		  
	
public ImageIcon ResizeImage(String path)
{	this.path=path;
    ImageIcon MyImage = new ImageIcon(path);
    Image img = MyImage.getImage();
    Image newImg = img.getScaledInstance(label7.getWidth(), label7.getHeight(), Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
}
	
}
