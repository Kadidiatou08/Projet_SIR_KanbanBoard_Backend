package fr.istic.taa.jaxrs.services;

import fr.istic.taa.jaxrs.dao.implement.TagDao;
import fr.istic.taa.jaxrs.domain.Tag;
import fr.istic.taa.jaxrs.dto.request.TagToAddDto;


import java.util.List;

public class TagService {

    TagDao tagDao;

    public TagService(){
        tagDao = new TagDao();
    }

    public List<Tag> getAll(){
        return tagDao.findAll();
    }
    public Tag find(Long id){
        return tagDao.findOne(id);
    }
    public boolean insert(TagToAddDto tagDto){

        Tag tag =  new Tag();
        tag.setName(tagDto.getName());

        tagDao.save(tag);
        return true;
    }
    public boolean update(Tag tag){
        tagDao.update(tag);
        return true;
    }
    public boolean delete(Long id){

        tagDao.deleteById(id);
        return true;

    }
}
