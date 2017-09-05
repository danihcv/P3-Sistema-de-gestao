package alocation;

import resource.ResourcePrototype;
import user.UserStrategy;
import work.Work;

import java.util.Date;

public abstract class AlocationState {
    ResourcePrototype resource;
    UserStrategy responsible;
    Date begin, end;
    Work work;

    AlocationState() {}

    public AlocationState(ResourcePrototype resource, UserStrategy responsible, Date begin, Date end, Work work) {
        this.resource = resource;
        this.responsible = responsible;
        this.begin = begin;
        this.end = end;
        this.work = work;
    }

    public abstract AlocationState updateState();

    public ResourcePrototype getResource() {
        return resource;
    }

    public UserStrategy getResponsible() {
        return responsible;
    }

    public Date getBegin() {
        return begin;
    }

    public Date getEnd() {
        return end;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }
}
