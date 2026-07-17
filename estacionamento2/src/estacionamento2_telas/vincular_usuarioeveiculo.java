package estacionamento2_telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import codigo.bd;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class vincular_usuarioeveiculo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vincular_usuarioeveiculo frame = new vincular_usuarioeveiculo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public vincular_usuarioeveiculo() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JComboBox usuario = new JComboBox();
		usuario.setBounds(84, 11, 272, 22);
		contentPane.add(usuario);
		ResultSet rs=bd.select_usuario();
		while(rs.next()) {
			usuario.addItem(rs.getString("cpf"));
		}
		
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(10, 15, 64, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox placa = new JComboBox();
		placa.setBounds(84, 80, 272, 22);
		contentPane.add(placa);
		ResultSet rs2=bd.select_veiculo();
		while(rs2.next()) {
			placa.addItem(rs2.getString("placa"));
		}
		
		
		JLabel lblNewLabel_1 = new JLabel("Placa:");
		lblNewLabel_1.setBounds(10, 88, 64, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton vincular = new JButton("Vincular");
		vincular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indice_u=usuario.getSelectedIndex(), indice_v=placa.getSelectedIndex();
				try {
					ResultSet rs = bd.select_usuario();
					for(int i=0;i<=indice_u;i++)
						rs.next();
					int id_usuario =rs.getInt("id");
					 rs = bd.select_veiculo();
					 while(rs.next()) {
						 while(rs2.next()) {
							 if(rs.getString("placa").equals(rs2.getString("placa"))
									 && rs2.getInt("ativo")==1) { 
							 }}
						
					 }
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		vincular.setBounds(170, 178, 89, 23);
		contentPane.add(vincular);

	}
}
