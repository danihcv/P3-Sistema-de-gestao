package alocation;

import user.UserStrategy;

public class InProgressConcreteState extends AlocationState {
    public InProgressConcreteState(String name, UserStrategy responsible) {
        super(name, responsible);
    }

    @Override
    AlocationState updateState() {
        return new AlocatedConcreteState();
    }
}
