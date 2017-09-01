package user;

import resource.ResourcePrototype;
import work.Work;
import work.WorkTypes;

import java.util.LinkedList;
import java.util.List;

public abstract class UserStrategy {
    private int id;
    private String name;
    private String email;
    private String cpf;
    private List<ResourcePrototype> alocatedResources = new LinkedList<>();
    private List<Work> realizedWorks = new LinkedList<>();

    public UserStrategy(int id, String name, String email, String cpf) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
    }

    abstract boolean canAlocateResource(String resource);
    abstract boolean canAlocateWork(WorkTypes work);
}
