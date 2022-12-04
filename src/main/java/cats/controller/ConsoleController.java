package cats.controller;


import cats.connector.DataBaseConnector;
import cats.model.Cat;
import cats.model.Users;
import cats.service.CatServiceImplementation;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ConsoleController {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        CatServiceImplementation catsServices = new CatServiceImplementation();

        Cat cat = new Cat();
        Users user = new Users();
        Scanner scan = new Scanner(System.in);
        int x = 0;
        int s;

        DataBaseConnector dbc = new DataBaseConnector();
        dbc.getDBConnection();

        while (true) {

            System.out.println("1. To display information about all cats, enter 1.");
            System.out.println("2. Enter 2 to add a new cat.");
            System.out.println("3. Type 3 to display information about the cat.");
            System.out.println("4. Type 4 add attribute to cat.");
            System.out.println("5. Type 5 to delete cat.");
            System.out.println("6. Type 6 to find cat by its name.");
            System.out.println("7. Type 7 to find children of the cat.");
            System.out.println("8. Type 8 to find cat by its color.");
            System.out.println("9. Type 9 to add user.");

            s = scan.nextInt();

            try {
                x = Integer.parseInt(String.valueOf(s));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
            }

            switch (x) {
                case 1:
                    catsServices.getAll();
                    break;
                case 2:
                    System.out.println("Enter the id of the cat.");
                    Long id = scan.nextLong();
                    cat.setId(id);

                    System.out.println("Enter the age of the cat.");
                    Long age = scan.nextLong();
                    scan.nextLine();
                    cat.setAge(age);

                    System.out.println("Enter the name of the cat.");
                    String name = scan.nextLine();
                    cat.setName(name);

                    System.out.println("Enter the gender of the cat.");
                    String gender = scan.nextLine();
                    cat.setGender(gender);

                    System.out.println("Enter the fathersId of the cat.");
                    Long fathersId = scan.nextLong();
                    scan.nextLine();

                    /*ResultSet rs = catsServices.checkParent(fathersId);
                    while(!rs.next()) {
                        System.out.println("Cat is female not male.");
                        System.out.println("Enter the fathersId of the cat.");
                        fathersId = scan.nextLong();
                        rs = catsServices.checkParent(fathersId);
                    }
                    cat.setFathersId(fathersId);*/

                    System.out.println("Enter the mothers id of the cat.");
                    Long motherId = scan.nextLong();
                    cat.setMotherId(motherId);

                    System.out.println("Enter the color of the cat.");
                    String color = scan.nextLine();
                    cat.setColor(color);
                    catsServices.createCat(cat);
                    break;
                case 3:
                    System.out.println("Enter the id of the cat.");
                    id = scan.nextLong();//считываю айди
                    scan.nextLine();
                    cat.setId(id);

                    catsServices.getById(cat.getId());
                    break;
                case 4:
                    System.out.println("Enter the id of the cat.");
                    id = scan.nextLong();
                    scan.nextLine();
                    cat.setId(id);

                    System.out.println("Enter the color of the cat with id:" + id);
                    age = scan.nextLong();
                    name = scan.nextLine();
                    gender = scan.nextLine();
                    color = scan.nextLine();

                    cat.setAge(age);
                    cat.setName(name);
                    cat.setGender(gender);
                    cat.setColor(color);

                    catsServices.update(cat);
                    break;
                case 5:
                    System.out.println("Enter the id of the cat.");
                    id = scan.nextLong();//считываю айди
                    cat.setId(id);

                    catsServices.deleteById(id);
                    break;
                case 6:
                    System.out.println("Enter the name of the cat.");
                    name = scan.nextLine();
                    cat.setName(name.toLowerCase());

                    catsServices.getByName(name);
                    break;
                case 7:
                    System.out.println("Enter id of the cat to select information about its children.");
                    id = scan.nextLong();
                    cat.setFatherId(id);

                    catsServices.findChildren(id);
                    break;
                case 8:
                    System.out.println("Enter the color of the cat.");
                    color = scan.nextLine();
                    color = color.toLowerCase();
                    cat.setColor(color);

                    catsServices.getByColor(cat.getColor());
                    break;
                case 9:
                    System.out.println("Enter the login");
                    String login = scan.nextLine();
                    scan.nextLine();
                    user.setLogin(login);

                    System.out.println("Enter the password.");
                    String password = scan.nextLine();
                    scan.nextLine();
                    user.setPassword(password);

                    catsServices.createUser(user);
                    break;
                /*case 10:
                    System.out.println("all mothers of cats.");
                    catsServices.createMothersList();
                case 11:
                    System.out.println("Enter father Id.");
                    Long fatherId = scan.nextLong();
                    cat.setFatherId(fatherId);

                    catsServices.getFatherNameById(fatherId);
                    break;*/
                default:
                    if (s >= 15) {
                        System.out.println("Invalid input.");
                        break;
                    }
            }
        }
    }
}