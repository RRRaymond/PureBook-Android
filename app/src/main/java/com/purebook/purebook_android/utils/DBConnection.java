package com.purebook.purebook_android.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by chrischen on 2017/12/26.
 */

public class DBConnection {
    public static String ip= "47.100.25.190";
    public static String dbName = "purebookDB";
    private static final String url = "jdbc:mysql://" + ip + "/"+dbName;
    public static String dbUser = "guest";
    public static String dbPassword = "tj1552702";
    public static String port = "3306";

    private Connection connection;


}
