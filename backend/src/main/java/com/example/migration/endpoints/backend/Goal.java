package com.example.migration.endpoints.backend;

public class Goal {

    public static final String TYPE_STEP = "step";
    public static final String TYPE_WALKING_DISTANCE = "walking_distance";
    public static final String TYPE_RUNNING_DISTANCE = "running_distance";

    public Goal(){}

    public Goal(long id, String title, String description, String type, int goal, Reward reward) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.goal = goal;
        this.reward = reward;
    }

    private Long id;
    private String title;
    private String description;
    private String type;
    private Integer goal;
    private Reward reward;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public Integer getGoal() {
        return goal;
    }

    public Reward getReward() {
        return reward;
    }
}
