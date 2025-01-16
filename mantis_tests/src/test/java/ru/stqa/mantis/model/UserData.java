package ru.stqa.mantis.model;

import io.swagger.client.model.User;

public record UserData(String username, String email, String accessLever, Boolean enabled, Boolean protect ) {



    public UserData() {
        this("", "", "reporter", true, false);
    }


    public UserData withName(String username) {
        return new UserData(username, this.email, this.accessLever, this.enabled, this.protect);
    }


    public UserData withEmail(String email) {
        return new UserData(this.username, email, this.accessLever, this.enabled, this.protect);
    }

    public UserData withAccessLever(String accessLever) {
        return new UserData(this.username, this.email, accessLever, this.enabled, this.protect);
    }

    public UserData withEnabled(Boolean enabled) {
        return new UserData(this.username, this.email, this.accessLever, enabled, this.protect);
    }

    public UserData withProtect(Boolean protect) {
        return new UserData(this.username, this.email, this.accessLever, this.enabled, protect);
    }
}
