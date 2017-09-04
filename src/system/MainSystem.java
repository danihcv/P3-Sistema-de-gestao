package system;

import alocation.AlocationState;
import alocation.InProgressConcreteState;
import com.sun.org.apache.xpath.internal.SourceTree;
import resource.*;
import user.*;
import work.Work;
import work.WorkTypes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MainSystem {
    private DateFormat format = new SimpleDateFormat("dd/MM/yyyy' 'HH:mm");

    private ResourcePrototype prototypeProjector = new ProjectorConcretePrototype();
    private ResourcePrototype prototypeLab = new LabConcretePrototype();
    private ResourcePrototype prototypeClass = new ClassRoomConcretePrototype();
    private ResourcePrototype prototypeAuditorium = new AuditoriumConcretePrototype();

    private List<UserStrategy> users = new LinkedList<>();
    private List<AlocationState> alocations = new LinkedList<>();
    private List<ResourcePrototype> resources = new LinkedList<>();

    public MainSystem() {
    }

    public void menu() {
        boolean running = true;

        while (running) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
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
            switch (sel) {
                case 1:
                    this.cadastrarUser("ALUNO");
                    break;
            case 2: this.cadastrarUser("MESTRANDO");
                break;
            case 3: this.cadastrarUser("DOUTORANDO");
                break;
            case 4: this.cadastrarUser("PROFESSOR");
                break;
            case 5: this.cadastrarUser("PESQUISADOR");
                break;
            case 6: this.alocarRecurso();
                break;
                /*
            case 7: this.editarRecurso();
                break;
            case 8: this.detalhesAlocacoes();
                break;
                */
            case 9: this.consultarUser();
                break;
                /*
            case 10: this.consultarRecurso();
                break;
            case 11: this.relatorio();
                break;
                */
                case 12:
                    running = false;
                    break;

            }
        }
    }

    private void alocarRecurso() {
        System.out.println("\n\n\n\n\n\n\n\n\n\nAlocar Recurso\n");

        AlocationState newAlocation = new InProgressConcreteState();
        Scanner scan = new Scanner(System.in);
        String cpf;

        UserStrategy responsible = null;
        do {
            System.out.print("-Digite o CPF do responsável pelo recurso: ");
            cpf = scan.nextLine();

            if (cpf.equals("-1"))
                return;

            for (UserStrategy user : this.users) {
                if (user.getCpf().equals(cpf)) {
                    if (user.canAlocateResource())
                        responsible = user;
                    else {
                        System.out.println(">> Este usuário não pode alocar recurso!");
                    }
                }
            }
            if (responsible == null) {
                System.out.println(">> Usuário não existe!");
            }
        } while (responsible == null);

        ResourcePrototype resource = null;
        String nameRes;
        do {
            System.out.print("-Digite o nome do recurso: ");
            nameRes = scan.nextLine();
            nameRes = nameRes.toLowerCase();

            if (nameRes.equals("-1")) {
                return;
            }

            for (ResourcePrototype res : this.resources) {
                if (res.getName().equals(nameRes)) {
                    resource = res;
                }
            }
            if (resource == null) {
                System.out.println(">> Recurso não existe!");
            }
        } while (resource == null);

        Date dataInicio = null, dataTermino = null;
        boolean accept = false;
        System.out.print("-Digite a data de inicio (dd/MM/yyyy HH:mm): ");
        String line = scan.nextLine();
        while(!accept) {
            try {
                dataInicio = format.parse(line);
                accept = true;
            } catch (ParseException e) {
                System.out.println(">> Formato errado!");
            }
        }

        System.out.print("-Digite a data de término (dd/MM/yyyy HH:mm): ");
        accept = false;
        line = scan.nextLine();
        while (!accept) {
            try {
                dataTermino = format.parse(line);
                accept = true;
            } catch (ParseException e) {
                System.out.println(">> Formato errado!");
            }
        }

        boolean canAlocate = true;
        for (AlocationState aloc : this.alocations) {
            if (aloc.getResponsible() == responsible
                    && (aloc.getBegin().before(dataTermino) || aloc.getEnd().after(dataInicio))) {
                canAlocate = false;
            }
        }
        if (!canAlocate) {
            System.out.println(">> Este usuário não pode fazer alocação neste horário!");
            System.out.println("APERTE ENTER PARA CONTINUAR");
            scan.nextLine();
        }

        canAlocate = true;
        for (AlocationState aloc : this.alocations) {
            if (aloc.getResource() == resource
                    && (aloc.getBegin().before(dataTermino) || aloc.getEnd().after(dataInicio))) {
                canAlocate = false;
            }
        }
        if (!canAlocate) {
            System.out.println(">> Este recurso não pode ser alocado neste horário!");
            System.out.println("APERTE ENTER PARA CONTINUAR");
            scan.nextLine();
        }

        System.out.println("-Digite o tipo de atividade ('aula tradicional', 'apresentacao', 'laboratorio')");
        String activityType;
        WorkTypes workType = null;
        do{
            activityType = scan.nextLine();
            switch (activityType.toLowerCase()) {
                case "aula tradicional":
                    workType = WorkTypes.aulaTradicional;
                    break;
                case "apresentacao":
                    workType = WorkTypes.apresentacao;
                    break;
                case "laboratorio":
                    workType = WorkTypes.laboratorio;
                    break;
            }
        } while (workType == null);

        if (!responsible.canAlocateWork(workType)) {
            System.out.println(">> Este usuário não pode fazer este tipo de atividade!");
            System.out.println("APERTE ENTER PARA CONTINUAR");
            scan.nextLine();
        }

        System.out.print("-Digite o título da atividade: ");
        String workTitle = scan.nextLine();
        System.out.print("-Digite a descrição da atividade: ");
        String workDescription = scan.nextLine();
        System.out.print("-Digite o material de apoio da atividade: ");
        String workMaterial = scan.nextLine();

        System.out.print("-Digite o tipo de participantes ('aluno', 'mestrando', 'doutorando', 'pesquisador', 'professor'): ");
        String particType;
        accept = false;
        do{
            particType = scan.nextLine();
            particType = particType.toUpperCase();
            if (particType.equals("ALUNO") || particType.equals("MESTRANDO") || particType.equals("DOUTORANDO")
                    || particType.equals("PESQUISADOR") || particType.equals("PROFESSOR")) {
                accept = true;
            }
        } while (!accept);
        System.out.print("-Digite a quantidade de participantes: ");
        int qntPartic = Integer.parseInt(scan.nextLine());
        List<UserStrategy> participants = new LinkedList<>();
        for (int i = 0; i < qntPartic && i < users.size(); i++) {
            accept = false;
            do {
                System.out.printf("-Digite o CPF do participante %d: ", i + 1);
                cpf = scan.nextLine();
                for (UserStrategy user : this.users) {
                    if (user.getCpf().equals(cpf)) {
                        if (user.getType().equals(particType)) {
                            participants.add(user);
                            accept = true;
                        } else {
                            System.out.println(">> Usuário não é do tipo informado!");
                        }
                    }
                }
                if (!accept) {
                    System.out.println(">> Usuário inválido!");
                }
            } while (!accept);
        }

        Work newWork = new Work(workType, workTitle, workDescription, workMaterial, participants);
        newAlocation = new InProgressConcreteState(resource, responsible, dataInicio, dataTermino, newWork);
        this.alocations.add(newAlocation.updateState());
    }

    private void consultarUser() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\n\n\n\n\n\n\n\n\nConsultar Usuário\n");
        System.out.print("-Digite o CPF do usuário: ");
        String cpf = scan.nextLine();

        boolean ans = false;
        for (UserStrategy user : this.users) {
            if (user.getCpf().equals(cpf)) {
                System.out.println(user);
                ans = true;
            }
        }

        if (!ans) {
            System.out.println(">> Não foi encontrado nenhum usuário com este CPF.");
        }

        System.out.println("APERTE ENTER PARA CONTINUAR");
        scan.nextLine();
    }

    private void cadastrarUser(String type) {
        type = type.toUpperCase();
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\n\n\n\n\n\n\n\n\nCadastrar Usuário\n");
        System.out.print("-Digite o CPF do "+ type +": ");
        String cpf = scan.nextLine();
        System.out.print("-Digite o nome do "+ type +": ");
        String name = scan.nextLine();
        System.out.print("-Digite o e-mail do "+ type +": ");
        String email = scan.nextLine();

        switch (type) {
            case "ALUNO":
                users.add(new StudentConcreteStrategy(name, email, cpf));
                break;
            case "PROFESSOR":
                users.add(new TeacherConcreteStrategy(name, email, cpf));
                break;
            case "MESTRANDO":
                users.add(new MasterConcreteStrategy(name, email, cpf));
                break;
            case "DOUTORANDO":
                users.add(new DoctorateConcreteStrategy(name, email, cpf));
                break;
            case "PESQUISADOR":
                users.add(new ResearcherConcreteStrategy(name, email, cpf));
                break;
            default:
                System.out.println("ERRO AO CADASTRAR!");
                break;
        }
    }
}
