package cats.model;


import lombok.Getter;
import lombok.Setter;

public class Users {
    @Getter @Setter private String userId;
    @Getter @Setter private String login;
    @Getter @Setter private String password;
    public Users() {

    }
}