package estacionamento2_telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu();
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
	public menu() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 486, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton cad_usuario = new JButton("Cadastrar Usuario");
		cad_usuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cad_usuario cad_user = new cad_usuario();
				cad_user.setVisible(true);
			}
		});
		cad_usuario.setBounds(47, 69, 186, 23);
		contentPane.add(cad_usuario);
		
		JButton cad_veiculo = new JButton("Cadastrar Veiculo");
		cad_veiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cad_veiculo cad_v = new cad_veiculo();
				cad_v.setVisible(true);
			}
		});
		cad_veiculo.setBounds(261, 69, 176, 23);
		contentPane.add(cad_veiculo);
		
		JButton vin_usuario = new JButton("Vincular Usuario a Veiculo");
		vin_usuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vincular_usuarioeveiculo vin_user = null;
				try {
					vin_user = new vincular_usuarioeveiculo();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				vin_user.setVisible(true);
			}
		});
		vin_usuario.setBounds(47, 121, 186, 23);
		contentPane.add(vin_usuario);
		
		JButton lis_veiculo = new JButton("Listar todos os Veículos");
		lis_veiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lis_veiculos lis_v = null;
				try {
					lis_v = new lis_veiculos();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				lis_v.setVisible(true);
			}
		});
		lis_veiculo.setBounds(261, 121, 176, 23);
		contentPane.add(lis_veiculo);
		
		JButton lis_usuario = new JButton("Listar todos Usuarios");
		lis_usuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lis_usuario lis_u = null;
				try {
					lis_u = new lis_usuario();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				lis_u.setVisible(true);
			}
		});
		lis_usuario.setBounds(47, 170, 186, 23);
		contentPane.add(lis_usuario);
		
		JButton lis_veiculodousuario = new JButton("Listar Veiculos do Usuario");
		lis_veiculodousuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Listar_veiculosdousuario lis_v = null;
				try {
					lis_v = new Listar_veiculosdousuario();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				lis_v.setVisible(true);
			}
		});
		lis_veiculodousuario.setBounds(251, 170, 186, 23);
		contentPane.add(lis_veiculodousuario);
		
		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		sair.setBounds(170, 227, 89, 23);
		contentPane.add(sair);
		
		JLabel lblNewLabel = new JLabel("MENU");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 47);
		contentPane.add(lblNewLabel);

	}
}
