
package cats.dao;

import cats.model.Cat;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
public interface CatDao {
    Cat getById(Long id) throws SQLException, ClassNotFoundException;
    List<Cat> getAll() throws ClassNotFoundException;
    Cat createCat(Cat cat) throws SQLException, ClassNotFoundException, IOException;

    Cat update(Cat cat) throws ClassNotFoundException;
    boolean deleteById(Long id) throws ClassNotFoundException;

}