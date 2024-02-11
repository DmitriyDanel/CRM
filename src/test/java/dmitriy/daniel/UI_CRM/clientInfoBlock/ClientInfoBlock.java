package dmitriy.daniel.UI_CRM.clientInfoBlock;

import Dmitriy.Daniel.config.BrowserInitialization;
import Dmitriy.Daniel.pages.CasesViewPage;
import dmitriy.daniel.UI_CRM.caseCreate.CreateCaseManually;
import io.qameta.allure.Story;
import org.testng.annotations.*;

public class ClientInfoBlock {

    private BrowserInitialization browserInitialization;
    private CasesViewPage casesViewPage;
    private CreateCaseManually createCaseManually;

    @BeforeMethod
    public void setUp() {
        browserInitialization = BrowserInitialization.getInstance();
        createCaseManually = new CreateCaseManually();
        createCaseManually.setUpBrowser();
        casesViewPage = browserInitialization.casesViewPage;
    }

    @AfterMethod
    public void tearDownPage() {
        browserInitialization.closePage();
    }

    @Test
    @Story("https://traveldev.atlassian.net/browse/TEST-1742  'Update Client' with required and optional fields (+Locale and Marketing Country)")
    public void updateClientWithRequiredAndOptionalFieldsLocaleAndMarketing() {
        createCaseManually.createNewCase();
        updateClientWithRequiredAndOptionalFields();
    }

    public void updateClientWithRequiredAndOptionalFields() {
        casesViewPage.clickBtnClientUpdate()
                .setClientUpdateFormFirstName("Jack")
                .setClientUpdateFormMiddleName("Capt")
                .setClientUpdateFormLastName("Sparrow")
                .setValueLocale("uk-UA")
                .setValueMarketingCountry("AD")
                .clickModalBtmUpdate()
                .reload()
                .assertUpdateClientInfo();

    }


    @Test
    @Story("https://traveldev.atlassian.net/browse/TEST-1741  'Update Client' with required and optional fields - valid data")
    public void updateClientWithRequiredAndOptionalFieldsValidData() {
        createCaseManually.createNewCase();
        updateClientInfoBlock();
    }

    public void updateClientInfoBlock() {
        casesViewPage.clickBtnClientUpdate()
                .setClientUpdateFormFirstName("Black")
                .setClientUpdateFormMiddleName("Captain")
                .setClientUpdateFormLastName("Snow")
                .clickModalBtmUpdate()
                .reload()
                .assertUpdateClientWithRequiredAndOptionalFieldsValidData();

    }

    @Test
    @Story("https://traveldev.atlassian.net/browse/TEST-1736  'Update Client' with only required field - valid data")
    public void updateClientWithOnlyRequiredFields() {
        createCaseManually.createNewCase();
        updateClientOnlyFirstNameFields();
    }

    public void updateClientOnlyFirstNameFields() {
        casesViewPage.clickBtnClientUpdate()
                .setClientUpdateFormFirstName("Gold")
                .clickModalBtmUpdate()
                .reload()
                .assertUpdateClientOnlyFirstNameFields();

    }

    @Test
    @Story("https://traveldev.atlassian.net/browse/TEST-1744  Adding email (valid data)")
    public void addEmailToClientInfoBlockValidData() {
        createCaseManually.createNewCase();
        addEmailToClientInfoBlock();
    }

    public void addEmailToClientInfoBlock() {
        casesViewPage
                .clickBtnAddEmail()
                .addEmailFormEmail("AddAutoTest@mail.com")
                .btnAddEmailInAddEmailForm()
                .reload()
                .assertAddEmailToClientInfoBlock();
    }

    @Test
    @Story("https://traveldev.atlassian.net/browse/TEST-1745  Email - Verify validation message for invalid data")
    public void addEmailValidationMessageForInvalidData() {
        createCaseManually.createNewCase();
        addEmailToClientInfoBlockNegativeScenario();
    }

    public void addEmailToClientInfoBlockNegativeScenario() {
        casesViewPage
                .clickBtnAddEmail()
                .addEmailFormEmail("test@techorkcom")
                .btnAddEmailInAddEmailForm()
                .assertAddEmailToClientInfoBlockNegativeScenario()
                .reload();
    }

    @Test
    @Story("https://traveldev.atlassian.net/browse/TEST-1753 Case - Add phone")
    public void caseAddPhone() {
        createCaseManually.createNewCase();
        caseAddPhoneToClientInfoBlock();
    }

    public void caseAddPhoneToClientInfoBlock() {
        casesViewPage
                .clickBtnAddPhone()
                .addPhoneInForm("+380983429271")
                .clickInModalBtnAddPhone()
                .reload()
                .assertCaseAddPhoneToClientInfoBlock();
    }

    @Test
    @Story("https://traveldev.atlassian.net/browse/TEST-1755  [Case] Phone number - Verify validation message for invalid data")
    public void caseAddPhoneNegativeScenario() {
        createCaseManually.createNewCase();
        caseAddPhoneToClientInfoBlockNegativeScenario();
    }

    public void caseAddPhoneToClientInfoBlockNegativeScenario() {
        casesViewPage
                .clickBtnAddPhone()
                .addPhoneInForm("1888888888")
                .clickInModalBtnAddPhone()
                .assertCaseAddPhoneToClientInfoBlockNegativeScenario();
    }
}

