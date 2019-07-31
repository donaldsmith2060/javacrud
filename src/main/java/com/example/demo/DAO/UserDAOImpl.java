package com.example.demo.DAO;
import com.example.demo.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class UserDAOImpl implements UserDAO{

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public void update(User user){
        if(user.getUserId()!=null){
            String sql = "update users set name= ? WHERE ID = ?";

            Connection conn = null;

            try {
                conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, user.getUserName());
                ps.setInt(2, user.getUserId());
                User employee = null;
                ps.executeUpdate();
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {}
                }
            }

        }else{
            insert(user);
        }
    }
    public void delete(User user){
        if(user.getUserId()!=null){
            String sql = "delete from users WHERE ID = ?";

            Connection conn = null;

            try {
                conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, user.getUserId());
                User employee = null;
                ps.executeUpdate();
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {}
                }
            }

        }else{
            insert(user);
        }
    }

    public void insert(User user){

        String sql = "INSERT into users(name) VALUES(?)";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }

    public User findById(int id){

        String sql = "SELECT * FROM users WHERE ID = ?";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            User employee = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                employee = new User(
                        rs.getInt("ID"),
                        rs.getString("NAME")
                );
            }
            rs.close();
            ps.close();
            return employee;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }
    public List<User> getAllUsers(){

        String sql = "SELECT * FROM users order by id asc";
        ArrayList<User> results=new ArrayList<User>();

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                User employee = new User(
                        rs.getInt("ID"),
                        rs.getString("NAME")
                );
                results.add(employee);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
        return results;
    }

}