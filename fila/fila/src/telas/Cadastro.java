package telas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import codigos.consumo;
import codigos.controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class Cadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nome;
	private JTextField idade;
	private JTextField grau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
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
	public Cadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroPaciente = new JLabel("CADASTRO PACIENTE");
		lblCadastroPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroPaciente.setBounds(0, 11, 414, 14);
		contentPane.add(lblCadastroPaciente);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(28, 75, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblIdade = new JLabel("IDADE:");
		lblIdade.setBounds(28, 112, 46, 14);
		contentPane.add(lblIdade);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(28, 159, 46, 14);
		contentPane.add(lblCpf);
		
		MaskFormatter cp = null;
		try {
			cp=new MaskFormatter("###.###.###-##");
		} catch(ParseException e1) {
			e1.printStackTrace();
		}
		
		JFormattedTextField cpf = new JFormattedTextField(cp);
		cpf.setBounds(140, 156, 220, 20);
		contentPane.add(cpf);
		
		JLabel lblGrauDeUrgencia = new JLabel("Grau de Urgencia:");
		lblGrauDeUrgencia.setBounds(28, 194, 87, 14);
		contentPane.add(lblGrauDeUrgencia);
		
		nome = new JTextField();
		nome.setBounds(140, 72, 220, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		idade = new JTextField();
		idade.setBounds(140, 109, 220, 20);
		contentPane.add(idade);
		idade.setColumns(10);
		
		grau = new JTextField();
		grau.setBounds(140, 191, 220, 20);
		contentPane.add(grau);
		grau.setColumns(10);
		
		JButton btnNewButton = new JButton("SAIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(268, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton cadastrar = new JButton("CADASTRAR");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!controller.validaNome(nome.getText())) {
		            return;
		        }

		        if (!controller.validaidade(idade.getText())) {
		            return;
		        }
		        
		        if(!controller.validacpf(cpf.getText())) {
		        	return;
		        }
		       
		        
		        if(!controller.validaGrau(grau.getText())) {
		        	return;
		        }
		        try {

		            if (controller.cpfExiste(cpf.getText())) {
		                return;
		            }

		        } catch (Exception e1) {
		            e1.printStackTrace();
		            return;
		        };

		        try {

		            consumo.cadastrar_paciente(
		                    nome.getText(),
		                    Integer.parseInt(idade.getText()),
		                    cpf.getText(),
		                    grau.getText());

		            JOptionPane.showMessageDialog(null,
		                    "Cadastro realizado com sucesso.");

		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		});
		cadastrar.setBounds(121, 227, 108, 23);
		contentPane.add(cadastrar);
		
	

	}
}


















//if ( Integer.parseInt(idade.getText().toString()) < 1 
//		|| Integer.parseInt(idade.getText().toString()) > 123) {
//		JOptionPane.showMessageDialog(null, "Idade Invalida");
//		
//	}
//
//	
//		if (!nome.getText().toString().isEmpty() && !cpf.getText().toString().isEmpty())
//				{
//			try {
//				consumo.cadastrar_paciente(nome.getText(),Integer.parseInt(idade.getText().toString()),cpf.getText(),grau.getText());
//				
//				JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso");
//			} catch (Exception e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			
//				}
//		 
//		
		
				

		
	
