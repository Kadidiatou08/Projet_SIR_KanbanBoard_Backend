package fr.istic.taa.jaxrs.services;

import fr.istic.taa.jaxrs.dao.implement.BoardDao;
import fr.istic.taa.jaxrs.dao.implement.SectionDao;
import fr.istic.taa.jaxrs.domain.Board;
import fr.istic.taa.jaxrs.domain.Section;
import fr.istic.taa.jaxrs.dto.request.BoardToAddDto;
import fr.istic.taa.jaxrs.dto.request.SectionToBoardDto;
import fr.istic.taa.jaxrs.utlis.Utils;


import java.util.List;

public class BoardService {

    BoardDao boardDao;
    SectionDao sectionDao;

    public BoardService(){
        boardDao = new BoardDao();
        sectionDao = new SectionDao();
    }

    public List<Board> getAll(){

        return boardDao.findAll();
    }

    public Board find(long id){
        return boardDao.findOne(id);
    }

    public boolean insert(BoardToAddDto boardToAddDto){
        Board board = new Board();
        List<Section> sectionsFound = Utils.sectionListExist(boardToAddDto.getIdSections());
        if(sectionsFound.isEmpty()){
           return false;
        }
        board.setName(boardToAddDto.getName());
        board.setSections(sectionsFound);
        boardDao.save(board);
        return true;
    }

    public boolean update(Board board){
        boardDao.update(board);
        return true;
    }

    public boolean delete(Long id){
        boardDao.deleteById(id);
        return true;
    }

    //A revoir ce methode il me fraudait pas ajouter une section deja existante
    public boolean addSection(SectionToBoardDto sectionToBoardDto){
        Section sectionFound = Utils.sectionExist(sectionToBoardDto.getIdSection()).get();
        Board boardFound = Utils.boardExist(sectionToBoardDto.getIdBoardDto()).get();

        if( sectionFound == null || boardFound == null){
            return false;
        }

        List<Section> sectionsExists = boardFound.getSections();
        sectionsExists.add(sectionFound);
        boardFound.setSections(sectionsExists);
        boardDao.update(boardFound);

        sectionFound.getBoards().add(boardFound);
        sectionDao.update(sectionFound); // Il faut faire des deux cotés
        return true;

    }

}
