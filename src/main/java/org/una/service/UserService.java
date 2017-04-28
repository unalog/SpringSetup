package org.una.service;

import java.util.Date;

import org.una.domain.UserVO;
import org.una.dto.LoginDTO;

public interface UserService {

	public UserVO login(LoginDTO dto) throws Exception;
	
	public void keepLogin(String uid, String sessionId, Date next) throws Exception;
	
	public UserVO checkLoginBefor(String value);
}
