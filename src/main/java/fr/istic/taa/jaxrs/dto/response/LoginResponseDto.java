package fr.istic.taa.jaxrs.dto.response;

import fr.istic.taa.jaxrs.domain.User;

public class LoginResponseDto {

    private Boolean userFound;
    private User user;

    public Boolean getUserFound() {
        return userFound;
    }

    public void setUserFound(Boolean userFound) {
        this.userFound = userFound;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
