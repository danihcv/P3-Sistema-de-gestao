package user;

import alocation.AlocationState;
import resource.ResourcePrototype;
import work.Work;
import work.WorkTypes;

import java.util.LinkedList;
import java.util.List;

public abstract class UserStrategy {
    String type;
    private String name;
    private String email;
    private int cpf;
    private List<ResourcePrototype> alocatedResources = new LinkedList<>();
    private List<Work> realizedWorks = new LinkedList<>();

    public UserStrategy(String name, String email, int cpf) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
    }

    public abstract boolean canAlocateResource();
    public abstract boolean canAlocateWork(WorkTypes work);

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getCpf() {
        return cpf;
    }

    public void addAlocatedResource(ResourcePrototype resource) {
        this.alocatedResources.add(resource);
    }

    public void addRealizedWork(Work newWork) {
        this.realizedWorks.add(newWork);
    }

    @Override
    public String toString() {
        String alocated = "";
        List<String> alocatedNames = new LinkedList<>();
        for(ResourcePrototype res : this.alocatedResources) {
            boolean add = true;
            for(String alocatedName : alocatedNames) {
                if(alocatedName.equals(res.getName())) {
                    add = false;
                }
            }
            if (add) {
                alocatedNames.add(res.getName());
            }
        }
        for(String str : alocatedNames) {
            alocated = alocated.concat("\t• "+ str +"\n");
        }

        String realized = "";
        List<String> realizedNames = new LinkedList<>();
        for(Work work : this.realizedWorks) {
            boolean add = true;
            for(String realizedName : realizedNames) {
                if(realizedName.equals(work.getTitle())) {
                    add = false;
                }
            }
            if (add) {
                realizedNames.add(work.getTitle());
            }
        }
        for(String str : realizedNames) {
            realized = realized.concat("\t• "+ str +"\n");
        }

        return "-Tipo: "+ this.type +"\n"+
                "-CPF: "+ this.cpf +"\n"+
                "-Nome: "+ this.name +"\n"+
                "-E-mail: "+ this.email +"\n"+
                "-Recursos já alocados:\n"+
                    alocated +
                "-Atividades realizadas:\n"+
                    realized;
    }
}
