package Dmitriy.Daniel.models.CRM;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateCaseForm {

    @Data
    public static class DataCase {
        public String contact_phone;
        public String contact_email;
        public String category_key;
        public String category_id;
        public String order_uid;
        public String subject;
        public String description;
        public String project_key;

        public DataCase() {

            contact_phone = "+380983429271";
            contact_email = "captain.maorgan@gmail.com";
            category_key = "Exchange";
            category_id = null;
            order_uid = "321654";
            subject = "Auto testing DmitriyD";
            description = "Description Auto testing DmitriyD";
            project_key = "ovago";
        }
    }
}
//
//
//package Dmitriy.Daniel.models.CRM;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//
//@Data
//@AllArgsConstructor
//public class CreateCaseForm {
//
//    private String contact_email;
//    private String contact_phone;
//    private String category_key;
//    private String category_id;
//    private String order_uid;
//    private String subject;
//    private String description;
//    private String project_key;
//    private OrderInfo order_info;
//
//    @Data
//    @AllArgsConstructor
//    public static class OrderInfo {
//        private String departureDate;
//        private String departureAirport;
//    }
//}