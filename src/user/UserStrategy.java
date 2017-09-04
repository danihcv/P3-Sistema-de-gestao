package user;

import resource.ResourcePrototype;
import work.Work;
import work.WorkTypes;

import java.util.LinkedList;
import java.util.List;

public abstract class UserStrategy {
    String type;
    private String name;
    private String email;
    private String cpf;
    private List<ResourcePrototype> alocatedResources = new LinkedList<>();
    private List<Work> realizedWorks = new LinkedList<>();

    public UserStrategy(String name, String email, String cpf) {
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

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "-Tipo: "+ this.type +"\n"+
                "-CPF: "+ this.cpf +"\n"+
                "-Nome: "+ this.name +"\n"+
                "-E-mail: "+ this.email +"\n";
    }
}
