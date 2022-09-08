package fr.istic.taa.jaxrs.dao.implement;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.Board;


public class BoardDao extends AbstractJpaDao<Long, Board> {

    public BoardDao(){
        super(Board.class);
    }
}
