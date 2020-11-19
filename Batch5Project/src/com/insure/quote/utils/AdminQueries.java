package com.insure.quote.utils;

public class AdminQueries {

		
		//public static final String VALIDATE_USER_QUERY = "select * from userrole where username = ? and password = ?";
		
		public static final String GET_ROLECODE = "select rolecode from userrole where username = ? and password = ?";
		
		public static final String ADD_USER = "insert into userRole values(?,?,?)";
		
		public static final String ACCOUNT_CREATION = "insert into accounts values(accountnumber.nextval,?,?,?,?,?,?,?)";
		
		public static final String GET_LOB_NAME = "select bus_seg_id from Business_Segment where bus_seg_name = ?";
		
		public static final String USER_EXISTS = "select * from userrole where username = ?";
		
		public static final String GET_BUS_SEG_ID = "select lineofBusiness from accounts where accountnumber = ?";
		
		public static final String GET_POLICY_QUESTIONS = "select * from policyquestions where bus_seg_id = ?";
		
		//String GET_POLICY_PREMIUM_AMOUNT = "select pre_amt from premiums where ? in (pre_ans_weightage_min,pre_ans_weightage_max)";
		public static final String GET_POLICY_PREMIUM_AMOUNT = "select pre_amt from premiums where ? between pre_ans_weightage_min and pre_ans_weightage_max";
		
		public static final String CREATE_POLICY = "insert into policy values(policy_number.nextval, ?, ?)";
		
		public static final String GET_POLICY_NUMBER = "select max(policynumber) from policy";
		
		public static final String GET_QUESTION_IDS = "select pol_ques_id from policyquestions where bus_seg_id = ?";
		
		public static final String ADD_POLICY_DETAILS = "insert into policydetails values(?,?,?)";
		
		public static final String GET_POLICIES = "select * from policy";
		
		public static final String GET_ACCOUNT_DETAILS = "select * from accounts where accountnumber = ?";
		
		public static final String GET_BUS_SEG_NAME = "select bus_seg_name from businesssegment where bus_seg_id = ?";
		
		public static final String GET_POLICY_PREMIUM = "select policypremium from policy where policynumber = ?";
		
		public static final String GET_SELECTED_ANSWERS = "select answer from policydetails where policynumber = ?";
		
	}



