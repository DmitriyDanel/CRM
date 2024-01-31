package Dmitriy.Daniel.models.zoho;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class ObjectRequestLeadForm {

    public String type = "chat/create-v1";
    public String projectKey = "ovago";
    public String projectSourceCid = "I1B1L1";
    public DataBody data;

    public ObjectRequestLeadForm() {
        data = new DataBody();
    }

    @Data
    public static class DataBody {
        public String rid = "223537545129";
        public int channel = 1;
        public int version = 1;
        public Owner owner = new Owner();
        public Visitor visitor = new Visitor();
        public Lead lead = new Lead();
    }

    @Data
    public static class Owner {
        private String id = "799";
        private String name = "dmitriy.daniel.admin";
        private String email = "dmitriy.danel@kiv.dev";
        private boolean isBot = false;
    }

    @Data

    public static class Visitor {
        public String id;
        public String uuid;
        public String name;
        public String email;
        public String phone;
        public String countryCode;
        public String ip;

        public Visitor() {
            Faker d = new Faker();
            id = String.valueOf(d.random().nextInt(10000000, 99999999));
            uuid = String.valueOf(d.random().nextInt(10000000, 99999999))+ "-0000-0f0e-a00-captainblack";
            name = "Captain Morgan";
            email = d.internet().emailAddress();
            phone = "+38098" + d.random().nextInt(1000000, 9999999);
            countryCode = "UA";
            ip = "46.173.98.154";

        }
    }

    @Data
    public static class Lead {
        public String uid;
        public String currency = "USD";
        public String tripType = "OW";
        public String cabin = "E";
        public int adults = 1;
        public int children = 0;
        public int infants = 0;
        public List<Flight> flights;

        public Lead() {
            Faker d = new Faker();
            uid = String.valueOf(d.random().nextInt(1111111, 9999999)) + "cblack";
        }
    }

    @Data
    public static class Flight {
        public String origin;
        public String destination;
        public String departure;

        public Flight() {
            String patternNew = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patternNew);
            origin = "NYC";
            destination = "LAX";
            departure = simpleDateFormat.format(new Date().getTime());
        }
    }
}


