package com.insure.quote.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.insure.quote.dto.Policy;
import com.insure.quote.exception.IQGSException;
import com.insure.quote.service.InsuredService;
import com.insure.quote.service.InsuredServiceImpl;

@WebServlet("/InsuredViewPolicy")
public class InsuredViewPolicy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InsuredService service = new InsuredServiceImpl();
		PrintWriter out = response.getWriter();
		
		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession();
		try {
			String username = (String)session.getAttribute("username");
			System.out.println(username);
			int accNo = service.getAccountNumber(username);
			List<Policy> policies = service.getInsuredPolicies(accNo);
			System.out.println("policies size : "+policies.size());
			if(policies.size() > 0) {
				request.setAttribute("policies", policies);
			
				dispatcher = request.getRequestDispatcher("PolicyCreation.jsp");
				dispatcher.include(request, response);
		
			}
			
			else {
				out.println("Policies does not exists.. ");
				/*dispatcher = request.getRequestDispatcher("insurerhome.html");
				dispatcher.include(request, response);*/
							
			}
		}catch (IQGSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	}

