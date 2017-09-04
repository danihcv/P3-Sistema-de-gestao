package user;

import work.WorkTypes;

public class ResearcherConcreteStrategy extends UserStrategy {
    public ResearcherConcreteStrategy(String name, String email, String cpf) {
        super(name, email, cpf);
        this.type = "PESQUISADOR";
    }

    @Override
    public boolean canAlocateResource() {
        return true;
    }

    @Override
    public boolean canAlocateWork(WorkTypes work) {
        return false;
    }
}
