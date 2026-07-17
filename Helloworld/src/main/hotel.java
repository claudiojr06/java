package main;

import java.util.Scanner;

public class hotel {
	public static void main(String[] args) {
		float valorDiaria = 120,faturamento=0;
		int[] numQuarto= new int[50];
		String[] nome= new String[50];
		int[] qtdDiarias = new int[50];
		int op, indice=0, aux=0,maior=0,totalUtilizacao=0;
		int[] utilizacao = new int[50];
		Scanner sc = new Scanner(System.in);
		for(indice=0;indice<50;indice++) {
			numQuarto[indice]=404;
			utilizacao[indice]=0;
		}
		do{
			System.out.println("1. Checkin");
			System.out.println("2. Relatório");
			System.out.println("0. SAIR");
			System.out.println("Opção: ");
			op = sc.nextInt();
			switch(op) {
			case 1:{
				System.out.print("Informar o numero do quarto: ");
				aux=sc.nextInt();
				if(aux<=49&&aux>0)
				if(numQuarto[aux]==404) {
					System.out.print("Forneça o nome do Hóspede: ");
					nome[aux]=sc.next();
					System.out.print("Forneça o numero de diarias: ");
					qtdDiarias[aux] = sc.nextInt();
					numQuarto[aux] = 1;
					utilizacao[aux]++;
					if(utilizacao[aux]>maior) {
						maior=utilizacao[aux];
					}
					System.out.println("Valor total: R$"+(qtdDiarias[aux]*valorDiaria));
					faturamento+=(qtdDiarias[aux]*valorDiaria);
					totalUtilizacao++;
				}
				else {
					System.out.println("Quarto esta ocupado ");
					System.out.println("Quartos livres: ");
					for(indice=0;indice<50;indice++) {
						if(numQuarto[indice]==404) {
							System.out.print(indice+" ");
						}
					
					}
				}else {
					System.out.println("Numero incorreto");
					}
					break;
			}
			case 2:{
				System.out.println("1. Buscar por Quarto");
				System.out.println("2. Taxa Média de Ocupação");
				System.out.println("3.Quarto mais utilizado");
				System.out.print("Opção 4. Faturamento total ");
				System.out.print("Opção: ");
				aux = sc.nextInt();
				switch(aux) {
				case 1:{
					int op2;
					System.out.println("1. Buscar por Quarto");
					System.out.println("2. Buscar por Hóspede");
					op2=sc.nextInt();
					switch(op2) {
					case 1:{
						System.out.println("Forneça o número do quarto:");
						indice=sc.nextInt();
						if(indice>=0 && indice<50) {
							if(numQuarto[indice]!= 404) {
						System.out.println("Hóspede: "+nome[indice]);
						System.out.println("Valor Total: R$"+(qtdDiarias[indice]*valorDiaria));
						}else {
							System.out.println("Quarto vago.");
							}
						}
						break;
						}
					case 2:{String n;
					System.out.println("Forneça o nome do Hospede: ");
					n=sc.next();
					for(indice=0;indice<50;indice++);{
						if(n.equals(nome[indice])) {
							System.out.println("O hospede está no quarto" +indice);
							break;
						}
					}
					if(indice==50)
						break;
						}
					default:{System.out.println("Opção Invalida");}
					}
					break;
					}
				case 2:{
					System.out.println("A taxa média de ocupação é: "+((totalUtilizacao/50)*100)+"%");
					break;
				}
				case 3:{
					for(indice=0;indice<50;indice++);{
						if(utilizacao[indice]==maior) {
							System.out.println("O quarto" + indice+"foi o mais utilizado");
						}
					}
					
					break;
				}
				case 4:{
					System.out.println("Faturamento Total: R$"+faturamento);
					break
					;}
				default:{System.out.println("Opção Incorreta.");}
				}
				break;
				}
			
			case 0:{
				break;}
			}
		}while(op!=0);
		

		}
}
