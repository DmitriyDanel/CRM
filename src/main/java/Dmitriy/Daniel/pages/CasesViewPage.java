package Dmitriy.Daniel.pages;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;


//AddEmail_________________________________________________________________Client Info

public class CasesViewPage {
    private final Page page;
    private final Locator btnAddEmailInClientInfoBlock;
    private final Locator inModalFillAddEmail;
    private final Locator inModalBtnAddEmail;
    private final Locator btnAddPhoneInClientInfoBlock;
    private final Locator addPhoneInForm;
    private final Locator inModalBtnAddPhone;
    //Send SMS________________________________________________________Communication
    private final Locator communicationTypeForm;
    private final Locator formSMSTemplate;
    private final Locator formPhonNumber;
    private final Locator btnSendSMS;
    private final Locator SMSInternalNoteField;
    private final Locator btnModalSendSMS;

    //Make Call________________________________________________________Communication
    private final Locator btnMakeCall;
    private final Locator formClientPhonNumber;

    //SendEmail________________________________________________________Communication
    private final Locator formEmailTemplate;
    private final Locator clickToPreviewAndSendEmailBtn;
    private final Locator clickToInternalNoteFieldEmail;
    private final Locator clickBtnSendEmail;
    private final Locator clickToBtnDetails;

    //UpdateUserForm________________________________________________________Client Info
    private final Locator clickBtnClientUpdate;
    private final Locator setClientUpdateFormFirstName;
    private final Locator setClientUpdateFormLastName;
    private final Locator setClientUpdateFormMiddleName;
    private final Locator setValueLocale;
    private final Locator setValueMarketingCountry;
    private final Locator btmUpdateModal;
    //General Info--------------------------------------------------------------------------------Update
    private final Locator btnGeneralInfoUpdate;
    private final Locator departmantToUpdateCaseForm;
    private final Locator updateDepartmantToUpdateCaseForm;
    private final Locator categoryToUpdateCaseForm;
    private final Locator inputCategoryToUpdateCaseForm;
    private final Locator bookingIdToUpdateCaseForm;
    private final Locator subjectToUpdateCaseForm;
    private final Locator descriptionToUpdateCaseForm;
    private final Locator btnUpdateGeneralInfoBlock;
    private final Locator errorSummaryUpdateCase;
    private final Locator btnCloseUpdateCase;

    //Fiels--------------------------------------------------------------------------------Update
    private final Locator btnUploadFiels;
    private final Locator btnBrowseInFileInputInsideModal;
    private final Locator btnUploadInFileInputInsideModal;

    //General Info Form
    private final Locator feldStatusNew;
    private final Locator feldStatusSuccess;
    private final Locator feldStatusPending;
    private final Locator fieldProject;
    private final Locator fieldsAgent;
    private final Locator fieldSourseType;
    private final Locator fieldBookingID;
    private final Locator fieldSubject;
    private final Locator fieldDescription;

    //Client Info Form
    private final Locator fieldPhone;
    private final Locator fieldEmail;

    // Change status
    private final Locator btnChangeStatus;
    private final Locator fieldStatusInChangeCaseStatusModal;
    private final Locator fieldSentToEmail;
    private final Locator fieldLanguageInChangeCaseStatusModal;

    private final Locator changeEmployeeInChangeCaseStatusModal;
    private final Locator ckickInModalBtnChangeStatus;
    private final Locator btnCloseCase;


//asserts

    private final Locator assertProject;

    public CasesViewPage(Page page) {
        this.page = page;

        this.assertProject = page.locator("#w0 > tbody > tr:nth-child(2) > td > span");

        this.btnAddEmailInClientInfoBlock = page.locator("#btn-add-email");
        this.inModalFillAddEmail = page.locator("#casesaddemailform-email");
        this.inModalBtnAddEmail = page.locator("#w0 > div.form-group.text-center > button");
        this.btnAddPhoneInClientInfoBlock = page.locator("#btn-add-phone");
        this.addPhoneInForm = page.locator("#casesaddphoneform-phone");
        this.inModalBtnAddPhone = page.locator("#w0 > div.form-group.text-center > button");

        this.communicationTypeForm = page.locator("#c_type_id");

        //Make Call________________________________________________________Communication
        this.btnMakeCall = page.locator("#btn-make-call-case-communication-block");
        this.formClientPhonNumber = page.locator("#client-phone-number-id");

        //Send SMS________________________________________________________Communication
        this.formSMSTemplate = page.locator("#c_sms_tpl_key");
        this.formPhonNumber = page.locator("#casecommunicationform-c_phone_number_id");
        this.btnSendSMS = page.locator("#sms-input-box > div.btn-wrapper > button");
        this.SMSInternalNoteField = page.locator("#casepreviewsmsform-internalnote");
        this.btnModalSendSMS = page.locator("#w12 > div.btn-wrapper.text-center > button");

        //SendEmail________________________________________________________Communication
        this.formEmailTemplate = page.locator("#c_email_tpl_key");
        this.clickToPreviewAndSendEmailBtn = page.locator("#preview_email_btn");
        this.clickToInternalNoteFieldEmail = page.locator("#casepreviewemailform-internalnote");
        this.clickBtnSendEmail = page.locator("#send_email_btn");

        this.clickToBtnDetails = page.locator("#list-wrapper > div:nth-child(3) > div.card-body > div.chat__message-footer > a");

        //UpdateUserForm________________________________________________________Client Info
        this.clickBtnClientUpdate = page.locator("#btn-client-update");
        this.setClientUpdateFormFirstName = page.locator("#casesclientupdateform-first_name");
        this.setClientUpdateFormLastName = page.locator("#casesclientupdateform-last_name");
        this.setClientUpdateFormMiddleName = page.locator("#casesclientupdateform-middle_name");
        this.setValueLocale = page.locator("#casesclientupdateform-locale");
        this.setValueMarketingCountry = page.locator("#casesclientupdateform-marketingcountry");
        this.btmUpdateModal = page.locator("#client-edit-name-form > div.form-group.text-center > button");

        //General Info--------------------------------------------------------------------------------Update
        this.btnGeneralInfoUpdate = page.locator("#btn-case-update");
        this.departmantToUpdateCaseForm = page.locator("#updateinfoform-depid");
        this.updateDepartmantToUpdateCaseForm = page.locator("#updateinfoform-depid > option:nth-child(4)");
        this.categoryToUpdateCaseForm = page.locator("#select2-categoryId-container");
        this.inputCategoryToUpdateCaseForm = page.locator("//*[@id=\"w0\"]/div[3]/div[1]/span/span[1]/span/span[2]");
        this.bookingIdToUpdateCaseForm = page.locator("#updateinfoform-orderuid");
        this.subjectToUpdateCaseForm = page.locator("#updateinfoform-subject");
        this.descriptionToUpdateCaseForm = page.locator("#updateinfoform-description");
        this.btnUpdateGeneralInfoBlock = page.locator("#w0 > div.form-group.text-center > button");
        this.errorSummaryUpdateCase = page.locator("#w0 > div.form-group.field-updateinfoform-orderuid.has-error > div");
        this.btnCloseUpdateCase = page.locator("#modal-md > div > div > div.modal-header > h3 > button");
        //Fiels--------------------------------------------------------------------------------Update
        this.btnUploadFiels = page.locator("body > div.container.body > div > div.right_col > div.row > div.col-md-12.col-sm-12.col-xs-12 > div.cases-view > div:nth-child(5) > div:nth-child(2) > div > div.x_title > ul > li:nth-child(1) > button");
        this.btnBrowseInFileInputInsideModal = page.locator("#uploadform-files");
        this.btnUploadInFileInputInsideModal = page.locator("#file-storage-upload-form-id > button");

        //General Info Form
        this.feldStatusNew = page.locator("#w0 > tbody > tr:nth-child(1) > td > span.badge.badge-info");
        this.feldStatusSuccess = page.locator("#w0 > tbody > tr:nth-child(1) > td"); //Open/Solved
        this.feldStatusPending = page.locator("#w0 > tbody > tr:nth-child(1) > td > span.badge.badge-warning");
        this.fieldProject = page.locator("#w0 > tbody > tr:nth-child(2) > td > span");
        this.fieldsAgent = page.locator("#w0 > tbody > tr:nth-child(3) > td");
        this.fieldSourseType = page.locator("#w0 > tbody > tr:nth-child(4) > td > span");
        this.fieldBookingID = page.locator("#caseBookingId");
        this.fieldSubject = page.locator("div:nth-child(1) > div > div.x_content > div > div.col-md-12 > h4:nth-child(3) > span");
        this.fieldDescription = page.locator("div:nth-child(1) > div > div.x_content > div > div.col-md-12 > pre");

        //Client Info Form
        this.fieldPhone = page.locator("#w3 > tbody > tr:nth-child(2) > td > div > code");
        this.fieldEmail = page.locator("#w3 > tbody > tr:nth-child(3) > td > div > code");

        //Change status
        this.btnChangeStatus = page.locator("#btn-change-status");
        this.fieldStatusInChangeCaseStatusModal = page.locator("#caseschangestatusform-statusid");
        this.fieldSentToEmail = page.locator("#caseschangestatusform-sendto");
        this.fieldLanguageInChangeCaseStatusModal = page.locator("#caseschangestatusform-language");
        this.changeEmployeeInChangeCaseStatusModal = page.locator("#caseschangestatusform-userid");
        this.ckickInModalBtnChangeStatus = page.locator("#change-status-form-id > div.form-group.text-center > button");
        this.btnCloseCase = page.locator("body > div.container.body > div > div.right_col > div.row > div.col-md-12.col-sm-12.col-xs-12 > div.cases-view > div.x_panel > div > a.add-reason.btn.btn-danger");


    }

    //Asserts
    public CasesViewPage assertGeneralInfoUpdate() {

        page.reload();
        Assert.assertTrue(feldStatusNew.textContent().contains("New"));
        Assert.assertTrue(fieldProject.textContent().contains("OVAGO"));
        Assert.assertTrue(fieldBookingID.textContent().contains("654321"));
        Assert.assertTrue(fieldSubject.textContent().contains("updateSubjectAutoTest"));
        Assert.assertTrue(fieldDescription.textContent().contains("updateDescriptionAutoTest"));

        return this;
    }

    public CasesViewPage assertGeneralInfoUpdateNegativeScenario() {
        Assert.assertTrue(errorSummaryUpdateCase.textContent().contains("Booking ID is invalid."));


        return this;
    }

    public CasesViewPage assertNewCaseCreate() {
        page.waitForTimeout(3000);
        page.reload();
        Assert.assertTrue(feldStatusNew.textContent().contains("New"));
        Assert.assertTrue(fieldProject.textContent().contains("OVAGO"));
        Assert.assertTrue(fieldSubject.textContent().contains("autoTest"));
        Assert.assertTrue(fieldDescription.textContent().contains("Test_Dmitriy.Danel"));
        Assert.assertTrue(fieldsAgent.textContent().contains(" dmitriy.daniel.admin"));
        return this;
    }

    public CasesViewPage assertChangedFromNewToStatusOpen() {
        page.reload();
        Assert.assertTrue(feldStatusSuccess.textContent().contains("Open"));
        return this;
    }

    public CasesViewPage assertChangedFromNewToStatusSolved() {
        page.reload();
        Assert.assertTrue(feldStatusSuccess.textContent().contains("Solved"));
        return this;
    }

    public CasesViewPage assertChangedFromOpenToStatusPending() {
        page.reload();
        Assert.assertTrue(feldStatusPending.textContent().contains("Pending"));
        Assert.assertTrue(fieldsAgent.textContent().contains("dmitriy.daniel.CX"));
        return this;
    }

    public CasesViewPage assertUpdateClientInfo() {
        Assert.assertTrue(page.locator("#w3 > tbody > tr:nth-child(2) > td").textContent().contains("Jack"));
        Assert.assertTrue(page.locator("#w3 > tbody > tr:nth-child(3) > td").textContent().contains("Capt"));
        Assert.assertTrue(page.locator("#w2 > a").textContent().contains("S*****w"));
        Assert.assertTrue(page.locator("#w3 > tbody > tr:nth-child(6) > td > span").textContent().contains("uk-UA"));
        Assert.assertTrue(page.locator("[class=js_marketing_country]").textContent().contains("AD"));
        return this;
    }

    public CasesViewPage assertUpdateClientWithRequiredAndOptionalFieldsValidData() {
        Assert.assertTrue(page.locator("#w3 > tbody > tr:nth-child(2) > td").textContent().contains("Black"));
        Assert.assertTrue(page.locator("#w3 > tbody > tr:nth-child(3) > td").textContent().contains("Captain"));
        Assert.assertTrue(page.locator("#w2 > a").textContent().contains("***w"));
        return this;
    }

    public CasesViewPage assertUpdateClientOnlyFirstNameFields() {
        page.waitForTimeout(2000);
        Assert.assertTrue(page.locator("#pjax-client-info > div > div.x_content > div > div.col-md-5").textContent().contains("Gold"));
        return this;
    }

    public CasesViewPage assertCaseAddPhoneToClientInfoBlock() {
        Assert.assertTrue(page.locator("#pjax-client-info > div > div.x_content").textContent().contains("+380******271"));
        return this;
    }

    public CasesViewPage assertCaseAddPhoneToClientInfoBlockNegativeScenario() {
        Assert.assertTrue(page.locator("#modalCaseSm > div > div").textContent().contains("The format of Phone is invalid."));
        return this;
    }

    public CasesViewPage assertAddEmailToClientInfoBlock() {
//        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add********@mail.com")).click();
        Assert.assertTrue(page.locator("#w4 > tbody > tr:nth-child(3)").textContent().contains("Add********@mail.com"));
        return this;
    }

    public CasesViewPage assertAddEmailToClientInfoBlockNegativeScenario() {
        Assert.assertTrue(page.locator("#w0 > div.form-group.field-casesaddemailform-email.required.has-error > div.help-block").textContent().contains("Email is not a valid email address."));
        reload();
        return this;
    }

    public CasesViewPage assertStatusHistory() {
        Assert.assertTrue(page.locator("#w0 > table > tbody > tr > td:nth-child(3) > span").textContent().contains("New"));
        Assert.assertTrue(page.locator("#w0 > table > tbody > tr > td:nth-child(9)").textContent().contains("Created by web"));
        Assert.assertTrue(page.locator("#w0 > table > tbody > tr > td:nth-child(10)").textContent().contains("dmitriy.daniel.admin"));
        Assert.assertTrue(page.locator("#w0 > table > tbody > tr > td:nth-child(11)").textContent().contains("dmitriy.daniel.admin"));
        reload();
        return this;
    }

    public CasesViewPage assertAgentCanSendToSMS() {
        reload();
        Assert.assertTrue(page.locator("#list-wrapper > div.chat__message.chat__message--system.chat__message--sms > div.chat__message-heading > div.chat__sender").textContent().contains("SMS from "));
        return this;
    }

    public CasesViewPage assertAgentCanSentToEmail() {
        reload();
        Assert.assertTrue(page.locator("#list-wrapper > div.chat__message.chat__message--system.chat__message--sms > div.chat__message-heading > div.chat__sender").textContent().contains("Open"));
        return this;
    }

    //Status History


    public CasesViewPage ckickBtnLogs() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Logs")).click();
        return this;
    }

    public CasesViewPage ckickBtnStatusHistory() {
        page.getByText("Status History (1)").click();
        return this;
    }

    //
    public CasesViewPage ckickBtnChangeStatus() {
        btnChangeStatus.click();
        return this;
    }

    public CasesViewPage reload() {

        page.reload();
        page.reload();
        return this;
    }

    public CasesViewPage clickBtnClose() {
        btnCloseCase.click();
        return this;
    }

    public CasesViewPage setStatusInChangeCaseStatusModal(String value) {
        fieldStatusInChangeCaseStatusModal.selectOption(value);
        return this;
    }

    public CasesViewPage changefieldSentToEmail(String value) {
        fieldSentToEmail.selectOption(value);
        return this;
    }

    public CasesViewPage setLanguageInChangeCaseStatusModal(String value) {
        fieldLanguageInChangeCaseStatusModal.selectOption(value);
        return this;
    }

    public CasesViewPage setEmployeeInChangeCaseStatusModal(String value) {
        changeEmployeeInChangeCaseStatusModal.selectOption(value);
        return this;
    }

    public CasesViewPage ckickInModalBtnChangeStatus() {
        ckickInModalBtnChangeStatus.click();
        return this;
    }


    public CasesViewPage clickBtnAddEmail() {
        btnAddEmailInClientInfoBlock.click();
        return this;
    }

    public CasesViewPage addEmailFormEmail(String value) {
        inModalFillAddEmail.type(value);
        page.waitForTimeout(2000);
        return this;
    }

    public CasesViewPage btnAddEmailInAddEmailForm() {
        inModalBtnAddEmail.click();
        page.waitForTimeout(2000);
        return this;
    }

    public CasesViewPage clickBtnAddPhone() {
        btnAddPhoneInClientInfoBlock.click();
        return this;
    }

    public CasesViewPage addPhoneInForm(String value) {
        addPhoneInForm.fill(value);
        return this;
    }

    public CasesViewPage clickInModalBtnAddPhone() {
        inModalBtnAddPhone.click();
        return this;
    }

    //Make Call________________________________________________________Communication

    public CasesViewPage setToPhoneValue(String value) {
        communicationTypeForm.click();
        communicationTypeForm.selectOption(value);
        return this;
    }

    public CasesViewPage setClientPhoneNumber(String value) {
        formClientPhonNumber.click();
        formClientPhonNumber.selectOption(value);
        return this;
    }

    public CasesViewPage clickBtnMakeCall() {
        btnMakeCall.click();
        return this;
    }

    //Send SMS________________________________________________________Communication

    public CasesViewPage setToSMSValue(String value) {
        communicationTypeForm.click();
        communicationTypeForm.selectOption(value);
        return this;
    }

    public CasesViewPage setValueInFormSMSTemplate(String value) {
        formSMSTemplate.click();
        formSMSTemplate.selectOption(value);
        return this;
    }

    public CasesViewPage setValueInFormPhonNumber(String value) {
        formPhonNumber.click();
        formPhonNumber.selectOption(value);
        return this;
    }

    public CasesViewPage clickToSendSMSBtn() {
        btnSendSMS.click();
        return this;
    }

    public CasesViewPage clickToSMSInternalNoteField(String value) {
        SMSInternalNoteField.fill(value);
        return this;
    }

    public CasesViewPage clickToModalSendSMSBtn() {
        btnModalSendSMS.click();
        return this;
    }

    //SendEmail________________________________________________________Communication

    public CasesViewPage clickToBtnDetails() {
        page.reload();
        clickToBtnDetails.click();
        return this;

    }

    public CasesViewPage setToEmailValue(String value) {
        communicationTypeForm.click();
        communicationTypeForm.selectOption(value);
        return this;
    }

    public CasesViewPage setValueInFormEmailTemplate(String value) {
        formEmailTemplate.click();
        formEmailTemplate.selectOption(value);
        return this;
    }

    public CasesViewPage clickToEmailRadioBtn(String value) {
        page.getByLabel(value).check();
        return this;
    }

    public CasesViewPage clickToPreviewAndSendEmailBtn() {
        clickToPreviewAndSendEmailBtn.click();
        return this;
    }

    public CasesViewPage clickToInternalNoteFieldEmail(String value) {
        clickToInternalNoteFieldEmail.fill(value);
        return this;
    }

    public CasesViewPage clickBtnSendEmail() {
        clickBtnSendEmail.click();
        return this;

    }

//    UpdateUserForm________________________________________________________Client Info

    public CasesViewPage clickBtnClientUpdate() {

        clickBtnClientUpdate.click();
        return this;
    }

    public CasesViewPage setClientUpdateFormFirstName(String value) {
        setClientUpdateFormFirstName.fill(value);
        return this;
    }

    public CasesViewPage setClientUpdateFormLastName(String value) {
        setClientUpdateFormLastName.fill(value);
        return this;
    }

    public CasesViewPage setClientUpdateFormMiddleName(String value) {
        setClientUpdateFormMiddleName.fill(value);
        return this;

    }

    public CasesViewPage setValueLocale(String value) {
        setValueLocale.click();
        setValueLocale.selectOption(value);
        return this;
    }

    public CasesViewPage setValueMarketingCountry(String value) {
        setValueMarketingCountry.click();
        setValueMarketingCountry.selectOption(value);
        return this;
    }


    public CasesViewPage clickModalBtmUpdate() {
        btmUpdateModal.click();
        return this;

    }

    //General Info--------------------------------------------------------------------------------Update

    public CasesViewPage clickBtnGeneralInfoUpdate() {
        btnGeneralInfoUpdate.click();
        return this;
    }


    public CasesViewPage updateDepartmantToUpdateCaseForm(String value) {
        page.getByLabel("Department").selectOption(value);
        return this;
    }

    public CasesViewPage setCategoryToUpdateCaseForm(String value) {
        inputCategoryToUpdateCaseForm.click();
        page.locator("#select2-categoryId-container");
        page.waitForTimeout(3000);
        page.getByRole(AriaRole.SEARCHBOX).fill(value);
        page.getByRole(AriaRole.SEARCHBOX).press("Enter");
        return this;
    }

    public CasesViewPage updateBookingIDToUpdateCaseForm(String value) {
        bookingIdToUpdateCaseForm.fill(value);
        return this;
    }

    public CasesViewPage updateSubjectToUpdateCaseForm(String value) {
        subjectToUpdateCaseForm.fill(value);
        return this;
    }

    public CasesViewPage updateDescriptionToUpdateCaseForm(String value) {
        descriptionToUpdateCaseForm.fill(value);
        return this;
    }

    public CasesViewPage clickBtnUpdateGeneralInfoBlock() {
        btnUpdateGeneralInfoBlock.click();
        page.waitForTimeout(3000);
        return this;
    }

    public CasesViewPage clickBtnCloseUpdateCase() {
        btnCloseUpdateCase.click();
        return this;
    }

    //Fiels--------------------------------------------------------------------------------Update
    public CasesViewPage clickBtnUploadFiel() {
        btnUploadFiels.click();
        return this;
    }

    public CasesViewPage clickBtnBrowseInFileInputInsideModal() {
        btnBrowseInFileInputInsideModal.click();
        return this;
    }

    public CasesViewPage clickBtnUploadInFileInputInsideModal() {
        btnUploadInFileInputInsideModal.click();
        return this;
    }

    public CasesViewPage assertfeldStatus() {
        Assert.assertTrue(page.locator(".feldStatus").textContent().contains("AutoTest@mail.com"));
        return this;
    }


}


//
//
//package dmitriy.daniel.CRM.pages;
//
//import Dmitriy.Daniel.elements.Element;
//import com.microsoft.playwright.Locator;
//import com.microsoft.playwright.options.AriaRole;
//import lombok.extern.slf4j.Slf4j;
//import org.testng.Assert;
//
//import static com.codeborne.selenide.Selenide.sleep;
//import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
//
//
//@Slf4j
//public class CasesViewPage extends Element {
//
//    private final Locator assertProject = find("#w0 > tbody > tr:nth-child(2) > td > span");
//    private final Locator btnAddEmailInClientInfoBlock = find("#btn-add-email");
//    private final Locator inModalFillAddEmail = find("#casesaddemailform-email");
//    private final Locator inModalBtnAddEmail = find("#w0 > div.form-group.text-center > button");
//    private final Locator btnAddPhoneInClientInfoBlock = find("#btn-add-phone");
//    private final Locator addPhoneInForm = find("#casesaddphoneform-phone");
//    private final Locator inModalBtnAddPhone = find("#w0 > div.form-group.text-center > button");
//
//    private final Locator communicationTypeForm = find("#c_type_id");
//
//    //Make Call________________________________________________________Communication
//    private final Locator btnMakeCall = find("#btn-make-call-case-communication-block");
//    private final Locator formClientPhoneNumber = find("#client-phone-number-id");
//
//    //Send SMS________________________________________________________Communication
//    private final Locator formSMSTemplate = find("#c_sms_tpl_key");
//    private final Locator formPhoneNumber = find("#casecommunicationform-c_phone_number_id");
//    private final Locator btnSendSMS = find("#sms-input-box > div.btn-wrapper > button");
//    private final Locator SMSInternalNoteField = find("#casepreviewsmsform-internalnote");
//    private final Locator btnModalSendSMS = find("#w10 > div.btn-wrapper.text-center > button");
//
//    //SendEmail________________________________________________________Communication
//    private final Locator formEmailTemplate = find("#c_email_tpl_key");
//    private final Locator clickToPreviewAndSendEmailBtn = find("#preview_email_btn");
//    private final Locator clickToInternalNoteFieldEmail = find("#casepreviewemailform-internalnote");
//    private final Locator clickBtnSendEmail = find("#send_email_btn");
//
//    private final Locator clickToBtnDetails = find("#list-wrapper > div:nth-child(3) > div.card-body > div.chat__message-footer > a");
//
//    //UpdateUserForm________________________________________________________Client Info
//    private final Locator clickBtnClientUpdate = find("#btn-client-update");
//    private final Locator setClientUpdateFormFirstName = find("#casesclientupdateform-first_name");
//    private final Locator setClientUpdateFormLastName = find("#casesclientupdateform-last_name");
//    private final Locator setClientUpdateFormMiddleName = find("#casesclientupdateform-middle_name");
//    private final Locator setValueLocale = find("#casesclientupdateform-locale");
//    private final Locator setValueMarketingCountry = find("#casesclientupdateform-marketingcountry");
//    private final Locator btmUpdateModal = find("#client-edit-name-form > div.form-group.text-center > button");
//
//    //General Info--------------------------------------------------------------------------------Update
//    private final Locator btnGeneralInfoUpdate = find("#btn-case-update");
//    private final Locator departmantToUpdateCaseForm = find("#updateinfoform-depid");
//    private final Locator updateDepartmantToUpdateCaseForm = find("#updateinfoform-depid > option:nth-child(4)");
//    private final Locator categoryToUpdateCaseForm = find("#select2-categoryId-container");
//    private final Locator inputCategoryToUpdateCaseForm = find("//*[@id=\"w0\"]/div[3]/div[1]/span/span[1]/span/span[2]");
//    private final Locator bookingIdToUpdateCaseForm = find("#updateinfoform-orderuid");
//    private final Locator subjectToUpdateCaseForm = find("#updateinfoform-subject");
//    private final Locator descriptionToUpdateCaseForm = find("#updateinfoform-description");
//    private final Locator btnUpdateGeneralInfoBlock = find("#w0 > div.form-group.text-center > button");
//    //Fiels--------------------------------------------------------------------------------Update
//    private final Locator btnUploadFiels = find("body > div.container.body > div > div.right_col > div.row > div.col-md-12.col-sm-12.col-xs-12 > div.cases-view > div:nth-child(5) > div:nth-child(2) > div > div.x_title > ul > li:nth-child(1) > button");
//    private final Locator btnBrowseInFileInputInsideModal = find("#uploadform-files");
//    private final Locator btnUploadInFileInputInsideModal = find("#file-storage-upload-form-id > button");
//
//    //General Info Form
//    private final Locator feldStatusNew = find("#w0 > tbody > tr:nth-child(1) > td > span.badge.badge-info");
//    private final Locator feldStatusSuccess = find("#w0 > tbody > tr:nth-child(1) > td"); //Open/Solved
//    private final Locator feldStatusPending = find("#w0 > tbody > tr:nth-child(1) > td > span.badge.badge-warning");
//    private final Locator fieldProject = find("#w0 > tbody > tr:nth-child(2) > td > span");
//    private final Locator fieldsAgent = find("#w0 > tbody > tr:nth-child(3) > td");
//    private final Locator fieldSourseType = find("#w0 > tbody > tr:nth-child(4) > td > span");
//    private final Locator fieldBookingID = find("#caseBookingId");
//    private final Locator fieldSubject = find("div:nth-child(1) > div > div.x_content > div > div.col-md-12 > h4:nth-child(3) > span");
//    private final Locator fieldDescription = find("div:nth-child(1) > div > div.x_content > div > div.col-md-12 > pre");
//
//    //Client Info Form
//    private final Locator fieldPhone = find("#w3 > tbody > tr:nth-child(2) > td > div > code");
//    private final Locator fieldEmail = find("#w3 > tbody > tr:nth-child(3) > td > div > code");
//
//    //Change status
//    private final Locator btnChangeStatus = find("#btn-change-status");
//    private final Locator fieldStatusInChangeCaseStatusModal = find("#caseschangestatusform-statusid");
//    private final Locator fieldLanguageInChangeCaseStatusModal = find("#caseschangestatusform-language");
//    private final Locator changeEmployeeInChangeCaseStatusModal = find("#caseschangestatusform-userid");
//    private final Locator ckickInModalBtnChangeStatus = find("#change-status-form-id > div.form-group.text-center > button");
//    private final Locator BtnCloseCase = find("body > div.container.body > div > div.right_col > div.row > div.col-md-12.col-sm-12.col-xs-12 > div.cases-view > div.x_panel > div > a.add-reason.btn.btn-danger");
//
//
//    //Asserts
//    public CasesViewPage assertGeneralInfoUpdate() {
//
//        page.reload();
//        Assert.assertTrue(feldStatusNew.textContent().contains("New"));
//        Assert.assertTrue(fieldProject.textContent().contains("OVAGO"));
//        Assert.assertTrue(fieldBookingID.textContent().contains("654321"));
//        Assert.assertTrue(fieldSubject.textContent().contains("updateSubjectAutoTest"));
//        Assert.assertTrue(fieldDescription.textContent().contains("updateDescriptionAutoTest"));
//
//        return this;
//    }
//
//    public CasesViewPage assertNewCaseCreate() {
//        page.reload();
//        Assert.assertTrue(feldStatusNew.textContent().contains("New"));
//        Assert.assertTrue(fieldProject.textContent().contains("OVAGO"));
//        Assert.assertTrue(fieldSubject.textContent().contains("autoTest"));
//        Assert.assertTrue(fieldDescription.textContent().contains("Test_Dmitriy.Danel"));
//        Assert.assertTrue(fieldsAgent.textContent().contains(" dmitriy.daniel.admin"));
//        return this;
//    }
//
//    public CasesViewPage assertChangedFromNewToStatusOpen() {
//        page.reload();
//        Assert.assertTrue(feldStatusSuccess.textContent().contains("Open"));
//        return this;
//    }
//
//    public CasesViewPage assertChangedFromNewToStatusSolved() {
//        page.reload();
//        Assert.assertTrue(feldStatusSuccess.textContent().contains("Solved"));
//        return this;
//    }
//
//    public CasesViewPage assertChangedFromOpenToStatusPending() {
//        page.reload();
//        Assert.assertTrue(feldStatusPending.textContent().contains("Pending"));
//        Assert.assertTrue(fieldsAgent.textContent().contains("dmitriy.daniel.CX"));
//        return this;
//    }
//
//    public CasesViewPage assertUpdateClientInfo() {
//        Assert.assertTrue(page.locator("#w2 > tbody > tr:nth-child(2) > td").textContent().contains("Jack"));
//        Assert.assertTrue(page.locator("#w2 > tbody > tr:nth-child(3) > td").textContent().contains("Capt"));
//        Assert.assertTrue(page.locator("#w2 > tbody > tr:nth-child(4) > td").textContent().contains("Sparrow"));
//        Assert.assertTrue(page.locator("#w2 > tbody > tr:nth-child(6) > td > span").textContent().contains("uk-UA"));
//        Assert.assertTrue(page.locator("[class=js_marketing_country]").textContent().contains("AD"));
//        return this;
//
//    }
//
//    public CasesViewPage assertCaseAddPhoneToClientInfoBlock() {
//        page.reload();
//        Assert.assertTrue(page.locator("#w3").textContent().contains("+380950950955"));
//        return this;
//    }
//
//    public CasesViewPage assertaddEmailToClientInfoBlock() {
//        Assert.assertTrue(page.locator("#w3").textContent().contains("AutoTest@mail.com"));
//        return this;
//    }
//
//    //
//    public CasesViewPage ckickBtnChangeStatus() {
//        btnChangeStatus.click();
//        return this;
//    }
//
//    public CasesViewPage reload() {
//        page.reload();
//        return this;
//    }
//
//    public CasesViewPage clickBtnClose() {
//        BtnCloseCase.click();
//        return this;
//    }
//
//    public CasesViewPage setStatusInChangeCaseStatusModal(String value) {
//        fieldStatusInChangeCaseStatusModal.selectOption(value);
//        return this;
//    }
//
//    public CasesViewPage setLanguageInChangeCaseStatusModal(String value) {
//        fieldLanguageInChangeCaseStatusModal.selectOption(value);
//        return this;
//    }
//
//    public CasesViewPage setEmployeeInChangeCaseStatusModal(String value) {
//        changeEmployeeInChangeCaseStatusModal.selectOption(value);
//        return this;
//    }
//
//    public CasesViewPage ckickInModalBtnChangeStatus() {
//        ckickInModalBtnChangeStatus.click();
//        return this;
//    }
//
//    public CasesViewPage assertUserIsAbleToAssignTheCaseToAnotherAgentWhenChangingTheCaseStatusToPending() {
//        page.reload();
//        assertThat(page.locator("#w0 > tbody > tr:nth-child(1) > td > span.badge.badge-warning")).hasText("Pending");
//        assertThat(page.locator("#w0 > tbody > tr:nth-child(3) > td")).hasText("dmitriy.daniel.CX");
//        return this;
//    }
//
//    public CasesViewPage asertTheCaseStatusIsChangedToBusinessStatusSolved() {
//        page.reload();
//        assertThat(page.locator("#w0 > tbody > tr:nth-child(1) > td > span:nth-child(2)")).hasText("Solved");
//        return this;
//    }
//
//
//    public CasesViewPage clickBtnAddEmail() {
//        btnAddEmailInClientInfoBlock.click();
//        return this;
//    }
//
//    public CasesViewPage addEmailFormEmail(String value) {
//        inModalFillAddEmail.fill(value);
//        return this;
//    }
//
//    public CasesViewPage btnAddEmailInAddEmailForm() {
//        inModalBtnAddEmail.click();
//        return this;
//    }
//
//    public CasesViewPage clickBtnAddPhone() {
//        btnAddPhoneInClientInfoBlock.click();
//        return this;
//    }
//
//    public CasesViewPage addPhoneInForm(String value) {
//        addPhoneInForm.fill(value);
//        return this;
//    }
//
//    public CasesViewPage clickInModalBtnAddPhone() {
//        inModalBtnAddPhone.click();
//        return this;
//    }
//
//    //Make Call________________________________________________________Communication
//
//    public CasesViewPage setToPhoneValue(String value) {
//        communicationTypeForm.click();
//        communicationTypeForm.selectOption(value);
//        return this;
//    }
//
//    public CasesViewPage setClientPhoneNumber(String value) {
//        formClientPhoneNumber.click();
//        formClientPhoneNumber.selectOption(value);
//        return this;
//    }
//
//    public CasesViewPage clickBtnMakeCall() {
//        btnMakeCall.click();
//        return this;
//    }
//
//    //Send SMS________________________________________________________Communication
//
//    public CasesViewPage setToSMSValue(String value) {
//        communicationTypeForm.click();
//        communicationTypeForm.selectOption(value);
//        return this;
//    }
//
//    public CasesViewPage setValueInFormSMSTemplate(String value) {
//        formSMSTemplate.click();
//        formSMSTemplate.selectOption(value);
//        return this;
//    }
//
//    public CasesViewPage setValueInFormPhonNumber(String value) {
//        formPhoneNumber.click();
//        formPhoneNumber.selectOption(value);
//        return this;
//    }
//
//    public CasesViewPage clickToSendSMSBtn() {
//        btnSendSMS.click();
//        return this;
//    }
//
//    public CasesViewPage clickToSMSInternalNoteField(String value) {
//        SMSInternalNoteField.fill(value);
//        return this;
//    }
//
//    public CasesViewPage clickToModalSendSMSBtn() {
//        btnModalSendSMS.click();
//        return this;
//    }
//
//    //SendEmail________________________________________________________Communication
//
//    public CasesViewPage clickToBtnDetails() {
//        page.reload();
//        clickToBtnDetails.click();
//        return this;
//
//    }
//
//    public CasesViewPage setToEmailValue(String value) {
//        communicationTypeForm.click();
//        communicationTypeForm.selectOption(value);
//        return this;
//    }
//
//    public CasesViewPage setValueInFormEmailTemplate(String value) {
//        formEmailTemplate.click();
//        formEmailTemplate.selectOption(value);
//        return this;
//    }
//
//    public CasesViewPage clickToEmailRadioBtn(String value) {
//        page.getByLabel(value).check();
//        return this;
//    }
//
//    public CasesViewPage clickToPreviewAndSendEmailBtn() {
//        clickToPreviewAndSendEmailBtn.click();
//        return this;
//    }
//
//    public CasesViewPage clickToInternalNoteFieldEmail(String value) {
//        clickToInternalNoteFieldEmail.fill(value);
//        return this;
//    }
//
//    public CasesViewPage clickBtnSendEmail() {
//        clickBtnSendEmail.click();
//        return this;
//
//    }
//
////    UpdateUserForm________________________________________________________Client Info
//
//    public CasesViewPage clickBtnClientUpdate() {
//
//        clickBtnClientUpdate.click();
//        return this;
//    }
//
//    public CasesViewPage setClientUpdateFormFirstName(String value) {
//        setClientUpdateFormFirstName.fill(value);
//        return this;
//    }
//
//    public CasesViewPage setClientUpdateFormLastName(String value) {
//        setClientUpdateFormLastName.fill(value);
//        return this;
//    }
//
//    public CasesViewPage setClientUpdateFormMiddleName(String value) {
//        setClientUpdateFormMiddleName.fill(value);
//        return this;
//
//    }
//
//    public CasesViewPage setValueLocale(String value) {
//        setValueLocale.click();
//        setValueLocale.selectOption(value);
//        return this;
//    }
//
//    public CasesViewPage setValueMarketingCountry(String value) {
//        setValueMarketingCountry.click();
//        setValueMarketingCountry.selectOption(value);
//        return this;
//    }
//
//
//    public CasesViewPage clickModalBtmUpdate() {
//        btmUpdateModal.click();
//        return this;
//
//    }
//
//    //General Info--------------------------------------------------------------------------------Update
//
//    public CasesViewPage clickBtnGeneralInfoUpdate() {
//        btnGeneralInfoUpdate.click();
//        return this;
//    }
//
//
//    public CasesViewPage updateDepartmantToUpdateCaseForm(String value) {
//        page.getByLabel("Department").selectOption(value);
//        return this;
//    }
//
//    public CasesViewPage setCategoryToUpdateCaseForm(String value) {
//        inputCategoryToUpdateCaseForm.click();
//        sleep(5000);
//        page.getByRole(AriaRole.SEARCHBOX).fill(value);
//        page.getByRole(AriaRole.SEARCHBOX).press("Enter");
//        return this;
//    }
//
//    public CasesViewPage updateBookingIDToUpdateCaseForm(String value) {
//        bookingIdToUpdateCaseForm.fill(value);
//        return this;
//    }
//
//    public CasesViewPage updateSubjectToUpdateCaseForm(String value) {
//        subjectToUpdateCaseForm.fill(value);
//        return this;
//    }
//
//    public CasesViewPage updateDescriptionToUpdateCaseForm(String value) {
//        descriptionToUpdateCaseForm.fill(value);
//        return this;
//    }
//
//    public CasesViewPage ClickBtnUpdateGeneralInfoBlock() {
//        btnUpdateGeneralInfoBlock.click();
//        return this;
//    }
//
//    //Fiels--------------------------------------------------------------------------------Update
//    public CasesViewPage clickBtnUploadFiel() {
//        btnUploadFiels.click();
//        return this;
//    }
//
//    public CasesViewPage clickBtnBrowseInFileInputInsideModal() {
//        btnBrowseInFileInputInsideModal.click();
//        return this;
//    }
//
//    public CasesViewPage clickBtnUploadInFileInputInsideModal() {
//        btnUploadInFileInputInsideModal.click();
//        return this;
//    }
//
//    public CasesViewPage assertfeldStatus() {
//        Assert.assertTrue(page.locator(".feldStatus").textContent().contains("AutoTest@mail.com"));
//        return this;
//    }
//
//
//}
