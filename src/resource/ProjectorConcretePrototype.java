package resource;

import java.util.LinkedList;

public class ProjectorConcretePrototype extends ResourcePrototype {
    public ProjectorConcretePrototype() {
        this.id = -1;
        this.name = "Projetor";
        this.alocations = new LinkedList<>();
    }

    ProjectorConcretePrototype(ProjectorConcretePrototype prot) {
        this.id = prot.getId();
        this.name = prot.getName();
        this.alocations = prot.getAlocations();
    }

    @Override
    public ResourcePrototype clone() {
        return new ProjectorConcretePrototype(this);
    }
}
