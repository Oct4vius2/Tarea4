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
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuBar;


public class Almacen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	
	private JTable table;
	private javax.swing.JScrollPane jScrollPane1;
	
	DefaultTableModel model;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Almacen frame = new Almacen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Almacen() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		
		
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
        Dimension tamanoPantalla = mipantalla.getScreenSize();
        int alturaPantalla = tamanoPantalla.height;
        int anchoPantalla = tamanoPantalla.width;
        setSize(480,459);
        setLocation(anchoPantalla/4,alturaPantalla/4);
        getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Nombre del producto:");
        lblNewLabel.setBounds(10, 14, 143, 14);
        getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Marca:");
        lblNewLabel_1.setBounds(10, 45, 114, 14);
        getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Categoria:");
        lblNewLabel_2.setBounds(10, 76, 114, 14);
        getContentPane().add(lblNewLabel_2);
        
        lblNewLabel_3 = new JLabel("Precio:");
        lblNewLabel_3.setBounds(10, 101, 114, 14);
        getContentPane().add(lblNewLabel_3);
        
        lblNewLabel_4 = new JLabel("Cantidad disponible:");
        lblNewLabel_4.setBounds(10, 132, 114, 14);
        getContentPane().add(lblNewLabel_4);
        
        lblNewLabel_6 = new JLabel("NomProducto");
        lblNewLabel_6.setBounds(10, 173, 87, 14);
        getContentPane().add(lblNewLabel_6);
        
        lblNewLabel_7 = new JLabel("Marca");
        lblNewLabel_7.setBounds(107, 173, 46, 14);
        getContentPane().add(lblNewLabel_7);
        
        lblNewLabel_8 = new JLabel("Categoria");
        lblNewLabel_8.setBounds(188, 173, 78, 14);
        getContentPane().add(lblNewLabel_8);
        
        lblNewLabel_9 = new JLabel("Precio");
        lblNewLabel_9.setBounds(274, 173, 46, 14);
        getContentPane().add(lblNewLabel_9);
        
        lblNewLabel_10 = new JLabel("Disponible");
        lblNewLabel_10.setBounds(363, 173, 76, 14);
        getContentPane().add(lblNewLabel_10);
        
        
        
        textField = new JTextField();
        textField.setBounds(134, 11, 320, 20);
        getContentPane().add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setBounds(134, 42, 320, 20);
        getContentPane().add(textField_1);
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setBounds(134, 70, 320, 20);
        getContentPane().add(textField_2);
        textField_2.setColumns(10);
        
        textField_3 = new JTextField();
        textField_3.setBounds(134, 98, 320, 20);
        getContentPane().add(textField_3);
        textField_3.setColumns(10);
        
        textField_4 = new JTextField();
        textField_4.setBounds(134, 129, 320, 20);
        getContentPane().add(textField_4);
        textField_4.setColumns(10);
        
        
        
        String[] titulos = {"Producto", "Marca", "Categoria", "Precio", "Cantidad"};
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
        			
        			
        		
        		}
        	}
        });
        table.setModel(model);
        table.setBounds(10, 198, 444, 157);
        getContentPane().add(table);
        
        JButton btnNewButton = new JButton("Cerrar sesi\u00F3n");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					Interfaz frame = new Interfaz();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
        	}
        });
        btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
        btnNewButton.setBounds(152, 366, 143, 23);
        getContentPane().add(btnNewButton);
        
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        mnNewMenu = new JMenu("Acciones\r\n");
        menuBar.add(mnNewMenu);
        
        mntmNewMenuItem = new JMenuItem("Agregar\r\n");
        mntmNewMenuItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Conexion co5 = new Conexion();
        		
        		String Producto = textField.getText();
        		String Marca = textField_1.getText();
        		String Categoria = textField_2.getText();
        		String Precio = textField_3.getText();
        		String Cantidad = textField_4.getText();

        		
        		String strSentenciaInsert = String.format("INSERT INTO productos (NombreProducto, MarcaProducto, CategoriaProducto, PrecioProducto, CantidadProducto)"
        				+ "VALUES ('%s', '%s', '%s', '%s', '%s')", Producto, Marca, Categoria, Precio, Cantidad);
        		co5.conectar();
        		co5.ejecutarSentenciaSQL(strSentenciaInsert);
        		mostrarDatos();
        	}
        });
        mnNewMenu.add(mntmNewMenuItem);
        
        mntmNewMenuItem_1 = new JMenuItem("Editar\r\n");
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		Conexion co4 = new Conexion();
        		co4.conectar();
        		
        		String Producto = textField.getText();
        		String Marca = textField_1.getText();
        		String Categoria = textField_2.getText();
        		String Precio = textField_3.getText();
        		String Cantidad = textField_4.getText();
        	
        		
        		String strSentenciaInsert = String.format("UPDATE productos SET MarcaProducto = '%s', CategoriaProducto = '%s', PrecioProducto = '%s', CantidadProducto = '%s' WHERE NombreProducto = '%s'"
        		, Marca, Categoria, Precio, Cantidad, Producto);
        		
        		co4.ejecutarSentenciaSQL(strSentenciaInsert);
        		mostrarDatos();
        		
        	}
        });
        mnNewMenu.add(mntmNewMenuItem_1);
        
        mntmNewMenuItem_2 = new JMenuItem("Borrar\r\n");
        mntmNewMenuItem_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Conexion co3 = new Conexion();
        		co3.conectar();
        		String NomUsuario = textField.getText();
        		String strSentenciaInsert = String.format("DELETE FROM productos WHERE NombreProducto= '%s' ", NomUsuario);
        		co3.ejecutarSentenciaSQL(strSentenciaInsert);
        		mostrarDatos();
        	}
        });
        mnNewMenu.add(mntmNewMenuItem_2);
        mostrarDatos();
        
      
       
	}
	
	public void mostrarDatos() {
		while(model.getRowCount()>0) {
			model.removeRow(0);
		}
		Conexion co2 = new Conexion();
		co2.conectar();
		try {
			ResultSet rs = co2.consultarRegistros("SELECT * FROM productos");
			
			while (rs.next()) {
				String nProducto = rs.getString(1);
				String Marca = rs.getString(2);
				String Categoria = rs.getString(3);
				String Precio = rs.getString(4);
				String Cantidad = rs.getString(5);
				System.out.println(nProducto + " - " + Marca + " - " + Categoria + " - " + Precio + " - " + Cantidad );
				Object[] usuario= {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)};
				model.addRow(usuario);
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		
	}

}

