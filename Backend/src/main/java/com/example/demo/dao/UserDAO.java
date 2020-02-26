package com.example.demo.dao;

import com.example.demo.dto.UserDTO;
import com.example.demo.utils.DBConnection;
import org.apache.logging.log4j.spi.LoggerRegistry;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO implements Serializable {

    private Connection conn;
    private PreparedStatement stm;
    private ResultSet rs;

    public void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public String checkLogin(String username, String password) throws Exception {
        String role = null;
        try {
            Connection con = DBConnection.createConnection();
            if (con != null) {
                String sql = "select Rolename\n" +
                        "from Account\n" +
                        "inner join Role on Role.Id = Account.roleid\n" +
                        "where Username = ? and Password = ? and status = 'active'";
                PreparedStatement stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                ResultSet rs = stm.executeQuery();

                if (rs.next()) {
                    role = rs.getString("Rolename");
                }
            }
        }  finally {
            closeConnection();
        }
        return role;
    }

    public List<UserDTO> getUserList() throws Exception{
        List<UserDTO> result = null;
        try {
            Connection con = DBConnection.createConnection();
            if (con != null) {
                result = new ArrayList<>();
                String username, role, password;

                String sql = "select Username, Password, Rolename\n" +
                        "from Account\n" +
                        "inner join Role on Role.Id = Account.roleid\n" +
                        "and status = 'active'";
                PreparedStatement stm = con.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();

                while (rs.next()) {
                    username = rs.getString("Username");
                    password = rs.getString("Password");
                    role = rs.getString("Rolename");
                    result.add(new UserDTO(username, role, password));
                }
            }
        }  finally {
            closeConnection();
        }
        return result;
    }
}
