package com.insure.quote.dao;

import java.util.List;

import com.insure.quote.dto.Accounts;
import com.insure.quote.dto.Policy;
import com.insure.quote.dto.PolicyQuestions;
import com.insure.quote.exception.IQGSException;

public interface InsuredDao {
public boolean accountValidation(String username) throws IQGSException;
	
	public String getLineOfBusinessIdByName(String lineOfBusinessName) throws IQGSException;

	public boolean isUserExists(String userName) throws IQGSException;
	
	public int accountCreation(Accounts account) throws IQGSException;
	
	public List<Policy> getInsuredPolicies(int accNo) throws IQGSException;
	
	public int getAccountNumber(String username) throws IQGSException;
	
	public Accounts getAccountDetails(Integer accNo) throws IQGSException;
	
	public String getBusSegName(String lineOfBusiness) throws IQGSException;
	
	public Double getPolicyPremium(Integer polNum) throws IQGSException;
	
	public List<PolicyQuestions> getPolicyQuestions(String lineOfBusiness) throws IQGSException;
	
	public List<String> getSelectedAnswers(Integer polNum) throws IQGSException;

}
