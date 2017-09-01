package resource;

import alocation.AlocationState;

import java.util.LinkedList;
import java.util.List;

public abstract class ResourcePrototype {
    int id;
    String name;
    List<AlocationState> alocations = new LinkedList<>();
}
