package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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

public class listar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nome;
	private JTextField idade;
	private JTextField grau;
	private JTextField id;
	private JTextField entrada;
	private JTextField atendido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					listar frame = new listar();
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
	public listar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastroPaciente = new JLabel("LISTAR PACIENTE");
		lblCadastroPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroPaciente.setBounds(20, 11, 414, 14);
		contentPane.add(lblCadastroPaciente);

		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(20, 95, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblIdade = new JLabel("IDADE:");
		lblIdade.setBounds(208, 67, 46, 14);
		contentPane.add(lblIdade);

		idade = new JTextField();
		idade.setEditable(false);
		idade.setColumns(10);
		idade.setBounds(266, 67, 72, 20);
		contentPane.add(idade);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(30, 39, 46, 14);
		contentPane.add(lblCpf);

		MaskFormatter cp = null;
		try {
			cp = new MaskFormatter("###.###.###-##");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		JFormattedTextField cpf = new JFormattedTextField(cp);
		cpf.setBounds(122, 36, 174, 20);
		contentPane.add(cpf);

		nome = new JTextField();
		nome.setEditable(false);
		nome.setColumns(10);
		nome.setBounds(127, 92, 154, 20);
		contentPane.add(nome);

		JLabel lblGrauDeUrgencia = new JLabel("Urgencia:");
		lblGrauDeUrgencia.setBounds(20, 123, 98, 14);
		contentPane.add(lblGrauDeUrgencia);

		grau = new JTextField();
		grau.setEditable(false);
		grau.setColumns(10);
		grau.setBounds(127, 123, 169, 20);
		contentPane.add(grau);

		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(20, 61, 46, 14);
		contentPane.add(lblId);

		id = new JTextField();
		id.setEditable(false);
		id.setColumns(10);
		id.setBounds(127, 61, 56, 20);
		contentPane.add(id);

		JLabel lblHorarioDaChegada = new JLabel("Horario da Entrada:");
		lblHorarioDaChegada.setBounds(20, 151, 109, 14);
		contentPane.add(lblHorarioDaChegada);

		entrada = new JTextField();
		entrada.setEditable(false);
		entrada.setColumns(10);
		entrada.setBounds(127, 148, 179, 20);
		contentPane.add(entrada);

		JLabel lblAtendido = new JLabel("Atendido:");
		lblAtendido.setBounds(20, 186, 109, 14);
		contentPane.add(lblAtendido);

		atendido = new JTextField();
		atendido.setEditable(false);
		atendido.setColumns(10);
		atendido.setBounds(127, 176, 169, 20);
		contentPane.add(atendido);

		JButton Sair = new JButton("Sair");
		Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		Sair.setBounds(165, 227, 89, 23);
		contentPane.add(Sair);

		JButton buscar = new JButton("Buscar");
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!controller.validacpf(cpf.getText())) {
					return;
				}

				JSONArray array;
				try {
					array = codigos.consumo.buscar_paciente();
					int i = 0;
					for (i = 0; i < array.size(); i++) {

						JSONObject obj = (JSONObject) array.get(i);
						if (obj.get("cpf").toString().equals(cpf.getText().toString())) {
							id.setText((String) obj.get("id").toString());
							nome.setText(obj.get("nome").toString());
							idade.setText((String) obj.get("idade").toString());
							cpf.setText("");
							grau.setText((String) obj.get("grauUrgencia").toString());
							entrada.setText((String) obj.get("horarioChegada").toString());
							atendido.setText((String) obj.get("atendido").toString());
							break;
						}

					}

					if (i == array.size()) {

						cpf.setText("");
						nome.setText("");
						id.setText("");
						idade.setText("");
						nome.setText("");
						grau.setText("");
						entrada.setText("");
						atendido.setText("");
						JOptionPane.showMessageDialog(null, "Paciente não encontrado");

					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		buscar.setBounds(306, 32, 87, 23);
		contentPane.add(buscar);

	}
}
