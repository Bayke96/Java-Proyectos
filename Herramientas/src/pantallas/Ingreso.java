package pantallas;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;



public class Ingreso {
	private static JTextField txtNombre;
	private static JPasswordField passwordField;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		JFrame ventana = new JFrame("Herramientas Jose González");
		ventana.getContentPane().setBackground(new Color(119, 136, 153));
		ventana.setSize(400, 401);
		ventana.setResizable(false);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		ventana.setLocation(dim.width/2-ventana.getSize().width/2, dim.height/2-ventana.getSize().height/2);
		ventana.getContentPane().setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtNombre.getText().trim().equalsIgnoreCase("")){
					JOptionPane.showMessageDialog(null, "Debe introducir un nombre de usuario", "Dato obligatorio", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(!txtNombre.getText().trim().equalsIgnoreCase("jose gonzalez") && !txtNombre.getText().trim().equalsIgnoreCase("jose gonzález")){
					JOptionPane.showMessageDialog(null, "Nombre de usuario incorrecto", "Error de acceso", JOptionPane.ERROR_MESSAGE);
					return;
				}
				passwordField.requestFocus();
			}
		});
		txtNombre.setForeground(new Color(255, 255, 255));
		txtNombre.setBackground(new Color(119, 136, 153));
		txtNombre.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(255, 255, 255)));
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtNombre.setBounds(132, 161, 122, 28);
		ventana.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre de Usuario");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(132, 130, 122, 16);
		ventana.getContentPane().add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblContrasea.setBounds(132, 223, 122, 16);
		ventana.getContentPane().add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = new String(passwordField.getPassword());
				
				if(password.equalsIgnoreCase("")){
					JOptionPane.showMessageDialog(null, "Debe introducir una contraseña", "Dato obligatorio", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(!password.equalsIgnoreCase("a1b2c3d4e5")){
					JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Error de acceso", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				ventana.dispose();
				Inicio.main(args);
			}
		});
		passwordField.setForeground(new Color(255, 255, 255));
		passwordField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(255, 255, 255)));
		passwordField.setBackground(new Color(119, 136, 153));
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(132, 251, 122, 28);
		ventana.getContentPane().add(passwordField);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String password = new String(passwordField.getPassword());
				
				if(txtNombre.getText().trim().equalsIgnoreCase("")){
					JOptionPane.showMessageDialog(null, "Debe introducir un nombre de usuario", "Dato obligatorio", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(password.equalsIgnoreCase("")){
					JOptionPane.showMessageDialog(null, "Debe introducir una contraseña", "Dato obligatorio", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(!txtNombre.getText().trim().equalsIgnoreCase("jose gonzalez") && !txtNombre.getText().trim().equalsIgnoreCase("jose gonzález")){
					JOptionPane.showMessageDialog(null, "Nombre de usuario incorrecto", "Error de acceso", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(!password.equalsIgnoreCase("a1b2c3d4e5")){
					JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Error de acceso", JOptionPane.ERROR_MESSAGE);
					return;
				}
				ventana.dispose();
				Inicio.main(args);
			}
		});
		btnAceptar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnAceptar.setForeground(new Color(255, 255, 255));
		btnAceptar.setBackground(new Color(119, 136, 153));
		btnAceptar.setBounds(103, 327, 90, 28);
		ventana.getContentPane().add(btnAceptar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtNombre.setText("");
				passwordField.setText("");
			}
		});
		btnBorrar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnBorrar.setForeground(new Color(255, 255, 255));
		btnBorrar.setBackground(new Color(119, 136, 153));
		btnBorrar.setBounds(195, 327, 90, 28);
		ventana.getContentPane().add(btnBorrar);
		
		JLabel ToolsLabel = new JLabel("");
		ToolsLabel.setIcon(new ImageIcon(Ingreso.class.getResource("/imagenes/tools.png")));
		ToolsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ToolsLabel.setBounds(132, 20, 129, 104);
		ventana.getContentPane().add(ToolsLabel);
		
		ventana.setVisible(true);
		
		txtNombre.requestFocus();
	}
}
