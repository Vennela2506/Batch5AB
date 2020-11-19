package com.insure.quote.service;

import java.util.List;

import com.insure.quote.dao.InsuredDao;
import com.insure.quote.dao.InsuredDaoImpl;
import com.insure.quote.dto.Accounts;
import com.insure.quote.dto.Policy;
import com.insure.quote.dto.PolicyQuestions;
import com.insure.quote.exception.IQGSException;

public class InsuredServiceImpl implements InsuredService{

		InsuredDao insuredDao = new InsuredDaoImpl();
		@Override
		public String getLineOfBusinessIdByName(String busSegName) throws IQGSException {
			// TODO Auto-generated method stub
			return insuredDao.getLineOfBusinessIdByName(busSegName);
		}

		
		@Override
		public boolean isUserExists(String userName) throws IQGSException {
			// TODO Auto-generated method stub
			return insuredDao.isUserExists(userName);
		}

		@Override
		public int accountCreation(Accounts account) throws IQGSException {
			// TODO Auto-generated method stub
			return insuredDao.accountCreation(account);
		}


		@Override
		public boolean accountValidation(String username) throws IQGSException {
			// TODO Auto-generated method stub
			return insuredDao.accountValidation(username);
		}


		@Override
		public int getAccountNumber(String username) throws IQGSException {
			// TODO Auto-generated method stub
			return insuredDao.getAccountNumber(username);
		}


		@Override
		public List<Policy> getInsuredPolicies(int accNo) throws IQGSException {
			// TODO Auto-generated method stub
			return insuredDao.getInsuredPolicies(accNo);
		}


		@Override
		public Accounts getAccountDetails(int accNo) throws IQGSException {
			// TODO Auto-generated method stub
			return insuredDao.getAccountDetails(accNo);
		}


		@Override
		public String getBusSegName(String lineOfBusiness) throws IQGSException {
			// TODO Auto-generated method stub
			return insuredDao.getBusSegName(lineOfBusiness);
		}


		@Override
		public Double getPolicyPremium(int polNum) throws IQGSException {
			// TODO Auto-generated method stub
			return insuredDao.getPolicyPremium(polNum);
		}


		@Override
		public List<PolicyQuestions> getPolicyQuestions(String lineOfBusiness) throws IQGSException {
			// TODO Auto-generated method stub
			return insuredDao.getPolicyQuestions(lineOfBusiness);
		}


		@Override
		public List<String> getSelectedAnswers(int polNum) throws IQGSException {
			// TODO Auto-generated method stub
			return insuredDao.getSelectedAnswers(polNum);
		}


		

	}



