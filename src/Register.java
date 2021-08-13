import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField textField_4;
	private JLabel lblNewLabel_6;
	private JTextField textField_5;
	private JLabel lblNewLabel_7;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registrar");
		lblNewLabel.setBounds(205, 11, 90, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(257, 59, 126, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(257, 90, 126, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		textField_2 = new JTextField();
		textField_2.setBounds(257, 121, 126, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(257, 152, 126, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(257, 183, 126, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(257, 214, 126, 20);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(257, 245, 126, 20);
		contentPane.add(passwordField_1);
		
		lblNewLabel_1 = new JLabel("Nombre de usuario");
		lblNewLabel_1.setBounds(73, 62, 126, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setBounds(73, 93, 90, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Apellido");
		lblNewLabel_3.setBounds(73, 124, 90, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Número de telefono");
		lblNewLabel_4.setBounds(73, 186, 126, 14);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Correo Electronico");
		lblNewLabel_5.setBounds(73, 155, 126, 14);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Contraseña");
		lblNewLabel_6.setBounds(73, 217, 90, 14);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Confirmar contraseña");
		lblNewLabel_7.setBounds(73, 248, 126, 14);
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("Registrarse");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conexion co1 = new Conexion();
        		
        		String NomUsuario = textField.getText();
        		String Nombre = textField_1.getText();
        		String Apellido = textField_2.getText();
        		String Correo = textField_4.getText();
        		String Telefono = textField_5.getText();
        		String Contrasena = passwordField.getText();
        		
        		String strSentenciaInsert = String.format("INSERT INTO sesiones(NombreDeUsuario, Nombre, Apellido, CorreoElectronico, Telefono, Contraseña)"
        				+ "VALUES ('%s', '%s', '%s', '%s', '%s', '%s')", NomUsuario, Nombre, Apellido, Correo, Telefono, Contrasena);
        		co1.conectar();
        		co1.ejecutarSentenciaSQL(strSentenciaInsert);
        		JFrame frame = new JFrame();
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
		btnNewButton.setBounds(183, 302, 112, 23);
		contentPane.add(btnNewButton);
		
		
		
		
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
        Dimension tamanoPantalla = mipantalla.getScreenSize();
        int alturaPantalla = tamanoPantalla.height;
        int anchoPantalla = tamanoPantalla.width;
        setSize(anchoPantalla/4,alturaPantalla/2);
        setLocation(anchoPantalla/4,alturaPantalla/4);
	}
}
