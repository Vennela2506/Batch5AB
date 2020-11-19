package com.insure.quote.utils;

public class InsuredDbQueries {
public static final String ACCOUNT_CREATION = "insert into Accounts values(accountnumber.nextval,?,?,?,?,?,?,?)";
	
public static final String VALIDATE_ACCOUNT_QUERY ="select * from Accounts where username = ?";

public static final String GET_INSURED_POLICY = "select * from Policy where Accountnumber = ? ";
	
public static final String GET_LOB_NAME = "select bus_seg_id from Business_Segment where bus_seg_name = ?";
	
public static final String USER_EXISTS = "select * from UserRole where username = ?";
	
public static final String GET_ACCOUNT_DETAILS = "select * from Accounts where accountnumber = ?";
	
public static final String GET_ACCOUNT_NUMBER = "select accountnumber from Accounts where username = ? ";
	
public static final String GET_BUS_SEG_NAME = "select bus_seg_name from Business_Segment where bus_seg_id = ?";
	
public static final String GET_POLICY_PREMIUM = "select policypremium from Policy where policynumber = ?";
	
public static final String GET_SELECTED_ANSWERS = "select answer from PolicyDetails where policynumber = ?";

}
