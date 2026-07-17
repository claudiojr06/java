package main;

import java.util.Scanner;

public class helloworld {
	public static void main(String[] args) {
		int op;
		int[] x= new int[10];
		float n1=0,n2=0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Escolha o cálculo a ser feito: \n1. Soma\n2 Subtração \n3. Divisão \n4 Multiplicação");
			op=sc.nextInt();
			if(op!=0);{
				System.out.print("Forneça o Primeiro Valor: ");
				n1=sc.nextFloat();
				System.out.print("Forneça o Segundo Valor: ");
				n2 = sc.nextFloat();
			}
			switch(op) {
				case 1:{
					System.out.println("A soma dos valores é: "+(n1+n2));
				}
				case 2:{
					System.out.println("A subtração dos valores é"+(n1-n2));
				}
				case 3:{
					System.out.println("A multiplicação dos valores é"+(n1*n2));
				}
				case 4:{
					System.out.println("A divisão dos valeores é :"+(n1/n2));
				}
				case 0:{break;}
				default:{
					System.out.println("Opção incorreta.");
				}
			}
		}while(op!=0);
		
	}
}
		
		//System.out.println("Digite o numero 1:");
		//x=sc.nextFloat();
		//System.out.println("Digite o numero 2");
		//y=sc.nextFloat();
		//System.out.println("Escolha a Forma de Calcular: 1.Soma 2.Subtração 3.Multiplicação 4.Divisão 0.Sair  :");
		//op=sc.nextInt();
		//
		//}}while
		
		
	

