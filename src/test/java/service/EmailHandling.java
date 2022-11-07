package service;

import page.EmailPage;

public class EmailHandling {

    public EmailPage emailPage = new EmailPage();

    public String getVmEstimatedMonthlyCostValueInEmail() {
        return emailPage.getCostInEmail();
    }

    public String getGeneratedEmailName(String urlNameOfEmailGenerator) {
        return emailPage.openPage(urlNameOfEmailGenerator).clickGenerateEmailButton().getEmailName();
    }

    public EmailHandling checkEmail() {
        emailPage.clickCheckEmailButton().clickRefreshButton();
        return this;
    }
}
