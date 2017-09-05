package resource;

import alocation.AlocationState;

import java.util.LinkedList;
import java.util.List;

public abstract class ResourcePrototype {
    int id;
    String name;
    List<AlocationState> alocations = new LinkedList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAlocations(List<AlocationState> alocations) {
        this.alocations = alocations;
    }

    public List<AlocationState> getAlocations() {
        return alocations;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract ResourcePrototype clone();

    public void addAlocation(AlocationState newAlocation) {
        this.alocations.add(newAlocation);
    }
}
