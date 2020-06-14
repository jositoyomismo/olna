package empleados;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import principal.MenuPrincipal;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class RegistroEmpleados extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String url = "jdbc:mysql://localhost:3306/olna?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String user = "root";
	private static final String password = "root";
	
	PreparedStatement ps;
	ResultSet rs;
	Connection conn;
	
	 public static Connection getConnection() {
	    	
		 Connection conn=null;
	    	
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
	private JTextField txtidEmpleado;
	private JTextField txtNombre;
	private JTextField txtEmail;
	private JTextField txtDepart;
	private JTable table;

	public RegistroEmpleados() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\logo.png"));
		setTitle("INTRANET OLNADETECTIVES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 812, 421);
		setIconImage(new ImageIcon(getClass().getResource("/Imagenes/LOGO OLNA.jpg")).getImage());
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(0, 0, 88, 392);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnSalir = new JButton(new ImageIcon("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\icono salir.png"));
		btnSalir.setBounds(10, 278, 68, 59);
		panel.add(btnSalir);
		btnSalir.setToolTipText("Salir");
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal menu = new MenuPrincipal();
				menu.setVisible(true);
				dispose();
			}
		});
		
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\home.png"));
		btnNewButton.setBounds(10, 73, 68, 58);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Salir");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(21, 253, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Menu");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(21, 35, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Principal");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(20, 51, 68, 14);
		panel.add(lblNewLabel_4);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(Color.WHITE);
		panel_2.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		panel_2.setBackground(new Color(204, 204, 255));
		panel_2.setBounds(89, 94, 717, 298);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		
		JLabel lblNewLabel_5 = new JLabel("N\u00BA de empleado:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(10, 11, 116, 14);
		panel_2.add(lblNewLabel_5);
		
		txtidEmpleado = new JTextField();
		txtidEmpleado.setBounds(115, 11, 187, 20);
		panel_2.add(txtidEmpleado);
		txtidEmpleado.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Nombre:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(10, 50, 74, 14);
		panel_2.add(lblNewLabel_6);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(115, 47, 187, 20);
		panel_2.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel txtDepartamento = new JLabel("Departamento:");
		txtDepartamento.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtDepartamento.setForeground(Color.WHITE);
		txtDepartamento.setBounds(10, 87, 95, 14);
		panel_2.add(txtDepartamento);
		
		
		JLabel lblNewLabel_9 = new JLabel("E-Mail");
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_9.setBounds(10, 125, 95, 14);
		panel_2.add(lblNewLabel_9);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(115, 122, 185, 20);
		panel_2.add(txtEmail);
		txtEmail.setColumns(10);		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		panel_3.setBounds(89, 0, 717, 98);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\logo1.png"));
		lblNewLabel.setBounds(0, 0, 133, 98);
		panel_3.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("REGISTRO DE EMPLEADOS");
		lblNewLabel_1.setBounds(136, 0, 581, 98);
		panel_3.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBackground(new Color(204, 204, 204));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setLabelFor(this);
	
	JButton btnGuardar = new JButton("");
	btnGuardar.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) {
			
			addRow();
		}});
		btnGuardar.setToolTipText("Guardar");
		btnGuardar.setIcon(new ImageIcon("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\guardar.png"));
		btnGuardar.setBounds(166, 225, 80, 64);
		panel_2.add(btnGuardar);
	
	JButton btnBorrar = new JButton("");
	btnBorrar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			deleteRow();
		}
	});
	btnBorrar.setIcon(new ImageIcon("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\trash.png"));
	btnBorrar.setBounds(46, 225, 80, 64);
	panel_2.add(btnBorrar);
	
	txtDepart = new JTextField();
	txtDepart.setBounds(115, 84, 187, 20);
	panel_2.add(txtDepart);
	txtDepart.setColumns(10);
	
	JButton btnModificar = new JButton("");
	btnModificar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			updateRow();
		}
		
	});
	btnModificar.setToolTipText("Actualizar");
	btnModificar.setIcon(new ImageIcon("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\modificar.png"));
	btnModificar.setBounds(46, 150, 80, 64);
	panel_2.add(btnModificar);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(312, 11, 395, 278);
	panel_2.add(scrollPane);
	
	table = new JTable();
	table.setModel(new DefaultTableModel(
		new Object[][] {
		},
		new String[] {
			"Nº Empleado", "Nombre", "Departamento", "Email"
		}
	));
	scrollPane.setViewportView(table);
	
	JButton btnBuscar = new JButton("");
	btnBuscar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			showRow();
		}
	});
	btnBuscar.setToolTipText("Mostrar listado");
	btnBuscar.setIcon(new ImageIcon("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\buscar.png"));
	btnBuscar.setBounds(166, 153, 80, 61);
	panel_2.add(btnBuscar);
	}
	
 private void addRow() {
		 
		 DefaultTableModel model = (DefaultTableModel)table.getModel();
		 
		 model.addRow(new Object [] {Integer.parseInt(txtidEmpleado.getText()), txtNombre.getText(), txtDepart.getText(), txtEmail.getText()});
		 
		 Connection con = null;
			try {
				con = getConnection();
				ps= con.prepareStatement("INSERT INTO empleado(txtidEmpleado,txtNombre,txtDepart,txtEmail) VALUES (?,?,?,?)");
				ps.setInt(1, Integer.parseInt(txtidEmpleado.getText()));
				ps.setString(2,txtNombre.getText());
				ps.setString(3, txtDepart.getText());
				ps.setString(4, txtEmail.getText());
				ps.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "El empleado ha sido insertado con éxito");
				
				con.close();
				
			} catch(Exception e) {
				System.err.println(e);
			}
		
		
	 }
	 
	 private void deleteRow() {
		 
		 DefaultTableModel model = (DefaultTableModel)table.getModel();

		 if(table.getSelectedRowCount()==1) {
			 model.removeRow(table.getSelectedRow());
		 }else {
			 if(table.getRowCount()==0) {
				 
				 JOptionPane.showMessageDialog(this, "La tabla está vacía");
			 }else {
				 JOptionPane.showMessageDialog(this, "Por favor, seleccione una fila");
			 }
		 }
		 Connection con = null;
			try {
				String sql = "DELETE FROM empleado WHERE id_empleado =?";
				con = getConnection();
				ps= con.prepareStatement(sql);
				ps.setInt(1, Integer.parseInt(txtidEmpleado.getText()));
				
				ps.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "El empleado ha sido borrado con éxito");
				
				con.close();
				
			} catch(Exception e) {
				System.err.println(e);
			}
		 
	 }
	 private void updateRow() {
		 
		 
		 Connection con = null;
			try {
				String sql = "UPDATE empleados SET txtNombre=?, txtDepart=? txtEmail=? WHERE id_empleado=?";
				con = getConnection();
				ps= con.prepareStatement(sql);
				ps.setInt(1, Integer.parseInt(txtidEmpleado.getText()));
				ps.setString(2,txtNombre.getText());
				ps.setString(3, txtDepart.getText());
				ps.setString(4, txtEmail.getText());
				ps.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "El empleado ha sido actualizado con éxito");
				
				con.close();
				
			} catch(Exception e) {
				System.err.println(e);
			}
		 
	 }
	 private void showRow() {
		 
		 
		 Connection con = null;
			try {
				con = getConnection();
				String sql = "SELECT * FROM empleados";
				ps = con.prepareStatement(sql);
				rs=ps.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				
				con.close();
				
			} catch(Exception e) {
				System.err.println(e);
			}
		 
		
	 }
}