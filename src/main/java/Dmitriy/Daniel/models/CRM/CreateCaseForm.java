package Dmitriy.Daniel.models.CRM;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateCaseForm {

    @Data
    public static class DataCase {

        public String contact_phone = "+380983421111";
        public String contact_email = "danelukdv1@gmail.com";
        public String category_key = "Exchange";
        public String category_id = null;
        public String order_uid = "92WS01W";
        public String subject = "Auto testing DmitriyD";
        public String description = "Description Auto testing DmitriyD";
        public String project_key = "ovago";
    }

}
