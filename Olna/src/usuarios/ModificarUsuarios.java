package usuarios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import conexion.Conexion;
import principal.Acceso;
import principal.MenuPrincipal;

public class ModificarUsuarios extends JFrame {
	
	private static final String url = "jdbc:mysql://localhost:3306/olna?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String user = "root";
	private static final String password = "root";
	
	PreparedStatement ps;
	ResultSet rs;
	Connection conn;
	
	 public static Connection getConnection() {
	    	
	    	
	    	Connection conn = null;
	    	
	    	try {
	    		Class.forName("com.mysql.cj.jdbc.Driver");
	    		conn = DriverManager.getConnection(url,user,password);
	    		if(conn!=null) {
	    			System.out.println("Conexión establecida");
	    		}
	    		}catch (ClassNotFoundException | SQLException e) {
	    			System.out.println("Error al conectar" + e);
	    		}
			return conn;
	    	//Con este método nos retorna la conexion
	    }
	 private JPanel contentPane;
	 private JTextField txtUsuario;
	 private JPasswordField txtPassword;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acceso frame = new Acceso();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ModificarUsuarios() {
		
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imageneslogo.png"));
		setTitle("INTRANET OLNADETECTIVES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(new ImageIcon(getClass().getResource("/Imagenes/LOGO OLNA.jpg")).getImage());
		setBounds(100, 100, 610, 361);
		setResizable(false);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		panel_2.setBackground(new Color(204, 204, 255));
		panel_2.setBounds(133, 95, 461, 237);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnAltaUsuario = new JButton("");
		btnAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUsuario();	
			}
		});
		btnAltaUsuario.setToolTipText("Alta Usuario");
		btnAltaUsuario.setIcon(new ImageIcon("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\registro.png"));
		btnAltaUsuario.setBounds(130, 144, 89, 67);
		panel_2.add(btnAltaUsuario);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(32, 67, 96, 14);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(32, 104, 96, 14);
		panel_2.add(lblNewLabel_3);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(149, 61, 218, 20);
		panel_2.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(149, 102, 218, 20);
		panel_2.add(txtPassword);
		
		JButton btnEliminar = new JButton("");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				borrarUsuario();
			}
		});
		btnEliminar.setIcon(new ImageIcon("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\trash.png"));
		btnEliminar.setBounds(271, 144, 89, 67);
		btnEliminar.setToolTipText("Eliminar");
		panel_2.add(btnEliminar);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		panel_3.setBounds(0, 0, 594, 98);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ALTA Y BAJA DE USUARIO");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBackground(new Color(204, 204, 204));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setLabelFor(this);
		lblNewLabel_1.setBounds(140, 0, 454, 98);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 132, 98);
		panel_3.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\logo1.png"));
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(0, 0, 146, 98);
		panel_3.add(lblNewLabel_6);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 104, 133, 228);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Salir");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setForeground(Color.BLUE);
		lblNewLabel_5.setBounds(48, 125, 38, 14);
		panel.add(lblNewLabel_5);
		
		
		JButton btnSalir = new JButton(new ImageIcon("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\icono salir.png"));
		btnSalir.setBounds(20, 150, 89, 67);
		panel.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setToolTipText("Salir");
		
		JButton btnMenuPrincipal = new JButton("");
		btnMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal menu = new MenuPrincipal();
				menu.setVisible(true);
				dispose();
			}
		});
		btnMenuPrincipal.setIcon(new ImageIcon("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\home.png"));
		btnMenuPrincipal.setBounds(20, 36, 89, 67);
		btnMenuPrincipal.setToolTipText("Menu Principal");
		panel.add(btnMenuPrincipal);
		
		JLabel lblNewLabel_4 = new JLabel("Menu Principal");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(20, 11, 89, 14);
		panel.add(lblNewLabel_4);
	
	}
	public void altaUsuario() {
		
		Connection con = null;
		try {
			con = getConnection();
			ps= con.prepareStatement("INSERT INTO usuarios(id_user,clave) VALUES (?,?)");
			ps.setString(1, txtUsuario.getText());
			ps.setString(2, String.valueOf(txtPassword.getPassword()));
			ps.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "El usuario ha sido creado con éxito");
			
			con.close();
			
		} catch(Exception e) {
			System.err.println(e);
		}
	
	
	}
		
	
	public void borrarUsuario() {
		
		Connection con = null;
		
		try {
			
			con = getConnection();
			
			ps= con.prepareStatement("delete from usuarios where id_user = ? AND clave =?");
			
			ps.setString(1, txtUsuario.getText());
			ps.setString(2, String.valueOf(txtPassword.getPassword()));
			
			ps.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Usuario borrado");
		
			
		} catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, "No se ha completado la accion de borrado");
		}
	
	}
}
