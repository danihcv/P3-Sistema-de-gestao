package work;

import user.UserStrategy;

import java.util.LinkedList;
import java.util.List;

public class Work {
    private WorkTypes type;
    private String title;
    private String description;
    private String material;
    private String participantsType;
    private List<UserStrategy> participants = new LinkedList<>();

    public Work(WorkTypes type, String title, String description, String material, String participantsType, List<UserStrategy> participants) {
        this.type = type;
        this.title = title;
        this.description = description;
        this.material = material;
        this.participantsType = participantsType;
        this.participants = participants;
    }

    public String getParticipantsType() {
        return participantsType;
    }

    public void setParticipantsType(String participantsType) {
        this.participantsType = participantsType;
    }


    public WorkTypes getType() {
        return type;
    }

    public void setType(WorkTypes type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public List<UserStrategy> getParticipants() {
        return participants;
    }

    public void setParticipants(List<UserStrategy> participants) {
        this.participants = participants;
    }
}
