package com.unity.githubAPI.dto;

import java.io.Serializable;

public class RepositoryInfoDto implements Serializable {

    private RepositoryInfoDto(Builder builder) {
        fullName= builder.fullName;
        description = builder.description;
        cloneUrl = builder.cloneUrl;
        stars = builder.stars;
        createdAt = builder.createdAt;

    }

    private String fullName;
    private String description;
    private String cloneUrl;
    private Double stars;
    private String createdAt;

    public String getFullName() {
        return fullName;
    }

    public String getDescription() {
        return description;
    }

    public String getCloneUrl() {
        return cloneUrl;
    }

    public Double getStars() {
        return stars;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public static final class Builder {
        private String fullName;
        private String description;
        private String cloneUrl;
        private Double stars;
        private String createdAt;

        public Builder(){

        }

        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder cloneUrl(String cloneUrl) {
            this.cloneUrl = cloneUrl;
            return this;
        }

        public Builder stars(Double stars) {
            this.stars = stars;
            return this;
        }

        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public RepositoryInfoDto build(){
            return new RepositoryInfoDto(this);
        }
    }
}
