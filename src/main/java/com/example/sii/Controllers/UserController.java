package com.example.sii.Controllers;

import com.example.sii.Models.User;

import java.sql.*;

public class UserController {

    public void signInUser(User user) throws SQLException, ClassNotFoundException {

        //Making a connection to a database
        String url = "jdbc:h2:~/test";
        String usr = "sa";
        String passwd = "";
        Connection connection = DriverManager.getConnection(url,usr,passwd);

        boolean alreadyTaken = findUserByLogin(user.getLogin(),connection);

        if(alreadyTaken)
        {
            System.out.println("Login is already taken");
        }
        else
        {
            String sql = "INSERT INTO users(login, email, password) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
        }

    }

    private boolean findUserByLogin(String _login,Connection connection) throws ClassNotFoundException, SQLException {



        //Creating sql query that checks if there are any _login in users table
        String sql = "SELECT COUNT(*) AS count FROM users WHERE login = "+_login+ ";";
        Statement statement = connection.createStatement();
        ResultSet set = statement.executeQuery(sql);

        //Returning true if there is already that login in database;
        if(set.getInt("count") !=0 )
            return true;
        else
            return false;
    }

}
