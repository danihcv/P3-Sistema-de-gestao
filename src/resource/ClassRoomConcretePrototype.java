package resource;

import java.util.LinkedList;

public class ClassRoomConcretePrototype extends ResourcePrototype {
    public ClassRoomConcretePrototype() {
        this.id = -1;
        this.name = "Sala de aula";
        this.alocations = new LinkedList<>();
    }

    ClassRoomConcretePrototype(ClassRoomConcretePrototype prot) {
        this.id = prot.getId();
        this.name = prot.getName();
        this.alocations = prot.getAlocations();
    }

    @Override
    public ResourcePrototype clone() {
        return new ClassRoomConcretePrototype(this);
    }
}
