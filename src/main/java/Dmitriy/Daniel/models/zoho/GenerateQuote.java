package Dmitriy.Daniel.models.zoho;

import lombok.Data;

import java.util.List;

@Data
public class GenerateQuote {
    private Integer chatId;
    private List<Integer> quotesIds;
}
