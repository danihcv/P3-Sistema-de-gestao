package alocation;

import resource.ResourcePrototype;
import user.UserStrategy;
import work.Work;

import java.util.Date;

public class FinishedConcreteState extends AlocationState {
    public FinishedConcreteState(ResourcePrototype resource, UserStrategy responsible, Date begin, Date end, Work work) {
        super(resource, responsible, begin, end, work);
    }

    @Override
    public AlocationState updateState() {
        return this;
    }
}
