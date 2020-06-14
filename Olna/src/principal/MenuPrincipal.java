package principal;


import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import biblioteca.Biblioteca;
import casos.Casos;
import clientes.Clientes;
import empleados.RegistroEmpleados;
import usuarios.ModificarUsuarios;

public class MenuPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
	public MenuPrincipal() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\logo.png"));
		setTitle("INTRANET OLNADETECTIVES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 361);
		setIconImage(new ImageIcon(getClass().getResource("/Imagenes/LOGO OLNA.jpg")).getImage());
		setResizable(false);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(0, 0, 88, 322);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Salir");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(27, 188, 37, 14);
		panel.add(lblNewLabel_2);
		
	

		
		JButton btnSalir = new JButton(new ImageIcon("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\icono salir.png"));
		btnSalir.setBounds(10, 213, 68, 66);
		panel.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setToolTipText("Salir");
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Biblioteca bib = new Biblioteca();
				bib.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\LEY.png"));
		btnNewButton_2.setBounds(10, 61, 68, 66);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_4 = new JLabel("Biblioteca");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(18, 36, 60, 14);
		panel.add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		panel_1.setBackground(new Color(51, 204, 255));
		panel_1.setBounds(84, 230, 510, 92);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("RRSS");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(21, 40, 55, 20);
		panel_1.add(lblNewLabel_5);
		
		JButton btnFacebook = new JButton("");
		btnFacebook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop.getDesktop().browse(new URI("https://es-es.facebook.com/"));
				}catch (Exception ex){
					JOptionPane.showMessageDialog(null, "Error, la página no existe");
				}
			}
		});
		btnFacebook.setToolTipText("Facebook");
		btnFacebook.setIcon(new ImageIcon("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\facebook.png"));
		btnFacebook.setBounds(122, 28, 55, 53);
		panel_1.add(btnFacebook);
		
		JButton btnTwitter = new JButton("");
		btnTwitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop.getDesktop().browse(new URI("https://twitter.com/explore"));
				}catch (Exception ex){
					JOptionPane.showMessageDialog(null, "Error, la página no existe");
				}
			}
		});
		btnTwitter.setToolTipText("Twitter");
		btnTwitter.setIcon(new ImageIcon("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\twitter.png"));
		btnTwitter.setBounds(225, 28, 55, 53);
		panel_1.add(btnTwitter);
		
		JButton btnInstagram = new JButton("");
		btnInstagram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop.getDesktop().browse(new URI("https://www.instagram.com/?hl=es"));
				}catch (Exception ex){
					JOptionPane.showMessageDialog(null, "Error, la página no existe");
				}
			}
		});
		btnInstagram.setToolTipText("Instagram");
		btnInstagram.setIcon(new ImageIcon("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\instagram.png"));
		btnInstagram.setBounds(319, 28, 55, 53);
		panel_1.add(btnInstagram);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		panel_2.setBackground(new Color(204, 204, 255));
		panel_2.setBounds(84, 95, 510, 135);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnClientes = new JButton(new ImageIcon("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\clientes.png"));
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes cli = new Clientes();
				cli.setVisible(true);
				dispose();
			}
		});
		btnClientes.setToolTipText("Clientes");
		btnClientes.setBounds(283, 11, 89, 67);
		panel_2.add(btnClientes);
		
		JButton btnCasos = new JButton(new ImageIcon("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\casos.png"));
		btnCasos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Casos casos = new Casos();
				casos.setVisible(true);
				dispose();
			}
		});
		btnCasos.setToolTipText("Casos");
		btnCasos.setBounds(149, 11, 89, 67);
		panel_2.add(btnCasos);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistroEmpleados regEmp = new RegistroEmpleados();
				regEmp.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\empleados.png"));
		btnNewButton.setToolTipText("Empleados");
		btnNewButton.setBounds(30, 11, 89, 67);
		panel_2.add(btnNewButton);
		
		JLabel lblNewLabel_6 = new JLabel("Empleados");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(40, 97, 80, 14);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Casos");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(174, 98, 46, 14);
		panel_2.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Clientes");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(297, 98, 67, 14);
		panel_2.add(lblNewLabel_8);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarUsuarios users = new ModificarUsuarios ();
				users.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\user.png"));
		btnNewButton_1.setBounds(396, 11, 89, 67);
		panel_2.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Usuarios");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(417, 98, 63, 14);
		panel_2.add(lblNewLabel_3);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		panel_3.setBounds(89, 0, 505, 98);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\logo1.png"));
		lblNewLabel.setBounds(0, 0, 139, 98);
		panel_3.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("APLICACION DE GESTION");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBackground(new Color(204, 204, 204));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setLabelFor(this);
		lblNewLabel_1.setBounds(139, 0, 366, 98);
		panel_3.add(lblNewLabel_1);
	}
}
