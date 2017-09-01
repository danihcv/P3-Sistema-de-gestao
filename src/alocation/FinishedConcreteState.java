package alocation;

import user.UserStrategy;

public class FinishedConcreteState extends AlocationState {
    public FinishedConcreteState(String name, UserStrategy responsible) {
        super(name, responsible);
    }

    @Override
    AlocationState updateState() {
        return this;
    }
}
