package fr.istic.taa.jaxrs.dto.request;

public class SectionToBoardDto {

    private Long idBoardDto;
    private Long idSection;

    public Long getIdBoardDto() {
        return idBoardDto;
    }

    public void setIdBoardDto(Long idBoardDto) {
        this.idBoardDto = idBoardDto;
    }

    public Long getIdSection() {
        return idSection;
    }

    public void setIdSection(Long idSection) {
        this.idSection = idSection;
    }
}
