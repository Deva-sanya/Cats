
package cats.service;

import cats.model.Cat;

import java.sql.SQLException;
import java.util.List;

public interface CatService {

    Cat getById(Long id) throws SQLException, ClassNotFoundException;
    List<Cat> getAll() throws ClassNotFoundException;
    Cat createCat(Cat cat) throws SQLException, ClassNotFoundException;
    Cat update(Cat cat) throws ClassNotFoundException;
    boolean deleteById(Long id) throws ClassNotFoundException;

}