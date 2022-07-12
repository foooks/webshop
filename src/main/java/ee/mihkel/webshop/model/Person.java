package ee.mihkel.webshop.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Person {
    @Id
    private String personCode;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phoneNumber;
}
