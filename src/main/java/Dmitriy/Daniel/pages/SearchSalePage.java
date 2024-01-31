package dmitriy.daniel.CRM.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SearchSalePage {
    private final Page page;
    private final Locator btnCreateCase;
    private final Locator btnSearchSales;
    private final Locator fillConfirmationNumberBookingID;


    public SearchSalePage(Page page) {
        this.page = page;

        this.btnCreateCase = page.locator("#w2 > table > tbody > tr > td:nth-child(12) > a:nth-child(3)");
        this.fillConfirmationNumberBookingID = page.locator("#salesearch-booking_id");
        this.btnSearchSales = page.locator("#w1 > div:nth-child(2) > div > div > button");
    }



    public SearchSalePage fillConfirmationNumberBookingID(String value){
        fillConfirmationNumberBookingID.fill(value);
        return this;
    }

    public SearchSalePage clickbtnSearchSales(){
        btnSearchSales.click();
        return this;
    }

    public SearchSalePage clickBtnCreateCase(){
        btnCreateCase.click();
        return this;
    }


}
