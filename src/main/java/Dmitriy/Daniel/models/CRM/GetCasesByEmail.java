package Dmitriy.Daniel.models.CRM;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetCasesByEmail {

    @Data
    public static class CasesByEmailParams {

        public String contact_email = "danelukdv@gmail.com";
        public int active_only = 1;
        public String department_key = "support";
        public String project_key = "ovago";
        public int results_limit = 10;
    }

}
