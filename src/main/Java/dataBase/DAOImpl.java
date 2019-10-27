package dataBase;



import domain.User;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;


public class DAOImpl implements DAO {
    private String url = "jdbc:mysql://127.0.0.1:3306/tms?serverTimezone=Europe/Moscow&AllowPublicKeyRetrieval=True&useSSL=false";
    private String username = "root";
    private String password = "vlad";
    private Connection conn;
    public DAOImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(url, username, this.password);
            System.out.println("Success!!!");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public User getUserById(long userId) {
        String sql = "SELECT Id, Name,Email,Password,Gender FROM user WHERE Id = ?";
        User user = new User();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user.setId(resultSet.getLong("Id"));
                user.setName(resultSet.getString("Name"));
                user.setEmail(resultSet.getString("Email"));
                user.setPassword(resultSet.getString("Password"));
                user.setGender(resultSet.getString("Gender"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public boolean creat(User user) {
        String sql = "INSERT INTO user (Name, Email, Password, Gender) VALUE (?,?,?,?)";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getGender());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

       return true;
    }

    @Override
    public boolean delete(long id) {
        String sql = "DELETE FROM user WHERE id = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean update(User user,long id) {
        String sql = "UPDATE user SET Name = ?,Email = ?, Password = ?, Gender = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getGender());
            preparedStatement.setLong(5, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
