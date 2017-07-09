import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Sistema {
    DateFormat format = new SimpleDateFormat("dd/MM/yyyy' 'HH:mm");

	public static int qntdAlunos = 0;
	public static int qntdMestrandos = 0;
	public static int qntdDoutorandos = 0;
	public static int qntdProfessores = 0;
	public static int qntdPesquisadores = 0;
	public static int qntdRecursos = 0;
	public static int qntdTotalAlocacoes = 0;

	public static String[] Alunos_nome = new String[0];
	public static String[] Alunos_email = new String[0];
	public static String[] Mestrandos_nome = new String[0];
	public static String[] Mestrandos_email = new String[0];
	public static String[] Doutorandos_nome = new String[0];
	public static String[] Doutorandos_email = new String[0];
	public static String[] Professores_nome = new String[0];
	public static String[] Professores_email = new String[0];
	public static String[] Pesquisadores_nome = new String[0];
	public static String[] Pesquisadores_email = new String[0];

	public static String[] Recursos_nome = new String[0];
	public static Date[][] Recursos_dataInicio = new Date[0][0];
	public static Date[][] Recursos_dataTermino = new Date[0][0];
	public static int[][] Recursos_alocacaoID = new int[0][0];

	public static String[] Alocacao_status = new String[0];
	public static int[] Alocacao_recursoID = new int[0];
	public static int[] Alocacao_recursoIDIdx = new int[0];
	public static int[] Alocacao_responsavelID = new int[0];
	public static String[] Alocacao_responsavelTipo = new String[0];
	public static String[] Alocacao_atividadeTipo = new String[0];
	public static String[] Alocacao_atividadeTitulo = new String[0];
	public static String[] Alocacao_atividadeDescricao = new String[0];
	public static String[] Alocacao_atividadeMaterial = new String[0];
	public static String[] Alocacao_atividadeParticipantesTipo = new String[0];
	public static int[][] Alocacao_atividadeParticipantesID = new int[0][0];

	public void cadastrarAluno(){
		qntdAlunos++;
		Scanner scanner = new Scanner(System.in);

		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\tCadastro de aluno\n");
        System.out.print("-Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        System.out.print("-Digite o e-mail do aluno: ");
        String email = scanner.nextLine();

		String[] alunosPrev = Alunos_nome;
        Alunos_nome = new String[qntdAlunos];
        System.arraycopy(alunosPrev, 0, Alunos_nome, 0, qntdAlunos-1);
        Alunos_nome[qntdAlunos-1] = nome.toUpperCase();
        alunosPrev = Alunos_email;
        Alunos_email = new String[qntdAlunos];
        System.arraycopy(alunosPrev, 0, Alunos_email, 0, qntdAlunos-1);
        Alunos_email[qntdAlunos-1] = email.toLowerCase();
	}

	public void cadastrarMestrando(){
		qntdMestrandos++;
		Scanner scanner = new Scanner(System.in);

		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\tCadastro de mestrando\n");
		System.out.print("-Digite o nome do mestrando: ");
		String nome = scanner.nextLine();
		System.out.print("-Digite o e-mail do mestrando: ");
		String email = scanner.nextLine();

		String[] mestPrev = Mestrandos_nome;
		Mestrandos_nome = new String[qntdMestrandos];
		System.arraycopy(mestPrev, 0, Mestrandos_nome, 0, qntdMestrandos-1);
		Mestrandos_nome[qntdMestrandos-1] = nome.toUpperCase();
        mestPrev = Mestrandos_email;
        Mestrandos_email = new String[qntdMestrandos];
        System.arraycopy(mestPrev, 0, Mestrandos_email, 0, qntdMestrandos-1);
        Mestrandos_email[qntdMestrandos-1] = email.toLowerCase();
	}

	public void cadastrarDoutorando(){
		qntdDoutorandos++;
		Scanner scanner = new Scanner(System.in);

		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\tCadastro de doutorando\n");
		System.out.print("-Digite o nome do doutorando: ");
		String nome = scanner.nextLine();
		System.out.print("-Digite o e-mail do doutorando: ");
		String email = scanner.nextLine();

        String[] doutPrev = Doutorandos_nome;
        Doutorandos_nome = new String[qntdDoutorandos];
        System.arraycopy(doutPrev, 0, Doutorandos_nome, 0, qntdDoutorandos-1);
        Doutorandos_nome[qntdDoutorandos-1] = nome.toUpperCase();
        doutPrev = Doutorandos_email;
        Doutorandos_email = new String[qntdDoutorandos];
        System.arraycopy(doutPrev, 0, Doutorandos_email, 0, qntdDoutorandos-1);
        Doutorandos_email[qntdDoutorandos-1] = email.toLowerCase();
	}

	public void cadastrarProfessor(){
		qntdProfessores++;
		Scanner scanner = new Scanner(System.in);

		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\tCadastro de professor\n");
		System.out.print("-Digite o nome do professor: ");
		String nome = scanner.nextLine();
		System.out.print("-Digite o e-mail do professor: ");
		String email = scanner.nextLine();

		String[] profPrev = Professores_nome;
		Professores_nome = new String[qntdProfessores];
		System.arraycopy(profPrev, 0, Professores_nome, 0, qntdProfessores-1);
		Professores_nome[qntdProfessores-1] = nome.toUpperCase();
		profPrev = Professores_email;
        Professores_email = new String[qntdProfessores];
		System.arraycopy(profPrev, 0, Professores_email, 0, qntdProfessores-1);
        Professores_email[qntdProfessores-1] = email.toLowerCase();
	}

	public void cadastrarPesquisador(){
		qntdPesquisadores++;
		Scanner scanner = new Scanner(System.in);

		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\tCadastro de pesquisador\n");
		System.out.print("-Digite o nome do pesquisador: ");
		String nome = scanner.nextLine();
		System.out.print("-Digite o e-mail do pesquisador: ");
		String email = scanner.nextLine();

		String[] pesqPrev = Pesquisadores_nome;
		Pesquisadores_nome = new String[qntdPesquisadores];
		System.arraycopy(pesqPrev, 0, Pesquisadores_nome, 0, qntdPesquisadores-1);
		Pesquisadores_nome[qntdPesquisadores-1] = nome.toUpperCase();
		pesqPrev = Pesquisadores_email;
        Pesquisadores_email = new String[qntdPesquisadores];
		System.arraycopy(pesqPrev, 0, Pesquisadores_email, 0, qntdPesquisadores-1);
        Pesquisadores_email[qntdPesquisadores-1] = email.toLowerCase();
	}

	public void alocarRecurso() throws ParseException {
	    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\tAlocação de recurso\n");
		Scanner scanner = new Scanner(System.in);
		qntdTotalAlocacoes++;

        String[] prevAlocStr = Alocacao_status;
        Alocacao_status = new String[qntdTotalAlocacoes];
        System.arraycopy(prevAlocStr, 0, Alocacao_status, 0, qntdTotalAlocacoes-1);
        Alocacao_status[qntdTotalAlocacoes-1] = "Em processo de alocação";

        boolean alocacao;
        int recursoID, responsavelID = -1;
        String responsavelTipo = "";
        Date dataInicio, dataTermino;
		do{
            System.out.print("-Digite a data de inicio (dd/MM/yyyy HH:mm): ");
            String line = scanner.nextLine();
            dataInicio = format.parse(line);
            System.out.print("-Digite a data de término (dd/MM/yyyy HH:mm): ");
            line = scanner.nextLine();
            dataTermino = format.parse(line);

            alocacao = false;
		    System.out.print("-Digite o ID do recurso: ");
			recursoID = scanner.nextInt();
			scanner.nextLine();

			if(recursoID >= qntdRecursos){
			    System.out.println("Recurso inexistente!");
			    alocacao = true;
            }
            if(!alocacao) {
                int qntdAlocacoes = Recursos_dataInicio[recursoID].length;
                for (int i = 0; i < qntdAlocacoes; i++) {
                    if ((Recursos_dataInicio[recursoID][i].before(dataInicio) && Recursos_dataTermino[recursoID][i].after(dataInicio))
                    || (Recursos_dataInicio[recursoID][i].before(dataTermino) && Recursos_dataTermino[recursoID][i].after(dataTermino))) {
                        System.out.println("Recurso indisponivel\n");
                        alocacao = true;
                    }
                }
            }

            if(!alocacao) {
                System.out.print("-Digite o ID do responsavel pelo recurso: ");
                responsavelID = scanner.nextInt();
                scanner.nextLine();
                System.out.print("-Digite a classificação do responsavel pelo recurso: ");
                responsavelTipo = scanner.nextLine();

                switch (responsavelTipo.toLowerCase()) {
                    case "professor":
                        if (responsavelID >= qntdProfessores) {
                            System.out.println("Professor inexistente!");
                            alocacao = true;
                        }
                        break;
                    case "mestrando":
                        if (responsavelID >= qntdMestrandos) {
                            System.out.println("Mestrando inexistente!");
                            alocacao = true;
                        }
                        break;
                    case "doutorando":
                        if (responsavelID >= qntdDoutorandos) {
                            System.out.println("Doutorando inexistente!");
                            alocacao = true;
                        }
                        break;
                    default:
                        System.out.println(responsavelTipo + " não tem autorização para alocar recurso.");
                        alocacao = true;
                }

                if (!alocacao) {
                    for (int i = 0; i < qntdTotalAlocacoes - 1; i++) {
                        if (Alocacao_responsavelID[i] == responsavelID && Alocacao_responsavelTipo[i].equals(responsavelTipo.toUpperCase())) {
                            if (Alocacao_status[i].equals("Alocado")) {
                                int qntdAlocacoes = Recursos_dataInicio[Alocacao_recursoID[i]].length;
                                for (int j = 0; j < qntdAlocacoes; j++) {

                                    if ((Recursos_dataInicio[Alocacao_recursoID[i]][j].before(dataInicio) && Recursos_dataTermino[Alocacao_recursoID[i]][j].after(dataInicio))
                                    || (Recursos_dataInicio[Alocacao_recursoID[i]][j].before(dataTermino) && Recursos_dataTermino[Alocacao_recursoID[i]][j].after(dataTermino))) {
                                        System.out.println("Esta pessoa já alocou um recurso neste mesmo horário!");
                                        alocacao = true;
                                    }
                                }
                            } else if (Alocacao_status[i].equals("Em progresso")) {
                                System.out.println("Esta pessoa já alocou um recurso e está em progresso!");
                                alocacao = true;
                            }
                        }
                    }
                }
            }
		}while(alocacao);
		int[] prevAloc = Alocacao_recursoID;
		Alocacao_recursoID = new int[qntdTotalAlocacoes];
		System.arraycopy(prevAloc, 0, Alocacao_recursoID, 0, qntdTotalAlocacoes-1);
		Alocacao_recursoID[qntdTotalAlocacoes-1] = recursoID;

		int qntdAlocacoesNova = Recursos_dataInicio[recursoID].length+1;
		prevAloc = Alocacao_recursoIDIdx;
		Alocacao_recursoIDIdx = new int[qntdTotalAlocacoes];
		System.arraycopy(prevAloc, 0, Alocacao_recursoIDIdx, 0, qntdTotalAlocacoes-1);
		Alocacao_recursoIDIdx[qntdTotalAlocacoes-1] = qntdAlocacoesNova-1;

		prevAloc = Recursos_alocacaoID[recursoID];
		Recursos_alocacaoID[recursoID] = new int[qntdAlocacoesNova];
		System.arraycopy(prevAloc, 0, Recursos_alocacaoID[recursoID], 0, qntdAlocacoesNova-1);
        Recursos_alocacaoID[recursoID][qntdAlocacoesNova-1] = qntdTotalAlocacoes-1;

        Date[] prevAlocDate = Recursos_dataInicio[recursoID];
        Recursos_dataInicio[recursoID] = new Date[qntdAlocacoesNova];
        System.arraycopy(prevAlocDate, 0, Recursos_dataInicio[recursoID], 0, qntdAlocacoesNova-1);
        Recursos_dataInicio[recursoID][qntdAlocacoesNova-1] = dataInicio;

        prevAlocDate = Recursos_dataTermino[recursoID];
        Recursos_dataTermino[recursoID] = new Date[qntdAlocacoesNova];
        System.arraycopy(prevAlocDate, 0, Recursos_dataTermino[recursoID], 0, qntdAlocacoesNova-1);
        Recursos_dataTermino[recursoID][qntdAlocacoesNova-1] = dataTermino;

        prevAloc = Alocacao_responsavelID;
        Alocacao_responsavelID = new int[qntdTotalAlocacoes];
        System.arraycopy(prevAloc, 0, Alocacao_responsavelID, 0, qntdTotalAlocacoes-1);
		Alocacao_responsavelID[qntdTotalAlocacoes-1] = responsavelID;
        prevAlocStr = Alocacao_responsavelTipo;
        Alocacao_responsavelTipo = new String[qntdTotalAlocacoes];
        System.arraycopy(prevAlocStr, 0, Alocacao_responsavelTipo, 0, qntdTotalAlocacoes-1);
		Alocacao_responsavelTipo[qntdTotalAlocacoes-1] = responsavelTipo.toUpperCase();

		String str;
		do {
		    alocacao = true;
            System.out.print("-Digite o tipo de atividade: ");
            str = scanner.nextLine();
            switch (str.toLowerCase()){
                case "apresentações":
                    alocacao = false;
                    break;
                case "aula tradicional":
                case "laboratório":
                    if(responsavelTipo.toUpperCase().equals("PROFESSOR"))
                        alocacao = false;
                    else
                        System.out.println("'"+ responsavelTipo.toUpperCase() +"' não tem autorização para alocar esse recurso!");
                    break;
                default:
                    System.out.println("'"+ str +"' não é uma atividade válida! As atividades podem ser: 'Aula tradicional', 'Apresentações' ou 'Laboratório'.");
                    break;
            }
        }while (alocacao);
        prevAlocStr = Alocacao_atividadeTipo;
        Alocacao_atividadeTipo = new String[qntdTotalAlocacoes];
        System.arraycopy(prevAlocStr, 0, Alocacao_atividadeTipo, 0, qntdTotalAlocacoes - 1);
        Alocacao_atividadeTipo[qntdTotalAlocacoes - 1] = str;

		System.out.print("-Digite o titulo de atividade: ");
        str = scanner.nextLine();
        prevAlocStr = Alocacao_atividadeTitulo;
        Alocacao_atividadeTitulo = new String[qntdTotalAlocacoes];
        System.arraycopy(prevAlocStr, 0, Alocacao_atividadeTitulo, 0, qntdTotalAlocacoes-1);
        Alocacao_atividadeTitulo[qntdTotalAlocacoes-1] = str;
		System.out.print("-Digite a descrição da atividade: ");
        str = scanner.nextLine();
        prevAlocStr = Alocacao_atividadeDescricao;
        Alocacao_atividadeDescricao = new String[qntdTotalAlocacoes];
        System.arraycopy(prevAlocStr, 0, Alocacao_atividadeDescricao, 0, qntdTotalAlocacoes-1);
        Alocacao_atividadeDescricao[qntdTotalAlocacoes-1] = str;
        System.out.print("-Diga qual o material de apoio: ");
        prevAlocStr = Alocacao_atividadeMaterial;
        Alocacao_atividadeMaterial = new String[qntdTotalAlocacoes];
        System.arraycopy(prevAlocStr, 0, Alocacao_atividadeMaterial, 0, qntdTotalAlocacoes-1);
        Alocacao_atividadeMaterial[qntdTotalAlocacoes-1] = scanner.nextLine();

		boolean registrando = true;
		do {
            System.out.print("-Digite o tipo de participantes: ");
            String tipo = scanner.nextLine();
            if(tipo.toLowerCase().equals("aluno") || tipo.equals("mestrando") || tipo.equals("doutorando")){
                registrando = false;
                prevAlocStr = Alocacao_atividadeParticipantesTipo;
                Alocacao_atividadeParticipantesTipo = new String[qntdTotalAlocacoes];
                System.arraycopy(prevAlocStr, 0, Alocacao_atividadeParticipantesTipo, 0, qntdTotalAlocacoes-1);
                Alocacao_atividadeParticipantesTipo[qntdTotalAlocacoes-1] = tipo.toUpperCase();
            }
            else{
                System.out.println("Tipo inválido de participantes! Participantes podem ser: 'Aluno', 'Mestrando' ou 'Doutorando'.");
            }
        }while (registrando);

		System.out.print("-Digite a quantidade de participantes: ");
		int qntdParticipantes = scanner.nextInt();
		scanner.nextLine();
        int[][] prevAlocIntMat = Alocacao_atividadeParticipantesID;
        Alocacao_atividadeParticipantesID = new int[qntdTotalAlocacoes][];
        System.arraycopy(prevAlocIntMat, 0, Alocacao_atividadeParticipantesID, 0, qntdTotalAlocacoes - 1);
        Alocacao_atividadeParticipantesID[qntdTotalAlocacoes-1] = new int[qntdParticipantes];
		for(int i = 0; i < qntdParticipantes; i++){
		    do {
                registrando = false;
                System.out.print("-Digite o ID do participante " + i + ": ");
                int id = scanner.nextInt();
                scanner.nextLine();
                switch (Alocacao_atividadeParticipantesTipo[qntdTotalAlocacoes - 1].toLowerCase()) {
                    case "aluno":
                        if (id >= Alunos_nome.length) {
                            System.out.println("Aluno não existente!");
                            registrando = true;
                        }
                        break;
                    case "mestrando":
                        if (id >= Mestrandos_nome.length) {
                            System.out.println("Mestrando não existente!");
                            registrando = true;
                        }
                        break;
                    case "doutorando":
                        if (id >= Doutorandos_nome.length) {
                            System.out.println("Doutorando não existente!");
                            registrando = true;
                        }
                        break;
                }
                if(!registrando) {
                    Alocacao_atividadeParticipantesID[qntdTotalAlocacoes - 1][i] = id;
                }
            }while(registrando);
		}

		Alocacao_status[qntdTotalAlocacoes-1] = "Alocado";
	}

	public void editarRecurso(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\tEditar alocação\n");
        System.out.println("• Lista de alocações não concluídas:\n");
        System.out.println("___________________________________________________________________________________");
        System.out.println(" ID |    Data    |       Status       |    Recurso    |  Responsável  |   Atividade");
        for(int i = 0; i < qntdTotalAlocacoes; i++){
            if(!Alocacao_status[i].equals("Concluido")) {
                int id = Alocacao_recursoID[i], idx = Alocacao_recursoIDIdx[i], responsavelID = Alocacao_responsavelID[i];
                System.out.printf(" %02d | %s | %s | %s | %s | %s\n", i, format.format(Recursos_dataInicio[id][idx]), Alocacao_status[i], Recursos_nome[id], (Alocacao_responsavelTipo[i].toLowerCase().equals("professor") ? Professores_nome[responsavelID] : (Alocacao_responsavelTipo[i].toLowerCase().equals("mestrando") ? Mestrandos_nome[responsavelID] : Doutorandos_nome[responsavelID])), Alocacao_atividadeTitulo[i]);
            }
        }
        System.out.println("-----------------------------------------------------------------------------------");

        boolean editando = true;
        do{
            System.out.print("\n-Digite o ID da alocação a ser atualizada ou digite -1 para sair: ");
            int sel = scanner.nextInt();
            scanner.nextLine();
            if(sel == -1) {
                editando = false;
            } else if(sel >= qntdTotalAlocacoes){
                System.out.println("ID inválido!");
            } else if(Alocacao_status[sel].equals("Concluido")){
                System.out.println("A alocação selecionada já se encontra concluída!");
            } else{
                System.out.print("-Você deseja atualizar o status de '"+ Alocacao_atividadeTitulo[sel] +"' para '"+ (Alocacao_status[sel].equals("Alocado") ? "Em andamento" : "Concluido") +"'? (sim / nao)\n> ");
                String str = scanner.nextLine();
                if(str.toLowerCase().charAt(0) == 's'){
                    Alocacao_status[sel] = Alocacao_status[sel].equals("Alocado") ? "Em andamento" : "Concluido";
                    editando = false;
                } else{
                    System.out.println("Edição cancelada!");
                }
            }
        }while(editando);
    }

    public void detalhesAlocacoes(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\tVer alocações\n");
        System.out.println("• Lista detalhada de todas as alocações já feitas:\n");
        for(int i = 0; i < qntdTotalAlocacoes; i++){
            System.out.println("-------------------------");
            System.out.printf("ID: %d\n", i);
            System.out.printf("Status: %s\n", Alocacao_status[i]);
            int recursoID = Alocacao_recursoID[i], recursoIdx = Alocacao_recursoIDIdx[i];
            System.out.printf("Recurso: %s\n", Recursos_nome[recursoID]);
            System.out.printf("Data - Inicio: %s\n", format.format(Recursos_dataInicio[recursoID][recursoIdx]));
            System.out.printf("Data - Término: %s\n", format.format(Recursos_dataTermino[recursoID][recursoIdx]));
            System.out.printf("Atividade - Tipo: %s\n", Alocacao_atividadeTipo[i]);
            System.out.printf("Atividade - Título: %s\n", Alocacao_atividadeTitulo[i]);
            System.out.printf("Atividade - Descrição: %s\n", Alocacao_atividadeDescricao[i]);
            String respTipo = Alocacao_responsavelTipo[i];
            System.out.printf("Responsável: %s - %s\n", respTipo, (respTipo.equals("PROFESSOR") ? Professores_nome[Alocacao_responsavelID[i]] : (respTipo.equals("MESTRANDO")) ? Mestrandos_nome[Alocacao_responsavelID[i]] : Doutorandos_nome[Alocacao_responsavelID[i]]));
            System.out.printf("Participantes - Tipo: %s\n", Alocacao_atividadeParticipantesTipo[i]);
            System.out.printf("Participantes: ");
            boolean primeiro = true;
            for(int partID : Alocacao_atividadeParticipantesID[i]){
                String partTipo = Alocacao_atividadeParticipantesTipo[i].toLowerCase();
                if(!primeiro){
                    System.out.print("; ");
                }
                switch (partTipo) {
                    case "aluno":
                        System.out.printf("%s", Alunos_nome[partID]);
                        break;
                    case "mestrando":
                        System.out.printf("%s", Mestrandos_nome[partID]);
                        break;
                    case "doutorando":
                        System.out.printf("%s", Doutorandos_nome[partID]);
                        break;
                }
                primeiro = false;
            }
            System.out.println();
        }
        System.out.print("\nAperte ENTER para sair.");
        scanner.nextLine();
    }

    public void consultarUsuario(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\tConsultar usuário\n");
        int ID = -1;
        String usuNome, usuTipo;
        do {
            System.out.print("- Digite o nome do usuário: ");
            usuNome = scanner.nextLine();
            System.out.print("- Digite o tipo de usuário: ");
            usuTipo = scanner.nextLine();
            switch (usuTipo.toLowerCase()) {
                case "aluno":
                    for (int i = 0; i < Alunos_nome.length; i++){
                        if(Alunos_nome[i].equals(usuNome.toUpperCase())){
                            ID = i;
                        }
                    }
                    break;
                case "mestrando":
                    for (int i = 0; i < Mestrandos_nome.length; i++){
                        if(Mestrandos_nome[i].equals(usuNome.toUpperCase())){
                            ID = i;
                        }
                    }
                    break;
                case "doutorando":
                    for (int i = 0; i < Doutorandos_nome.length; i++){
                        if(Doutorandos_nome[i].equals(usuNome.toUpperCase())){
                            ID = i;
                        }
                    }
                    break;
                case "professor":
                    for (int i = 0; i < Professores_nome.length; i++){
                        if(Professores_nome[i].equals(usuNome.toUpperCase())){
                            ID = i;
                        }
                    }
                    break;
                case "pesquisador":
                    for (int i = 0; i < Pesquisadores_nome.length; i++){
                        if(Pesquisadores_nome[i].equals(usuNome.toUpperCase())){
                            ID = i;
                        }
                    }
                    break;
                default:
                    System.out.println("Tipo de usuário inválido!");
                    break;
            }
            if(ID == -1){
                System.out.println("Usuário não encontrado!");
            }
        }while(ID == -1);

        System.out.println("--------------------");
        System.out.printf("ID: %d\n", ID);
        System.out.printf("Nome: %s\n", usuNome.toUpperCase());
        String usuEmail = "";
        switch (usuTipo.toLowerCase()){
            case "aluno": usuEmail = Alunos_email[ID];
                break;
            case "mestrando": usuEmail = Mestrandos_email[ID];
                break;
            case "doutorando": usuEmail = Doutorandos_email[ID];
                break;
            case "professor": usuEmail = Professores_email[ID];
                break;
            case "pesquisador": usuEmail = Pesquisadores_email[ID];
                break;
        }
        System.out.printf("E-mail: %s\n", usuEmail);
        System.out.print("Recursos alocados: ");
        int[] recursos = new int[qntdRecursos];
        for(int i = 0; i < qntdTotalAlocacoes; i++){
            if(Alocacao_responsavelID[i] == ID && Alocacao_responsavelTipo[i].toLowerCase().equals(usuTipo.toLowerCase())){
                recursos[Alocacao_recursoID[i]] = 1;
            }
        }
        boolean primeiro = true;
        for(int i = 0; i < qntdRecursos; i++){
            if(recursos[i] == 1){
                if(!primeiro){
                    System.out.println("; ");
                }
                System.out.printf("%s", Recursos_nome[i]);
                primeiro = false;
            }
        }
        System.out.println("\nAtividades realizadas: ");
        for(int i = 0; i < qntdTotalAlocacoes; i++){
            if(Alocacao_responsavelID[i] == ID && Alocacao_responsavelTipo[i].toLowerCase().equals(usuTipo.toLowerCase())){
                System.out.printf("\t• %s - %s - %s\n", Alocacao_atividadeTipo[i], Alocacao_atividadeTitulo[i], Alocacao_atividadeDescricao[i]);
            }
        }
        System.out.println("--------------------");
        System.out.print("\nPressione ENTER para sair.");
        scanner.nextLine();
    }

    public void consultarRecurso(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\tConsultar recurso\n");
        int ID = -1;
        String recNome;
        do{
            System.out.println("-Digite o nome do recurso: ");
            recNome = scanner.nextLine();
            for(int i = 0; i < qntdRecursos; i++){
                if(Recursos_nome[i].equals(recNome.toLowerCase())){
                    ID = i;
                }
            }
            if(ID == -1){
                System.out.println("Recurso inexistente!");
            }
        }while (ID == -1);

        System.out.println("--------------------");
        System.out.printf("ID: %d\n", ID);
        System.out.printf("Nome: %s\n", Recursos_nome[ID]);
        for(int i = 0; i < qntdTotalAlocacoes; i++){
            if(Alocacao_recursoID[i] == ID){
                System.out.println("\t------------------------------");
                System.out.printf("\t• Atividade - Tipo: %s\n", Alocacao_atividadeTipo[i]);
                System.out.printf("\t• Atividade - Título: %s\n", Alocacao_atividadeTitulo[i]);
                System.out.printf("\t• Atividade - Descrição: %s\n", Alocacao_atividadeDescricao[i]);
                System.out.printf("\t• Atividade - Material de apoio: %s\n", Alocacao_atividadeMaterial[i]);
                System.out.printf("\t• Alocação - Status: %s\n", Alocacao_status[i]);
                System.out.printf("\t• Alocação - Data início: %s\n", format.format(Recursos_dataInicio[Alocacao_recursoID[i]][Alocacao_recursoIDIdx[i]]));
                System.out.printf("\t• Alocação - Data término: %s\n", format.format(Recursos_dataTermino[Alocacao_recursoID[i]][Alocacao_recursoIDIdx[i]]));
                System.out.printf("\t• Alocação - Responsável: %s - %s\n", Alocacao_responsavelTipo[i], (Alocacao_responsavelTipo[i].equals("PROFESSOR") ? Professores_nome[Alocacao_responsavelID[i]] : (Alocacao_responsavelTipo[i].equals("MESTRANDO") ? Mestrandos_nome[Alocacao_responsavelID[i]] : Doutorandos_nome[Alocacao_responsavelID[i]])));
                System.out.printf("\t• Participantes - Tipo: %s\n", Alocacao_atividadeParticipantesTipo[i]);
                System.out.print("\t• Participantes: ");
                for(int j = 0; j < Alocacao_atividadeParticipantesID[i].length; j++){
                    if(j != 0){
                        System.out.print("; ");
                    }
                    switch (Alocacao_atividadeParticipantesTipo[i].toLowerCase()){
                        case "aluno":
                            System.out.printf("%s", Alunos_nome[Alocacao_atividadeParticipantesID[i][j]]);
                            break;
                        case "mestrando":
                            System.out.printf("%s", Mestrandos_nome[Alocacao_atividadeParticipantesID[i][j]]);
                            break;
                        case "doutorando":
                            System.out.printf("%s", Doutorandos_nome[Alocacao_atividadeParticipantesID[i][j]]);
                            break;
                    }
                }
            }
            System.out.println("\n");
        }
        System.out.println("--------------------");
        System.out.println("\nAperte ENTER para sair.");
        scanner.nextLine();
    }

    public void relatorio(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\tRelatório da unidade acadêmica\n");

        System.out.println("--------------------");
        System.out.printf("• Número de usuários cadastrados: %d\n", qntdAlunos + qntdMestrandos + qntdDoutorandos + qntdProfessores + qntdPesquisadores);
        System.out.println("• Recursos:");
        int procAloc = 0, alocado = 0, andamento = 0, concluido = 0;
        for (String status : Alocacao_status) {
            switch (status.toLowerCase()) {
                case "em processo de alocação":
                    procAloc++;
                    break;
                case "alocado":
                    alocado++;
                    break;
                case "em andamento":
                    andamento++;
                    break;
                case "concluido":
                    concluido++;
                    break;
            }
        }
        System.out.printf("\t- Em processo de alocação: %d\n", procAloc);
        System.out.printf("\t- Alocados: %d\n", alocado);
        System.out.printf("\t- Em andamento: %d\n", andamento);
        System.out.printf("\t- Concluídos: %d\n", concluido);
        System.out.printf("• Número total de alocações: %d\n", qntdTotalAlocacoes);
        System.out.println("• Atividades:");
        int tradicional = 0, apresentacao = 0, laboratorio = 0;
        for (String tipo : Alocacao_atividadeTipo) {
            switch (tipo.toLowerCase()) {
                case "aula tradicional":
                    tradicional++;
                    break;
                case "apresentações":
                    apresentacao++;
                    break;
                case "laboratório":
                    laboratorio++;
                    break;
            }
        }
        System.out.printf("\t- Aula tradicional: %d\n", tradicional);
        System.out.printf("\t- Apresentações: %d\n", apresentacao);
        System.out.printf("\t- Laboratório: %d\n", laboratorio);
        System.out.println("--------------------");
        System.out.print("\nAperte ENTER para sair.");
        scanner.nextLine();
    }

	public static void main(String[] args) throws ParseException {
		Sistema sis = new Sistema();
		Scanner scanner = new Scanner(System.in);

		System.out.print("-Digite a quantidade de recursos disponiveis: ");
		qntdRecursos = scanner.nextInt();
		scanner.nextLine();

		Recursos_nome = new String[qntdRecursos];
		for(int i = 0; i < qntdRecursos; i++){
			System.out.print("Nome do recurso: ");
			Recursos_nome[i] = scanner.nextLine().toLowerCase();
		}
		Recursos_dataInicio = new Date[qntdRecursos][0];
		Recursos_dataTermino = new Date[qntdRecursos][0];
        Recursos_alocacaoID = new int[qntdRecursos][0];

		boolean running = true;

		while(running){
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("\tBem-vindo ao sistema do IC!\n");
            System.out.println("_________________________");
            System.out.println("|    MENU PRINCIPAL:    |");
            System.out.println(" -----------------------");
            System.out.println("1. Cadastrar aluno");
			System.out.println("2. Cadastrar mestrando");
			System.out.println("3. Cadastrar doutorando");
			System.out.println("4. Cadastrar professor");
			System.out.println("5. Cadastrar pesquisador");
			System.out.println("6. Alocar recurso");
			System.out.println("7. Editar alocação");
			System.out.println("8. Ver alocações");
			System.out.println("9. Consultar usuário");
			System.out.println("10. Consultar recurso");
			System.out.println("11. Relatório da unidade");
			System.out.println("12. Sair");

			System.out.print("-Digite o numero da opção desejada:\n> ");

			int sel = scanner.nextInt();
			scanner.nextLine();
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
                case 6: sis.alocarRecurso();
                    break;
                case 7: sis.editarRecurso();
                    break;
                case 8: sis.detalhesAlocacoes();
                    break;
                case 9: sis.consultarUsuario();
                    break;
                case 10: sis.consultarRecurso();
                    break;
                case 11: sis.relatorio();
                    break;
                case 12: running = false;
					break;
			}
		}
	}
}