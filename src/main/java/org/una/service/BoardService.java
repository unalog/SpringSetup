package org.una.service;

import java.util.List;

import org.una.domain.BoardVO;
import org.una.domain.Criteria;
import org.una.domain.SearchCriteria;

public interface BoardService {
	
	public void regist(BoardVO vo) throws Exception;
	
	public BoardVO read (Integer bno) throws Exception;
	
	public void modify (BoardVO vo) throws Exception;
	
	public void remove (Integer bno) throws Exception;
	
	public List<BoardVO>listAll() throws Exception;
	
	public List<BoardVO>listPage(int page) throws Exception;
	
	public List<BoardVO>listCriteria(Criteria cri) throws Exception;
	
	public int listCountCriteria(Criteria cri) throws Exception;
	
	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception;
	
	public int listCountCriteria(SearchCriteria cri) throws Exception;
	
	public List<String> getAttach(Integer bno) throws Exception;
	
}
