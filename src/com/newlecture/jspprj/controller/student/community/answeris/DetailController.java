package com.newlecture.jspprj.controller.student.community.answeris;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.jspprj.dao.AnswerisDao;
import com.newlecture.jspprj.dao.jdbc.JdbcAnswerisDao;
import com.newlecture.jspprj.entity.AnswerisView;

@WebServlet("/student/community/answeris/detail")
public class DetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");

		AnswerisDao answerisDao = new JdbcAnswerisDao();
		AnswerisView answeris = answerisDao.get(id);
		
		//주의!, request로 값을 넘겨줄때 객체타입은 오브젝트 타입으로 반환되므로 반드시 형변환하여 사용해야한다.
		request.setAttribute("answeris", answeris);
		
		//다음 서블릿으로 포워드 하는 방식
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/student/community/answeris/detail.jsp");
		dispatcher.forward(request, response);
	}
}
