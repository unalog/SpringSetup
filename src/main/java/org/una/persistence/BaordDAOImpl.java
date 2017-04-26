package org.una.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.una.domain.BoardVO;
import org.una.domain.Criteria;
import org.una.domain.SearchCriteria;

@Repository
public class BaordDAOImpl implements BoardDAO {

	
	@Inject
	private SqlSession session;
	private static String namespace = "org.una.mapper.BoardMapper";
	
	
	@Override
	public void create(BoardVO vo) throws Exception {
		session.insert(namespace+".create",vo);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		return session.selectOne(namespace+".read", bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		session.update(namespace+".update",vo);
		
	}

	@Override
	public void delete(Integer bno) throws Exception {
		session.delete(namespace+".delete",bno);
		
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return session.selectList(namespace+".listAll");
	}

	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		
		if (page <= 0){
			page = 1;
		}
		
		page = (page -1) * 10;
		
		return session.selectList(namespace+".listPage", page);
	}
	
	public List<BoardVO>listCriteria(Criteria cri) throws Exception
	{
		return session.selectList(namespace+".listCriteria", cri);
	}
	

	public int countPaging(Criteria cri)throws Exception
	{
		return session.selectOne(namespace+".countPaging", cri);
	}


	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception
	{
		return session.selectList(namespace+".listSearch", cri);
	}
	
	public int listSearchCount(SearchCriteria cri) throws Exception
	{
		return session.selectOne(namespace+".listSearchCount", cri);
	}
	

	public void updateReplyCnt(Integer bno, int amount) throws Exception
	{
		Map<String, Object> paramMap = new HashMap<String,Object>();
		paramMap.put("bno", bno);
		paramMap.put("amount", amount);
		
		
		session.update(namespace+".updateReplyCnt", paramMap);
	}

	public void updateViewCnt(Integer bno) throws Exception
	{
		session.update(namespace+".updateViewCnt", bno);
	}
}
