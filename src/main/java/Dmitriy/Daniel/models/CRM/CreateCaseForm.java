package Dmitriy.Daniel.models.CRM;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateCaseForm {
    @Data
    public static class DataCase {

        public String contact_phone = "+380983429271";
        public String contact_email = "captain.maorgan@gmail.com";
        public String category_key = "Exchange";
        public String category_id = null;
        public String order_uid = "321654";
        public String subject = "Auto testing DmitriyD";
        public String description = "Description Auto testing DmitriyD";
        public String project_key = "ovago";
    }
}
