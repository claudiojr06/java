package loja;

public class Produtos {
	String nome;
	float preco;
	int codigo,quantidade=0;
	
	public Produtos(String n ,float p, int c) {
		nome = n;
		preco=p;
		codigo=c;
		
	}
	public void imprimir() {
		System.out.println("Código: "+codigo);
		System.out.println("Nome: "+nome);
		System.out.println("Preço: R$"+preco);
		System.out.println("Quantidade em Estoque: "+quantidade);
		System.out.println("____________________________________");
		
	}

}
