package alocation;

import resource.ResourcePrototype;
import user.UserStrategy;
import work.Work;

import java.util.Date;

public class InProcessConcreteState extends AlocationState {
    public InProcessConcreteState() {
        super();
    }

    public InProcessConcreteState(ResourcePrototype resource, UserStrategy responsible, Date begin, Date end, Work work) {
        super(resource, responsible, begin, end, work);
    }

    @Override
    public AlocationState updateState() {
        return new AlocatedConcreteState(this.resource, this.responsible, this.begin, this.end, this.work);
    }

    @Override
    public String toString() {
        return "Em processo de alocação";
    }
}
