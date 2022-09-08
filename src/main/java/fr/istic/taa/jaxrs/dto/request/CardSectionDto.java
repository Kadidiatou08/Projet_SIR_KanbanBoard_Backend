package fr.istic.taa.jaxrs.dto.request;

public class CardSectionDto {
    private Long idCard;
    private Long idSection;

    public Long getIdCard() {
        return idCard;
    }

    public void setIdCard(Long idCard) {
        this.idCard = idCard;
    }

    public Long getIdSection() {
        return idSection;
    }

    public void setIdSection(Long idSection) {
        this.idSection = idSection;
    }
}
