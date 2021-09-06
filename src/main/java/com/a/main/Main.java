package com.a.main;

import java.sql.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        run();
//        while(true) {
//            Date date = new Date();
//            if (date.getHours() == 12 || date.getHours() == 6) {
//                run();
//            } else {
//                try {
//                    TimeUnit.HOURS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        post.postMessage("19407060121","https://ehallplatform.xust.edu.cn/default/jkdk/mobile/mobJkdkAdd.jsp?uid=NEMwNUU4QzM0MEY2MjY5QTNGMEY2MzVDRTk0Q0RFNjg=");

//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
//        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 1);
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(calendar.getTime()));

    }

    public static void run() {
        LinkedList<Student> list = new LinkedList<Student>();
        String url = "jdbc:mysql://111.229.238.150:3306/community_street";
        String username = "root";
        String password = "123456";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            Statement st = conn.createStatement();
            String sql = "select * from student";
            ResultSet resultSet = st.executeQuery(sql);
            resultSet.first();
            list.addFirst(new Student(resultSet.getString("xh"),resultSet.getString("url")));
            while (resultSet.next()) {
                list.addLast(new Student(resultSet.getString("xh"),resultSet.getString("url")));
            }
            for (Student student: list) {
                try {
                    post.postMessage(student.getXh(),student.getUrl());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(student.getXh());
                System.out.println(student.getUrl());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
