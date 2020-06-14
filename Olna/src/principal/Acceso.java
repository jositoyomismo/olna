package principal;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import conexion.Conexion;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Acceso extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	
	
	Conexion cc = new Conexion();
	
	Connection con = cc.conexion();
	

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
	public Acceso() {
		
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\logo.png"));
		setTitle("INTRANET OLNADETECTIVES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 361);
		setResizable(false);
		setVisible(true);
		setIconImage(new ImageIcon(getClass().getResource("/Imagenes/LOGO OLNA.jpg")).getImage());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		panel_2.setBackground(new Color(204, 204, 255));
		panel_2.setBounds(0, 95, 594, 237);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarAcceso();	
			}
		});
		btnNewButton_1.setToolTipText("Acceder");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\registro.png"));
		btnNewButton_1.setBounds(155, 141, 89, 67);
		panel_2.add(btnNewButton_1);
		
	

		
		JButton btnSalir = new JButton(new ImageIcon("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\icono salir.png"));
		btnSalir.setBounds(346, 141, 89, 67);
		panel_2.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnSalir.setToolTipText("Salir");
		
		JLabel lblNewLabel_2 = new JLabel("Usuario:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(107, 31, 96, 14);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(107, 82, 96, 14);
		panel_2.add(lblNewLabel_3);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(248, 29, 218, 20);
		panel_2.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(248, 80, 218, 20);
		panel_2.add(txtPassword);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		panel_3.setBounds(0, 0, 594, 98);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ACCESO A SISTEMA");
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
		
	}
	public void validarAcceso() {
		
		int resultado=0;
		
		try{
			
			String usuario = txtUsuario.getText();
			
			String pass = String.valueOf(txtPassword.getPassword());
			
			String sql ="select * from usuarios where id_user ='" + usuario + "' and clave='" + pass + "' ";
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			
		
			
			if (rs.next()) {
				
				resultado=1;
				
				if(resultado==1) {
									
					MenuPrincipal menPrin = new MenuPrincipal();
					
					menPrin.setVisible(true);
					
					dispose();
					
					JOptionPane.showMessageDialog(null, "Acceso permitido!");
					
				}
			}
				
		}catch (Exception e) {
					
		}
		
	}
}
