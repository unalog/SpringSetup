package org.una.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.una.domain.BoardVO;
import org.una.domain.Criteria;
import org.una.domain.SearchCriteria;
import org.una.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	
	@Inject
	
	private BoardDAO dao;
	
	
	@Override
	public void regist(BoardVO vo) throws Exception {
		
		dao.create(vo);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		
		return dao.read(bno);
	}

	@Override
	public void modify(BoardVO vo) throws Exception {
		
		
		dao.update(vo);
		
	}

	@Override
	public void remove(Integer bno) throws Exception {
		
		dao.delete(bno);
		
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return dao.listAll();
		
	}


	public List<BoardVO>listPage(int page) throws Exception
	{
		return dao.listPage(page);
	}
	

	public List<BoardVO>listCriteria(Criteria cri) throws Exception
	{
		return dao.listCriteria(cri);
	}
	

	public int listCountCriteria(Criteria cri) throws Exception
	{
		return dao.countPaging(cri);
	}
	
	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception
	{
		return dao.listSearch(cri);
	}
	
	public int listCountCriteria(SearchCriteria cri) throws Exception
	{
		return dao.listSearchCount(cri);
	}
}
