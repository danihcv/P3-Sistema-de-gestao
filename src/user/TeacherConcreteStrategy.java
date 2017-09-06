package user;

import work.WorkTypes;

public class TeacherConcreteStrategy extends UserStrategy {
    public TeacherConcreteStrategy(String name, String email, int cpf) {
        super(name, email, cpf);
        this.type = "PROFESSOR";
    }

    @Override
    public boolean canAlocateResource() {
        return true;
    }

    @Override
    public boolean canAlocateWork(WorkTypes work) {
        return true;
    }
}
