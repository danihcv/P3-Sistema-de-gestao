package user;

import work.WorkTypes;

public class StudentConcreteStrategy extends UserStrategy {
    public StudentConcreteStrategy(String name, String email, String cpf) {
        super(name, email, cpf);
        this.type = "ALUNO";
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
