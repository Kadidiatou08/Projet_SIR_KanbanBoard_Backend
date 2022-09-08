package fr.istic.taa.jaxrs.services;

import fr.istic.taa.jaxrs.dao.implement.SectionDao;
import fr.istic.taa.jaxrs.domain.Section;
import fr.istic.taa.jaxrs.dto.request.SectionToAddDto;


import java.util.List;

public class SectionService {

    SectionDao sectionDao;

    public SectionService(){
        sectionDao = new SectionDao();
    }

    public List<Section> getAll(){
        return sectionDao.findAll();
    }
    public Section find(Long id){
        return sectionDao.findOne(id);
    }
    public boolean insert(SectionToAddDto sectionDto){

        Section section = new Section();

        section.setName(sectionDto.getName());

        sectionDao.save(section);
        return true;

    }
    public boolean update(Section section){
        sectionDao.update(section);
        return true;
    }
    public boolean delete(Long id){
        sectionDao.deleteById(id);
        return true;
    }
}
