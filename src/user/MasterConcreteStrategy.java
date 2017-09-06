package user;

import work.WorkTypes;

public class MasterConcreteStrategy extends UserStrategy {
    public MasterConcreteStrategy(String name, String email, int cpf) {
        super(name, email, cpf);
        this.type = "MESTRANDO";
    }

    @Override
    public boolean canAlocateResource() {
        return false;
    }

    @Override
    public boolean canAlocateWork(WorkTypes work) {
        return work == WorkTypes.apresentacao;
    }
}
