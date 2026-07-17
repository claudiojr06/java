package codigo;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import banco_telas.Conta;
import banco_telas.Operacao;

public class controller {

	static Conta[] contas = new Conta[100];
	static Operacao[] opp = new Operacao[1000];
	static int indice = 0;

	public static boolean cadUse(String nome, int numero) {

		if (nome.length() > 0 && numero > 0) {

			for (int i = 0; i < 100; i++) {
				if (contas[i] != null && contas[i].numero == numero) {
					JOptionPane.showMessageDialog(null, "Número de conta já existe!");
					return false;
				}
			}

			for (int i = 0; i < 100; i++) {
				if (contas[i] == null) {

					contas[i] = new Conta();
					contas[i].nome = nome;
					contas[i].numero = numero;
					contas[i].valor = 0;

					JOptionPane.showMessageDialog(null, "Conta cadastrada com sucesso!!");

					return true;
				}
			}

			JOptionPane.showMessageDialog(null, "Limite de contas atingido!");

		} else {
			JOptionPane.showMessageDialog(null, "Dados inválidos!");
		}
		return false;
	}

	public static void mov(int numcont, float quant, boolean oque) {

		for (int z = 0; z < 100; z++) {
			if (contas[z] != null)
				if (contas[z].numero == numcont) {
					if (oque == true && quant > 0) {
						contas[z].valor += quant;
						opp[indice] = new Operacao();
						opp[indice].conta = numcont;
						opp[indice].valor = quant;
						opp[indice].totald += quant;
						opp[indice].op = "CREDITO";
						indice++;
						break;
					} else {
						if (contas[z].valor >= quant && quant > 0) {
							contas[z].valor -= quant;
							opp[indice] = new Operacao();
							opp[indice].conta = numcont;
							opp[indice].valor = quant;
							opp[indice].totals += quant;
							opp[indice].op = "DEBITO";
							indice++;
							break;
						}

					}
					if (quant < 0 && contas[z].valor >= quant) {
						JOptionPane.showMessageDialog(null, "Valor insuficiente");
					}
				}

		}

	}

	public static void List(JComboBox box) {
		box.addItem("");
		for (int x = 0; x < 100; x++) {
			if (contas[x] != null) {
				System.out.print(contas[x].nome);

				box.addItem(contas[x].numero);
			}

		}

	}

	public static void LL(JComboBox box, JTextField nome, JTextField valor) {
		for (int x = 0; x < 100; x++) {
			if (contas[x] != null)
				if (contas[x].numero == Integer.parseInt(box.getSelectedItem().toString())) {
					nome.setText(contas[x].nome);
					valor.setText("" + contas[x].valor);
				}

		}

	}

	public static void Lmov(JComboBox box, JTextField nome, JTextField valor, JTextField saque, JTextField depo) {
		int s = 0, d = 0;
		for (int x = 0; x < 100; x++) {
			if (contas[x] != null)
				if (contas[x].numero == Integer.parseInt(box.getSelectedItem().toString())) {
					System.out.println(indice);
					for (int a = 0; a < indice; a++) {
						if (opp[a].conta == contas[x].numero) {
							if (opp[a].op.equals("CREDITO")) {
								System.out.println(opp[a].totald);
								d += opp[a].totald;
							} else {
								s += opp[a].totals;
							}
							nome.setText("" + contas[x].nome);
							valor.setText("" + contas[x].valor);
							saque.setText("" + s);
							depo.setText("" + d);
						}

					}
				}

		}

	}
}
