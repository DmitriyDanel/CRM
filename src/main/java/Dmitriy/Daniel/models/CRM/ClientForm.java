package Dmitriy.Daniel.models.CRM;

import com.github.javafaker.Faker;
import lombok.Data;

@Data
public class ClientForm {
    public int type;
    public String email;

    public ClientForm() {
        Faker d = new Faker();
        email = d.internet().emailAddress();
        type = 1;
    }
}
