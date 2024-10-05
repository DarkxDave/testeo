package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class GUI {

	private JFrame frame;
	private final JLabel lblHospital = new JLabel("Registro Enfermeras");
	private JTextField txtNombre;
	private JTextField txtTurno;
	private JTable table;
	private Connection con1;
	private PreparedStatement insert;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
		refrescoTabla();
	}


	private void refrescoTabla() {
		int c;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con1 = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");
			insert = con1.prepareStatement("select * from enfermeras");
			ResultSet rs = insert.executeQuery();
			ResultSetMetaData Rss = rs.getMetaData();
			c = Rss.getColumnCount();
			
			DefaultTableModel Df = (DefaultTableModel)table.getModel();
			Df.setRowCount(0);
			while(rs.next()) {
				Vector v2 = new Vector();
				for(int i=1; i<=c; i++) {
					v2.add(rs.getString("id"));
					v2.add(rs.getString("nombre"));
					v2.add(rs.getString("turno"));
				}
				Df.addRow(v2);
				
			}

		} 
		catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Hospital");
		frame.setBounds(100, 100, 854, 290);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		lblHospital.setFont(new Font("Segoe UI Black", Font.BOLD, 24));
		lblHospital.setBounds(278, 11, 303, 31);
		frame.getContentPane().add(lblHospital);
		lblHospital.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Registro", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel.setBounds(10, 53, 309, 190);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNombre.setBounds(10, 45, 66, 16);
		panel.add(lblNombre);
		
		JLabel lblTurno = new JLabel("Turno");
		lblTurno.setHorizontalAlignment(SwingConstants.LEFT);
		lblTurno.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblTurno.setBounds(10, 83, 66, 16);
		panel.add(lblTurno);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(76, 44, 221, 20);
		panel.add(txtNombre);
		
		txtTurno = new JTextField();
		txtTurno.setColumns(10);
		txtTurno.setBounds(76, 82, 221, 20);
		panel.add(txtTurno);
		
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNombre.getText();
				String turno = txtTurno.getText();
				
				 
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con1 = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");
					insert = con1.prepareStatement("insert into enfermeras(nombre, turno)values(?,?)");
					insert.setString(1, nombre);
					insert.setString(2, turno);
					
					insert.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Enfermera agregada");
					refrescoTabla();
					
					txtNombre.setText("");
					txtTurno.setText("");
					txtNombre.requestFocus();
				} 
				catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				
				catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		btnAgregar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnAgregar.setBounds(10, 154, 89, 23);
		panel.add(btnAgregar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel Df = (DefaultTableModel)table.getModel();
				int indiceSeleccionado = table.getSelectedRow();
				
				try {
					int id = Integer.parseInt((String) Df.getValueAt(indiceSeleccionado, 0));
					
					int dialogResult = JOptionPane.showConfirmDialog(null, "¿Quieres borrar a la enfermera?", "Advertencia", JOptionPane.YES_NO_OPTION);
					
					if(dialogResult == JOptionPane.YES_OPTION) {
						Class.forName("com.mysql.jdbc.Driver");
						con1 = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");
						insert = con1.prepareStatement("delete from enfermeras where id = ?");
				
						insert.setInt(1, id);
						
						insert.executeUpdate();
						
						JOptionPane.showMessageDialog(null, "Enfermera borrada");
						refrescoTabla();
						
						txtNombre.setText("");
						txtTurno.setText("");
						txtNombre.requestFocus();
					}

					
				} 
				catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				
				catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnBorrar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnBorrar.setBounds(208, 154, 89, 23);
		panel.add(btnBorrar);
		
		
		table = new JTable();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel Df = (DefaultTableModel)table.getModel();
				int indiceSeleccionado = table.getSelectedRow();
				
				txtNombre.setText(Df.getValueAt(indiceSeleccionado, 1).toString());
				txtTurno.setText(Df.getValueAt(indiceSeleccionado, 2).toString());
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel Df = (DefaultTableModel)table.getModel();
				int indiceSeleccionado = table.getSelectedRow();
				
				try {
					int id = Integer.parseInt((String) Df.getValueAt(indiceSeleccionado, 0));
					String nombre = txtNombre.getText();
					String turno = txtTurno.getText();
					Class.forName("com.mysql.jdbc.Driver");
					con1 = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");
					insert = con1.prepareStatement("update enfermeras set nombre = ?, turno = ? where id = ?");
					insert.setString(1, nombre);
					insert.setString(2, turno);
					insert.setInt(3, id);
					
					insert.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Enfermera editada");
					refrescoTabla();
					
					txtNombre.setText("");
					txtTurno.setText("");
					txtNombre.requestFocus();
				} 
				catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				
				catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEditar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnEditar.setBounds(109, 154, 89, 23);
		panel.add(btnEditar);
		
		
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "Nombre", "Turno"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		table.setBounds(335, 67, 493, 176);
		frame.getContentPane().add(table);
		
		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNombre_1.setBounds(498, 51, 66, 16);
		frame.getContentPane().add(lblNombre_1);
		
		JLabel lblTurno_1 = new JLabel("Turno");
		lblTurno_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblTurno_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblTurno_1.setBounds(664, 51, 66, 16);
		frame.getContentPane().add(lblTurno_1);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		lblId.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblId.setBounds(337, 53, 66, 16);
		frame.getContentPane().add(lblId);
	}
}
