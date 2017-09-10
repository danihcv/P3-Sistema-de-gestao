package resource;

import java.util.LinkedList;

public class LabConcretePrototype extends ResourcePrototype {
    public LabConcretePrototype() {
        this.id = -1;
        this.name = "Laboratório";
        this.alocations = new LinkedList<>();
    }

    private LabConcretePrototype(LabConcretePrototype prot) {
        this.id = prot.getId();
        this.name = prot.getName();
        this.alocations = prot.getAlocations();
    }

    @Override
    public ResourcePrototype clone() {
        return new LabConcretePrototype(this);
    }

    @Override
    public String toString() {
        return "Laboratório";
    }
}
