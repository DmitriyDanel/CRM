package Dmitriy.Daniel.models.zoho;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetCaseZoho {
    public String caseGID = "";

    @Data
    @AllArgsConstructor
    public static class ZohoIQData {

        @Data
        public static class CreateChatForm {

            private String type;
            private String projectKey;
            private String projectSourceCid;
            private Data data;
        }

    //    @Data
    //
    //    public static class Data {
    //        private String rid = "213537545654" ;
    //        private int channel = 114;
    //        private int version = 1;
    //        private Owner owner ;
    //        private Visitor visitor;
    //        private Lead lead;
    //    }
    //
    //    @Data
    //
    //    static class Owner {
    //        private String id;
    //        private String name;
    //        private String email;
    //        private boolean isBot;
    //    }
    //
    //    @Data
    //
    //    static class Visitor {
    //        private String id;
    //        private String uuid;
    //        private String name;
    //        private String email;
    //        private String phone;
    //        private String countryCode;
    //        private String ip;
    //    }
    //
    //    @Data
    //
    //    static class Lead {
    //        private String uid;
    //        private String currency;
    //        private String tripType;
    //        private String cabin;
    //        private int adults;
    //        private int children;
    //        private int infants;
    //        private Flight[] flights;
    //    }
    //
    //    @Data
    //
    //    static class Flight {
    //        private String origin;
    //        private String destination;
    //        private String departure;
    //    }
    }
}
