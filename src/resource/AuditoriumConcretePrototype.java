package resource;

import java.util.LinkedList;

public class AuditoriumConcretePrototype extends ResourcePrototype {
    public AuditoriumConcretePrototype() {
        this.id = -1;
        this.name = "Auditório";
        this.alocations = new LinkedList<>();
    }

    private AuditoriumConcretePrototype(AuditoriumConcretePrototype prot) {
        this.id = prot.getId();
        this.name = prot.getName();
        this.alocations = prot.getAlocations();
    }

    @Override
    public ResourcePrototype clone() {
        return new AuditoriumConcretePrototype(this);
    }
}
