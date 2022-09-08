package fr.istic.taa.jaxrs.dto.request;

import java.util.List;

public class CardUserDto {
    private Long idCard;
    private List<Long> idUsersAssigned;

    public Long getIdCard() {
        return idCard;
    }

    public void setIdCard(Long idCard) {
        this.idCard = idCard;
    }

    public List<Long> getIdUsersAssigned() {
        return idUsersAssigned;
    }

    public void setIdUsersAssigned(List<Long> idUsersAssigned) {
        this.idUsersAssigned = idUsersAssigned;
    }
}
