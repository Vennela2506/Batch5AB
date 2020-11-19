package com.insure.quote.dao;

import java.sql.SQLException;


import com.insure.quote.dto.UserRole;

public interface Userdao {
	public UserRole userLogin(String UserId,String Password) throws SQLException ;
	}


