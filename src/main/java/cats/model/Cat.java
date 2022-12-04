package cats.model;


import lombok.Getter;
import lombok.Setter;

public class Cat  {

    @Getter @Setter private Long id;
    @Getter @Setter private Long age;
    @Getter @Setter private String name;

    @Getter @Setter private Long fatherId;
    @Getter @Setter private Long motherId;

    @Getter @Setter private String gender;
    @Getter @Setter private String color;

    public Cat() {

    }
}