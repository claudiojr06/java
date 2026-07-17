package main;

import java.util.Scanner;

public class Exercicio {
 public static void main(String[] args) {
	 int op,x=0,dia=0,um=0,dois=0,tres=0,y;
	 int[]data=new int[7], qlivros = new int[4];
	 int[]livro=new int[7];
	 String[]nome= new String[7];
	 Scanner sc = new Scanner(System.in);
	 qlivros[0]=0;
	 qlivros[1]=0;
	 qlivros[2]=0;
	 qlivros[3]=0;
	 do {
	 System.out.println("Escolha a Opção: \n1. Emprestimo de Livro \n2. Listar quantidade que cada livro vendeu no dia: \n3.Livro Mais Emprestado \n4.Nomes que alugaram livro\n0. Sair \nOpção:");
	 op=sc.nextInt();
	 switch(op) {
	 			case 1:{
	 				System.out.println("Selecione o dia da semana  \n1.Domingo \n2.Segunda \n3.Terça \n4. Quarta \n5.Quinta \n6.Sexta \n7. Sabado:");
	 				data[dia]=sc.nextInt();
	 				System.out.println("Nome:");
	 				nome[dia]=sc.next();
	 				System.out.println("Escolha seu Livro: \n1.livro 1  \n2.livro 2 \n3.livro 3 ");
	 				livro[dia]=sc.nextInt();
	 				qlivros[livro[dia]]++;
	 				dia++;
	 				break;
 				}
	 			case 2:{
	 				System.out.println("Escolha um dia da semana  \n1.Domingo \n2.Segunda \n3.Terça \n4. Quarta \n5.Quinta \n6.Sexta \n7. Sabado:");
	 				y=sc.nextInt();
	 					for(x=0;x<dia;x++) {
	 						if(data[x]==y) {
	 							System.out.println(livro[x]);
	 					
	 						}
	 					}
	 				break;
	 			}
	 			case 3:{
	 				if(qlivros[1] >= qlivros[2] && qlivros[1] >= qlivros[3])
	 				System.out.println("O livro mais emprestado foi o livro 1");
	 				else if (qlivros[2] >= qlivros[1] && qlivros[2] >= qlivros[3])
	 					System.out.println("O livro mais emprestado foi o livro 2");
	 				else
	 					System.out.println("O livro mais emprestado foi o livro 3");
	 				break;
	 			}
	 			case 4:{for(x=0;x<dia;x++) {
	 				System.out.println("Nomes:"+nome[x]);	 			
	 			}	 				
	 				break;
	 			}
	 				 
	 			case 0:{System.out.println("Lista Finalizada!");break;
	 			}
	 
	 			default:{
	 				System.out.println("Opção Invalida!");
	 			}
	 }
	 }while(op!=0);
	 }	 
 }

