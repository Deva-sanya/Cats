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
        Cat cat = catDaoImplementation.getById(id);
        return cat;
    }

    public User getByLogin(String login) {
        User user = catDaoImplementation.getByLogin(login);
        return user;
    }

    public List<Cat> createMothersList () {
        List<Cat> mothersList = catDaoImplementation.createMothersList();
        //printListOfMothers(mothersList);
        return  mothersList;
    }

    public List<Cat> createFathersList () {
        List<Cat> fathersList = catDaoImplementation.createFathersList();
        //printListOfFathers(fathersList);
        return  fathersList;
    }

    @Override
    public List<Cat> getAll() {
        List<Cat> cats = catDaoImplementation.getAll();//вызываем обьект дао из сервиса так как сервис это между
        printList(cats);
        return cats;
    }

    /*public ResultSet checkParent(Long fatherId) throws SQLException {
        return catDaoImplementation.checkParent(fatherId);
    }*/


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
        List<Cat> cats = catDaoImplementation.getByName(name);
        //printList(cats);
        return null;
    }

    public List<Cat> getFatherNameById(Long fatherId) {
        List<Cat> cats = catDaoImplementation.getFatherNameById(fatherId);
        return null;
    }

    public List<Cat> getByColor(String color) {
        List<Cat> cats = catDaoImplementation.getByColor(color);
        //printList(cats);
        return cats;
    }

    public void findChildren(Long id) {
        List<Cat> cats = catDaoImplementation.findChildren(id);
        List<String> catsName = new ArrayList<>();
        for (Cat cat : cats) {
            catsName.add(cat.getName());
        }
        System.out.println("Parent: " + "Id:" + " " + cats.get(0).getFatherId() + " " + " " + "Children:" + " " + catsName);
    }

    public  void printList(List<Cat> cats) {
        for (Cat cat : cats) {
            System.out.println("Cat: " + "Id:" + " " + cat.getId() + " " + "Age:" + " " + cat.getAge()
                    + " " + "fatherId:" + " " + cat.getFatherId() + " " + " " + "motherId:" + " " + cat.getMotherId() + " " +
                    "Name:" + cat.getName() + " " + "Color:" + " " +
                    " " + cat.getColor() + " " + "Gender:" + " " + cat.getGender());
        }
    }
    /*public  void printListOfMothers(List<Cat> mothersList) {
        for (Cat cat : mothersList) {
            System.out.println("Cat: " + " " + cat.getName() + " " + "Age:" + " " + cat.getAge());
        }
    }*/
}
