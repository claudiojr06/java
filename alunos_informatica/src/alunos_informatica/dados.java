package alunos_informatica;

public class dados {
	static aluno[] a = new aluno[100];
	static int indice=0;
	
	public static void cadastrar(String n,int c) {
		a[indice]=new aluno(n,c);
		System.out.println(indice);
		indice++;

	}
	public static aluno buscar_cpf(int cpf) {
		for(int i=0;i<indice;i++) {
			if(cpf==a[i].cpf) {
				return a[i];
			}
		}
		aluno al =null;
		al.nome="";
		al.cpf=0;
		return al;
	}
}
