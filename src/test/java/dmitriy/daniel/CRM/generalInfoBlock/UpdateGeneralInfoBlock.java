package dmitriy.daniel.CRM.generalInfoBlock;

import Dmitriy.Daniel.config.BrowserInitialization;
import Dmitriy.Daniel.pages.CasesViewPage;
import dmitriy.daniel.CRM.caseCreate.CreateCaseManually;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class  UpdateGeneralInfoBlock  {
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
    @Story("https://traveldev.atlassian.net/browse/TEST-1747  Verify General Info update in the Case")
    public void generalInfoUpdateInTheCase(){
        createCaseManually.createNewCase();
        updateGeneralInfoBlock();
    }
        public void updateGeneralInfoBlock() {
        casesViewPage
                .clickBtnGeneralInfoUpdate()
                .updateDepartmantToUpdateCaseForm("2")
                .updateBookingIDToUpdateCaseForm("654321")
                .updateSubjectToUpdateCaseForm("updateSubjectAutoTest")
                .updateDescriptionToUpdateCaseForm("updateDescriptionAutoTest")
                .setCategoryToUpdateCaseForm("Add child to the existing flight")
                .clickBtnUpdateGeneralInfoBlock()
                .assertGeneralInfoUpdate();
    }

    @Test
    @Story("https://traveldev.atlassian.net/browse/TEST-1748  General Info update (negative scenario)")
    public void generalInfoUpdateInTheCaseNegativeScenario() {
        createCaseManually.createNewCase();
        updateGeneralInfoNegativeScenario();
    }
    public void updateGeneralInfoNegativeScenario() {
        casesViewPage.clickBtnGeneralInfoUpdate()
                .updateBookingIDToUpdateCaseForm("**%%##")
                .clickBtnUpdateGeneralInfoBlock()
                .assertGeneralInfoUpdateNegativeScenario()
                .clickBtnCloseUpdateCase();
    }
}
