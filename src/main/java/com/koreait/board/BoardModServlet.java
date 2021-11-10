package com.koreait.board;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mod")
public class BoardModServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String strIboard = req.getParameter("iboard");
        int iboard = Integer.parseInt(strIboard);

        BoardVO param = new BoardVO();
        param.setIboard(iboard);
        BoardVO data = BoardDAO.selBoardDetail(param);

        req.setAttribute("bbb", data);

        String path = "/WEB-INF/jsp/mod.jsp";
        req.getRequestDispatcher(path).forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    //수정 처리 //완료되면 디테일화면으로 이동
        String strIboard = req.getParameter("iboard");
        int iboard = Integer.parseInt(strIboard);
        String title = req.getParameter("title");
        String ctnt = req.getParameter("ctnt");
        String writer = req.getParameter("writer");

        System.out.println("title : " + title);
        System.out.println("ctnt : " + ctnt);
        System.out.println("writer : " + writer);

        BoardVO param = new BoardVO();

        param.setIboard(iboard);
        param.setTitle(title);
        param.setCtnt(ctnt);
        param.setWriter(writer);

        int result = BoardDAO.modBoard(param);
        System.out.println(result);

        switch (result){
            case 1:
                res.sendRedirect("/detail?iboard=" + strIboard);
                break;

        }


    }
}