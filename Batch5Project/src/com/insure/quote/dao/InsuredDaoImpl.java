package com.insure.quote.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.insure.quote.dto.Accounts;
import com.insure.quote.dto.Policy;
import com.insure.quote.dto.PolicyDetails;
import com.insure.quote.dto.PolicyQuestions;
import com.insure.quote.exception.IQGSException;
import com.insure.quote.utils.AdminQueries;
import com.insure.quote.utils.DataBaseConnection;
import com.insure.quote.utils.InsuredDbQueries;

public class InsuredDaoImpl implements InsuredDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	@Override
	public boolean accountValidation(String username) throws IQGSException {
		boolean found = false;
		try {
			conn=DataBaseConnection.getConnection();

			PreparedStatement pst = conn.prepareStatement(InsuredDbQueries.VALIDATE_ACCOUNT_QUERY);
			pst.setString(1, username);
			
			rs = pst.executeQuery();
			found = rs.next();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}
        return found;
	}


	
	@Override
	public String getLineOfBusinessIdByName(String lineOfBusinessName) throws IQGSException {
		// TODO Auto-generated method stub
		String businessSegmentId = null;
		boolean found = false;
		try {
			conn=DataBaseConnection.getConnection();

			pst = conn.prepareStatement(InsuredDbQueries.GET_LOB_NAME);
			pst.setString(1, lineOfBusinessName);
			
			rs = pst.executeQuery();
			found = rs.next();
			if(found == true) {
				businessSegmentId = rs.getString(1);
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}
		return businessSegmentId;
	}
	
	
	@Override
	public boolean isUserExists(String userName) throws IQGSException {
		// TODO Auto-generated method stub
		boolean found = false;
		try {
			conn = DataBaseConnection.getConnection();

			pst = conn.prepareStatement(InsuredDbQueries.USER_EXISTS);
			pst.setString(1, userName);
			rs = pst.executeQuery();
			if(rs.next()) {
				found = true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}
        return found;
	}

	@Override
	public int accountCreation(Accounts account) throws IQGSException {
		// TODO Auto-generated method stub

		
		int isInserted = 0;
		try {
			conn=DataBaseConnection.getConnection();
			pst = conn.prepareStatement(InsuredDbQueries.ACCOUNT_CREATION);
			pst.setString(1, account.getInsuredName());
			pst.setString(2, account.getInsuredStreet());
			pst.setString(3, account.getInsuredCity());
			pst.setString(4, account.getInsuredState());
			pst.setInt(5, account.getInsuredZip());
			pst.setString(6, account.getLineOfBusiness());
			pst.setString(7, account.getUserName());
			
			isInserted = pst.executeUpdate();
			

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}
		
		return isInserted;
	}



	@Override
	public List<Policy> getInsuredPolicies(int accno) throws IQGSException {
		// TODO Auto-generated method stub
		List<Policy> policies = new ArrayList<Policy>();
		Policy policy;
		try {
			conn = DataBaseConnection.getConnection();
			pst = conn.prepareStatement(InsuredDbQueries.GET_INSURED_POLICY);	
			pst.setInt(1, accno);
			rs = pst.executeQuery();
			while(rs.next()) {
				policy = new Policy();
				policy.setPolicyNumber(rs.getInt(1));
				policy.setPolicyPremium(rs.getDouble(2));
				policy.setAccNumber(rs.getInt(3));
				policies.add(policy);
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		finally {
			try
			{
				pst.close();
				conn.close();
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}		
		return policies;
}



	@Override
	public int getAccountNumber(String username) throws IQGSException {
		// TODO Auto-generated method stub
		int accNo = 0;
		try {
			conn = DataBaseConnection.getConnection();

			pst = conn.prepareStatement(InsuredDbQueries.GET_ACCOUNT_NUMBER);
			pst.setString(1, username);
			
			rs = pst.executeQuery();
			if(rs.next()) {
				
				accNo = rs.getInt(1);
				
			}
			else {
				System.out.println("No Account so please create one");
			}
		} catch (SQLException e) {
			throw new IQGSException("problem while creating PS object");
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new IQGSException("problem while closing");
			}

		}
        return accNo;

	}


	@Override
	public Accounts getAccountDetails(Integer accNumber) throws IQGSException {
		// TODO Auto-generated method stub
		Accounts account = new Accounts();
		try {
			conn =DataBaseConnection.getConnection();
			pst= conn.prepareStatement(InsuredDbQueries.GET_ACCOUNT_DETAILS);	
			pst.setInt(1, accNumber);
			rs = pst.executeQuery();

			if(rs.next()) {
				account.setAccountNumber(rs.getInt(1));
				account.setInsuredName(rs.getString(2));
				account.setInsuredStreet(rs.getString(3));
				account.setInsuredCity(rs.getString(4));
				account.setInsuredState(rs.getString(5));
				account.setInsuredZip(rs.getInt(6));
				account.setLineOfBusiness(rs.getString(7));
				
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		finally {
			try
			{
				pst.close();
				conn.close();
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}		
		
		return account;
	}

	@Override
	public String getBusSegName(String busSegId) throws IQGSException {
		// TODO Auto-generated method stub
		String busSegName = null;
		try {
			conn = DataBaseConnection.getConnection();

			pst = conn.prepareStatement(InsuredDbQueries.GET_BUS_SEG_NAME);
			pst.setString(1, busSegId);
			rs = pst.executeQuery();
			if(rs.next()) {
				busSegName = rs.getString(1);
				System.out.println("Getting business segment id :" + busSegName);
			}
		} catch (SQLException e) {
			throw new IQGSException("problem while creating PS object"+e.getMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new IQGSException("problem while closing");
			}

		}
		//System.out.println(busSegName);
		return busSegName;
	}
	@Override
	public Double getPolicyPremium(Integer polNum) throws IQGSException {
		// TODO Auto-generated method stub
		Double polPremium = 0.0;
		try {
			conn = DataBaseConnection.getConnection();

			pst = conn.prepareStatement(InsuredDbQueries.GET_POLICY_PREMIUM);
			pst.setInt(1, polNum);
			rs = pst.executeQuery();
			if(rs.next()) {
				polPremium = rs.getDouble(1);
				System.out.println("Getting policy premium: " + polPremium);
			}
		} catch (SQLException e) {
			throw new IQGSException("problem while creating PS object"+e.getMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new IQGSException("problem while closing");
			}

		}
		System.out.println("policy premium in dao is : " + polPremium);
		return polPremium;
	}

	@Override
	public  List<String> getSelectedAnswers(Integer polNum) throws IQGSException {
		// TODO Auto-generated method stub
		List<String> selectedAns = new ArrayList<String>();
		PolicyDetails details = null;
		boolean isFound = false;
		conn = DataBaseConnection.getConnection();
		try {
			
			pst = conn.prepareStatement(InsuredDbQueries.GET_SELECTED_ANSWERS);
			pst.setInt(1, polNum);
			rs = pst.executeQuery();
			//System.out.println("policy number : "+polNum);
			while(rs.next()) {
				selectedAns.add(rs.getString(1));
			}
		} catch (SQLException e) {
			throw new IQGSException("problem while creating PS object "+e.getMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new IQGSException("problem while closing");
			}

		}
		System.out.println("Inside dao answers are:"+selectedAns);
		return selectedAns;
	}


	@Override
	public List<PolicyQuestions> getPolicyQuestions(String lineOfBusinessId) throws IQGSException {
		// TODO Auto-generated method stub
		List<PolicyQuestions> policyQuestions = new ArrayList<PolicyQuestions>();
		PolicyQuestions polQues = null;
		try {
			conn = DataBaseConnection.getConnection();
			System.out.println(lineOfBusinessId);
			pst = conn.prepareStatement(AdminQueries.GET_POLICY_QUESTIONS);
			pst.setString(1, lineOfBusinessId);
			rs = pst.executeQuery();
			while(rs.next()) {
				polQues = new PolicyQuestions();
				polQues.setPolQuesId(rs.getString(1));
				polQues.setPolQuesSeq(rs.getInt(2));
				polQues.setBusSegId(rs.getString(3));
				polQues.setPolQuesDesc(rs.getString(4));
				polQues.setPolQuesAns1(rs.getString(5));
				polQues.setPolQuesAns1Weightage(rs.getInt(6));
				polQues.setPolQuesAns2(rs.getString(7));
				polQues.setPolQuesAns2Weightage(rs.getInt(8));
				polQues.setPolQuesAns3(rs.getString(9));
				polQues.setPolQuesAns3Weightage(rs.getInt(10));
				policyQuestions.add(polQues);
			}
		} catch (SQLException e) {
			throw new IQGSException("problem while creating PS object"+e.getMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new IQGSException("problem while closing");
			}

		}
		System.out.println(policyQuestions);
		return policyQuestions;

	}
	
}



