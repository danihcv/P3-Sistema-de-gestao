package alocation;

import user.UserStrategy;

public abstract class AlocationState {
    String name;
    UserStrategy responsible;

    public AlocationState(String name, UserStrategy responsible) {
        this.name = name;
        this.responsible = responsible;
    }

    abstract AlocationState updateState();
}
