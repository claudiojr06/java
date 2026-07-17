package governo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

//import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;

public class buscar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nome;
	public static void addcadastro()throws SQLException {
		ResultSet rs=bd_gov.select_cadastro();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					buscar frame = new buscar();
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
	public buscar() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox bus_cpf = new JComboBox();
		bus_cpf.setToolTipText("CPF");
		bus_cpf.setBounds(399, 227, 25, 22);
		contentPane.add(bus_cpf);
		ResultSet rs=bd_gov.select_cadastro();
		while(rs.next()) {
			bus_cpf.addItem(rs.getString("cpf"));}
	
	bus_cpf.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int indice = bus_cpf.getSelectedIndex();
			System.out.println(indice);
			try {
				ResultSet rs = bd_gov.select_cadastro();
				for(int i =0;i<=indice;i++) {
					rs.next();
				}
				nome.setText(rs.getString("nome"));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
});
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setBounds(44, 11, 46, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(44, 113, 46, 22);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("SAIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(256, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		nome = new JTextField();
		nome.setEditable(false);
		nome.setBounds(126, 114, 185, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		MaskFormatter mask=null;
		try {
			mask=new MaskFormatter("###.###.###-##");
			mask.setPlaceholderCharacter('_');
		} catch(ParseException e1) {
			e1.printStackTrace();
		}
		
		JFormattedTextField cpf = new JFormattedTextField(mask);
		cpf.setBounds(126, 12, 185, 20);
		contentPane.add(cpf);
		
		JButton buscar = new JButton("Buscar");
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ResultSet rs= bd_gov.select_cadastro(cpf.getText());
					while(rs.next()) {
						nome.setText(rs.getString("nome"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		buscar.setBounds(321, 11, 89, 23);
		contentPane.add(buscar);
		
		JButton deletar = new JButton("DELETAR");
		deletar.setBounds(91, 227, 89, 23);
		contentPane.add(deletar);
		
		

	}
	}
	
