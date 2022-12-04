package cats.dao;

import cats.connector.DataBaseConnector;
import cats.model.Cat;
import cats.model.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class CatDaoImplementation implements CatDao {
    public static Logger logger = Logger.getLogger(CatDaoImplementation.class.getName());

    @Override
    public Cat getById(Long id) {
        Cat cat = new Cat();

        try (Connection connection = DataBaseConnector.getDBConnection()) {

            if (connection != null) {

                Statement st = connection.createStatement();//подключаюсь к базе
                ResultSet rs = st.executeQuery("SELECT * FROM  Cats where id=" + id);//запрос в базу

                while (rs.next()) {
                    cat = setCat(rs);//передаю результат в кота
                }
                if (cat.getId() != null) {//скипаю пустоту
                    return cat;
                }
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cat;
    }

    @Override
    public List<Cat> getAll() {
        List<Cat> cats = new ArrayList<>();

        try (Connection connection = DataBaseConnector.getDBConnection()) {
            if (connection != null) {
                PreparedStatement preparedStmt = connection.prepareStatement("SELECT * FROM Cats ORDER BY id");
                ResultSet rs = preparedStmt.executeQuery();

                while (rs.next()) {
                    Cat cat = setCat(rs);
                    cats.add(cat);
                }
                preparedStmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cats;
    }

    /*public ResultSet checkParent(Long fatherId) throws SQLException {

        try (Connection connection = DataBaseConnector.getDBConnection()) {
            if (connection != null) {

                Statement st = connection.createStatement();
                return st.executeQuery("SELECT id  FROM Cats WHERE id ='" + fatherId + "'AND gender = 'male'");
            } else {
                return null;
            }
        }
    }*/

    public List<Cat> createMothersList() {
        List<Cat> mothersList = new ArrayList<>();

        try (Connection connection = DataBaseConnector.getDBConnection()) {

            if (connection != null) {
                PreparedStatement preparedStmt = connection.prepareStatement("SELECT * FROM Cats WHERE LOWER(gender) LIKE '%female%' ORDER BY age ASC");
                ResultSet rs = preparedStmt.executeQuery();

                while (rs.next()) {
                    Cat cat = setCat(rs);
                    mothersList.add(cat);
                }
                preparedStmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mothersList;
    }

    public List<Cat> createFathersList() {
        List<Cat> fathersList = new ArrayList<>();

        try (Connection connection = DataBaseConnector.getDBConnection()) {

            if (connection != null) {
                PreparedStatement preparedStmt = connection.prepareStatement("SELECT * FROM Cats WHERE LOWER(gender) = 'male' ORDER BY age ASC");
                ResultSet rs = preparedStmt.executeQuery();

                while (rs.next()) {
                    Cat cat = setCat(rs);
                    fathersList.add(cat);
                }
                preparedStmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fathersList;
    }

    @Override
    public Cat createCat(Cat cat) throws SQLException {

        try (Connection connection = DataBaseConnector.getDBConnection()) {
            if (connection != null) {
                PreparedStatement insertSQL = connection.prepareStatement(
                        "INSERT INTO Cats (age, name,gender,fatherId, motherid, color) " +
                                "VALUES ( ?, ?, ?, ?, ?, ?)");

                insertSQL.setLong(1, cat.getAge());
                insertSQL.setString(2, cat.getName());
                insertSQL.setString(3, cat.getGender());
                insertSQL.setLong(4, cat.getFatherId());
                insertSQL.setLong(5, cat.getMotherId());
                insertSQL.setString(6, cat.getColor());

                try {
                insertSQL.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(" cat inserted");
            }
        }
        return cat;
    }

    public Users createUser(Users user) throws SQLException {

        try (Connection connection = DataBaseConnector.getDBConnection()) {
            if (connection != null) {
                PreparedStatement insertSQL = connection.prepareStatement(
                        "INSERT INTO users (login,password) " + "VALUES (?, ?)");

                insertSQL.setString(1, user.getLogin());
                insertSQL.setString(2, user.getPassword());

                try {
                    insertSQL.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException("You have page already.");
                }
                System.out.println("user insert.");
            }
        }
        return user;
    }

    @Override
    public Cat update(Cat cat) {

        try (Connection connection = DataBaseConnector.getDBConnection()) {
            if (connection != null) {

                PreparedStatement preparedStmt = connection.prepareStatement
                        ("UPDATE Cats SET age = ? , name = ? , gender = ? , color = ? WHERE id = ?");
                preparedStmt.setLong(1, cat.getAge());
                preparedStmt.setString(2, cat.getName());
                preparedStmt.setString(3, cat.getGender());
                preparedStmt.setString(4, cat.getColor());
                preparedStmt.setLong(5, cat.getId());

                preparedStmt.executeUpdate();
                System.out.println("Cat updated.");
                preparedStmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cat;
    }

    public List<Cat> getFatherNameById(Long fatherId) {

        List<Cat> cats = new ArrayList<>();

        try (Connection connection = DataBaseConnector.getDBConnection()) {
            Cat cat;
            if (connection != null) {

                PreparedStatement preparedStmt = connection.prepareStatement("SELECT * FROM Cats WHERE fatherid=" + fatherId);
                ResultSet rs = preparedStmt.executeQuery();

                while (rs.next()) {
                    cat = setCat(rs);//передаю результат в кота
                    cats.add(cat);
                }
                preparedStmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cats;
    }

    @Override
    public boolean deleteById(Long id) {

        try (Connection connection = DataBaseConnector.getDBConnection()) {

            if (connection != null) {
                PreparedStatement preparedStmt = connection.prepareStatement("DELETE FROM Cats WHERE id = ?");
                preparedStmt.setLong(1, id);

                preparedStmt.executeUpdate();
                System.out.println("Cat deleted.");
                preparedStmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Cat> getByName(String name) {
        List<Cat> cats = new ArrayList<>();

        try (Connection connection = DataBaseConnector.getDBConnection()) {
            Cat cat = new Cat();
            if (connection != null) {
                PreparedStatement preparedStmt = connection.prepareStatement("SELECT * FROM Cats WHERE LOWER(name) LIKE '%" + name + "%'");
                ResultSet rs = preparedStmt.executeQuery();

                while (rs.next()) {
                    cat = setCat(rs);
                    cats.add(cat);
                }
                if (cat.getName() != null) {
                    return cats;
                }
                preparedStmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cats;
    }

    public List<Cat> getByColor(String color) {

        List<Cat> cats = new ArrayList<>();

        try (Connection connection = DataBaseConnector.getDBConnection()) {
            Cat cat;
            if (connection != null) {

                PreparedStatement preparedStmt = connection.prepareStatement("SELECT * FROM Cats WHERE LOWER(color) LIKE '%" + color + "%'");
                ResultSet rs = preparedStmt.executeQuery();

                while (rs.next()) {
                    cat = setCat(rs);//передаю результат в кота
                    cats.add(cat);
                }
                preparedStmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cats;
    }


    public List<Cat> findChildren(Long id) {
        List<Cat> cats = new ArrayList<>();

        try (Connection connection = DataBaseConnector.getDBConnection()) {
            Cat cat = new Cat();
            if (connection != null) {
                PreparedStatement preparedStmt = connection.prepareStatement("SELECT * from Cats WHERE'" + id + "'IN (fathersId)");

                ResultSet rs = preparedStmt.executeQuery();
                while (rs.next()) {
                    cat = setCat(rs);//передаю результат в кота
                    cats.add(cat);
                }
                if (cat.getName() != null) {
                    return cats;
                } else {
                    System.out.println("Cat have no kids yet.");
                }
                preparedStmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cats;
    }

    private Cat setCat(ResultSet rs) throws SQLException {
        Cat cat = new Cat();
        cat.setId(rs.getLong("id"));
        cat.setName(rs.getString("name"));
        cat.setAge(rs.getLong("age"));
        cat.setGender(rs.getString("gender"));
        cat.setFatherId(rs.getLong("fatherId"));
        cat.setMotherId(rs.getLong("motherId"));
        cat.setColor(rs.getString("color"));
        return cat;
    }

    private Users setUser(ResultSet rs) throws SQLException {
        Users user = new Users();
        user.setLogin(rs.getString("login"));
        user.setLogin(rs.getString("password"));
        return user;
    }
}
