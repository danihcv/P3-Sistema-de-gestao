package alocation;

import user.UserStrategy;

public class AlocatedConcreteState extends AlocationState {
    public AlocatedConcreteState(String name, UserStrategy responsible) {
        super(name, responsible);
    }

    @Override
    AlocationState updateState() {
        return new FinishedConcreteState();
    }
}
