package com.example.videorentalsystem;

import java.sql.*;
import java.util.Scanner;

public class VideoDTO {
    String vid_title;
    int vid_number;
    String vid_description;
    String vid_category;
    String vid_actor;
    String lang;
    //비디오 제목 비디오 설명 비디오 카테고리 비디오 출연배우 지원언어
    Connection connection;
    String query = "SELECT * FROM `FILM`";
    PreparedStatement pstmt;
    ResultSet resultset;
    Scanner scan = new Scanner(System.in);

    public VideoDTO() {
        String address = "jdbc:mysql://localhost/sakila";
        String username = "root";
        String password = "1111";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(address, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getVid_title(int selectnumber) {
        try {
            pstmt = connection.prepareStatement(query);
            query =  "select title from film inner join inventory where film.film_id ="+ selectnumber;
            resultset = pstmt.executeQuery(query);
            while(resultset.next()){
               vid_title = resultset.getString(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } return vid_title;
    }

    public String getVid_description(int selectnumber) {
        try {
            query = "select description from film inner join inventory where film.film_id ="+ selectnumber;
            pstmt = connection.prepareStatement(query);
            resultset = pstmt.executeQuery();
            while(resultset.next()){
                vid_description = resultset.getString(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } return vid_description;
    }


    public String getVid_category(int selectnumber) {
        try {
            query = "select name from film_category as a inner join category as b on a.category_id=b.category_id where a.film_id ="+ selectnumber;
            pstmt = connection.prepareStatement(query);

            resultset = pstmt.executeQuery();
            while(resultset.next()){
                vid_category = resultset.getString(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } return vid_category;
    }

    public String getVid_actor(int selectnumber) {
        try {
            query = "select first_name, last_name from sakila.actor a inner join sakila.film_actor b on a.actor_id = b.actor_id where film_id ="+ selectnumber;
            pstmt = connection.prepareStatement(query);
            resultset = pstmt.executeQuery();
            while(resultset.next()){
                vid_actor= resultset.getString(1);
                vid_actor += (" " + resultset.getString(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } return vid_actor;
    }

    public String getLang(int selectnumber) {
        try {

            query = "select name from sakila.language a  join sakila.film b on a.language_id = b.language_id where film_id =" + selectnumber;
            pstmt = connection.prepareStatement(query);
            resultset = pstmt.executeQuery();
            while(resultset.next()){
                lang = resultset.getString(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lang;
    }

}
