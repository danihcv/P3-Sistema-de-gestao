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

import static resource.ResourcesType.*;

public class MainSystem {
    private DateFormat format = new SimpleDateFormat("dd/MM/yyyy' 'HH:mm");

    private ProjectorConcretePrototype prototypeProjector = new ProjectorConcretePrototype();
    private LabConcretePrototype prototypeLab = new LabConcretePrototype();
    private ClassRoomConcretePrototype prototypeClass = new ClassRoomConcretePrototype();
    private AuditoriumConcretePrototype prototypeAuditorium = new AuditoriumConcretePrototype();

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
            System.out.println("6. Cadastrar recurso");
            System.out.println("7. Alocar recurso");
            System.out.println("8. Editar alocação");
            System.out.println("9. Ver alocações");
            System.out.println("10. Consultar usuário");
            System.out.println("11. Consultar recurso");
            System.out.println("12. Relatório da unidade");
            System.out.println("13. Sair");

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
                case 6: this.cadastrarRecurso();
                    break;
                case 7: this.alocarRecurso();
                    break;
                /*
                case 8: this.editarRecurso();
                    break;
                case 9: this.detalhesAlocacoes();
                    break;
                */
                case 10: this.consultarUser();
                    break;
                case 11: this.consultarRecurso();
                    break;
                /*
                case 12: this.relatorio();
                    break;
                */
                case 13:
                    running = false;
                    break;

            }
        }
    }

    private void consultarRecurso() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\n\n\n\n\n\n\n\n\nConsultar Recurso\n");

        System.out.print("-Digite o nome do recurso: ");
        String name = scan.nextLine();
        name = name.toLowerCase();
        ResourcePrototype resource = null;
        for (ResourcePrototype res : this.resources) {
            if (res.getName().toLowerCase().equals(name)) {
                resource = res;
            }
        }

        if(resource == null) {
            System.out.println(">> Não existe recurso com este nome!");
        } else {
            System.out.println("--------------------");
            System.out.printf("ID: %d\n", resource.getId());
            System.out.printf("Nome: %s\n", resource.getName());

            for(AlocationState aloc : resource.getAlocations()) {
                System.out.println("\t------------------------------");
                System.out.printf("\t• Atividade - Título: %s\n", aloc.getWork().getTitle());
                System.out.printf("\t• Atividade - Descrição: %s\n", aloc.getWork().getDescription());
                System.out.printf("\t• Atividade - Material de apoio: %s\n", aloc.getWork().getMaterial());
                System.out.printf("\t• Alocação - Responsável: %s\n", aloc.getResponsible().getName());
                System.out.printf("\t• Alocação - Status: %s\n", aloc);
                System.out.printf("\t• Alocação - Data início: %s\n", format.format(aloc.getBegin()));
                System.out.printf("\t• Alocação - Data término: %s\n", format.format(aloc.getEnd()));
                System.out.printf("\t• Participantes - Tipo: %s\n", aloc.getWork().getParticipantsType());
                System.out.printf("\t• Participantes: ");
                boolean first = true;
                for(UserStrategy partic : aloc.getWork().getParticipants()){
                    if(!first){
                        System.out.print("; ");
                    } else {
                        first = false;
                    }
                    System.out.println(partic.getName());
                }
            }
            System.out.println("\n");
        }
        System.out.println("--------------------");
        System.out.println("\nAperte ENTER para sair.");
        scan.nextLine();
    }

    private void cadastrarRecurso() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\n\n\n\n\n\n\n\n\nCadastrar Recurso\n");

        System.out.println("-Tipos de recurso:");
        System.out.println("1. Auditório");
        System.out.println("2. Sala de aula");
        System.out.println("3. Laboratório");
        System.out.println("4. Projetor");

        int sel;
        ResourcePrototype newResource = null;
        do{
            System.out.print("-Digite o tipo de recurso que deseja criar: ");
            sel = Integer.parseInt(scan.nextLine());

            switch (sel) {
                case 1:
                    newResource = prototypeAuditorium.clone();
                    break;
                case 2:
                    newResource = prototypeClass.clone();
                    break;
                case 3:
                    newResource = prototypeLab.clone();
                    break;
                case 4:
                    newResource = prototypeProjector.clone();
                    break;
            }
        } while (newResource == null);

        System.out.print("-Digite o nome do recurso: ");
        String name = scan.nextLine();

        newResource.setId(this.resources.size() + 1);
        newResource.setName(name);
        this.resources.add(newResource);
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
                System.out.println(">> Usuário inválido!");
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
                if (res.getName().toLowerCase().equals(nameRes)) {
                    resource = res;
                }
            }
            if (resource == null) {
                System.out.println(">> Recurso não existe!");
            }
        } while (resource == null);

        Date dataInicio = null, dataTermino = null;
        boolean accept = false;
        while(!accept) {
            try {
                System.out.print("-Digite a data de inicio (dd/MM/yyyy HH:mm): ");
                dataInicio = format.parse(scan.nextLine());
                accept = true;
            } catch (ParseException e) {
                System.out.println(">> Formato errado!");
            }
        }

        accept = false;
        while (!accept) {
            try {
                System.out.print("-Digite a data de término (dd/MM/yyyy HH:mm): ");
                dataTermino = format.parse(scan.nextLine());
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

        String activityType;
        WorkTypes workType = null;
        do{
            System.out.print("-Digite o tipo de atividade ('aula tradicional', 'apresentacao', 'laboratorio')");
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
                default:
                    System.out.println(">> Tipo errado! Atividades podem ser 'aula tradicional', 'apresentacao' ou 'laboratorio'.");
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

        Work newWork = new Work(workType, workTitle, workDescription, workMaterial, particType, participants);
        newAlocation = new InProgressConcreteState(resource, responsible, dataInicio, dataTermino, newWork);
        newAlocation = newAlocation.updateState();
        this.alocations.add(newAlocation);
        resource.addAlocation(newAlocation);
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
                System.out.println("APERTE ENTER PARA CONTINUAR");
                scan.nextLine();
                break;
        }
    }
}
