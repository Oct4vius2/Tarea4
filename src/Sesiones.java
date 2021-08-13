import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class Sesiones extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	
	private JTable table;
	private javax.swing.JScrollPane jScrollPane1;
	
	DefaultTableModel model;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sesiones frame = new Sesiones();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Sesiones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		
		
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
        Dimension tamanoPantalla = mipantalla.getScreenSize();
        int alturaPantalla = tamanoPantalla.height;
        int anchoPantalla = tamanoPantalla.width;
        setSize(anchoPantalla/4,alturaPantalla/2);
        setLocation(anchoPantalla/4,alturaPantalla/4);
        getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Nombre de usuario:");
        lblNewLabel.setBounds(10, 11, 114, 14);
        getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Nombre:");
        lblNewLabel_1.setBounds(10, 36, 114, 14);
        getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Apellido:");
        lblNewLabel_2.setBounds(10, 61, 114, 14);
        getContentPane().add(lblNewLabel_2);
        
        lblNewLabel_3 = new JLabel("Correo Electronico:");
        lblNewLabel_3.setBounds(10, 86, 114, 14);
        getContentPane().add(lblNewLabel_3);
        
        lblNewLabel_4 = new JLabel("Número de telefono:");
        lblNewLabel_4.setBounds(10, 111, 114, 14);
        getContentPane().add(lblNewLabel_4);
        
        lblNewLabel_5 = new JLabel("Contrase\u00F1a:");
        lblNewLabel_5.setBounds(10, 136, 114, 14);
        getContentPane().add(lblNewLabel_5);
        
        lblNewLabel_6 = new JLabel("NomUsuario");
        lblNewLabel_6.setBounds(10, 315, 76, 14);
        getContentPane().add(lblNewLabel_6);
        
        lblNewLabel_7 = new JLabel("Nombre");
        lblNewLabel_7.setBounds(96, 315, 46, 14);
        getContentPane().add(lblNewLabel_7);
        
        lblNewLabel_8 = new JLabel("Apellido");
        lblNewLabel_8.setBounds(163, 315, 46, 14);
        getContentPane().add(lblNewLabel_8);
        
        lblNewLabel_9 = new JLabel("Correo");
        lblNewLabel_9.setBounds(240, 315, 46, 14);
        getContentPane().add(lblNewLabel_9);
        
        lblNewLabel_10 = new JLabel("Telefono");
        lblNewLabel_10.setBounds(311, 315, 76, 14);
        getContentPane().add(lblNewLabel_10);
        
        lblNewLabel_11 = new JLabel("Contrase\u00F1a");
        lblNewLabel_11.setBounds(386, 315, 68, 14);
        getContentPane().add(lblNewLabel_11);
        
        
        
        textField = new JTextField();
        textField.setBounds(134, 8, 320, 20);
        getContentPane().add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setBounds(134, 33, 320, 20);
        getContentPane().add(textField_1);
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setBounds(134, 58, 320, 20);
        getContentPane().add(textField_2);
        textField_2.setColumns(10);
        
        textField_3 = new JTextField();
        textField_3.setBounds(134, 83, 320, 20);
        getContentPane().add(textField_3);
        textField_3.setColumns(10);
        
        textField_4 = new JTextField();
        textField_4.setBounds(134, 108, 320, 20);
        getContentPane().add(textField_4);
        textField_4.setColumns(10);
        
        textField_5 = new JTextField();
        textField_5.setBounds(134, 133, 320, 20);
        getContentPane().add(textField_5);
        textField_5.setColumns(10);
        
        JButton btnNewButton = new JButton("Agregar\r\n");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Conexion co5 = new Conexion();
        		
        		String NomUsuario = textField.getText();
        		String Nombre = textField_1.getText();
        		String Apellido = textField_2.getText();
        		String Correo = textField_3.getText();
        		String Telefono = textField_4.getText();
        		String Contrasena = textField_5.getText();
        		
        		String strSentenciaInsert = String.format("INSERT INTO sesiones(NombreDeUsuario, Nombre, Apellido, CorreoElectronico, Telefono, Contraseña)"
        				+ "VALUES ('%s', '%s', '%s', '%s', '%s', '%s')", NomUsuario, Nombre, Apellido, Correo, Telefono, Contrasena);
        		co5.conectar();
        		co5.ejecutarSentenciaSQL(strSentenciaInsert);
        		mostrarDatos();
        	}
        });
        btnNewButton.setBounds(10, 230, 89, 23);
        getContentPane().add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Editar\r\n");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		Conexion co4 = new Conexion();
        		co4.conectar();
        		
        		String NomUsuario = textField.getText();
        		String Nombre = textField_1.getText();
        		String Apellido = textField_2.getText();
        		String Correo = textField_3.getText();
        		String Telefono = textField_4.getText();
        		String Contrasena = textField_5.getText();
        		
        		String strSentenciaInsert = String.format("UPDATE sesiones SET Nombre = '%s', Apellido = '%s', CorreoElectronico = '%s', Telefono = '%s', Contraseña = '%s' WHERE NombreDeUsuario = '%s'"
        		, Nombre, Apellido, Correo, Telefono, Contrasena,NomUsuario);
        		
        		co4.ejecutarSentenciaSQL(strSentenciaInsert);
        		mostrarDatos();
        		
        	}
        });
        btnNewButton_1.setBounds(109, 230, 89, 23);
        getContentPane().add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("Borrar");
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Conexion co3 = new Conexion();
        		co3.conectar();
        		String NomUsuario = textField.getText();
        		String strSentenciaInsert = String.format("DELETE FROM sesiones WHERE NombreDeUsuario= '%s' ", NomUsuario);
        		co3.ejecutarSentenciaSQL(strSentenciaInsert);
        		mostrarDatos();
        	}
        });
        btnNewButton_2.setBounds(208, 230, 89, 23);
        getContentPane().add(btnNewButton_2);
        
        JButton btnNewButton_3 = new JButton("Cerrar sesi\u00F3n");
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
		            File ruta = new File(".\\bin");
					ProcessBuilder pb = new ProcessBuilder("java", "Interfaz");
					pb.directory(ruta);
					pb.redirectErrorStream(true);
					pb.inheritIO();
					Process process = pb.start();
			      } catch (IOException ex) {
			      
			          	System.out.println("Error al ejecutar");
			        
			      }
        		
        	}
        });
        btnNewButton_3.setBounds(311, 230, 143, 23);
        getContentPane().add(btnNewButton_3);
        
        
        
        String[] titulos = {"Nombre de usuario", "Nombre", "Apellido", "Telefono", "Correo Electronico", "Contraseña"};
        model = new DefaultTableModel(null,titulos);
        table =  new JTable();      
        
        table.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		if(e.getClickCount()==1) {
        			JTable receptor = (JTable)e.getSource();
        			
        			textField.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(),0).toString());
        			textField_1.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(),1).toString());
        			textField_2.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(),2).toString());
        			textField_3.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(),3).toString());
        			textField_4.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(),4).toString());
        			textField_5.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(),5).toString());
        			
        		
        		}
        	}
        });
        table.setModel(model);
        table.setBounds(10, 333, 444, 157);
        getContentPane().add(table);
        mostrarDatos();
        
      
       
	}
	
	public void mostrarDatos() {
		while(model.getRowCount()>0) {
			model.removeRow(0);
		}
		Conexion co2 = new Conexion();
		co2.conectar();
		try {
			ResultSet rs = co2.consultarRegistros("SELECT * FROM sesiones");
			
			while (rs.next()) {
				String nUsuario = rs.getString(1);
				String nombre = rs.getString(2);
				String apellido = rs.getString(3);
				String cElectronico = rs.getString(4);
				String numTelefono = rs.getString(5);
				String Contrasena = rs.getString(6);
				System.out.println(nUsuario + " - " + nombre + " - " + apellido + " - " + cElectronico + " - " + numTelefono + " - " + Contrasena);
				Object[] usuario= {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)};
				model.addRow(usuario);
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
