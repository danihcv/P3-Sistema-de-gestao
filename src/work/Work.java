package work;

import user.UserStrategy;

import java.util.LinkedList;
import java.util.List;

public class Work {
    private WorkTypes type;
    private String title;
    private String description;
    private String material;
    private List<UserStrategy> participants = new LinkedList<>();

    public Work(WorkTypes type, String title, String description, String material, List<UserStrategy> participants) {
        this.type = type;
        this.title = title;
        this.description = description;
        this.material = material;
        this.participants = participants;
    }
}
