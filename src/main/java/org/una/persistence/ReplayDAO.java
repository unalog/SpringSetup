package org.una.persistence;

import java.util.List;

import org.una.domain.Criteria;
import org.una.domain.ReplyVO;

public interface ReplayDAO {
	
	public List<ReplyVO> list(Integer bno) throws Exception;
	
	public void create (ReplyVO vo) throws Exception;
	
	public void update (ReplyVO vo) throws Exception;
	
	public void delete (Integer rno) throws Exception;
	
	
	public List<ReplyVO> listPage(Integer bno, Criteria cri)  throws Exception;
	
	public int count (Integer bno) throws Exception;

}
