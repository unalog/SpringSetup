package org.una.persistence;

import java.util.Date;

import org.una.domain.UserVO;
import org.una.dto.LoginDTO;

public interface UserDAO {
	public UserVO login (LoginDTO dto) throws Exception;
	
	public void keepLogin(String uid, String sessionId, Date next);
	
	public UserVO checkUserWithSessionKey(String value);
}
