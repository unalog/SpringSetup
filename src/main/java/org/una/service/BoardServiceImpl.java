package org.una.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.domain.BoardVO;
import org.una.domain.Criteria;
import org.una.domain.SearchCriteria;
import org.una.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	
	@Inject
	
	private BoardDAO dao;
	
	@Transactional
	@Override
	public void regist(BoardVO vo) throws Exception {
		
		dao.create(vo);
		String[] files = vo.getFiles();
		
		if(files == null){return;}
		
		for(String fileName : files)
		{
			dao.addAttach(fileName);
		}
	}

	@Transactional
	@Override
	public BoardVO read(Integer bno) throws Exception {
		
		dao.updateViewCnt(bno);
		return dao.read(bno);
	}

	@Transactional
	@Override
	public void modify(BoardVO vo) throws Exception {
		
		
		dao.update(vo);
		
		Integer bno = vo.getBno();
		
		dao.deleteAttach(bno);
		String[] files = vo.getFiles();

		if(files == null){return;}
		
		for(String fileName : files)
		{
			dao.addAttach(fileName);
		}
		
	}

	@Transactional
	@Override
	public void remove(Integer bno) throws Exception {
		
		dao.deleteAttach(bno);
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

	@Override
	public List<String> getAttach(Integer bno) throws Exception {
		
		return dao.getAttach(bno);
	}
}
