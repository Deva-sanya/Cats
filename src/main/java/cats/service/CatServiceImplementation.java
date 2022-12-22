package cats.service;

import cats.dao.CatDaoImplementation;
import cats.model.Cat;
import cats.model.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatServiceImplementation implements CatService {
    CatDaoImplementation catDaoImplementation = new CatDaoImplementation();

    @Override
    public Cat getById(Long id) {
        return catDaoImplementation.getById(id);
    }

    public User getByLogin(String login) {
        return catDaoImplementation.getByLogin(login);
    }

    public List<Cat> createMothersList() {
        return catDaoImplementation.createMothersList();
    }

    public List<Cat> createFathersList() {
        return catDaoImplementation.createFathersList();

    }

    @Override
    public List<Cat> getAll() {
        return catDaoImplementation.getAll();
    }

    @Override
    public Cat createCat(Cat cat) throws SQLException {
        return catDaoImplementation.createCat(cat);
    }

    public User createUser(User user) throws SQLException {
        return catDaoImplementation.createUser(user);
    }

    @Override
    public Cat update(Cat cat) {
        return catDaoImplementation.update(cat);
    }

    @Override
    public boolean deleteById(Long id) {
        return catDaoImplementation.deleteById(id);
    }

    public boolean deleteUser(String login) {
        return catDaoImplementation.deleteUser(login);
    }

    public List<Cat> getByName(String name) {
        return catDaoImplementation.getByName(name);
    }

    public List<Cat> getByColor(String color) {
        return catDaoImplementation.getByColor(color);

    }

    public void findChildren(Long id) {
        List<Cat> cats = catDaoImplementation.findChildren(id);
        List<String> catsName = new ArrayList<>();
        for (Cat cat : cats) {
            catsName.add(cat.getName());
        }
        System.out.println("Parent: " + "Id:" + " " + cats.get(0).getFatherId() + " " + " " + "Children:" + " " + catsName);
    }
}
