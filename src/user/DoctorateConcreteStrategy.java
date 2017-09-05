package user;

import work.WorkTypes;

public class DoctorateConcreteStrategy extends UserStrategy {
    public DoctorateConcreteStrategy(String name, String email, String cpf) {
        super(name, email, cpf);
        this.type = "DOUTORANDO";
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
