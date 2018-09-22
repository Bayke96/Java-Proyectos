package pantallas;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Painter;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.lang3.text.WordUtils;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;



public class Inicio {
	private static JTextField txtNombre;
	private static JTextField txtPrecio;
	private static JTextField txtUnidades;
	private static JTextField txtMNombre;
	private static JTextField txtMPrecio;
	private static JTextField txtMUnidades;
	private static JTable table;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		JFrame Inicio = new JFrame("Herramientas Jose González - Menu Principal");
		Inicio.getContentPane().setBackground(new Color(119, 136, 153));
		Inicio.getContentPane().setLayout(null);
		
		JButton btnHerramientas = new JButton("   Herramientas");
		btnHerramientas.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/toolbox.png")));
		btnHerramientas.setForeground(new Color(255, 255, 255));
		btnHerramientas.setFont(new Font("Dialog", Font.BOLD, 15));
		btnHerramientas.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(255, 255, 255)));
		btnHerramientas.setBackground(new Color(255, 0, 0));
		btnHerramientas.setBounds(6, 6, 345, 89);
		Inicio.getContentPane().add(btnHerramientas);
		
		JButton btnMateriales = new JButton("   Materiales");
		btnMateriales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio.dispose();
				Materiales.main(args);
			}
		});
		btnMateriales.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/materiales.png")));
		btnMateriales.setForeground(new Color(30, 144, 255));
		btnMateriales.setFont(new Font("Dialog", Font.BOLD, 15));
		btnMateriales.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(255, 255, 255)));
		btnMateriales.setBackground(new Color(192, 192, 192));
		btnMateriales.setBounds(351, 6, 365, 89);
		Inicio.getContentPane().add(btnMateriales);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 107, 710, 459);
		Inicio.getContentPane().add(tabbedPane);
		
		JPanel PanelAgregar = new JPanel();
		PanelAgregar.setForeground(Color.RED);
		PanelAgregar.setBackground(new Color(128, 0, 0));
		tabbedPane.addTab("Agregar  ", new ImageIcon(Inicio.class.getResource("/imagenes/addred.png")), PanelAgregar, null);
		
		PanelAgregar.setLayout(null);
		
		
		
		
		JTextArea txtDescripcion = new JTextArea();
		txtDescripcion.setForeground(Color.BLACK);
		
		txtNombre = new JTextField();
		txtNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UIManager.put("nimbusBase", Color.GRAY);
				UIManager.put("textForeground", Color.BLACK);
				UIManager.put("OptionPane.messageForeground", Color.BLACK);
				
				if(txtNombre.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "Debe introducir un nombre para el producto", "Dato obligatorio", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				txtDescripcion.requestFocus();
				
			}
		});
		txtNombre.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtNombre.setForeground(new Color(255, 255, 255));
		txtNombre.setBackground(new Color(128, 0, 0));
		txtNombre.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txtNombre.setBounds(56, 77, 146, 28);
		PanelAgregar.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				UIManager.put("nimbusBase", Color.GRAY);
				UIManager.put("textForeground", Color.BLACK);
				UIManager.put("OptionPane.messageForeground", Color.BLACK);
				
				if(txtPrecio.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "Debe introducir un precio para el producto", "Dato obligatorio", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(!txtPrecio.getText().matches("[0-9]+([,.][0-9]{1,2})?")){
					JOptionPane.showMessageDialog(null, "El campo precio solo acepta números", "Error de validación", JOptionPane.WARNING_MESSAGE);
					return;
				}
				Double Precio = Double.parseDouble(txtPrecio.getText().replaceAll(",", "."));
				if(Precio <= 0.0){
					JOptionPane.showMessageDialog(null, "El precio debe ser mayor a 0!", "Error de validación", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				txtUnidades.requestFocus();
			}
		});
		txtPrecio.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtPrecio.setForeground(new Color(255, 255, 255));
		txtPrecio.setBackground(new Color(128, 0, 0));
		txtPrecio.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(56, 281, 170, 28);
		PanelAgregar.add(txtPrecio);
		
		JComboBox comboBoxHerramienta = new JComboBox();
		JComboBox comboBoxEliminar = new JComboBox();
		
		txtUnidades = new JTextField();
		txtUnidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UIManager.put("nimbusBase", Color.GRAY);
				UIManager.put("textForeground", Color.BLACK);
				UIManager.put("OptionPane.messageForeground", Color.BLACK);
				
				if(txtNombre.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "Debe introducir un nombre para el producto", "Dato obligatorio", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(txtDescripcion.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "Debe introducir una descripción para el producto", "Dato obligatorio", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(txtPrecio.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "Debe introducir un precio para el producto", "Dato obligatorio", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(!txtPrecio.getText().matches("[0-9]+([,.][0-9]{1,2})?")){
					JOptionPane.showMessageDialog(null, "El campo precio solo acepta números", "Error de validación", JOptionPane.WARNING_MESSAGE);
					return;
				}
				Double Precio = Double.parseDouble(txtPrecio.getText().replaceAll(",", "."));
				if(Precio <= 0.0){
					JOptionPane.showMessageDialog(null, "El precio debe ser mayor a 0!", "Error de validación", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(txtUnidades.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "Debe introducir una cantidad de unidades para el producto", "Dato obligatorio", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(!txtUnidades.getText().matches("[0-9]+")){
					JOptionPane.showMessageDialog(null, "El campo unidades solo acepta números enteros", "Error de validación", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(Integer.parseInt(txtUnidades.getText().trim()) <= 0){
					JOptionPane.showMessageDialog(null, "El campo unidades debe ser mayor a 0!", "Error de validación", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				BD base = new BD();
				base.Conectar("Herramientas_Jose");
				try {
					if(base.BuscarHerramienta(txtNombre.getText()) == true){
						JOptionPane.showMessageDialog(null, "Este producto ya existe dentro del inventario!", "Error en la BDD", JOptionPane.WARNING_MESSAGE);
						return;
					}
					base.InsertarHerramienta(txtNombre.getText(), txtDescripcion.getText(), Precio, Integer.parseInt(txtUnidades.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				txtNombre.setText("");
				txtDescripcion.setText("");
				txtUnidades.setText("");
				txtPrecio.setText("");
				
				txtNombre.requestFocus();
				
				
				DefaultTableModel dm = (DefaultTableModel) table.getModel();
				int rowCount = dm.getRowCount();
				//Remove rows one by one from the end of the table
				for (int i = rowCount - 1; i >= 0; i--) {
				    dm.removeRow(i);
				}
				
				BD conexion = new BD();
			    Statement stmt = null;
			    conexion.Conectar("Herramientas_Jose");
			    try{
			    	DefaultTableModel model = (DefaultTableModel) table.getModel();
			    	String selectSQL = "SELECT ID, Nombre, Descripcion, Precio, Unidades FROM Herramientas";
					  PreparedStatement preparedStatement = conexion.conn.prepareStatement(selectSQL);
					  ResultSet rs = preparedStatement.executeQuery(selectSQL);
					  while (rs.next()) {
					   	 	
					  	model.addRow(new Object[]{rs.getInt("ID"), WordUtils.capitalize(rs.getString("Nombre")), rs.getString("Descripcion").substring(0, 1).toUpperCase() + rs.getString("Descripcion").substring(1), rs.getDouble("Precio"), rs.getInt("Unidades")});
					  	
					  }
					  
				}
				catch(Exception y){
						  System.err.println(y);
					  }
			    conexion.Desconectar();
			    

				
			    conexion.Conectar("Herramientas_Jose");
			    try{
			    	
			    	String selectSQL = "SELECT Nombre FROM Herramientas";
					  PreparedStatement preparedStatement = conexion.conn.prepareStatement(selectSQL);
					  ResultSet rs = preparedStatement.executeQuery(selectSQL);
					  comboBoxHerramienta.setModel(new DefaultComboBoxModel(new String[] {"Seleccione"}));
					  comboBoxEliminar.setModel(new DefaultComboBoxModel(new String[] {"Seleccione"}));
					  while (rs.next()) {
					  	comboBoxHerramienta.addItem(WordUtils.capitalizeFully(rs.getString("Nombre")));
					  	comboBoxEliminar.addItem(WordUtils.capitalizeFully(rs.getString("Nombre")));
					  }
					  
				}
				catch(Exception xe){
						  System.err.println(xe);
					  }
			    conexion.Desconectar();
			    
			    JOptionPane.showMessageDialog(null, "Herramienta agregada", "Operación Exitosa", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		txtUnidades.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtUnidades.setForeground(new Color(255, 255, 255));
		txtUnidades.setBackground(new Color(128, 0, 0));
		txtUnidades.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txtUnidades.setColumns(10);
		txtUnidades.setBounds(56, 349, 170, 28);
		PanelAgregar.add(txtUnidades);
		
		JLabel lblAgregarNuevaHerramienta = new JLabel("AGREGAR NUEVA HERRAMIENTA");
		lblAgregarNuevaHerramienta.setForeground(new Color(255, 255, 255));
		lblAgregarNuevaHerramienta.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarNuevaHerramienta.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblAgregarNuevaHerramienta.setBounds(16, 21, 305, 16);
		PanelAgregar.add(lblAgregarNuevaHerramienta);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNombre.setBounds(56, 49, 125, 16);
		PanelAgregar.add(lblNombre);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setForeground(Color.WHITE);
		lblDescripcin.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDescripcin.setBounds(56, 117, 125, 16);
		PanelAgregar.add(lblDescripcin);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 145, 261, 96);
		PanelAgregar.add(scrollPane);
		
		
		txtDescripcion.setLineWrap(true);
		scrollPane.setViewportView(txtDescripcion);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblPrecio.setBounds(56, 253, 125, 16);
		PanelAgregar.add(lblPrecio);
		
		JLabel lblUnidades = new JLabel("Unidades");
		lblUnidades.setForeground(Color.WHITE);
		lblUnidades.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblUnidades.setBounds(56, 321, 125, 16);
		PanelAgregar.add(lblUnidades);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UIManager.put("nimbusBase", Color.GRAY);
				UIManager.put("textForeground", Color.BLACK);
				UIManager.put("OptionPane.messageForeground", Color.BLACK);
				
				if(txtNombre.getText().trim().equals("")){
					
					JOptionPane.showMessageDialog(null, "Debe introducir un nombre para el producto", "Dato obligatorio", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(txtDescripcion.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "Debe introducir una descripción para el producto", "Dato obligatorio", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(txtPrecio.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "Debe introducir un precio para el producto", "Dato obligatorio", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(!txtPrecio.getText().matches("[0-9]+([,.][0-9]{1,2})?")){
					JOptionPane.showMessageDialog(null, "El campo precio solo acepta números", "Error de validación", JOptionPane.WARNING_MESSAGE);
					return;
				}
				Double Precio = Double.parseDouble(txtPrecio.getText().replaceAll(",", "."));
				if(Precio <= 0.0){
					JOptionPane.showMessageDialog(null, "El precio debe ser mayor a 0!", "Error de validación", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(txtUnidades.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "Debe introducir una cantidad de unidades para el producto", "Dato obligatorio", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(!txtUnidades.getText().matches("[0-9]+")){
					JOptionPane.showMessageDialog(null, "El campo unidades solo acepta números enteros", "Error de validación", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(Integer.parseInt(txtUnidades.getText().trim()) <= 0){
					JOptionPane.showMessageDialog(null, "El campo unidades debe ser mayor a 0!", "Error de validación", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				BD base = new BD();
				base.Conectar("Herramientas_Jose");
				try {
					if(base.BuscarHerramienta(txtNombre.getText()) == true){
						JOptionPane.showMessageDialog(null, "Este producto ya existe dentro del inventario!", "Error en la BDD", JOptionPane.WARNING_MESSAGE);
						return;
					}
					base.InsertarHerramienta(txtNombre.getText(), txtDescripcion.getText(), Precio, Integer.parseInt(txtUnidades.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				txtNombre.setText("");
				txtDescripcion.setText("");
				txtUnidades.setText("");
				txtPrecio.setText("");
				
				txtNombre.requestFocus();
				
				DefaultTableModel dm = (DefaultTableModel) table.getModel();
				int rowCount = dm.getRowCount();
				//Remove rows one by one from the end of the table
				for (int i = rowCount - 1; i >= 0; i--) {
				    dm.removeRow(i);
				}
				
				BD conexion = new BD();
			    Statement stmt = null;
			    conexion.Conectar("Herramientas_Jose");
			    try{
			    	DefaultTableModel model = (DefaultTableModel) table.getModel();
			    	String selectSQL = "SELECT ID, Nombre, Descripcion, Precio, Unidades FROM Herramientas";
					  PreparedStatement preparedStatement = conexion.conn.prepareStatement(selectSQL);
					  ResultSet rs = preparedStatement.executeQuery(selectSQL);
					  while (rs.next()) {
					   	 	
					  	model.addRow(new Object[]{rs.getInt("ID"), WordUtils.capitalize(rs.getString("Nombre")), rs.getString("Descripcion").substring(0, 1).toUpperCase() + rs.getString("Descripcion").substring(1), rs.getDouble("Precio"), rs.getInt("Unidades")});
					  	
					  }
					  
				}
				catch(Exception y){
						  System.err.println(y);
					  }
			    conexion.Desconectar();
			    
			    
			    conexion.Conectar("Herramientas_Jose");
			    try{
			    	
			    	String selectSQL = "SELECT Nombre FROM Herramientas";
					  PreparedStatement preparedStatement = conexion.conn.prepareStatement(selectSQL);
					  ResultSet rs = preparedStatement.executeQuery(selectSQL);
					  comboBoxHerramienta.setModel(new DefaultComboBoxModel(new String[] {"Seleccione"}));
					  comboBoxEliminar.setModel(new DefaultComboBoxModel(new String[] {"Seleccione"}));
					  while (rs.next()) {
					  	comboBoxHerramienta.addItem(WordUtils.capitalizeFully(rs.getString("Nombre")));
					  	comboBoxEliminar.addItem(WordUtils.capitalizeFully(rs.getString("Nombre")));
					  }
					  
				}
				catch(Exception xe){
						  System.err.println(xe);
					  }
			    conexion.Desconectar();
			    
			    JOptionPane.showMessageDialog(null, "Herramienta agregada", "Operación Exitosa", JOptionPane.INFORMATION_MESSAGE);
				
				
			}
		});
		btnAgregar.setBackground(new Color(128, 0, 0));
		btnAgregar.setForeground(new Color(255, 255, 255));
		btnAgregar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnAgregar.setBounds(507, 386, 90, 28);
		PanelAgregar.add(btnAgregar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNombre.setText("");
				txtDescripcion.setText("");
				txtUnidades.setText("");
				txtPrecio.setText("");
			}
		});
		btnBorrar.setBackground(new Color(128, 0, 0));
		btnBorrar.setForeground(new Color(255, 255, 255));
		btnBorrar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnBorrar.setBounds(600, 386, 90, 28);
		PanelAgregar.add(btnBorrar);
		
		JPanel PanelModificar = new JPanel();
		PanelModificar.setBackground(new Color(128, 0, 0));
		tabbedPane.addTab("Modificar  ", new ImageIcon(Inicio.class.getResource("/imagenes/editred.png")), PanelModificar, null);
		PanelModificar.setLayout(null);
		
		JTextArea txtMDescripcion = new JTextArea();
		txtMDescripcion.setForeground(new Color(0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("MODIFICAR HERRAMIENTA EXISTENTE");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(27, 22, 360, 16);
		PanelModificar.add(lblNewLabel);
		
		
		comboBoxHerramienta.setForeground(new Color(0, 0, 0));
		comboBoxHerramienta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				BD conex = new BD();
				
				try{
					conex.Conectar("Herramientas_Jose");
					String Nombre = "", Descripcion = "";
					Double precio = 0.0;
					int unidades = 0;
					 String selectSQL = "SELECT Nombre, Descripcion, Precio, Unidades FROM Herramientas WHERE Nombre = ?";
					  PreparedStatement preparedStatement = conex.conn.prepareStatement(selectSQL);
					  preparedStatement.setString(1, comboBoxHerramienta.getSelectedItem().toString().toLowerCase());
					  ResultSet rs = preparedStatement.executeQuery();
					  while (rs.next()) {
					  	Nombre = rs.getString("Nombre");
					  	Descripcion = rs.getString("Descripcion");
					  	precio = rs.getDouble("precio");
					  	unidades = rs.getInt("unidades");
					  
					  }
					 
					  txtMNombre.setText(WordUtils.capitalizeFully(Nombre));
					  txtMDescripcion.setText(WordUtils.capitalize(Descripcion));
					  txtMPrecio.setText(Double.toString(precio));
					  txtMUnidades.setText(Integer.toString(unidades));
				}
				catch(Exception e2){
					System.err.println(e2);
				}
				finally{
					conex.Desconectar();
				}
				
				
			}
		});
		comboBoxHerramienta.setFont(new Font("SansSerif", Font.BOLD, 12));
		comboBoxHerramienta.setModel(new DefaultComboBoxModel(new String[] {"Seleccione"}));
		comboBoxHerramienta.setBackground(new Color(255, 239, 213));
		comboBoxHerramienta.setBounds(71, 84, 264, 26);
		PanelModificar.add(comboBoxHerramienta);
		
		JLabel lblNombreProducto = new JLabel("Nombre");
		lblNombreProducto.setForeground(new Color(255, 255, 255));
		lblNombreProducto.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNombreProducto.setBounds(50, 56, 78, 16);
		PanelModificar.add(lblNombreProducto);
		
		JLabel lblNuevoNombre = new JLabel("Nuevo Nombre");
		lblNuevoNombre.setForeground(Color.WHITE);
		lblNuevoNombre.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNuevoNombre.setBounds(71, 125, 144, 16);
		PanelModificar.add(lblNuevoNombre);
		
		txtMNombre = new JTextField();
		txtMNombre.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txtMNombre.setBackground(new Color(128, 0, 0));
		txtMNombre.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtMNombre.setForeground(new Color(255, 255, 255));
		txtMNombre.setBounds(95, 153, 207, 28);
		PanelModificar.add(txtMNombre);
		txtMNombre.setColumns(10);
		
		JLabel lblNuevoPrecio = new JLabel("Precio");
		lblNuevoPrecio.setForeground(Color.WHITE);
		lblNuevoPrecio.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNuevoPrecio.setBounds(71, 285, 144, 16);
		PanelModificar.add(lblNuevoPrecio);
		
		txtMPrecio = new JTextField();
		txtMPrecio.setForeground(Color.WHITE);
		txtMPrecio.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtMPrecio.setColumns(10);
		txtMPrecio.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txtMPrecio.setBackground(new Color(128, 0, 0));
		txtMPrecio.setBounds(95, 313, 207, 28);
		PanelModificar.add(txtMPrecio);
		
		JLabel lblUnidades_1 = new JLabel("Unidades");
		lblUnidades_1.setForeground(Color.WHITE);
		lblUnidades_1.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblUnidades_1.setBounds(71, 353, 144, 16);
		PanelModificar.add(lblUnidades_1);
		
		txtMUnidades = new JTextField();
		txtMUnidades.setForeground(Color.WHITE);
		txtMUnidades.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtMUnidades.setColumns(10);
		txtMUnidades.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txtMUnidades.setBackground(new Color(128, 0, 0));
		txtMUnidades.setBounds(95, 381, 207, 28);
		PanelModificar.add(txtMUnidades);
		
		JLabel lblDescripcin_1 = new JLabel("Descripci\u00F3n");
		lblDescripcin_1.setForeground(Color.WHITE);
		lblDescripcin_1.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblDescripcin_1.setBounds(71, 193, 144, 16);
		PanelModificar.add(lblDescripcin_1);
		
		
		txtMDescripcion.setLineWrap(true);
		txtMDescripcion.setBounds(71, 221, 255, 54);
		PanelModificar.add(txtMDescripcion);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				UIManager.put("nimbusBase", Color.GRAY);
				UIManager.put("textForeground", Color.BLACK);
				UIManager.put("OptionPane.messageForeground", Color.BLACK);
				
				if(comboBoxHerramienta.getSelectedItem().toString().equalsIgnoreCase("seleccione")){
					JOptionPane.showMessageDialog(null, "Debe elegir un producto para modificar!", "Dato obligatorio", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				
				if(txtMNombre.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "Debe introducir un nombre para el producto", "Dato obligatorio", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(txtMDescripcion.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "Debe introducir una descripción para el producto", "Dato obligatorio", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(txtMPrecio.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "Debe introducir un precio para el producto", "Dato obligatorio", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(!txtMPrecio.getText().matches("[0-9]+([,.][0-9]{1,2})?")){
					JOptionPane.showMessageDialog(null, "El campo precio solo acepta números", "Error de validación", JOptionPane.WARNING_MESSAGE);
					return;
				}
				Double Precio = Double.parseDouble(txtMPrecio.getText().replaceAll(",", "."));
				if(Precio <= 0.0){
					JOptionPane.showMessageDialog(null, "El precio debe ser mayor a 0!", "Error de validación", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(txtMUnidades.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "Debe introducir una cantidad de unidades para el producto", "Dato obligatorio", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(!txtMUnidades.getText().matches("[0-9]+")){
					JOptionPane.showMessageDialog(null, "El campo unidades solo acepta números enteros", "Error de validación", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(Integer.parseInt(txtMUnidades.getText().trim()) <= 0){
					JOptionPane.showMessageDialog(null, "El campo unidades debe ser mayor a 0!", "Error de validación", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				
				BD mod = new BD();
				try {
					if(!txtMNombre.getText().equalsIgnoreCase(comboBoxHerramienta.getSelectedItem().toString()) && mod.BuscarHerramienta(txtMNombre.getText().toLowerCase()) == true){
						JOptionPane.showMessageDialog(null, "Ya existe una herramienta con este nombre dentro del inventario!", "Error de BDD", JOptionPane.WARNING_MESSAGE);
						return;
					}
					mod.ActualizarHerramienta(comboBoxHerramienta.getSelectedItem().toString().toLowerCase(), txtMNombre.getText(), txtMDescripcion.getText(), Precio, 
							Integer.parseInt(txtMUnidades.getText()));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				BD conexion = new BD();
			    Statement stmt = null;
			    conexion.Conectar("Herramientas_Jose");
			    try{
			    	
			    	String selectSQL = "SELECT Nombre FROM Herramientas";
					  PreparedStatement preparedStatement = conexion.conn.prepareStatement(selectSQL);
					  ResultSet rs = preparedStatement.executeQuery(selectSQL);
					  comboBoxHerramienta.setModel(new DefaultComboBoxModel(new String[] {"Seleccione"}));
					  comboBoxEliminar.setModel(new DefaultComboBoxModel(new String[] {"Seleccione"}));
					  while (rs.next()) {
					  	comboBoxHerramienta.addItem(WordUtils.capitalizeFully(rs.getString("Nombre")));
					  	comboBoxEliminar.addItem(WordUtils.capitalizeFully(rs.getString("Nombre")));
					  }
					  
				}
				catch(Exception xe){
						  System.err.println(xe);
					  }
			    conexion.Desconectar();
				
				txtMNombre.setText("");
				txtMDescripcion.setText("");
				txtMUnidades.setText("");
				txtMPrecio.setText("");
				
				
				DefaultTableModel dm = (DefaultTableModel) table.getModel();
				int rowCount = dm.getRowCount();
				//Remove rows one by one from the end of the table
				for (int i = rowCount - 1; i >= 0; i--) {
				    dm.removeRow(i);
				}
				
				
			    conexion.Conectar("Herramientas_Jose");
			    try{
			    	DefaultTableModel model = (DefaultTableModel) table.getModel();
			    	String selectSQL = "SELECT ID, Nombre, Descripcion, Precio, Unidades FROM Herramientas";
					  PreparedStatement preparedStatement = conexion.conn.prepareStatement(selectSQL);
					  ResultSet rs = preparedStatement.executeQuery(selectSQL);
					  while (rs.next()) {
					   	 	
					  	model.addRow(new Object[]{rs.getInt("ID"), WordUtils.capitalize(rs.getString("Nombre")), rs.getString("Descripcion").substring(0, 1).toUpperCase() + rs.getString("Descripcion").substring(1), rs.getDouble("Precio"), rs.getInt("Unidades")});
					  	
					  }
					  
				}
				catch(Exception y){
						  System.err.println(y);
					  }
			    conexion.Desconectar();
			    
			    
			  
			    
			    JOptionPane.showMessageDialog(null, "Herramienta actualizada!", "Operación Exitosa", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnModificar.setBackground(new Color(128, 0, 0));
		btnModificar.setBounds(521, 381, 90, 28);
		PanelModificar.add(btnModificar);
		
		JButton btnMBorrar = new JButton("Borrar");
		btnMBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				BD conexion = new BD();
			    Statement stmt = null;
			    conexion.Conectar("Herramientas_Jose");
			    try{
			    	
			    	String selectSQL = "SELECT Nombre FROM Herramientas";
					  PreparedStatement preparedStatement = conexion.conn.prepareStatement(selectSQL);
					  ResultSet rs = preparedStatement.executeQuery(selectSQL);
					  comboBoxHerramienta.setModel(new DefaultComboBoxModel(new String[] {"Seleccione"}));
					  while (rs.next()) {
					  	comboBoxHerramienta.addItem(WordUtils.capitalizeFully(rs.getString("Nombre")));
					  }
					  
				}
				catch(Exception xe){
						  System.err.println(xe);
					  }
			    conexion.Desconectar();
				
				txtMNombre.setText("");
				txtMDescripcion.setText("");
				txtMUnidades.setText("");
				txtMPrecio.setText("");
			}
		});
		btnMBorrar.setForeground(Color.WHITE);
		btnMBorrar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnMBorrar.setBackground(new Color(128, 0, 0));
		btnMBorrar.setBounds(614, 381, 90, 28);
		PanelModificar.add(btnMBorrar);
		
		JPanel PanelEliminar = new JPanel();
		PanelEliminar.setBackground(new Color(128, 0, 0));
		tabbedPane.addTab("Eliminar ", new ImageIcon(Inicio.class.getResource("/imagenes/deletered.png")), PanelEliminar, null);
		PanelEliminar.setLayout(null);
		
		JLabel lblEliminarHerramientaExistente = new JLabel("ELIMINAR HERRAMIENTA EXISTENTE");
		lblEliminarHerramientaExistente.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarHerramientaExistente.setForeground(Color.WHITE);
		lblEliminarHerramientaExistente.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblEliminarHerramientaExistente.setBounds(21, 24, 343, 16);
		PanelEliminar.add(lblEliminarHerramientaExistente);
		
		JLabel label = new JLabel("Nombre");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("SansSerif", Font.BOLD, 15));
		label.setBounds(53, 61, 78, 16);
		PanelEliminar.add(label);
		
		
		
		JLabel label_1 = new JLabel("Nombre");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("SansSerif", Font.BOLD, 15));
		label_1.setBounds(74, 133, 78, 16);
		PanelEliminar.add(label_1);
		
		JLabel label_2 = new JLabel("Descripci\u00F3n");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("SansSerif", Font.BOLD, 15));
		label_2.setBounds(412, 133, 144, 16);
		PanelEliminar.add(label_2);
		
		JLabel label_3 = new JLabel("Precio");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("SansSerif", Font.BOLD, 15));
		label_3.setBounds(74, 222, 144, 16);
		PanelEliminar.add(label_3);
		
		JLabel label_4 = new JLabel("Unidades");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("SansSerif", Font.BOLD, 15));
		label_4.setBounds(74, 308, 144, 16);
		PanelEliminar.add(label_4);
		
		JLabel lblENombre = new JLabel("");
		lblENombre.setForeground(new Color(255, 255, 255));
		lblENombre.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblENombre.setBounds(74, 161, 264, 26);
		PanelEliminar.add(lblENombre);
		
		JLabel lblEPrecio = new JLabel("");
		lblEPrecio.setForeground(Color.WHITE);
		lblEPrecio.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblEPrecio.setBounds(74, 250, 264, 26);
		PanelEliminar.add(lblEPrecio);
		
		JLabel lblEUnidades = new JLabel("");
		lblEUnidades.setForeground(Color.WHITE);
		lblEUnidades.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblEUnidades.setBounds(74, 342, 264, 26);
		PanelEliminar.add(lblEUnidades);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(null);
		scrollPane_1.setBounds(412, 159, 264, 144);
		PanelEliminar.add(scrollPane_1);
		
		JTextArea lblEDescripcion = new JTextArea();
		scrollPane_1.setViewportView(lblEDescripcion);
		lblEDescripcion.setLineWrap(true);
		lblEDescripcion.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		lblEDescripcion.setBackground(new Color(128, 0, 0));
		lblEDescripcion.setForeground(new Color(255, 255, 255));
		lblEDescripcion.setEditable(false);
		
		
		comboBoxEliminar.setForeground(Color.black);
		comboBoxEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				BD conex = new BD();
				
				try{
					conex.Conectar("Herramientas_Jose");
					String Nombre = "", Descripcion = "";
					Double precio = 0.0;
					int unidades = 0;
					 String selectSQL = "SELECT Nombre, Descripcion, Precio, Unidades FROM Herramientas WHERE Nombre = ?";
					  PreparedStatement preparedStatement = conex.conn.prepareStatement(selectSQL);
					  preparedStatement.setString(1, comboBoxEliminar.getSelectedItem().toString().toLowerCase());
					  ResultSet rs = preparedStatement.executeQuery();
					  while (rs.next()) {
					  	Nombre = rs.getString("Nombre");
					  	Descripcion = rs.getString("Descripcion");
					  	precio = rs.getDouble("precio");
					  	unidades = rs.getInt("unidades");
					  
					  }
					 
					  lblENombre.setText(WordUtils.capitalizeFully(Nombre));
					  lblEDescripcion.setText(WordUtils.capitalize(Descripcion));
					  lblEPrecio.setText(Double.toString(precio));
					  lblEUnidades.setText(Integer.toString(unidades));
				}
				catch(Exception e2){
					System.err.println(e2);
				}
				finally{
					conex.Desconectar();
				}
				
			}
		});
		comboBoxEliminar.setModel(new DefaultComboBoxModel(new String[] {"Seleccione"}));
		comboBoxEliminar.setFont(new Font("SansSerif", Font.BOLD, 12));
		comboBoxEliminar.setBackground(new Color(255, 239, 213));
		comboBoxEliminar.setBounds(74, 89, 264, 26);
		PanelEliminar.add(comboBoxEliminar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				UIManager.put("nimbusBase", Color.GRAY);
				UIManager.put("textForeground", Color.BLACK);
				UIManager.put("OptionPane.messageForeground", Color.BLACK);
				
				if(comboBoxEliminar.getSelectedItem().toString().equalsIgnoreCase("seleccione")){
					JOptionPane.showMessageDialog(null, "Debe elegir un producto para eliminar!", "Dato obligatorio", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				BD mod = new BD();
				try {
					
					mod.EliminarHerramienta(comboBoxEliminar.getSelectedItem().toString().toLowerCase());
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				
				BD conexion = new BD();
			    Statement stmt = null;
			    conexion.Conectar("Herramientas_Jose");
			    try{
			    	
			    	String selectSQL = "SELECT Nombre FROM Herramientas";
					  PreparedStatement preparedStatement = conexion.conn.prepareStatement(selectSQL);
					  ResultSet rs = preparedStatement.executeQuery(selectSQL);
					  comboBoxHerramienta.setModel(new DefaultComboBoxModel(new String[] {"Seleccione"}));
					  comboBoxEliminar.setModel(new DefaultComboBoxModel(new String[] {"Seleccione"}));
					  while (rs.next()) {
						comboBoxHerramienta.addItem(WordUtils.capitalizeFully(rs.getString("Nombre")));
					  	comboBoxEliminar.addItem(WordUtils.capitalizeFully(rs.getString("Nombre")));
					  	
					  }
					  
				}
				catch(Exception xe){
						  System.err.println(xe);
					  }
			    conexion.Desconectar();
				
				lblENombre.setText("");
				lblEDescripcion.setText("");
				lblEUnidades.setText("");
				lblEPrecio.setText("");
				
				
				DefaultTableModel dm = (DefaultTableModel) table.getModel();
				int rowCount = dm.getRowCount();
				//Remove rows one by one from the end of the table
				for (int i = rowCount - 1; i >= 0; i--) {
				    dm.removeRow(i);
				}
				
				
			    conexion.Conectar("Herramientas_Jose");
			    try{
			    	DefaultTableModel model = (DefaultTableModel) table.getModel();
			    	String selectSQL = "SELECT ID, Nombre, Descripcion, Precio, Unidades FROM Herramientas";
					  PreparedStatement preparedStatement = conexion.conn.prepareStatement(selectSQL);
					  ResultSet rs = preparedStatement.executeQuery(selectSQL);
					  while (rs.next()) {
					   	 	
					  	model.addRow(new Object[]{rs.getInt("ID"), WordUtils.capitalize(rs.getString("Nombre")), rs.getString("Descripcion").substring(0, 1).toUpperCase() + rs.getString("Descripcion").substring(1), rs.getDouble("Precio"), rs.getInt("Unidades")});
					  	
					  }
					  
				}
				catch(Exception y){
						  System.err.println(y);
					  }
			    conexion.Desconectar();
			    
			    
			    
			    
			    
			    JOptionPane.showMessageDialog(null, "Herramienta eliminada!", "Operación Exitosa", JOptionPane.INFORMATION_MESSAGE);
				
				
			}
		});
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnEliminar.setBackground(new Color(128, 0, 0));
		btnEliminar.setBounds(521, 386, 90, 28);
		PanelEliminar.add(btnEliminar);
		
		JButton btnEBorrar = new JButton("Borrar");
		btnEBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BD conexion = new BD();
			    Statement stmt = null;
			    conexion.Conectar("Herramientas_Jose");
			    try{
			    	
			    	String selectSQL = "SELECT Nombre FROM Herramientas";
					  PreparedStatement preparedStatement = conexion.conn.prepareStatement(selectSQL);
					  ResultSet rs = preparedStatement.executeQuery(selectSQL);
					  comboBoxEliminar.setModel(new DefaultComboBoxModel(new String[] {"Seleccione"}));
					  while (rs.next()) {
					  	comboBoxEliminar.addItem(WordUtils.capitalizeFully(rs.getString("Nombre")));
					  }
					  
				}
				catch(Exception xe){
						  System.err.println(xe);
					  }
			    conexion.Desconectar();
				
				lblENombre.setText("");
				lblEDescripcion.setText("");
				lblEUnidades.setText("");
				lblEPrecio.setText("");
				
			}
		});
		btnEBorrar.setForeground(Color.WHITE);
		btnEBorrar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnEBorrar.setBackground(new Color(128, 0, 0));
		btnEBorrar.setBounds(614, 386, 90, 28);
		PanelEliminar.add(btnEBorrar);
		
		JPanel PanelVisualizar = new JPanel();
		PanelVisualizar.setBackground(new Color(128, 0, 0));
		tabbedPane.addTab("Visualizar  ", new ImageIcon(Inicio.class.getResource("/imagenes/viewred.png")), PanelVisualizar, null);
		PanelVisualizar.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(0, 0, 710, 54);
		PanelVisualizar.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnReporte = new JButton("Generar Reporte");
		btnReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 Document document = new Document();
				    // step 2
				    try {
						PdfWriter.getInstance(document, new FileOutputStream("C://reporte_herramientas.pdf"));
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (DocumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    // step 3
				    document.open();
				    // step 4
				    
				    LocalDateTime ldt = LocalDateTime.now();
				    
				    Double contadortotal = 0.0;
				    
				    Paragraph parrafo2 = new Paragraph("Herramientas & Materiales");
				    Paragraph parrafo3 = new Paragraph("Jose González\n\n");
				    
				    Paragraph paragraph = new Paragraph("Inventario de Herramientas - " + DateTimeFormatter.ofPattern("dd-MM-yyyy - hh:mm a", Locale.ENGLISH).format(ldt) + "\n\n");
				    paragraph.setAlignment(1);
				   
				    parrafo2.setAlignment(1);
				    parrafo3.setAlignment(1);
				    
				    try {
				    	
				    	document.add(parrafo2);
				    	document.add(parrafo3);
						document.add(paragraph);
					} catch (DocumentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				    

				PdfPTable tabla = new PdfPTable(5);
				
				com.itextpdf.text.Font f1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 8);
				f1.setColor(BaseColor.WHITE);
				
				com.itextpdf.text.Font f2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 8);
				f2.setColor(BaseColor.BLACK);
				
				PdfPCell cell = new PdfPCell(new Phrase("N° Item", f1));
				cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				BaseColor myColor = WebColors.getRGBColor("#800000");
				BaseColor blanco = WebColors.getRGBColor("#FFFFFF");
				cell.setBorder(Rectangle.BOTTOM);
				cell.setBackgroundColor(myColor);
				
				
				
				tabla.addCell(cell);
				cell = new PdfPCell(new Phrase("Nombre", f1));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				myColor = WebColors.getRGBColor("#800000");
				cell.setBorder(Rectangle.BOTTOM);
				cell.setBackgroundColor(myColor);
				
				tabla.addCell(cell);
				cell = new PdfPCell(new Phrase("Descripción", f1));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				myColor = WebColors.getRGBColor("#800000");
				cell.setBorder(Rectangle.BOTTOM);
				cell.setBackgroundColor(myColor);
				
				tabla.addCell(cell);
				cell = new PdfPCell(new Phrase("Precio", f1));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				myColor = WebColors.getRGBColor("#800000");
				cell.setBorder(Rectangle.BOTTOM);
				cell.setBackgroundColor(myColor);
				
				tabla.addCell(cell);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell = new PdfPCell(new Phrase("Unidades", f1));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				myColor = WebColors.getRGBColor("#800000");
				cell.setBorder(Rectangle.BOTTOM);
				cell.setBackgroundColor(myColor);
				tabla.addCell(cell);
				
				
				
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				
				
				
				
				
				
				
				   for(int aw=0;aw<table.getRowCount() ; aw++){
					   cell = new PdfPCell(new Phrase(Integer.toString(aw + 1), f2));
					   cell.setBorder(Rectangle.BOTTOM);
					   cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					   tabla.addCell(cell);
					   cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					   cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					   cell = new PdfPCell(new Phrase(table.getValueAt(aw, 1).toString(), f2));
					   cell.setBorder(Rectangle.BOTTOM);
					   cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					   tabla.addCell(cell);
					   cell = new PdfPCell(new Phrase(table.getValueAt(aw, 2).toString(), f2));
					   cell.setBorder(Rectangle.BOTTOM);
					   cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					   tabla.addCell(cell);
					   DecimalFormat format = new DecimalFormat("0.##");
					   cell = new PdfPCell(new Phrase(format.format(Double.parseDouble(table.getValueAt(aw, 3).toString())), f2));
					   cell.setBorder(Rectangle.BOTTOM);
					   cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					   tabla.addCell(cell);
					   cell = new PdfPCell(new Phrase(table.getValueAt(aw, 4).toString(), f2));
					   cell.setBorder(Rectangle.BOTTOM);
					   cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					   tabla.addCell(cell);
					   
					   
					   contadortotal += Double.parseDouble(table.getValueAt(aw, 3).toString());
				    }

				   cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				   
				   DecimalFormat formato = new DecimalFormat("#,###.##");
				   double IVA = contadortotal * 0.16;
				   double Sub = contadortotal - IVA;
				   
				   Paragraph parrafo4 = new Paragraph("\n\n\nSub-TTL: " + formato.format(Sub) + " BsS.", f2);
				   Paragraph parrafo5 = new Paragraph("I.V.A (16%): " + formato.format(IVA) + " BsS.", f2);
				   Paragraph parrafo6 = new Paragraph("Total: " + formato.format(contadortotal) + " BsS.", f2);
				   
				   parrafo4.setAlignment(2);
				   parrafo4.setIndentationRight(50);
				   parrafo5.setAlignment(2);
				   parrafo5.setIndentationRight(50);
				   parrafo6.setAlignment(2);
				   parrafo6.setIndentationRight(50);

				    // Step 5
				    try {
						document.add(tabla);
						document.add(parrafo4);
						document.add(parrafo5);
						document.add(parrafo6);
						Desktop.getDesktop().open(new File("C://reporte_herramientas.pdf"));
					} catch (DocumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				    // step 6
				    document.close();
				
				
			}
		});
		btnReporte.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnReporte.setForeground(new Color(255, 255, 255));
		btnReporte.setBackground(new Color(128, 0, 0));
		btnReporte.setBounds(563, 6, 141, 42);
		panel_3.add(btnReporte);
		
		JComboBox comboBoxOrdenar = new JComboBox();
		comboBoxOrdenar.setForeground(new Color(0, 0, 0));
		comboBoxOrdenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				if(comboBoxOrdenar.getSelectedItem().toString().equalsIgnoreCase("id")){
					
					DefaultTableModel dm = (DefaultTableModel) table.getModel();
					int rowCount = dm.getRowCount();
					//Remove rows one by one from the end of the table
					for (int i = rowCount - 1; i >= 0; i--) {
					    dm.removeRow(i);
					}
					
					
					 BD conexion = new BD();
					    Statement stmt = null;
					    conexion.Conectar("Herramientas_Jose");
					    try{
					    	DefaultTableModel model = (DefaultTableModel) table.getModel();
					    	String selectSQL = "SELECT ID, Nombre, Descripcion, Precio, Unidades FROM Herramientas ORDER BY ID";
							  PreparedStatement preparedStatement = conexion.conn.prepareStatement(selectSQL);
							  ResultSet rs = preparedStatement.executeQuery(selectSQL);
							  while (rs.next()) {
							  
							  	
							  	
							  	model.addRow(new Object[]{rs.getInt("ID"), WordUtils.capitalize(rs.getString("Nombre")), rs.getString("Descripcion").substring(0, 1).toUpperCase() + rs.getString("Descripcion").substring(1), rs.getDouble("Precio"), rs.getInt("Unidades")});
							  	
							  }
							  
						}
						catch(Exception abc){
								  System.err.println(abc);
							  }
					    conexion.Desconectar();
				}
				if(comboBoxOrdenar.getSelectedItem().toString().equalsIgnoreCase("nombre")){
					DefaultTableModel dm = (DefaultTableModel) table.getModel();
					int rowCount = dm.getRowCount();
					//Remove rows one by one from the end of the table
					for (int i = rowCount - 1; i >= 0; i--) {
					    dm.removeRow(i);
					}
					
					
					
					 BD conexion = new BD();
					    Statement stmt = null;
					    conexion.Conectar("Herramientas_Jose");
					    try{
					    	DefaultTableModel model = (DefaultTableModel) table.getModel();
					    	String selectSQL = "SELECT ID, Nombre, Descripcion, Precio, Unidades FROM Herramientas ORDER BY Nombre";
							  PreparedStatement preparedStatement = conexion.conn.prepareStatement(selectSQL);
							  ResultSet rs = preparedStatement.executeQuery(selectSQL);
							  while (rs.next()) {
							  
							  	
							  	
							  	model.addRow(new Object[]{rs.getInt("ID"), WordUtils.capitalize(rs.getString("Nombre")), rs.getString("Descripcion").substring(0, 1).toUpperCase() + rs.getString("Descripcion").substring(1), rs.getDouble("Precio"), rs.getInt("Unidades")});
							  	
							  }
							  
						}
						catch(Exception abc){
								  System.err.println(abc);
							  }
					    conexion.Desconectar();
				}
				if(comboBoxOrdenar.getSelectedItem().toString().equalsIgnoreCase("descripción")){
					DefaultTableModel dm = (DefaultTableModel) table.getModel();
					int rowCount = dm.getRowCount();
					//Remove rows one by one from the end of the table
					for (int i = rowCount - 1; i >= 0; i--) {
					    dm.removeRow(i);
					}
					
					
					
					 BD conexion = new BD();
					    Statement stmt = null;
					    conexion.Conectar("Herramientas_Jose");
					    try{
					    	DefaultTableModel model = (DefaultTableModel) table.getModel();
					    	String selectSQL = "SELECT ID, Nombre, Descripcion, Precio, Unidades FROM Herramientas ORDER BY Descripcion";
							  PreparedStatement preparedStatement = conexion.conn.prepareStatement(selectSQL);
							  ResultSet rs = preparedStatement.executeQuery(selectSQL);
							  while (rs.next()) {
							  
							  	
							  	
							  	model.addRow(new Object[]{rs.getInt("ID"), WordUtils.capitalize(rs.getString("Nombre")), rs.getString("Descripcion").substring(0, 1).toUpperCase() + rs.getString("Descripcion").substring(1), rs.getDouble("Precio"), rs.getInt("Unidades")});
							  	
							  }
							  
						}
						catch(Exception abc){
								  System.err.println(abc);
							  }
					    conexion.Desconectar();
	
				}
				if(comboBoxOrdenar.getSelectedItem().toString().equalsIgnoreCase("precio")){
					DefaultTableModel dm = (DefaultTableModel) table.getModel();
					int rowCount = dm.getRowCount();
					//Remove rows one by one from the end of the table
					for (int i = rowCount - 1; i >= 0; i--) {
					    dm.removeRow(i);
					}
					
					
					
					 BD conexion = new BD();
					    Statement stmt = null;
					    conexion.Conectar("Herramientas_Jose");
					    try{
					    	DefaultTableModel model = (DefaultTableModel) table.getModel();
					    	String selectSQL = "SELECT ID, Nombre, Descripcion, Precio, Unidades FROM Herramientas ORDER BY Precio DESC";
							  PreparedStatement preparedStatement = conexion.conn.prepareStatement(selectSQL);
							  ResultSet rs = preparedStatement.executeQuery(selectSQL);
							  while (rs.next()) {
							  
							  	
							  	
							  	model.addRow(new Object[]{rs.getInt("ID"), WordUtils.capitalize(rs.getString("Nombre")), rs.getString("Descripcion").substring(0, 1).toUpperCase() + rs.getString("Descripcion").substring(1), rs.getDouble("Precio"), rs.getInt("Unidades")});
							  	
							  }
							  
						}
						catch(Exception abc){
								  System.err.println(abc);
							  }
					    conexion.Desconectar();
				}
				if(comboBoxOrdenar.getSelectedItem().toString().equalsIgnoreCase("unidades")){
					DefaultTableModel dm = (DefaultTableModel) table.getModel();
					int rowCount = dm.getRowCount();
					//Remove rows one by one from the end of the table
					for (int i = rowCount - 1; i >= 0; i--) {
					    dm.removeRow(i);
					}
					
					
					
					 BD conexion = new BD();
					    Statement stmt = null;
					    conexion.Conectar("Herramientas_Jose");
					    try{
					    	DefaultTableModel model = (DefaultTableModel) table.getModel();
					    	String selectSQL = "SELECT ID, Nombre, Descripcion, Precio, Unidades FROM Herramientas ORDER BY Unidades DESC";
							  PreparedStatement preparedStatement = conexion.conn.prepareStatement(selectSQL);
							  ResultSet rs = preparedStatement.executeQuery(selectSQL);
							  while (rs.next()) {
							  
							  	
							  	
							  	model.addRow(new Object[]{rs.getInt("ID"), WordUtils.capitalize(rs.getString("Nombre")), rs.getString("Descripcion").substring(0, 1).toUpperCase() + rs.getString("Descripcion").substring(1), rs.getDouble("Precio"), rs.getInt("Unidades")});
							  	
							  }
							  
						}
						catch(Exception abc){
								  System.err.println(abc);
							  }
					    conexion.Desconectar();
				}
				
				
			}
		});
		comboBoxOrdenar.setBackground(new Color(255, 255, 255));
		comboBoxOrdenar.setFont(new Font("SansSerif", Font.BOLD, 12));
		comboBoxOrdenar.setModel(new DefaultComboBoxModel(new String[] {"ID", "Nombre", "Descripci\u00F3n", "Precio", "Unidades"}));
		comboBoxOrdenar.setBounds(159, 14, 203, 26);
		panel_3.add(comboBoxOrdenar);
		
		JLabel lblNewLabel_1 = new JLabel("Ordenar por");
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(6, 19, 141, 16);
		panel_3.add(lblNewLabel_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBorder(null);
		scrollPane_2.setBackground(new Color(128, 0, 0));
		scrollPane_2.setBounds(10, 66, 694, 348);
		PanelVisualizar.add(scrollPane_2);
		
		table = new JTable();
		table.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		table.setRowSelectionAllowed(false);
		table.setForeground(new Color(255, 255, 255));
		table.setBackground(new Color(128, 0, 0));
		table.setShowHorizontalLines(true);
		table.setFont(new Font("SansSerif", Font.BOLD, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombre", "Descripci\u00F3n", "Precio", "Unidades"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Object.class, Object.class, Double.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(0).setMaxWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(125);
		table.getColumnModel().getColumn(3).setMaxWidth(125);
		table.getColumnModel().getColumn(4).setPreferredWidth(125);
		table.getColumnModel().getColumn(4).setMaxWidth(125);
		scrollPane_2.setViewportView(table);
		table.setGridColor(new Color(255, 255, 255));
		
		scrollPane_2.getViewport().setBackground(new Color(128, 0, 0));
		
		DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
		headerRenderer.setBackground(Color.WHITE);
		headerRenderer.setForeground(new Color(128, 0, 0));
		headerRenderer.setHorizontalAlignment(JLabel.CENTER);

		for (int i = 0; i < table.getModel().getColumnCount(); i++) {
		        table.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
		}
		
		
		
		
		Inicio.setSize(728, 600);
		Inicio.setResizable(false);
		Inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		Inicio.setLocation(dim.width/2-Inicio.getSize().width/2, dim.height/2-Inicio.getSize().height/2);
		
		Inicio.setVisible(true);
		
		txtNombre.requestFocus();
		
		
	    BD conexion = new BD();
	    Statement stmt = null;
	    conexion.Conectar("Herramientas_Jose");
	    try{
	    	DefaultTableModel model = (DefaultTableModel) table.getModel();
	    	String selectSQL = "SELECT ID, Nombre, Descripcion, Precio, Unidades FROM Herramientas";
			  PreparedStatement preparedStatement = conexion.conn.prepareStatement(selectSQL);
			  ResultSet rs = preparedStatement.executeQuery(selectSQL);
			  while (rs.next()) {
			  	comboBoxHerramienta.addItem(WordUtils.capitalizeFully(rs.getString("Nombre")));
			  	comboBoxEliminar.addItem(WordUtils.capitalizeFully(rs.getString("Nombre")));
			  	
			  	
			  	
			  	model.addRow(new Object[]{rs.getInt("ID"), WordUtils.capitalize(rs.getString("Nombre")), rs.getString("Descripcion").substring(0, 1).toUpperCase() + rs.getString("Descripcion").substring(1), rs.getDouble("Precio"), rs.getInt("Unidades")});
			  	
			  }
			  
		}
		catch(Exception e){
				  System.err.println(e);
			  }
	    conexion.Desconectar();
	    
	    
	    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	    centerRenderer.setHorizontalAlignment( JLabel.CENTER );
	    table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
	    table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
	    table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
	    table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
	    table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );

	}
}

