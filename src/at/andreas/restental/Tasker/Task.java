package at.andreas.restental.Tasker;

public class Task {
    String name;
    String description;
    String creator;
    int priority;

    public Task(String name, String description, String creator, int priority){
        this.name = name;
        this.description = description;
        this.creator = creator;
        this.priority = priority;
    }

    public Task(){

    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreator() {
        return creator;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}