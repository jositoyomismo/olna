package casos;

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
import net.proteanit.sql.DbUtils;
import principal.MenuPrincipal;

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

public class Casos extends JFrame {
	
	
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
	public JTextField txtIdCaso;
	private JTextField txtTipoCaso;
	private JTextField txtResult;
	private JTable table;

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

	 public Casos() {
			
	        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\josit\\eclipse-workspace\\olna\\src\\Imagenes\\logo.png"));
			setTitle("INTRANET OLNADETECTIVES");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 819, 410);
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
			panel.setBounds(0, 0, 88, 381);
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
			txtResuelto.setBounds(89, 96, 729, 285);
			contentPane.add(txtResuelto);
			txtResuelto.setLayout(null);
			
			JButton btnModificar = new JButton(new ImageIcon("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\modificar.png"));
			btnModificar.setToolTipText("Modificar");
			btnModificar.setBounds(115, 115, 74, 64);
			txtResuelto.add(btnModificar);
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					updateRow();
				}
			});
			
			
			JLabel lblNewLabel_5 = new JLabel("N\u00BA de caso:");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_5.setForeground(Color.WHITE);
			lblNewLabel_5.setBounds(10, 11, 116, 14);
			txtResuelto.add(lblNewLabel_5);
			
			txtIdCaso = new JTextField();
			txtIdCaso.setBounds(115, 11, 126, 20);
			txtResuelto.add(txtIdCaso);
			txtIdCaso.setColumns(10);
			
			JLabel lblNewLabel_6 = new JLabel("Tipo de caso:");
			lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_6.setForeground(Color.WHITE);
			lblNewLabel_6.setBounds(10, 50, 74, 14);
			txtResuelto.add(lblNewLabel_6);
			
			JLabel lblNewLabel_7 = new JLabel("Resuelto");
			lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_7.setForeground(Color.WHITE);
			lblNewLabel_7.setBounds(10, 87, 95, 14);
			txtResuelto.add(lblNewLabel_7);
			
			
			txtTipoCaso = new JTextField();
			txtTipoCaso.setBounds(115, 47, 126, 20);
			txtResuelto.add(txtTipoCaso);
			txtTipoCaso.setColumns(10);
			
			txtResult = new JTextField();
			txtResult.setBounds(115, 84, 126, 20);
			txtResuelto.add(txtResult);
			txtResult.setColumns(10);
		
			
			JButton btnNewButton_1 = new JButton("");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					deleteRow();
				}
			});
			btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\trash.png"));
			btnNewButton_1.setBounds(10, 197, 68, 64);
			txtResuelto.add(btnNewButton_1);
			
			JButton btnNewButton_2 = new JButton("");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showRow();
				}
			
			
			});
			btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\buscar.png"));
			btnNewButton_2.setBounds(115, 197, 74, 64);
			txtResuelto.add(btnNewButton_2);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(263, 11, 456, 252);
			txtResuelto.add(scrollPane);
			
			DefaultTableModel model = new DefaultTableModel();
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Número de caso","Tipo de Caso", "Resultado"
				}
			));
		
			scrollPane.setViewportView(table);
			
			
			JButton btnGuardar = new JButton("");
			btnGuardar.setBounds(10, 112, 68, 64);
			txtResuelto.add(btnGuardar);
			btnGuardar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {	
					addRow();
				}
					
					
			});
			btnGuardar.setToolTipText("Guardar");
			btnGuardar.setIcon(new ImageIcon("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\guardar.png"));
			
			JPanel panel_3 = new JPanel();
			panel_3.setBorder(new LineBorder(new Color(255, 255, 255), 3));
			panel_3.setBounds(89, 0, 724, 98);
			contentPane.add(panel_3);
			panel_3.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\josit\\Desktop\\workspaceSpring\\Olna\\src\\Imagenes\\logo1.png"));
			lblNewLabel.setBounds(0, 0, 139, 98);
			panel_3.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("CASOS");
			lblNewLabel_1.setBounds(142, 0, 582, 98);
			panel_3.add(lblNewLabel_1);
			lblNewLabel_1.setForeground(Color.BLUE);
			lblNewLabel_1.setBackground(new Color(204, 204, 204));
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setLabelFor(this);

		}
	 private void addRow() {
		 
		 DefaultTableModel model = (DefaultTableModel)table.getModel();
		 
		 model.addRow(new Object [] {Integer.parseInt(txtIdCaso.getText()), txtTipoCaso.getText(), txtResult.getText()});
		 
		 Connection con = null;
			try {
				con = getConnection();
				ps= con.prepareStatement("INSERT INTO caso(id_caso,tipo_caso,resuelto) VALUES (?,?,?)");
				ps.setInt(1, Integer.parseInt(txtIdCaso.getText()));
				ps.setString(2,txtTipoCaso.getText());
				ps.setString(3, txtResult.getText());
				ps.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "El caso ha sido insertado con éxito");
				
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
				String sql = "DELETE FROM caso WHERE id_caso =?";
				con = getConnection();
				ps= con.prepareStatement(sql);
				ps.setInt(1, Integer.parseInt(txtIdCaso.getText()));
				
				ps.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "El caso ha sido borrado con éxito");
				
				con.close();
				
			} catch(Exception e) {
				System.err.println(e);
			}
		 
	 }
	 private void updateRow() {

		 
		 Connection con = null;
			try {
				String sql = "UPDATE caso SET tipo_caso=?, resuelto=? WHERE id_caso=?";
				con = getConnection();
				ps= con.prepareStatement(sql);
				ps.setInt(1, Integer.parseInt(txtIdCaso.getText()));
				ps.setString(2,txtTipoCaso.getText());
				ps.setString(3, txtResult.getText());
				ps.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "El caso ha sido actualizado con éxito");
				
				con.close();
				
			} catch(Exception e) {
				System.err.println(e);
			}
		 
	 }
	 private void showRow() {
		 
		 
		 Connection con = null;
			try {
				con = getConnection();
				String sql = "SELECT * FROM caso";
				ps = con.prepareStatement(sql);
				rs=ps.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				
				con.close();
				
			} catch(Exception e) {
				System.err.println(e);
			}
		 
		
	 }
	 
}
	


	


