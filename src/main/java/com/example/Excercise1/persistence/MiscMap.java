package com.example.Excercise1.persistence;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Notes:
 *	 An improved data structure that combined the literal-to-database name and corresponding vector
 *   structures would probabily be a design improvement.
 *
 *   This class should be modified to read table and field names directly from the database's
 *   data dictionary rather then have them hardcoded.
 */
public class MiscMap {

    // ABN Reason Types from the ABN_RSN_TYP table - used for providing default values in Std Ordr
    public static final int ABN_RSN_TYP_ROUTINE = 1;
    public static final int ABN_RSN_TYP_DIAGNOSIS = 2;
    public static final int ABN_RSN_TYP_FREQ = 3;
    public static final int ABN_RSN_TYP_NON_FDA = 4;

    // Accident Cause Type Abbrevs from the ACCIDENT_CAUSE_TYP table
    public static final String ACCIDENT_CAUSE_TYP_AUTO_ACCIDENT_ABBREV = "AA";
    public static final String ACCIDENT_CAUSE_TYP_ABUSE_ABBREV = "AB";
    public static final String ACCIDENT_CAUSE_TYP_ANOTHER_PARTY_RESPONSIBLE_ABBREV = "AP";
    public static final String ACCIDENT_CAUSE_TYP_EMPLOYMENT_ABBREV = "EM";
    public static final String ACCIDENT_CAUSE_TYP_OTHER_ACCIDENT_ABBREV = "OA";

    public static final int ACCIDENT_CAUSE_TYP_AUTO_ACCIDENT = 1;
    public static final int ACCIDENT_CAUSE_TYP_ABUSE = 2;
    public static final int ACCIDENT_CAUSE_TYP_ANOTHER_PARTY_RESPONSIBLE = 3;
    public static final int ACCIDENT_CAUSE_TYP_EMPLOYMENT = 4;
    public static final int ACCIDENT_CAUSE_TYP_OTHER_ACCIDENT = 5;

    public static final int ACK_TYP_277 = 200;
    public static final int ACK_TYP_EFAX = 400;
    public static final int ACK_TYP_SFAX = 500;
    public static final int ACK_TYP_LUXSCI = 600;
    public static final int ACK_TYP_CONCORD = 700;

    // Statement data types from the STMT_DATA_TYP table
    public static final int STMT_DATA_TYP_SFAX_COVER_PAGE_COVER_NAME = 100;
    public static final int STMT_DATA_TYP_SFAX_COVER_PAGE_SENDER_NAME = 101;
    public static final int STMT_DATA_TYP_SFAX_COVER_PAGE_SENDER_PHONE = 102;
    public static final int STMT_DATA_TYP_SFAX_COVER_PAGE_REFERENCE = 103;
    public static final int STMT_DATA_TYP_SFAX_COVER_PAGE_TIME_ZONE = 104;
    public static final int STMT_DATA_TYP_LUXSCI_MESSAGE_BODY_DOC = 200;
    public static final int STMT_DATA_TYP_LUXSCI_EMAIL_ADDRESS = 201;
    public static final int STMT_DATA_TYP_LUXSCI_TOKEN_URL = 202;
    public static final int STMT_DATA_TYP_LUXSCI_DOMAIN = 203;
    public static final int STMT_DATA_TYP_LUXSCI_SEND_EMAIL_URL = 204;
    public static final int STMT_DATA_TYP_LUXSCI_SEND_EMAIL_METHOD = 205;
    public static final int STMT_DATA_TYP_LUXSCI_ACCOUNT_URL = 206;
    public static final int STMT_DATA_TYP_LUXSCI_REPORT_SENT_METHOD = 207;
    public static final int STMT_DATA_TYP_LUXSCI_API_KEY = 208;
    public static final int STMT_DATA_TYP_LUXSCI_TOKEN = 209;
    public static final int STMT_DATA_TYP_LUXSCI_ACCOUNT_ID = 210;
    public static final int STMT_DATA_TYP_LUXSCI_MESSAGE_DELAY = 211;
    public static final int STMT_DATA_TYP_CONCORD_URI = 300;

    // Adjustment Types from the ADJ_CD_TYP table
    public static final int ADJ_CD_TYP_REVENUE = 1;
    public static final int ADJ_CD_TYP_BADDEBT = 2;
    public static final int ADJ_CD_TYP_CASH = 3;
    public static final int ADJ_CD_TYP_OTHER = 4;

    // Adjustment Codes from the ADJ_CD table
    public static final int ADJ_CD_PAYMENT = 2;
    public static final int ADJ_CD_RETRO = 4;
    public static final int ADJ_CD_REPRICE = 100;
    public static final int ADJ_CD_BILLDR = 107;
    public static final int ADJ_CD_REFUND = 201;
    public static final int ADJ_CD_MINWO = 210;
    public static final int ADJ_CD_PFD = 211;
    public static final int ADJ_CD_SUSPXFER = 400;
    public static final int ADJ_CD_BILL_TO_CLIENT_NICL = 461;
    public static final int ADJ_CD_INTEREST_CHARGE = 13000;
    public static final int ADJ_CD_CB_XFER = 13001;
    public static final int ADJ_CD_SPLITBILL = 13031;

    // Attachment types from ATTACH_TYP table
    public static final int ATTACH_TYP_ACCN_REFUND = 62;
    public static final String ATTACH_TYP_ABBREV_ACCN_REFUND = "ACCNREFUND";
    public static final int ATTACH_TYP_CLN_REFUND = 63;
    public static final String ATTACH_TYP_ABBREV_CLN_REFUND = "CLNREFUND";
    public static final int ATTACH_TYP_ACCN_SUSP_REFUND = 64;
    public static final String ATTACH_TYP_ABBREV_ACCN_SUSP_REFUND = "ACCNSUSPREFUND";
    public static final int ATTACH_TYP_CLN_SUSP_REFUND = 65;
    public static final String ATTACH_TYP_ABBREV_CLN_SUSP_REFUND = "CLNSUSPREFUND";

    // Submission Frequency Types  from SUBM_FREQ_TYP table
    public static final int SUBM_FREQ_TYP_MONTHLY = 1;
    public static final int SUBM_FREQ_TYP_BIMONTHLY = 2;
    public static final int SUBM_FREQ_TYP_WEEKLY = 3;

    // Diagnosis Method Selection Types for a Payor
    public static final int TEST_LEVEL_ONLY = 1;
    public static final int ANY_TEST_AND_ANY_ACCN_LEVEL = 2;
    public static final int TEST_ONLY_AND_ANY_ACCN_LEVEL = 3;

    // Client Submission Frequency Types  from CLN_SUBM_FREQ_TYP table
    public static final int CLN_SUBM_FREQ_TYP_BIMONTHLY = 1;  // twice a month, not every other month
    public static final int CLN_SUBM_FREQ_TYP_MONTHLY = 2;
    public static final int CLN_SUBM_FREQ_TYP_WEEKLY = 3;
    public static final int CLN_SUBM_FREQ_TYP_YEARLY = 4;

    //New Client Physician Question from the XREF table
    public static final int CLN_PHYS_COMMENT = 13;

    // Client Statements sorting types
    public static final int CLN_SORT_BY_SALESPERSON = 0;
    public static final int CLN_SORT_BY_ABBREV_ALPHANUMERIC  = 1;
    public static final int CLN_SORT_BY_NAME = 2;
    public static final int CLN_SORT_BY_ABBREV_ONLY_ALPHA = 3;

    // Client Statements sorting types for Client Statement Merge Engine
    public static final int CLN_STMT_MERGE_SORT_BY_FILENAME= 0;
    public static final int CLN_STMT_MERGE_SORT_BY_CLN_ABBREV  = 1;

    // recurring charges frequency types from REC_CHRGS_FREQ_TYP table
    public static final int REC_CHRGS_FREQ_TYP_BIMONTHLY = 1;
    public static final int REC_CHRGS_FREQ_TYP_MONTHLY = 2;

    //Supported Appeal Document Types on Document Maintenance Screen
    public static final int APPEAL_FORM_TYP_TEXT = 0;
    public static final int APPEAL_FORM_TYP_PDF = 1;
    public static final int APPEAL_FORM_TYP_RICH_TEXT = 2;

    public static final int DOC_TYP_PT_STMT = 5;
    public static final int DOC_TYP_DAILY_WEEKLY_CHARGE_NOTIF = 8;
    public static final int DOC_TYP_CLN_STMT = 12;
    public static final int DOC_TYP_TP_STMT_NON_PT = 13;
    public static final int DOC_TYP_PT_ERR   = 15;
    public static final int DOC_TYP_CLN_ERR  = 16;
    public static final int DOC_TYP_APPL_LTTR  = 17;
    public static final int DOC_TYP_DUN_MSG  = 18;
    public static final int DOC_TYP_LIM_COV_DIAG = 19;
    public static final int DOC_TYP_COLLECTIONS = 20;
    public static final int DOC_TYP_NOTES_PT = 21;
    public static final int DOC_TYP_NOTES_THIRD_PARTY = 22;
    public static final int DOC_TYP_NOTES_CLN = 23;
    public static final int DOC_TYP_NOTES_PAY_ADJ = 24;
    public static final int DOC_TYP_CLAIM_STATUS_REQUEST = 25;
    public static final int DOC_TYP_CLN_DUN_MSG  = 26;
    public static final int DOC_TYP_BLG_ASSIGN_NOTIF = 27;
    public static final int DOC_TYP_INVOICE_NOTIF = 28;
    public static final int DOC_TYP_CLN_ADL_LTR  = 29;
    public static final int DOC_TYP_ATTACH_REFUND  = 30;
    public static final int DOC_TYP_ATTACH_CLAIM  = 31;
    public static final int DOC_TYP_EXCEL_CLN_STMT  = 32;
    public static final int DOC_TYP_CLN_DIRECT_LTR = 35;
    public static final int DOC_TYP_PT_NOTIF_SMS_VERIF_MSG_BODY = 39;
    public static final int DOC_TYP_PT_NOTIF_SMS_PLAN_CREATION_MSG_BODY = 40;
    public static final int DOC_TYP_PT_NOTIF_SMS_STMT_NOTIF_MSG_BODY = 41;
    public static final int DOC_TYP_PT_NOTIF_EMAIL_VERIF_MSG_BODY = 42;
    public static final int DOC_TYP_PT_NOTIF_EMAIL_PLAN_CREATION_MSG_BODY = 43;
    public static final int DOC_TYP_PT_NOTIF_EMAIL_STMT_NOTIF_MSG_BODY = 43;
    public static final int DOC_TYP_PT_NOTIF_VERIF_EMAIL_SUBJECT = 45;
    public static final int DOC_TYP_PT_NOTIF_PLAN_CREATION_EMAIL_SUBJECT = 46;
    public static final int DOC_TYP_PT_NOTIF_STMT_NOTIF_EMAIL_SUBJECT = 47;

    public static final int DOC_DOC_TYP_STMT_CLN                = 1;
    public static final int DOC_DOC_TYP_STMT_TP_NON_PT          = 2;
    public static final int DOC_DOC_TYP_STMT_PT                 = 3;
    public static final int DOC_DOC_TYP_EP_LTR                  = 4;
    public static final int DOC_DOC_TYP_APPL_LTR                = 5;
    public static final int DOC_TYP_TYP_LIM_COV                 = 7;
    public static final int DOC_TYP_TYP_COLLECTIONS             = 8;
    public static final int DOC_TYP_TYP_CLAIM_STATUS_REQUEST    = 10;
    public static final int DOC_TYP_TYP_CLIENT_NOTIF            = 11;
    public static final int DOC_TYP_TYP_ADL                     = 12;
    public static final int DOC_TYP_TYP_ATTACH                  = 13;
    public static final int DOC_TYP_TYP_EXCEL_CLN_STMT          = 14;
    public static final int DOC_TYP_TYP_PT_NOTIF_MSG_BODY       = 15;
    public static final int DOC_TYP_TYP_PT_NOTIF_EMAIL_SUBJECT  = 16;

    public static final int FILE_TYP_EP_PT_LTR            = 1;
    public static final int FILE_TYP_EP_CLN_LTR           = 2;
    public static final int FILE_TYP_CLN_WELCOME_LTR      = 3;
    public static final int FILE_TYP_PAL                  = 4;
    public static final int FILE_TYP_PAP                  = 5;
    public static final int FILE_TYP_CLN_LTR_TOA          = 6;
    public static final int FILE_TYP_REFUND               = 7;
    public static final int FILE_TYP_CHARGE_NOTIFICATIONS = 8;
    public static final int FILE_TYP_APPEAL_LTR           = 9;
    public static final int FILE_TYP_ADL                  = 10;
    public static final int FILE_TYP_ADL_COMBINED         = 11;

    //Client Dunning Message types from the CLN_DUN_MSG_TYP table
    public static final int CLN_DUN_MSG_TYP_NONE  = 0;
    public static final int CLN_DUN_MSG_TYP_CLN_DUN  = 1;
    public static final int CLN_DUN_MSG_TYP_PYR_GRP_DUN  = 2;

    //data format types from DATA_FMT_TYP table
    public static final int DATA_FMT_TYP_CLN_PRIM_FAC_STMT = 3;
    public static final int DATA_FMT_TYP_CLN_STMT = 6;
    public static final int DATA_FMT_TYP_BARC_CLN_STMT = 133;
    public static final int DATA_FMT_TYP_APPL = 17;
    public static final int DATA_FMT_TYP_ATTACHMENT = 3000;
    public static final int DATA_FMT_TYP_DAILY_WEEKLY_CHARGE_NOTIFICATION = 6101;
    public static final int DATA_FMT_TYP_WS = 6303;
    public static final int DATA_FMT_TYP_CMS1500V2012 = 503;
    public static final int DATA_FMT_TYP_837_CLN_STMT = 633;
    public static final int DATA_FMT_TYP_PIPE_DELIMITER_PT_STMT_2_8 = 4114;
    public static final int DATA_FMT_TYP_REVSPRING_PT_STMT_1_0 = 4116;

    public static final int DIAG_CD_TYP_ICD_9_CM = 1;
    public static final int DIAG_CD_TYP_ICD_10_CM = 2;

    //ICD-10 default diagnosis code type id starting value. When loading the future versions , it will be ICD_version + 0000 (ex:110000)
    //ICD-10 diagnosis type will start from 102014 in the database.
    public static final int ICD10_DIAG_CD_TYP_ID_RANGE_START_VALUE = 100000;


    /**
     * The "main" main lab in the fac table.
     */
    public static final int MAIN_FACILITY_FAC_ID = 1;

    //Facility Types
    public static final int FAC_TYP_NONE = 0;
    public static final int FAC_TYP_MAIN_LAB = 1;
    public static final int FAC_TYP_PSC = 2;
    public static final int FAC_TYP_HOSP_LAB = 3;
    public static final int FAC_TYP_REMOTE_AFFIL = 4;
    public static final int FAC_TYP_B_TEST_FAC = 0;
    public static final int FAC_TYP_REF_LAB = 5;
    public static final int FAC_TYP_STAT_LAB = 6;
    public static final int FAC_TYP_MAIN_OR_REMOTE_LAB = 104;

    //Facility Specialty Types
    public static final int FAC_SPECIALTY_TYP_NONE = 0;
    public static final int FAC_SPECIALTY_TYP_CRITICAL_ACCESS_HOSPITAL = 1;

    //Facility License Types
    public static final int FAC_LIC_TYP_NONE = 0;
    public static final int FAC_LIC_TYP_TAX_ID = 1;
    public static final int FAC_LIC_TYP_CLIA_NUM = 2;
    public static final int FAC_LIC_TYP_ORGANIZATIONAL_NPI = 3;
    public static final int FAC_LIC_TYP_FACILITY_NPI = 4;
    public static final int FAC_LIC_TYP_TAXONOMY_CODE = 5;
    public static final int FAC_LIC_TYP_MAMMO_CERT_NUM = 6;

    // Gender Types (Sex)
    public static final int GENDER_TYP_MALE = 1;
    public static final int GENDER_TYP_FEMALE = 2;
    public static final int GENDER_TYP_NA = 3;
    public static final int GENDER_TYP_NG = 4;

    // Label Types (LABEL_TYP)
    public static final int LABEL_TYP_WORKGROUP = 1;
    public static final int LABEL_TYP_PRIORITY = 2;

    // Payor billing rules type
    public static final String PYR_BILLING_RULES_TYP_SUB_ID = "Sub ID Pattern";
    public static final String PYR_BILLING_RULES_TYP_DIAG = "Diagnosis";
    public static final String PYR_BILLING_RULES_TYP_INSURED_GRP_ID = "Insured Group ID Pattern";

    // Payor billing rules payor change comment
    public static final String PYR_BILLING_RULES_PAYOR_CHANGE_COMMENT = "Payor change based on Payor Billing Rules";

    // Payor field requirement settings

    /**
     * n/a
     */
    public static final int PYR_FLD_NA = 0;

    /**
     * optional
     */
    public static final int PYR_FLD_OPTIONAL = 1;

    /**
     * recommended
     */
    public static final int PYR_FLD_RECOMMENDED = 2;

    /**
     * required
     */
    public static final int PYR_FLD_REQUIRED = 3;


    // these values map the integer value of a REQ field with the string meaning of the field
    public static final int FLD_OPTIONAL = 1;
    public static final String OPTIONAL = "optional";
    public static final int FLD_RECOMMENDED = 2;
    public static final String RECOMMENDED = "recommended";
    public static final int FLD_REQUIRED = 3;
    public static final String REQUIRED = "required";

    // Screen types (OE)

    /**
     * default screen
     */
    public static final int SCRN_TYP_DEFAULT = 0;

    /**
     * lab screen
     */
    public static final int SCRN_TYP_LAB = 1;

    /**
     * PSC screen
     */
    public static final int SCRN_TYP_PSC = 2;

    /**
     * billing screen
     */
    public static final int SCRN_TYP_BILLING = 4;


    /**
     * default screen name
     */
    public static final String SCRN_TYP_DEFAULT_STR = "DEFAULT";

    /**
     * lab screen names
     */
    public static final String SCRN_TYP_LAB_STR = "LAB";

    public static final String SCRN_TYP_LAB_NOLMRP_STR = "LAB-NOLMRP";

    /**
     * PSC screen name
     */
    public static final String SCRN_TYP_PSC_STR = "PSC";

    /**
     * billing screen names
     */
    public static final String SCRN_TYP_BILLING_STR = "BILLING";

    public static final String SCRN_TYP_BILLING_NOLMRP_STR = "BILLING-NOLMRP";


    public static final String SLA_AUTHNUM_PATTERN = "[0-9A-Za-z ,\\-?\\\"\\'+/=()!.&]{0,50}";


    /**
     * Test Code search
     */
    public static final int TEST_PROF_NULL  = 0;
    public static final int TEST_PROF_PROF  = 1;
    public static final int TEST_PROF_NON   = 2;

    /**
     *  Modifiers.
     */
    public static final String GA_MOD = "GA";
    public static final String MOD = "90";
    public static final String NONFDA_MOD = "NONFDA";
    public static final String GY_MOD = "GY";
    public static final String GZ_MOD = "GZ";
    public static final String PC_MOD = "26";
    public static final String PC_MOD_INT = "26INT";
    public static final String TC_MOD = "TC";
    public static final String GY_GZ_MODS[] = {GY_MOD, GZ_MOD};
    public static final String LR_MOD = "LR";
    public static final String MOD_59 = "59";
    public static final String MOD_76 = "76";
    public static final String MOD_77 = "77";
    public static final String MOD_90 = "90";
    public static final String MOD_91 = "91";
    public static final String MOD_AY = "AY";

    public static final String CD_MOD = "CD";
    public static final String CE_MOD = "CE";
    public static final String CF_MOD = "CF";

    public static final String RT_MOD = "RT";
    public static final String LT_MOD = "LT";

    public static final int MOD_SUPPRESS_NONE = 0;
    public static final int MOD_SUPPRESS_CONSOLIDATION = 1;
    public static final int MOD_SUPPRESS_STATEMENTS = 2;

    //User Groups
    //    I'm just using the PHLEB one, so since this is hard coded data, I'll let the others get
    //    "turned on" as needed and in case someone wants to change the variable names
    public static final int USER_GRP_TYP_NONE = 0;
    public static final int USER_GRP_TYP_PHLEB = 1;

    /**
     * Submit to payor
     */
    public  static final int	LMTD_COV_ABN_ACTN1      = 1;

    /**
     * Submit to secondary payor
     */
    public  static final int	LMTD_COV_ABN_ACTN2      = 2;

    /**
     * Submit to payor
     */
    public  static final int	NON_FDA_ABN_ACTN1 	    = 1;

    /**
     * Submit to secondary payor
     */
    public  static final int	NON_FDA_ABN_ACTN2 	    = 2;

    /**
     * Submit to client
     */
    public  static final int	NON_FDA_NO_ABN_ACTN1    = 1;

    /**
     * Submit to secondary payor
     */
    public  static final int    NON_FDA_NO_ABN_ACTN2    = 2;

    // Message Staus
    public  static final int    MSG_NOT_SENT    = 0;

    // Message Staus
    public  static final int    MSG_SENT_TO_ASSGN_USER = 1;

    // Message Staus
    public  static final int    MSG_SENT_TO_SUPERVISOR = 2;

    //Relationship type (RELSHP_TYP)
    public static final int RELSHP_TYP_NONE = 0;
    public static final int RELSHP_TYP_SELF = 1;
    public static final int RELSHP_TYP_SPOUSE = 2;
    public static final int RELSHP_TYP_CHILD = 3;
    public static final int RELSHP_TYP_OTHER = 4;
    public static final int RELSHP_TYP_UNKNOWN = 5;

    /**
     * @Deprecated Use DbErrorMap.PRC_RMK_JOIN_ACCN
     */
    public static final int RMK_CD_JOIN_ID = 1200;

    //ToDo:  This should probably be in DbErroMap with the rest of the remark codes.
    public static final int RMK_CD_EP_TL_UNASSIGNED = 1305;

    //Accn Super Search Field IDs
    public static final int SRCH_FLD_ACCN       = 1;
    public static final int SRCH_FLD_ACCN_STA   = 2;
    public static final int SRCH_FLD_ADJ_CD     = 3;
    public static final int SRCH_FLD_BAL_DUE    = 4;
    public static final int SRCH_FLD_BAL_DUE_GT = 5;
    public static final int SRCH_FLD_BAL_DUE_LT = 6;
    public static final int SRCH_FLD_CLN        = 7;
    public static final int SRCH_FLD_CONTACT    = 8;
    public static final int SRCH_FLD_CONTRACT   = 9;
    public static final int SRCH_FLD_XREF       = 10;
    public static final int SRCH_FLD_DOS        = 11;
    public static final int SRCH_FLD_DIAG       = 12;
    public static final int SRCH_FLD_FLNG_LMT   = 13;
    public static final int SRCH_FLD_ERR_GRP    = 14;
    public static final int SRCH_FLD_FEE_SCHED  = 15;
    public static final int SRCH_FLD_FIX_ERRS   = 16;
    public static final int SRCH_FLD_PT_L_NM    = 17;
    public static final int SRCH_FLD_PT_F_NM    = 18;
    public static final int SRCH_FLD_BATCH      = 19;
    public static final int SRCH_FLD_EFT        = 20;
    public static final int SRCH_FLD_ERA        = 21;
    public static final int SRCH_FLD_NON_PRM_PYR_GRP    = 22;
    public static final int SRCH_FLD_NON_PRM_PYR        = 23;
    public static final int SRCH_FLD_PHLEB      = 24;
    public static final int SRCH_FLD_FAC        = 25;
    public static final int SRCH_FLD_PRM_PMT    = 26;
    public static final int SRCH_FLD_PROC_CD    = 27;
    public static final int SRCH_FLD_UPIN       = 28;
    public static final int SRCH_FLD_PSC        = 29;
    public static final int SRCH_FLD_RMRK_CD    = 30;
    public static final int SRCH_FLD_ERR_CD     = 31;//22. and any Reason code (note that reason code does not search for no-action codes; it should)
    public static final int SRCH_FLD_REQ        = 32;
    public static final int SRCH_FLD_SEC_PMT    = 33;
    public static final int SRCH_FLD_SSN        = 34;
    public static final int SRCH_FLD_STMNT_STA  = 35;
    public static final int SRCH_FLD_SUBM       = 36;
    public static final int SRCH_FLD_TEST_CD    = 37;
    public static final int SRCH_FLD_PART_PMT   = 45;
    public static final int SRCH_FLD_FIX_RSN_CD = 46;
    public static final int SRCH_FLD_CLN_TYP    = 47;
    public static final int SRCH_FLD_DOB_LT     = 48;
    public static final int SRCH_FLD_DOB_GT     = 49;
    public static final int SRCH_FLD_PT_ID      = 50;
    public static final int SRCH_FLD_PRM_PYR    = 51;
    public static final int SRCH_FLD_TEST_MOD = 53;
    public static final int SRCH_FLD_PROC_MOD = 54;//4. 'Modifier'. This would search through both accn_test and accn_proc modifiers.  Or add seperate 'Test Modifier' and 'Procedure Modifier' if the query would run faster.
    public static final int SRCH_FLD_SUBM_FILE = 55;//5. 'Submission File'
    public static final int SRCH_FLD_AGE_ACCN = 56;//6. 'Age of Accession'.  This age should be calculated by Today - DOS.
    public static final int SRCH_FLD_AGE_ACCN_GREATER = 57;//7. 'Age of Accession >'.  This age should be calculated by Today - DOS.
    public static final int SRCH_FLD_AGE_ACCN_LESS = 58;//8. 'Age of Accession <'.  This age should be calculated by Today - DOS.
    public static final int SRCH_FLD_RPT_DT = 59;//9. Final Reported Date
    public static final int SRCH_FLD_SUBM_SVC = 60;//10. Submission Service
    public static final int SRCH_FLD_SUBS_ID = 61;//11. Subscriber Id
    public static final int SRCH_FLD_OUT_AGNCY = 62;//12. Outside Agency
    public static final int SRCH_FLD_PRIM_PYR_GRP = 64;//13. Primary payor group,
    public static final int SRCH_FLD_ACCNT_DT = 67;//21. Accounting Date
    public static final int SRCH_FLD_REFUND_AMT = 68;//23. Refund Amount > $
    public static final int SRCH_FLD_NO_ACTIVITY = 69;//24. No Activity after last statement (there could be a response from primarypayor, the system submitted to secondary, and then we'd see if there is any activity ono this secondary statement)
    public static final int SRCH_FLD_PYR = 71;//Pyr ID
    public static final int SRCH_FLD_DUN_CYCLE = 72;//Dunning Cycle
    public static final int SRCH_FLD_NARRATIVE_DIAG = 73;//Narrative Diagnosis (y/n)
    public static final int SRCH_FLD_PYR_GRP = 74;//Payor Group
    public static final int SRCH_FLD_CLN_PRODUCT = 75;//Client Product
    public static final int SRCH_FLD_NPI = 79;//NPI
    public static final int SRCH_FLD_PHYS_FNAME = 80;//Physician First Name
    public static final int SRCH_FLD_PHYS_LNAME = 81;//Physician Last Name
    public static final int SRCH_FLD_TEST_TYP = 82;//Test Type CR24848
    public static final int SRCH_FLD_CLN_ST = 83;//Client State CR24842
    public static final int SRCH_FLD_PMT_PLAN = 84;//Payment Plan y/n ?
    public static final int SRCH_FLD_PYR_NAME = 85;//Pyr Name
    public static final int SRCH_FLD_CLN_ZIP  = 86;//Client Zip
    public static final int SRCH_FLD_CLN_NAME  = 87;//Client Name
    public static final int SRCH_FLD_DSLS  = 88;//Days Since Last Statement
    public static final int SRCH_FLD_CLN_QUESTION_14  = 89;//Client Question 14
    public static final int SRCH_FLD_XREF_CLN    = 90; //Xref Client
    public static final int SRCH_FLD_XREF_PYR    = 91; //Xref Payor
    public static final int SRCH_FLD_XREF_TEST   = 92; //Xref Test
    public static final int SRCH_FLD_EPI = 93;
    public static final int SRCH_FLD_CLN_PT_ID = 94;
    public static final int SRCH_FLD_FAC_PT_ID = 95;
    public static final int SRCH_FLD_CLN_FAC = 96;
    public static final int SRCH_FLD_CS_ERR_TYP = 97;
    public static final int SRCH_FLD_RMRK_NOTE = 98;
    public static final int SRCH_FLD_SUBM_PYR = 99;
    public static final int SRCH_FLD_CLR_ID = 100;
    public static final int SRCH_FLD_DOB = 101;
    public static final int SRCH_FLD_RPT_DT_LT = 102;
    public static final int SRCH_FLD_RPT_DT_GT = 103;
    public static final int SRCH_FLD_PYR_CNTCT_ADD = 104;
    public static final int SRCH_FLD_FR_PENDING = 105;
    public static final int SRCH_FLD_PT_ZIP = 106;
    public static final int SRCH_FLD_PT_ST = 107;
    public static final int SRCH_FLD_CLAIM_ID = 108;
    public static final int SRCH_FLD_UNBILLABLE_ERR_TYP = 109;
    public static final int SRCH_FLD_OUT_AGNCY_PRE_CORRESP = 110;
    public static final int SRCH_FLD_OVERRIDE_APPEAL_REASON_CODE= 111; //Override Appeal Reason Code
    public static final int SRCH_FLD_CONTACT_NOTE = 112;
    public static final int SRCH_FLD_CNTCT_INFO = 113;
    public static final int SRCH_FLD_FOLLOW_UP_COMPLETE = 114;
    public static final int SRCH_FLD_OVERRIDE_APPEAL_FOLLOW_UP_REASON_CODE = 115;

    //Accn Super Search Action IDs
    public static final int SRCH_ACTN_RESUBMIT  = 1;
    public static final int SRCH_BULK_CHNG  = 2;
    public static final int SRCH_ACTN_REPRICE  = 3;
    public static final int SRCH_ACTN_WRITEOFF  = 4;
    public static final int SRCH_ACTN_MOVE_TO_PT  = 5;
    public static final int SRCH_ACTN_ADD_NOTE  = 6;
    public static final int SRCH_ACTN_APPEAL  = 7;
    public static final int SRCH_ACTN_REPRICE_AND_CLN_RULES  = 8;
    public static final int SRCH_ACTN_ADD_CHARGE  = 10;
    public static final int SRCH_ACTN_BILLINGASSIGNMENT = 11;
    public static final int SRCH_ACTN_CLAIMSTATUS = 12;
    public static final int SRCH_ACTN_PAYOR_BILLING_RULES = 13;
    public static final int SRCH_ACTN_CHANGE_PRIMARY_PAYOR = 14;

    // Accn Super Search Alias Tables
    public static final String TBL_PT_SEQ_LIST = "pt_seq_list";
    public static final String FLD_PT_SEQ_LIST_SEQ_ID = "pk_seq_id";

    // Accn Super Search Query NewLine Threshold
    public static final int SRCH_NEWLINE_THRESHOLD = 1000;

    //Physician Credential Types from the PHYS_CRED_TYP table
    public static final String PHYS_CRED_TYP_MEDICAL_DOCTOR = "MD";
    public static final String PHYS_CRED_TYP_OSTEOPATHY_OPTOMETRY = "DO";
    public static final String PHYS_CRED_TYP_PODIATRIC_MED = "DPM";
    public static final String PHYS_CRED_TYP_DENTAL_MED = "DM";
    public static final String PHYS_CRED_TYP_DENTAL_SURGERY = "DDS";
    public static final String PHYS_CRED_TYP_CHIROPRACTIC_MED = "DC";
    public static final String PHYS_CRED_TYP_NURSE_PRACTICIONER = "NP";
    public static final String PHYS_CRED_TYP_MIDWIFE = "MW";
    public static final String PHYS_CRED_TYP_DR_OPTOMETRY = "OD";
    public static final String PHYS_CRED_TYP_PHYSICAL_THERAPIST = "PT";
    public static final String PHYS_CRED_TYP_DDM = "DDM";
    public static final String PHYS_CRED_TYP_CH = "CH";
    public static final String PHYS_CRED_TYP_CP = "CP";
    public static final String PHYS_CRED_TYP_PHYSICIAN_ASSISTANT = "PA";


    // physician id types
    public static final int PHYS_ID_TYP_UPIN     = 1;
    public static final int PHYS_ID_TYP_PAYOR_NUMBER = 2;
    public static final int PHYS_ID_TYP_STATE_LICENSE = 3;
    public static final int PHYS_ID_TYP_PAYOR_NUMBER_OR_STATE_LICENSE = 4;

    /** deprecated it should be removed when all references are removed. **/
    public static final int PHYS_ID_TYP_OTHER    = 5;

    public static final int PHYS_ID_TYP_NPI_AND_UPIN    = 5;
    public static final int PHYS_ID_TYP_NPI_AND_PAYOR_NUMBER    = 6;
    public static final int PHYS_ID_TYP_NPI_AND_STATE_LICENSE = 7;
    public static final int PHYS_ID_TYP_NPI_AND_PAYOR_NUMBER_OR_STATE_LICENSE = 8;
    public static final int PHYS_ID_TYP_NPI = 9;
    public static final int PHYS_ID_TYP_NPI_AND_TAXONOMY = 10;

    /**
     * REASSESS_START_OVER forces the accn to re-start the ep process. This
     * is appropriate when an error has been added to an accn.
     */
    public static final int REASSESS_START_OVER = 1;

    /**
     * REASSESS_FORCED_ADVANCE forces the accn to the next ep queue. If it
     * currently isn't in EP, it is equivalent to re-starting ep.
     */
    public static final int REASSESS_FORCED_ADVANCE = 2;

    /**
     * REASSESS_RE_POPULATE_OR_AVDVANCE re-analyzes the errors on the
     * accn, and if there is an active error that allows the accn to
     * remain in its present queue, it will remain there, though it
     * will re-populate the ep error queue. If it there isn't an error
     * which specifies its current queue, it moves on in the ep process.
     */
    public static final int REASSESS_RE_POPULATE_OR_ADVANCE = 3;

    /**
     * country abbrv for USA
     */
    public static final String COUNTRY_USA_NAME = "USA";

    /**
     * country id for USA
     */
    public static final int COUNTRY_USA_ID = 0;

    /**
     * country name for Canada
     */
    public static final String COUNTRY_CANADA_NAME = "CANADA";

    /**
     * country id for Canada
     */
    public static final int COUNTRY_CANADA_ID = 1;

    /**
     * XREF Categories
     */
    public static final int XREF_CAT_CLN = 1;
    public static final int XREF_CAT_FAC = 2;
    public static final int XREF_CAT_UPIN = 3;
    public static final int XREF_CAT_ADJMNT = 4;
    public static final int XREF_CAT_PYR = 5;
    public static final int XREF_CAT_TST = 6;
    public static final int XREF_CAT_PROC = 7;
    public static final int XREF_CAT_PHYS = 8;
    public static final int XREF_CAT_ERR = 9;
    public static final int XREF_CAT_ADJ_FAC = 98;
    public static final int XREF_CAT_GENERIC = 99;

    /**
     * XREF Types
     */

    public static final int XREF_TYP_INVALID = -1;
    public static final int XREF_TYP_VOLUME = 2;
    public static final int XREF_TYP_AGE = 3;
    public static final int XREF_TYP_PHYSICIAN_COMMENT = 4;
    public static final int XREF_TYP_CLN_SALES_REP = 5;
    public static final int XREF_TYP_CLN_REVENUE = 6;
    public static final int XREF_TYP_UPIN_LIS_ID = 7;
    public static final int XREF_TYP_LIS_PHYS_ID = 8;
    public static final int XREF_TYP_PYR = 9;
    public static final int XREF_TYP_BARC_CLIENT = 10;
    public static final int XREF_TYP_BARC_TEST = 11;
    public static final int XREF_TYP_MOL_DX_Z_CODE = 13;
    public static final int XREF_TYP_REGION = 14;
    // 15,16 also used.
    public static final int XREF_TYP_DFLT_PT_LOC_TO_HOME_BOUND = 17;
    public static final int XREF_TYP_CLN = 18;
    // 19,20 also used
    public static final int XREF_TYP_CLIENT_PROVIDER = 21;
    public static final int XREF_TYP_LIS_TEST_ID = 22;
    public static final int XREF_TYP_PROFESSIONAL_TEST = 30;
    public static final int XREF_TYP_PROFESSIONAL_PYR = 31;
    public static final int XREF_TYP_APC_PROC_CD = 32;
    public static final int XREF_TYP_PAYOR_CODE = 33;
    public static final int XREF_TYP_REASON_CODE = 50;
    /**30- 40 are used in BRL **/
    public static final int XREF_TYP_CONTRACT_CHRG = 70;
    public static final int XREF_TYP_WILD_TEST = 74;
    public static final int XREF_TYP_RENDERING_PHYSICIAN_NPI = 100;
    public static final int XREF_TYP_RECON_HOSP = 107;
    public static final int XREF_TYP_CLINPATH_PATHOLOGIST = 108;
    public static final int XREF_TYP_CLINPATH_PYR = 109;
    public static final int XREF_TYP_DEFAULT_DIAGNOSIS = 110;
    public static final int XREF_TYP_PYR_INSURANCE_TYPE = 111;
    public static final int XREF_TYP_GENERIC_INSURANCE_TYPE = 112;
    public static final int XREF_TYP_CLINPATH_BLUECROSS_OVERRIDE = 113;
    public static final int XREF_TYP_MDIL_TPLCODE = 142;
    public static final int XREF_TYP_MONTHLY_NOTE = 200;
    public static final int XREF_TYP_ART28 = 300;
    public static final int XREF_TYP_CLIENT_PROFILE_GDSP_FLAG = 302;
    public static final int XREF_TYP_CLIENT_PROFILE_GDSP_SITE_NUMBER = 303;
    public static final int XREF_TYP_DOD_NUM = 304;
    public static final int XREF_TYP_NET_TERMS = 310;
    public static final int XREF_TYP_FINANCIAL_GROUP = 312;
    public static final int XREF_TYP_ARTICLE28_PAYOR = 400;
    public static final int XREF_TYP_ARTICLE28N_TEST = 401;
    public static final int XREF_TYP_ARTICLE28Y_TEST = 402;
    public static final int XREF_TYP_XAFP_TEST = 403;
    public static final int XREF_TYP_PROC_PHDMD = 404;
    public static final int XREF_TYP_PHYS_PHDMD = 405;
    public static final int XREF_TYP_PHYS_INTERPRETATION = 406;
    public static final int XREF_TYP_BC_PHD_INTERP = 407;
    public static final int XREF_TYP_NO_SPLIT_26_C = 408;
    public static final int XREF_TYP_PARTA_BILL_CLN = 409;
    public static final int XREF_TYP_PRICING_SYMBOL = 410;
    public static final int XREF_TYP_NORCHEM_DES_CONTRACT_NUMBER = 411;
    public static final int XREF_TYP_NORCHEM_COURT_CONTRACT_NUMBER = 412;
    public static final int XREF_TYP_NORCHEM_COURT_INVOICE_NUMBER = 413;
    public static final int XREF_TYP_CHARGE_DESCRIPTION = 414;
    public static final int XREF_TYP_SERVICE_CODE = 415;
    public static final int XREF_TYP_ADJUSTMENT_CODE = 416;
    public static final int XREF_TYP_WATER_TESTS = 417;
    public static final int XREF_TYP_PYR_NTE = 418;
    public static final int XREF_TYP_TST_NTE_ENTRY = 419;
    public static final int XREF_TYP_CLN_NET_TERMS_OVR = 420;
    public static final int XREF_TYP_CLN_STMT_CURRENT_BALANCE_ONLY = 421;
    public static final int XREF_TYP_CURRENCY_CONVERSION = 422;
    public static final int XREF_TYP_SUPPRESS_TEST = 423;
    public static final int XREF_TYP_CORDANT_SDCWS_CONTRACT_NUMBER = 424;
    public static final int XREF_TYP_PHARMA_TEST = 425;
    public static final int XREF_TYP_SUPPRESS_ALL_CPT_CODES = 426;
    public static final int XREF_TYP_EXPORT_EXCEL_TO_XML = 427;
    public static final int XREF_TYP_ALTER_CLN_STMT_SUBM_DT = 428;
    public static final int XREF_TYP_CLN_STMT_CUSTOM_HEADER_TEXT = 429;
    public static final int XREF_TYP_CLN_SUBM_SVCS_ENABLE_CLIENT_SUMMARY_PAGE = 430;

    public static final int XREF_TYP_REND_PHYS_OVERRIDE = 501;      //Physician override        RENDPHYSOR
    public static final int XREF_TYP_REND_PHYS_SUPERVISOR = 502;    //Physician override        RENDSUPERVISOR
    public static final int XREF_TYP_PYR_SUP_PHYS = 503;            //Payor override            RENDSUPPHYS
    public static final int XREF_TYP_REND_PHYS_TAXONOMY = 504;      //Physician override        RENDTAXCD
    public static final int XREF_TYP_REND_PHYS_GRP_TAXONOMY = 505;  //Physician override        RENDTAXGRPCD
    public static final int XREF_TYP_REND_PHYS_AFFILIATE = 506;     //Physician override        RENDAFFLIC
    public static final int XREF_TYP_REND_PHYS_GRP_AFFILIATE = 507; //Physician override        RENDAFFGRPLIC
    public static final int XREF_TYP_ORD_PHYS_CLN_OVERRIDE = 508;   //Payor specific override   CLIENTORDERPHYS
    public static final int XREF_TYP_MOL_DX_PYR = 509;
    public static final int XREF_TYP_MOL_DX_PROC_Z_CODE = 510;
    public static final int XREF_TYP_ENCFACCLN = 511;               //Encounter facility client ENCFACCLN
    public static final int XREF_TYP_ORD_PHYS_OVERRIDE = 512;       //Ordering Physician override  ORDPHYSNAME

    public static final int XREF_TYP_PARENT_CHILD_CLN_RELSHP = 999;

    /** @Deprecated use com.mbasys.mars.persistance.MarsEnumerations.XREF_TYP */
    public static final int XREF_TYP_ARRONFILE = 2000;
    /** @Deprecated use com.mbasys.mars.persistance.MarsEnumerations.XREF_TYP */
    public static final int XREF_TYP_BILLTC = 2001;
    public static final int XREF_TYP_CLN_PROD_TYP_PSC_TO_NOT_PERFORM_OE = 2004;

    public static final int XREF_TYP_WELL_EXAM = 2006;
    public static final int XREF_TYP_WELL_EXAM_AGE = 2007;
    public static final int XREF_TYP_WELL_EXAM_DIAG = 2008;
    public static final int XREF_TYP_AY_MOD = 2100;
    public static final int XREF_TYP_TESTNAMEONCLAIM = 3010;
    public static final int XREF_TYP_LABCOSTONCLAIM = 3020;

    //iRhythm xrefs
    public static final int XREF_TYP_CLN_BILLING_TERMS = 4010;
    public static final int XREF_TYP_IRHYTHM_INVOICE_NUMBER = 4011;

    // File group xref types
    public static final int XREF_TYP_FILE_GROUP_837 = 4020;

    public static final int XREF_TYP_BY_REPORT = 4021;

    public static final int XREF_TYP_GL_HEADER = 4022;

    public static final int XREF_TYP_TEST_TIER = 4023;

    //brli xref
    public static final int XREF_TYP_CLN_COST_CENTER = 10005;

    // Viracor xref types
    public static final int XREF_TYP_PAYMENT_TERMS = 10010;
    public static final int XREF_TYP_TEST_TYPE = 10011;
    public static final int XREF_TYP_CONTRACTED = 10012;

    // BioPharma xref types
    public static final int XREF_TYP_STUDY_NAME = 10024;
    public static final int XREF_TYP_STUDY_NUMBER = 10025;
    public static final int XREF_TYP_PROTOCOL_NUMBER = 10026;

    // VRL xref types
    public static final int XREF_TYP_SUPPLIER_NUMBER = 10016;
    public static final int XREF_TYP_SUPPLIER_SITE = 10017;
    public static final int XREF_TYP_GCOA = 10018;
    public static final int XREF_TYP_VRL_PAYMENT_TERMS = 10019;
    public static final int XREF_TYP_VRL_CLIENT_INVOICE_HEADER = 10020;

    public static final String XREF_TYP_ABBREV_ENCFACCLN = "ENCFACCLN";
    public static final String XREF_TYP_ABBREV_FAC_BANK_ABBREV = "FACBANKABBRV"; // Facility Bank Abbreviation
    public static final String XREF_TYP_ABBREV_SUPPRESSPHYS = "SUPPRESSPHYS";

    public static final String XREF_ABBREV_NOT_COVERED = "NOTCOVERED";
    public static final String XREF_ABBREV_WELL_EXAM_AGE = "WELLEXAM-AGE";
    public static final String XREF_ABBREV_WELL_EXAM_DIAG = "WELLEXAM-DIAG";
    public static final String XREF_ABBREV_WELL_EXAM_DIAG_ICD10 = "WELLEXAM-DIAG-ICD10";

    public static final String XREF_TYP_ABBREV_REVIEWPRICE = "REVIEWPRICE";

    public static final String XREF_TYP_ABBREV_MEASUREMENT = "MEASUREMENT";
    public static final String XREF_TYP_ABBREV_NDUC = "NDUC";
    public static final String XREF_TYP_ABBREV_NDC = "NDC";
    public static final String XREF_TYP_ABBREV_PQ = "PQ";

    public static final String XREF_ABBREV_MD_PHD_FAC_ABBREV = "MD-PHD";
    public static final String XREF_ABBREV_PHD = "PHD";
    public static final String XREF_ABBREV_YES = "YES";
    public static final String XREF_ABBREV_NO = "NO";
    public static final String XREF_ABBREV_PROF = "PROF";
    public static final String XREF_ABBREV_COMP = "COMP";

    public static final String XREF_ABBREV_TPL_STATUS_CODE_01_ADJUDICATED_PAID = "01";
    public static final String XREF_ABBREV_TPL_STATUS_CODE_10_DEDUCTIBLE_NOT_MET = "10";
    public static final String XREF_ABBREV_TPL_STATUS_CODE_99_ZERO_NEGATIVE_PAID = "99";

    // Frequency Types  from FREQ_TYP table
    public static final int FREQ_TYP_DAILY = 1;
    public static final int FREQ_TYP_WEEKLY = 2;
    public static final int FREQ_TYP_MONTHLY = 3;
    public static final int FREQ_TYP_SEMI_ANUALLY = 4;
    public static final int FREQ_TYP_QUARTERLY = 5;


    // Frequency Types from DAILY_CHARGES_FREQ_TYP table
    public static final int DLY_CHRGS_FREQ_TYP_DLY_PT = 1;
    public static final int DLY_CHRGS_FREQ_TYP_DLY_AG = 2;
    public static final int DLY_CHRGS_FREQ_TYP_WKLY_PT = 3;
    public static final int DLY_CHRGS_FREQ_TYP_WKLY_AG = 4;

    /**
     * @Deprecated  Use MiscMap.COUNTRY_USA_ID
     */
    // no other country should be defined here. Go to the country table for all others.
    public static final int CNTRY_USA = 0;

    // compliance log entry types
    public static final int CMPL_LOG_TYP_ACCN_COPAY = 1;
    public static final int CMPL_LOG_TYP_CONS_TABLE_CHANGE = 2;
    public static final int CMPL_LOG_TYP_SPL_PRICE_BELOW_COST = 3;
    public static final int CMPL_LOG_TYP_TEST_PRICE_0 = 4;
    public static final int CMPL_LOG_TYP_DIAG_CODE_CHANGE = 5;
    public static final int CMPL_LOG_TYP_ACCN_REVENUE_ADJ_ADDED = 6;
    public static final int CMPL_LOG_TYP_ACCN_TEST_UPDATE = 7;
    public static final int CMPL_LOG_TYP_PYR_NO_CHARGE_REF_LAB = 8;
    public static final int CMPL_LOG_TYP_OE_NO_CHARGE = 9;
    public static final int CMPL_LOG_TYP_CLN_NO_CHARGE = 10;
    public static final int CMPL_LOG_TYP_CLN_DISPALY_DISCOUNTS = 11;
    public static final int CMPL_LOG_TYP_CLN_NO_CHARGE_REF_LAB = 12;
    public static final int CMPL_LOG_TYP_FLAT_FEE_PROFILE = 13;
    public static final int CMPL_LOG_TYP_TEST_FAC_NONCLN_NO_CHARGE_LAB = 14;


    // Mapping of internet MIME types
    public static final String MIMETYPE_PDF  = "application/pdf";
    public static final String MIMETYPE_XLS  = "application/xls";
    public static final String MIMETYPE_TEXT = "text/plain";
    public static final String MIMETYPE_GIF = "image/gif";
    public static final String MIMETYPE_JPEG = "image/jpeg";
    public static final String MIMETYPE_PNG = "image/png";
    public static final String MIMETYPE_TIFF = "image/tiff";

    //Client Letter Versions
    public static final int CLN_LTR_WELCOME             = 1;
    public static final int CLN_LTR_WELCOME_SPEC        = 2;
    public static final int CLN_LTR_WELCOME_FEE         = 3;
    public static final int CLN_LTR_WELCOME_SPEC_FEE    = 4;
    public static final int CLN_LTR_PAP                 = 5;



    // CreatorId strings for data locking utility

    public static final String ACCN_DEMO_LOCK_CREATOR = "Accn Demographics";
    public static final String EP_LOCK_CREATOR = "EP";
    public static final String PRICEFORCE_LOCK_CREATOR = "Force to Price";
    public static final String PRICERETRO_LOCK_CREATOR = "Retro Price";

    // Patient loc Types
    public static final int PT_LOC_TYP_PSC = 1;
    public static final int PT_LOC_TYP_HM_BOUND = 2;
    public static final int PT_LOC_TYP_PHY_OFFICE = 3;

    public static final String PT_LOC_TYP_PSC_DESCR = "PSC";
    public static final String PT_LOC_TYP_HM_BOUND_DESCR = "HOMEBOUND";
    public static final String PT_LOC_TYP_PHY_OFFICE_DESCR = "DOCTOR OFFICE";

    //Client Account Types
    public static final String CLN_ACCNT_TYP_PRIVATE_PHY_DESCR = "PRIVATE PHYSICIAN";
    public static final String CLN_ACCNT_TYP_PHY_GROUP_DESCR = "PHYSICIAN GROUP";
    public static final String CLN_ACCNT_TYP_HOSPITAL_DESCR = "HOSPITAL";
    public static final String CLN_ACCNT_TYP_IPA_DESCR = "IPA";
    public static final String CLN_ACCNT_TYP_LABORATORY_DESCR = "LABORATORY";
    public static final String CLN_ACCNT_TYP_CLINICAL_TRIAL_DESCR = "CLINICAL TRIALS";
    public static final String CLN_ACCNT_TYP_CHAIN_OF_CUSTODY_DESCR = "CHAIN OF CUSTODY";
    public static final String CLN_ACCNT_TYP_CAPITATED_DESCR = "CAPITATED";
    public static final String CLN_ACCNT_TYP_DIALYSIS_DESCR = "DIALYSIS";
    public static final String CLN_ACCNT_TYP_NURSING_HOME_DESCR = "NURSING HOME";
    public static final String CLN_ACCNT_TYP_ASSISTED_LIVING_DESCR = "ASSISTED LIVING";
    public static final String CLN_ACCNT_TYP_SKILLED_NURSING_FACILITY_DESCR = "SKILLED NURSING FACILITY";
    public static final String CLN_ACCNT_TYP_CUSTODIAL_CARE_FACILITY_DESCR = "CUSTODIAL CARE FACILITY";
    public static final String CLN_ACCNT_TYP_CORRECTIONAL_FACILITY_DESCR = "CORRECTIONAL FACILITY";

    public static final int CLN_ACCNT_TYP_INVALID = 0;
    public static final int CLN_ACCNT_TYP_PRIVATE_PHY_TYPE = 1;
    public static final int CLN_ACCNT_TYP_PHY_GROUP_TYPE = 2;
    public static final int CLN_ACCNT_TYP_HOSPITAL_TYPE = 3;
    public static final int CLN_ACCNT_TYP_IPA_TYPE = 4;
    public static final int CLN_ACCNT_TYP_LABORATORY_TYPE = 5;
    public static final int CLN_ACCNT_TYP_CLINICAL_TRIAL_TYPE = 6;
    public static final int CLN_ACCNT_TYP_CHAIN_OF_CUSTODY_TYPE = 7;
    public static final int CLN_ACCNT_TYP_CAPITATED_TYPE = 8;
    public static final int CLN_ACCNT_TYP_NURSING_HOME_TYPE = 9;
    public static final int CLN_ACCNT_TYP_NURSING_HOME_TYPE_NO_CENSUS = 10;
    public static final int CLN_ACCNT_TYP_DIALYSIS = 17;
    public static final int CLN_ACCNT_TYP_RADIOLOGY_TYPE = 50;
    public static final int CLN_ACCNT_TYP_ASSISTED_LIVING = 51;
    public static final int CLN_ACCNT_TYP_SKILLED_NURSING_FACILITY = 30;
    public static final int CLN_ACCNT_TYP_CUSTODIAL_CARE_FACILITY = 31;
    public static final int CLN_ACCNT_TYP_CORRECTIONAL_FACILITY = 32;
    public static final int CLN_ACCNT_TYP_REHAB_CENTER = 60;
    //Dial Freq Basis
    public static final int DIAL_FREQ_BASIS_NON = 0;
    public static final int DIAL_FREQ_BASIS_CALENDAR = 1;
    public static final int DIAL_FREQ_BASIS_NUM_OF_DAYS = 2;

    //Dial Freq Type
    public static final int DIAL_FREQ_TYP_NON = 0;
    public static final int DIAL_FREQ_TYP_DAILY = 1;
    public static final int DIAL_FREQ_TYP_WEEKLY = 2;
    public static final int DIAL_FREQ_TYP_MONTHLY = 3;
    public static final int DIAL_FREQ_TYP_SEMI_ANNUALLY = 4;
    public static final int DIAL_FREQ_TYP_QUARTERLY = 5;
    public static final int DIAL_FREQ_TYP_ANNUALLY = 6;

    // limited coverage acceptable diag types
    public static final int ACCPT_DIAG_TYP_COVERED = 1;
    public static final int ACCPT_DIAG_TYP_NON_COVERED = 2;
    public static final int ACCPT_DIAG_TYP_EXCL = 3;
    /** @Deprecated use ACCPT_DIAG_TYP_COVERED */
    public static final int ACCPT_DIAG_TYP_INCL_NON_ROUTINE = ACCPT_DIAG_TYP_COVERED;
    /** @Deprecated use ACCPT_DIAG_TYP_NON_COVERED */
    public static final int ACCPT_DIAG_TYP_INCL_ROUTINE = ACCPT_DIAG_TYP_NON_COVERED;
    /** @Deprecated the pre_op type is no loger used */
    public static final int ACCPT_DIAG_TYP_PRE_OP = 4;

    // per diem types
    public static final int PER_DIEM_NO = 0;
    public static final int PER_DIEM_PT_DAY = 1;
    public static final int PER_DIEM_PT_DAY_WITH_SVC = 2;


    //No of Secondary Ids to list in Error message on the client demographics screen for Account type change
    public static final int NO_OF_SCNDY_IDS_IN_ERROR_MSG = 5;

    /** Lab Patient Id **/
    public static final int CSQ_LAB_PT_ID = 12;

    // client specific questions
    public static final int CSQ_CLN_PT_ID = 14; // Client Patient ID

    // Sterling Case Number ID
    public static final int CSQ_STERLING_CASE_NUMBER = 14;

    // client specific questions
    public static final int CSQ_CLN_ADMIT_DOCTOR = 16; // Admitting Doctor Question Id.

    // Client Chart Number
    public static final int CSQ_CLN_CHART_ID = 17;

    // Patient Master Id
    public static final int CSQ_PT_MASTER_ID = 18;

    // BARC Trial ID
    public static final int CSQ_BARC_TRIAL_ID = 19;

    // Final Send
    public static final int CSQ_FINAL_SEND = 20;

    /** client specific question for payor address **/
    public static final int CSQ_PYR_ADDRESS = 21;

    /** client specific question for Client Order Producut **/
    public static final int CSQ_CLN_ORDER_PRODUCT = 22;

    /** scanned response **/
    public static final int CSQ_SCANNED_RESPONSE = 23;

    /** ward response **/
    public static final int CSQ_WARD_RESPONSE = 24;

    /** toxid response **/
    public static final int CSQ_TOXID_RESPONSE = 25;

    /** tox Acct PID response **/
    public static final int CSQ_TOX_ACCT_PID_RESPONSE = 26;

    /** client specific question for hospital facility Id **/
    public static final int CSQ_HOSPITAL_FACILITY_ID = 27;
    /** client specific question for hospital patient Id **/
    public static final int CSQ_HOSPITAL_PATIENT_ID = 28;
    /** client specific question for  HIS order ID**/
    public static final int CSQ_HIS_ORDER_ID = 29;
    /** client specific question for LAB ID **/
    public static final int CSQ_LAB_ID = 30;
    public static final int CSQ_LIS_PHYS = 31;
    public static final int CSQ_LIS_TEST_IDS = 33;
    public static final int CSQ_VISIT_NUMBER = 34;
    public static final int CSQ_TEST_FAC_AND_ABN_FLAG = 35;
    public static final int CSQ_START_DATE = 36;

    public static final int CSQ_APPROVAL_NO = 37;

    public static final int CSQ_HEALTH_NO = 38;
    public static final int CSQ_XAFP_ACCESSION_ID = 41;

    public static final int CSQ_COLLECTED_BY = 50;

    public static final int CSQ_THERANOS_ORDER_NUMBER = 50;

    public static final int CSQ_GENEDX_MRN = 50;

    public static final int CSQ_MDIVERSE_TEST_COMMENTS = 50;

    public static final int CSQ_VRL_ID1 = 50;

    public static final int CSQ_GENEDX_AUTH_NUMBER = 51;

    public static final int CSQ_CLINPATH_ACCOUNT_NUMBER = 51;

    public static final int CSQ_VIRACOR_NUMBER_ORDERED = 51;

    public static final int CSQ_STERLING_ORDER_DATE = 51;

    public static final int CSQ_VRL_ID2 = 51;

    public static final int CSQ_STERLING_CLN_PT_ID = 52;

    public static final int CSQ_VIRACOR_ITEM_NUMBER = 52;

    public static final int CSQ_VRL_ID3 = 52;

    public static final int CSQ_COUNSELOR = 53;

    public static final int CSQ_VIRACOR_LOT_NUMBER = 53;

    public static final int CSQ_VRL_ID4 = 53;

    public static final int CSQ_SOCIAL_WORKER = 54;

    public static final int CSQ_CASE_MANAGER = 55;

    public static final int CSQ_PAROLE_OFFICER = 56;

    public static final int CSQ_GENEDX_LAB_NUMBER = 58;

    public static final int CSQ_SPECIMEN_ID = 58;

    public static final int CSQ_CLN_CASE_NUMBER = 59;

    public static final int CSQ_DONOR_ID = 61;

    public static final int CSQ_GENEDX_PT_ID = 63;

    public static final int CSQ_GROUP_ID = 68;

    public static final int CSQ_FUNDING_SOURCE = 70;

    public static final int CSQ_COMP = 71;

    public static final int CSQ_TPA = 72;

    public static final int CSQ_COLLECTION_SITE = 73;

    //pt_demo_chk status
    public static final int PT_DEMO_CHK_UNPROCESSED = 0;
    public static final int PT_DEMO_CHK_SUCCESS = 1;
    public static final int PT_DEMO_CHK_RETRY = 2;
    public static final int PT_DEMO_CHK_FAILED = 3;

    // BARC Client Statement SUBM SVC ID
    public static final int BARC_SUBM_SVC = 133;

    //accn_lnk types
    public static final int ACCN_LNK_TYP_INVALID = -1;
    public static final int ACCN_LNK_TYP_OBSOLETE = 0;
    public static final int ACCN_LNK_TYP_COMBO = 1;
    public static final int ACCN_LNK_TYP_CAL_HMO = 2;
    public static final int ACCN_LNK_TYP_ADHOC = 3;
    public static final int ACCN_LNK_TYP_RADIOLOGY = 4;
    public static final int ACCN_LNK_TYP_CLN_BILL_REF = 5;
    public static final int ACCN_LNK_TYP_ESRD_DIALYSIS = 6;
    public static final int ACCN_LNK_TYP_CLIENT_BILLING_RULES = 7;
    public static final int ACCN_LNK_TYP_PHYS_PATHOLOGY_SVC = 8;
    public static final int ACCN_LNK_TYP_TEST = 9;
    public static final int ACCN_LNK_TYP_DIRECT_BILLING = 10;
    public static final int ACCN_LNK_TYP_NONFDA = 11;
    public static final int ACCN_LNK_TYP_CLN_BR_NY_ARTICLE_28 = 12;
    public static final int ACCN_LNK_TYP_CLN_BR_CA_XAFP = 13;
    public static final int ACCN_LNK_TYP_OE_SPLIT = 14;
    public static final int ACCN_LNK_TYP_BILLING_ASSIGNMENT_SPLIT = 15;


    public static final String ACCN_LINK_TYPE_DESCR = "";
    public static final String ACCN_LINK_TYPE_OBSOLETE_DESCR = "Obsolete";
    public static final String ACCN_LINK_TYPE_FLOW_AND_MALECULAR_DESCR = "Combination of flow and molecular";
    public static final String ACCN_LINK_TYPE_CA_HMO_DESCR = "California HMO";
    public static final String ACCN_LINK_TYPE_MANUAL_DESCR = "AD HOC/Manual";
    public static final String ACCN_LINK_TYPE_RADIOLOGY_DESCR = "Radiology";
    public static final String ACCN_LINK_TYPE_CLN_BILL_REF_DESCR = "Client Bill Referrals";
    public static final String ACCN_LINK_TYPE_ESRD_DIALYSIS_DESCR = "ESRD Dialysis";
    public static final String ACCN_LINK_TYPE_PHYS_PATHOLOGY_SVC_DESCR = "Technical Component of Physician Pathology Services";
    public static final String ACCN_LINK_TYPE_TEST_DESCR = "Test Level Split";
    public static final String ACCN_LINK_TYPE_DIRECT_BILLING_DESCR = "Direct Billing";
    public static final String ACCN_LINK_TYPE_NONFDA_DESCR = "NonFDA";

    //Accession split types
    public static final String ACCN_SPLIT_TYPE_FLOW_SUFFIX = "XC";
    public static final String ACCN_SPLIT_TYPE_MAN_SUFFIX = "XM";
    public static final String ACCN_SPLIT_TYPE_HMO_SUFFIX = "XP";
    public static final String ACCN_SPLIT_TYPE_RAD_SUFFIX = "R";
    public static final String ACCN_SPLIT_TYPE_CLN_BILL_REF_SUFFIX = "C";
    public static final String ACCN_SPLIT_TYPE_ESRD_SUFFIX = "XD";
    public static final String ACCN_SPLIT_TYPE_PATHOLOGY_SUFFIX = "XG";
    public static final String ACCN_SPLIT_TYPE_TEST_SUFFIX = "XS";
    public static final String ACCN_SPLIT_TYPE_DIRECT_BILLING_SUFFIX = "XDB";
    public static final String ACCN_SPLIT_TYPE_NONFDA_SUFFIX = "XF";

    public static final int ACCN_SPLIT_TYPE_FLOW_LINK = ACCN_LNK_TYP_COMBO;
    public static final int ACCN_SPLIT_TYPE_MAN_LINK = ACCN_LNK_TYP_ADHOC;
    public static final int ACCN_SPLIT_TYPE_HMO_LINK = ACCN_LNK_TYP_CAL_HMO;
    public static final int ACCN_SPLIT_TYPE_RAD_LINK = ACCN_LNK_TYP_RADIOLOGY;
    public static final int ACCN_SPLIT_TYPE_CLN_BILL_REF_LINK = ACCN_LNK_TYP_CLN_BILL_REF;
    public static final int ACCN_SPLIT_TYPE_ESRD_LINK = ACCN_LNK_TYP_ESRD_DIALYSIS;
    public static final int ACCN_SPLIT_TYPE_PATHOLOGY_LINK = ACCN_LNK_TYP_PHYS_PATHOLOGY_SVC;
    public static final int ACCN_SPLIT_TYPE_TEST_LINK = ACCN_LNK_TYP_TEST;
    public static final int ACCN_SPLIT_TYPE_DIRECT_BILLING_LINK = ACCN_LNK_TYP_DIRECT_BILLING;
    public static final int ACCN_SPLIT_TYPE_NONFDA_LINK = ACCN_LNK_TYP_NONFDA;


    //patient types
    public static final int PT_TYP_NULL = 0;
    public static final int PT_TYP_IN = 1;
    public static final int PT_TYP_OUT = 2;
    public static final int PT_TYP_NON = 3;

    //procedure code service types
    public static final int SVC_TYP_DIAG_XRAY = 4;  //AKA Radiology
    public static final int SVC_TYP_DIAG_LAB = 5;
    public static final int SVC_TYP_PATHOLOGY = 100;
    public static final int SVC_TYP_HIGH_RISK_MAMMO = 6;
    public static final int SVC_TYP_LOW_RISK_MAMMO = 7;

    //boolean for getLnkAccnIds
    public static final boolean INCLUDE_OBSOLETE_ACCNS = true;

    //Mesage types
    public static final int MSG_TYP_SUPPRESS_PRC = 1;
    public static final int MSG_TYP_SUPPRESS_PRC_SYS = 2;
    public static final int MSG_TYP_INFO = 3;
    public static final int MSG_TYP_SUPPRESS_PRC_AND_DISPLAY = 4;


    //EpOutSideAgency services
    public static final String SEARCH_AMERICA = "searchAmerica";
    public static final String TEVIXMD = "tevixMD";

    //Ub92 Claim Typ ID
//    public static final int UB92_141 = 1;
//    public static final int UB92_147 = 2;
//    public static final int UB92_148 = 3;

    //Condition Code Type abbrevs
    public static final String CONDITION_CODE_D0 = "D0";
    public static final String CONDITION_CODE_D1 = "D1";
    public static final String CONDITION_CODE_D2 = "D2";
    public static final String CONDITION_CODE_D3 = "D3";
    public static final String CONDITION_CODE_D4 = "D4";
    public static final String CONDITION_CODE_D5 = "D5";
    public static final String CONDITION_CODE_D6 = "D6";
    public static final String CONDITION_CODE_D7 = "D7";
    public static final String CONDITION_CODE_D8 = "D8";
    public static final String CONDITION_CODE_D9 = "D9";
    public static final String CONDITION_CODE_E0 = "E0";
    public static final String CONDITION_CODE_21 = "21";


    /**
     * Claim type not specified.
     */
    public static final int CLAIM_TYP_NOT_SPECIFIED = 0;

    /**
     * Corresponds to abbrev 141.
     */
    public static final int CLAIM_TYP_NEW_141 = 1;
    //   public static final int CLAIM_TYP_NEW = 1;

    /**
     * Corresponds to abbrev 147.
     */
    public static final int CLAIM_TYP_ADJUSTED_147 = 2;
    //   public static final int CLAIM_TYP_ADJUSTED = 2;

    /**
     * Corresponds to abbrev 148.
     */
    public static final int CLAIM_TYP_CANCELLED_148 = 3;
    //   public static final int CLAIM_TYP_CANCELLED = 3;

    /**
     * Corresponds to abbrev 131.
     */
    public static final int CLAIM_TYP_NEW_131 = 4;

    /**
     * Corresponds to abbrev 135.
     */
    public static final int CLAIM_TYP_ADDITIONAL_CHARGES_135 = 5;

    /**
     * Corresponds to abbrev 145.
     */
    public static final int CLAIM_TYP_ADDITIONAL_CHARGES_145 = 14;

    /**
     * Corresponds to abbrev 137.
     */
    public static final int CLAIM_TYP_ADJUSTED_137 = 6;

    /**
     * Corresponds to abbrev 138.
     */
    public static final int CLAIM_TYP_CANCELLED_138 = 7;

    /**
     * Corresponds to abbrev 1.
     */
    public static final int CLAIM_TYP_NEW_1 = 8;

    /**
     * Corresponds to abbrev 7.
     */
    public static final int CLAIM_TYP_REPLACEMENT_7 = 9;

    /**
     * Corresponds to abbrev 8.
     */
    public static final int CLAIM_TYP_CANCELLED_8 = 10;

    /**
     * Corresponds to abbrev 851.
     */
    public static final int CLAIM_TYP_NEW_851 = 11;

    /**
     * Corresponds to abbrev 857.
     */
    public static final int CLAIM_TYP_ADJUSTED_857 = 12;

    /**
     * Corresponds to abbrev 858.
     */
    public static final int CLAIM_TYP_CANCELLED_858 = 13;

    /**
     * Pyr Bill types.
     */
    public static final int BILL_TYP_NONE = 0;
    public static final int BILL_TYP_141_147 = 1;
    public static final int BILL_TYP_141_148 = 2;
    public static final int BILL_TYP_141_147_148 = 3;
    public static final int BILL_TYP_141 = 4;

    public static final int BILL_TYP_131 = 5;
    public static final int BILL_TYP_131_135 = 6;
    public static final int BILL_TYP_131_137 = 7;
    public static final int BILL_TYP_131_138 = 8;
    public static final int BILL_TYP_131_135_137 = 9;
    public static final int BILL_TYP_131_135_138 = 10;
    public static final int BILL_TYP_131_137_138 = 11;
    public static final int BILL_TYP_131_135_137_138 = 12;

    // Professional bill types
    public static final int BILL_TYP_1 = 13;
    public static final int BILL_TYP_1_7 = 14;
    public static final int BILL_TYP_1_8 = 15;
    public static final int BILL_TYP_1_7_8 = 16;

    // Critical Access Hospital bill types
    public static final int BILL_TYP_851 = 17;
    public static final int BILL_TYP_851_857 = 18;
    public static final int BILL_TYP_851_858 = 19;
    public static final int BILL_TYP_851_857_858 = 20;

    public static final int BILL_TYP_141_145 = 21;
    public static final int BILL_TYP_141_145_147 = 22;
    public static final int BILL_TYP_141_145_148 = 23;
    public static final int BILL_TYP_141_145_147_148 = 24;

    /**
     * Pyr Bill types.
     */
/*    public static final int BILL_TYP_NOT_147_OR_148 = 0;
    public static final int BILL_TYP_147 = 1;
    public static final int BILL_TYP_148 = 2;
    public static final int BILL_TYP_147_AND_148 = 3;
  */

    public static final String MSG_PRIO_LOW  = "LOW";
    public static final String MSG_PRIO_MED  = "MED";
    public static final String MSG_PRIO_HIGH = "HIGH";

    /**
     * Payor write-off basis is billed (gross).
     */
    public static final int PYR_AUTO_WO_BASIS_GROSS = 1;
    /**
     * Payor write-off basis is expect.
     */
    public static final int PYR_AUTO_WO_BASIS_EXPECT = 2;

    /**
     * Pyr types
     */
    public static final int PYR_CLN = 3;
    public static final int PYR_PT = 4;
    public static final int PYR_GRN = 5;

    /**
     * Pyr Group types
     */
    public static final int PYR_GRP_CLN = 3;
    public static final int PYR_GRP_PT  = 4;

    /**
     * Address Agency ids
     */
    public static final int AGNCY_SEARCH_AMERICA = 1;
    public static final int AGNCY_TEVIX = 2;
    public static final int AGNCY_TEVIX_PRE = 6;

    /**
     * Diagnosis Agency ids
     */
    public static final int AGNCY_CODERYTE = 3;
    public static final int AGNCY_CODERYTE_PRE = 7;

    /**
     * Physician Agency ids
     */
    public static final int AGNCY_PECOS = 4;
    public static final int AGNCY_PECOS_PRE = 8;

    /**
     * Insurance Discovery Agency ids
     */
    public static final int AGNCY_INSURANCE_DISCOVERY = 5;
    public static final int AGNCY_INSURANCE_DISCOVERY_PRE = 9;

    /**
     * Insurance Discovery Accession Agency Ids
     */
    public static final int AGNCY_INSURANCE_DISCOVERY_ACCESSION = 10;
    public static final int AGNCY_INSURANCE_DISCOVERY_ACCESSION_PRE = 11;

    /**
     * Address Search Accession Agency Ids
     */
    public static final int AGNCY_ADDRESS_SEARCH_ACCESSION = 12;
    public static final int AGNCY_ADDRESS_SEARCH_ACCESSION_PRE = 13;


    /**
     * Payor Service Review Agency Ids
     */
    public static final int AGNCY_ADVANCE_NOTIFICATION_PYR_SVC_REVIEW = 14;
    public static final int AGNCY_ADVANCE_NOTIFICATION_PYR_SVC_REVIEW_PRE = 15;

    /**
     * Payor Physician ROPA Agency Ids
     */
    public static final int AGNCY_PYR_PHYS_ROPA = 16;
    public static final int AGNCY_PYR_PHYS_ROPA_PRE = 17;
    /*
     * Agency Type Ids
     */
    public static final int AGNCY_TYP_NONE      = 0;
    public static final int AGNCY_TYP_ADDRESS   = 1;
    public static final int AGNCY_TYP_DIAG      = 2;
    public static final int AGNCY_TYP_PHYSICIAN = 3;
    public static final int AGNCY_TYP_INSURANCE_DISCOVERY = 4;
    public static final int AGNCY_TYP_PAYOR_SERVICE_REVIEW = 5;
    public static final int AGNCY_TYP_PAYOR_PHYSICIAN_REGISTRATION = 6;

    /**
     * Delivery Method Type, fax.
     */
    public static final int DELVRY_MTHD_TYP_COURIER = 1;
    public static final int DELVRY_MTHD_TYP_FAX = 2;
    public static final int DELVRY_MTHD_TYP_EMAIL = 3;
    public static final int DELVRY_MTHD_TYP_MAIL = 4;
    public static final int DELVRY_MTHD_TYP_XIFIN_MAN = 5;
    public static final int DELVRY_MTHD_TYP_XIFIN_AUTO = 6;
    public static final int DELVRY_MTHD_TYP_XIFIN_SERVER = 7;
    public static final int DELVRY_MTHD_TYP_XIFIN_HOLD = 8;
    public static final int DELVRY_MTHD_TYP_EFAX = 9;
    public static final int DELVRY_MTHD_TYP_WS = 10;
    public static final int DELVRY_MTHD_TYP_SFAX = 11;
    public static final int DELVRY_MTHD_TYP_LUXSCI = 12;
    public static final int DELVRY_MTHD_TYP_CONCORD = 13;
    public static final List<Integer> DELVRY_MTHD_TYPS_AUTOMATED_EMAIL = Collections.singletonList(DELVRY_MTHD_TYP_LUXSCI);
    public static final List<Integer> DELVRY_MTHD_TYPS_AUTOMATED_FAX = new ArrayList<>();
    static
    {
        DELVRY_MTHD_TYPS_AUTOMATED_FAX.add(DELVRY_MTHD_TYP_EFAX);
        DELVRY_MTHD_TYPS_AUTOMATED_FAX.add(DELVRY_MTHD_TYP_SFAX);
        DELVRY_MTHD_TYPS_AUTOMATED_FAX.add(DELVRY_MTHD_TYP_CONCORD);
    }

    /**
     *  Contact Method types - used for Client submission configuration
     *  From the CNTCT_MTHD table
     */
    public static final int CNTCT_MTHD_TYP_CALL = 1;
    public static final int CNTCT_MTHD_TYP_FAX = 2;
    public static final int CNTCT_MTHD_TYP_EMAIL = 3;
    public static final int CNTCT_MTHD_TYP_COURIER = 4;
    public static final int CNTCT_MTHD_TYP_MAIL = 5;

    /**
     * On set types.
     */
    public static final int ONSET_TYP_ACCIDENT = 1;
    public static final int ONSET_TYP_INITIAL_TREATMENT = 2;
    public static final int ONSET_TYP_LAST_MENSTRUAL_PERIOD = 3;
    public static final int ONSET_TYP_CURRENT_ILLNESS_OR_SYMPTOM = 4;

    //On Set Type Abbrev
    public static final String ONSET_TYP_ACCIDENT_ABBREV = "439";
    public static final String ONSET_TYP_INITIAL_TREATMENT_ABBREV = "454";
    public static final String ONSET_TYP_LAST_MENSTRUAL_PERIOD_ABBREV = "484";
    public static final String ONSET_TYP_CURRENT_ILLNESS_OR_SYMPTOM_ABBREV = "431";


    /**
     * Occurrence Codes
     */
    public static final int OCCURRENCE_CODE_TYP_DATE_NOTIFIED_BILL_PROCS = 24;
    public static final String OCCURRENCE_CODE_TYP_DATE_NOTIFIED_BILL_PROCS_ABBREV = "32";

    /**
     * Client product types.
     */
    public static final int CLN_PRODUCT_TYP_HOSPITAL_ADMIT = 1;

    /**
     * Npi types. - per CR #25433 these are the 2 types of NPIs
     */
    public static final int NPI_TYP_INDIVIDUAL = 1;
    public static final String NPI_TYP_ABBREV_INDIVIDUAL = "Individual";
    public static final int NPI_TYP_ORGANIZATION = 2;
    public static final String NPI_TYP_ABBREV_ORGANIZATION = "Organization";

    /**
     * @Deprecated  Use NPI_TYP_INDIVIDUAL
     */
    public static final int NPI_TYP_PHYSICIAN = 1;

    /**
     * Npi entities. - These values replace what we THOUGHT were NPI Types.
     */
    public static final int NPI_ENTITY_CLN = 1;
    public static final String NPI_ENTITY_ABBREV_CLN = "Client";
    public static final int NPI_ENTITY_FAC = 2;
    public static final String NPI_ENTITY_ABBREV_FAC = "Facility";
    public static final int NPI_ENTITY_PHYS = 3;
    public static final String NPI_ENTITY_ABBREV_PHYS = "Physician";

    /**
     * Accn phys types.
     */
    public static final int ACCN_PHYS_TYP_INVALID = 0;
    public static final int ACCN_PHYS_TYP_ORDERING = 1;
    public static final int ACCN_PHYS_TYP_REFERRING = 2;
    public static final int ACCN_PHYS_TYP_PRIMARY = 3;
    public static final int ACCN_PHYS_TYP_RENDERING = 4;

    /**
     * Rendering phys Types.
     */
    public static final int RENDERING_PHYS_ID_TYP_UPIN     = 1;
    public static final int RENDERING_PHYS_ID_TYP_NPI  = 2;
    public static final int RENDERING_PHYS_ID_TYP_AFFILIATED_NUMBER   = 3;
    public static final int RENDERING_PHYS_ID_TYP_AFFILIATED_GROUP_NUMBER = 4;

    /**
     * PHYS_PYR_LIC_TYPE Types
     */
    public static final int PHYS_PYR_LIC_TYP_AFFILIATED_NUMBER = 1;
    public static final int PHYS_PYR_LIC_TYP_AFFILIATED_GROUP_NUMBER = 2;

    /**
     * Procedure Codes
     */
    public static final String PROC_ID_00000 = "00000";

    /**
     * Value Code Type Abbrevs
     */

    public static final String VALUE_CODE_TYP_ESTIMATED_RESPONSIBILITY_PAYOR_A = "A3";
    public static final String VALUE_CODE_TYP_ESTIMATED_RESPONSIBILITY_PAYOR_B = "B3";

    public static final String PHYS_ID_TYP_QUALIFIER_RENDERING = "82";
    public static final String PHYS_ID_TYP_QUALIFIER_PRIMARY = "QB";

    /** This determines where we expect to see a claim id delimiter.  It is an offset that starts at the end of a
     *  claim id and projects backwards*/
    public static int CLAIM_DELIMITER_REAR_OFFSET = 3;

    /** The delimiter that seperates an accession Id and the claim id suffix.
     * Used by submissions an Statements. */
    public static final String CLAIM_ID_DELIMITER = "Z";

    public static final boolean PASS_THIS_TO_USE_ORIGINAL_DB_ACCESS_METHODS = true; // Mostly EBs
    public static final boolean PASS_THIS_TO_USE_NEW_DB_ACCESS_METHODS = false;  // Mostly JDBC

    public static final String ARTICLE28Y = "ART28Y";
    public static final String ARTICLE28N = "ART28N";
    public static final int TEST_TYP_DNA = 1;
    public static final int TEST_TYP_GENETIC_COUNCILING = 2;
    public static final int TEST_TYP_ONCOLOGY = 3;
    public static final int TEST_TYP_REPRODUCTIVE = 4;

    public static final int PAYMENTS = 1;
    public static final int SUSPENSE = 2;
    public static final int NON_AR = 3;
    public static final int DISCREPANCY = 4;
    public static final int PROV_ADJ_TYP_NO_CLAIM_FOUND = 2;
    public static final int DEP_BALACNING = 5;
    public static final int PREVIOUS_BILLING_SYSTEM_PAYMENTS = 6;
    public static final int ASSIGN_SUSP_AS_PMT = 7;

    //Price messages
    public static final int INVALID = 0;
    public static final int SUPPRESS_PRICE = 1;
    public static final int SUPPRESS_PRICE_SYS = 2;
    public static final int INFORMATIONAL = 3;
    public static final int SUPRESS_PRICE_DISPLAY = 4;

    //Billing Assignment types
    public static final Integer BILLING_ASSIGNMENT_UNASSIGNED = 0;
    public static final Integer BILLING_ASSIGNMENT_CLIENT = 1;
    public static final Integer BILLING_ASSIGNMENT_INSURANCE = 2;

    /**
     * Pyr_svc_typ Claim status constants
     */
    public static int PYR_SVC_TYP_CLAIM_STATUS = 1;
    public static int PYR_SVC_TYP_BATCH_CLAIM_STATUS = 2;
    public static int PYR_SVC_TYP_ADVANCE_NOTIFICATION = 3;

    public static List<Integer> getSuppressPriceTypes()
    {
        return Arrays.asList(SUPPRESS_PRICE, SUPPRESS_PRICE_SYS, SUPRESS_PRICE_DISPLAY);
    }

    //Accession payer priorities
    public static final int ACCN_PYR_PRIO_INVALID = 0;
    public static final int ACCN_PYR_PRIO_ONE = 1;
    public static final int ACCN_PYR_PRIO_TWO = 2;

    public static final String USERS_NON = "";
    public static final String USERS_ENGINE_PRICING_USER = "PricingEngine";
    public static final String USERS_ENGINE_ACCN_VALIDATION = "AccnValidationEngine";

    // Valid PDF image file extentions
    public static final String IMG_TYP_GIF = "gif";
    public static final String IMG_TYP_JPEG = "jpeg";
    public static final String IMG_TYP_PNG = "png";
    public static final String IMG_TYP_TIFF = "tiff";
    public static final String IMG_TYP_JPG = "jpg";

    // Valid text file extensions
    public static final String TEXT_FILE_TYP_TXT = "txt";

    // Valid excel file extensions
    public static final String EXCEL_FILE_TYP_XLS = "xls";
    public static final String EXCEL_FILE_TYP_XLSX = "xlsx";
    public static final String[] EXCEL_FILE_TYPES = {EXCEL_FILE_TYP_XLS, EXCEL_FILE_TYP_XLSX};

    // Maximum image file size allowed on the Logo Configuration screen (10,485,760 bytes = 10MB)
    public static final int MAX_IMG_SIZE = 10485760;

    // Logo Configuration form types
    public static final int NO_FORM_TYP = 0;
    public static final int CLN_STMT_FORM_TYP = 1;
    public static final int EP_LTR_FORM_TYP = 2;
    public static final int APPEAL_LTR_FORM_TYP = 3;
    public static final int ANNUAL_DISCLOSURE_LTR_FORM_TYP = 4;
    public static final int WELCOME_LTR_FORM_TYP = 5;
    public static final int PATIENT_STMT_FORM_TYP = 6;

    public static final int APPEAL_LTR_FORM_TYP_NONE = 0;
    public static final int APPEAL_LTR_FORM_TYP_SINGLE = 1;
    public static final int APPEAL_LTR_FORM_TYP_MULTIPLE = 2;

    // EP Letter logo locations
    public static final int EP_LTR_LOGO_LOCATION_NEXT_TO_ADDY = 1;
    public static final int EP_LTR_LOGO_LOCATION_UPPER_LEFT = 2;
    public static final int EP_LTR_LOGO_LOCATION_CENTERED = 3;
    public static final int EP_LTR_LOGO_LOCATION_TOP_MARGIN_CENTERED = 4;

    // Letter logo locations
    public static final int LOGO_LOCATION_UPPER_LEFT = 1;
    public static final int LOGO_LOCATION_CENTERED = 2;
    public static final int LOGO_LOCATION_UPPER_RIGHT = 3;
    public static final int LOGO_LOCATION_TOP_MARGIN_CENTERED = 4;

    public static final String PRC_TBL_TMP_FILE_PREFIX = "PriceTableMaintTemp";

    // QprcLoad Statuses
    public static final int QPRC_STATUS_PENDING_VALIDATION = 1;
    public static final int QPRC_STATUS_PENDING_COPY = 2;
    public static final int QPRC_STATUS_PENDING_RETRO_APPROVAL = 3;
    public static final int QPRC_STATUS_VALIDATE_ERROR = 4;
    public static final int QPRC_STATUS_DENIED_RETRO = 5;
    public static final int QPRC_STATUS_APPROVED_RETRO = 6;

    // Payor Physician Exclusion Types
    public static final int PYR_PHYS_EXCL = 1;
    public static final int OIG_PHYS_EXCL = 2;
    public static final int SAM_PHYS_EXCL = 3;

    // Payor ID in the PYR_PHYS_EXCL table for OIG exclusions will be 0
    public static final int OIG_EXCL_PYR_ID = 0;

    // Migrate Expect Prices from Procedure Code to Test
    public static final String EXPECT_ALLOC_SOURCE_PYR      = "P";
    public static final String EXPECT_ALLOC_SOURCE_MEDICARE = "M";

    public static final String CHARGE_DEP_FOR_TODAY_NOTE = "CLIENT CREDIT DEPOSIT";
    public static final String ACCN_CHARGE_DEP_FOR_TODAY_NOTE = "PATIENT CREDIT DEPOSIT";
    //If updating this, be sure to update GET_CHARGE_PREPMT_DEP_FOR_TODAY in PmtSBBean that uses this note
    public static final String PREPMT_CHARGE_DEP_FOR_TODAY_NOTE = "PATIENT PREPAYMENT DEPOSIT";

    public static final int ELC_PMT_TYP_DISPLAY = 0;
    public static final int ELC_PMT_TYP_SALE    = 1;
    public static final int ELC_PMT_TYP_CREDIT  = 2;
    public static final int ELC_PMT_TYP_VOID    = 3;
    public static final int ELC_PMT_TYP_AUTHORIZE = 4;

    public static final int ELC_CARD_TYP_MASTER_CARD = 1;
    public static final int ELC_CARD_TYP_VISA = 5;

    public static final int ELC_PMT_MTHD_TYP_CREDIT_CARD = 2;
    public static final int ELC_PMT_MTHD_TYP_PINLESS_DEBIT = 3;

    public static final int CLN_BUCKET_TYP_CURRENT = 0;
    public static final int CLN_BUCKET_TYP_30 = 1;
    public static final int CLN_BUCKET_TYP_60 = 2;
    public static final int CLN_BUCKET_TYP_90 = 3;
    public static final int CLN_BUCKET_TYP_120 = 4;
    public static final int CLN_BUCKET_TYP_150 = 5;
    public static final int CLN_BUCKET_TYP_180 = 6;

    public static final String SINGLE_STATEMENT_RESCHED_USER = "SingleStatement";

    public static final int RSNCD_FLD_ADDRESS = -1;
    public static final int RSNCD_FLD_INSURED_ADDRESS1 = 10;
    public static final int RSNCD_FLD_INSURED_ADDRESS2 = 11;
    public static final int RSNCD_FLD_INSURED_ZIP = 12;
    public static final int RSNCD_FLD_INSURED_CITY = 13;
    public static final int RSNCD_FLD_INSURED_STATE = 14;
    public static final int RSNCD_FLD_PATIENT_ADDRESS1 = 121;
    public static final int RSNCD_FLD_PATIENT_ADDRESS2 = 122;
    public static final int RSNCD_FLD_PATIENT_ZIP = 123;
    public static final int RSNCD_FLD_PATIENT_CITY = 124;
    public static final int RSNCD_FLD_PATIENT_STATE = 125;
    public static final int RSNCD_FLD_PATIENT_COUNTRY = 183;
    public static final int RSNCD_FLD_INSURED_COUNTRY = 195;

    /**
     * Unknown Physician Credential Type.
     */
    public static final String PHYS_CRED_TYP_UNK = "UNK";

    //procedure code service types
    public static final int PROC_CD_SVC_LVL_TYP_TECHNICAL_ID    = 1;    // Proc Code Service Level Type is Technical Component
    public static final int PROC_CD_SVC_LVL_TYP_PROFESSIONAL_ID = 2;    // Proc Code Service Level Type is Professional Component
    public static final int PROC_CD_SVC_LVL_TYP_GLOBAL_ID       = 3;    // Proc Code Service Level Type is Global Component

    // DMS "tokens" see CR35247 - START
    public static final String TOKEN_ACCN_ID    = "[#accnid]";
    public static final String TOKEN_PT_ID      = "[#ptid]";
    public static final String TOKEN_USER_ID      = "[#userid]";
    public static final String TOKEN_SOURCE_ID      = "[#sourceid]";
    // DMS "tokens" see CR35247 - END

    /**
     * Refund file types
     */
    public static final int REFUND_FILE_TYP_REFUND_FILE = 1;
    public static final int REFUND_FILE_TYP_REFUND_CHECK = 2;
    public static final int REFUND_FILE_TYP_REFUND_FILE_AND_CHECK = 3;

    public static final int CONS_DIAG_REQ_NA = 0;
    public static final int CONS_DIAG_REQ_NONE = 1;
    public static final int CONS_DIAG_REQ_ONE = 2;
    public static final int CONS_DIAG_REQ_ALL = 3;

    public static final int CONS_PYR_PROC_TYP_UNIT_LIMIT = 1;
    public static final int CONS_PYR_PROC_TYP_MOD76_77 = 2;
    public static final int CONS_PYR_PROC_TYP_MOD91 = 3;

    public static final String IMPORT_ENGINE_TYP_IMPORT = "IMPORT";
    public static final String IMPORT_ENGINE_TYP_CLN_PMT_IMPORT = "CLNPMT";

    /**
     * Claim Actions
     */
    public static final String SUBMIT_CLAIM_ACTION_ORIGINAL_VALUE = "original";
    public static final String SUBMIT_CLAIM_ACTION_ORIGINAL_DISPLAY = "Original";
    public static final String SUBMIT_CLAIM_ACTION_CORRECTED_VALUE = "corrected";
    public static final String SUBMIT_CLAIM_ACTION_CORRECTED_DISPLAY = "Replacement";
    public static final String SUBMIT_CLAIM_ACTION_CORRECTEDFULL_VALUE = "correctedfullaccession";
    public static final String SUBMIT_CLAIM_ACTION_CORRECTEDFULL_DISPLAY = "Replacement - Full Accession";
    public static final String SUBMIT_CLAIM_ACTION_CANCELLED_VALUE = "void";
    public static final String SUBMIT_CLAIM_ACTION_CANCELLED_DISPLAY = "Cancelled";
    public static final String SUBMIT_CLAIM_ACTION_LATECHARGE_VALUE = "latecharge";
    public static final String SUBMIT_CLAIM_ACTION_LATECHARGE_DISPLAY = "Late Charge";

    /**
     * Claim frequency codes
     */
    public static final String CLAIM_FREQ_CODE_ORIGINAL = "1";
    public static final String CLAIM_FREQ_CODE_LATECHARGE = "5";
    public static final String CLAIM_FREQ_CODE_REPLACEMENT = "7"; // Corrected
    public static final String CLAIM_FREQ_CODE_VOID = "8"; // Cancelled

    /**
     * Bank File Type Formats
     */
    public static final String BANK_FILE_FMT_TYP_BAI2 = "BAI2";
    public static final String BANK_FILE_FMT_TYP_CSV = "CSV";

    public static final int BIGDATA_STA_ID_UNMATCHED = 10;
    public static final int BIGDATA_STA_ID_AMT_NOT_PROVIDED = 20;
    public static final int BIGDATA_STA_ID_AMT_INVALID = 21;
    public static final int BIGDATA_STA_ID_PMT_EFF_DT_NOT_PROVIDED = 30;
    public static final int BIGDATA_STA_ID_PMT_EFF_DT_INVALID = 31;
    public static final int BIGDATA_STA_ID_ERA_FILE_NAME_NOT_PROVIDED = 40;
    public static final int BIGDATA_STA_ID_DUPLICATE_BIGDATA_ENTRY = 50;
    public static final int BIGDATA_STA_ID_NO_DEP_YET = 70;
    public static final int BIGDATA_STA_ID_SET_DATA_ERR_BT = 81;
    public static final int BIGDATA_STA_ID_SET_DATA_ERR_DBT = 82;
    public static final int BIGDATA_STA_ID_COMPLETE = 99;

    public static final String BANK_DEP_MATCH_TYP_BIGDATA = "B";

    /**
     * Common DNL_TBL_IDs
     */
    public static final int DNL_TBL_ID_CS_ACK = 232; // Claim Status acknowledgement codes
    public static final int DNL_TBL_ID_CS_REJ = 233; // Claim Status rejection codes
    public static final int DNL_TBL_ID_CS_DEN = 234; // Claim Status denial codes
    public static final int DNL_TBL_ID_CH = 235; // Clearinghouse denial table

    /**
     * System setting values for Patient ID system setting (85)
     */
    public static final int SS_PATIENT_ID_TYPE_VALUE_EPI_ONLY = 0;
    public static final int SS_PATIENT_ID_TYPE_VALUE_CLIENT_ONLY = 1;
    public static final int SS_PATIENT_ID_TYPE_VALUE_EPI_CLN_FAC = 2;

    /**
     * System setting values for "Allow multiple units on profiles that are set to explode" (1845)
     * 0 = A profile submitted with multiple units will be processed as a single unit profile.
     * 1 = A Profile submitted with multiple units will result in multiple single unit profiles
     * 2 = A Fixed Profile submitted with multiple units will result in one profile with multiple units.
     */
    public static final int SS_MULTI_UNITS_PROF_PROCESSED_AS_SINGLE_UNIT_PROF = 0;
    public static final int SS_SET_MULTI_UNIT_PROF_TO_MULTI_ONE_UNIT_PROF_DIVIDE_MANUAL_PRC_BY_UNITS_IF_SENT = 1;
    public static final int SS_FIXED_MULTI_UNITS_PROF_RESULT_ONE_PROF_WITH_MULTI_UNITS = 2;

    // Mapped values for PT_ID_TYP
    public static final int PT_ID_TYP_EPI = 1;
    public static final int PT_ID_TYP_CLIENT = 2;
    public static final int PT_ID_TYP_FACILITY = 3;

    // used by EPI CR37147 in the Super Search Servlet and the Accn Srch Results page
    public static final String CLN_ORDERING_FAC_ALIAS = "clnOrderingFac";
    public static final String CLN_SPECIFIC_PT_ID_ALIAS = "clnSpecificPtId";
    public static final String FAC_SPECIFIC_PT_ID_ALIAS = "facSpecificPtId";

    public static final String FAC_CLN = "fac_cln";
    public static final String FAC_ORDER_FAC = "fac_ordering_fac";
    public static final String PHLEB_FAC_ABBRV = "phleb_fac_abbrv";
    public static final String ACCN_TEST_FAC_POS = "accn_test_fac_pos";

    public static final String ADJ_ABBRV = "adj_abbrv";
    public static final String ACCN_STATUS = "accn_status";
    public static final String ACCTNG_DT = "acctng_dt";
    public static final String AGE_OF_DOS = "age_of_dos";
    public static final String CS_ERROR_TYPE = "cs_error_type";
    public static final String CLN_PRODUCT = "cln_product";
    public static final String CLN_STATE = "cln_state";
    public static final String CLN_TYPE = "cln_type";
    public static final String CLN_ZIP = "cln_zip";
    public static final String CONTACT_FILTER = "contact";
    public static final String CONTRACT_FILTER = "contract";
    public static final String LAST_STMT_DT = "last_stmt_dt";
    public static final String DIAG_CD = "diag_cd";
    public static final String DOB = "dob";
    public static final String DUN_CYCLE = "dun_cycle";
    public static final String ERR_GRP = "err_grp";
    public static final String FEE_SCHED = "fee_sched";
    public static final String FINAL_RP_DT = "final_rp_dt";
    public static final String REQ_ID = "req_id";
    public static final String ERR_FIX_DT = "err_fix_dt";
    public static final String FIX_RS_CD = "fix_rs_cd";
    public static final String DIAG_ABB = "diag_abb";
    public static final String NPI_ID = "npi_id";
    public static final String OUT_AGEN = "out_agen";
    public static final String EFT_ID = "eft_id";
    public static final String ERA_ID = "era_id";
    public static final String PMT_BATCH_ID = "pmt_batch_id";
    public static final String PYR_GRP = "pyr_grp";
    public static final String PYR_ID = "pyr_id";
    public static final String NON_PRM_PYR_ID = "non_prm_pyr_id";
    public static final String PRM_PYR_ID = "prm_pyr_id";
    public static final String SBM_PYR_ID = "subm_pyr_id";
    public static final String PYR_NM = "pyr_nm";
    public static final String PHLEB_ID = "phleb_id";
    public static final String PROC_ID = "proc_id";
    public static final String PROC_ID_IN_ERR = "proc_id_in_err";
    public static final String RSN_CD_TB = "rsn_cd_tb";
    public static final String RSN_CD = "rsn_cd";
    public static final String RMK_CD = "rmk_cd";
    public static final String RMK_NT = "rmk_nt";
    public static final String STMT_STAT = "stmt_stat";
    public static final String SUBM_FILE = "subm_file";
    public static final String SUBM_SRV = "subm_srv";
    public static final String SUBSCRBR_ID = "subscrbr_id";
    public static final String TEST_ID = "test_id";
    public static final String TEST_TYP = "test_typ";
    public static final String UPIN_ID = "upin_id";
    public static final String XREF_ADJ = "xref_adj";
    public static final String XREF_CLN = "xref_cln";
    public static final String XREF_FAC = "xref_fac";
    public static final String XREF_PYR = "xref_pyr";
    public static final String XREF_PHYS = "xref_phys";
    public static final String XREF_PROC = "xref_proc";
    public static final String XREF_TEST = "xref_test";
    public static final String XREF_UPIN = "xref_upin";
    public static final String PROC_MOD = "proc_mod";
    public static final String TEST_MOD = "test_mod";
    public static final String RFND_AMT = "rfnd_amt";
    public static final String POS = "pos";
    public static final String CH_ID = "ch_id";
    public static final String ACCN_ACTIVITY = "accn_last_activity";
    public static final String ASSIGN_DT = "assgn_dt"; /*Assign Date*/
    public static final String ASSGND = "b_assgnd"; /*Assigned(y/n)*/
    public static final String NAR_DIAG = "narrative_diagnosis";
    public static final String FLNG_LMT = "filing_time_lmt";
    public static final String DAYS_IN_QUEUE = "days_in_queue";
    public static final String PSC_ID = "psc_id";
    public static final String PT_F_NM = "pt_f_nm";
    public static final String PT_L_NM = "pt_l_nm";

    public static final String ACCN_ADJ_F = "ACCN_ADJ_F";
    public static final String ACCN_CNTRCT_F = "ACCN_CNTRCT_F";
    public static final String ACCN_DIAG_CD_F = "ACCN_DIAG_CD_F";
    public static final String ACCN_ERR_GRP_F = "ACCN_ERR_GRP_F";
    public static final String ACCN_FEE_SCHLD_F = "ACCN_FEE_SCHLD_F";
    public static final String ACCN_PMT_BATCH_F = "ACCN_PMT_BATCH_F";
    public static final String ACCN_EFT_ID_F = "ACCN_EFT_ID_F";
    public static final String ACCN_ERA_ID_F = "ACCN_ERA_ID_F";
    public static final String ACCN_PYR_GRP_F = "ACCN_PYR_GRP_F";
    public static final String ACCN_PYR_F = "ACCN_PYR_F";
    public static final String ACCN_PRM_PYR_F = "ACCN_PRM_PYR_F";
    public static final String ACCN_NON_PRM_PYR_F = "ACCN_NON_PRM_PYR_F";
    public static final String ACCN_SUBM_PYR_F = "ACCN_SUBM_PYR_F";
    public static final String ACCN_POS_F = "ACCN_POS_F";
    public static final String ACCN_PROC_ID_F = "ACCN_PROC_ID_F";
    public static final String ACCN_PROC_ID_IN_ERR_F = "ACCN_PROC_ID_IN_ERR_F";
    public static final String ACCN_UPIN_F = "ACCN_UPIN_F";
    public static final String ACCN_NPI_F = "ACCN_NPI_F";
    public static final String ACCN_RMK_CD_F = "ACCN_RMK_CD_F";
    public static final String ACCN_RSN_CD_TB_F = "ACCN_RSN_CD_TB_F";
    public static final String ACCN_RSN_CD_F = "ACCN_RSN_CD_F";
    public static final String ACCN_STMT_STAT_F = "ACCN_STMT_STAT_F";
    public static final String ACCN_TEST_ID_F = "ACCN_TEST_ID_F";
    public static final String ACCN_ERR_FIX_DT_F = "ACCN_ERR_FIX_DT_F";
    public static final String ACCN_FIX_REASON_CD_F = "ACCN_FIX_REASON_CD_F";
    public static final String ACCN_TEST_MOD_F = "ACCN_TEST_MOD_F";
    public static final String ACCN_PROC_MOD_F = "ACCN_PROC_MOD_F";
    public static final String ACCN_SUBM_FILE_F = "ACCN_SUBM_FILE_F";
    public static final String ACCN_SUBM_SRV_F = "ACCN_SUBM_SRV_F";
    public static final String ACCN_SUBSCRBR_F = "ACCN_SUBSCRBR_F";
    public static final String ACCN_OUT_AGEN_F = "ACCN_OUT_AGEN_F";
    public static final String ACCN_RFND_AMT_F = "ACCN_RFND_AMT_F";
    public static final String ACCN_DUN_CYCLE_F = "ACCN_DUN_CYCLE_F";
    public static final String ACCN_DIAG_ABBRV_F = "ACCN_DIAG_ABBRV_F";
    public static final String ACCN_IS_NAR_DIAG_F = "ACCN_IS_NAR_DIAG_F";
    public static final String ACCN_TEST_TYP_F = "ACCN_TEST_TYP_F";
    public static final String ACCN_PYR_NM_F = "ACCN_PYR_NM_F";
    public static final String ACCN_LAST_STMT_DT_F = "ACCN_LAST_STMT_DT_F";
    public static final String ACCN_XREF_CLN_F = "ACCN_XREF_CLN_F";
    public static final String ACCN_XREF_FAC_F = "ACCN_XREF_FAC_F";
    public static final String ACCN_XREF_PYR_F = "ACCN_XREF_PYR_F";
    public static final String ACCN_XREF_TEST_F = "ACCN_XREF_TEST_F";
    public static final String ACCN_XREF_UPIN_F = "ACCN_XREF_UPIN_F";
    public static final String ACCN_CS_ERROR_F = "ACCN_CS_ERROR_F";
    public static final String ACCN_RMK_NT_F = "ACCN_RMK_NT_F";
    public static final String ACCN_CH_ID_F = "ACCN_CH_ID_F";
    public static final String ACCN_LAST_ACTIVITY_F = "ACCN_LAST_ACTIVITY_F";
    public static final String ACCN_DAY_TIL_F = "ACCN_DAY_TIL_F";
    public static final String ACCN_PSC_ID_F = "ACCN_PSC_ID_F";


    // used by function SQL to CR32254 in the EP Search
    public static final String EP_DIAG_CD_F = "EP_DIAG_CD_F"; 		/*Filter 11*/
    public static final String EP_ERR_GRP_F = "EP_ERR_GRP_F"; 		/*Filter 13*/
    public static final String EP_PROC_ID_F = "EP_PROC_ID_F"; 		/*Filter 22*/
    public static final String EP_UPIN_F = "EP_UPIN_F"; 			/*Filter 23*/
    public static final String EP_RSN_CD_F = "EP_RSN_CD_F"; 		/*Filter 24*/
    public static final String EP_RMK_CD_F = "EP_RMK_CD_F";			/*Filter 26*/
    public static final String EP_TEST_ID_F = "EP_TEST_ID_F"; 		/*Filter 27*/
    public static final String EP_ADJ_F = "EP_ADJ_F"; 				/*Filter 39*/
    public static final String EP_POS_F = "EP_POS_F"; 				/*Filter 46*/
    public static final String EP_TEST_TYP_F = "EP_TEST_TYP_F"; 	/*Filter 65*/
    public static final String EP_PYR_NM_F = "EP_PYR_NM_F"; 		/*Filter 69*/
    public static final String EP_XREF_CLN_F = "EP_XREF_CLN_F"; 	/*Filter 73*/
    public static final String EP_XREF_ADJ_F = "EP_XREF_ADJ_F"; 	/*Filter 74*/
    public static final String EP_XREF_PYR_F = "EP_XREF_PYR_F"; 	/*Filter 75*/
    public static final String EP_XREF_TEST_F = "EP_XREF_TEST_F"; 	/*Filter 76*/
    public static final String EP_XREF_PROC_F = "EP_XREF_PROC_F"; 	/*Filter 77*/
    public static final String EP_XREF_PHYS_F = "EP_XREF_PHYS_F"; 	/*Filter 78*/
    public static final String EP_CS_ERROR_F = "EP_CS_ERROR_F"; 	/*Filter 85*/


    public static final int PHYS_SPECIALITY_TYPE_NEPHROLOGY = 39;

    public static final int DIAL_TYP_HEMO = 1;
    public static final int DIAL_TYP_CAPD = 2;
    public static final int DIAL_TYP_CCPD = 3;
    public static final int DIAL_TYP_IPD  = 4;
    public static final int DIAL_TYP_ESRD = 5;

    // non-client tax types
    public static final int PYR_TAX_TYPE_DO_NOT_BILL = 0;
    public static final int PYR_TAX_TYPE_BUILT_INTO_FS = 1;
    public static final int PYR_TAX_TYPE_BILL_ON_CLAIM = 2;

    public static final int BILL_RENAL_TEST_TO_CLN   = 1;
    public static final int BILL_RENAL_TEST_TO_PAYOR = 2;

    public static final int CLN_BILLING_CATEGORY_PRC_TYP_MONTHLY_CAP_RATE = 1;
    public static final int CLN_BILLING_CATEGORY_PRC_TYP_FEE_SCHEDULE     = 2;

    // Patient Suspense Reason Type IDs
    public static final int PT_SUSPEND_REASON_TYP_ID_ADDRESS = 1;
    public static final int PT_SUSPEND_REASON_TYP_ID_PT_NEW_REVIEW = 2;
    public static final int PT_SUSPEND_REASON_TYP_ID_PT_UPDATED_REVIEW = 3;
    public static final int PT_SUSPEND_REASON_TYP_ID_OTHER = 4;

    //Client Question - Purchase Order NO
    public static final int ACCN_CLN_Q_PURCHASE_ORDER_REQUESTER = 10000;
    public static final int ACCN_CLN_Q_PURCHASE_ORDER_NO = 10001;
    public static final int ACCN_CLN_Q_REG_DT = 10002;

    // System Setting 4050 indexes
    public static final int SS_4050_RSN_GRP_IDX = 0;
    public static final int SS_4050_CARC_IDX    = 1;

    //Pyr Pyr Link Type Mapping
    public static final int PYR_PYR_LINK_TYP_IDENTIFICATION = 1;

    //DocStore Category Map
    public static final String DOC_STORE_CATEGORY_ACCN = "Accession";
    public static final String DOC_STORE_CATEGORY_CLN = "Client";
    public static final String DOC_STORE_CATEGORY_PAYOR = "Payor";
    public static final String DOC_STORE_CATEGORY_SYSTEM = "System";
    public static final String DOC_STORE_CATEGORY_PATIENT = "Patient";

    public static final String DOC_STORE_TYP_APPEAL = "APPEAL";
    public static final String DOC_STORE_TYP_XIFIN_ATTACHMENT = "xifinattach";

    // CR 32946
    public static final String PYR_NO_BILL = "PYRNOBILL";

    // basis types for OePostingHoldRuleLogic
    public static final String OE_POSTING_HOLD_BASIS_TYPE_FR = "FR";
    public static final String OE_POSTING_HOLD_BASIS_TYPE_LDT = "LDT";
    public static final String OE_POSTING_HOLD_BASIS_TYPE_DOS = "DOS";

    public static final int PYR_GEMS_LOGIC_DEFAULT = 0;
    public static final int PYR_GEMS_LOGIC_YES = 1;
    public static final int PYR_GEMS_LOGIC_NO = 2;

    public static final int DIAG_GEM_TYP_ICD10_TO_9 = 109;
    public static final int DIAG_GEM_TYP_ICD9_TO_10 = 910;

    //Void types for accn_diag_del
    public static final int DIAG_VOID_TYP_USER = 0;
    public static final int DIAG_VOID_TYP_DIAG_TYP = 1;
    public static final int DIAG_VOID_TYP_GEMS = 2;

    //Artificial diag void types.  These are flags to help with the validation logic and are not actually saved with the records
    public static final int DIAG_VOID_TYP_DELETE = -1;  //Delete without an AccnDiagDel
    public static final int DIAG_VOID_TYP_RES = -2;  //Resurrected AccnDiagDel

    public static final String DIAG_GEMS_USER = "GEMS";
    public static final String DIAG_GEMS_CMNT = "GEMS from ";

    // Types used for determining whether or not a submission file is approved to display on client portal
    public static final int STMT_APPROVED_TYP_PENDING_REVIEW = 0;
    public static final int STMT_APPROVED_TYP_APPROVED = 1;
    public static final int STMT_APPROVED_TYP_NOT_APPROVED = 2;

    public static final String STMT_APPROVED_TYP_PENDING_REVIEW_STRING = "Pending Review";
    public static final String STMT_APPROVED_TYP_APPROVED_STRING = "Approved";
    public static final String STMT_APPROVED_TYP_NOT_APPROVED_STRING = "Not Approved";

    //Override Types
    public static final String OVERRIDE_BY_CLIENT = "Client";
    public static final String OVERRIDE_BY_CLIENT_ACCNT_TYPE = "Client Account Type";
    public static final String OVERRIDE_BY_PAYOR = "Payor";
    public static final String OVERRIDE_BY_PAYOR_GRP = "Payor Group";
    public static final int INVALID_OVERRIDE_ID = -1;

    // Sub-client invoice disable options
    public static final int DISABLE_SUB_CLIENT_NONE = 0;
    public static final int DISABLE_SUB_CLIENT_CHARGES = 1;
    public static final int DISABLE_SUB_CLIENT_INVOICES = 2;

    // Client Statement reprice adjustments display options
    public static final int CLN_STMT_DISPLAY_REPRICE_ADJS_SUM_MONTHLY = 1;
    public static final int CLN_STMT_DISPLAY_REPRICE_ADJS_SUM_ALL = 2;

    public static final int FAC_BILL_TO_OVERRIDE_LNK_TYP_PYR_INCLUSION = 1;
    public static final int FAC_BILL_TO_OVERRIDE_LNK_TYP_PYR_EXCLUSION = 2;
    public static final int FAC_BILL_TO_OVERRIDE_LNK_TYP_PYR_GRP_INCLUSION = 3;
    public static final int FAC_BILL_TO_OVERRIDE_LNK_TYP_PYR_GRP_EXCLUSION = 4;
    public static final int FAC_BILL_TO_OVERRIDE_LNK_TYP_CLN_ACCNT_TYP = 5;
    public static final int FAC_BILL_TO_OVERRIDE_LNK_TYP_SVC_TYP = 6;
    public static final int FAC_BILL_TO_OVERRIDE_LNK_TYP_SVC_LVL_TYP = 7;
    public static final int FAC_BILL_TO_OVERRIDE_LNK_TYP_PROC_CD = 8;
    public static final int FAC_BILL_TO_OVERRIDE_LNK_TYP_REND_PHYS_XREF = 9;

    public static final String BASIS_PYR_BILLING_RULE_TYP_PYR = "PAYOR";
    public static final String BASIS_PYR_BILLING_RULE_TYP_PYR_GRP = "PAYOR GROUP";

    public static final int PYR_BILLING_RULES_TYP_ID_SUB_ID = 1;
    public static final int PYR_BILLING_RULES_TYP_ID_INSURED_GRP_ID = 2;

    public static final int PT_NOTIF_LTR_CONFIG_LNK_TYP_PYR_GRP_INCL = 1;
    public static final int PT_NOTIF_LTR_CONFIG_LNK_TYP_PYR_GRP_EXCL = 2;
    public static final int PT_NOTIF_LTR_CONFIG_LNK_TYP_PYR_INCL = 3;
    public static final int PT_NOTIF_LTR_CONFIG_LNK_TYP_PYR_EXCL = 4;
    public static final int PT_NOTIF_LTR_CONFIG_LNK_TYP_CLN_ACCNT_TYP_INCL = 5;
    public static final int PT_NOTIF_LTR_CONFIG_LNK_TYP_CLN_ACCNT_TYP_EXCL = 6;
    public static final int PT_NOTIF_LTR_CONFIG_LNK_TYP_CLN_INCL = 7;
    public static final int PT_NOTIF_LTR_CONFIG_LNK_TYP_CLN_EXCL = 8;
    public static final int PT_NOTIF_LTR_CONFIG_LNK_TYP_TAXONOMY_CD_INCL = 9;
    public static final int PT_NOTIF_LTR_CONFIG_LNK_TYP_TAXONOMY_CD_EXCL = 10;
    public static final int PT_NOTIF_LTR_CONFIG_LNK_TYP_TEST_TYP_INCL = 11;
    public static final int PT_NOTIF_LTR_CONFIG_LNK_TYP_TEST_TYP_EXCL = 12;
    public static final int PT_NOTIF_LTR_CONFIG_LNK_TYP_TEST_INCL = 13;
    public static final int PT_NOTIF_LTR_CONFIG_LNK_TYP_TEST_EXCL = 14;
    public static final int PT_NOTIF_LTR_CONFIG_LNK_TYP_CLN_PRIM_FAC_INCL = 15;
    public static final int PT_NOTIF_LTR_CONFIG_LNK_TYP_CLN_PRIM_FAC_EXCL = 16;
    public static final int PT_NOTIF_LTR_CONFIG_LNK_TYP_MOD_INCL = 17;
    public static final int PT_NOTIF_LTR_CONFIG_LNK_TYP_MOD_EXCL = 18;
    public static final int PT_NOTIF_LTR_CONFIG_LNK_TYP_CLN_STATE_INCL = 19;
    public static final int PT_NOTIF_LTR_CONFIG_LNK_TYP_CLN_STATE_EXCL = 20;
    public static final int PT_NOTIF_LTR_CONFIG_LNK_TYP_CLN_QUESTION_RESPONSE = 21;

    public static final String TEST_MSG_SPECIAL_DISCOUNT_FLAG_ABBREV = "SPDISCFLAG";

    // Patient Estimation Benefit Types
    public static final int PT_ESTIMATION_BENEFIT_TYP_COPAYMENT = 1;
    public static final int PT_ESTIMATION_BENEFIT_TYP_DEDUCTIBLE = 2;
    public static final int PT_ESTIMATION_BENEFIT_TYP_COINSURANCE = 3;
    public static final int PT_ESTIMATION_BENEFIT_TYP_NOCOVERED = 4;

    public static final int PROF_TYP_FIXED = 0;
    public static final int PROF_TYP_FLEXIBLE = 1;
    public static final int PROF_TYP_ADHOC = 2;

    // Facility Type
    public static final int APPEAL_LETTER_MAIN_FAC = 0;
    public static final int APPEAL_LETTER_CLN_ORDERING_FAC = 1;
    public static final int APPEAL_LETTER_ACCN_BILLING_FAC = 2;
    public static final int EP_LETTER_MAIN_FAC = 0;
    public static final int EP_LETTER_CLN_ORDERING_FAC = 1;

    // Patient Letter Facility Type
    public static final int PATIENT_STMT_LETTER_MAIN_FAC = 0;
    public static final int PATIENT_STMT_LETTER_CLN_ORDERING_FAC = 1;
    public static final int PATIENT_STMT_LETTER_ACCN_BILLING_FAC = 2;

    // import omit types
    public static final int OMIT_INCOMPLETE = 10;
    public static final int OMIT_DUPLICATE = 30;
    public static final int OMIT_IGNORE = 50;

    // Patient Estimation Status Types
    public static final int PT_ESTIMATION_STA_TYP_SENT_TO_PATIENT = 4;
    public static final int PT_ESTIMATION_STA_TYP_OBSOLETE = 7;

    //Client Billing Rules Category All Clients Abbrev
    public static final String ALL_CLIENTS = "ALL CLIENTS";

    // Payor Address Override Types
    public static final int PYR_ADDR_OVERRIDE_TYP_CLAIM = 1;
    public static final int PYR_ADDR_OVERRIDE_TYP_ATTACH = 2;
    public static final int PYR_ADDR_OVERRIDE_TYP_APPEAL = 3;
    public static final int PYR_ADDR_OVERRIDE_TYP_REFUND = 4;

    // Payor Address Override Link Types
    public static final int PYR_ADDR_OVERRIDE_LNK_TYP_FACILITY = 1;
    public static final int PYR_ADDR_OVERRIDE_LNK_TYP_PROCEDURE_CD = 2;
    public static final int PYR_ADDR_OVERRIDE_LNK_TYP_MODIFIER = 3;

    //Ep Summary Screen Constants
    //Appeal Error Types
    public static final int ERR_CD_NON_APPEAL_ERR_TYP = 0;
    public static final int ERR_CD_APPEAL_ERR_TYP = 1;
    public static final int ERR_CD_APPEAL_FOLLOW_UP_ERR_TYP = 2;

    public static final int EP_INTERNAL_APPEALFOLLOWUP_SUBGRP = 33;
    public static final String APPEALFOLLOWUP_ERRCD_BY_PYR = "appealFollowUpErrcdByPayor";
    public static final String APPEALFOLLOWUP_ERRS_BY_PYR = "appealFollowUpErrsByPyr";
    public static final String APPEALFOLLOWUP_GRPBY_PYRGRP_PYR = "appealFollowUpByPyrInPyrGrp";
    public static final String APPEALFOLLOWUP_SUBGRP = "appealFollowUp";

    // Payor Physician registration payor field requirement pseudo field description prefix
    public static final String PYR_PHYS_REGISTRATION_PSEUDO_FLD_DESCR_PREFIX = "Physician in ";
    public static final String PYR_PHYS_REGISTRATION_ERR_CD_PREFIX = "PYRPHYS";

    // Payor service auth types
    public static final int PYR_SERVICE_AUTH_TYP_PRIOR_AUTHORIZATION = 0;
    public static final int PYR_SERVICE_AUTH_TYP_ADVANCE_NOTIFICATION = 1;

    public MiscMap()
    {
    }


}
