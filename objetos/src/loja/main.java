package loja;
import java.util.Scanner;

public class main {
	
	public static void main(String[] args) {
		int op,codigo,i=0, quantidade,compra,qtd=0;
		float preco;
		String nome;
		Produtos[] p = new Produtos[100];
		Scanner sc=new Scanner (System.in);
		do {
		System.out.println("1. Cadastrar Produto");
		System.out.println("2. Estoque");
		System.out.println("3. Realizar Venda");
		System.out.println("4. Realizar Compra");
		System.out.println("0. Sair");
		System.out.print("Opção: ");
		op=sc.nextInt();
		switch(op) {
		case 1:{
			System.out.println("Forneça o Nome do Produto: ");
			nome= sc.next();
			System.out.println("Forneça o Preço do Produto: ");
			preco= sc.nextFloat();
			System.out.println("Forneça o Código do Produto: ");
			codigo = sc.nextInt();
			p[i]= new Produtos (nome,preco,codigo);
			i++;
			break;}
		case 2:{
			for(int contador =0;contador<i;contador++) {
				p[contador].imprimir();
			  

			}
			break;}
		case 3:{
			System.out.println("Informe o Código do Produto: ");
			codigo=sc.nextInt();
			for(int contador=0;contador<i;contador++) {
				if(p[contador].codigo==codigo) {
					System.out.println("Informe a quantidade: ");
					quantidade=sc.nextInt();
					if(p[contador].quantidade>=quantidade) {
					  p[contador].quantidade-=quantidade;
					  System.out.println("Valor total: R$"+
					  (quantidade*p[contador].preco));
					}
					
				}
			}
			break;}
		case 4:{
			System.out.println("Informe o Codigo do Produto Comprado: ");
			compra=sc.nextInt();
			for(int contador=0;contador<i;contador++) {
				System.out.println("Informe a quantidade Comprada: ");
				qtd=sc.nextInt();
				p[contador].quantidade+=qtd;
				
				
			}
			break;}
		case 0:{break;}
		default:{System.out.println("Opção Invalida.");}
		}
		}while(op!=0);
	}

}
