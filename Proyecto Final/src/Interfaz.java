
import java.awt.*;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Interfaz extends JFrame {
	
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton;
	private JPasswordField passwordField;

	
	public static void main(String[] args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
	}

	public Interfaz() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(205, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(205, 53, 249, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(205, 91, 249, 20);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de usuario");
		lblNewLabel_1.setBounds(63, 56, 146, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contraseña");
		lblNewLabel_2.setBounds(63, 94, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conexion conn = new Conexion();
				conn.conectar();
				
				String valor1 = textField.getText();
				String valor2 = passwordField.getText();
				
				try {
					ResultSet rs = conn.consultarRegistros("SELECT * FROM sesiones");
					
					while (rs.next()) {
						String nUsuario = rs.getString(1);
						String Contrasena = rs.getString(6);
						
						
						
						if(nUsuario.equals(valor1) && Contrasena.equals(valor2)) {
							System.out.println("ACABA DE INICIAR SESIÓN");
							
							try {
								Seleccion frame = new Seleccion();
								frame.setVisible(true);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
							
							
							break;
						}
												
						
					}
				}catch (Exception e1) {
					System.out.println(e1);
				}
				
				
				
			}
		});
		btnNewButton.setBounds(173, 199, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Registrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton_1.setBounds(173, 253, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(173, 160, 73, 14);
		contentPane.add(lblNewLabel_3);
		

		
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
        Dimension tamanoPantalla = mipantalla.getScreenSize();
        int alturaPantalla = tamanoPantalla.height;
        int anchoPantalla = tamanoPantalla.width;
        setSize(anchoPantalla/4,alturaPantalla/2);
        setLocation(anchoPantalla/4,alturaPantalla/4);
	}
}
