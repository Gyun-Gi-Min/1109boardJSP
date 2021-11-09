package com.koreait.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {

    public static int insBoard(BoardVO param){

        Connection con = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO t_board (title, ctnt, writer) VALUES (?, ?, ?)";

        try{

            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);

            ps.setString(1, param.getTitle());
            ps.setString(2, param.getCtnt());
            ps.setString(3, param.getWriter());

            return ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbUtils.close(con,ps);
        }

        return 0;
    }


    public  static List<BoardVO> selBoardList(){
        List<BoardVO> list = new ArrayList();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = " SELECT iboard, title, writer, rdt FROM t_board ORDER BY iboard DESC ";

        try{
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()) {
                BoardVO vo = new BoardVO();
                vo.setIboard(rs.getInt("iboard"));
                vo.setTitle(rs.getString("title"));
                vo.setWriter(rs.getString("writer"));
                vo.setRdt(rs.getString("rdt"));
                list.add(vo);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbUtils.close(con,ps,rs);
        }return list;

    }
    public static BoardVO selBoardDetail(BoardVO param){
        BoardVO vo = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT title, writer, rdt, ctnt from t_board where iboard = ? ";

        try{
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1,param.getIboard());
            rs = ps.executeQuery();
            //이까지 들어오면 1줄이다.
            if(rs.next()){
                vo = new BoardVO();
                vo.setTitle(rs.getString("title"));
                vo.setWriter(rs.getString("writer"));
                vo.setRdt(rs.getString("rdt"));
                vo.setCtnt(rs.getString("ctnt"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbUtils.close(con,ps,rs);
        }return vo;

    }






}
