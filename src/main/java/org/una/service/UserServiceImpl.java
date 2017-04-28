package org.una.service;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.una.domain.UserVO;
import org.una.dto.LoginDTO;
import org.una.persistence.UserDAO;


@Service
public class UserServiceImpl implements UserService{

	
	@Inject
	private UserDAO dao;
	
	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		return dao.login(dto);
	}

	@Override
	public void keepLogin(String uid, String sessionId, Date next) throws Exception {
		
		
		dao.keepLogin(uid, sessionId, next);
		
	}

	@Override
	public UserVO checkLoginBefor(String value) {
		
		return dao.checkUserWithSessionKey(value);
	}

}
