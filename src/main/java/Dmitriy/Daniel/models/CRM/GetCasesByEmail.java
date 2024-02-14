package Dmitriy.Daniel.models.CRM;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetCasesByEmail {
    @Data
    public static class CasesByEmailParams {
        public String contact_email;
        public int active_only;
        public String department_key;
        public String project_key;
        public int results_limit;

        public CasesByEmailParams() {
            contact_email = "danelukdv@gmail.com";
            active_only = 1;
            department_key = "support";
            project_key = "ovago";
            results_limit = 10;
        }
    }
}
