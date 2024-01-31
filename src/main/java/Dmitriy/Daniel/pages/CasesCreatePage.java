package dmitriy.daniel.CRM.pages;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.codeborne.selenide.Selenide.sleep;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CasesCreatePage {
    private final Page page;
    private final Faker faker;
    private final Locator webFormProjectID;
    private final Locator webFormDepID;
    private final Locator selectionCategoryID;
    private final Locator webFormSourceTypeID;
    private final Locator bookingID;
    private final Locator openAndSetWebFormClientphone;
    private final Locator openAndSetWebFormEmail;
    private final Locator subjectField;
    private final Locator descriptionField;
    private final Locator clickBtnCreateCase;

    private final String firstName;
    private final String midleName;
    private final String lastName;
    private final String contactEmail;


    public CasesCreatePage(Page page) {
        this.page = page;


        this.webFormProjectID = page.locator("#casescreatebywebform-projectid");
        this.webFormDepID = page.locator("#casescreatebywebform-depid");
        this.selectionCategoryID = page.locator("#select2-categoryId-container");
        this.webFormSourceTypeID = page.locator("#casescreatebywebform-sourcetypeid");
        this.bookingID = page.locator("#casescreatebywebform-orderuid");
        this.openAndSetWebFormClientphone = page.locator("#casescreatebywebform-clientphone");
        this.openAndSetWebFormEmail = page.locator("#casescreatebywebform-clientemail");
        this.subjectField = page.locator("#casescreatebywebform-subject");
        this.descriptionField = page.locator("#casescreatebywebform-description");
        this.clickBtnCreateCase = page.locator("#create-case-form-submit");


        this.faker = new Faker();
        this.firstName = faker.name().firstName();
        this.midleName = faker.name().name();
        this.lastName = faker.name().lastName();
        this.contactEmail = faker.internet().emailAddress();


    }


    public CasesCreatePage openFormProjectID() {
        webFormProjectID.click();
        return this;
    }

    public CasesCreatePage selectProjectID(String value) {
        webFormProjectID.selectOption(value);
        return this;
    }

    public CasesCreatePage openWebFormDepID() {
        webFormDepID.click();
        return this;
    }

    public CasesCreatePage selectionDepID(String value) {
        webFormDepID.selectOption(value);
        return this;
    }

    public CasesCreatePage selectionWebFormCategoryID(String value) {
//        selectionCategoryID.click();
//        sleep(5000);
//        page.getByRole(AriaRole.SEARCHBOX).type(value);
//        sleep(5000);
//        page.getByRole(AriaRole.SEARCHBOX).press("Enter");

        selectionCategoryID.click();
        selectionCategoryID.type(value);
        sleep(5000);
        selectionCategoryID.press("Enter");
        return this;
    }

    public CasesCreatePage openWebFormSourceTypeID() {
        webFormSourceTypeID.click();
        return this;
    }

    public CasesCreatePage selectionSourceTypeID(String value) {
        webFormSourceTypeID.selectOption(value);
        return this;
    }

    public CasesCreatePage bookingID(String value) {
        bookingID.fill(value);
        return this;
    }

    public CasesCreatePage openAndSetWebFormClientphone(String value) {
        openAndSetWebFormClientphone.fill(value);
        return this;
    }

    public CasesCreatePage openAndSetWebFormEmail(String value) {
        openAndSetWebFormEmail.fill(value);
        return this;
    }

    public CasesCreatePage fillInTheSubjectField(String value) {
        subjectField.fill(value);
        return this;
    }

    public CasesCreatePage fillInTheDescriptionField(String value) {
        descriptionField.fill(value);
        return this;
    }

    public CasesCreatePage clickBtnCreateCase() {
        clickBtnCreateCase.click();
        return this;
    }

    public CasesCreatePage assertCreateCase() {
        assertThat(page.locator("[id=\"w25\"]"));
        assertThat(page.locator(".status")).hasText("OVAGO");
        return this;
    }

}


//package dmitriy.daniel.CRM.pages;
//
//import Dmitriy.Daniel.config.InitialBrowser;
//import com.microsoft.playwright.Locator;
//import lombok.extern.slf4j.Slf4j;
//
//import static com.codeborne.selenide.Selenide.sleep;
//import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
//
//@Slf4j
//public class CasesCreatePage extends InitialBrowser {
//
//    private final Locator webFormProjectID = find("#casescreatebywebform-projectid");
//    private final Locator webFormDepID = find("#casescreatebywebform-depid");
//    private final Locator selectionCategoryID = find("#select2-categoryId-container");
//    private final Locator webFormSourceTypeID = find("#casescreatebywebform-sourcetypeid");
//    private final Locator bookingID = find("#casescreatebywebform-orderuid");
//    private final Locator openAndSetWebFormClientphone = find("#casescreatebywebform-clientphone");
//    private final Locator openAndSetWebFormEmail = find("#casescreatebywebform-clientemail");
//    private final Locator subjectField = find("#casescreatebywebform-subject");
//    private final Locator descriptionField = find("#casescreatebywebform-description");
//    private final Locator clickBtnCreateCase = find("#create-case-form-submit");
//
//
//    public CasesCreatePage openFormProjectID() {
//        webFormProjectID.click();
//        return this;
//    }
//
//    public CasesCreatePage selectProjectID(String value) {
//        webFormProjectID.selectOption(value);
//        return this;
//    }
//
//    public CasesCreatePage openWebFormDepID() {
//        webFormDepID.click();
//        return this;
//    }
//
//    public CasesCreatePage selectionDepID(String value) {
//        webFormDepID.selectOption(value);
//        return this;
//    }
//
//    public CasesCreatePage selectionWebFormCategoryID(String value) {
//        selectionCategoryID.click();
//        page.locator("css=#select2-categoryId-container").type(value);
//        sleep(800);
//        page.locator("css=#select2-categoryId-container").press("Enter");
//
//        return this;
//    }
//
//    public CasesCreatePage openWebFormSourceTypeID() {
//        webFormSourceTypeID.click();
//        return this;
//    }
//
//    public CasesCreatePage selectionSourceTypeID(String value) {
//        webFormSourceTypeID.selectOption(value);
//        return this;
//    }
//
//    public CasesCreatePage bookingID(String value) {
//        bookingID.fill(value);
//        return this;
//    }
//
//    public CasesCreatePage openAndSetWebFormClientphone(String value) {
//        openAndSetWebFormClientphone.fill(value);
//        return this;
//    }
//
//    public CasesCreatePage openAndSetWebFormEmail(String value) {
//        openAndSetWebFormEmail.fill(value);
//        return this;
//    }
//    public CasesCreatePage fillInTheSubjectField(String value){
//        subjectField.fill(value);
//        return this;
//    }
//    public CasesCreatePage fillInTheDescriptionField(String value){
//        descriptionField.fill(value);
//        return this;
//    }
//
//    public CasesCreatePage clickBtnCreateCase() {
//        clickBtnCreateCase.click();
//        return this;
//    }
//    public CasesCreatePage assertCreateCase() {
//        assertThat(page.locator("[id=\"w25\"]"));
//        assertThat(page.locator(".status")).hasText("OVAGO");
//        return this;
//    }
//
//}
