package com.insure.quote.service;

import java.util.List;

import com.insure.quote.dao.AdminDaoImpl;
import com.insure.quote.dao.AdminDao;
import com.insure.quote.dto.Accounts;
import com.insure.quote.dto.Policy;
import com.insure.quote.dto.PolicyQuestions;
import com.insure.quote.dto.UserRole;
import com.insure.quote.exception.IQGSException;

public class AdminServiceImpl implements AdminService {
AdminDaoImpl adminDao = new AdminDaoImpl ();
/*@Override
public boolean loginValidation(String username, String password) throws IQGSException {
// TODO Auto-generated method stub
return adminDao.loginValidation(username, password);
}*/

@Override
public String getRoleCode(String username, String password) throws IQGSException {
// TODO Auto-generated method stub
return adminDao.getRoleCode(username, password);
}

@Override
public int addUser(UserRole userRole) throws IQGSException {
// TODO Auto-generated method stub
return adminDao.addUser(userRole);
}

@Override
public int accountCreation(Accounts account) throws IQGSException {
// TODO Auto-generated method stub
return adminDao.accountCreation(account);
}

@Override
public String getLineOfBusinessIdByName(String busSegName) throws IQGSException {
// TODO Auto-generated method stub
return adminDao.getLineOfBusinessIdByName(busSegName);
}

@Override
public boolean isUserExists(String userName) throws IQGSException {
// TODO Auto-generated method stub
return adminDao.isUserExists(userName);
}

@Override
public String getBusSegId(int accNumber) throws IQGSException {
// TODO Auto-generated method stub
return adminDao.getBusSegId(accNumber);
}

@Override
public List<PolicyQuestions> getPolicyQuestions(String busSegId) throws IQGSException {
// TODO Auto-generated method stub
return adminDao.getPolicyQuestions(busSegId);
}

@Override
public int getPolicyPremiumAmount(int sumOfWeightages) throws IQGSException {
// TODO Auto-generated method stub
return adminDao.getPolicyPremiumAmount(sumOfWeightages);
}

@Override
public int createPolicy(Policy policy) throws IQGSException {
// TODO Auto-generated method stub
return adminDao.createPolicy(policy);
}

@Override
public int getPolicyNumber() throws IQGSException {
// TODO Auto-generated method stub
return adminDao.getPolicyNumber();
}

@Override
public void addPolicyDetails(int polNumber, List<String> questionIds, List<String> selectedAnswers)
throws IQGSException {
// TODO Auto-generated method stub
adminDao.addPolicyDetails(polNumber, questionIds, selectedAnswers);
}

@Override
public List<Policy> getPolicies() throws IQGSException {
// TODO Auto-generated method stub
return adminDao.getPolicies();
}

@Override
public Accounts getAccountDetails(int accNumber) throws IQGSException {
// TODO Auto-generated method stub
return adminDao.getAccountDetails(accNumber);
}

@Override
public String getBusSegName(String lineOfBusiness) throws IQGSException {
// TODO Auto-generated method stub
return adminDao.getBusSegName(lineOfBusiness);
}

@Override
public Double getPolicyPremium(int polNum) throws IQGSException {
// TODO Auto-generated method stub
return adminDao.getPolicyPremium(polNum);
}

@Override
public List<String> getSelectedAnswers(int polNum) throws IQGSException {
// TODO Auto-generated method stub
return adminDao.getSelectedAnswers(polNum);
}



}
