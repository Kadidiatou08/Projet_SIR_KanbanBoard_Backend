package fr.istic.taa.jaxrs.dao.implement;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.Section;


public class SectionDao extends AbstractJpaDao<Long, Section> {

    public SectionDao(){
        super(Section.class);
    }
}
