package com.ecommerce.order.about;


public class AboutRepresentation {
    private String buildNumber;
    private String buildTime;
    private String deployTime;
    private String gitRevision;
    private String gitBranch;
    private String environment;
    private String author;

    public AboutRepresentation(String buildNumber,
                               String buildTime,
                               String deployTime,
                               String gitRevision,
                               String gitBranch,
                               String environment,
                               String author) {
        this.buildNumber = buildNumber;
        this.buildTime = buildTime;
        this.deployTime = deployTime;
        this.gitRevision = gitRevision;
        this.gitBranch = gitBranch;
        this.environment = environment;
        this.author = author;
    }

    public String getBuildNumber() {
        return buildNumber;
    }

    public void setBuildNumber(String buildNumber) {
        this.buildNumber = buildNumber;
    }

    public String getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(String buildTime) {
        this.buildTime = buildTime;
    }

    public String getDeployTime() {
        return deployTime;
    }

    public void setDeployTime(String deployTime) {
        this.deployTime = deployTime;
    }

    public String getGitRevision() {
        return gitRevision;
    }

    public void setGitRevision(String gitRevision) {
        this.gitRevision = gitRevision;
    }

    public String getGitBranch() {
        return gitBranch;
    }

    public void setGitBranch(String gitBranch) {
        this.gitBranch = gitBranch;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
