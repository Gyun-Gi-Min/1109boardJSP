package com.koreait.board;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/detail")
public class BoardDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        BoardVO aa= new BoardVO();

        int bb = Integer.parseInt(req.getParameter("iboard"));
        aa.setIboard(bb);

        BoardVO vo = BoardDAO.selBoardDetail(aa);
        req.setAttribute("data",vo);

        String path = "/WEB-INF/jsp/detail.jsp";
        RequestDispatcher rd = req.getRequestDispatcher(path);
        rd.forward(req,res);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
