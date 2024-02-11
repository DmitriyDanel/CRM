package Dmitriy.Daniel.constants;

import Dmitriy.Daniel.config.PropertiesReader;

public class CrmConstants {

        static PropertiesReader reader = new PropertiesReader("src/main/resources/crm.properties");
    public static final String CRM_API_USER_STAGE = reader.getProperty("crm.api.user.stage");
    public static final String CRM_API_PASS_STAGE = reader.getProperty("crm.api.password.stage");

    public static final String CRM_URL_STAGE = reader.getProperty("crm.url.stage");
    public static final String CRM_API_URL_STAGE = reader.getProperty("crm.api.url.stage");
    public static final String CRM_USER_TOKEN_STAGE = reader.getProperty("crm.user.token.stage");
    public static final String DEV = reader.getProperty("crm_url_dev");
    public static final String ENV_URL = reader.getProperty("env.url");
    public static final String USERNAME = reader.getProperty("crm.user_stage");
    public static final String PASSWORD = reader.getProperty("crm.password_stage");
//

//    public static String CRM_API_URL_DEV = "https://api.crm.dev.travel-dev.com";
//    public static String CRM_API_USER_DEV = "dmitriy.danel";
//    public static String CRM_API_PASSWORD_DEV = "0910BIGti/*-+";
//
//    public static String CRM_API_URL_STAGE = "https://api.crm.stage.travel-dev.com";
//    public static String CRM_API_USER_STAGE = "dmitriy.daniel";
//    public static String CRM_API_PASS_STAGE = "0910BIGti/*-+";
//
//
//
//    public static String CRM_URL_DEV = "https://crm.dev.travel-dev.com";
//    public static String CRM_USER_DEV = "Dmitriy.Danel";
//    public static String CRM_PASSWORD_DEV = "0910BIGti/*-+";
//
//
//    public static String CRM_URL_STAGE = "https://crm.stage.travel-dev.com";
//    public static String CRM_USER_STAGE = "dmitriy.daniel.admin";
//    public static String CRM_PASSWORD_STAGE = "0910BIGti/*-+";
}

