package clientes;


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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import principal.MenuPrincipal;



public class Clientes extends JFrame {


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
	
	public JPanel contentPane;
	public JTextField txtIdCliente;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTable table;
	private JTextField txtTipoCaso;
	


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

	 public Clientes() {
			
	        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\josit\\eclipse-workspace\\olna\\src\\Imagenes\\logo.png"));
			setTitle("INTRANET OLNADETECTIVES");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 860, 479);
			setIconImage(new ImageIcon(getClass().getResource("/Imagenes/LOGO OLNA.jpg")).getImage());
			setResizable(false);
			setVisible(true);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(255, 255, 255), 3));
			panel.setBackground(new Color(0, 153, 255));
			panel.setBounds(0, 0, 88, 450);
			contentPane.add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel_2 = new JLabel("Menu");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setBounds(30, 27, 43, 14);
			panel.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("Principal");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setForeground(Color.WHITE);
			lblNewLabel_3.setBounds(10, 52, 68, 14);
			panel.add(lblNewLabel_3);
			
			
			JLabel lblNewLabel_4 = new JLabel("Salir");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel_4.setForeground(Color.WHITE);
			lblNewLabel_4.setBounds(30, 222, 36, 14);
			panel.add(lblNewLabel_4);
			
			JButton salir = new JButton("");
			salir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			
			salir.setToolTipText("Salir");
			salir.setIcon(new ImageIcon("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\icono salir.png"));
			salir.setBounds(10, 261, 68, 69);
			panel.add(salir);
			
			JButton btnNewButton = new JButton("");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MenuPrincipal menu = new MenuPrincipal();
					menu.setVisible(true);
					dispose();
				}
			});
			btnNewButton.setIcon(new ImageIcon("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\home.png"));
			btnNewButton.setBounds(10, 78, 68, 62);
			panel.add(btnNewButton);
			
			JPanel txtResuelto = new JPanel();
			txtResuelto.setForeground(Color.WHITE);
			txtResuelto.setBorder(new LineBorder(new Color(255, 255, 255), 3));
			txtResuelto.setBackground(new Color(204, 204, 255));
			txtResuelto.setBounds(89, 109, 765, 341);
			contentPane.add(txtResuelto);
			txtResuelto.setLayout(null);
			
			
			
			JLabel lblNewLabel_5 = new JLabel("N\u00BA de cliente:");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_5.setForeground(Color.WHITE);
			lblNewLabel_5.setBounds(10, 11, 116, 14);
			txtResuelto.add(lblNewLabel_5);
			
			txtIdCliente = new JTextField();
			txtIdCliente.setBounds(115, 11, 126, 20);
			txtResuelto.add(txtIdCliente);
			txtIdCliente.setColumns(10);
			
			JLabel lblNewLabel_6 = new JLabel("Nombre:");
			lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_6.setForeground(Color.WHITE);
			lblNewLabel_6.setBounds(10, 50, 74, 14);
			txtResuelto.add(lblNewLabel_6);
			
			JLabel lblNewLabel_7 = new JLabel("Direccion:");
			lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_7.setForeground(Color.WHITE);
			lblNewLabel_7.setBounds(10, 87, 95, 14);
			txtResuelto.add(lblNewLabel_7);
			
			
			txtNombre = new JTextField();
			txtNombre.setBounds(115, 47, 126, 20);
			txtResuelto.add(txtNombre);
			txtNombre.setColumns(10);
			
			txtDireccion = new JTextField();
			txtDireccion.setBounds(115, 84, 126, 20);
			txtResuelto.add(txtDireccion);
			txtDireccion.setColumns(10);
		
			
			JButton btnBorrar = new JButton("");
			btnBorrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					deleteRow();
				}
			});
			btnBorrar.setIcon(new ImageIcon("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\trash.png"));
			btnBorrar.setBounds(16, 266, 68, 64);
			txtResuelto.add(btnBorrar);
			
			JButton btnMostrar = new JButton("");
			btnMostrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showRow();
				}
			
			
			});
			btnMostrar.setIcon(new ImageIcon("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\buscar.png"));
			btnMostrar.setBounds(115, 266, 74, 64);
			txtResuelto.add(btnMostrar);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(263, 11, 492, 319);
			txtResuelto.add(scrollPane);
			
			JButton btnModificar = new JButton(new ImageIcon("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\modificar.png"));
			btnModificar.setToolTipText("Modificar");
			btnModificar.setBounds(115, 191, 74, 64);
			txtResuelto.add(btnModificar);
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					updateRow();
				}
			});
			
			
			DefaultTableModel model = new DefaultTableModel();
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"N\u00FAmero de cliente", "Nombre", "Direcci\u00F3n", "Tipo de Caso"
				}
			));
		
			scrollPane.setViewportView(table);
			
			
			JButton btnGuardar = new JButton("");
			btnGuardar.setBounds(16, 188, 68, 64);
			txtResuelto.add(btnGuardar);
			btnGuardar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {	
					addRow();
				}
					
					
			});
			btnGuardar.setToolTipText("Guardar");
			btnGuardar.setIcon(new ImageIcon("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\guardar.png"));
			
			JLabel lblNewLabel_8 = new JLabel("Tipo Caso:");
			lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_8.setForeground(Color.WHITE);
			lblNewLabel_8.setBounds(10, 125, 74, 14);
			txtResuelto.add(lblNewLabel_8);
			
			txtTipoCaso = new JTextField();
			txtTipoCaso.setBounds(115, 122, 126, 20);
			txtResuelto.add(txtTipoCaso);
			txtTipoCaso.setColumns(10);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBorder(new LineBorder(new Color(255, 255, 255), 3));
			panel_3.setBounds(89, 0, 765, 98);
			contentPane.add(panel_3);
			panel_3.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\logo1.png"));
			lblNewLabel.setBounds(0, 0, 139, 98);
			panel_3.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("CLIENTES");
			lblNewLabel_1.setBounds(138, 0, 627, 98);
			panel_3.add(lblNewLabel_1);
			lblNewLabel_1.setForeground(Color.BLUE);
			lblNewLabel_1.setBackground(new Color(204, 204, 204));
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setLabelFor(this);

		}
	 private void addRow() {
		 
		 DefaultTableModel model = (DefaultTableModel)table.getModel();
		 
		 model.addRow(new Object [] {Integer.parseInt(txtIdCliente.getText()), txtNombre.getText(), txtDireccion.getText(), txtTipoCaso.getText()});
		 
		 Connection con = null;
			try {
				con = getConnection();
				ps= con.prepareStatement("INSERT INTO clientes(txtIdCliente,txtNombre,txtDireccion,txtTipoCaso) VALUES (?,?,?,?)");
				ps.setInt(1, Integer.parseInt(txtIdCliente.getText()));
				ps.setString(2,txtNombre.getText());
				ps.setString(3, txtDireccion.getText());
				ps.setString(4, txtTipoCaso.getText());
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
				String sql = "DELETE FROM clientes WHERE id_cliente =?";
				con = getConnection();
				ps= con.prepareStatement(sql);
				ps.setInt(1, Integer.parseInt(txtIdCliente.getText()));
				
				ps.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "El cliente ha sido borrado con éxito");
				
				con.close();
				
			} catch(Exception e) {
				System.err.println(e);
			}
		 
	 }
	 private void updateRow() {
		 
	
		 Connection con = null;
			try {
				String sql = "UPDATE clientes SET id_cliente=?, nombre=?, direccion=? tipo_caso=? WHERE id_cliente=?";
				con = getConnection();
				ps= con.prepareStatement(sql);
				ps.setInt(1, Integer.parseInt(txtIdCliente.getText()));
				ps.setString(2,txtNombre.getText());
				ps.setString(3, txtDireccion.getText());
				ps.setString(4, txtTipoCaso.getText());
				ps.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "El cliente ha sido actualizado con éxito");
				
				con.close();
				
			} catch(Exception e) {
				System.err.println(e);
			}
		 
	 }
	 private void showRow() {
		 
		 
		 Connection con = null;
			try {
				con = getConnection();
				String sql = "SELECT * FROM clientes";
				ps = con.prepareStatement(sql);
				rs=ps.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				
				con.close();
				
			} catch(Exception e) {
				System.err.println(e);
			}
		 
		
	 }
}
