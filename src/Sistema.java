import java.util.*;

public class Sistema {
	public static int qntdAlunos = 0;
	public static int qntdMestrandos = 0;
	public static int qntdDoutorandos = 0;
	public static int qntdProfessores = 0;
	public static int qntdPesquisadores = 0;
	public static int qntdRecursos = 0;
	public static int qntdTotalAlocacoes = 0;

	public static String[] Alunos_nome = new String[0];
	public static String[] Mestrandos_nome = new String[0];
	public static String[] Doutorandos_nome = new String[0];
	public static String[] Professores_nome = new String[0];
	public static String[] Pesquisadores_nome = new String[0];
	public static String Admin_nome = "";

	public static String[] Recursos_nome = new String[0];
	public static String[] Recursos_statusAlocacao = new String[0];

	public static String[] Alocacao_status;
	public static int[] Alocacao_dataInicioDia;
	public static int[] Alocacao_dataInicioMes;
	public static int[] Alocacao_dataInicioAno;
	public static int[] Alocacao_dataTerminoDia;
	public static int[] Alocacao_dataTerminoMes;
	public static int[] Alocacao_dataTerminoAno;
	public static int[] Alocacao_responsavelID;
	public static int[] Alocacao_recursoID;
	public static String[] Alocacao_responsavelTipo = new String[0];
	public static String[] Alocacao_atividadeID = new String[0];

	public static String[] Alocacao_atividadeTipo;
	public static String[] Alocacao_atividadeTitulo;
	public static String[] Alocacao_atividadeDescricao;
	public static String[] Alocacao_atividadeParticipantesTipo;
	public static int[][] Alocacao_atividadeParticipantesID;

	public void cadastrarAluno(){
		Scanner scanner = new Scanner(System.in);

		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\tCadastro de aluno\n");
		System.out.print("Digite o nome do aluno: ");
		String nome = scanner.nextLine();

		this.qntdAlunos++;
		String[] nomesPrev = this.Alunos_nome;

		this.Alunos_nome = new String[this.qntdAlunos];
		System.arraycopy(nomesPrev, 0, this.Alunos_nome, 0, this.qntdAlunos-1);
		this.Alunos_nome[this.qntdAlunos-1] = nome;
	}

	public void cadastrarMestrando(){
		Scanner scanner = new Scanner(System.in);

		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\tCadastro de mestrando\n");
		System.out.print("Digite o nome do mestrando: ");
		String nome = scanner.nextLine();

		this.qntdMestrandos++;
		String[] nomesPrev = this.Mestrandos_nome;

		this.Mestrandos_nome = new String[this.qntdMestrandos];
		System.arraycopy(nomesPrev, 0, this.Mestrandos_nome, 0, this.qntdMestrandos-1);
		this.Mestrandos_nome[this.qntdMestrandos-1] = nome;
	}

	public void cadastrarDoutorando(){
		Scanner scanner = new Scanner(System.in);

		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\tCadastro de doutorando\n");
		System.out.print("Digite o nome do doutorando: ");
		String nome = scanner.nextLine();

		this.qntdDoutorandos++;
		String[] nomesPrev = this.Doutorandos_nome;

		this.Doutorandos_nome = new String[this.qntdDoutorandos];
		System.arraycopy(nomesPrev, 0, this.Doutorandos_nome, 0, this.qntdDoutorandos-1);
		this.Doutorandos_nome[this.qntdDoutorandos-1] = nome;
	}

	public void cadastrarProfessor(){
		Scanner scanner = new Scanner(System.in);

		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\tCadastro de professor\n");
		System.out.print("Digite o nome do professor: ");
		String nome = scanner.nextLine();

		this.qntdProfessores++;
		String[] nomesPrev = this.Professores_nome;

		this.Professores_nome = new String[this.qntdProfessores];
		System.arraycopy(nomesPrev, 0, this.Professores_nome, 0, this.qntdProfessores-1);
		this.Professores_nome[this.qntdProfessores-1] = nome;
	}

	public void cadastrarPesquisador(){
		Scanner scanner = new Scanner(System.in);

		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\tCadastro de pesquisador\n");
		System.out.print("Digite o nome do pesquisador: ");
		String nome = scanner.nextLine();

		this.qntdPesquisadores++;
		String[] nomesPrev = this.Pesquisadores_nome;

		this.Pesquisadores_nome = new String[this.qntdPesquisadores];
		System.arraycopy(nomesPrev, 0, this.Pesquisadores_nome, 0, this.qntdPesquisadores-1);
		this.Pesquisadores_nome[this.qntdPesquisadores-1] = nome;
	}

	public void alocarRecurso(){
		Scanner scanner = new Scanner(System.in);
		this.qntdTotalAlocacoes++;

		String[] prevAlocacoes = this.Recursos_statusAlocacao;
		this.Recursos_statusAlocacao = new String[this.qntdTotalAlocacoes];

		System.arraycopy(prevAlocacoes, 0, this.Recursos_statusAlocacao, 0, this.qntdTotalAlocacoes-1);
		this.Alocacao_status[this.qntdTotalAlocacoes-1] = "Em processo de alocação";

		System.out.print("Insira o dia do inicio: ");
		this.Alocacao_dataInicioDia[this.qntdTotalAlocacoes-1] = scanner.nextInt();
		System.out.print("Insira o mês do inicio: ");
		this.Alocacao_dataInicioMes[this.qntdTotalAlocacoes-1] = scanner.nextInt();
		System.out.print("Insira o ano do inicio: ");
		this.Alocacao_dataInicioAno[this.qntdTotalAlocacoes-1] = scanner.nextInt();

		System.out.print("Insira o dia do termino: ");
		this.Alocacao_dataTerminoDia[this.qntdTotalAlocacoes-1] = scanner.nextInt();
		System.out.print("Insira o mês do termino: ");
		this.Alocacao_dataTerminoMes[this.qntdTotalAlocacoes-1] = scanner.nextInt();
		System.out.print("Insira o ano do termino: ");
		this.Alocacao_dataTerminoAno[this.qntdTotalAlocacoes-1] = scanner.nextInt();

		do{
		System.out.print("Insira o ID do recurso: ");
			int recursoID = scanner.nextInt();
			if(this.Recursos_statusAlocacao[recursoID].equals("Disponivel"))
				break;
			else
				System.out.println("Recurso indisponivel\n");
		}while(true);

		System.out.print("Digite o ID do responsavel pelo recurso: ");
		this.Alocacao_responsavelID[this.qntdTotalAlocacoes-1] = scanner.nextInt();
		System.out.print("Digite a classificação do responsavel pelo recurso: ");
		this.Alocacao_responsavelTipo[this.qntdTotalAlocacoes-1] = scanner.nextLine();
		System.out.print("Digite a classificação do responsavel pelo recurso: ");
		this.Alocacao_responsavelTipo[this.qntdTotalAlocacoes-1] = scanner.nextLine();

		System.out.print("Digite o tipo de atividade: ");
		this.Alocacao_atividadeTipo[this.qntdTotalAlocacoes-1] = scanner.nextLine();
		System.out.print("Digite o titulo de atividade: ");
		this.Alocacao_atividadeTitulo[this.qntdTotalAlocacoes-1] = scanner.nextLine();
		System.out.print("Digite a descrição da atividade: ");
		this.Alocacao_atividadeDescricao[this.qntdTotalAlocacoes-1] = scanner.nextLine();
		System.out.print("Digite o tipo de participantes: ");
		this.Alocacao_atividadeParticipantesTipo[this.qntdTotalAlocacoes-1] = scanner.nextLine();
		System.out.print("Digite a quantidade de participantes: ");
		int qntdParticipantes = scanner.nextInt();
		for(int i = 0; i < qntdParticipantes; i++){
			this.Alocacao_atividadeParticipantesID[this.qntdTotalAlocacoes-1][i] = scanner.nextInt();
		}


		this.Alocacao_status[this.qntdTotalAlocacoes-1] = "Alocado";
	}

	public static void main(String[] args){
		Sistema sis = new Sistema();
		Scanner scanner = new Scanner(System.in);

		System.out.print("Digite a quantidade de recursos disponiveis: ");
		sis.qntdRecursos = scanner.nextInt();
		sis.Recursos_nome = new String[sis.qntdRecursos];
		sis.Recursos_statusAlocacao = new String[sis.qntdRecursos];
		for(int i = 0; i < sis.qntdRecursos; i++){
			System.out.print("Nome do recurso: ");
			scanner.nextLine();
			sis.Recursos_nome[i] = scanner.nextLine();
			sis.Recursos_statusAlocacao[i] = "Disponivel";
		}

		boolean running = true;

		while(running){
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("\tBem-vindo ao sistema do IC!\n\n");
			System.out.println("-Digite o numero da opção desejada:");
			System.out.println("1. Cadastrar aluno");
			System.out.println("2. Cadastrar mestrando");
			System.out.println("3. Cadastrar doutorando");
			System.out.println("4. Cadastrar professor");
			System.out.println("5. Cadastrar pesquisador");
			System.out.println("6. Alocar recurso");
			System.out.println("7. Editar alocação");
			System.out.println("8. Ver alocações");
			System.out.println("9. Sair");

			System.out.print("\n> ");

			int sel = scanner.nextInt();
			switch(sel){
				case 1: sis.cadastrarAluno();
					break;
				case 2: sis.cadastrarMestrando();
					break;
				case 3: sis.cadastrarDoutorando();
					break;
				case 4: sis.cadastrarProfessor();
					break;
				case 5: sis.cadastrarPesquisador();
					break;
				default: running = false;
					break;
			}

			for(String al : sis.Alunos_nome){
				System.out.println(al);
			}
		}
	}
}
