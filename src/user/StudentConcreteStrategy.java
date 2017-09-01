package user;

import work.WorkTypes;

public class StudentConcreteStrategy extends UserStrategy {
    public StudentConcreteStrategy(int id, String name, String email, String cpf) {
        super(id, name, email, cpf);
    }

    @Override
    boolean canAlocateResource(String resource) {
        return false;
    }

    @Override
    boolean canAlocateWork(WorkTypes work) {
        return false;
    }
}
