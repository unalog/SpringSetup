package org.una.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.una.domain.Criteria;
import org.una.domain.ReplyVO;


@Repository
public class ReplayDAOImpl implements ReplayDAO{

	
	@Inject
	private SqlSession session;
	private static String namespace = "org.una.mapper.ReplyMapper";
	
	@Override
	public List<ReplyVO> list(Integer bno) throws Exception {
		return session.selectList(namespace+".list", bno);
	}

	@Override
	public void create(ReplyVO vo) throws Exception {
		session.insert(namespace+".create", vo);
		
	}

	@Override
	public void update(ReplyVO vo) throws Exception {
		session.update(namespace+".update", vo);
		
	}

	@Override
	public void delete(Integer rno) throws Exception {
		session.delete(namespace+".delete", rno);
		
	}

	@Override
	public List<ReplyVO> listPage(Integer bno, Criteria cri) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("bno", bno);
		paramMap.put("cri", cri);
		
		return session.selectList(namespace+".listPage",paramMap);
		
	}

	@Override
	public int count(Integer bno) throws Exception {
		
		return session.selectOne(namespace+".count", bno);
	}
	

	public int getBno(Integer rno) throws Exception
	{
		return session.selectOne(namespace+".getBno", rno);
	}

}
