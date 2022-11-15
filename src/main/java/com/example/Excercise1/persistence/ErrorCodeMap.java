package com.example.Excercise1.persistence;


import org.apache.log4j.Category;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 *
 * Notes:
 *	 An improved data structure that combined the literal-to-database name and corresponding vector
 *   structures would probably be a design improvement.
 *
 *   This class should be modified to read table and field names directly from the database's
 *   data dictionary rather then have them hard coded.
 *
 */

public class ErrorCodeMap {

    /************************************************************************
     *  Stake out your chunk-o-numbers below.  Feel free to relocate
     *  or adjust the already claimed bands to allow for future growth.  Also, feel
     *  free to relocate some of your error codes to the COMMON area.
     *
     *      0 -  199: Generic "success" (or expected behavior) codes
     *    200 -  999: Common error codes usable by all
     *   1000 - 1199: OE Posting Engine
     *   1200 - 1299: Pricing Logic
     *   1300 - 1399: Error Processing
     *   1400 - 1450: Client Transaction Detail
     *   1451 - 1550: Test Code File Maintenance
     *   1551 - 1650: Payment Search
     *   1651 - 1850: ////////////////////// unused ////////////////////////////////////////
     *   1851 - 1899: Accession Test Update
     *   1900 - 1999: EOM
     *   2000 - 2099: Patient Demographics & Standing Order
     *   2100 - 2149: Accession Manifest
     *   2150 - 2199: Daily Receipt
     *   2200 - 2230: Facility Demographics
     *   2231 - 2250: Payment Discrepancy Summary
     *   2251 - 2970: Non-Client Payment Summary
     *   2271 - 2295: Client Pricing Configuration
     *   2996 - 3003: Payor Requirements
     *   3004 - 3007: Special Price Table
     *   3008 - 3011: Order Entry
     *   3012 - 3020: Payor Group Demographics
     *   3021 - 3034: Payor Contract Configuration
     *   3035 - 3044: Payor Demographics
     *   3045 - 3047: Payor Contract Configuration
     *   3048 - 3054: Client Physician Assignment
     *   3065 - 3070: Payor Demographics
     *   3071 - 3090: EP Match Compare
     *   3091 - 3099: Lab Component Change Release
     *   3100 - 3199: Dialysis Frequency Control Screen
     *   3200 - 3299: Payor Contact Manager Screen
     *   3300 - 3399: Client Billing Rules Screen
     *   4000 - 4010: Client Pricing Inquiry
     *   4011 - 4060: Client Pricing Configuration
     *   4061 - 4085: Payor Pricing Configuration
     *   4086 - 4199: Scheduler
     *   4200 - 4250: Client Demographics
     *   4251 - 4260: Question Maintenance Servlet (SSQ, TSQ, client specific questions)
     *   4261 - 4299: Accession Demographics
     *   4300 - 4399: Payor Pricing Config Error Codes
     *   5000 - 5999: Order Entry
     *   6301 - 6350: Accn Notes & Promise Pmts
     *   6400 - 6450: Doc Maintenance
     *   6451 - 6500: Accn Transaction Detail
     *   6500 - 6520: PyrGrpDemoGrpcs Needs More ErroCodes(Added New Requirements)
     *   6521 - 6530: PyrDemoGrpcs Needs More ErroCodes(Added New Requirements) 6521-6530
     *	 6560 - 6565: MarsMessage
     *   6570 - 6579: Payor procedure code consolidation rules
     *   6600 - 6699: Payments
     *   6700 - 6799: Client submission
     *   6800 - 6899: MedUnite Reporting
     *   6900 - 6999: Accn audit
     *   7000 - 7020: Elig roster
     *   7020 - 7099: MARS Search Result Screens
     *   7100 - 7199: Client Pricing Config
     *   7200 - 7205: Payor Requirements
     *   7210 - 7215: Special price table
     *   7300 - 7399: Refunds
     *   7400 - 7500: Submission and Remittance File Maintenance
     *   7600 - 7650: Pyr Coverage Limitation Req
     *   8000 - 8200: Patient Demographics & Standing Order (More)
     *   8201 - 8299: Pyr pricing config (more)
     *   8300 - 8400: Procedure Code
     *   8400 - 8500: Upin <-> Phys synchronization problems.
     *   8501 - 8505: Client Pricing Config
     *   8800 - 8899: Electronic Payment
     *   9000 - 9999: Payor Billing Rules Error Codes for XP
     *   10000 - 10050: Accession Demographics
     *   10051 - 10100: Reason Code File Maintenance
     *   10101 - 10150: User Account File Maintenance
     *   10151 - 10200: PDF Setup
     *   10301 - 10314: Hl7 Importer
     *   1050  - 1053 : File Maintenance Lab Message
     *   11000 - 11999: Patient Notification Letter Configuration
     *   12000 - 12999: Patient Estimation
     public static final int INVALID_USER_PHONE  = 10101;
     *************************************************************************/
    /**
     * The category that this class will use for logging
     */
    private static Category log = Category.getInstance(ErrorCodeMap.class.getName());

    /*
     Custom Radilogy Terms
     */
    public static final String test = getCustomString("test");
    public static final String Test = getCustomString("Test");
    public static final String accession = getCustomString("accession");
    public static final String Accession = getCustomString("Accession");
    public static final String accn = getCustomString("accn");
    public static final String Accn = getCustomString("Accn");
    public static final String phlebotomy = getCustomString("phlebotomy");
    public static final String Phlebotomy = getCustomString("Phlebotomy");
    public static final String Phleb = getCustomString("Phleb");
    public static final String lab = getCustomString("lab");
    public static final String Lab = getCustomString("Lab");
    public static final String fmLab = getCustomString("fmLab");
    public static final String sfmLab = getCustomString("sfmLab");
    public static final String errPhleb = getCustomString("errPhleb");

    /**
     * Generic 'success' code. (0 - 199)
     */
    public static final int SUCCESS = 100;
    public static final String SUCCESS_MSG = "Successful";

    public static final int NEW_RECORD = 101;
    public static final String NEW_RECORD_MSG = "New Record";

    public static final int UPDATED_RECORD = 102;
    public static final String UPDATED_RECORD_MSG = "Updated Record";

    public static final int DELETED_RECORD = 103;
    public static final String DELETED_RECORD_MSG = "Deleted Record";

    public static final int TRANSITION = 104;

    public static final int DELETED_NEW_RECORD = 105;
    public static final String DELETED_NEW_RECORD_MSG = "Deleted New Record";

    public static final int DAO_INIT = 106;
    public static final String DAO_INIT_MSG = "DAO Initialization";

    public static final int RECORD_FOUND = 0;
    public static final String RECORD_FOUND_MSG = "Select Successful";

    public static final int RECORD_NOT_FOUND = 3;
    public static final String RECORD_NOT_FOUND_MSG = "Select Unsuccessful";

    public static final int DATA_LOCKED = 4;
    public static final String DATA_LOCKED_MSG = "Data locked";



    // Triggered when a child class (ie: AccnTest) calls its parent (ie: Test) to load
    public static final int PARENT_RECORD_NOT_FOUND = 5;
    public static final String PARENT_RECORD_NOT_FOUND_MSG = "Parent Select Unsuccessful";

    // COMMON ERROR CODES USABLE BY ALL (200 - 999)
    public static final int    REQUIRED_PT_ID = 200;
    public static final String REQUIRED_PT_ID_MSG = "A patient ID is required";
    public static final int    REQUIRED_CLN_ID = 202;
    public static final String REQUIRED_CLN_ID_MSG = "A client ID is required";
    public static final int    REQUIRED_CLN_ABBREV = 204;
    public static final String REQUIRED_CLN_ABBREV_MSG = "A client ID is required";
    public static final int    INVALID_CLN_ABBREV = 205;
    public static final String INVALID_CLN_ABBREV_MSG = "Invalid client ID";
    public static final int    REQUIRED_PT_ID_AND_CLN_ID = 206;
    public static final String REQUIRED_PT_ID_AND_CLN_ID_MSG = "A patient ID and a client ID are required";
    public static final int    REQUIRED_PHYSICIAN = 210;
    public static final String REQUIRED_PHYSICIAN_MSG = "An Ordering Physician NPI is required";
    public static final int    INVALID_UPIN_ID = 211;
    public static final String INVALID_UPIN_ID_MSG = "Invalid UPIN.";
    public static final int    REQUIRED_TEST_ID = 212;
    public static final String REQUIRED_TEST_ID_MSG = "A "+test+" ID is required";
    public static final int    REQUIRED_CNTCT = 214;
    public static final String REQUIRED_CNTCT_MSG = "A contact person is required";
    public static final int    INVALID_ACCN_ID  = 215;
    public static final String INVALID_ACCN_ID_MSG  = "Invalid "+Accn+" ID";
    public static final int    UNAUTHORIZED_CREATE_PT = 216;
    public static final String UNAUTHORIZED_CREATE_PT_MSG = "User does not have permission to create a new patient";
    public static final int    INVALID_PHYS_SEQ = 217;
    public static final String INVALID_PHYS_SEQ_MSG = "Invalid Physician ID.";
    public static final int    INVALID_PHYS_NPI = 218;
    public static final String INVALID_PHYS_NPI_MSG = "Invalid Physician NPI.";
    public static final int    INVALID_PHYS = 219;
    public static final String INVALID_PHYS_MSG = "Invalid Physician";
    public static final int    REQUIRED_ACCNT_TYPE = 220;
    public static final String REQUIRED_ACCNT_TYPE_MSG = "Account type is required";
    public static final int    REQUIRED_DELAY_REASON_CODE = 229;
    public static final String REQUIRED_DELAY_REASON_CODE_MSG = "Delay reason code is required";
    public static final int    REQUIRED_CNTCT_MTHD = 230;
    public static final String REQUIRED_CNTCT_MTHD_MSG = "A contact method is required";
    public static final int    INVALID_COPY_FROM_CLIENT = 231;
    public static final String INVALID_COPY_FROM_CLIENT_MSG = "Invalid Copy From Client entered.";
    public static final int    INVALID_DT = 300;
    public static final String INVALID_DT_MSG = "Invalid date.";
    public static final int    REQUIRED_AUTHRZTN_DT = 305;
    public static final String REQUIRED_AUTHRZTN_DT_MSG = "An Authorization Date is required";
    public static final int    REQUIRED_XREF_ID = 309;
    public static final String REQUIRED_XREF_ID_MSG = "A Cross Reference Description is required";
    public static final int    REQUIRED_EFF_DT = 310;
    public static final String REQUIRED_EFF_DT_MSG = "An effective date is required";
    public static final int    INVALID_EFF_DT = 311;
    public static final String INVALID_EFF_DT_MSG = "Invalid effective date.";
    public static final int    REQUIRED_EXP_DT = 312;
    public static final String REQUIRED_EXP_DT_MSG = "An expiration date is required";
    public static final int    INVALID_EXP_DT = 313;
    public static final String INVALID_EXP_DT_MSG = "Invalid expiration date.";
    public static final int    INVALID_DT_RANGE = 314;
    public static final String INVALID_DT_RANGE_MSG = "Invalid date range.";
    public static final int    REQUIRED_FRM_DT = 315;
    public static final String REQUIRED_FRM_DT_MSG = "A 'From' date is required";
    public static final int    REQUIRED_TO_DT = 316;
    public static final String REQUIRED_TO_DT_MSG = "A 'Through' date is required";
    public static final int    INVALID_TO_DT = 317;
    public static final String INVALID_TO_DT_MSG = "Invalid 'Through' date";
    public static final int    MISSING_ADDR = 330;
    public static final String MISSING_ADDR_MSG = "No address entered";
    public static final int    INVALID_PHN = 340;
    public static final String INVALID_PHN_MSG = "Invalid phone number entered";
    public static final int    MISSING_ZIP = 350;
    public static final String MISSING_ZIP_MSG = "No zip code entered";
    public static final int    INVALID_ZIP = 351;
    public static final String INVALID_ZIP_MSG = "An invalid zip code was entered";
    public static final int    CONFLICT_ZIP_STATE = 352;
    public static final String CONFLICT_ZIP_STATE_MSG = "The zip code and state entered conflict";
    public static final int    INVALID_KEY_CHAR = 353;
    public static final String INVALID_KEY_CHAR_MSG = "Only Number or Letter type values are allowed and Key length can't exceed ";
    public static final int    INVALID_CHAR = 354;
    public static final String INVALID_CHAR_MSG = "Only Number or Letter type values are allowed.";
    public static final int    ACD_DUP_PYR = 355;
    public static final String ACD_DUP_PYR_MSG = "A Duplicate Payor was entered.";
    public static final int    INVALID_PHLEB = 356;
    public static final String INVALID_PHLEB_MSG = "An invalid "+Phleb+" ID was entered.";
    public static final int    INVALID_PHLEB_FAC = 357;
    public static final String INVALID_PHLEB_FAC_MSG = "An invalid "+errPhleb+" Facility ID was entered.";
    public static final int    ACD_DUP_MEDICARE_PYR = 358;
    public static final String ACD_DUP_MEDICARE_PYR_MSG = "Multiple payors within the Medicare group cannot be entered.";
    public static final int    LOAD_ERROR = 400;
    public static final String LOAD_ERROR_MSG = "Failed to load data";
    public static final int    ERROR = 500;
    public static final String ERROR_MSG = "Unable to Process Transaction.";
    public static final int    PYR_DELETED = 501;
    public static final String PYR_DELETED_MSG = "Payor has been deleted.";
    public static final int    DIAG_TYP_REQ = 502;
    public static final String DIAG_TYP_REQ_MSG = "Diagnosis Type Required.";

    public static final int    ADJ_TYP_REQ = 503;
    public static final String ADJ_TYP_REQ_MSG = "ADJ Code Type Required.";
    public static final int    ADJ_CD_REQ = 503;
    public static final String ADJ_CD_REQ_MSG = "Adjustment Code ID Required.";
    public static final int    ADJ_CD_INVALID = 504;
    public static final String ADJ_CD_INVALID_MSG = "Adjustment Code ID invalid.";
    public static final int    ADJ_CD_ADD_INACTIVE = 505;
    public static final String ADJ_CD_ADD_INACTIVE_MSG = "Can't add an inactive adjustment code.";
    public static final int    ADJ_CD_TIED_TO_ERR_CDS = 506;
    public static final String ADJ_CD_TIED_TO_ERR_CDS_MSG = "Adjustment Code is tied to Error Code %s - %s. Please delete before marking as inactive.";
    public static final int    ADJ_XREF_TYP_REQ = 507;
    public static final String ADJ_XREF_TYP_REQ_MSG = "ADJ Code Cross-Reference Required.";

    public static final int    INVALID_NUMERIC_VALUE = 600;
    public static final String INVALID_NUMERIC_VALUE_MSG = "Invalid numeric value.";
    public static final int    INVALID_PYR = 601;
    public static final String INVALID_PYR_MSG = "Invalid Payor ID.";

    public static final int    REASSESS_ERR = 602;
    public static final String REASSESS_ERR_MSG = "An error occurred while re-queuing the "+accession+".  The system will automatically attempt to re-queue the "+accession+" within 5 minutes.";
    public static final int INVALID_DIAG_SHORT_DESC_LENGHTH = 603;
    public static final String INVALID_DIAG_SHORT_DESC_LENGHTH_MSG = "Name must be less than 60 characters.";
    public static final int INVALID_DIAG_CD_DESC_LENGHTH = 604;
    public static final String INVALID_DIAG_CD_DESC_LENGHTH_MSG = "Description must be less than 325 characters.";
    public static final int REQUIRED_DESCRIPT = 611;
    public static final String REQUIRED_DESCRIPT_MSG= "Description is required.";
    public static final int INVALID_PROC = 612;
    public static final String INVALID_PROC_MSG = "Invalid procedure code";

    public static final int REQUIRED_PROC = 613;
    public static final String REQUIRED_PROC_MSG = "Procedure code is required";
    public static final int EFF_DT_AFTER_EXP_DT = 614;
    public static final String EFF_DT_AFTER_EXP_DT_MSG = "Effective date is after expiration date";
    public static final int GREATER_THAN_ZERO = 615;
    public static final String GREATER_THAN_ZERO_MSG= "input must be greater than zero.";
    public static final int NUM_NOT_NEGATIVE = 616;
    public static final String NUM_NOT_NEGATIVE_MSG= "input cannot be negative.";
    public static final int NEXT_SEQ_ERR = 617;
    public static final String NEXT_SEQ_ERR_MSG= "Error getting next sequence number";
    public static final int XACTION_ROLLBACK_FATAL_ERROR = 618;
    public static final String XACTION_ROLLBACK_FATAL_ERROR_MSG = "Fatal error while attempting to rollback transaction. Contact your system administrator.";
    public static final int XACTION_ROLLBACK = 619;
    public static final String XACTION_ROLLBACK_MSG = "Submit cancelled. Transaction rolled back to due to exception. ";
    public static final int MIN_EXCEEDS_MAX = 620;
    public static final String MIN_EXCEEDS_MAX_MSG= "Minimum should not exceed maximum";
    public static final int NOT_EFFECTIVE = 621;
    public static final String NOT_EFFECTIVE_MSG = " not effective";
    public static final int NO_RECORDS_FOUND = 622;
    public static final String NO_RECORDS_FOUND_MSG = "No Records Found.";
    public static final int INVALID_ABBREV = 623;
    public static final String INVALID_ABBREV_MSG = " abbreviation contains invalid character(s).";
    public static final int ACCT_DT_MISMATCH = 624;
    public static final String ACCT_DT_MISMATCH_MSG = "Unable to determine the accounting date, contact help desk.";
    public static final int FROM_AFTER_THRU_DT = 625;
    public static final String FROM_AFTER_THRU_DT_MSG = "The from date must be on or before the thru dt.";
    public static final int FUTURE_DT = 626;
    public static final String FUTURE_DT_MSG = "Future dates are not allowed";
    public static final int FIELD_LENGTH_EXCEEDED = 627;
    public static final String FIELD_LENGTH_EXCEEDED_MSG = "Field length exceeded maximum allowed length";
    public static final int MULTI_ACCNS_SELECTED = 628;
    public static final String MULTI_ACCNS_SELECTED_MSG = "Multiple selections for the same accn is not allowed";
    public static final int PT_REC_EXISTS = 629;
    public static final String PT_REC_EXISTS_MSG = "Patient record already exists";
    public static final int INVALID_VALUE = 630;
    public static final String INVALID_VALUE_MSG = "An invalid value was entered for ";
    public static final int DUPLICATE_RECORD = 631;
    public static final String DUPLICATE_RECORD_MSG = "A duplicate record was entered ";
    public static final int INVALID_MOD = 632;
    public static final String INVALID_MOD_MSG = "Invalid modifier. ";
    public static final int CHANGE_NOT_ALLOWED = 633;//fyi, put what change is not allowed before and reason after.
    public static final String CHANGE_NOT_ALLOWED_MSG = "change not allowed due to";
    public static final int RECORD_EXISTS = 634;//fyi, put what in front and value after.
    public static final String RECORD_EXISTS_MSG = "record already exists";
    public static final int FIELD_NOT_EDITABLE = 635;//put what field in front.
    public static final String FIELD_NOT_EDITABLE_MSG = "field is not editable.";
    public static final int ACCN_LOCK = 636;
    public static final String ACCN_LOCK_MSG = "Your "+Accession+" Lock is no longer present.  You will need to reapply all changes.";
    public static final int SESSION_SUBMITTING_ALREADY = 637;
    public static final String SESSION_SUBMITTING_ALREADY_MSG = "A previous submit has not finished yet.  Please wait a few seconds and try again.";
    public static final int SESSION_WAS_RESET = 638;
    public static final String SESSION_WAS_RESET_MSG = "A prior submit or reset caused the session to be cleared and the displayed data is now invalid.  " +
            "To avoid this, do not submit more than once and do not use multiple browser windows. " +
            "Please reset and try your operation again.";
    public static final int MISSING_VALID_PROC_CODE = 639;
    public static final String MISSING_VALID_PROC_CODE_MSG = "A valid procedure code was not found for this action.";
    public static final int REVOKE_LOCK = 640;
    public static final String REVOKE_LOCK_MSG = "You no longer have exclusive use to update data. You will need to start over and reapply all changes.";
    public static final int RECORD_NOT_EDITABLE = 641;
    public static final String RECORD_NOT_EDITABLE_MSG = "This record is not editable.";
    public static final int FIELD_REQUIRED = 642;
    public static final String FIELD_REQUIRED_MSG = "field is required.";
    public static final int RECORDS_EXCEEDED = 643;
    public static final String RECORDS_EXCEEDED_MSG = "The maximum records allowed has been exceeded";
    public static final int    INVALID_TAXONOMYCODE = 644;
    public static final String INVALID_TAXONOMYCODE_MSG = "Taxonomy code not found.";
    public static final int    INVALID_TIME_FORMAT = 645;
    public static final String INVALID_TIME_FORMAT_MSG = "Time must be in the format HH:MM";
    public static final int    DATE_BEFORE_EQUAL_TODAY = 646;
    public static final String DATE_BEFORE_EQUAL_TODAY_MSG = "Date must be before or equal to today.";
    public static final int    DISCHARGE_ON_AFTER_ADMISSION = 647;
    public static final String DISCHARGE_ON_AFTER_ADMISSION_MSG = "Discharge date must be on or after admission date.";
    public static final int    ADMISSION_IF_DISCHARGE = 648;
    public static final String ADMISSION_IF_DISCHARGE_MSG = "Admission date must be specified if discharge is specified.";

    public static final int    USER_ACCESS_DENIED_FOR_FACILITY = 649;
    public static final String USER_ACCESS_DENIED_FOR_FACILITY_MSG= "User access denied for facility ";

    public static final int NO_VALUE = 650;
    public static final String NO_VALUE_MSG = "No value was entered for ";

    public static final int NO_ICN_FOR_CORRECTED_CLAIM = 652;
    public static final String NO_ICN_FOR_CORRECTED_CLAIM_MSG= "No ICNs found for corrected claim: Payor|SubscriberID=";

    public static final int NO_PROCS_FOUND_FOR_CORRECTED_CLAIM= 653;
    public static final String NO_PROCS_FOUND_FOR_CORRECTED_CLAIM_MSG = "No procedure codes found for corrected claim: ICN=";



    public static final int SESSION_IS_NO_LONGER_CURRENT = 651;
    public static final String SESSION_IS_NO_LONGER_CURRENT_MSG = "The session is no longer current and the displayed data is now invalid.  " +
            "To avoid this, do not use multiple browser windows. " +
            "Please reset and try your operation again.";


    public static final int DATA_LOCK_LOST = 652;
    public static final String DATA_LOCK_LOST_MSG = "Your Lock is no longer present.  You will need to reapply all changes.";

    public static final int REQUIRED_SUB_NAME = 654;
    public static final String REQUIRED_SUB_NAME_MSG = "Subscriber Name is required";
    public static final int REQUIRED_SUB_DOB = 655;
    public static final String REQUIRED_SUB_DOB_MSG = "Subscriber DOB is required";
    public static final int REQUIRED_SUB_ID = 656;
    public static final String REQUIRED_SUB_ID_MSG = "Subscriber ID is required";
    public static final int REQUIRED_SUB_GENDER = 657;
    public static final String REQUIRED_SUB_GENDER_MSG = "Subscriber Gender Type is required";

    public static final int REQUIRED_DEP_NAME = 658;
    public static final String REQUIRED_DEP_NAME_MSG = "Dependent Name is required";
    public static final int REQUIRED_DEP_DOB = 659;
    public static final String REQUIRED_DEP_DOB_MSG = "Dependent DOB is required";
    public static final int REQUIRED_DEP_GENDER = 660;
    public static final String REQUIRED_DEP_GENDER_MSG = "Dependent Gender Type is required";
    public static final int REQUIRED_DEP_RELATIONSHIP = 661;
    public static final String REQUIRED_DEP_RELATIONSHIP_MSG = "Dependent Relationship Type is required";

    public static final int ERROR_CONNECTING_CARDCONNECT = 662;
    public static final String ERROR_CONNECTING_CARDCONNECT_MSG = "Error connecting to CardConnect. Try again later / Submit again to save changes.";
    public static final int INVALID_MERCHANT_CREDENTIALS = 663;
    public static final String INVALID_MERCHANT_CREDENTIALS_MSG = "Invalid username or password. Submit again to save changes.";
    public static final int INVALID_MERCHANT_ID = 664;
    public static final String INVALID_MERCHANT_ID_MSG = "Invalid merchant id. Submit again to save changes.";
    public static final int MERCHANT_NOT_ON_SITE = 665;
    public static final String MERCHANT_NOT_ON_SITE_MSG = "Incorrect site details - merchant not on site. Submit again to save changes.";
    public static final int INVALID_CHECK_ELIG_ON_TRANSLATED_PYR = 666;
    public static final String INVALID_CHECK_ELIG_ON_TRANSLATED_PYR_MSG = "Check eligibility cannot be set for a rule that translates to the same payor.";


    // File Maintenance Lab Message 1050
    public static final int INVALID_LAB_MESSAGE_ABBRV = 1050;
    public static final String INVALID_LAB_MESSAGE_MSG = "File maintenance - Lab Message account not on file";
    public static final int INVALID_LAB_MESSAGE_SS = 1051;
    public static final String INVALID_LAB_MESSAGE_SS_MSG = "File maintenance - Lab Message not found TestMsg in SystemSetting by id ";
    public static final int LAB_MESSAGE_NOT_SAVE_ERR = 1052;
    public static final String LAB_MESSAGE_NOT_SAVE_ERR_MSG = "File maintenance - Lab Message can not save with abbrev ";
    public static final int LAB_MESSAGE_DESCR_DUPLICATED_ERR = 1053;
    public static final String LAB_MESSAGE_DESCR_DUPLICATED_MSG = " (Hint: Description value must be unique)";

    //Pricing codes
    public static final int PYR_NO_BILL_CODE = 1293;
    public static final String PYR_NO_BILL_MSG = "Do not bill this payor.";

    public static final int PRC_NOT_INCREMENTAL_CODE = 1294;
    public static final int INCREMENTAL_NO_RULETEST_CODE = 1295;
    public static final String INCREMENTAL_NO_RULETEST_MSG = "At least 1 Include row is required in the Inclusion & Exclusion grid for ";



    //Accn Demo 10000-10050
    public static final int ACCN_ID_CONFLICT = 10000;
    public static final String ACCN_ID_CONFLICT_MSG = "The "+Accession+" data has expired.  Please re-select the "+Accession+" ID.";
    public static final int UB92_BILL_TYPE_REQ = 10001;
    public static final String UB92_BILL_TYPE_REQ_MSG = "UB04 Bill Type is required for submission.";
    public static final int ICN_REQ = 10002;
    public static final String ICN_REQ_MSG = "ICN is required for this claim type or action.";
    public static final int UB92_COMMENT_REQ = 10003;
    public static final String UB92_COMMENT_REQ_MSG = "Comment Required for this UB04 Condition Code.";
    public static final int UB92_REASON_CD_REQ = 10004;
    public static final String UB92_REASON_CD_REQ_MSG = "UB04 Condition Code is required for this UB04 Bill Type.";
    public static final int UB92_INVALID_REASON_CD = 10005;
    public static final String UB92_INVALID_REASON_CD_MSG = "Invalid UB04 Condition Code for this UB04 Bill Type.";
    public static final int UB92_CLAIM_TYP_NOT_ALLOWED = 10006;
    public static final String UB92_CLAIM_TYP_NOT_ALLOWED_MSG = "The Payor does not allow this UB04 Bill Type.";
    public static final int COLLECTION_PYR = 10007;
    public static final String COLLECTION_PYR_MSG = "No Payors allowed after a Collection Payor.";
    public static final int PREG_RQD_ONSET_TYPE = 10008;
    public static final String PREG_RQD_ONSET_TYPE_MSG = "WARNING : 'Last Menstrual Period' onset type required for pregnancy indicator";
    public static final int PREG_ONSET_DATE_RQD = 10009;
    public static final String PREG_ONSET_DATE_RQD_MSG = "WARNING : Onset date required for pregnancy indicator";
    public static final int GRAVIDA_NUM_NUMERIC = 10010;
    public static final String GRAVIDA_NUM_NUMERIC_MSG = "Gravida number must be a numerical value, from 0 to 99";
    public static final int ADMISSION_DATE_TIME = 10011;
    public static final String ADMISSION_DATE_TIME_MSG = "Admission time has been specified without a date.";
    public static final int DISCHARGE_DATE_TIME = 10012;
    public static final String DISCHARGE_DATE_TIME_MSG = "Discharge time has been specified without a date.";
    public static final int SUBMIT_CLAIMS_PYR_FORMAT = 10013;
    public static final String SUBMIT_CLAIMS_PYR_FORMAT_MSG = "Submit Claims requires a payor and a format.";
    public static final int SUBMIT_CLAIMS_PYR_NOT_FOUND = 10014;
    public static final String SUBMIT_CLAIMS_PYR_NOT_FOUND_MSG = "Unknown payor for claim submission.";
    public static final int DUPLICATE_CLNID_PTID = 10015;
    public static final String DUPLICATE_CLNID_PTID_MSG = "Duplicate Client ID/Specific Patient ID not allowed";
    public static final int DUPLICATE_FACID_PTID = 10016;
    public static final String DUPLICATE_FACID_PTID_MSG = "Duplicate Facility ID/Specific Patient ID not allowed";
    public static final int INVALID_PT_ID_TYPE = 10017;
    public static final String INVALID_PT_ID_TYPE_MSG = "Invalid patient ID type specified";




    // End of Month (1950 - 1999)
    public static final int 	EOM_DATE_NOT_RELEASED = 1950;
    public static final String 	EOM_DATE_NOT_RELEASED_MSG = "EOM cannot be started. The following date has not final report released: ";
    public static final int		EOM_STARTUP_FAILED = 1951;
    public static final String	EOM_STARTUP_FAILED_MSG = "An error occurred and EOM processing could not be instantiated.";
    public static final int 	EOM_NOT_END_OF_PERIOD = 1952;
    public static final String 	EOM_NOT_END_OF_PERIOD_MSG = "EOM cannot be started within the current system accounting period.";
    public static final int 	EOM_EOM_ALREADY_RUNNING = 1953;
    public static final String 	EOM_EOM_ALREADY_RUNNING_MSG = "The EOM Engine is currently running.  Please try again later.";
    public static final int 	EOM_DATE_NOT_FORCED_TO_PRICE = 1954;
    public static final String 	EOM_DATE_NOT_FORCED_TO_PRICE_MSG = "EOM cannot be started. The following date has not been forced to pricing: ";
    public static final int 	EOM_STATUS_RECORD_LOAD_ERROR = 1955;
    public static final String 	EOM_STATUS_RECORD_LOAD_ERROR_MSG = "EOM Status record could not be obtained. Cannot launch EOM.";
    public static final int 	EOM_PREV_PERIOD_NOT_COMPLETED = 1956;
    public static final String 	EOM_PREV_PERIOD_NOT_COMPLETED_MSG = "EOM cannot be started. EOM has not been completed for previous accounting period. Complete EOM processing for previous period from EOM Status screen.";
    public static final int 	EOM_PYR_GRP_NOT_FOUND = 1957;
    public static final String 	EOM_PYR_GRP_NOT_FOUND_MSG = "Payor group with following ID not found: ";
    public static final int 	EOM_SUMMARY_CREATE_FAILED = 1958;
    public static final String 	EOM_SUMMARY_CREATE_FAILED_MSG = "EOM Activation summary cannot be created due to a fatal system error.";
    public static final int 	EOM_ERROR_DURING_PENDING_CHECK = 1959;
    public static final String 	EOM_ERROR_DURING_PENDING_CHECK_MSG = "EOM cannot be started. An error occurred while attempting to verify all pending "+accession+"s have been forced to pricing.";
    public static final int 	EOM_ERROR_WHILE_PARSING_START_DATE = 1960;
    public static final String 	EOM_ERROR_WHILE_PARSING_START_DATE_MSG = "EOM cannot be started. An error occurred while attempting to load the accounting period start and end dates.";
    public static final int 	EOM_ERROR_SUBMITTING_DATA = 1961;
    public static final String 	EOM_ERROR_SUBMITTING_DATA_MSG = "Error occurred. Could not commit changes to database.";
    public static final int 	EOM_ERROR_DURING_RECALC = 1962;
    public static final String 	EOM_ERROR_DURING_RECALC_MSG = "Error occurred while attempting to recalculate totals.";
    public static final int 	EOM_PEND_ACCNS_MISSING_LAB_MSGS = 1963;
    public static final String 	EOM_PEND_ACCNS_MISSING_LAB_MSGS_MSG = "EOM cannot be activated. There are pending "+accession+"s that have not had their "+lab+" messages released and the manual "+lab+" message release is set to true requiring these to be worked.";
    public static final int 	EOM_PEND_ACCNS_MISSING_PYR= 1964;
    public static final String 	EOM_PEND_ACCNS_MISSING_PYR_MSG = "EOM cannot be activated. There are pending "+accession+"s without billing information and force to manual pricing system setting is set to true requiring these to be worked.";
    public static final int     EOM_CLOSE_NONFATAL_ERROR = 1966;
    public static final String  EOM_CLOSE_NONFATAL_ERROR_MSG = "The previous period had errors which did not prevent end of month from completing.  This will not prevent end of month from running for the current period.";
    public static final int     EOM_STATUS_INVALID_STATUS = 1967;
    public static final String  EOM_STATUS_INVALID_STATUS_MSG = "Status of the previous period could not be determined or is invalid.  Please review the previous period or contact support.";
    public static final int     EOM_EOM_CLOSE_IN_USE = 1968;
    public static final String  EOM_EOM_CLOSE_IN_USE_MSG = "The EOM Closing Package is currently in use.  Please try again later.";
    public static final int     EOM_VALUE_TOO_LARGE = 1969;
    public static final String  EOM_VALUE_TOO_LARGE_MSG = "One or more values are too large to save.  " +
            "Please check your inputs on this screen and others and try again.";
    public static final int     EOM_STATUS_FATAL_ERRORS = 1970;
    public static final String  EOM_STATUS_FATAL_ERRORS_MSG = "End of Month processing has not been completed sucessfully for accounting period.";
    public static final int     EOM_STATUS_NONFATAL_ERRORS = 1971;
    public static final String  EOM_STATUS_NONFATAL_ERRORS_MSG = "End of Month processing had non-fatal errors. The specific steps that failed are shown in the Activity grid at the bottom of this screen. You may also contact Xifin for further assistance.";
    public static final int     EOM_TRIAL_RUN = 1972;
    public static final String  EOM_TRIAL_RUN_MSG = "*** TRIAL RUN *** The data displayed here is from a trial run of the month-end close and is not final! *** TRIAL RUN *** ";
    public static final int     EOM_OUT_OF_BALANCE = 1973;
    public static final String  EOM_OUT_OF_BALANCE_MSG = "The package is currently OUT OF BALANCE. Please view Closing Package for details.";
    public static final int     EOM_RUN_CLOSE_PKG = 1974;
    public static final String  EOM_RUN_CLOSE_PKG_MSG = "The Closing Package has not been run yet for selected accounting period. Run the Closing Package to check to see if system is in balance.";
    public static final int     EOM_PROCESSING_LAUNCHED = 1975;
    public static final String  EOM_PROCESSING_LAUNCHED_MSG = "End of Month Processing Launched.";
    public static final int     REQ_CLOSE_DT = 1976;
    public static final String  REQ_CLOSE_DT_MSG = "Close Date is required";
    public static final int     INVALID_CLOSE_DT = 1977;
    public static final String  INVALID_CLOSE_DT_MSG = "Invalid Close Date: ";
    public static final int     CANNOT_UPDATE_CLOSE_DT = 1978;
    public static final String  CANNOT_UPDATE_CLOSE_DT_MSG = "Close date for month can not be updated when EOM already finished";
    public static final String  CANNOT_UPDATE_CLOSE_DT_MSG2 = "Close date for month can not be updated when EOM currently running";
    public static final int     CLOSE_DT_BEFORE_CUR_DT_ERR = 1979;
    public static final String  CLOSE_DT_BEFORE_CUR_DT_ERR_MSG = "Close date / time can not be before current date / time.";
    public static final int     CLOSE_DT_TIME_ERR = 1980;
    public static final String  CLOSE_DT_TIME_ERR_MSG = "Close date time only allows 4-7 pm";
    public static final String  CLOSE_DT_TIME_ERR_MSG2 = "Close date time only allows 4-6 pm";
    public static final int     INVALID_SOFT_CLOSE_DT = 1981;
    public static final String  INVALID_SOFT_CLOSE_DT_MSG = "Close date can not be earlier than the last calendar day of each month";
    public static final String  INVALID_SOFT_CLOSE_DT_MSG2 = "Close date can not be later than the 7th of the next month";
    public static final String  INVALID_SOFT_CLOSE_DT_MSG3 = "Close date can not be later than the 10th of the next month";
    public static final int     CLOSE_DT_BE_WEEKEND_ERR = 1982;
    public static final String  CLOSE_DT_BE_WEEKEND_ERR_MSG = "Close date can not be on a weekend";
    public static final int     CLOSE_DT_BE_HOLIDAY_ERR = 1983;
    public static final String  CLOSE_DT_BE_HOLIDAY_ERR_MSG = "Close date can not be on a holiday";

    //End of Month (1950 - 1999)

    // Patient Demographic and Standing Order error codes & messages (2000 - 2099, 8000 - 8200)
    public static final int    PT_RECORD_NOT_FOUND = 2000;
    public static final String PT_RECORD_NOT_FOUND_MSG = "An existing patient record is required to create a standing order";
    public static final int    REQUIRED_PT_SSN = 2010;
    public static final String REQUIRED_PT_SSN_MSG = "A social security number is required";
    public static final int    INVALID_PT_SSN = 2011;
    public static final String INVALID_PT_SSN_MSG = "The social security number is invalid";
    public static final int    REQUIRED_PT_L_NM = 2012;
    public static final String REQUIRED_PT_L_NM_MSG = "A patient last name is required";
    public static final int    REQUIRED_PT_F_NM = 2013;
    public static final String REQUIRED_PT_F_NM_MSG = "A patient first name is required";
    public static final int    REQUIRED_PT_DOB = 2014;
    public static final String REQUIRED_PT_DOB_MSG = "A patient date of birth is required";
    public static final int    INVALID_PT_DOB = 2015;
    public static final String INVALID_PT_DOB_MSG = "The patient date of birth is not valid.  Must not be future dated.";
    public static final int    REQUIRED_PT_SEX = 2016;
    public static final String REQUIRED_PT_SEX_MSG = "A patient sex is required";
    public static final int    REQUIRED_PT_COUNTRY = 2017;
    public static final String REQUIRED_PT_COUNTRY_MSG = "A patient country is required";
    public static final int    REQUIRED_PT_ADDR1 = 2018;
    public static final String REQUIRED_PT_ADDR1_MSG = "A patient address (1) is required";
    public static final int    REQUIRED_PT_ADDR2 = 2019;
    public static final String REQUIRED_PT_ADDR2_MSG = "A patient address (2) is required";
    public static final int    REQUIRED_PT_ZIP = 2020;
    public static final String REQUIRED_PT_ZIP_MSG = "A patient zip code is required";
    public static final int    INVALID_PT_ZIP = 2021;
    public static final String INVALID_PT_ZIP_MSG = "Invalid patient zip code";
    public static final int    REQUIRED_PT_CITY = 2022;
    public static final String REQUIRED_PT_CITY_MSG = "A patient city is required";
    public static final int    INVALID_PT_CITY = 2023;
    public static final String INVALID_PT_CITY_MSG = "Invalid patient city.";
    public static final int    REQUIRED_PT_STATE = 2024;
    public static final String REQUIRED_PT_STATE_MSG = "A patient state is required";
    public static final int    REQUIRED_PT_CMNTS = 2025;
    public static final String REQUIRED_PT_CMNTS_MSG = "Patient comments are required";
    public static final int    CONFLICT_PT_ZIP_STATE = 2026;
    public static final String CONFLICT_PT_ZIP_STATE_MSG = "The patient zip code conflicts with the state entered";
    public static final int    CONFLICT_EMPLYR_ZIP_STATE = 2027;
    public static final String CONFLICT_EMPLYR_ZIP_STATE_MSG = "The employer zip code conflicts with the state entered";

    public static final int    REQUIRED_PT_CASE = 2028;
    public static final String REQUIRED_PT_CASE_MSG = "A case number is required";
    public static final int    INVALID_PT_CASE = 2017;
    public static final String INVALID_PT_CASE_MSG = "The case number is invalid";
    public static final int    INVALID_PTDOB = 2029;
    public static final String INVALID_PTDOB_MSG = "The patient date of birth is not valid.";
    public static final int    REQUIRED_PT_PYR = 2030;
    public static final String REQUIRED_PT_PYR_MSG = "At least one payor is required";
    public static final int    REQUIRED_PT_HM_PHN = 2031;
    public static final String REQUIRED_PT_HM_PHN_MSG = "A patient home phone is required.";
    public static final int    INVALID_PT_HM_PHN = 2007;
    public static final String INVALID_PT_HM_PHN_MSG = "Patient home phone is invalid.";
    public static final int    REQUIRED_PT_WRK_PHN = 2032;
    public static final String REQUIRED_PT_WRK_PHN_MSG = "A patient work phone is required.";
    public static final int    INVALID_PT_WRK_PHN = 2008;
    public static final String INVALID_PT_WRK_PHN_MSG = "Patient work phone is invalid.";
    public static final int    REQUIRED_PT_EMAIL = 2033;
    public static final String REQUIRED_PT_EMAIL_MSG = "A patient email is required.";
    public static final int    INVALID_PT_EMAIL = 2006;
    public static final String INVALID_PT_EMAIL_MSG = "Invalid patient email.";
    public static final int    REQUIRED_EMPLYR_NM = 2034;
    public static final String REQUIRED_EMPLYR_NM_MSG = "Employer name is required.";
    public static final int    REQUIRED_EMPLYR_CITY = 2035;
    public static final String REQUIRED_EMPLYR_CITY_MSG = "Employer city is required.";
    public static final int    REQUIRED_EMPLYR_ZIP = 2036;
    public static final String REQUIRED_EMPLYR_ZIP_MSG = "Employer zip is required.";
    public static final int    INVALID_EMPLYR_ZIP = 2042;
    public static final String INVALID_EMPLYR_ZIP_MSG = "Employer zip is invalid.";
    public static final int    REQUIRED_EMPLYR_ST = 2037;
    public static final String REQUIRED_EMPLYR_ST_MSG = "Employer state is required.";
    public static final int    REQUIRED_EMPLYR_PHONE = 2001;
    public static final String REQUIRED_EMPLYR_PHONE_MSG = "Employer phone is required.";
    public static final int    INVALID_EMPLYR_PHONE = 2009;
    public static final String INVALID_EMPLYR_PHONE_MSG = "Employer phone is invalid.";
    public static final int    REQUIRED_EMPLYR_FAX = 2002;
    public static final String REQUIRED_EMPLYR_FAX_MSG = "Employer fax is required.";
    public static final int    INVALID_EMPLYR_FAX = 2041;
    public static final String INVALID_EMPLYR_FAX_MSG = "Employer fax is invalid.";
    public static final int    REQUIRED_EMPLYR_ADDR1 = 2003;
    public static final String REQUIRED_EMPLYR_ADDR1_MSG = "Employer address (1) is required.";
    public static final int    REQUIRED_EMPLYR_ADDR2 = 2004;
    public static final String REQUIRED_EMPLYR_ADDR2_MSG = "Employer address (2) is required.";
    public static final int    REQUIRED_EMPLYR_COUNTRY = 2005;
    public static final String REQUIRED_EMPLYR_COUNTRY_MSG = "Employer Country is required.";
    public static final int    REQUIRED_STD_ORDR_TST = 2038;
    public static final String REQUIRED_STD_ORDR_TST_MSG = "At least one "+test+" is required in a standing order";
    public static final int    DUP_STD_ORDR_TST = 2039;
    public static final String DUP_STD_ORDR_TST_MSG = "Duplicate "+test+" in the standing order";
    public static final int    REQUIRED_STD_ORDR_CLN_CNTCT_NM = 2040;
    public static final String REQUIRED_STD_ORDR_CLN_CNTCT_NM_MSG = "A client contact name is required";
    public static final int    REQUIRED_STD_ORDR_CLN_CNTCT_PHN = 2042;
    public static final String REQUIRED_STD_ORDR_CLN_CNTCT_PHN_MSG = "A client contact phone number is required";
    public static final int    REQUIRED_STD_ORDR_CLN_CNTCT_DLVRY_MTHD = 2044;
    public static final String REQUIRED_STD_ORDR_CLN_CNTCT_DLVRY_MTHD_MSG = "A method for sending renewal requests must be specified";
    public static final int    REQUIRED_ABN_RSN = 2046;
    public static final String REQUIRED_ABN_RSN_MSG = "No ABN reason code given.  Please resubmit this record with the default reason code suggested or supply a different reason code.";

    public static final int    MISSING_PT_PYR_ABBRV = 2047;
    public static final String MISSING_PT_PYR_ABBRV_MSG = "Missing a Payor ID";
    public static final int    DUPLICATE_PT_PYR_PRIO = 2048;
    public static final String DUPLICATE_PT_PYR_PRIO_MSG = "At least two payors have the same priority.  Priority must be unique";
    public static final int    MISSING_PT_PYR_PRIO = 2049;
    public static final String MISSING_PT_PYR_PRIO_MSG = "Missing a payor priority.   Priorities must start at '1' with no gaps in sequence";
    public static final int    INVALID_PT_PYR_PRIO = 2049;  // running out of error codes for pt demo JSP
    public static final String INVALID_PT_PYR_PRIO_MSG = "Invalid payor priority.   Priorities must be a positive integer that start at '1'";
    public static final int    REQUIRED_PT_PYR_SUBS_ID = 2050;
    public static final String REQUIRED_PT_PYR_SUBS_ID_MSG = "Required subscriber ID in payor record";
    public static final int    INVALID_PT_PYR_SUBS_ID = 2051;
    public static final String INVALID_PT_PYR_SUBS_ID_MSG = "Invalid subscriber ID in payor record";
    public static final int    REQUIRED_PT_PYR_PLN_ID = 2052;
    public static final String REQUIRED_PT_PYR_PLN_ID_MSG = "Required plan ID in payor record";
    public static final int    INVALID_PT_PYR_PLN_ID = 2053;
    public static final String INVALID_PT_PYR_PLN_ID_MSG = "Invalid plan ID in payor record";
    public static final int    REQUIRED_PT_PYR_GRP_ID = 2054;
    public static final String REQUIRED_PT_PYR_GRP_ID_MSG = "Required group ID in payor record";
    public static final int    INVALID_PT_PYR_GRP_ID = 2055;
    public static final String INVALID_PT_PYR_GRP_ID_MSG = "Invalid group ID in payor record";
    public static final int    REQUIRED_PT_PYR_INS_L_NM = 2056;
    public static final String REQUIRED_PT_PYR_INS_L_NM_MSG = "Required insurer last name in payor record";
    public static final int    INVALID_PT_PYR_INS_L_NM = 2057;
    public static final String INVALID_PT_PYR_INS_L_NM_MSG = "Invalid insurer last name in payor record";
    public static final int    REQUIRED_PT_PYR_INS_F_NM = 2058;
    public static final String REQUIRED_PT_PYR_INS_F_NM_MSG = "Required insurer first name in payor record";
    public static final int    INVALID_PT_PYR_INS_F_NM = 2059;
    public static final String INVALID_PT_PYR_INS_F_NM_MSG = "Invalid insurer first name in payor record";
    public static final int    REQUIRED_PT_PYR_INS_ADDR1 = 2060;
    public static final String REQUIRED_PT_PYR_INS_ADDR1_MSG = "Required insurer address #1 in payor record";
    public static final int    INVALID_PT_PYR_INS_ADDR1 = 2061;
    public static final String INVALID_PT_PYR_INS_ADDR1_MSG = "Invalid insurer address #1 in payor record";
    public static final int    REQUIRED_PT_PYR_INS_ADDR2 = 2062;
    public static final String REQUIRED_PT_PYR_INS_ADDR2_MSG = "Required insurer address #2 in payor record";
    public static final int    INVALID_PT_PYR_INS_ADDR2 = 2063;
    public static final String INVALID_PT_PYR_INS_ADDR2_MSG = "Invalid insurer address #2 in payor record";
    public static final int    REQUIRED_PT_PYR_INS_ZIP_ID = 2064;
    public static final String REQUIRED_PT_PYR_INS_ZIP_ID_MSG = "Required insurer ZIP code in payor record";
    public static final int    INVALID_PT_PYR_INS_ZIP_ID = 2065;
    public static final String INVALID_PT_PYR_INS_ZIP_ID_MSG = "Invalid insurer ZIP code in payor record";
    public static final int    REQUIRED_PT_PYR_INS_CITY = 2066;
    public static final String REQUIRED_PT_PYR_INS_CITY_MSG = "Required insurer city in payor record";
    public static final int    INVALID_PT_PYR_INS_CITY = 2067;
    public static final String INVALID_PT_PYR_INS_CITY_MSG = "Invalid insurer city in payor record";
    public static final int    REQUIRED_PT_PYR_INS_ST_ID = 2068;
    public static final String REQUIRED_PT_PYR_INS_ST_ID_MSG = "Required insurer state in payor record";
    public static final int    INVALID_PT_PYR_INS_ST_ID = 2069;
    public static final String INVALID_PT_PYR_INS_ST_ID_MSG = "Invalid insurer state in payor record";
    public static final int    REQUIRED_PT_PYR_INS_HM_PHN = 2070;
    public static final String REQUIRED_PT_PYR_INS_HM_PHN_MSG = "Required insurer home phone in payor record";
    public static final int    INVALID_PT_PYR_INS_HM_PHN = 2071;
    public static final String INVALID_PT_PYR_INS_HM_PHN_MSG = "Invalid insurer home phone in payor record";
    public static final int    REQUIRED_PT_PYR_INS_WK_PHN = 2072;
    public static final String REQUIRED_PT_PYR_INS_WK_PHN_MSG = "Required insurer work phone in payor record";
    public static final int    INVALID_PT_PYR_INS_WK_PHN = 2073;
    public static final String INVALID_PT_PYR_INS_WK_PHN_MSG = "Invalid insurer work phone in payor record";
    public static final int    REQUIRED_PT_PYR_OTHER_INFO = 2074;
    public static final String REQUIRED_PT_PYR_OTHER_INFO_MSG = "Required other info in payor record";
    public static final int    INVALID_PT_PYR_OTHER_INFO = 2075;
    public static final String INVALID_PT_PYR_OTHER_INFO_MSG = "Invalid other info in payor record";
    public static final int    REQUIRED_PT_PYR_CMNT = 2076;
    public static final String REQUIRED_PT_PYR_CMNT_MSG = "Required comment in payor record";
    public static final int    INVALID_PT_PYR_CMNT = 2077;
    public static final String INVALID_PT_PYR_CMNT_MSG = "Invalid comment in payor record";

    public static final int    INVALID_DUP_PYRREF = 2078;
    public static final String INVALID_DUP_PYRXREF_MSG = "An invalid duplicate Payor cross reference type or a duplicate of a XREF Type-Xref member was entered. <BR> To setup valid duplicates of xref types, select the File Maintenance Cross Reference screen. -- ";
    public static final int    INVALID_SINGLE_USE_PYR_XREF = 2079;
    public static final String INVALID_SINGLE_USE_PYR_XREF_MSG = "This type of cross reference may only be assigned to one payor";

    public static final int    INVALID_TEST_ID = 2080;
    public static final String INVALID_TEST_ID_MSG = "Invalid "+Test+" ID.";

    public static final int    INVALID_PT_DIAG_DIAG_CD_ID = 2081;
    public static final String INVALID_PT_DIAG_DIAG_CD_MSG = "Invalid diagnosis code specified: ";
    public static final int    DUP_PT_DIAG_DIAG_CD_ID = 2082;
    public static final String DUP_PT_DIAG_DIAG_CD_MSG = "Duplicate patient diag code: ";
    public static final int    DIAG_NOT_HIGHEST_SPECIFICITY_ID = 2083;
    public static final String DIAG_NOT_HIGHEST_SPECIFICITY_MSG = "All diagnosis codes must be specified at the highest level of specificity.  The following diagnosis code is not: ";
    public static final int    DUP_PT_PT_PYR_WITH_DIFF_EFF_DT_ID = 2084;
    public static final String DUP_PT_PT_PYR_WITH_DIFF_EFF_DT_MSG = "You cannot create a new effective date record because it contains the exact same information as the record with effective date: ";
    public static final int    INVALID_PT_PYR_INS_EMAIL = 2085;
    public static final String INVALID_PT_PYR_INS_EMAIL_MSG = "Insured email invalid/missing";
    public static final int    INVALID_PT_PYR_INS_COUNTRY = 2086;
    public static final String INVALID_PT_PYR_INS_COUNTRY_MSG = "Insured country invalid/missing ";
    public static final int    DEL_LAST_EFFDT_ERR = 2087;
    public static final String DEL_LAST_EFFDT_ERR_MSG = "The patient requires at least one effective date.";
    public static final int    PT_DEM_DPH_MEDICARE_DEFAULT_ERR = 2088;
    public static final String PT_DEM_DPH_MEDICARE_DEFAULT_ERR_MSG = "Error retrieving default Medicare Dialysis Information: Contact Xifin Support - ";
    public static final int    PT_DEM_DPH_IMPORT_ERROR = 2089;
    public static final String PT_DEM_DPH_IMPORT_ERROR_MSG = "Error importing dialysis history records - ";
    public static final int PT_DEMO_ROLLBACK_FATAL_ERROR = 10600;
    public static final String PT_DEMO_ROLLBACK_FATAL_ERROR_MSG = "Fatal error while attempting to rollback transaction. Contact your system administrator.";
    public static final int PT_DEMO_XACTION_ROLLBACK = 10601;
    public static final String PT_DEMO_XACTION_ROLLBACK_MSG = "Submit aborted. Transaction rolled back due to exception. ";


    public static final int    INVALID_MSP_DOS_DOB = 2140;
    public static final String INVALID_MSP_DOS_DOB_MSG = "\"DOS of Most Recent MSP Form\" must be after the Patient Date of Birth";
    public static final int    INVALID_FUTURE_MSP_DOS = 2141;
    public static final String INVALID_FUTURE_MSP_DOS_MSG = "\"DOS of Most Recent MSP Form\" cannot be in the future";

    public static final int    MISSING_PYR_DT_RECORD = 2090;
    public static final String MISSING_PYR_DT_RECORD_MSG = "Unable to determine which diagnosis code types to use for this patient's primary payor";
    public static final int    PATIENT_LAST_PYR = 2091;
    public static final String PATIENT_LAST_PYR_MSG = "No other payors allowed after Patient Payor.";
    public static final int    PATIENT_DEL = 2092;
    public static final String PATIENT_DEL_MSG = "Deleting Patient Payor not allowed.";
    public static final int    RESUBMIT = 2093;
    public static final String RESUBMIT_MSG = "Re-submitting to a payor that was never submitted to is not allowed.";
    public static final int    INVALID_PT_MARITAL_STA_TYP = 2094;
    public static final String INVALID_PT_MARITAL_STA_TYP_MSG = "Invalid marital status type is selected";
    public static final int    REQUIRED_PT_MARITAL_STA_TYP = 2095;
    public static final String REQUIRED_PT_MARITAL_STA_TYP_MSG = "A patient marital status type is required";
    public static final int    INVALID_PT_PYR_SEX = 2096;
    public static final String INVALID_PT_PYR_SEX_MSG = "Invalid sex in payor record";
    public static final int    REQUIRED_PT_PYR_SEX = 2097;
    public static final String REQUIRED_PT_PYR_SEX_MSG = "Required sex in payor record";
    public static final int    INVALID_PT_PYR_DOB = 2098;
    public static final String INVALID_PT_PYR_DOB_MSG = "Invalid DOB in payor record";
    public static final int    REQUIRED_PT_PYR_DOB = 2099;
    public static final String REQUIRED_PT_PYR_DOB_MSG = "Required DOB in payor record";
    public static final int    INVALID_PT_ID = 8010;
    public static final String INVALID_PT_ID_MSG = "Invalid characters in Patient ID";
    public static final int INVALID_SUSPEND_NOTE = 8011;
    public static final String INVALID_SUSPEND_MSG = "Suspend Reason Note has more than allowed number of characters";

    public static final int    PT_DEMO_ERROR = 8000; // general error
    public static final int    INVALID_COLL_PYR_ABBRV = 8001;
    public static final String INVALID_COLL_PYR_ABBRV_MSG = "Invalid Payor ID: Patient Demographics record may not have a collections payor.";
    public static final int    INVALID_PDH_DOS_DT = 8002;
    public static final String INVALID_PDH_DOS_DT_MSG = "Invalid Xifin Patient Dialysis History Date of service.";
    public static final int    INVALID_PDH_INV_PROC_ID = 8003;
    public static final String INVALID_PDH_INV_PROC_ID_MSG = "Invalid Proc ID in Xifin Patient Dialysis History grid.";
    public static final int    INVALID_PDH_INV_HIST_STRT_DT = 8004;
    public static final String INVALID_PDH_INV_HIST_STRT_DT_MSG = "Invalid History Range Start Date";
    public static final int    INVALID_PDH_INV_HIST_END_DT = 8005;
    public static final String INVALID_PDH_INV_HIST_END_DT_MSG = "Invalid History Range End Date";
    public static final int    INVALID_PDH_DUPLICATE_PROC = 8006;
    public static final String INVALID_PDH_DUPLICATE_PROC_MSG = "NON-Xifin Dialysis History - Duplicate Proc Ignored";
    public static final int    INVALID_MSP_DOS = 8007;
    public static final String INVALID_MSP_DOS_MSG = "MSP DOS Cannot be before patient DOB or a future date.";
    public static final int    WARN_EXPIRING_PT_STD_ORDERS = 8020;
    public static final String WARN_EXPIRING_PT_STD_ORDERS_MSG = "This update will result in the following standing order(s) being expired. Click Save And Clear again to save changes:";

    // Accession Manifest Error Codes (2100 - 2149)
    public static final int    INVALID_MNFST_ID = 2100;
    public static final String INVALID_MNFST_ID_MSG = "Invalid manifest ID.";
    public static final int    NO_ACCNS_FOUND = 2110;
    public static final String NO_ACCNS_FOUND_MSG = "No "+accession+"s were found.  Unable to generate a manifest";
    public static final int    AM_WRONG_VER_LAB_TO_PHYS = 2111;
    public static final String AM_WRONG_VER_LAB_TO_PHYS_MSG = "Cannot load an "+accession+" manifest from the "+sfmLab+" "+accession+" manifest screen into the physician version of "+accession+" manifest. Manifest id:";
    public static final int    AM_WRONG_VER_PHYS_TO_LAB = 2112;
    public static final String AM_WRONG_VER_PHYS_TO_LAB_MSG = "Cannot load an "+accession+" manifest from the physician "+accession+" manifest screen into the "+sfmLab+" version of "+accession+" manifest. Manifest id:";
    public static final int    AM_CREATE_MNFST_ID_ERROR = 2113;
    public static final String AM_CREATE_MNFST_ID_ERROR_MSG = "Could not create a new "+accession+" manifest id.";
    public static final int    AM_FAC_LOAD_ERROR = 2114;
    public static final String AM_FAC_LOAD_ERROR_MSG = "Could not load the facility associated with the manifest.";
    public static final int    AM_CLN_LOAD_ERROR = 2115;
    public static final String AM_CLN_LOAD_ERROR_MSG = "Could not load the client associated with the manifest.";


    // Daily Receipt Error Codes (2150 - 2199)
    public static final int    ACD_INVALID_DLY_RCPT_ID = 2150;
    public static final String ACD_INVALID_DLY_RCPT_ID_MSG = "Invalid Daily Receipt ID.";
    public static final int    ACD_CREATE_DLY_RCPT_ID_ERROR = 2151;
    public static final String ACD_CREATE_DLY_RCPT_ID_ERROR_MSG = "An error prevented a new daily receipt ID from being generated.";
    public static final int    ACD_REQUIRED_PSC_ID = 2160;
    public static final String ACD_REQUIRED_PSC_ID_MSG = "A Payment facility is required.";
    public static final int    ACD_REQUIRED_PHLEB_ID = 2162;
    public static final String ACD_REQUIRED_PHLEB_ID_MSG = "A Payment User ID is required.";

    public static final int    ACD_REQUIRED_CASH_DRWR_OPENED_BY = 2164;
    public static final String ACD_REQUIRED_CASH_DRWR_OPENED_BY_MSG = "You must record who opened the cash drawer.";
    public static final int    ACD_REQUIRED_CASH_DRWR_CLOSED_BY = 2166;
    public static final String ACD_REQUIRED_CASH_DRWR_CLOSED_BY_MSG = "You must record who closed the cash drawer.";
    public static final int    ACD_REQUIRED_COMMENT = 2168;
    public static final String ACD_REQUIRED_COMMENT_MSG = "A explanation of why the cash is over/under is required.";
    public static final int    ACD_INCORRECT_CASH_OVER_UNDER = 2170;
    public static final String ACD_INCORRECT_CASH_OVER_UNDER_MSG = "The amount entered for cash over/under is incorrect.";
    public static final int    ACD_NO_ACCN_PMTS_FOUND = 2180;
    public static final String ACD_NO_ACCN_PMTS_FOUND_MSG = "No payments were found.  Unable to generate a daily receipt.";
    public static final int    ACD_DEP_DATA_LOCK_ERROR = 2181;
    public static final String ACD_DEP_DATA_LOCK_ERROR_MSG = "Unable to obtain a lock on deposit ";
    public static final int    ACD_ACCN_DATA_LOCK_ERROR = 2182;
    public static final String ACD_ACCN_DATA_LOCK_ERROR_MSG = "Unable to obtain lock on "+accession;
    public static final int    ACD_XACTION_ROLLBACK = 2183;
    public static final String ACD_XACTION_ROLLBACK_MSG = "Submit cancelled. Transaction rolled back to due to exception. ";
    public static final int    ACD_XACTION_ROLLBACK_FATAL_ERROR = 2184;
    public static final String ACD_XACTION_ROLLBACK_FATAL_ERROR_MSG = "Fatal error while attempting to rollback transaction. Contact your system administrator.";
    public static final int    ACD_UNKNOWN_FATAL_ERROR = 2185;
    public static final String ACD_UNKNOWN_FATAL_ERROR_MSG = "An unknown error occurred while attempting to submit.";
    public static final int    ACD_NO_ACCN_PMTS_LOAD_ERROR = 2186;
    public static final String ACD_NO_ACCN_PMTS_LOAD_ERROR_MSG = "An error prevented loading of payments.  Unable to generate a daily receipt.";
    public static final int    ACD_DLY_RCPT_LOAD_ERROR = 2187;
    public static final String ACD_DLY_RCPT_LOAD_ERROR_MSG = "An unknown error prevented loading of the daily receipt.";
    public static final int    ACD_DLY_RCPT_INVALID_PMT_REFERENCED = 2188;
    public static final String ACD_DLY_RCPT_INVALID_PMT_REFERENCED_MSG = "Daily receipt not created. A payment referenced by the receipt was not found.";
    public static final int    ACD_DLY_RCPT_INVALID_PARAMTER = 2189;
    public static final String ACD_DLY_RCPT_INVALID_PARAMTER_MSG = "An invalid request parameter from page caused an error on submit.";

    //Facility Demographics (2200 - 2230)
    public static final int FAC_DEMO_INVALID_FAC_SPECIALTY_TYP_ID = 2196;
    public static final String FAC_DEMO_INVALID_FAC_SPECIALTY_TYP_ID_MSG = "The facility specialty type ID could not be parsed.";
    public static final int FAC_DEMO_SVC_TYP_REQ = 2197;
    public static final String FAC_DEMO_SVC_TYP_REQ_MSG = "A Service Type selection is required.";
    public static final int FAC_DEMO_MAMMO_CERT_ID = 2198;
    public static final String FAC_DEMO_MAMMO_CERT_ID_MSG = "Mammography Certification Number is required.";
    public static final int FAC_DEMO_INVALID_CLIA_NUM = 2199;
    public static final String FAC_DEMO_INVALID_CLIA_NUM_MSG = "Invalid CLIA number format - Must be 2 digits followed 1 alphabet letter [A-Z] followed by 7 digits.";
    public static final int FAC_DEMO_DATA_LOCK_ERROR = 2200;
    public static final String FAC_DEMO_DATA_LOCK_ERROR_MSG = "Could not obtain a lock on facility ";
    public static final int FAC_DEMO_INVALID_PYR = 2201;
    public static final String FAC_DEMO_INVALID_PYR_MSG = "Invalid payor ID entered.";
    public static final int FAC_DEMO_INVALID_FAC_TYP_ID = 2202;
    public static final String FAC_DEMO_INVALID_FAC_TYP_ID_MSG = "The facility type ID could not be parsed.";
    public static final int FAC_DEMO_INVALID_FAC_ID = 2203;
    public static final String FAC_DEMO_INVALID_FAC_ID_MSG = "The facility ID could not be parsed.";
    public static final int FAC_DEMO_XACTION_ROLLBACK_FATAL_ERROR = 2204;
    public static final String FAC_DEMO_XACTION_ROLLBACK_FATAL_ERROR_MSG = "Fatal error while attempting to rollback transaction. Contact your system administrator.";
    public static final int FAC_DEMO_XACTION_ROLLBACK = 2205;
    public static final String FAC_DEMO_XACTION_ROLLBACK_MSG = "Submit cancelled. Transaction rolled back to due to exception. ";
    public static final int FAC_DEMO_COULDNT_LOAD_FAC_LIC = 2206;
    public static final String FAC_DEMO_COULDNT_LOAD_FAC_LIC_MSG = "An error occurred while loading the facility license information for facility.";
    public static final int FAC_DEMO_COULDNT_LOAD_FAC_PYR = 2207;
    public static final String FAC_DEMO_COULDNT_LOAD_FAC_PYR_MSG = "An error occurred while loading the facility payor information for facility.";
    public static final int FAC_DEMO_COULDNT_PARSE_FAC_LIC_TYP = 2208;
    public static final String FAC_DEMO_COULDNT_PARSE_FAC_LIC_TYP_MSG = "Facility license type could not be parse from request.";
    public static final int FAC_DEMO_DUPLICATE_PYR = 2209;
    public static final String FAC_DEMO_DUPLICATE_PYR_MSG = "Cannot add payor. Entry already exists for payor.";
    public static final int FAC_DEMO_INVALID_BILLING_FACILITY = 2210;
    public static final String FAC_DEMO_INVALID_BILLING_FACILITY_MSG = "Billing facility for this facility is invalid. Please select a correct billing facility and hit submit.";
    public static final int FAC_DEMO_COULDNT_GET_NEXT_SEQ_NUM = 2211;
    public static final String FAC_DEMO_COULDNT_GET_NEXT_SEQ_NUM_MSG = "Cannot create new facility record. The next facility sequence number could not be obtained.";
    public static final int    FAC_INVALID_MAIL_ZIP_ID = 2212;
    public static final String FAC_INVALID_MAIL_ZIP_ID_MSG = "Facility zip code is either missing or invalid";
    public static final int    FAC_CONFLICT_MAIL_ZIP_STATE = 2213;
    public static final String FAC_CONFLICT_MAIL_ZIP_STATE_MSG = "The Facility zip code conflicts with the state entered";
    public static final int    FAC_INVALID_CORRESP_ZIP_ID = 2214;
    public static final String FAC_INVALID_CORRESP_ZIP_ID_MSG = "Correspondence zip code is either missing or invalid";
    public static final int    FAC_CONFLICT_CORRESP_ZIP_STATE = 2215;
    public static final String FAC_CONFLICT_CORRESP_ZIP_STATE_MSG = "The Correspondence zip code conflicts with the state entered";
    public static final int    FAC_INVALID_REMIT_ZIP_ID = 2216;
    public static final String FAC_INVALID_REMIT_ZIP_ID_MSG = "Remit To zip code is either missing or invalid";
    public static final int    FAC_CONFLICT_REMIT_ZIP_STATE = 2217;
    public static final String FAC_CONFLICT_REMIT_ZIP_STATE_MSG = "The Remit To zip code conflicts with the state entered";
    public static final int FAC_DEMO_INVALID_SUBM_PYR_ID = 2218;
    public static final String FAC_DEMO_INVALID_SUBM_PYR_ID_MSG = "The submission Pyr ID could not be parsed.";
    public static final int FAC_DEMO_MED_SUBM_PYR_ID = 2219;
    public static final String FAC_DEMO_MED_SUBM_PYR_ID_MSG = "Medicare payor selection is required.";
    public static final int FAC_DEMO_TAX_ID = 2220;
    public static final String FAC_DEMO_TAXID_ID_MSG = "Tax ID is required.";
    public static final int FAC_DEMO_CLIA_NUM_ID = 2221;
    public static final String FAC_DEMO_CLIA_NUM_MSG = "CLIA number is required.";
    public static final int FAC_DEMO_CONTACT_1_ID = 2222;
    public static final String FAC_DEMO_CONTACT_1_MSG = "Contact 1 is required.";
    public static final int FAC_DEMO_FAC_TYPE_ID = 2223;
    public static final String FAC_DEMO_FAC_TYPE_MSG ="Facility type is required";
    public static final int FAC_DEMO_FAC_XREF_REQUIRED = 2224;
    public static final String FAC_DEMO_FAC_XREF_REQUIRED_MSG ="Facility Xref Type required";
    public static final int FAC_DEMO_NAME_FIELD_REQUIRED = 2225;
    public static final String FAC_DEMO_NAME_FIELD_REQUIRED_MSG ="Name field required";
    public static final int FAC_DEMO_ADDR1_FIELD_REQUIRED = 2226;
    public static final String FAC_DEMO_ADDR1_FIELD_REQUIRED_MSG ="Address 1 field required";
    public static final int FAC_DEMO_ZIP_FIELD_REQUIRED = 2227;
    public static final String FAC_DEMO_ZIP_FIELD_REQUIRED_MSG ="Zip Code field required";
    public static final int FAC_DEMO_NPI_ERROR = 2228;
    public static final String FAC_DEMO_NPI_ERROR_MSG ="Invalid Facility NPI - Must be a 10 digit numeric value without leading zeros";
    public static final int FAC_DEMO_NPI_INVALID_FAC = 2229;
    public static final String FAC_DEMO_NPI_INVALID_FAC_MSG ="Invalid Facility NPI - Current in use by a non facility entity";
    public static final int FAC_DEMO_ORG_NPI_ERROR = 2230;
    public static final String FAC_DEMO_ORG_NPI_ERROR_MSG ="Invalid Organizational NPI - Must be a 10 digit numeric value without leading zeros";

    //Facility Demographics (2200 - 2230)

    //Payment Discrepancy Summary (2231 - 2240)
    public static final int PMT_DISCR_DATA_LOCK_ERROR = 2231;
    public static final String PMT_DISCR_DATA_LOCK_ERROR_MSG = "Could not obtain a lock on batch ";
    public static final int PMT_DISCR_INVALID_BATCH = 2232;
    public static final String PMT_DISCR_INVALID_BATCH_MSG = "Could not load batch ";
    public static final int PMT_DISCR_XACTION_ROLLBACK_FATAL_ERROR = 2233;
    public static final String PMT_DISCR_XACTION_ROLLBACK_FATAL_ERROR_MSG = "Fatal error while attempting to rollback transaction. Contact your system administrator.";
    public static final int PMT_DISCR_XACTION_ROLLBACK = 2234;
    public static final String PMT_DISCR_XACTION_ROLLBACK_MSG = "Submit aborted. Transaction rolled back to due to exception. ";
    public static final int PMT_DISCR_PRC_DATA_LOCK_ERROR = 2235;
    public static final String PMT_DISCR_PRC_DATA_LOCK_ERROR_MSG = "Could not obtain a lock on expect fee schedule with id ";
    //Payment Discrepancy Summary (2231 - 2240)

    //Extra Facility Demographics (2200 - 2240)
    public static final int FAC_DEMO_DUP_FAC_NAME = 2241;
    public static final String FAC_DEMO_DUP_FAC_NAME_MSG ="Duplicate Facility Name";
    public static final int FAC_DEMO_PYR_PYR_GRP = 2242;
    public static final String FAC_DEMO_PYR_PYR_GRP_MSG ="Either Payor or Payor Group (not both) must be specified.";
    public static final int FAC_DEMO_DUP_PYR = 2243;
    public static final String FAC_DEMO_DUP_PYR_MSG ="Duplicate Payor or Payor Group is not allowed.";
    public static final int NPI_ORGANIZATIONAL_NPI_REQ_ERROR = 2244;
    public static final String NPI_ORGANIZATIONAL_NPI_REQ_ERROR_MSG ="Organizational NPI is required.";
    public static final int NPI_DOES_NOT_EXIST_ERROR = 2245;
    public static final String NPI_DOES_NOT_EXIST_ERROR_MSG ="NPI does not exist in local or global database.";
    public static final int BILL_TO_FAC_CANNOT_BE_DELETED = 2246;
    public static final String BILL_TO_FAC_CANNOT_BE_DELETED_MSG ="Unable to delete facility as it is the Billing Facility on Facility ";
    public static final int FAC_DEMO_TYPE_UPDATE = 2247;
    public static final String FAC_DEMO_TYPE_UPDATE_MSG = "Facility Type cannot be updated to";
    public static final int FAC_DEMO_SVC_TYP_INVALID = 2248;
    public static final String FAC_DEMO_SVC_TYP_INVALID_MSG = "Service Type selection is invalid.";
    public static final int FAC_DEMO_FAC_GRP_NOT_ACCEPTED = 2249;
    public static final String FAC_DEMO_FAC_GRP_NOT_ACCEPTED_MSG = "Facility Groups not supported.";
    public static final int FAC_DEMO_CANNOT_DELETE_MAIN_FAC = 2250;
    public static final String FAC_DEMO_CANNOT_DELETE_MAIN_FAC_MSG = "Main Facility cannot be deleted.";
    public static final int FACBILL_ERROR_LOADING_PROC = 2236;
    public static final String FACBILL_ERROR_LOADING_PROC_MSG = "An error occurred and prevented the proc data from being loaded.";
    public static final int FACBILL_ERROR_PYR_GRP_EXCL = 2237;
    public static final String FACBILL_ERROR_PYR_GRP_EXCL_MSG = "Payor Group Exclusion is not allowed if there is a Payor or Payor Group Inclusion";
    public static final int FACBILL_ERROR_PYR_EXCL = 2238;
    //Extra Facility Demographics (2200 - 2250)


    //Non-Client Payment Summary (2251 - 2970)
    public static final int NCPS_DATA_LOCK_ERROR = 2251;
    public static final String NCPS_DATA_LOCK_ERROR_MSG = "Could not obtain a lock on batch ";
    public static final int NCPS_INVALID_BATCH = 2252;
    public static final String NCPS_INVALID_BATCH_MSG = "Could not load batch ";
    public static final int NCPS_COULDNT_LOAD_ACCN_DTL = 2253;
    public static final String NCPS_COULDNT_LOAD_ACCN_DTL_MSG = "Could not load "+accession+" detail. There was no data in the session to use in search.";
    public static final int NCPS_COULDNT_LOAD_PROC_DTL = 2254;
    public static final String NCPS_COULDNT_LOAD_PROC_DTL_MSG = "Could not load proc code detail. There was no data in the session to use in search.";
    public static final int NCPS_XACTION_ROLLBACK_FATAL_ERROR = 2255;
    public static final String NCPS_XACTION_ROLLBACK_FATAL_ERROR_MSG = "Fatal error while attempting to rollback transaction. Contact your system administrator.";
    public static final int NCPS_XACTION_ROLLBACK = 2256;
    public static final String NCPS_XACTION_ROLLBACK_MSG = "Submit aborted. Transaction rolled back to due to exception. ";
    public static final int NCPS_POST_ERROR = 2257;
    public static final String NCPS_POST_ERROR_MSG = "A posting error occurred.";
    public static final int NCPS_DISCREP_NOT_RELEASED = 2258;
    public static final String NCPS_DISCREP_NOT_RELEASED_MSG = "Batch cannot be posted. Batch discrepancies have not been released.";
    public static final int NCPS_ERROR_LOADING_BATCH = 2259;
    public static final String NCPS_ERROR_LOADING_BATCH_MSG = "An error occurred and prevented the batch data from being loaded.";
    public static final int NCPS_ERROR_LOADING_PYR = 2260;
    public static final String NCPS_ERROR_LOADING_PYR_MSG = "An error occurred and prevented the payor data from being loaded.";
    public static final int NCPS_ERROR_LOADING_ACCN_DTL = 2261;
    public static final String NCPS_ERROR_LOADING_ACCN_DTL_MSG = "An error occurred and the "+accession+" detail could not be loaded,";
    public static final int NCPS_ERROR_LOADING_PROC_DTL = 2262;
    public static final String NCPS_ERROR_LOADING_PROC_DTL_MSG = "An error occurred and the proc code detail could not be loaded,";
    public static final int NCPS_NONE_SELECTED = 2263;
    public static final String NCPS_NONE_SELECTED_MSG = "No items have been selected for posting.";
    public static final int NCPS_ALLOW_AMT_NOT_NEGATIVE_IF_PAID_AMT_POSITIVE = 2264;
    public static final String NCPS_ALLOW_AMT_NOT_NEGATIVE_IF_PAID_AMT_POSITIVE_MSG = "Allowed amount cannot be negative if paid amount is positive.";
    public static final int NCPS_ALLOW_AMT_NOT_SMALLER_THAN_PAID_AMT = 2265;
    public static final String NCPS_ALLOW_AMT_NOT_SMALLER_THAN_PAID_AMT_MSG = "Allowed amount must be equal to or greater than paid amount.";

    //Non-Client Payment Summary (2251 - 2970)

    // Payor Requirement error codes/msg
    public static final int INVALID_DOS_MATCH = 2996;
    public static final String INVALID_DOS_MATCH_MSG = "DOS Eff Date must be on or before Eff Date.";
    public static final int INVALID_PAT_ERR_MATCH = 2997;
    public static final String INVALID_PAT_ERR_MATCH_MSG = "Must have both pattern and error message or neither.";
    public static final int INVALID_FLD_ID = 2998;
    public static final String INVALID_FLD_ID_MSG = "Invalid field id";
    public static final int INVALID_DATE = 2999;
    public static final String INVALID_DATE_MSG = "Invalid date format";
    public static final int DELETE_ERROR = 3000;
    public static final String DELETE_MSG = "Delete unsuccessful";
    public static final int UPDATE_ERROR = 3001;
    public static final String UPDATE_MSG = "Update unsuccessful";
    public static final int GET_ERROR = 3002;
    public static final String GET_MSG = "Get unsuccessful";
    public static final int CREATE_ERROR = 3003;
    public static final String CREATE_MSG = "Create unsuccessful";
    public static final int PYR_REQ_NO_DOUBLE_QUOTES = 7200;
    public static final String PYR_REQ_NO_DOUBLE_QUOTES_MSG = "Double quotes (\") cannot be used in the error message.";

    // Special price table
    public static final int IMPORT_SRC_ERROR = 3004;
    public static final String IMPORT_SRC_MSG = "Invalid data source";
    public static final int IMPORT_ERROR = 3005;
    public static final String IMPORT_MSG = "Error on import";
    public static final int INVALID_COPY = 3006;
    public static final String INVALID_COPY_MSG = "Invalid copy operation";
    public static final int RETRO_ERROR = 3007;
    public static final String RETRO_ERROR_MSG = "Retro pricing attempted";
    public static final int IMPORT_NOTE = 7210;
    public static final String INVALID_MEDICARE_PYR_ID_MSG = "The selected Facility has a different Medicare Payer Id than the clients using this special price table.";
    public static final String INVALID_FAC_ID_MSG = "Facility not selected.";
    public static final String IMPORT_TELL_USER_TO_CHECK_FILE = "Please verify that all records in the file are in the correct format.";
    public static final String IMPORT_NOTE_MSG = "The items displayed include records that already existed in the table that matched imported records.";
    public static final String IMPORT_PARTIAL_FAIL_MSG = "Errors occurred and not all records were imported.  " + IMPORT_TELL_USER_TO_CHECK_FILE;
    public static final String IMPORT_INVALID_EFF_DT = "Invalid effective date";
    public static final String IMPORT_INVALID_EXP_DT = "Invalid expiration date";
    public static final String IMPORT_INVALID_PRICE = "Invalid price";
    public static final String IMPORT_TOO_MANY_FIELDS = "Invalid data file:  Too many fields.";
    public static final String IMPORT_TOO_MANY_RECORDS = "Invalid data file:  Too many records. Maximum number of records is: ";
    public static final String IMPORT_ID_NOT_FOUND = " was not found.";
    public static final String IMPORT_INVALID_DATA_FILE = "Invalid data file.  " + IMPORT_TELL_USER_TO_CHECK_FILE;
    public static final String IMPORT_EXISTING_UPDATED = "Existing records were updated.  " +
            "These records have been marked with an asterisk (*) before the "+test+" name.";
    public static final String IMPORT_EXISTING_NOT_UPDATED = "The imported file contained " +
            "multiple entries that are identical except for the prices.  " +
            "These entries have been marked with a plus sign (+) before the " +
            test+" name.  Review the entries and either delete them or modify them to be unique.";
    public static final String IMPORT_IDENTICAL_IGNORED = "The imported file contained " +
            "identical record(s).  The duplicate entries were not loaded.";

    public static final int FM_PRC_DATE_RANGE_ERROR = 3008;
    public static final String FM_PRC_OVERLAP_ERROR_MSG = "An overlapping record already exists.";
    public static final String FM_PRC_GAP_ERROR_MSG = "A gap in the effective date records exists.";

    // Order Entry
    public static final int MISSING_CLNID_OR_DOS = 3008;
    public static final String MISSING_CLNID_OR_DOS_MSG = "Missing client ID or date of service";
    public static final int PYR_EXCLUDED = 3009;
    public static final String PYR_EXCLUDED_MSG = "payor excluded";
    public static final int PYR_DOES_NOT_EXIST = 3010;
    public static final String PYR_DOES_NOT_EXIST_MSG = "payor doesn't exist";
    public static final int INVALID_DIAG_CD = 3011;
    public static final String INVALID_DIAG_CD_MSG = "Invalid diagnosis code";


    // PyrGrpDemoGraphics
    public static final int REQUIRED_MIN_BAL  = 3012;
    public static final int REQUIRED_WO_AGE   =  3013;
    public static final int REQUIRED_ADJ_CODE  = 3014;
    public static final String REQUIRED_MIN_BAL_MSG  = "Min w/o Bal Required";
    public static final String REQUIRED_WO_AGE_MSG   =  "w/o Age Required";
    public static final String REQUIRED_ADJ_CODE_MSG   =  "ADJ CD Required";
    public static final int REQUIRED_PRC_SUSP_EFF_DT  = 3015;
    public static final String REQUIRED_PRC_SUSP_EFF_DT_MSG  = "PRICING Eff Date Required";
    public static final int REQUIRED_BIL_SUSP_EFF_DT  = 3016;
    public static final String REQUIRED_BIl_SUSP_EFF_DT_MSG  = "BILLING Eff Date Required";
    public static final int PRC_SUSP_EFF_DT_INVALID  = 3017;
    public static final String PRC_SUSP_EFF_DT_INVALID_MSG  = "Invalid Pricing Effective Date";
    public static final int BIL_SUSP_EFF_DT_INVALID  = 3018;
    public static final String BIl_SUSP_EFF_DT_INVALID_MSG  = "Invalid Billing Effective Date";
    public static final int PRC_SUSP_EXP_DT_INVALID  = 3019;
    public static final String PRC_SUSP_EXP_DT_INVALID_MSG  = "Invalid Pricing Exp Date";
    public static final int BIL_SUSP_EXP_DT_INVALID  = 3020;
    public static final String BIl_SUSP_EXP_DT_INVALID_MSG  = "Invalid Billing Exp Date";
    public static final int AUTO_WO_BASIS_INVALID  = 3062;
    public static final String AUTO_WO_BASIS_INVALID_MSG    = "Auto Write-Off Basis Missing or Invalid";

    // PyrContrctConfig
    public static final int REQUIRED_CONTRCT_ID  = 3021;
    public static final String REQUIRED_CONTRCT_ID_MSG  = "Contract ID Required";
    public static final int REQUIRED_CONTRCT_NM  = 3022;
    public static final String REQUIRED_CONTRCT_NM_MSG  = "Contract Name Required";
    public static final int REQUIRED_CONTRCT_COVRG   =  3023;
    public static final String REQUIRED_CONTRCT_COVRG_MSG   =  "Contract Coverage Required";
    public static final int REQUIRED_CONTRCT_START_DT  = 3024;
    public static final String REQUIRED_CONTRCT_START_DT_MSG   =  "Contract Effective Date Required";
    public static final int REQUIRED_CONTRCT_REVIEW_DT  = 3025;
    public static final String REQUIRED_CONTRCT_REVIEW_DT_MSG  = "Contract Review Date Required";
    public static final int REQUIRED_CONTRCT_RPT_FRM  = 3026;
    public static final String REQUIRED_CONTRCT_RPT_FRM_MSG  = "Report Form Required";
    public static final int REQUIRED_CONTRCT_RPT_FREQ  = 3027;
    public static final String REQUIRED_CONTRCT_RPT_FREQ_MSG  = "Report Frequency Required";
    public static final int REQUIRED_CONTRCT_ADMIN_NM  = 3028;
    public static final String REQUIRED_CONTRCT_ADMIN_NM_MSG  = "Administrator Name Required";
    public static final int REQUIRED_PYR_ID = 3029;
    public static final String REQUIRED_PYR_ID_MSG  = "Payor ID Required";
    public static final int REQUIRED_PYR_EFF_DT = 3030;
    public static final String REQUIRED_PYR_EFF_DT_MSG  = "Payor Effective Date Required";
    public static final int CONTRCT_EFF_DT_INVALID  = 3031;
    public static final String CONTRCT_EFF_DT_INVALID_MSG  = "Invalid Contract Effective Date";
    public static final int CONTRCT_REVIEW_DT_INVALID  = 3032;
    public static final String CONTRCT_REVIEW_DT_INVALID_MSG  = "Invalid Review Date";
    public static final int CONTRCT_EXP_DT_INVALID  = 3033;
    public static final String CONTRCT_EXP_DT_INVALID_MSG  = "Invalid Contract Expiration Date";
    public static final int PAYOR_DT_EFF_DT_INVALID  = 3034;
    public static final String PAYOR_DT_EFF_DT_INVALID_MSG  = "Invalid Payor Effective Date";
    public static final int INVALID_ADMINPHN  = 3045;
    public static final String INVALID_ADMINPHN_MSG  = "Invalid Phone Format.";
    public static final int INVALID_ADMINFAX  = 3046;
    public static final String INVALID_ADMINFAX_MSG  = "Invalid Fax Format.";
    public static final int PAYOR_DT_CONTRCT_IN_USE  = 3047;
    public static final String PAYOR_DT_CONTRCT_IN_USE_MSG  = "The Payor ID is already in use by another contract.";
    public static final int DELETED_CONTRCT  = 3055;
    public static final String DELETED_CONTRCT_MSG  = "This Contract has been Deleted.";
    public static final int END_DT_START_DT  = 3056;
    public static final String END_DT_START_DT_MSG  = "Effective Date must be less than Review Date and Exp Date.";
    public static final int REQUIRED_CONTRCT_END_DT  = 3057;
    public static final String REQUIRED_CONTRCT_END_DT_MSG  = "Contract End Date Required";
    public static final int PYR_CAP  = 3061;
    public static final String PYR_CAP_MSG  = "Only one payor allowed on contract when payor is capitated.";
    public static final int PYRCNTRCT_ZIP_INVALID  = 3063;
    public static final String PYRCNTRCT_ZIP_INVALID_MSG  = "Invalid Zip for payor contract admin address";
    public static final int PYRCNTRCT_ZIP_CONFLICT  = 3064;
    public static final String PYRCNTRCT_ZIP_CONFLICT_MSG  = "Payor Contract Admin Zip conflicts with the state entered";

    // Payor Demographics
    public static final int REQUIRED_PYR_GRP_ID  = 3034;
    public static final String REQUIRED_PYR_GRP_ID_MSG  = " Payor Group Required";
    public static final int  REQUIRED_PYR_NAME  = 3035;
    public static final String REQUIRED_PYR_NAME_MSG  = " Payor Name Required";
    public static final int REQUIRED_PYR_GRP_NAME  = 3036;
    public static final String REQUIRED_PYR_GRP_NAME_MSG  = " Payor Group Name Required";
    public static final int REQUIRED_PYR_EFFECTIVE_DATE  = 3037;
    public static final String REQUIRED_PYR_EFFECTIVE_DATE_MSG  = " Required Effective Date";
    public static final int REQUIRED_PYR_ADDR1  = 3038;
    public static final String REQUIRED_PYR_ADDR1_MSG  = " Payor Address 1 Required";
    public static final int REQUIRED_PYR_ZIP_ID  = 3039;
    public static final String REQUIRED_PYR_ZIP_ID_MSG  = " ZIP Code Required";
    public static final int INVALID_ZIP_ID  = 3040;
    public static final String INVALID_ZIP_ID_MSG  = " Invalid Zip Code";
    public static final int INVALID_PYR_PHN1  = 3041;
    public static final String INVALID_PYR_PHN1_MSG  = " Invalid Phone 1";
    public static final int INVALID_PYR_PHN2  = 3042;
    public static final String INVALID_PYR_PHN2_MSG  = " Invalid Phone 2";
    public static final int INVALID_PYR_FAX1  = 3043;
    public static final String INVALID_PYR_FAX1_MSG  = " Invalid Fax 1";
    public static final int INVALID_PYR_FAX2  = 3044;
    public static final String INVALID_PYR_FAX2_MSG  = " Invalid Fax 2";
    public static final int INVALID_PYR_NM  = 3065;
    public static final String INVALID_PYR_NM_MSG  = " Duplicate Payor Name Entered";
    public static final int INVALID_PYR_STATE  = 3066;
    public static final String INVALID_PYR_STATE_MSG  = "Payor zip code conflicts with the state entered";
    public static final int REQUIRED_PYR_XREF = 3067;
    public static final String REQUIRED_PYR_XREF_MSG  = "Payor Xref Type Required.";
    public static final int INVALID_PYR_REFUND_STATE  = 3068;
    public static final String INVALID_PYR_REFUND_STATE_MSG  = "Payor refund zip code conflicts with the state entered";
    public static final int INVALID_PYR_APPEAL_STATE  = 3069;
    public static final String INVALID_PYR_APPEAL_STATE_MSG  = "Appeal zip code conflicts with the state entered";
    public static final int INVALID_PYR_ABBREV  = 3079;
    public static final String INVALID_PYR_ABBREV_MSG  = "Duplicate Payor ID entered";
    public static final int INVALID_PYR_APPEAL_FAX =10500;
    public static final String INVALID_PYR_APPEAL_FAX_MSG  = "Invalid Appeal Fax";
    public static final int REQUIRED_PYR_APPEAL_FAX =10501;
    public static final String REQUIRED_PYR_APPEAL_FAX_MSG  = "Appeal Fax is Required";
    public static final int INVALID_PYR_ATTACH_STATE  = 10502;
    public static final String INVALID_PYR_ATTACH_STATE_MSG  = "Attachment zip code conflicts with the state entered";
    public static final int INVALID_PYR_ATTACH_FAX =10503;
    public static final String INVALID_PYR_ATTACH_FAX_MSG  = "Invalid Attachment Fax";
    public static final int REQUIRED_PYR_ATTACH_FAX =10504;
    public static final String REQUIRED_PYR_ATTACH_FAX_MSG  = "Attachment Fax is Required";
    public static final int REQUIRED_PYR_ATTACH_ADDRESS =10505;
    public static final String REQUIRED_PYR_ATTACH_ADDRESS_MSG  = "Attachment Address 1 is Required";
    public static final int REQUIRED_PYR_ATTACH_ZIP =10506;
    public static final String REQUIRED_PYR_ATTACH_ZIP_MSG  = "Attachment Zip is Required";
    public static final int FIELD_LENGTH_EXCEEDED_ATTACH_CITY =10507;
    public static final String FIELD_LENGTH_EXCEEDED_ATTACH_CITY_MSG  = "Field length exceeded maximum allowed length for Attachment City";
    public static final int INVALID_PYR_ATTACH_ZIP  = 10508;
    public static final String INVALID_PYR_ATTACH_ZIP_MSG  = "Invalid Attachment Zip Code";
    public static final int PYR_DEM_GRP_EXP_DT_BEFORE_EFF_DT = 10509;
    public static final String PYR_DEM_GRP_EXP_DT_BEFORE_EFF_DT_MSG = "Expiration date is before the effective date.";
    public static final int PYR_XREF_OVERLAP_DATE_RANGE = 10510;
    public static final String PYR_XREF_OVERLAP_DATE_RANGE_MSG = "Overlapping effective and expiration date range for a cross reference type.";
    public static final int INVALID_ADDRESS_OVERRIDE = 10511;
    public static final String INVALID_ADDRESS_OVERRIDE_MSG = "Invalid value for Address Override";
    public static final int INVALID_ADDRESS_OVERRIDE_STATE = 10512;
    public static final String INVALID_ADDRESS_OVERRIDE_STATE_MSG = "Invalid State";

    // ClnPhysAssgn
    public static final int REQUIRED_CLNPHYS_CLNID  = 3048;
    public static final String REQUIRED_CLNPHYS_CLNID_MSG  = "Client ID is required.";
    public static final int REQUIRED_CLNPHYS_EFFDT  = 3049;
    public static final String REQUIRED_CLNPHYS_EFFDT_MSG  = "Physician Effective Date is required.";
    public static final int REQUIRED_CLNPHYS_UPIN  = 3050;
    public static final String REQUIRED_CLNPHYS_UPIN_MSG  = "Physician is required.";
    public static final int INVALID_CLNPHYS_CLNID  = 3051;
    public static final String INVALID_CLNPHYS_CLNID_MSG  = "Client not on file.";
    public static final int INVALID_CLNPHYS  = 3052;
    public static final String INVALID_CLNPHYS_MSG  = "Physician not on file.";
    public static final int INVALID_CLNPHYS_UPINID_INACTIVE  = 3053;
    public static final String INVALID_CLNPHYS_UPINID_INACTIVE_MSG  = "Physician marked as inactive.";
    public static final int DUP_CLNPHYS  = 3055;
    public static final String DUP_CLNPHYS_MSG  = "Duplicate Physician ID.";
    public static final int INVALID_CLNPHYS_CPYCLNID  = 3059;
    public static final String INVALID_CLNPHYS_CPYCLNID_MSG  = "Copy of Upin Client Assignments to selected Client Id not on file.";
    public static final int INVALID_CLNPHYS_SELECTED_CLNID  = 3060;
    public static final String INVALID_CLNPHYS_SELECTED_CLNID_MSG  = "Invalid Copy Client Id selection. Client Id is the same as Copy Client ID.";

    // 3055-3056 & 3061-3070 TAKEN BY PYRCONTRCTCONFIG
    public static final int INVALID_PYRCNTRCT_PHN  = 3070;
    public static final String INVALID_PYRCNTRCT_PHN_MSG  = " Invalid Payor Contract Admin Phone";
    public static final int INVALID_PYRCNTRCT_FAX  = 3076;
    public static final String INVALID_PYRCNTRCT_FAX_MSG  = " Invalid Payor Contract Admin Fax";

    // ERROR NUMBERS 3048-3060 ARE RESERVED FOR clnPhysAssgn.jsp.

    //EP Search Errs
    public static final int EP_SRCHID = 1301;
    public static final String EP_SRCHID_MSG = "Search ID not entered.";
    public static final int EP_DESC = 1302;
    public static final String EP_DESC_MSG = "Description not entered.";
    public static final int EP_FILTER = 1303;
    public static final String EP_FILTER_MSG = "Filter not entered.";
    public static final int EP_SQL = 1304;
    public static final String EP_SQL_MSG = "SQL error:  Contact System Admin.";
    public static final int EP_NONE_SELECTED = 1305;
    public static final String EP_NONE_SELECTED_MSG = "No "+accession+"s eligible for that action were selected";
    public static final int EP_BAD_VALUE = 1306;
    public static final String EP_BAD_VALUE_MSG = "A blank or invalid value was entered for Filter ";
    public static final int    EP_INVALID_DT_RANGE = 1307;
    public static final String EP_INVALID_DT_RANGE_MSG = "Invalid date range.";
    public static final int    EP_INVALID_FROM_DT = 1308;
    public static final String EP_INVALID_FROM_DT_MSG = "Invalid From Date.";
    public static final int    EP_INVALID_THRU_DT = 1309;
    public static final String EP_INVALID_THRU_DT_MSG = "Invalid Thru Date.";
    public static final int    EP_CORRESP_ERR = 1310;
    public static final String EP_CORRESP_ERR_MSG = "An error occurred releasing to correspondence.";
    public static final int    EP_SRCH_TIMEOUT = 1311;
    public static final String EP_SRCH_TIMEOUT_MSG = "Query timed out.  Please refactor query with more selective criteria.";
    public static final int    EP_SRCH_PDF = 1312;
    public static final String EP_SRCH_PDF_MSG = "Exception ocurred creating PDF.";
    public static final int    EP_SRCH_NO_ASSIGNEE = 1313;
    public static final String EP_SRCH_NO_ASSIGNEE_MSG = "Assignee not entered.";
    public static final int    EP_SRCH_FETCH_ERROR = 1350;
    public static final String EP_SRCH_FETCH_ERROR_MSG = "A Transaction Problem has Occurred. " +
            "Please contact Customer Service and provide the date and time the exception occurred.";
    public static final int EP_SRCH_MAX_ALLOWED_ACTIONS = 1352;
    public static final String EP_SRCH_MAX_ALLOWED_ACTIONS_MSG = "Reached the maximum allowed number of concurrent search actions. Please allow time for existing actions to complete and try again.";

    public static final int SRCH_NO_ACCESSIONS = 1362;
    public static final String SRCH_NO_ACCESSIONS_MSG = "No accessions with acceptable status for this action were found";

    // RsnCdConfiguration Errors

    public static final int EP_ERR_GRP = 1314;
    public static final String EP_ERR_GRP_MSG = "Error Group Required.";

    public static final int EP_DNL_TBL_ID = 1315;
    public static final String EP_DNL_TBL_ID_MSG = "Reason Code Table ID required.";

    public static final int EP_EFF_DT = 1316;
    public static final String EP_EFF_DT_MSG = "EP Effective Date Required.";

    public static final int EP_DOS_EFF_DT = 1317;
    public static final String EP_DOS_EFF_DT_MSG = "EP DOS Effective Date Required.";

    public static final int EP_DOS_EFF_DT_INVALID = 1318;
    public static final String EP_DOS_EFF_DT_INVALID_MSG = "EP DOS Effective Date Required DOS Can't be Greater Than EFFDT.";

    public static final int EP_DOS_EFF_DT_INVALID_FORMAT = 1319;
    public static final String EP_DOS_EFF_DT_INVALID_FORMAT_MSG = "EP DOS Effective Invalid Format.";

    public static final int EP_EFF_DT_INVALID_FORMAT = 1320;
    public static final String EP_EFF_DT_INVALID_FORMAT_MSG = "EP Effective Invalid Format.";

    public static final int EP_ERR_TYP = 1321;
    public static final String EP_ERR_TYP_MSG = "Error Type Required.";

    public static final int EP_SHORT_DESCR = 1322;
    public static final String EP_SHORT_DESCR_MSG = "Name Required.";

    public static final int EP_DTL_DESCR = 1323;
    public static final String EP_DTL_DESCR_MSG = "Detail Description Required.";

    public static final int EP_ABN_FNL_ACTN = 1324;
    public static final String EP_ABN_FNL_ACTN_MSG = " ABN signed Final Action Required.";

    public static final int EP_ABN_FNL_ACTN_ADJCD = 1325;
    public static final String EP_ABN_FNL_ACTN_ADJCD_MSG = " ABN signed Adjustment Code  Required.";

    public static final int EP_LTR_TXT = 1326;
    public static final String EP_LTR_TXT_MSG =  "LTR TXT  Required.";

    public static final int EP_FNL_ACTN_ADJCD = 1327;
    public static final String EP_FNL_ACTN_ADJCD_MSG = " Final Action Adjustment Code  Required.";

    public static final int EP_FNL_ACTN_PYR_ABBREV = 1360;
    public static final String EP_FNL_ACTN_PYR_ABBREV_MSG = " Final Action Payor ID is Required ";


    public static final int EP_FNL_ACTN_PYR_ABBREV_INVALID = 1361;
    public static final String EP_FNL_ACTN_PYR_ABBREV_INVALID_MSG = " Payor Abbrev Selected for Final Action is Invalid ";

    public static final int EP_FLD_DNL_LVL_ERR =	1346;
    public static final String EP_FLD_DNL_LVL_ERR_MSG = "Denial Level selection is required.";

    public static final int EP_RSN_CD_REQUIRED = 1351;
    public static final String EP_RSN_CD_REQUIRED_MSG = " Reason Code Required.";

    public static final int EP_ERR_LVL = 1359;
    public static final String EP_ERR_LVL_MSG = " Error Level needs to be selected.";


    public static final int EP_PYR_ID = 1328;
    public static final String EP_PYR_ID_MSG = " Valid Payor required.";

    public static final int EP_PROC_CD = 1329;
    public static final String EP_PROC_CD_MSG = " Invalid Proc Code ";

    public static final int EP_PT_DOC_CD = 1330;
    public static final String EP_PT_DOC_CD_MSG = " Invalid Patient Doc Code.";

    public static final int EP_CLN_DOC_CD = 1331;
    public static final String EP_CLN_DOC_CD_MSG = " Invalid Client Doc Code.";

    public static final int EP_DELETE = 1332;
    public static final String EP_DELETE_MSG = "Can't Delete Error Code.";

    public static final int EP_NEW_ERRCD = 1333;
    public static final String EP_NEW_ERRCD_MSG = "Can't Create New Error Code.";

    public static final int EP_DOS_UPDATE = 1334;
    public static final String EP_DOS_UPDATE_MSG = "Can't Update the DOS ";

    public static final int EP_ABN_FNL_ACTN_ADJCD_INVALID = 1335;
    public static final String EP_ABN_FNL_ACTN_ADJCD_INVALID_MSG = " Can't select Adjustment Code for this Action.(Only for WRITE OFF)";

    public static final int EP_FNL_ACTN_ADJCD_INVALID = 1336;
    public static final String EP_FNL_ACTN_ADJCD_INVALID_MSG = " Can't Select Final Action Adjustment Code  for this Action(Only for WRITE OFF).";

    public static final int EP_NO_ACTION_AND_OVRRDES = 1337;
    public static final String EP_NO_ACTION_AND_OVRRDES_MSG = "Can't Have Overrides for No Action (Check No Action & Delete Overrides vice versa) ";

    public static final int EP_FNL_ACTN = 1338;
    public static final String EP_FNL_ACTN_MSG = " Final Action  Required.";

    public static final int EP_NO_DNL_TBL_ID = 1339;
    public static final String EP_NO_DNL_TBL_ID_MSG = " Reason Code Table does not exist.";

    public static final int EP_DNL_TBL_ID_DESCR = 1340;
    public static final String EP_DNL_TBL_ID_DESCR_MSG = "Reason Code Table Description Required.";

    public static final int EP_DEMGRPC_FLD = 1341;
    public static final String EP_DEMGRPC_FLD_MSG = " Can't select Auto Match and Match Compare for non Demographic data.";

    public static final int EP_USER_ID = 1342;
    public static final String EP_USER_ID_MSG = " Authorized by Required .";

    public static final int EP_PROC_CD_ERR = 1343;
    public static final String EP_PROC_CD_ERR_MSG = " Procedure Code level radio button must be selected to activate procedure code override selection .";

    public static final int EP_PT_META_DATA_ERR =	1344;
    public static final String EP_PT_META_DATA_ERR_MSG = " Unable to send patient letter for medical data.";

    public static final int EP_FLD_DNL_ERR =	1345;
    public static final String EP_FLD_DNL_ERR_MSG = "Field selected requires a procedure denial level.";

    public static final int EP_FLD_COLLECTION_ERR = 1346;
    public static final String EP_FLD_COLLECTION_ERR_MSG = "Final Action Collections Submission Service is Required";

    public static final int EP_OVERRIDE_LTR_TXT = 1347;
    public static final String EP_OVERRIDE_LTR_TXT_MSG =  "Letter text required for correspondence type";

    public static final int EP_OVERRIDE_ADJ_CD = 1348;
    public static final String EP_OVERRIDE_ADJ_CD_MSG =  "Valid adjustment code required for override with final action write-off";

    public static final int EP_OVERRIDE_ID_REQ = 1349;
    public static final String EP_OVERRIDE_ID_REQ_MSG = "ID required";

    public static final int EP_OVERRIDE_TYP_REQ = 13491;
    public static final String EP_OVERRIDE_TYP_REQ_MSG = "Override Type required";

    public static final int EP_OVERRIDE_ID = 13492;
    public static final String EP_OVERRIDE_ID_MSG = "Invalid ID";

    public static final int EP_OVERRIDE_FLD_COLLECTION_ERR =	1351;
    public static final String EP_OVERRIDE_FLD_COLLECTION_ERR_MSG = "Submission service is required for override with final action collections";

    public static final int EP_OVERRIDE_CONVERT = 1353;
    public static final String EP_OVERRIDE_CONVERT_MSG =  "Correspondence type required for override with final action convert";

    public static final int EP_OVERRIDE_PROC_CD = 1355;
    public static final String EP_OVERRIDE_PROC_CD_MSG = "Invalid proc code for override";

    public static final int EP_OVERRIDE_DEMGRPC_FLD = 1356;
    public static final String EP_OVERRIDE_DEMGRPC_FLD_MSG = " Can't select Auto Match and Match Compare for non Demographic data for override";

    public static final int EP_RSN_CD_REQUIRED_APPEAL_ERRCD_FLD = 1357;
    public static final String EP_RSN_CD_REQUIRED_APPEAL_ERRCD_FLD_MSG = "Appeal Override Code is required for Appeal Letter";

    public static final int EP_NOT_UPDATEABLE = 1358;
    public static final String EP_NOT_UPDATEABLE_MSG = " Error Code is not Updateable.";

    public static final int FLWUP_DAYS_FLWUP_CODE_REQUIRED = 1363;
    public static final String FLWUP_DAYS_FLWUP_CODE_REQUIRED_MSG = " Follow-up Days and Follow-up Code are required.";

    //EP Match Compare RESERVED 3071-3090
    public static final int EP_MTCH_CMP_PSTPN = 3071;
    public static final String EP_MTCH_CMP_PSTPN_MSG = " There must be comments for a Postpone action.";
    public static final int EP_MTCH_CMP_DCLN = 3072;
    public static final String EP_MTCH_CMP_DCLN_MSG = " There must be comments for a Decline action.";
    public static final int EP_MTCH_CMP_CHCKD = 3073;
    public static final String EP_MTCH_CMP_CHCKD_MSG = " At least one check box must be checked.";
    public static final int EP_MTCH_CMP_ACTN = 3074;
    public static final String EP_MTCH_CMP_ACTN_MSG = " At least one action (Accept, Decline,...) must be selected.";
    public static final int EP_MTCH_CMP_NO_MTCH = 3075;
    public static final String EP_MTCH_CMP_NO_MTCH_MSG = " No Matches for this "+Accession+".";
    //EP Match Compare RESERVED 3071-3090

    //Manual Pricing Release 3091 - 3099
    public static final int MPR_INVALID_START_DT = 3091;
    public static final String MPR_INVALID_START_DT_MSG = "Invalid start date was entered. Enter a valid start date.";
    public static final int MPR_INVALID_END_DT = 3092;
    public static final String MPR_INVALID_END_DT_MSG = "Invalid end date was entered. Enter a valid end date.";
    public static final int MPR_SUBMIT_ERROR = 3093;
    public static final String MPR_SUBMIT_ERROR_MSG = "Error while submitting data. Could not release date ";
    public static final int MPR_LOAD_DATA_ERROR = 3094;
    public static final String MPR_LOAD_DATA_ERROR_MSG = "Error occurred and pending "+accession+" data could not loaded.";
    //Manual Pricing Release 3091 - 3099

    // Payor Dialysis Frequency Control Screen 3100 - 3199
    public static final int DFC_CTRL_ID_RQD = 3100;
    public static final String DFC_CTRL_ID_RQD_MSG = "Dialysis Frequency Control ID was missing. An ID must be entered.";
    public static final int DFC_CTRL_ID_NTFND = 3101;
    public static final String DFC_CTRL_ID_NTFND_MSG = "Dialysis Frequency Control Table not found";
    public static final int DFC_CTRL_ID_ABBRV_MSNG = 3103;
    public static final String DFC_CTRL_ID_ABBRV_MSNG_MSG = "Dialysis frequency control abbrev. missing.";
    public static final int DFC_CTRL_ID_DESC_MSNG = 3103;
    public static final String DFC_CTRL_ID_DESC_MSNG_MSG = "Dialysis frequency control description missing.";
    public static final int DFC_DUP_PYR = 3104;
    public static final String DFC_DUP_PYR_MSG = "Invalid Duplicate Payor Record.";
    public static final int DFC_INV_PYR_ID = 3105;
    public static final String DFC_INV_PYR_ID_MSG = "Invalid Payor ID.";
    public static final int DFC_INV_PYR_EFFDT = 3106;
    public static final String DFC_INV_PYR_EFFDT_MSG = "Invalid Payor Effective Date";
    public static final int DFC_INV_PYR_DFC_BASIS_TYPE = 3107;
    public static final String DFC_INV_PYR_DFC_BASIS_TYPE_MSG = "Invalid Payor Dialysis Frequency Basis Type";
    public static final int DFC_INV_PYR_DFC_DUP_PYR = 3108;
    public static final String DFC_INV_PYR_DFC_DUP_PYR_MSG = "Invalid Duplicate Payor Group Record";
    public static final int DFC_INV_PYR_GRP_ID = 3109;
    public static final String DFC_INV_PYR_GRP_ID_MSG = "Invalid Payor Group ID.";
    public static final int DFC_INV_PYR_GRP_EFFDT = 3110;
    public static final String DFC_INV_PYR_GRP_EFFDT_MSG = "Invalid Payor Group Effective Date";
    public static final int DFC_DUP_DFC_PROC = 3111;
    public static final String DFC_DUP_DFC_PROC_MSG = "Invalid duplicate dialysis frequency control requirement.";
    public static final int DFC_INV_DIAL_TYPE = 3112;
    public static final String DFC_INV_DIAL_TYPE_MSG = "Invalid dialysis type.";
    public static final int DFC_INV_PROC_CD = 3113;
    public static final String DFC_INV_PROC_CD_MSG = "Invalid Proc Code.";
    public static final int DFC_INV_DIAL_FREQ_TYP = 3114;
    public static final String DFC_INV_DIAL_FREQ_TYP_MSG = "Invalid Dialysis Frequency Type.";
    public static final int DFC_NUM_SVCS_ZERO = 3115;
    public static final String DFC_NUM_SVCS_ZERO_MSG = "Invalid Number of Services.";
    public static final int DFC_INV_MED_TYP = 3116;
    public static final String DFC_INV_MED_TYP_MSG = "Invalid Prescribed Medication Type.";
    public static final int DFC_INV_COMP_NONCOMP = 3117;
    public static final String DFC_INV_COMP_NONCOMP_MSG = "Invalid Composite/Non-Composite selection.";
    public static final int DFC_INV_PYR_GRP_SEQ = 3118;
    public static final String DFC_INV_PYR_GRP_SEQ_MSG = "Invalid Payor Group Sequence ID.";
    public static final int DFC_INV_PYR_SEQ = 3119;
    public static final String DFC_INV_PYR_SEQ_MSG = "Invalid Payor Sequence ID.";
    public static final int DFC_INV_DFC_REQ_SEQ = 3120;
    public static final String DFC_INV_DFC_REQ_SEQ_MSG = "Invalid Dialysis Frequency Proc Sequence ID.";
    public static final int DFC_DUP_PYR_GRP = 3121;
    public static final String DFC_DUP_PYR_GRP_MSG = "Invalid Duplicate Payor Group Record.";
    public static final int DFC_CPY_FAILED_NOTFND = 3122;
    public static final String DFC_CPY_FAILED_NOTFND_MSG = "Copy failed: Original record not found.";
    public static final int DFC_CPY_FAILED_ID_USED = 3123;
    public static final String DFC_CPY_FAILED_ID_USED_MSG = "Copy failed: ID already in use.";
    public static final int DFC_REQ_MSNG = 3124;
    public static final String DFC_REQ_MSNG_MSG = "No Requirements data entered.";
    public static final int DFC_PYR_MSNG = 3125;
    public static final String DFC_PYR_MSNG_MSG = "No Payor Group or Payor data entered.";
    public static final int DFC_CANT_DELETE_MEDICARE_TABLE = 3126;
    public static final String DFC_CANT_DELETE_MEDICARE_TABLE_MSG = "Invalid Action - You can't delete Medicare's DFC Table.";
    public static final int DFC_CANT_DELETE_MEDICARE_ASSGN = 3127;
    public static final String DFC_CANT_DELETE_MEDICARE_ASSGN_MSG = "Invalid Action - You can't delete Medicare's Assignment to this DFC Table.";

    //   3200 - 3299: Payor Contact Manager Screen
    public static final int PCM_MISSING_USERID = 3200;
    public static final String PCM_MISSING_USERID_MSG = "User-Id missing from contact record.";
    public static final int PCM_INVALID_CNTCT_DT = 3201;
    public static final String PCM_INVALID_CNTCT_DT_MSG = "Invalid contact date was entered.\nEnter a valid contact date";
    public static final int PCM_MISSING_CNTCT_INFO = 3202;
    public static final String PCM_MISSING_CNTCT_INFO_MSG = "Contact information cannot be empty.";
    public static final int PCM_INVALID_FLWUP_DT = 3203;
    public static final String PCM_INVALID_FLWUP_DT_MSG = "Invalid follow up date was entered.\nEnter a valid follow up date";
    public static final int PCM_INVALID_FLWUP_COMPLETE = 3204;
    public static final String PCM_INVALID_FLWUP_COMPLETE_MSG = "Follow up complete value can only be true or false";
    public static final int PCM_INVALID_CONTACT_VOID = 3205;
    public static final String PCM_INVALID_CONTACT_VOID_MSG = "Contact void value can only be true or false";
    public static final int PCM_MISSING_CONTACT_RECS = 3206;
    public static final String PCM_MISSING_CONTACT_RECS_MSG = "No contact detail records specifed";
    public static final int PCM_INVALID_PAYOR = 3207;
    public static final String PCM_INVALID_PAYOR_MSG = "Invalid Payor specified";
    public static final int PCM_MISSING_FLWUP_USERID = 3208;
    public static final String PCM_MISSING_FLWUP_USERID_MSG = "Follow up userid is missing from the contact detail record.";
    public static final int PCM_NO_ROW_SELECTED = 3209;
    public static final String PCM_NO_ROW_SELECTED_MSG = "No contact note selected to copy to other payors.";
    public static final int PCM_INV_CPY_PAYOR = 3210;
    public static final String PCM_INV_CPY_PAYOR_MSG = "Invalid payor specified for note copy : ";
    public static final int PCM_NEW_ROW_SELECTED = 3211;
    public static final String PCM_NEW_ROW_SELECTED_MSG = "Cannot copy a new note to other payors : Please re-submit and save before copying to other payors.";
    public static final int PCM_INVALID_CHARS_IN_NOTES = 3212;
    public static final String PCM_INVALID_CHARS_IN_NOTES_MSG = "Invalid characters are not allowed.";
    public static final int PCM_INVALID_FLWUP_DT_FLWUP_USER = 3213;
    public static final String PCM_INVALID_FLWUP_DT_FLWUP_USER_MSG = "The follow-up date and follow-up user are both entered, or both blank.";
    public static final int PCM_UNABLE_UPDAT_OTHER_USER_NOTES = 3214;
    public static final String PCM_UNABLE_UPDAT_OTHER_USER_NOTES_MSG = "Cannot update another user's note.";
    public static final int PCM_USER_NO_ACTIVE_OR_SYS = 3215;
    public static final String PCM_USER_NO_ACTIVE_OR_SYS_MSG = "Follow-up person must be non-deleted and non-system user.";
    public static final int PCM_CONTACT_DT_EMPTY = 3216;
    public static final String PCM_CONTACT_DT_EMPTY_MSG = "Contact Date is required.";

    // 3300 - 3399: Client Billing Rules Screen.
    public static final int CBR_MISSING_CLNABBREV = 3300;
    public static final String CBR_MISSING_CLNABBREV_MSG = "Client Abbrev is not specified - Client record not found";
    public static final int CBR_CLN_NOTFND = 3301;
    public static final String CBR_CLN_NOTFND_MSG = "Client record not found";
    public static final int CBR_PYR_NOTFND = 3302;
    public static final String CBR_PYR_NOTFND_MSG = "Payor record not found";
    public static final int CBR_PYR_IE_INC_EXC_INV = 3303;
    public static final String CBR_PYR_IE_INC_EXC_INV_MSG = "Payor Inclusion/Exclusion option invalid";
    public static final int CBR_TST_NOTFND = 3304;
    public static final String CBR_TST_NOTFND_MSG = Test+" record not found";
    public static final int CBR_TST_TYP_NOTFND = 3305;
    public static final String CBR_TST_TYP_NOTFND_MSG = Test+" type not found";
    public static final int CBR_TST_IE_INC_EXC_INV = 3306;
    public static final String CBR_TST_IE_INC_EXC_INV_MSG = Test+" Inclusion/Exclusion option invalid";
    public static final int CBR_INV_BR_PT_TYP = 3307;
    public static final String CBR_INV_BR_PT_TYP_MSG = "Invalid patient type for billing rule : ";
    public static final int CBR_INV_BR_PRIO = 3308;
    public static final String CBR_INV_BR_PRIO_MSG = "Invalid priority for billing rule : ";
    public static final int CBR_INV_DOUBLE_IDS = 3309;
    public static final String CBR_INV_DOUBLE_IDS_MSG = "Bill Client ID and Bill Payor ID cannot be used simultaneously - Rule : ";
    public static final int CBR_INV_MISSING_IDS = 3310;
    public static final String CBR_INV_MISSING_IDS_MSG = "Either Bill Client ID or Bill Payor ID must be specified - Rule : ";
    public static final int CBR_DUP_BR_PRIO = 3311;
    public static final String CBR_DUP_BR_PRIO_MSG = "Duplicate priority found for billing rule : ";
    public static final int CBR_PYR_INC_EXC_NO_ID = 3312;
    public static final String CBR_PYR_INC_EXC_NO_ID_MSG = "No payor ID or group specified for payor inclusion/exclusion - Billing Rule : ";
    public static final int CBR_PYR_INC_EXC_INV_PYRGRP = 3313;
    public static final String CBR_PYR_INC_EXC_INV_PYRGRP_MSG = "Invalid payor group specified for payor inclusion/exclusion - Billing Rule : ";
    public static final int CBR_PYR_NOTFND_PYR_INCEXC = 3314;
    public static final String CBR_PYR_NOTFND_PYR_INCEXC_MSG = "Payor record not found for payor inclusion/exclusion - Billing Rule : ";
    public static final int CBR_PYR_NOTFND_BILL_PYR = 3315;
    public static final String CBR_PYR_NOTFND_BILL_PYR_MSG = "Bill Payor record not found for billing rule : ";
    public static final int CBR_CLN_NOTFND_BILL_CLN = 3316;
    public static final String CBR_CLN_NOTFND_BILL_CLN_MSG = "Bill Client record not found for billing rule :";
    public static final int CBR_INV_INC_EXC_DELETE_OPT = 3317;
    public static final String CBR_INV_INC_EXC_DELETE_OPT_MSG = "Invalid delete option found for billing rule :";
    public static final int CBR_TST_NOTFND_INCEXC = 3318;
    public static final String CBR_TST_NOTFND_INCEXC_MSG = Test+" record not found for test inclusion/exclusion - Billing Rule : ";
    public static final int CBR_TST_TYP_NOTFND_INCEXC = 3319;
    public static final String CBR_TST_TYP_NOTFND_INCEXC_MSG = Test+" type not found for "+test+" inclusion/exclusion - Billing Rule : ";
    public static final int CBR_TST_TYP_INCEXC_NO_ID = 3320;
    public static final String CBR_TST_TYP_INCEXC_NO_ID_MSG = "No "+Test+" type or "+test+" ID specified - Billing Rule : ";
    public static final int CBR_TST_TYP_INCEXC_EXTRA_ID = 3321;
    public static final String CBR_TST_TYP_INCEXC_EXTRA_ID_MSG = Test+" type and "+test+" ID cannot be used simultaneously - Billing Rule : ";
    public static final int CBR_PYR_INCEXC_EXTRA_ID = 3322;
    public static final String CBR_PYR_INCEXC_EXTRA_ID_MSG = "Payor Group and Payor Abbrev cannot be used simultaneously - Billing Rule : ";
    public static final int CBR_PYR_DUP_PYRGRP = 3323;
    public static final String CBR_PYR_DUP_PYRGRP_MSG = "Duplicate inclusion/exclusion payor group found - Billing Rule : ";
    public static final int CBR_PYR_REC_NOTFND_EPR_PYR = 3324;
    public static final String CBR_PYR_REC_NOTFND_EPR_PYR_MSG = "Payor record not found for Payor "+Test+" EP Rule : ";
    public static final int CBR_PYR_GRP_INV_EPR = 3325;
    public static final String CBR_PYR_GRP_INV_EPR_MSG = "Invalid Payor Group ID for Payor "+Test+" EP Rule : ";
    public static final int CBR_PYR_PYRGRP_DUP = 3326;
    public static final String CBR_PYR_PYRGRP_DUP_MSG = "Cannot use BOTH Payor ID and Payor Group Identification for Payor "+Test+" EP Rule : ";
    public static final int CBR_PYR_PYRGRP_MISS = 3327;
    public static final String CBR_PYR_PYRGRP_MISS_MSG = "Payor ID or Payor Group Identification missing for Payor "+Test+" EP Rule : ";
    public static final int CBR_INV_ALLOW_PARM = 3328;
    public static final String CBR_INV_ALLOW_PARM_MSG = "Invalid Allow option specified for an Payor "+Test+" EP Rule : ";
    public static final int CBR_TEST_NOTFND_EPR = 3330;
    public static final String CBR_TEST_NOTFND_EPR_MSG = Test+" not found for Allow option specified in Payor "+Test+" EP Rule : ";
    public static final int CBR_INV_TESTTYP_EPR = 3331;
    public static final String CBR_INV_TESTTYP_EPR_MSG = "Invalid "+Test+" Type found for Allow option specified in Payor "+Test+" EP Rule : ";
    public static final int CBR_TEST_TESTTYP_MISSING = 3332;
    public static final String CBR_TEST_TESTTYP_MISSING_MSG = Test+" Type and "+Test+" ID missing for Payor "+Test+" EP Rule : ";
    public static final int CBR_TEST_TESTTYP_DUP = 3333;
    public static final String CBR_TEST_TESTTYP_DUP_MSG = "Cannot use BOTH "+Test+" Type and "+Test+" ID for Payor "+Test+" EP Rule : ";
    public static final int CBR_EPR_MISSING_PYRABBRV_EXC = 3334;
    public static final String CBR_EPR_MISSING_PYRABBRV_EXC_MSG = "Missing Payor Abbrev for payor exclusion for Payor "+Test+" EP Rule : ";
    public static final int CBR_EPR_INV_PYRGRP_EXC = 3335;
    public static final String CBR_EPR_INV_PYRGRP_EXC_MSG = "Invalid payor group for payor group exclusion for Payor "+Test+" EP Rule : ";
    public static final int CBR_EPR_NO_PYRGRP_EXC = 3336;
    public static final String CBR_EPR_NO_PYRGRP_EXC_MSG = "Missing payor group for payor group exclusion for Payor "+Test+" EP Rule : ";
    public static final int CBR_EPR_PYRGRP_EXC_DUP = 3337;
    public static final String CBR_EPR_PYRGRP_EXC_DUP_MSG = "Duplicate payor groups used in payor group exclusion for Payor "+Test+" EP Rule : ";
    public static final int CBR_CPY_CLN_NOTFND = 3338;
    public static final String CBR_CPY_CLN_NOTFND_MSG = "Copy source client record not found ";
    public static final int CBR_CPY_CLN_NORECS = 3339;
    public static final String CBR_CPY_CLN_NORECS_MSG = "Copy source client has no client billing rules to copy";
    public static final int CBR_SECURITY_BY_FACILITY_VIOLATION = 3340;
    public static final String CBR_SECURITY_BY_FACILITY_VIOLATION_MSG = "The client may not be viewed due to 'security by facility' restrictions";


    //Client Pricing Inquiry Error Codes 4000 - 4010
    public static final int CPI_MISSING_CLN_ID = 4000;
    public static final String CPI_MISSING_CLN_ID_MSG = "Client ID was missing. A client ID must be entered.";
    public static final int CPI_INVALID_CLN_ID = 4001;
    public static final String CPI_INVALID_CLN_ID_MSG = "An invalid client ID was entered.";
    public static final int CPI_MISSING_DOS = 4002;
    public static final String CPI_MISSING_DOS_MSG = "Date of service was missing. A date of service must be entered.";
    public static final int CPI_MISSING_TEST_ID = 4003;
    public static final String CPI_MISSING_TEST_ID_MSG = Test+" ID was missing. A "+test+" ID must be entered.";
    public static final int CPI_INVALID_TEST_ID = 4004;
    public static final String CPI_INVALID_TEST_ID_MSG = "An invalid "+test+" ID was entered.";
    public static final int CPI_INVALID_PYR_ID = 4005;
    public static final String CPI_INVALID_PYR_ID_MSG = "Payor ID entered was invalid.";
    public static final int CPI_PRICING_ERROR = 4006;
    public static final String CPI_PRICING_ERROR_MSG = "Pricing error occurred while processing request. Unable to obtain pricing information.";
    public static final int CPI_LOAD_ERROR = 4007;
    public static final String CPI_LOAD_ERROR_MSG = "Error occurred while loading data.";
    public static final int CPI_MISSING_FAC_ERROR = 4008;
    public static final String CPI_MISSING_FAC_ERROR_MSG = Test+" does not have facility setup.";
    public static final int CPI_NOT_EFFECTIVE_TEST_ERROR = 4009;
    public static final String CPI_NOT_EFFECTIVE_TEST_ERROR_MSG = Test+" is not effective for DOS.";
    public static final int CPI_MISSING_PROC_ERROR = 4010;
    public static final String CPI_MISSING_PROC_ERROR_MSG = Test+" does not have Proc Code setup.";

    //Client Pricing Inquiry Error Codes 4000 - 4010

    //Client Pricing Configuration Error Codes 2271 - 2295, 4011 - 4062, 7100 - 7199
    public static final int CPC_INVALID_PRIMARY_CLN_ID = 4011;
    public static final String CPC_INVALID_PRIMARY_CLN_ID_MSG = "Primary client ID was invalid.\nEnter a valid primary ID or leave blank if no primary client.";
    public static final int CPC_MISSING_EFF_DT_PRC_DTLS = 4012;
    public static final String CPC_MISSING_EFF_DT_PRC_DTLS_MSG = "Effective date was missing from price details.\nEnter a valid effective date.";
    public static final int CPC_INVALID_EFF_DT_PRC_DTLS = 4013;
    public static final String CPC_INVALID_EFF_DT_PRC_DTLS_MSG = "Invalid effective date was entered in price details.\nEnter a valid effective date.";
    public static final int CPC_MISSING_EFF_DT_SDRY_CLN = 4014;
    public static final String CPC_MISSING_EFF_DT_SDRY_CLN_MSG = "Effective date was missing from secondary client entry.\nEnter a valid effective date.";
    public static final int CPC_INVALID_EFF_DT_SDRY_CLN = 4015;
    public static final String CPC_INVALID_EFF_DT_SDRY_CLN_MSG = "Invalid effective date was entered in secondary client entry.\nEnter a valid effective date.";
    public static final int CPC_INVALID_SDRY_CLN_ID = 4016;
    public static final String CPC_INVALID_SDRY_CLN_ID_MSG = "Secondary client ID invalid.\nEnter a valid secondary client id.";
    public static final int CPC_INVALID_REC_CHRG_EFF_DT = 4017;
    public static final String CPC_INVALID_REC_CHRG_EFF_DT_MSG = "Invalid effective date entered for recurring charge.\nEnter a valid effective date.";
    public static final int CPC_MISSING_REC_CHRG_EFF_DT = 4018;
    public static final String CPC_MISSING_REC_CHRG_EFF_DT_MSG = "Missing effective date entered for recurring charge.\nEnter a valid effective date.";
    public static final int CPC_INVALID_REC_CHRG_EXP_DT = 4019;
    public static final String CPC_INVALID_REC_CHRG_EXP_DT_MSG = "Invalid expiration date entered for recurring charge.\nEnter a valid expiration date.";
    public static final int CPC_CONFLICTING_CLN_SPC_MEDICARE_PYR_ID = 4020;
    public static final String CPC_CONFLICTING_CLN_SPC_MEDICARE_PYR_ID_MSG = "Special Price Tables for client pricing can only be assigned to clients that share the same Medicare Payor Id.";
    public static final int CPC_CONFLICTING_NON_CLN_SPC_MEDICARE_PYR_ID = 4021;
    public static final String CPC_CONFLICTING_NON_CLN_SPC_MEDICARE_PYR_ID_MSG = "Special Price Tables for non-client pricing can only be assigned to clients that share the same Medicare Payor Id.";
    public static final int CPC_INVALID_LVL0_DISC = 4030;
    public static final String CPC_INVALID_LVL0_DISC_MSG =  "Pricing detail client max discount level 0 invalid. Enter a number between 0 and 100.";
    public static final String CPC_INVALID_LVL0_DISC_MSG2 = "Pricing detail client max discount level 0 invalid. System setup for default limit on discounts implies 0 for level 0.";
    public static final int CPC_INVALID_LVL1_DISC = 4031;
    public static final String CPC_INVALID_LVL1_DISC_MSG = "Pricing detail invalid "+test+" level 1 discount. Enter a valid number between 0 and ";
    public static final int CPC_INVALID_LVL2_DISC = 4032;
    public static final String CPC_INVALID_LVL2_DISC_MSG = "Pricing detail invalid "+test+" level 2 discount. Enter a valid number between 0 and ";
    public static final int CPC_INVALID_LVL3_DISC = 4033;
    public static final String CPC_INVALID_LVL3_DISC_MSG = "Pricing detail invalid "+test+" level 3 discount. Enter a valid number between 0 and ";
    public static final int CPC_INVALID_LVL4_DISC = 4034;
    public static final String CPC_INVALID_LVL4_DISC_MSG = "Pricing detail invalid "+test+" level 4 discount. Enter a valid number between 0 and ";
    public static final int CPC_INVALID_LVL5_DISC = 4035;
    public static final String CPC_INVALID_LVL5_DISC_MSG = "Pricing detail invalid "+test+" level 5 discount. Enter a valid number between 0 and ";
    public static final int CPC_INVALID_LVL6_DISC = 4036;
    public static final String CPC_INVALID_LVL6_DISC_MSG = "Pricing detail invalid "+test+" level 6 discount. Enter a valid number between 0 and ";
    public static final int CPC_INVALID_LVL7_DISC = 4037;
    public static final String CPC_INVALID_LVL7_DISC_MSG = "Pricing detail invalid "+test+" level 7 discount. Enter a valid number between 0 and ";
    public static final int CPC_INVALID_LVL8_DISC = 4038;
    public static final String CPC_INVALID_LVL8_DISC_MSG = "Pricing detail invalid "+test+" level 8 discount. Enter a valid number between 0 and ";
    public static final int CPC_INVALID_LVL9_DISC = 4039;
    public static final String CPC_INVALID_LVL9_DISC_MSG = "Pricing detail invalid "+test+" level 9 discount. Enter a valid number between 0 and ";
    public static final int CPC_INVALID_CLN_RTLFS = 4040;
    public static final String CPC_INVALID_CLN_RTLFS_MSG = "Missing client retail fee schedule.";
    public static final int CPC_INVALID_CLN_FS = 4041;
    public static final String CPC_INVALID_CLN_FS_MSG = "Invalid client fee schedule.";
    public static final int CPC_INVALID_NONCLN_RTLFS = 4042;
    public static final String CPC_INVALID_NONCLN_RTLFS_MSG = "Invalid non-client retail fee schedule.";
    public static final int CPC_INVALID_NONCLN_FS = 4043;
    public static final String CPC_INVALID_NONCLN_FS_MSG = "Invalid non-client fee schedule.";
    public static final int CPC_INVALID_CLN_SPC_PRCTBL = 4044;
    public static final String CPC_INVALID_CLN_SPC_PRCTBL_MSG = "Invalid client special price table ID entered.";
    public static final int CPC_INVALID_CLN_SPC_PCTDISC = 4045;
    public static final String CPC_INVALID_CLN_SPC_PCTDISC_MSG = "Invalid client discount percentage entered.";
    public static final int CPC_INVALID_NONCLN_SPC_PRCTBL = 4046;
    public static final String CPC_INVALID_NONCLN_SPC_PRCTBL_MSG = "Invalid non-client special price table ID entered.";
    public static final int CPC_INVALID_NONCLN_SPC_PCTDISC = 4047;
    public static final String CPC_INVALID_NONCLN_SPC_PCTDISC_MSG = "Invalid non-client discount percentage entered.";
    public static final int CPC_SUBMIT_ERROR = 4048;
    public static final String CPC_SUBMIT_ERROR_MSG = "Unable to save data. Exception occurred: ";
    public static final int CPC_SDRY_CLN_ALREADY_PRMY_CLN = 4049;
    public static final String CPC_SDRY_CLN_ALREADY_PRMY_CLN_MSG = "Secondary client selected cannot be assigned. Cannot assign another primary client as a secondary client. ";
    public static final int CPC_SDRY_CLN_ALREADY_SDRY_CLN = 4050;
    public static final String CPC_SDRY_CLN_ALREADY_SDRY_CLN_MSG = "Secondary client selected cannot be assigned. Secondary client selected is already assigned to this primary client. ";
    public static final int CPC_SDRY_CLN_OTHER_SDRY_CLN = 4051;
    public static final String CPC_SDRY_CLN_OTHER_SDRY_CLN_MSG = "Secondary client selected cannot be assigned. Secondary client selected is already assigned to another primary client. ";
    public static final int CPC_SDRY_CLN_DT_WARNING = 4052;
    public static final String CPC_SDRY_CLN_DT_WARNING_MSG = "The effective dates for secondary clients must be the first of the month. The date entered was set to the first of next month.";
    public static final int CPC_RC_INVALID_ADJ_CODE = 4053;
    public static final String CPC_RC_INVALID_ADJ_CODE_MSG = "The adjustment code for recurring charge was missing or invalid.";
    public static final int CPC_RC_INVALID_BIL_FREQ = 4054;
    public static final String CPC_RC_INVALID_BIL_FREQ_MSG = "The billing frequency for recurring charge was missing or invalid.";
    public static final int CPC_RC_INVALID_CHRG = 4055;
    public static final String CPC_RC_INVALID_CHRG_MSG = "Charge amount for recurring charge was invalid or not indicated.";
    public static final int CPC_XACTION_ROLLBACK_FATAL_ERROR = 4056;
    public static final String CPC_XACTION_ROLLBACK_FATAL_ERROR_MSG = "Fatal error while attempting to rollback transaction. Contact your system administrator.";
    public static final int CPC_XACTION_ROLLBACK = 4057;
    public static final String CPC_XACTION_ROLLBACK_MSG = "Submit aborted. Transaction rolled back to due to exception. ";
    public static final int CPC_REC_CHRG_EFF_DT_MISMATCH = 4058;
    public static final String CPC_REC_CHRG_EFF_DT_MISMATCH_MSG = "Expiration date for recurring charge must be after effective date.";
    public static final int CPC_INVALID_STMT_FREQ = 4059;
    public static final String CPC_INVALID_STMT_FREQ_MSG = "Statement frequency not selected. Select a statement frequency.";
    public static final int CPC_SDRY_CLN_EXP_DT_WARNING = 4060;
    public static final String CPC_SDRY_CLN_EXP_DT_WARNING_MSG = "Expiration date of secondary client must be the last day of the month.  The date entered was set to the last day of the month.";
    public static final int CPC_INVALID_CLN_EXP_PRCTBL = 4061;
    public static final String CPC_INVALID_CLN_EXP_PRCTBL_MSG = "Invalid client expect price table ID entered.";
    public static final int CPC_SDRY_CLN_EXP_DT_IN_PRIOR_MONTH = 4062;
    public static final String CPC_SDRY_CLN_EXP_DT_IN_PRIOR_MONTH_MSG = "Secondary client's expiration date cannot be in a previous month.  The date was set to the last day of the current month or the month of the effective date.";
    public static final int CPC_INVALID_CLN_INCR_TBL = 4089;
    public static final String CPC_INVALID_CLN_INCR_TBL_MSG = "Invalid client Incr Tbl entry.";

    public static final int CPC_RC_ACCN_INVALID_TEST_ID = 4090;
    public static final String CPC_RC_ACCN_INVALID_TEST_ID_MSG = "The Test ID for recurring charges on Accession was missing or invalid.";
    public static final int CPC_REC_CHRG_ACCN_EFF_DT_MISMATCH = 4091;
    public static final String CPC_REC_CHRG_ACCN_EFF_DT_MISMATCH_MSG = "Expiration date for recurring charge on Accession must be after effective date.";
    public static final int CPC_INVALID_REC_CHRG_ACCN_EFF_DT = 4092;
    public static final String CPC_INVALID_REC_CHRG_ACCN_EFF_DT_MSG = "Invalid effective date entered for recurring charge on Accession.\nEnter a valid effective date.";
    public static final int CPC_MISSING_REC_CHRG_ACCN_EFF_DT = 4093;
    public static final String CPC_MISSING_REC_CHRG_ACCN_EFF_DT_MSG = "Missing effective date entered for recurring charge on Accession.\nEnter a valid effective date.";
    public static final int CPC_INVALID_REC_CHRG_ACCN_EXP_DT = 4094;
    public static final String CPC_INVALID_REC_CHRG_ACCN_EXP_DT_MSG = "Invalid expiry date entered for recurring charge on Accession.\nEnter a valid effective date.";
    public static final int CPC_MISSING_REC_CHRG_ACCN_EXP_DT = 4095;
    public static final String CPC_MISSING_REC_CHRG_ACCN_EXP_DT_MSG = "Missing expiry date entered for recurring charge on Accession.\nEnter a valid effective date.";
    public static final int CPC_CRCA_OVERLAP_EFF_DT = 4096;
    public static final String CPC_CRCA_OVERLAP_EFF_DT_ERR_MSG = "Overlapping dates for period ? ? and ? ?. The date range for effective dates may not overlap.";
    public static final int CPC_CRCA_IDENTICAL_EFF_DTS = 4097;
    public static final String CPC_CRCA_IDENTICAL_EFF_DTS_ERR_MSG = "Identical effective dates. Effective dates need to be unique.";

    public static final int CPC_ROLL_BIMON_REC_CHRG_EFF_DT = 2271;
    public static final String CPC_ROLL_BIMON_REC_CHRG_EFF_DT_MSG = "Bi-Monthly recurring charges must be set to be effective on the 1st or the 16th of the month. The date entered was set to the 1st of month.";
    public static final int CPC_ROLL_MON_REC_CHRG_EFF_DT = 2272;
    public static final String CPC_ROLL_MON_REC_CHRG_EFF_DT_MSG = "Monthly recurring charges must be set to be effective on the 1st of the month. The date entered was set to the 1st of month.";
    public static final int CPC_ROLL_BIMON_REC_CHRG_EXP_DT = 2273;
    public static final String CPC_ROLL_BIMON_REC_CHRG_EXP_DT_MSG = "Bi-Monthly recurring charges must be set to expire on the 15th or the last day of the month. The date entered was set to the last day of month.";
    public static final int CPC_ROLL_MON_REC_CHRG_EXP_DT = 2274;
    public static final String CPC_ROLL_MON_REC_CHRG_EXP_DT_MSG = "Monthly recurring charges must be set to expire on the last day of the month. The date entered was set to the last day of month.";
    public static final int CPC_INVALID_REF_HNDL_TEST_ID = 2275;
    public static final String CPC_INVALID_REF_HNDL_TEST_ID_MSG = "Invalid "+test+" ID entered for referral handling "+test+" id.";
    public static final int CPC_INVALID_PRC_REF_AT_COST_PLUS = 2276;
    public static final String CPC_INVALID_PRC_REF_AT_COST_PLUS_MSG = "Invalid handling fee entered. A handling fee is required if 'Price Referrals at Cost +' option is selected.";
    public static final int CPC_INVALID_MAX_HNDL_FEE = 2277;
    public static final String CPC_INVALID_MAX_HNDL_FEE_MSG = "Invalid maximum handling fee entered. Enter a valid maximum handling fee in dollars and cents.";
    public static final int CPC_INVALID_MIN_HNDL_FEE = 2278;
    public static final String CPC_INVALID_MIN_HNDL_FEE_MSG = "Invalid minimum handling fee entered. Enter a valid minimum handling fee in dollars and cents.";
    public static final int CPC_INVALID_HNDL_PCT = 2279;
    public static final String CPC_INVALID_HNDL_PCT_MSG = "Invalid percent of fee entered for handling fees. Enter a valid number.";
    public static final int CPC_ERROR_LOADING_ACCT_TYP = 2280;
    public static final String CPC_ERROR_LOADING_ACCT_TYP_MSG = "Error occurred while attempting to load the client account type.";
    public static final int CPC_ERROR_LOADING_SUBCLN = 2281;
    public static final String CPC_ERROR_LOADING_SUBCLN_MSG = "Error occurred while attempting to load the secondary clients.";
    public static final int CPC_ERROR_LOADING_PRIMARY = 2282;
    public static final String CPC_ERROR_LOADING_PRIMARY_MSG = "Error occurred while attempting to load primary client.";
    public static final int CPC_ERROR_LOADING_REF_HNDL_TEST = 2283;
    public static final String CPC_ERROR_LOADING_REF_HNDL_TEST_MSG = "Error occurred while attempting to load the referral handling test.";
    public static final int CPC_ERROR_LOADING_PRC_DETAIL = 2284;
    public static final String CPC_ERROR_LOADING_PRC_DETAIL_MSG = "Error occurred while attempting to load the pricing detail records. \nThere must be at least one pricing detail record created when client demographics are setup.";
    public static final String CPC_ERROR_LOADING_PRC_DETAIL_MSG1 = "Error occurred while attempting to load the pricing detail records. \nUnable to obtaine database connection.";
    public static final int CPC_ERROR_LOADING_FEE_SCHED = 2285;
    public static final String CPC_ERROR_LOADING_FEE_SCHED_MSG = "Error occurred while attempting to load fee schedule.";
    public static final int CPC_ERROR_LOADING_SPC_PRC_TBL = 2285;
    public static final String CPC_ERROR_LOADING_SPC_PRC_TBL_MSG = "Error occurred while attempting to load special price table.";
    public static final int CPC_ERROR_LOADING_REC_CHRG = 2286;
    public static final String CPC_ERROR_LOADING_REC_CHRG_MSG = "Error occurred while attempting to load client charges.";
    public static final int CPC_PRC_DTL_BEFORE_CLN_EFF_DT = 2287;
    public static final String CPC_PRC_DTL_BEFORE_CLN_EFF_DT_MSG = "Pricing detail effective date cannot fall before the effective date of the client.";
    public static final int CPC_MAX_HNDL_FEE_LT_MIN_FEE = 2288;
    public static final String CPC_MAX_HNDL_FEE_LT_MIN_FEE_MSG = "Maximum handling fee must be greater than or equal to the minimum handling fee.";
    public static final int CPC_CANNOT_ENABLE_PRICING = 2289;
    public static final String CPC_CANNOT_ENABLE_PRICING_MSG = "A retail fee schedule and fee schedule must be selected before enabling pricing.";
    public static final int CPC_INVALID_RATE = 2290;
    public static final String CPC_INVALID_RATE_MSG = "An invalid per diem rate was entered.";
    public static final int CPC_INVALID_TYP = 2291;
    public static final String CPC_INVALID_TYP_MSG = "An invalid per diem type was entered.";
    public static final int CPC_PER_DIEM_RATE_TYP_REQ = 2292;
    public static final String CPC_PER_DIEM_RATE_TYP_REQ_MSG = "Per Diem type and rate are both required.";
    public static final int CPC_PRIC_REF_AT_COST = 2293;
    public static final String CPC_PRIC_REF_AT_COST_MSG = "Price referrals at cost checkbox must be selected.";
    public static final int CPC_SUBM_CONFIG_NOT_SETUP = 2294;
    public static final String CPC_SUBM_CONFIG_NOT_SETUP_MSG = "Client submission service and cycle must be specified first.";
    public static final int CPC_REC_CHRG_EFF_DT_INVALID_FOR_WKLY_FREQ = 2295;
    public static final String CPC_REC_CHRG_EFF_DT_INVALID_FOR_WKLY_FREQ_MSG = "Effective date of recurring charge is invalid for a weekly frequency.  Valid starting days are 1, 8, 16, or 23.  The date was set to the first of the month.";
    public static final int CPC_REC_CHRG_EFF_DT_INVALID_FOR_YEARLY_FREQ = 2296;
    public static final String CPC_REC_CHRG_EFF_DT_INVALID_FOR_YEARLY_FREQ_MSG = "Yearly recurring charges must be set to be effective on the 1st of the month. The date entered was set to the 1st of month.";
    public static final int CPC_REC_CHRG_EXP_DT_INVALID_FOR_YEARLY_FREQ = 2297;
    public static final String CPC_REC_CHRG_EXP_DT_INVALID_FOR_YEARLY_FREQ_MSG = "Yearly recurring charges must be set to expire on the last day of the month. The date entered was set to the last day of month.";
    public static final int CPC_ERROR_LOADING_REC_CHRG_ACCN = 2298;
    public static final String CPC_ERROR_LOADING_REC_CHRG_ACCN_MSG = "Error occurred while attempting to load client charges on Accession.";


    public static final int CPC_SDRY_CLN_EXP_DT_BEFORE_EFF_DT_WARNING = 7100;
    public static final String CPC_SDRY_CLN_EXP_DT_BEFORE_EFF_DT_WARNING_MSG = "Expiration date must be on after the effective date.";
    public static final int CPC_REC_CHRG_EXP_DT_INVALID_FOR_WKLY_FREQ = 7101;
    public static final String CPC_REC_CHRG_EXP_DT_INVALID_FOR_WKLY_FREQ_MSG = "Expiration date of recurring charge is invalid for a weekly frequency.  Valid expiration days are 7, 15, 22, or the last day of the month.  The date was set to the last of the month.";
    public static final int CPC_REC_CHRG_CLN_SUBM_FREQ_INVALID = 7102;
    public static final String CPC_REC_CHRG_CLN_SUBM_FREQ_INVALID_MSG = "Couldn't validate the client's submission frequency.  Please check it in client submission configuration and verify that it is set up properly.";
    public static final int CPC_LINKED_CLN_CANNOT_LINK_TO_SELF = 7103;
    public static final String CPC_LINKED_CLN_CANNOT_LINK_TO_SELF_MSG = "Cannot link a client to itself.";
    public static final int CPC_LINKED_CLN_ALREADY_AN_A_CLN = 7104;
    public static final String CPC_LINKED_CLN_ALREADY_AN_A_CLN_MSG = "Client already has other clients linked to it.";
    public static final int CPC_LINKED_CLN_ALREADY_A_B_CLN = 7105;
    public static final String CPC_LINKED_CLN_ALREADY_A_B_CLN_MSG = "Client is already linked to client";
    public static final int CPC_SDRY_CLN_EFF_DT_IN_PRIOR_MONTH = 7106;
    public static final String CPC_SDRY_CLN_EFF_DT_IN_PRIOR_MONTH_MSG = "Secondary client's effective date cannot be in a previous month.  The date was set to the first of this month.";
    public static final int CPC_NULL_EFF_DT_SDRY_CLN = 7107;
    public static final String CPC_NULL_EFF_DT_SDRY_CLN_MSG = "Effective date for a secondary client cannot be empty.  Enter an effective date.";
    public static final int CPC_PER_DIEM_RECALC_ROLLBACK = 7108;
    public static final String CPC_PER_DIEM_RECALC_ROLLBACK_MSG = "There was a problem updating per diem client.  Pricing has been unsuspended, but per diem was not recalculated.";
    public static final int CPC_INVALID_EXP_DT_SDRY_CLN = 7109;
    public static final String CPC_INVALID_EXP_DT_SDRY_CLN_MSG = "Invalid expiration date was entered in secondary client entry.\nEnter a valid expiration date.";
    public static final int CPC_CLN_NOT_SUBCLN_OF_SELF = 7110;
    public static final String CPC_CLN_NOT_SUBCLN_OF_SELF_MSG = "A client cannot be a secondary client of itself.";
    public static final int CPC_RC_CHRG_TOO_HIGH = 7111;
    public static final String CPC_RC_CHRG_TOO_HIGH_MSG = "Charge amount for recurring charge cannot be higher than $999999.99.";
    public static final int CPC_OUT_OF_BOUNDS_DISCPCT = 7112;
    public static final String CPC_OUT_OF_BOUNDS_DISCPCT_MSG = "Pricing detail discount percent out of acceptable bounds (enter valid number between 0 and 100).";
    public static final String CPC_OUT_OF_BOUNDS_DISC_MARKUPPCT_MSG = "Pricing detail discount/markup percent out of acceptable bounds (for discounts enter a number between 0 and 100; for markups enter a number between -1 and -900).";
    public static final int CPC_BOTH_DISC_TYPES_NOT_ALLOWED = 7114;
    public static final String CPC_BOTH_DISC_TYPES_NOT_ALLOWED_MSG = "Either Client Discount Percent(Disc %) or Client Max discount level is allowed, but not both";
    public static final int CPC_PRIMARY_NO_CLN_DT_RECORDS = 7115;
    public static final String CPC_PRIMARY_NO_CLN_DT_RECORDS_MSG = "The primary client has no pricing details." +
            "  Finish setting up the primary client before adding secondary clients.";
    public static final int CPC_SDRY_CLN_ACTTYP_NOT_DIALYSIS = 7116;
    public static final String CPC_SDRY_CLN_ACTTYP_NOT_DIALYSIS_MSG = "Dialysis Client can not have a non-dialysis secondary client relationship.";

    public static final int    CPC_INVALID_TAXPCT = 7117;
    public static final String CPC_INVALID_TAXPCT_MSG = "The Tax % must be between 0 and 100 with no more than 3 decimal places.";
    public static final int CPC_SDRY_CLN_AND_PRMY_CLN_EFF_PERIODS_OVERLAP = 7118;
    public static final String CPC_SDRY_CLN_AND_PRRY_CLN_EFF_PERIODS_OVERLAP_MSG = "Secondary client and primary client effective periods overlap.";

    public static final int CPC_OUT_OF_BOUNDS_CLN_TAXPCT = 7119;
    public static final String CPC_OUT_OF_BOUNDS_CLN_TAXPCT_MSG = "Pricing detail client tax percent out of acceptable bounds (enter valid number between 0 and 100).";

    public static final int CPC_INVALID_CLN_TAXPCT = 7120;
    public static final String CPC_INVALID_CLN_TAXPCT_MSG = "Invalid client tax percentage entered.";

    public static final int CPC_OUT_OF_BOUNDS_NONCLN_TAXPCT = 7121;
    public static final String CPC_OUT_OF_BOUNDS_NONCLN_TAXPCT_MSG = "Pricing detail non-client tax percent out of acceptable bounds (enter valid number between 0 and 100).";

    public static final int CPC_INVALID_NONCLN_TAXPCT = 7122;
    public static final String CPC_INVALID_NONCLN_TAXPCT_MSG = "Invalid non-client tax percentage entered.";

    public static final int CPC_RETRO_ENQUEUE_ERROR = 7123;
    public static final String CPC_RETRO_ENQUEUE_ERROR_MSG = "Error enqueuing accns for retro processing.";

    public static final int CPC_SDRY_CLN_LOCKED = 7124;
    public static final String CPC_SDRY_CLN_LOCKED_MSG = "Secondary client is locked by another user.";

    //Client Pricing Configuration Error Codes 2271 - 2295, 4011 - 4060, 7100 - 7199, 8501 - 8505
    public static final int CPC_INVALID_PO_NUMBER = 8501;
    public static final String CPC_INVALID_PO_NUMBER_ERR_MSG = "PO Number is Required.";
    public static final int CPC_INVALID_PO_ISSUE_DT = 8502;
    public static final String CPC_INVALID_PO_ISSUE_DT_ERR_MSG = "PO Issue Date is Required.";
    public static final int CPC_INVALID_PO_EXP_DT = 8503;
    public static final String CPC_INVALID_PO_EXP_DT_ERR_MSG = "PO Invalid Expiration Date.";
    public static final int CPC_INVALID_PO_AMT = 8504;
    public static final String CPC_INVALID_PO_AMT_ERR_MSG = "PO Amount is invalid.";
    public static final int CPC_OVERLAP_PO_ISSUE_DT = 8505;
    public static final String CPC_OVERLAP_PO_ISSUE_DT_ERR_MSG = "PO Issue Date Overlap";

    // Client Pricing Configuration - Client Billing Categories tab error codes
    public static final int CPC_CBC_INVALID_EFF_DT = 8506;
    public static final String CPC_CBC_INVALID_EFF_DT_ERR_MSG = "Invalid effective date found on the Client Billing Categories tab.";
    public static final int CPC_CBC_INVALID_EXP_DT = 8507;
    public static final String CPC_CBC_INVALID_EXP_DT_ERR_MSG = "Invalid expiration date found on the Client Billing Categories tab.";
    public static final String CPC_CBC_EXP_DT_BEFORE_EFF_DT_ERR_MSG = "Expiration date is before the effective date.";
    public static final int CPC_CBC_INVALID_CAP_RATE_AMT = 8508;
    public static final String CPC_CBC_INVALID_CAP_RATE_AMT_ERR_MSG = "Invalid Cap Rate amount found on the Client Billing Categories tab.";
    public static final int CPC_CBC_INVALID_CLN_BILLING_CATEGORY = 8509;
    public static final String CPC_CBC_INVALID_CLN_BILLING_CATEGORY_ERR_MSG = "Invalid Client Billing Category found on the Client Billing Categories tab.";
    public static final int CPC_CBC_INVALID_PRC_TYPE = 8510;
    public static final String CPC_CBC_INVALID_PRC_TYPE_ERR_MSG = "Invalid Pricing Type found on the Client Billing Categories tab.";
    public static final int CPC_CBC_INVALID_CARVE_OUT_FEE_SCHEDULE = 8511;
    public static final String CPC_CBC_INVALID_CARVE_OUT_FEE_SCHEDULE_ERR_MSG = "Invalid Carve Out Fee Schedule found on the Client Billing Categories tab.";
    public static final int CPC_CBC_INVALID_FEE_SCHEDULE = 8512;
    public static final String CPC_CBC_INVALID_FEE_SCHEDULE_ERR_MSG = "Invalid Fee Schedule found on the Client Billing Categories tab.";
    public static final int CPC_CBC_INVALID_DISCOUNT_PCT = 8513;
    public static final String CPC_CBC_INVALID_DISCOUNT_PCT_ERR_MSG = "Invalid Discount Percentage amount found on the Client Billing Categories tab.";
    public static final int CPC_CBC_OVERLAP_EFF_DT = 8514;
    public static final String CPC_CBC_OVERLAP_EFF_DT_ERR_MSG = "? has overlapping dates for period ? ? and ? ?. The date range for effective dates may not overlap.";
    public static final int CPC_CBC_EFF_DT_REQUIRED = 8515;
    public static final String CPC_CBC_EFF_DT_REQUIRED_ERR_MSG = "Effective date is missing on the Client Billing Categories tab.";
    public static final int CPC_CBC_CLN_BILLING_CATEGORY_REQUIRED = 8516;
    public static final String CPC_CBC_CLN_BILLING_CATEGORY_REQUIRED_ERR_MSG = "Client Billing Category is missing on the Client Billing Categories tab.";
    public static final int CPC_CBC_PRC_TYPE_REQUIRED = 8517;
    public static final String CPC_CBC_PRC_TYPE_REQUIRED_ERR_MSG = "Price Type is missing on the Client Billing Categories tab.";
    public static final int CPC_CBC_CAP_RATE_REQUIRED = 8518;
    public static final String CPC_CBC_CAP_RATE_REQUIRED_ERR_MSG = "Fee Schedule is required for the Pricing Type selected on the Client Billing Categories tab.";
    public static final int CPC_CBC_FEE_SCHEDULE_REQUIRED = 8519;
    public static final String CPC_CBC_FEE_SCHEDULE_REQUIRED_ERR_MSG = "Fee Schedule is required for the Pricing Type selected on the Client Billing Categories tab.";
    public static final int CPC_CBC_IDENTICAL_EFF_DTS = 8520;
    public static final String CPC_CBC_IDENTICAL_EFF_DTS_ERR_MSG = "? has identical effective dates. Effective dates need to be unique.";

    //Client Transaction Detail Error Codes 1400 - 1450
    public static final int CTD_NO_STMT_DT_SELECTED = 1400;
    public static final String CTD_NO_STMT_DT_SELECTED_MSG = "A statement date must be selected before creating adjustments.";
    public static final int CTD_FAILED_TO_GET_NEXT_SEQ = 1401;
    public static final String CTD_FAILED_TO_GET_NEXT_SEQ_MSG = "Unable to obtain next sequence id while creating client adjustment.";
    public static final int CTD_CLN_ADJ_FAILED = 1402;
    public static final String CTD_CLN_ADJ_FAILED_MSG = "An unexpected exception occurred while saving client adjustments.";
    public static final int CTD_CLN_ADJ_TOO_BIG = 1403;
    public static final String CTD_CLN_ADJ_TOO_BIG_MSG = "The adjustment amount is too large.";
    public static final int CTD_PAYPAL_TRANSACTION_FAILED = 1404;
    public static final String CTD_PAYPAL_TRANSACTION_FAILED_MSG = "The Electronic Transaction Failed.";
    public static final int CTD_ELECTRONIC_PAYMENT_POSTING_FAILED = 1405;
    public static final String CTD_ELECTRONIC_PAYMENT_POSTING_FAILED_MSG = "Electronic Payment Posting Failed - Transaction VOIDed.";
    public static final int CTD_ELECTRONIC_PAYMENT_VOIDING_FAILED = 1406;
    public static final String CTD_ELECTRONIC_PAYMENT_VOIDING_FAILED_MSG = "System was unable to void electronic payment.";
    public static final int REQUIRED_INV_CODE  = 1407;
    public static final String REQUIRED_INV_CODE_MSG   =  "Invoice ID Required";

    //Client Transaction Detail Error Codes 1400 - 1450

    // Test Code File Maintenance 1451 - 1550
    public static final int FM_TESTBASED = 1451;
    public static final String FM_TESTBASED_MSG = "Only "+test+" based fee schedules allowed update.";
    public static final int FM_FSBASED = 1452;
    public static final String FM_FSBASED_MSG = "Special price tables are not allowed update.";
    public static final int FM_NOTESTNAME = 1453;
    public static final String FM_NOTESTNAME_MSG = Test+" name is a required field.";
    public static final int FM_BADPRCABBRV = 1454;
    public static final String FM_BADPRCABBRV_MSG = "Fee schedule name is not valid.";
    public static final int FM_RTLBASED = 1455;
    public static final String FM_RTLBASED_MSG = "Retail fee schedule has already been selected.";
    public static final int FM_BADPYR = 1456;
    public static final String FM_BADPYR_MSG = "Valid payor field is required for a "+test+" modifier update.";
    public static final int FM_BADPYRGRP = 1457;
    public static final String FM_BADPYRGRP_MSG = "Valid payor group field is required for a "+test+" modifier update.";
    public static final int FM_NO_TRAVEL_FEE_COMPONENT = 1458;
    public static final String FM_NO_TRAVEL_FEE_COMPONENT_MSG = "The travel fee cannot be included in a profile.";
    public static final int FM_NO_TRAVEL_FEE_SS = 1459;
    public static final String FM_NO_TRAVEL_FEE_SS_MSG = "Could not verify that the travel fee is not included in this profile.  Please check system settings.";
    public static final int FM_NO_HL7_COMP_OF_PROF = 1460;
    public static final String FM_NO_HL7_COMP_OF_PROF_MSG = "An Hl7 "+Test+" cannot be a component of profile";
    public static final int    INVALID_DUP_TSTXREF = 1461;
    public static final String INVALID_DUP_TSTXREF_MSG = "The "+Test+" XREF type you entered was invalid or the Cross Reference Description you selected is already listed. To allow duplicates of XREF types, select the File Maintenance Cross Reference screen. -- ";
    public static final int  REQUIRED_TSTXREF  = 1462;
    public static final String REQUIRED_TSTXREF_MSG  = Test+" Xref Type Required.";
    public static final int FM_REFLAB_COST = 1463;
    public static final String FM_REFLAB_COST_MSG = fmLab+" Cost for a Reference "+fmLab+" must be greater than $0.00";
    public static final int FM_BADPYREXCL = 1456;
    public static final String FM_BADPYREXCL_MSG = "Valid payor field is required for Payor Exclusion.";
    public static final int FM_COPY_TO_EXISTING_DATE = 1457;
    public static final String FM_COPY_TO_EXISTING_DATE_MSG = "Cannot copy to an existing effective date.";
    public static final int FM_BADPYRCONS = 1458;
    public static final String FM_BADPYRCONS_MSG = "Valid payor field is required for Suppress Consolidation.";

    // End Test Code File Maintenance 1451 - 1550

    // 1551 - 1650: Payment Search
    public static final int PS_SUSP_ALREADY_APPLIED = 1551;
    public static final String PS_SUSP_ALREADY_APPLIED_MSG = "Suspense entry has already been applied and cannot be selected.";
    public static final int PS_PMT_SUSP_NOT_FOUND = 1552;
    public static final String PS_PMT_SUSP_NOT_FOUND_MSG = "Error while loading payments suspense record with id ";
    public static final int PS_ACCN_NOT_FOUND = 1553;
    public static final String PS_ACCN_NOT_FOUND_MSG = Accession+" not found matching "+accession+" id entered: ";
    public static final int PS_ACCN_LOCK_FAILED = 1554;
    public static final String PS_ACCN_LOCK_FAILED_MSG = "Data lock could not be obtained for "+accession ;
    public static final int PS_DEP_LOCK_FAILED = 1555;
    public static final String PS_DEP_LOCK_FAILED_MSG = "Data locked could not be obtained for deposit ";
    public static final int PS_BAD_ACCN_STATUS = 1556;
    public static final String PS_BAD_ACCN_STATUS_MSG = Accession+" status does not allow suspense payments to be applied ";
    public static final int PS_SUBMIT_FAILED = 1557;
    public static final String PS_SUBMIT_FAILED_MSG = "An error occurred on submit preventing changes from being committed.";
    public static final int PS_NO_CLN_SUSP_TO_ACCN = 1558;
    public static final String PS_NO_CLN_SUSP_TO_ACCN_MSG = "Suspense entry has a client payor and cannot be applied directly to an "+accession+".";
    public static final int PS_NO_SUSP_TO_PRIM_CLN_PYR = 1559;
    public static final String PS_NO_SUSP_TO_PRIM_CLN_PYR_MSG = "Suspense entry cannot be applied to an "+accession+" that has a primary payor that is a client payor.";
    public static final int PS_ONLY_ONE_PT_PYR = 1560;
    public static final String PS_ONLY_ONE_PT_PYR_MSG = "Suspense entry has a patient payor that is different that the patient payor on the "+accession+". Cannot apply suspense because two different patient payors not allowed on same "+accession+".";
    public static final int PS_NO_SUSP_TO_PT_PRIM_ACCN = 1561;
    public static final String PS_NO_SUSP_TO_PT_PRIM_ACCN_MSG = "Suspense entry cannot be applied to "+accession+" with patient payor as the primary payor because it would force a reprice of the "+accession+".";
    public static final int PS_PMT_SUSP_LOCK_FAILED = 1562;
    public static final String PS_PMT_SUSP_LOCK_FAILED_MSG = "Data lock could not be obtained for payment suspense entry ";
    public static final int PS_PMT_SUSP_REFUND_LOCK_FAILED = 1563;
    public static final String PS_PMT_SUSP_REFUND_LOCK_FAILED_MSG = "Data lock could not be obtained for payment suspense refund entry ";
    public static final int PS_PMT_SUSP_NOTE_TOO_LONG = 1564;
    public static final String PS_PMT_SUSP_NOTE_TOO_LONG_MSG = "Maximum note length is 500 characters.";
    public static final int PS_PYR_NOT_FOUND = 1565;
    public static final String PS_PYR_NOT_FOUND_MSG = "Matching payor not found";
    public static final int PS_SUSP_PYR_NOT_VALID = 1566;
    public static final String PS_SUSP_PYR_NOT_VALID_MSG = "Suspense payment payor is not a valid payor.";
    // 1551 - 1650: Payment Search
    public static final int FAC_DEMO_INVALID_BILLING_FACILITY_SUBMIT = 1651;
    public static final String FAC_DEMO_INVALID_BILLING_FACILITY_SUBMIT_MSG = "Facility Type cannot be changed from Main or Remote Affiliate because this is the Billing Facility for the following facilities:";
    //   1851 - 1899: Accession Test Update
    public static final int ATU_CANNOT_DELETE_TEST_MSG = 1851;
    public static final String ATU_CANNOT_DELETE_TEST_MSG_MSG = "System added "+lab+" message %s cannot be deleted ";
    public static final int ATU_USER_CANNOT_ENTER = 1853;
    public static final String ATU_USER_CANNOT_ENTER_MSG = " is for internal system use only and cannot be entered by the user.";
    public static final int ATU_ERROR_ADDING_TEST_DATA = 1853;
    public static final String ATU_ERROR_ADDING_TEST_DATA_MSG = "An error occurred and the "+test+" could not be added to the "+accession+". ";

    public static final int ATU_ERROR_INVALID_MILEAGE = 1855;
    public static final String ATU_ERROR_INVALID_MILEAGE_MSG = "Mileage is not valid.";

    public static final int ATU_ERROR_REQUIRED_MILEAGE = 1856;
    public static final String ATU_ERROR_REQUIRED_MILEAGE_MSG = "Mileage required.";

    public static final int ATU_ERROR_INVALID_TRIP_STOPS = 1857;
    public static final String ATU_ERROR_INVALID_TRIP_STOPS_MSG = Phlebotomy+" Stops not valid.";

    public static final int ATU_ERROR_REQUIRED_TRIP_STOPS = 1858;
    public static final String ATU_ERROR_REQUIRED_TRIP_STOPS_MSG = Phlebotomy+" Stops required.";

    public static final int ATU_ERROR_INVALID_TRIP_PATIENTS = 1859;
    public static final String ATU_ERROR_INVALID_TRIP_PATIENTS_MSG = "Total Patients cannot be less than "+phlebotomy+" stops.";

    public static final int ATU_ERROR_REQUIRED_TRIP_PATIENTS = 1860;
    public static final String ATU_ERROR_REQUIRED_TRIP_PATIENTS_MSG = "Total Patients required.";

    public static final int ATU_WARNING_PRC_BELOW_COST = 1861;
    public static final String ATU_WARNING_PRC_BELOW_COST_MSG = "Price is below "+sfmLab+" cost.";

    public static final int ATU_ERROR_INVALID_FINAL_REPORTDT = 1862;
    public static final String ATU_ERROR_INVALID_FINAL_REPORTDT_MSG = "Invalid Final Report Date.";

    public static final int TEST_ONLY_AS_COMPONENT = 1863;
    public static final String TEST_ONLY_AS_COMPONENT_MSG = Test+" can only be ordered as a component of a profile";

    public static final int ACCN_NOT_FOUND = 1864;
    public static final String ACCN_NOT_FOUND_MSG = Accession+" %s was not found";



    //   1851 - 1899: Accession Test Update

    //Payor Pricing Config Error Codes 4061 - 4086
    //Payor Pricing Config Error Codes 8201 - 8299
    public static final int PPC_MISSING_RSNCD = 4061;
    public static final String PPC_MISSING_RSNCD_MSG = "Reason Code Table required.";
    public static final int PPC_MISSING_MIN_WO_BAL = 4062;
    public static final String PPC_MISSING_MIN_WO_BAL_MSG = "Min W/O Balance required.";
    public static final int PPC_MISSING_WO_ADJ_CD = 4063;
    public static final String PPC_MISSING_WO_ADJ_CD_MSG = "Min W/O Balance Adjustment Code required.";
    public static final int PPC_MISSING_WO_AGE = 4064;
    public static final String PPC_MISSING_WO_AGE_MSG = "W/O Age Required";
    public static final int PPC_MISSING_AGE_WO_ADJ = 4065;
    public static final String PPC_MISSING_AGE_WO_ADJ_MSG = "Age W/O Adjustment Code required.";
    public static final int PPC_MISSING_FL_TIME_LMT = 4066;
    public static final String PPC_MISSING_FL_TIME_LMT_MSG = "File Time Limit required.";
    public static final int PPC_MISSING_RE_FL_TIME_LMT = 4067;
    public static final String PPC_MISSING_RE_FL_TIME_LMT_MSG = "Re-File Time Limit required.";
    public static final int PPC_MISSING_APPL_TIME_LMT = 4068;
    public static final String PPC_MISSING_APPL_TIME_LMT_MSG = "Appeal Time Limit required.";
    public static final int PPC_MISSING_EFFDT = 4069;
    public static final String PPC_MISSING_EFFDT_MSG = "Effective Date is required.";
    public static final int PPC_MISSING_PROC_CD = 4070;
    public static final String PPC_MISSING_PROC_CD_MSG = "Proc Code Table is required.";
    public static final int PPC_MISSING_DIAG_CD = 4071;
    public static final String PPC_MISSING_DIAG_CD_MSG = "Diag Code Table is required.";
    public static final int PPC_MISSING_BILL_FEE_SCHED = 4072;
    public static final String PPC_MISSING_BILL_FEE_SCHED_MSG = "Billed Fee Schedule is required.";
    public static final int PPC_MISSING_EXPCT_FEE_SCHED = 4073;
    public static final String PPC_MISSING_EXPCT_FEE_SCHED_MSG = "Expect Fee Schedule is required.";
    public static final int PPC_BILL_FEE_SCHED_PROC_ID = 4074;
    public static final String PPC_BILL_FEE_SCHED_PROC_ID_MSG = "The Billed Fee Schedule doesn't match the Proc Code Tbl";
    public static final int PPC_BILL_FEE_SCHED_NOT_EFFECTIVE = 4075;
    public static final String PPC_BILL_FEE_SCHED_NOT_EFFECTIVE_MSG = "The Billed Fee Schedule is not effective.";
    public static final int PPC_BILL_FEE_SCHED_EXPIRED = 4076;
    public static final String PPC_BILL_FEE_SCHED_EXPIRED_MSG = "The Billed Fee Schedule has expired.";
    public static final int PPC_EXPCT_FEE_SCHED_PROC_ID = 4077;
    public static final String PPC_EXPCT_FEE_SCHED_PROC_ID_MSG = "The Expect Fee Schedule doesn't match the Proc Code Tbl";
    public static final int PPC_EXPCT_FEE_SCHED_NOT_EFFECTIVE = 4078;
    public static final String PPC_EXPCT_FEE_SCHED_NOT_EFFECTIVE_MSG = "The Expect Fee Schedule is not effective.";
    public static final int PPC_EXPCT_FEE_SCHED_EXPIRED = 4079;
    public static final String PPC_EXPCT_FEE_SCHED_EXPIRED_MSG = "The Expect Fee Schedule has expired.";
    public static final int PPC_DUP_EFFDT = 4080;
    public static final String PPC_DUP_EFFDT_MSG = "A duplicate Effective Date was entered.";
    public static final int PPC_FL_TIME_LMT = 4081;
    public static final String PPC_FL_TIME_LMT_MSG = "The Filing Time Limit can't be greater than the W/O Age.";
    public static final int PPC_FL_TIME_LMT_PYR_GRP = 4082;
    public static final String PPC_FL_TIME_LMT_PYR_GRP_MSG = "The Filing Time Limit can't be greater than the Payor Group W/O Age.";
    public static final int PPC_CONTRCT_ID = 4083;
    public static final String PPC_CONTRCT_ID_MSG = "Contract ID is required.";
    public static final int PPC_TEST_NUM = 4084;
    public static final String PPC_TEST_NUM_MSG = "Referral Handling "+Test+" ID doesn't exist.";
    public static final int PPC_TEST_NUM_PROFILE = 4085;
    public static final int PPC_FL_TIME_LMT_IS_REQUIRED = 4086;
    public static final String PPC_FL_TIME_LMT_IS_REQUIRED_MSG = "The Filing Time Limit is required.";


    public static final String PPC_TEST_NUM_PROFILE_MSG = "Referral Handling "+Test+" ID must be non-profile.";
    public static final int PPC_PC_MODIFIER_BILL_TO_PAYOR_NOT_FOUND = 201;
    public static final String PPC_PC_MODIFIER_BILL_TO_PAYOR_NOT_FOUND_MSG = "PC Modifier Bill To Payor was not found.";
    public static final int PPC_PC_MODIFIER_BILL_TO_PAYOR_ILLEGAL = 202;
    public static final String PPC_PC_MODIFIER_BILL_TO_PAYOR_ILLEGAL_MSG = "PC Modifier Bill To Payor cannot be the same as the payor.";
    public static final int PPC_SUBMIT_WITH_NULL_PYR = 203;
    public static final String PPC_SUBMIT_WITH_NULL_PYR_MSG = "An error occurred while submitting your changes.  Please try again.";
    public static final int PPC_MISSING_TRAVEL_FEE = 8201;
    public static final String PPC_MISSING_TRAVEL_FEE_MSG = "Travel fee flat and per-mile rate are both required if payor uses travel fee calculation.";
    public static final int PPC_TRAVEL_FEE_TOO_MANY_DEC = 8202;
    public static final String PPC_TRAVEL_FEE_TOO_MANY_DEC_MSG = "Travel fee rates can have at most three decimal places.";
    public static final int PPC_TRAVEL_FEE_NOT_NEGATIVE = 8203;
    public static final String PPC_TRAVEL_FEE_NOT_NEGATIVE_MSG = "Travel fee rates cannot be negative.";
    public static final int PPC_TRAVEL_FEE_NOT_A_NUMBER = 8204;
    public static final String PPC_TRAVEL_FEE_NOT_A_NUMBER_MSG = "Not a valid travel fee rate.";
    public static final int PPC_TRAVEL_FEE_TOO_LARGE = 8205;
    public static final String PPC_TRAVEL_FEE_TOO_LARGE_MSG = "Exceeds maximum travel fee rate.";
    public static final int PPC_NON_TESTING_FACILITY = 8206;
    public static final String PPC_NON_TESTING_FACILITY_MSG = " is not a testing facility.  Please delete this row from the Submission Service Provider grid and re-submit.";
    public static final int PPC_INVALID_INCR_TBL = 4090;
    public static final String PPC_INVALID_INCR_TBL_MSG = "Invalid Incremental Tbl entry under Pricing Information.";

    public static final int PPC_PPL_EMPTY_PAYOR_ID = 8207;
    public static final String PPC_PPL_EMPTY_PAYOR_MSG = "Payor cannot be empty in payor reference grid.";

    public static final int PPC_PPL_EMPTY_PAYOR_REFERENCE = 8208;
    public static final String PPC_PPL_EMPTY_PAYOR_REFERENCE_MSG = "Payor reference cannot be empty in payor reference grid.";

    public static final int PPC_PPL_DUPLICATE_PAYOR_ID = 8209;
    public static final String PPC_PPL_DUPLICATE_PAYOR_MSG = "A duplicate payor found in payor reference grid.";

    public static final int PPC_MISSING_REQUIRED_INST_BIL_TYP = 8210;
    public static final String PPC_MISSING_REQUIRED_INST_BIL_TYP_MSG = "Institutional Bill Classification of at least 13X or 14X is required.";

    // Scheduler
    public static final int SCHED_NO_STATUS_AVAIL = 4086;
    public static final String SCHED_NO_STATUS_AVAIL__MSG = "Scheduler Status is not available.";
    public static final int SCHED_NO_LAB_STATUS_AVAIL = 4087;
    public static final String SCHED_NO_LAB_STATUS_AVAIL__MSG = "Scheduler Status for the specified lab is not available.";
    // Scheduler Error Codes 4086 - 4199

    // Client Demographics Error Codes 4200 - 4246
    public static final int INVALID_CLNDEMO_ID  = 4200;
    public static final String INVALID_CLNDEMO_ID_MSG  = "Invalid Client ID";
    public static final int CLNDEMO_EAV_FMT = 4201;
    public static final String CLNDEMO_EAV_FMT_MSG  = "Invalid format for EAV";
    public static final int    INVALID_CLN_ABBRV = 4202;
    public static final String INVALID_CLN_ABBRV_MSG = "Client account not on file";
    public static final int  REQUIRED_CLNDEMO_NAME  = 4203;
    public static final String REQUIRED_CLNDEMO_NAME_MSG  = "Client Name Required";
    public static final int REQUIRED_CLNDEMO_ACCNTTYPE  = 4204;
    public static final String REQUIRED_CLNDEMO_ACCNTTYPE_MSG  = "Billing Account Type Required";
    public static final int REQUIRED_CLNDEMO_EFF_DT = 4205;
    public static final String REQUIRED_CLNDEMO_EFF_DT_MSG  = "Client Effective Date Required";
    public static final int CLNDEMO_EFF_DT_INVALID  = 4206;
    public static final String CLNDEMO_EFF_DT_INVALID_MSG  = "Invalid Client Effective Date";
    public static final int REQUIRED_CLNDEMO_CONTCT  = 4208;
    public static final String REQUIRED_CLNDEMO_CONTCT_MSG  = "Preferred Contact Type is required";
    public static final int REQUIRED_CLNDEMO_CONTCT_NM  = 4210;
    public static final String REQUIRED_CLNDEMO_CONTCT_NM_MSG  = "Missing Billing Contact Name";
    public static final int    REQUIRED_CLNDEMO_PHN = 4211;
    public static final String REQUIRED_CLNDEMO_PHN_MSG = "Billing contact phone number is required";
    public static final int    MISSING_CLNDEMO_PHN = 4212;
    public static final String MISSING_CLNDEMO_PHN_MSG = "Missing Billing contact phone number";
    public static final int    REQUIRED_CLNDEMO_FAX = 4213;
    public static final String REQUIRED_CLNDEMO_FAX_MSG = "Billing contact FAX number is required";
    public static final int    MISSING_CLNDEMO_FAX = 4214;
    public static final String MISSING_CLNDEMO_FAX_MSG = "Missing Billing contact FAX number";
    public static final int    ERROR_INVALID_NPI_TYPE = 4215;
    public static final String ERROR_INVALID_NPI_TYPE_MSG = "Invalid NPI type: Can only be 1 or 2";
    public static final int ERROR_CLNFAC_NPI_NTFND  = 4217;
    public static final String ERROR_CLNFAC_NPI_NTFND_MSG  = "Primary facility NPI not found.";
    public static final int INVALID_CLNDEMO_PHN1  = 4216;
    public static final String INVALID_CLNDEMO_PHN1_MSG  = "Invalid Billing contact Phone number";
    public static final int INVALID_CLNDEMO_PHN2  = 4218;
    public static final String INVALID_CLNDEMO_PHN2_MSG  = "Invalid Billing contact 2 Phone number";
    public static final int INVALID_CLNDEMO_FAX1  = 4220;
    public static final String INVALID_CLNDEMO_FAX1_MSG  = "Invalid Billing contact FAX Phone number";
    public static final int WARNING_CLNFAC_NPI_NTFND  = 4221;
    public static final String WARNING_CLNFAC_NPI_NTFND_MSG  = "Warning: Client facility NPI is not found. Use Physician License  to set up an individual NPI or submit to create a organization Client Facility NPI";
    public static final int INVALID_CLNDEMO_FAX2  = 4222;
    public static final String INVALID_CLNDEMO_FAX2_MSG  = "Invalid Billing contact 2 FAX Phone number";
    public static final int REQUIRED_CLNDEMO_EMAIL  = 4223;
    public static final String REQUIRED_CLNDEMO_EMAIL_MSG  = "Billing E-mail is required";
    public static final int REQUIRED_CLNDEMO_ADDR1  = 4224;
    public static final String REQUIRED_CLNDEMO_ADDR1_MSG  = "Missing Billing Address 1 required";
    public static final int INVALID_CLNDEMO_ZIP_ID  = 4225;
    public static final String INVALID_CLNDEMO_ZIP_ID_MSG  = "Invalid Billing Zip code";
    public static final int REQUIRED_CLNDEMO_ZIP_ID  = 4226;
    public static final String REQUIRED_CLNDEMO_ZIP_ID_MSG  = "Billing Zip code is either missing or invalid";
    public static final int INVALID_CL_FAC_NPI  = 4227;
    public static final String INVALID_CL_FAC_NPI_MSG  = "Client Facility NPI is invalid. Must be a 10 digit numeric value";
    public static final int    CONFLICT_CLNDEMO_ZIP_STATE  = 4228;
    public static final String CONFLICT_CLNDEMO_ZIP_STATE_MSG = "The Billing zip code conflicts with the state entered";
    public static final int REQUIRED_CLNDEMO_PRMY_FAC_ID = 4229;
    public static final String REQUIRED_CLNDEMO_PRMY_FAC_ID_MSG  = "Primary Facility selection is Required";
    public static final int INVALID_CLNDEMO_ACCNT_TYPE_TO_DIAL_PRMY_CLN = 4230;
    public static final String INVALID_CLNDEMO_ACCNT_TYPE_TO_DIAL_PRMY_CLN_MSG = "can not change account type to Dialysis because the client has a primary client relationship with ";
    public static final int INVALID_CLNDEMO_ACCNT_TYPE_TO_DIAL_SCDY_CLN = 4231;
    public static final String INVALID_CLNDEMO_ACCNT_TYPE_TO_DIAL_SCDY_CLN_MSG = "can not change account type to Dialysis because the client has secondary client relationship(s) with ";
    public static final int INVALID_CLNDEMO_ACCNT_TYPE_FROM_DIAL_PRMY_CLN = 4232;
    public static final String INVALID_CLNDEMO_ACCNT_TYPE_FROM_DIAL_PRMY_CLN_MSG = "can not change account type from Dialysis because the client has a primary client relationship with ";
    public static final int INVALID_CLNDEMO_ACCNT_TYPE_FROM_DIAL_SCDY_CLN = 4233;
    public static final String INVALID_CLNDEMO_ACCNT_TYPE_FROM_DIAL_SCDY_CLN_MSG = "can not change account type from Dialysis because the client has secondary client relationship(s) with ";
    public static final int EXCEL_OR_PDF_SUBM_SVC_REQD = 4234;
    public static final String EXCEL_OR_PDF_SUBM_SVC_REQD_MSG = "At least one submission service is required (PDF or Excel).";
    public static final int CLNDEMO_CONFLICTING_CLN_SPC_MEDICARE_PYR_ID = 4035;
    public static final String CLNDEMO_CONFLICTING_CLN_SPC_MEDICARE_PYR_ID_MSG = "Primary Facility cannot be updated as it must share the same Medicare Payor Id as the Client's Special Price Table.";
    public static final int INVALID_NPI_CHECK_DIGIT  = 4236;
    public static final String INVALID_NPI_CHECK_DIGIT_MSG  = "Client Facility NPI does not pass the check digit algorithm. Please validate NPI.";


    //Client Demo Lab info..
    public static final int INVALID_CLNDEMOLAB_PHN1 = 4230;
    public static final String INVALID_CLNDEMOLAB_PHN1_MSG  = "Invalid street address contact phone number";
    public static final int REQUIRED_CLNDEMOLAB_PHN1 = 4231;
    public static final String REQUIRED_CLNDEMOLAB_PHN1_MSG  = "Street address contact phone number is required";
    public static final int INVALID_CLNDEMOLAB_PHN2  = 4232;
    public static final String INVALID_CLNDEMOLAB_PHN2_MSG  = "Invalid street address contact 2 Phone number";
    public static final int REQUIRED_CLNDEMOLAB_FAX1  = 4233;
    public static final String REQUIRED_CLNDEMOLAB_FAX1_MSG  = "Street address contact FAX Phone number is required";
    public static final int INVALID_CLNDEMOLAB_FAX1  = 4234;
    public static final String INVALID_CLNDEMOLAB_FAX1_MSG  = "Invalid street address contact FAX Phone number";
    public static final int INVALID_CLNDEMOLAB_FAX2  = 4236;
    public static final String INVALID_CLNDEMOLAB_FAX2_MSG  = "Invalid street address contact 2 FAX Phone number";
    public static final int    INVALID_CLNDEMOLAB_ZIP_ID = 4238;
    public static final String INVALID_CLNDEMOLAB_ZIP_ID_MSG = "Street zip code is either missing or invalid";
    public static final int    INVALID_CLNDEMOREFUND_ZIP_ID = 4239;
    public static final String INVALID_CLNDEMOREFUND_ZIP_ID_MSG = "Refund zip code is either missing or invalid";
    public static final int    CONFLICT_CLNDEMOLAB_ZIP_STATE = 4240;
    public static final String CONFLICT_CLNDEMOLAB_ZIP_STATE_MSG = "Street zip code conflicts with the state";
    public static final int    REQUIRED_CLNDEMOLAB_EMAIL = 4241;
    public static final String REQUIRED_CLNDEMOLAB_EMAIL_MSG = "Street address E-mail is required";

    //Client Demo Corresp info
    public static final String REQUIRED_CLNDEMO_CORPHN_MSG = "Correspondence phone number is required";
    public static final int    MISSING_CLNDEMO_CORPHN = 4212;
    public static final String MISSING_CLNDEMO_CORPHN_MSG = "Missing Correspondence phone number";
    public static final int    REQUIRED_CLNDEMO_CORFAX = 4213;
    public static final String REQUIRED_CLNDEMO_CORFAX_MSG = "Correspondence FAX number is required";
    public static final int    MISSING_CLNDEMO_CORFAX = 4214;
    public static final String MISSING_CLNDEMO_CORFAX_MSG = "Missing Correspondence FAX number";
    public static final int INVALID_CLNDEMO_CORPHN  = 4216;
    public static final String INVALID_CLNDEMO_CORPHN_MSG  = "Invalid Correspondence contact Phone number";
    public static final int INVALID_CLNDEMO_CORFAX  = 4236;
    public static final String INVALID_CLNDEMO_CORFAX_MSG  = "Invalid Correspondence address FAX number";
    public static final int REQUIRED_CLNDEMO_CORADDR1  = 4224;
    public static final String REQUIRED_CLNDEMO_CORADDR1_MSG  = "Missing Correspondence Address 1 required";
    public static final int    INVALID_CLNDEMO_CORZIP_ID = 4238;
    public static final String INVALID_CLNDEMO_CORZIP_ID_MSG = "Correspondence zip code is either missing or invalid";
    public static final int    CONFLICT_CLNDEMO_CORZIP_STATE = 4240;
    public static final String CONFLICT_CLNDEMO_CORZIP_STATE_MSG = "Correspondence zip code conflicts with the state";

    public static final int    INVALID_DUP_CLNXREF = 4242;
    public static final String INVALID_DUP_CLNXREF_MSG = "The Client XREF type you entered was invalid or the Cross Reference Description you selected is already listed. To allow duplicates of XREF types, select the File Maintenance Cross Reference screen. -- ";
    public static final int    CONFLICT_CLNDEMOREFUND_ZIP_STATE = 4243;
    public static final String CONFLICT_CLNDEMOREFUND_ZIP_STATE_MSG = "Street zip code conflicts with the state";
    public static final int    INVALID_COUNTRY_STATE = 4244;
    public static final String INVALID_COUNTRY_STATE_MSG = "Missing or invalid state";
    public static final int  REQUIRED_CLNXREF  = 4246;
    public static final String REQUIRED_CLNXREF_MSG  = "Client Xref Type Required.";
    public static final int  INVALID_XREF_PHYSICIAN_LIC_ID  = 4247;
    public static final String INVALID_XREF_PHYSICIAN_LIC_ID_MSG  = "Invalid Physician License ID.";

    //Cross Reference Jsp and Servlet 4248-4249
    public static final int   REQUIRED_XREF_CAT_ID = 4248;
    public static final String REQUIRED_XREF_CAT_ID_MSG = "A Cross reference category selection is required.";
    public static final int   REQUIRED_XREF_TYP_ID = 4249;
    public static final String REQUIRED_XREF_TYP_ID_MSG = "A Cross reference type selection or creation is required.";
    public static final int   OVERLAP_DT_ID = 4250;
    public static final String OVERLAP_DT_ID_MSG = " does not allow over-lapping effective and expiration date ranges.";



    // Question Maintenance Servlet 4251 - 4260
    public static final int QMS_BLANK_QSTN_TEXT = 4251;
    public static final String QMS_BLANK_QSTN_TEXT_MSG = "Question text may not be blank. Enter question text.";
    public static final int QMS_LOCKING_ERROR = 4252;
    public static final String QMS_LOCKING_ERROR_MSG = "Unable to obtain lock.";
    public static final int QMS_SUBMIT_ERROR = 4253;
    public static final String QMS_SUBMIT_ERROR_MSG = "Unable to submit data. Changes rolled back.";
    public static final int QMS_INVALID_QID = 4254;
    public static final String QMS_INVALID_QID_MSG = "Question ID was invalid or blank. ID must be a valid number.";
    public static final int QMS_DELETED_NEW_RECORD = 4255;
    public static final String QMS_DELETED_NEW_RECORD_MSG = "A record that was added by the user and not yet submitted was flagged deleted.";
    public static final int QMS_INVALID_CLN_ID = 4256;
    public static final String QMS_INVALID_CLN_ID_MSG = "An invalid client ID was entered.";
    public static final int QMS_INVALID_TEST_ID = 4257;
    public static final String QMS_INVALID_TEST_ID_MSG = "An invalid "+test+" ID was entered.";
    public static final int QMS_INVALID_SPCMN_ID = 4258;
    public static final String QMS_INVALID_SPCMN_ID_MSG = "An invalid specimen container ID was entered.";
    //Question Maintenance Servlet 4251 - 4260

    //Accession Demographics
    public static final int ACD_MISSING_PYR_PRIO = 4261;
    public static final String ACD_MISSING_PYR_PRIO_MSG = "Payor Priority required.";
    public static final int ACD_MISSING_PYR_ID = 4262;
    public static final String ACD_MISSING_PYR_ID_MSG = "Payor ID required.";
    public static final int ACD_MISSING_INSUR_NM = 4263;
    public static final String ACD_MISSING_INSUR_NM_MSG = "Insurance Name required.";
    public static final int ACD_DUP_PRIO = 4264;
    public static final String ACD_DUP_PRIO_MSG = "A duplicate Payor Priority was entered.";
    public static final int ACD_DIAL_TYP = 4265;
    public static final String ACD_DIAL_TYP_MSG = "A Dialysis Type is required.";
    public static final int ACD_COND = 4266;
    public static final String ACD_COND_MSG = "A Dialysis Condition is required.";
    public static final int ACD_EP_HOLD = 4267;
    public static final String ACD_EP_HOLD_MSG = "Missing EP Hold comments.";
    public static final int ACD_EP_PRICE = 4268;
    public static final String ACD_EP_PRICE_MSG = "Unable to reprice at this time.";
    public static final int ACD_PYR_ID = 4269;
    public static final String ACD_PYR_ID_MSG = "Invalid Payor ID.";
    public static final int ACD_INDIGENT = 4270;
    public static final String ACD_INDIGENT_MSG = "Indigent % change not allowed on non Patient primary.";
    public static final int ACD_DUP_PYR_ID = 4271;
    public static final String ACD_DUP_PYR_ID_MSG = "A duplicate Payor ID was entered.";
    public static final int ACD_PYR_ID_SEQ = 4272;
    public static final String ACD_PYR_ID_SEQ_MSG = "Payor Priorities must follow a non-breaking sequence(1,2,3,..).";
    public static final int ACD_CLN_LOCK = 4273;
    public static final String ACD_CLN_LOCK_MSG = "Client currently locked.  Payor priority one changes not allowed.";
    public static final int ACD_ACCN_PYR_ERR = 4274;
    public static final String ACD_ACCN_PYR_ERR_MSG = "Problem finding Error to mark fixed.  It may have been fixed by someone else.";
    public static final int ACD_DEL_PYR = 4275;
    public static final String ACD_DEL_PYR_MSG = "Unable to delete Payor at this time.";
    public static final int ACD_PT_REC = 4276;
    public static final String ACD_PT_REC_MSG = "Patient Record does not exist.";
    public static final int ACCN_PYR_ERROR = 4277;
    public static final String ACCN_PYR_ERROR_MSG = "Unable to process "+Accn+" Payor Transaction.";
    public static final int ACCN_ERROR = 4278;
    public static final String ACCN_ERROR_MSG = "Unable to process "+Accn+" Transaction.";
    public static final int ACCN_PYR_ERRS = 4279;
    public static final String ACCN_PYR_ERRS_MSG = "Unable to process "+Accn+" Payor Errors.";
    public static final int ACCN_PYR_DATA = 4280;
    public static final String ACCN_PYR_DATA_MSG = "Unable to save "+Accn+" Payor Data.";
    public static final int ACD_PRIO_ORDR = 4281;
    public static final String ACD_PRIO_ORDR_MSG = "Error Occurred while processing Payor Priorities.";
    public static final int ACD_REPRICE_ERROR = 4282;
    public static final String ACD_REPRICE_ERROR_MSG = "Re-Pricing not allowed due to database data errors.";
    public static final int ACD_PRIO_ONE_REQ = 4283;
    public static final String ACD_PRIO_ONE_REQ_MSG = "Payor of priority 1 required.";
    public static final int ACD_PROC_PYR_PRIO = 4284;
    public static final String ACD_PROC_PYR_PRIO_MSG = "Unable to delete Payor with associated Payor Procedures.";
    public static final int ACD_REPRICE = 4285;
    public static final String ACD_REPRICE_MSG = "Re-pricing not allowed with unpriceable errors.";
    public static final int ACD_PTHMPHN = 4286;
    public static final String ACD_PTHMPHN_MSG = "Invalid patient home phone.";
    public static final int ACD_PTWRKPHN = 4287;
    public static final String ACD_PTWRKPHN_MSG = "Invalid patient work phone.";
    public static final int ACD_WRKEMPINJURYDT = 4288;
    public static final String ACD_WRKEMPINJURYDT_MSG = "Invalid workers' comp injury date.";
    public static final int ACD_REPRICING_ERROR = 4289;
    public static final String ACD_REPRICING_ERROR_MSG = "Required data for reprice missing from database.";
    public static final int ACD_CLN_PYR = 4290;
    public static final String ACD_CLN_PYR_MSG = "Client payor can only be primary with no other payors allowed.";
    public static final int ACD_NO_PYRS = 4291;
    public static final String ACD_NO_PYRS_MSG = "No payors for this "+accession+".  Please enter a payor via Order Entry.";
    public static final int ACD_REPRICE_NOT_ALLOWED = 4292;
    public static final String ACD_REPRICE_NOT_ALLOWED_MSG = "Repricing is not allowed with either payments, adjustments, or an invalid status.";
    public static final int ACD_INVALID_STATUS_FOR_ACTION = 4293;
    public static final String ACD_INVALID_STATUS_FOR_ACTION_MSG = "The "+accession+" status does not permit this action.";
    public static final int NO_PT_PYRS = 4294;
    public static final String NO_PT_PYRS_MSG = "At least one patient demographics payor required for this action.  Please enter a payor through Patient Demographics.";
    public static final int SUBM_PROM_PMTS = 4295;
    public static final String SUBM_PROM_PMTS_MSG = "Patient is on a payment plan. Please use Single Statement to generate a statement or Notes/Promised Payments to void the plan.";
    public static final int PT_PYR_SUSP = 4296;
    public static final String PT_PYR_SUSP_MSG = "Because the patient demographic record's primary payor is suspended, payor related demographic data will not be copied to the "+accession+".  Click Submit to accept this or Reset to cancel your changes.";
    public static final int PT_PYR_SECONDARY_SUSP = 4297;
    public static final String PT_PYR_SECONDARY_SUSP_MSG = "Because the patient demographic record's secondary payor(s) are suspended, payor demographic data for secondary payor(s) will not be copied to the "+accession+".  Click Submit to accept this or Reset to cancel your changes.";
    public static final int MCARE_PYR = 4298;
    public static final String MCARE_PYR_MSG = "Only one non-system added Medicare payor is allowed.";
    public static final int OE_NOT_PERFORMED = 4299;
    public static final String OE_NOT_PERFORMED_MSG = "This "+accession+" is not final reported and therefore cannot be " +
            "updated on this screen.  Please use Order Entry to final report the "+accession+".";
    public static final int NEEDS_OE_ON_REPORTED_ACCN = 8000;
    public static final String NEEDS_OE_ON_REPORTED_ACCN_MSG = "This "+accession+" must be updated " +
            "via Order Entry before any updates may be made using this screen";
    public static final int ACCN_PENDING_BILLING_ASSGNMNT = 8001;
    public static final String ACCN_PENDING_BILLING_ASSGNMNT_MSG = "Billing Assignment has not been completed";
    public static final int PYR_PRIO_ONE_CHANGED = 8100;
    public static final String PYR_PRIO_ONE_CHANGED_MSG = "Prio One Payor Changed - Verify Client Billing Category and click Submit";
    public static final int INVALID_BILLING_FACILITY = 8101;
    public static final String INVALID_BILLING_FACILITY_MSG = "Invalid billing facility.";

    //4261 - 4299: Accession Demographics && 8000 - 8200



    //Payor Pricing Config CONT'D
    public static final int PPC_DIS_PRCNT = 4300;
    public static final String PPC_DIS_PRCNT_MSG = "Percentages must be 1-100.";
    public static final int PPC_INVALID_CONTRCT = 4301;
    public static final String PPC_INVALID_CONTRCT_MSG = "Invalid Contract ID.";
    public static final int PPC_HANDLEMIN_LESS_ZERO = 4302;
    public static final String PPC_HANDLEMIN_LESS_ZERO_MSG = "Handle Min Fee can't be less than zero.";
    public static final int PPC_HANDLEMAX_LESS_ZERO = 4303;
    public static final String PPC_HANDLEMAX_LESS_ZERO_MSG = "Handle Max Fee can't be less than zero.";
    public static final int PPC_UPRC = 4304;
    public static final String PPC_UPRC_MSG = "RVS Unit Price can't be less than zero.";
    public static final int PPC_MAX_LESS_MIN = 4305;
    public static final String PPC_MAX_LESS_MIN_MSG = "Handling Fee Max can't be less than Min.";
    public static final int PPC_RVS_EPPRC = 4306;
    public static final String PPC_RVS_EPPRC_MSG = "There can't be an RVS Table and a Expect Fee Schedule.";
    public static final int PPC_DUP_PROC = 4307;
    public static final String PPC_DUP_PROC_MSG = "A duplicate Proc Code was entered.";
    public static final int PPC_DUP_CYCLE = 4308;
    public static final String PPC_DUP_CYCLE_MSG = "A duplicate Cycle was entered.";
    public static final int PPC_MISSING_SVC = 4309;
    public static final String PPC_MISSING_SVC_MSG = "Submission Service Missing.";
    public static final int PPC_MISSING_PRIM_SVC = 4310;
    public static final String PPC_MISSING_PRIM_SVC_MSG = "Primary and Non Primary Service required.";
    public static final int PPC_CYCLE_ZERO = 4311;
    public static final String PPC_CYCLE_ZERO_MSG = "Dunning Cycle must be greater than zero.";
    public static final int PPC_DAYS_ZERO = 4312;
    public static final String PPC_DAYS_ZERO_MSG = "Dunning Cycle Days must be greater than zero.";
    public static final int PPC_PROC = 4313;
    public static final String PPC_PROC_MSG = "Proc Code required.";
    public static final int PPC_CLEAR = 4314;
    public static final String PPC_CLEAR_MSG = "Clearing House ID required.";
    public static final int PPC_MISSING_DIAG_MTHD = 4315;
    public static final String PPC_MISSING_DIAG_MTHD_MSG = "Diagnosis selection method required.";
    public static final int PPC_DUP_ELIG = 4316;
    public static final String PPC_DUP_ELIG_MSG = "A duplicate Eligibility Service was entered.";
    public static final int PPC_MISSING_ELIG_SVC = 4317;
    public static final String PPC_MISSING_ELIG_SVC_MSG = "Eligibility Service required.";
    public static final int PPC_MISSING_ELIG_FAC = 4318;
    public static final String PPC_MISSING_ELIG_FAC_MSG = "Eligibility Facility required.";
    public static final int PPC_P_OR_C_PYR = 4319;
    public static final String PPC_P_OR_C_PYR_MSG = "Changes for this payor are not allowed on this screen.";
    public static final int PPC_NO_ELIG_PREF = 4320;
    public static final String PPC_NO_ELIG_PREF_MSG = "One eligibility service must be preferred.";
    public static final int PPC_ONLY_ONE_ELIG_PREF = 4321;
    public static final String PPC_ONLY_ONE_ELIG_PREF_MSG = "Only one eligibility service can be preferred.";
    public static final int PPC_MISSING_FACILITY = 4322;
    public static final String PPC_MISSING_FACILITY_MSG = "Dunning cycle requires a facility entered.";
    public static final int PPC_MISSING_PROVIDER = 4323;
    public static final String PPC_MISSING_PROVIDER_MSG = "Submission service provider requires a provider ID.";
    public static final int PPC_MISSING_GL_CODE = 4324;
    public static final String PPC_MISSING_GL_CODE_MSG = "Submission service provider requires a GL code";
    public static final int PPC_MISSING_SUBMITTER = 4325;
    public static final String PPC_MISSING_SUBMITTER_MSG = "Submission service provider requires a submitter ID.";
    public static final int PPC_MISSING_PSERVICE = 4326;
    public static final String PPC_MISSING_PSERVICE_MSG = "Submission service provider must exist for primary service in the dunning cycle row ";
    public static final int PPC_MISSING_NPSERVICE = 4327;
    public static final String PPC_MISSING_NPSERVICE_MSG = "Submission service provider must exist for non-primary service in the dunning cycle row ";
    public static final int PPC_PCOLLECTIONS_LASTROW = 4328;
    public static final String PPC_PCOLLECTIONS_LASTROW_MSG ="Primary collection service must be the last dunning cycle";
    public static final int PPC_NPCOLLECTIONS_LASTROW = 4329;
    public static final String PPC_NPCOLLECTIONS_LASTROW_MSG ="Non-Primary collection service must be the last dunning cycle";
    public static final int PPC_MULTICOLLS_PSERVICE = 4330;
    public static final String PPC_MULTICOLLS_PSERVICE_MSG ="Only one primary collection service is allowed per payor";
    public static final int PPC_MULTICOLLS_NPSERVICE = 4331;
    public static final String PPC_MULTICOLLS_NPSERVICE_MSG ="Only one non-primary collection service is allowed per payor";
    public static final int PPC_PYR_MOD_SPLIT_PYR_NO_PYR_SPECIFIED = 4332;
    public static final String PPC_PYR_MOD_SPLIT_PYR_NO_PYR_SPECIFIED_MSG = "You must specify a payor to bill for this modifier.";
    public static final int PPC_PYR_MOD_SPLIT_PYR_MOD_ALREADY_SPECIFIED = 4333;
    public static final String PPC_PYR_MOD_SPLIT_PYR_MOD_ALREADY_SPECIFIED_MSG = "Modifier already splits to payor";
    public static final int PPC_DUP_PYR_GRP_MOD_SPLIT_PYR = 4334;
    public static final String PPC_DUP_PYR_GRP_MOD_SPLIT_PYR_MSG = "A duplicate group modifier for split to payor was entered";
    public static final int PPC_GRP_MODIFIER_BILL_TO_PAYOR_NOT_FOUND = 4335;
    public static final String PPC_GRP_MODIFIER_BILL_TO_PAYOR_NOT_FOUND_MSG = "A group modifier for split to payor was not found";
    public static final int PPC_ERROR_SUBMITTING_DATA = 4336;
    public static final String PPC_ERROR_SUBMITTING_DATA_MSG = "A database error occurred while trying to submit the data";
    public static final int PPC_GRP_MODIFIER_BILL_PAYOR_NOT_FOUND = 4336;
    public static final String PPC_GRP_MODIFIER_BILL_PAYOR_NOT_FOUND_MSG = "The group modifier split payor was not found";
    public static final int PPC_NO_GAPS_IN_DUNNING_CYCLE = 4337;
    public static final String PPC_NO_GAPS_IN_DUNNING_CYCLE_MSG = "Gaps are not allowed in the submission cycle sequence.";
    public static final int PPC_PYR_FAC_NO_CHRG_EXCL_ALREADY_SPECIFIED = 4338;
    public static final String PPC_PYR_FAC_NO_CHRG_EXCL_ALREADY_SPECIFIED_MSG = "Facility is already excluded";
    public static final int PPC_PYR_FAC_NO_CHRG_EXCL_INVALID_DATE = 4339;
    public static final String PPC_PYR_FAC_NO_CHRG_EXCL_INVALID_DATE_MSG = "Missing or Invalid Date";
    public static final int PPC_PYR_FAC_NO_CHRG_EXCL_INVALID_FAC = 4340;
    public static final String PPC_PYR_FAC_NO_CHRG_EXCL_INVALID_FAC_MSG = "Facility is required";
    public static final int PPC_PYR_TAX_TYP = 4341;
    public static final String PPC_PYR_TAX_TYP_MSG = "Invalid Tax Type";
    public static final int ACD_PYR_ID_ATTCH_REQ = 4342;
    public static final String ACD_PYR_ID_ATTCH_REQ_MSG = "Payor is not configured for Claim Attachments. Selected Attachment Types have been cleared for Payor - ";
    public static final int PPC_INVALID_DX_RANGE = 4343;
    public static final String PPC_INVALID_DX_RANGE_MSG = "Invalid diagnosis range.";
    public static final int PPC_INVALID_DX_CODE = 4344;
    public static final String PPC_INVALID_DX_CODE_MSG = "Invalid diagnosis code.";
    public static final int PPC_INVALID_DX_OVERLAP = 4345;
    public static final String PPC_INVALID_DX_OVERLAP_MSG = "An overlapping diagnosis code or range for the same payor is not allowed.";
    public static final int PPC_INVALID_SPLIT_PYR = 4346;
    public static final String PPC_INVALID_SPLIT_PYR_MSG = "A payor cannot split to itself.";
    public static final int PPC_DIAG_CODE_REQUIRED = 4347;
    public static final String PPC_DIAG_CODE_REQUIRED_MSG = "Diagnosis Code Range is required.";
    public static final int PPC_REF_PHYS_ID_REQUIRED = 4348;
    public static final String PPC_REF_PHYS_ID_REQUIRED_MSG = "Referring physician ID cannot be blank.";
    public static final int PPC_DIAG_BILL_TO_PAYOR_ILLEGAL = 4349;
    public static final String PPC_DIAG_BILL_TO_PAYOR_ILLEGAL_MSG = "Diagnosis Bill To Payor cannot be the same as the payor.";
    public static final int PPC_SUBM_SVC_PROVIDER_INVALID_FAC = 4350;
    public static final String PPC_SUBM_SVC_PROVIDER_INVALID_FAC_MSG = "Submission service provider requires a facility ID.";
    public static final int PPC_CLEARINGHOUSE_REQUIRED = 4351;
    public static final String PPC_CLEARINGHOUSE_REQUIRED_MSG = "Clearinghouse ID required for electronic submission services.";
    public static final int PPC_CLEARINGHOUSE_INVALID = 4352;
    public static final String PPC_CLEARINGHOUSE_INVALID_MSG = "Clearinghouse ID contains invalid characters ";
    public static final int PPC_DUP_SUBM_SERVICE_PROVIDER = 4353;
    public static final String PPC_DUP_SUBM_SERVICE_PROVIDER_MSG = "Duplicate Facility and Service ID not allowed";
    public static final int PPC_PYR_NOT_ALLOWED = 4354;
    public static final String PPC_PYR_NOT_ALLOWED_MSG = " belongs to either the Client or Patient payor group and cannot be entered.";
    public static final int PPC_INVALID_DAYS_UNTIL_NEXT_CYCLE = 4355;
    public static final String PPC_INVALID_DAYS_UNTIL_NEXT_CYCLE_MSG = "Days until next cycle cannot be zero except for the last cycle.";
    public static final int PPC_MISSING_MANUAL_DEMAND_SUBM_SVC = 4356;
    public static final String PPC_MISSING_MANUAL_DEMAND_SUBM_SVC_MSG = "Manual Demand Submission Service is required.";
    public static final int PPC_MULTIPLE_DEFAULT_PT_PMT_PLAN_DUNS = 4357;
    public static final String PPC_MULTIPLE_DEFAULT_PT_PMT_PLAN_DUNS_MSG = "More than one patient payment plan default dun was found for this payor.";

    // Client Demographics Error Codes - Shipping address
    public static final int    MISSING_CLNDEMO_SHIPPHN = 4500;
    public static final String MISSING_CLNDEMO_SHIPPHN_MSG = "Missing shipping phone number";
    public static final int INVALID_CLNDEMO_SHIPPHN  = 4501;
    public static final String INVALID_CLNDEMO_SHIPPHN_MSG  = "Invalid shipping contact phone number";
    public static final int INVALID_CLNDEMO_SHIPFAX  = 4502;
    public static final String INVALID_CLNDEMO_SHIPFAX_MSG  = "Invalid shipping address fax number";
    public static final int REQUIRED_CLNDEMO_SHIPADDR1  = 4503;
    public static final String REQUIRED_CLNDEMO_SHIPADDR1_MSG  = "Missing shipping address 1 required";
    public static final int    INVALID_CLNDEMO_SHIPZIP_ID = 4504;
    public static final String INVALID_CLNDEMO_SHIPZIP_ID_MSG = "Shipping zip code is either missing or invalid";
    public static final int    CONFLICT_CLNDEMO_SHIPZIP_STATE = 4505;
    public static final String CONFLICT_CLNDEMO_SHIPZIP_STATE_MSG = "Shipping zip code conflicts with the state";

    // OE 5000-5999
    public static final int OE_NO_LIMITED_COVERAGE = 5000;
    public static final String OE_NO_LIMITED_COVERAGE_MSG = "There are no limited coverage procedures ordered for this row.\n";

    public static final int OE_NO_TEST = 5001;
    public static final String OE_NO_TEST_MSG = "There is no "+test+" defined for this row.\n";

    public static final int OE_ABN_REC_ERROR = 5002;
    public static final String OE_ABN_REC_ERROR_MSG = "Error occurred while setting ABN received.\nVerify data.";
    // OE 5000-5999

    //Client Payor Exclusions 6000 - 6099
    //public static final int REQUIRED_PYR_EFF_DT = 6002;
    //public static final String REQUIRED_PYR_EFF_DT_MSG = "A Payor effective date is required ";

    public static final int REQUIRED_PYR_GRP_EFF_DT = 6004;
    public static final String REQUIRED_PYR_GRP_EFF_DT_MSG = "Payor Group effective date is required ";

    public static final int DUP_PYR_EXCL = 6005;
    public static final String DUP_PYR_EXCL_MSG = "Duplicate Payor Exclusion found with the same Payor ID, Client ID, and Effective Date";

    public static final int DUP_PYR_GRP_EXCL = 6006;
    public static final String DUP_PYR_GRP_EXCL_MSG = "Duplicate Payor Group Exclusion found with the same Payor Group ID, Client ID, and Effective Date";

    public static final int OVERLAP_PYR_EXCL = 6007;
    public static final String OVERLAP_PYR_EXCL_MSG = "Payor Exclusions found that overlap effective periods.  Modify the exclusions to not overlap.";

    public static final int OVERLAP_PYR_GRP_EXCL = 6008;
    public static final String OVERLAP_PYR_GRP_EXCL_MSG = "Payor Group Exclusions found that overlap effective periods.  Modify the group exclusions to not overlaps.";

    // Client Transaction Detail 6010-6200
    public static final int REQUIRED_ADJ_DT = 6100;
    public static final String REQUIRED_ADJ_DT_MSG = "Adjustment date is required";

    public static final int FUTURE_ADJ_DT_INVALID = 6102;
    public static final String FUTURE_ADJ_DT_INVALID_MSG = "Adjustment date cannot be in the future.";

    public static final int PAST_ADJ_DT_INVALID = 6103;
    public static final String PAST_ADJ_DT_INVALID_MSG = "Adjustment date cannot fall before the start of the current accounting period.";

    public static final int REQUIRED_REV_ADJ_ACCN = 6015;
    public static final String REQUIRED_REV_ADJ_ACCN_MSG = "A "+accession+" ID is required for this revenue adjustment.";

    public static final int INVALID_REV_ADJ_ACCN = 6017;
    public static final String INVALID_REV_ADJ_ACCN_MSG = "The "+accession+" ID is invalid for this revenue adjustment.";

    public static final int REQUIRED_AMT = 6010;
    public static final String REQUIRED_AMT_MSG = "Adjustment amount is required";

    public static final int CTD_VIEW_STMT_SVC_NOT_DEFINED = 6011;
    public static final String CTD_VIEW_STMT_SVC_NOT_DEFINED_MSG = "Cannot generate statement.  No submission service is defined for the client. Please setup the submission service for the client in Client Submissions Configuration.";
    public static final int CANT_VIEW_STMT_NO_ACTIVITY = 6012;
    public static final String CANT_VIEW_STMT_NO_ACTIVITY_MSG = "There is no activity for the Current Statement.";
    public static final int CANT_PRINT_STMT_FOR_CLN_NO_ACTIVITY = 6013;
    public static final String CANT_PRINT_STMT_FOR_CLN_NO_ACTIVITY_MSG = "has no activity for the month and has a 0.00 balance due";
    public static final int CANT_PRINT_STMT_FOR_NEW_CLN_NO_ACTIVITY = 6014;
    public static final String CANT_PRINT_STMT_FOR_NEW_CLN_NO_ACTIVITY_MSG = "is a new client and has no activity";
    public static final int CTD_VIEW_EXCEL_STMT_SVC_NOT_DEFINED = 6015;
    public static final String CTD_VIEW_EXCEL_STMT_SVC_NOT_DEFINED_MSG = "Cannot generate statement.  No Excel submission service is defined for the client. Please setup the Excel submission service for the client in Client Submissions Configuration.";


    public static final int EXCEL_ERR_SYS_SETTINGS = 6016;
    public static final String EXCEL_ERR_SYS_SETTINGS_MSG = "System settings are not set up correctly for Excel Reports.";
    public static final int EXCEL_ERR_SUBMSVC = 6017;
    public static final String EXCEL_ERR_SUBMSVC_MSG = "Submission Service/Webidoc is not configured correctly.";
    public static final int EXCEL_ERR_DATES = 6018;
    public static final String EXCEL_ERR_DATES_MSG = "Dates for report are invalid.";
    public static final int EXCEL_ERR_REPORT = 6019;
    public static final String EXCEL_ERR_REPORT_MSG = "There was a problem processing the report.";
    public static final int NO_CONFIGURED_FOR_PDF_OR_EXCEL_STATEMENTS = 6020;
    public static final String NO_CONFIGURED_FOR_PDF_OR_EXCEL_STATEMENTS_MSG = "The following clients are not configured for Pdf or Excel statements: ";

    // Accn Demo Other 6201-6250
    public static final int REQ_QUESTION = 6201;
    public static final String REQ_QUESTION_MSG = "A question is required with a response.";
    public static final int REQ_RESPONSE = 6202;
    public static final String REQ_RESPONSE_MSG = "A response is required with a question.";
    public static final int INVALID_CLN_SPEC_QUES_RESP_PATTERN = 6203;
    public static final int REQ_CLN_SPEC_QUES_RESP = 6204;
    public static final String REQ_CLN_SPEC_QUES_RESP_MSG = "No Response to required Client Specific Question ";
    public static final int RECOMMENDED_CLN_SPEC_QUES_RESP = 6205;
    public static final String RECOMMENDED_CLN_SPEC_QUES_RESP_MSG = "No Response to recommended Client Specific Question ";


    // Phys Lic Config 6251-6300
    public static final int DUP_STATE = 6251;
    public static final String DUP_STATE_MSG = "Duplicate State.";
    public static final int REQ_STATE = 6252;
    public static final String REQ_STATE_MSG = "State ID required.";
    public static final int REQ_LIC = 6253;
    public static final String REQ_LIC_MSG = "License # required.";
    public static final int REQ_SUB_UPIN = 6254;
    public static final String REQ_SUB_UPIN_MSG = "Submission UPIN required.";
    public static final int INVALID_PYR_ID = 6255;
    public static final String INVALID_PYR_ID_MSG = "Invalid Payor ID.";
    public static final int DUP_LIC_PYR_ID = 6256;
    public static final String DUP_LIC_PYR_ID_MSG = "Duplicate License Payor ID.";
    public static final int REQ_PYR_ID = 6257;
    public static final String REQ_PYR_ID_MSG = "Payor ID required.";
    public static final int INVALID_PYR_GRP_ID = 6258;
    public static final String INVALID_PYR_GRP_ID_MSG = "Invalid Payor Group ID.";
    public static final int DUP_PYR_GRP_ID = 6259;
    public static final String DUP_PYR_GRP_ID_MSG = "Duplicate Payor Group ID.";
    public static final int REQ_PYR_GRP_ID = 6260;
    public static final String REQ_PYR_GRP_ID_MSG = "Payor Group ID required.";
    public static final int EXCLUSION_DATE_OVERLAP = 6261;
    public static final String EXCLUSION_DATE_OVERLAP_MSG = "Exclusion date ranges overlap for same payor.";
    public static final int PUE_START_DT = 6262;
    public static final String PUE_START_DT_MSG = "Payor UPIN Exclusion effective date after expiration date.";
    public static final int PGUE_START_DT = 6263;
    public static final String PGUE_START_DT_MSG = "Payor Group UPIN Exclusion effective date after expiration date.";
    public static final int PGUE_L_NM = 6264;
    public static final String PGUE_L_NM_MSG = "Last Name required.";
    public static final int PGUE_F_NM = 6265;
    public static final String PGUE_F_NM_MSG = "First Name required.";
    public static final int PGUE_ADDR1 = 6266;
    public static final String PGUE_ADDR1_MSG = "Address 1 required.";
    public static final int PGUE_ZIP = 6267;
    public static final String PGUE_ZIP_MSG = "Zip code required.";
    public static final int PGUE_CRED = 6268;
    public static final String PGUE_CRED_MSG = "Credential required.";
    public static final int PGUE_SPEC = 6269;
    public static final String PGUE_SPEC_MSG = "Specialty required.";
    public static final int KEY_CHANGE_DELETE = 6272;
    public static final String KEY_CHANGE_DELETE_MSG = "In order to delete an existing row, the key value must not be changed.";
    public static final int PGUE_EFF_DT = 6275;
    public static final String PGUE_EFF_DT_MSG = "Payor Group Exclusion effective date is required.";
    public static final int INVALID_PYR_CLN_LIC_ID = 6276;
    public static final String INVALID_PYR_CLN_LIC_ID_MSG = "Invalid Payor ID - A payor must be added to the Affiliated Licenses Grid before it can be added to the Specific Affiliated Licenses Grid.";
    public static final int DUP_LIC_CLN_ID = 6277;
    public static final String DUP_LIC_CLN_ID_MSG = "Duplicate Payor ID/Client ID record was added to the Client Specific Affiliated Licenses grid.";
    public static final int DUP_PROC_CD_ID = 6278;
    public static final String DUP_PROC_CD_ID_MSG = "Duplicate Proc Code was entered.  Second occurrence of this Proc Code has been removed.";
    public static final int PGUE_INVALID_L_NM = 6279;
    public static final String PGUE_INVALID_L_NM_MSG = "Invalid Last Name.";
    public static final int PGUE_INVALID_F_NM = 6280;
    public static final String PGUE_INVALID_F_NM_MSG = "Invalid First Name.";
    public static final int INVALID_PHYS_XREF = 6281;
    public static final String INVALID_PHYS_XREF_MSG = "Invalid XREF, please re-enter or use the XREF search window.";
    public static final int INVALID_SINGLE_USE_PHYS_XREF = 6283;
    public static final String INVALID_SINGLE_USE_PHYS_XREF_MSG = "This cross reference member may only be assigned to one physician.";
    public static final int MISSING_PHYS_XREF = 6284;
    public static final String MISSING_PHYS_XREF_MSG = "Missing XREF, please re-enter or use the XREF search window.";
    public static final int MISSING_UPIN_FOR_PHYS = 6285;
    public static final String MISSING_UPIN_FOR_PHYS_MSG = "Physician UPIN not on file in our UPIN Directory.  Please enter a valid UPIN.";
    public static final int DUPLICATE_NPI_FOR_PHYS = 6286;
    public static final String DUPLICATE_NPI_FOR_PHYS_MSG = "Physician NPI cannot be assigned to more than one physician. Please validate NPI";
    public static final int DUPLICATE_UPIN_FOR_PHYS = 6287;
    public static final String DUPLICATE_UPIN_FOR_PHYS_MSG = "This UPIN is already in use by another physician. Please enter a valid UPIN";
    public static final int DELETE_FAIL_ACCNPHYS_LINKED = 6288;
    public static final String DELETE_FAIL_ACCNPHYS_LINKED_MSG = "This Physician may not be deleted - "+Accession+"s still associated with this physician";
    public static final int DELETE_FAIL_CLIENT_LINKED = 6289;
    public static final String DELETE_FAIL_CLIENT_LINKED_MSG = "This Physician may not be deleted - Currently assigned by a client";
    public static final int OIG_START_DATE = 6290;
    public static final String OIG_START_DATE_MSG = "OIG Exclusion effective date after expiration date.";
    public static final int OIG_OVERLAP_DATE = 6291;
    public static final String OIG_OVERLAP_DATE_MSG = "OIG Exclusion date ranges overlap.";
    public static final int PYR_TAXONOMY_EFF_AFTER_EXP = 6292;
    public static final String PYR_TAXONOMY_EFF_AFTER_EXP_MSG = "Payor taxonomy exclusion effective date after expiration date.";
    public static final int PYR_GRP_TAXONOMY_EFF_AFTER_EXP = 6293;
    public static final String PYR_GRP_TAXONOMY_EFF_AFTER_EXP_MSG = "Payor group taxonomy exclusion effective date after expiration date.";
    public static final int OVERLAPPING_PAYOR_EXCLUSION = 6294;
    public static final String OVERLAPPING_PAYOR_EXCLUSION_MSG = "Exclusion date ranges overlap for same payor.";
    public static final int OVERLAPPING_PAYOR_GROUP_EXCLUSION = 6295;
    public static final String OVERLAPPING_PAYOR_GROUP_EXCLUSION_MSG = "Exclusion date ranges overlap for same payor group.";
    public static final int INVALID_POSTAL_CODE = 10404;
    public static final String INVALID_POSTAL_CODE_MSG = "An invalid postal code was entered";
    public static final int PGUE_POSTAL_CODE = 10405;
    public static final String PGUE_POSTAL_CODE_MSG = "Postal code required.";

    // this is an odd case where the state ID is imported (from globan NPI table for example) and it doesn't exist in the state table
    public static final int INVALID_STATE = 6299;
    public static final String INVALID_STATE_MSG = "The state on this physician address is not valid, so it has been cleared.  Click Submit again to save changes.";

    // Accn/Cln Notes & Promise Pmts 6300-6351
    public static final int INVALID_CONTACT_DT = 6300;
    public static final String INVALID_CONTACT_DT_MSG = "Invalid Contact Date: ";
    public static final int INVALID_FOLLOW_UP_DT = 6301;
    public static final String INVALID_FOLLOW_UP_DT_MSG = "Invalid Follow-up Date: ";
    public static final int REQ_USER = 6302;
    public static final String REQ_USER_MSG = "User ID is required";
    public static final int REQ_CONTACT_DT = 6303;
    public static final String REQ_CONTACT_DT_MSG = "Contact Date is required";
    public static final int REQ_CONTACT_INFO = 6304;
    public static final String REQ_CONTACT_INFO_MSG = "Notes or Contact Info is required";
    public static final int REQ_NOTE = 6305;
    public static final String REQ_NOTE_MSG = "Printable Notes are required";
    public static final int INVALID_AMT_DUN_CYCLE = 6306;
    public static final String INVALID_AMT_DUN_CYCLE_MSG = "Invalid Amount/Dunning Cycle";
    public static final int REQ_AMT_DUN_CYCLE = 6307;
    public static final String REQ_AMT_DUN_CYCLE_MSG = "Amount/Dunning Cycle is required";
    public static final int REQ_NEXT_STMT_DT = 6308;
    public static final String REQ_NEXT_STMT_DT_MSG = "Next Statement Date is required";
    public static final int INVALID_NEXT_STMT_DT = 6309;
    public static final String INVALID_NEXT_STMT_DT_MSG = "Invalid Next Statement Date Date: ";
    public static final int REQ_FOLLOW_UP_USER = 6310;
    public static final String REQ_FOLLOW_UP_USER_MSG = "Follow-up individual is required";
    public static final int REQ_DUE_DT = 6311;
    public static final String REQ_DUE_DT_MSG = "Due Date is required";
    public static final int INVALID_DUE_DT = 6312;
    public static final String INVALID_DUE_DT_MSG = "Invalid Due Date: ";
    public static final int INVALID_SETTLMNT_PCT = 6313;
    public static final String INVALID_SETTLMNT_PCT_MSG = "Invalid Settlement %: ";
    public static final int REQ_PP_AMT = 6314;
    public static final String REQ_PP_AMT_MSG = "Promise Payment Amount is required";
    public static final int INVALID_PP_AMT = 6315;
    public static final String INVALID_PP_AMT_MSG = "Invalid Promise Payment Amount: ";
    public static final int REQ_PMT_SCHED = 6316;
    public static final String REQ_PMT_SCHED_MSG = "Payment Schedule is required";
    public static final int REQ_DELVRY_MTHD = 6317;
    public static final String REQ_DELVRY_MTHD_MSG = "A Delivery Method is required when follow-up correspondence is selected";
    public static final int MULTIPLE_PROMS_PMT = 6318;
    public static final String MULTIPLE_PROMS_PMT_MSG = "It is invalid to have multiple active promise payments plans.  Unwanted plans must be marked void.";
    public static final int INVALID_PMT_NUM = 6319;
    public static final String INVALID_PMT_NUM_MSG = "Invalid # Pmt: ";
    public static final int MAX_PMT_NUM = 6320;
    public static final String MAX_PMT_NUM_MSG = "Number of payments cannot exceed: ";
    public static final int MIN_PMT_AMT = 6321;
    public static final String MIN_PMT_AMT_MSG = "Amount of payment cannot be less than: ";
    public static final int REQ_SETTLMNT_PRC_SUSP = 6322;
    public static final String REQ_SETTLMNT_PRC_SUSP_MSG = "To calculate a settlement percent, the client account must have the Suspend Pricing check box checked for both client and non-client pricing.";
    public static final int CLN_NO_BALANCE = 6323;
    public static final String CLN_NO_BALANCE_MSG = "A payment plan cannot be created for a client with no balance.";
    public static final int INVALID_PMT_SCHED = 6324;
    public static final String INVALID_PMT_SCHED_MSG = "The payment schedule you created cannot be completed by the due date. To correct this error do any one of the following: change the number of payments,  change the schedule selection or change the due date to a later date.";
    public static final int INVALID_STMNT_RESCHED = 6325;
    public static final String INVALID_STMNT_RESCHED_MSG = "No procs exist on this "+accession+".  A patient statement cannot be rescheduled.";
    public static final int REQ_PP_PLAN = 6326;
    public static final String REQ_PP_PLAN_MSG = "Please select a valid Plan Status. \nNote: Only one Promise Payment Plan can be active (current) at one time.";
    public static final int REQ_CREATE_USER = 6327;
    public static final String REQ_CREATE_USER_MSG = "Promise Payment Create User ID is required";
    public static final int INVALID_PP_CONTACT_DT = 6328;
    public static final String INVALID_PP_CONTACT_DT_MSG = "Invalid Promise Payment Contact Date: ";
    public static final int REQ_PP_CONTACT_DT = 6329;
    public static final String REQ_PP_CONTACT_DT_MSG = "Promise Payment Contact Date is required";
    public static final int INVALID_PP_CONTACT_UP_DT = 6330;
    public static final String INVALID_PP_CONTACT_UP_DT_MSG = "Invalid Promise Payment Contact Date. \nContact dates set in the future are not allowed.";
    public static final int INVALID_PP_SYS_SETTING = 6331;
    public static final String INVALID_PP_SYS_SETTING_MSG = "System error occurred while loading accn proms pmt sys setting. Please contact your System Administrator.";
    public static final int INVALID_PP_PMT_AMT = 6332;
    public static final String INVALID_PP_PMT_AMT_MSG = "System error occurred while calculating pymnt amt, please try again or contact your System Administrator.";
    public static final int MISSING_PP_PMT_AMT = 6333;
    public static final String MISSING_PP_PMT_AMT_MSG = "System Setting used for calculating promise pymnt amts is missing, please contact your System Administrator.";
    public static final int MISSING_PT_PYRS = 6334;
    public static final String MISSING_PT_PYRS_MSG = "Patient is not a payor for this "+accession+".";
    public static final int NO_NOTE_REC_SELECTED = 6335;
    public static final String NO_NOTE_REC_SELECTED_MSG = "Copy note to other clients failed : No note has been selected to copy";
    public static final int NOTE_CPY_CLN_NOTFND = 6336;
    public static final String NOTE_CPY_CLN_NOTFND_MSG = "Client record for copy not found - ID : ";
    public static final int PP_AMT_TOO_LARGE= 6337;
    public static final String PP_AMT_TOO_LARGE_MSG = "Promise Payment Amount is too large.";
    public static final int REQ_FOLLOW_UP_USER_AND_FOLLOW_UP_DT = 6338;
    public static final String REQ_FOLLOW_UP_USER_AND_FOLLOW_UP_DT_MSG = "Follow-up Date and Follow-up Person must be completed together or left blank.";
    public static final int CANNOT_SUBMIT_PT_DUE_TO_NO_PROCS_ASSIGNED_TO_PT_PYR = 6339;
    public static final String CANNOT_SUBMIT_PT_DUE_TO_NO_PROCS_ASSIGNED_TO_PT_PYR_MSG = "No procedure codes are pointing to a patient payor";
    public static final int FOLLOW_UP_DT_OUT_OF_RANGE = 6340;
    public static final String FOLLOW_UP_DT_OUT_OF_RANGE_MSG = "Follow-up Date selected must be between %s and %s";
    public static final int FOLLOW_UP_DT_BEFORE_MIN_DATE = 6341;
    public static final String FOLLOW_UP_DT_BEFORE_MIN_DATE_MSG = "Follow-up Date selected must be on or after %s";
    public static final int FOLLOW_UP_DT_AFTER_MAX_DATE = 6342;
    public static final String FOLLOW_UP_DT_AFTER_MAX_DATE_MSG = "Follow-up Date selected must be on or before %s";
    public static final int CONTACT_DATE_IS_FUTURE_DATE = 6344;
    public static final String CONTACT_DATE_IS_FUTURE_DATE_MSG = "Contact Date selected must be today or before.";
    public static final int FOLLOW_UP_DT_REQUIRED_FOR_MANUAL_ACTIVITY_CODE = 6345;
    public static final String FOLLOW_UP_DT_REQUIRED_FOR_MANUAL_ACTIVITY_CODE_MSG = "Follow-up Date is required for the selected Manual Activity Code: %s";

    // Doc Maintenance 6400-6450
    public static final int DOC_ID_REQ  = 6400;
    public static final String DOC_ID_REQ_MSG = "Doc ID is required.";
    public static final int DOC_ABBRV_REQ  = 6402;
    public static final String DOC_ABBRV_REQ_MSG = "Doc ID is required.";
    public static final int DOC_TYP_REQ = 6404;
    public static final String DOC_TYP_REQ_MSG = "Doc Type is required.";
    public static final int DOC_DESCR_REQ = 6406;
    public static final String DOC_DESCR_REQ_MSG = "Description is required.";
    public static final int DOC_TEXT_REQ = 6408;
    public static final String DOC_TEXT_REQ_MSG = "Text is required.";
    public static final int DOC_DELETE = 6410;
    public static final String DOC_DELETE_MSG = "Deleting a document still used in Dunning Cycle not allowed.";
    public static final int DOC_SEQ_ERR = 6411;
    public static final String DOC_SEQ_ERR_MSG = "Error occurred creating document id. Please try again.";
    public static final int DOC_TYP_MAX_ERR = 6412;
    public static final String DOC_TYP_MAX_ERR_MSG1 = "Only one template is allowed for document type: ";
    public static final int DOC_CLNDRCTLTR_DELETE = 6413;
    public static final String DOC_CLNDRCTLTR_DELETE_MSG = "This document is being used by System Logic and cannot be deleted. Please Contact XIFIN Customer Service.";

    public static final String DOC_TYP_MAX_ERR_MSG2 = "This document will not be saved. Please update or delete the existing current document: ";
    public static final int DOC_TYP_NOTES_ERR = 6414;
    public static final String DOC_TYP_NOTES_ERR_MSG = "The maximum of characters allowed in text field is 4000 characters with type notes.";
    public static final int DOC_TYP_APPEAL_DOCUMENT = 6415;
    public static final String DOC_TYP_APPEAL_DOCUMENT_ERR_MSG = "The maximum of characters allowed in text field is 28000 characters with type appeal document.";
    public static final int DOC_TYP_OTHERS_ERR = 6416;
    public static final String DOC_TYP_OTHERS_ERR_MSG = "The maximum of characters allowed in text field is 12000 characters";
    public static final int DOC_PYR_APPEAL_FILE_NAME_REQ = 6417;
    public static final String DOC_PYR_APPEAL_FILE_NAME_REQ_MSG = "Payor Appeal Document is required.";

    // Accn Transaction Detail 6451-6500
    public static final int PMT_REQ = 6451;
    public static final String PMT_REQ_MSG = "A payment amount is required.";
    public static final int EXP_DT_REQ = 6452;
    public static final String EXP_DT_REQ_MSG = "An expiration date is required.";
    public static final int CC_NM_REQ = 6453;
    public static final String CC_NM_REQ_MSG = "A Cardholder name is required.";
    public static final int CC_NUM_REQ = 6454;
    public static final String CC_NUM_REQ_MSG = "A Credit Card number is required.";
    public static final int PMT_INVALID = 6455;
    public static final String PMT_INVALID_MSG = "Invalid payment amount: ";
    public static final int EXP_DT_INVALID = 6456;
    public static final String EXP_DT_INVALID_MSG = "Invalid expiration date: ";
    public static final int CC_NUM_INVALID = 6457;
    public static final String CC_NUM_INVALID_MSG = "Invalid credit card number";
    public static final int PULL_SUBM_SVC_REQ = 6473;
    public static final String PULL_SUBM_SVC_REQ_MSG = "A pull client statement submission service id is required.";

    public static final int CHECK_NUM_REQ = 6458;
    public static final String CHECK_NUM_REQ_MSG = "A check number is required.";
    public static final int ADJ_AMT_REQ = 6459;
    public static final String ADJ_AMT_REQ_MSG = "An adjustment amount is required.";
    public static final int ADJ_AMT_INVALID = 6460;
    public static final String ADJ_AMT_INVALID_MSG = "Invalid adjustment amount: ";
    public static final int TEST_DIAG_CD_REQ = 6461;
    public static final String TEST_DIAG_CD_REQ_MSG = null; // CR31816
    public static final int DIAG_CNTCT_REQ = 6462;
    public static final String DIAG_CNTCT_REQ_MSG = "A new diagnosis requires a contact date and or a doc. received or client contact";
    public static final int ABN_UNP_ERR = 6463;
    public static final String ABN_UNP_ERR_MSG = "Changes resulting in unpriceable payor exclusion errors from limited coverage logic are not allowed.";
    public static final int NO_ADJ_PMT_REPRICE = 6464;
    public static final String NO_ADJ_PMT_REPRICE_MSG = "Adjustments and/or Payments cannot be made in conjunction with modifier changes which will trigger a reprice.";
    public static final int NO_ADJ_PT_ADD = 6465;
    public static final String NO_ADJ_PT_ADD_MSG = "Adjustments cannot be made in conjunction with adding a patient payor.  Please change the payor to patient and submit first.";
    public static final int ADJ_AMT_TOO_GREAT = 6466;
    public static final String ADJ_AMT_TOO_GREAT_MSG = "Adjustment amount cannot exceed the expect price of the "+accession+".";
    public static final int NO_PYRS = 6467;
    public static final String NO_PYRS_MSG = "No payor is on "+accession+", please enter payor via Order Entry.";
    public static final int ORDERED_TESTS_ERR = 6468;
    public static final String ORDERED_TESTS_ERR_MSG = "  Please use '"+Accession+" "+Test+" Update' to view and correct "+accession+".";
    public static final int TRAVEL_FEE_MILAGE_ERR = 6469;
    public static final String TRAVEL_FEE_MILAGE_ERR_MSG = "The Travel Fee Mileage value must be a postive number: ";
    public static final int TRAVEL_FEE_STOPS_ERR = 6470;
    public static final String TRAVEL_FEE_STOPS_ERR_MSG = "The Travel Fee "+Phlebotomy+" Stops value must be a postive integer: ";
    public static final int TRAVEL_FEE_PT_COUNT_ERR = 6471;
    public static final String TRAVEL_FEE_PT_COUNT_ERR_MSG = "The Travel Fee Patient Count value must be a postive integer: ";
    public static final int TRAVEL_FEE_PT_COUNT_STOPS_ERR = 6472;
    public static final String TRAVEL_FEE_PT_COUNT_STOPS_ERR_MSG = "The Travel Fee Patient Count must not be less than the number of "+Phlebotomy+" Stops";
    public static final int UNPOSTABLE_PAYMENT_ON_ACCN = 6474;
    public static final String UNPOSTABLE_PAYMENT_ON_ACCN_MSG = "The posting of this "+accn+" payment failed : ";
    public static final int DELETED_DX_CODE_ON_ACCN = 6475;
    public static final String DELETED_DX_CODE_ON_ACCN_MSG = "Deleted diagnosis code : ";

    // PyrGrpDemoGrpcs Needs More ErroCodes(Added New Requirements) 6500-6520

    public static final int PYR_GRP_DUN_SUB_CNT = 6500;
    public static final String PYR_GRP_DUN_SUB_CNT_MSG = " Required Subm Count.";
    public static final int PYR_GRP_DUN_CYCLE = 6501;
    public static final String PYR_GRP_DUN_CYCLE_MSG = " Required PyrGrpDun Cycle.";
    public static final int PYR_GRP_DUN_DAYS = 6502;
    public static final String PYR_GRP_DUN_DYAS_MSG = " Required PyrGrpDun Days.";
    public static final int PYR_GRP_DUN_SRVC_ID = 6503;
    public static final String PYR_GRP_DUN_SRVC_ID_MSG = " Required Primary Service ID.";
    public static final int PYR_GRP_DUN_NON_SRVC_ID = 6504;
    public static final String PYR_GRP_DUN_NON_SRVC_ID_MSG = " Required Non-Primary Service ID.";
    public static final int PYR_GRP_DEMAND_FMT = 6505;
    public static final String PYR_GRP_DEMAND_FMT_MSG = " Required Manual Demand Format.";
    public static final int PYR_GRP_MIN_STMT = 6506;
    public static final String PYR_GRP_MIN_STMT_MSG = " Required Minimum Statement.";
    public static final int PYR_GRP_DUN_INVALID_DAYS = 6507;
    public static final String PYR_GRP_DUN_INVALID_DAYS_MSG= "Days to Next Cycle Can't be Zero ";
    public static final int PYR_GRP_DUN_DELETE = 6508;
    public static final String PYR_GRP_DUN_DELETE_MSG= "Can't Delete All Cycles, Required at least one Default Cycle ";
    public static final int PYR_GRP_DUN_MULTIPLE_PT_PMT_PLAN_DEFAULT_DUNS = 6509;
    public static final String PYR_GRP_DUN_MULTIPLE_PT_PMT_PLAN_DEFAULT_DUNS_MSG = "More than one default patient payment plan dun was found for Patient Payor Group";



    // PyrDemoGrp and PyrDemo Need More ErrorCodes(Added New Requirements) 6521-6530
    public static final int PYR_GRP_INVALID_EFF_DT = 6521;
    public static final String PYR_GRP_INVALID_EFF_DT_MSG= "Invalid Effective Date ";
    public static final int PYR_GRP_INVALID_EFF_DATE = 6522;
    public static final String PYR_GRP_INVALID_EFF_DATE_MSG= "Can't Change Effective Date";
    public static final int DUPLICATE_CLN_BILLING_CATEGORY = 6523;
    public static final String DUPLICATE_CLN_BILLING_CATEGORY_MSG = "Duplicate Client Billing Category is not allowed";

    // AccnStmnt 6531-6549
    public static final int ACN_STMNT_STMNT = 6531;
    public static final String ACN_STMNT_STMNT_MSG= "Only one statement allowed.";
    public static final int ACN_STMNT_FORMAT = 6532;
    public static final String ACN_STMNT_FORMAT_MSG= "Format not supported.";
    public static final int ACN_STMNT_REQ = 6533;
    public static final String ACN_STMNT_REQ_MSG= "Statement required.";
    public static final int ACN_LTTR_REQ = 6534;
    public static final String ACN_LTTR_REQ_MSG= "Appeal Letter required.";
    public static final int ACN_NOTES_REQ = 6535;
    public static final String ACN_NOTES_REQ_MSG= "Notes required.";
    public static final int ACN_STMNT_INVALID_PYR_PRIO = 6536;
    public static final String ACN_STMNT_INVALID_PYR_PRIO_MSG = "Invalid payor priority.";
    public static final int ACN_STMNT_INVALID_PYR_ID = 6537;
    public static final String ACN_STMNT_INVALID_PYR_ID_MSG = "Invalid Payor ID.";
    public static final int ACN_STMNT_OVERRIDE_CD_REQ = 6538;
    public static final String ACN_STMNT_OVERRIDE_CD_REQ_MSG= "Override Code Required.";
    public static final int ACN_STMNT_PRICED_ACCNS_ALLOWED_REQ = 6539;
    public static final String ACN_STMNT_PRICED_ACCNS_ALLOWED_REQ_MSG= "Only priced "+accession+"s allowed for single statements and appeal letters.";
    public static final int ACN_STMNT_APPEAL_LTR_ERROR = 6540;
    public static final String ACN_STMNT_APPEAL_LTR_ERROR_MSG= "Error creating appeal letter.";
    // EpDunLtr 6550-6599
    public static final int DUN_CYCL_REQ = 6550;
    public static final String DUN_CYCL_REQ_MSG= "Both client and patient should have at least one dunning cycle in the system.";
    public static final int LTR_CNT_REQ = 6551;
    public static final String LTR_CNT_REQ_MSG= "Letter Count required.";
    public static final int DOC_REQ = 6552;
    public static final String DOC_REQ_MSG= "Document required.";
    public static final int DAYS_REQ = 6553;
    public static final String DAYS_REQ_MSG= "Days to Next Letter required.";
    public static final int CYCL_SEQ = 6554;
    public static final String CYCL_SEQ_MSG= "Letter count must follow a non-breaking sequence.";
    public static final int DUP_LTR_CNT = 6555;
    public static final String DUP_LTR_CNT_MSG= "Duplicate Letter Count.";
    public static final int INVALID_DAYS = 6556;
    public static final String INVALID_DAYS_MSG= "Only numbers are allowed in Days to Next Letter field.";
    public static final int DAYS_MAX_VALUE = 6557;
    public static final String DAYS_MAX_VALUE_MSG= "The Days to Next Letter field should not exceed 9 digits.";

    //6560 - 6565: MarsMessage
    public static final int MARS_MESSAGE_INVALID_USER = 6560;
    public static final String MARS_MESSAGE_INVALID_USER_MSG= "Invalid User ID";

    //6570 - 6579: Payor procedure code consolidation rules
    public static final int PPCC_RADIO_REQUIRES_DIAG = 6570;
    public static final String PPCC_RADIO_REQUIRES_DIAG_MSG = "Diagnosis radio button selection requires diagnosis code(s).";
    public static final int PPCC_RADIO_REQUIRES_NO_DIAG = 6571;
    public static final String PPCC_RADIO_REQUIRES_NO_DIAG_MSG = "Diagnosis radio button requires no diagnosis code(s).";
    public static final int PPCC_REQ_NOT_IN_LINK = 6572;
    public static final String PPCC_REQ_NOT_IN_LINK_MSG = " procedure code requirement is not found in the link table.";
    public static final int PPCC_LINK_NOT_IN_REQ = 6573;
    public static final String PPCC_LINK_NOT_IN_REQ_MSG = " procedure code/mod link is not found in the requirements table.";
    public static final int PPCC_RESULT_NOT_IN_LINK = 6574;
    public static final String PPCC_RESULT_NOT_IN_LINK_MSG = " results procedure code is not found in either link table.";
    public static final int PPCC_LINK_NOT_IN_RESULT = 6575;
    public static final String PPCC_LINK_NOT_IN_RESULT_MSG = " procedure code link is not found in the results table.";
    public static final int PPCC_LEVELI_MIN_CPT_OUT_OF_RANGE = 6576;
    public static final String PPCC_LEVELI_MIN_CPT_OUT_OF_RANGE_MSG= "Level I MIN # CPT must be less than or equal to the number of procedures in the consolidation rule.";
    public static final int PPCC_LEVELII_MIN_CPT_OUT_OF_RANGE = 6577;
    public static final String PPCC_LEVELII_MIN_CPT_OUT_OF_RANGE_MSG= "Level II MIN # CPT must be less than or equal to the number of procedures in the consolidation rule.";
    public static final int PPCC_NO_AUTOCHEM_TYPE_PROC_COD = 6578;
    public static final String PPCC_NO_AUTOCHEM_TYPE_PROC_COD_MSG= "No autochem procedure code requirement is linked to the consolidation procedure code of type autochem.";
    public static final int PPCC_AT_LEAST_ONE_PROC_MUST_HAVE_MIN_SVCS_GREATER_THAN_ZERO = 6579;
    public static final String PPCC_AT_LEAST_ONE_PROC_MUST_HAVE_MIN_SVCS_GREATER_THAN_ZERO_MSG = "At least one procedure in the Level ? requirements grid must have a minimum number of services that is greater than zero.";
    public static final int PPCC_MIN_CPT_OUT_OF_RANGE_PROCS_NO_MIN_VAL = 6580;
    public static final String PPCC_MIN_CPT_OUT_OF_RANGE_PROCS_NO_MIN_VAL_MSG = "Level ? minimum match input must be greater than the number of procedures that have a minimum number of services that is zero or empty.";
    public static final int PPCC_REQ_MOD_IS_NOT_ALLOWED = 6581;
    public static final String PPCC_REQ_MOD_IS_NOT_ALLOWED_MSG = "Modifier consolidation is disabled, but a mod is applied to a requirement.";
    public static final int PPCC_LINK_MOD_IS_NOT_ALLOWED = 6582;
    public static final String PPCC_LINK_MOD_IS_NOT_ALLOWED_MSG = "Modifier consolidation is disabled, but a mod is applied to a link.";
    public static final int PPCC_RESULT_MOD_IS_NOT_ALLOWED = 6583;
    public static final String PPCC_RESULT_MOD_IS_NOT_ALLOWED_MSG = "Modifier consolidation is disabled, but a mod is applied to a result.";
    public static final int PPCC_LEVELS_REQUIRED = 6584;
    public static final String PPCC_LEVELS_REQUIRED_MSG = "At least one level should be defined.";
    public static final int PPCC_ATLEAST_ONE_REQ_REQUIRED = 6585;
    public static final String PPCC_ATLEAST_ONE_REQ_REQUIRED_MSG = "At least one Requirement is required at level ";
    public static final int PPCC_ATLEAST_ONE_LINK_REQUIRED = 6586;
    public static final String PPCC_ATLEAST_ONE_LINK_REQUIRED_MSG = "At least one Link is required at level ";
    public static final int PPCC_NUMBER_OF_SERVICES_DIFFERENT = 6587;
    public static final String PPCC_NUMBER_OF_SERVICES_DIFFERENT_MSG = "Number of services are different at level ";
    public static final int PPCC_NO_DIAG_FOR_LC_DX = 6588;
    public static final String PPCC_NO_DIAG_FOR_LC_DX_MSG = "No diagnosis available to exclude LC Dx";
    public static final int PPCC_NO_CONS_DESCR = 6589;
    public static final String PPCC_NO_CONS_DESCR_MSG = "Consolidation rule description is required.";
    public static final int PPCC_DUP_CONS_RESULT = 6590;
    public static final String PPCC_DUP_CONS_RESULT_MSG = "Consolidation results can't have duplicate proc and mod combination.";
    public static final int PPCC_DUP_DIAG_CD = 6591;
    public static final String PPCC_DUP_DIAG_CD_MSG = "Duplicate diagnosis codes are not allowed.";
    public static final int PPCC_DUP_CLN_ACCT_TYPS = 6592;
    public static final String PPCC_DUP_CLN_ACCT_TYPS_MSG = "Duplicate client account types are not allowed.";
    public static final int PPCC_DUP_CONS_REQ = 6593;
    public static final String PPCC_DUP_CONS_REQ_MSG = ":Consolidation requirements can't have duplicate proc and mod combination at level ?.";
    public static final int PPCC_DUP_CONS_PROC_REQ = 6594;
    public static final String PPCC_DUP_CONS_PROC_REQ_MSG = ":Consolidation links can't have duplicate proc and mod combination at level ?.";
    public static final int PPCC_DUP_MOD_CONS_RESULT = 6595;
    public static final String PPCC_DUP_MOD_CONS_RESULT_MSG = ":Consolidation requirements can't have duplicate modifiers.";
    public static final int PPCC_DUP_MOD_CONS_LNK = 6596;
    public static final String PPCC_DUP_MOD_CONS_LNK_MSG = ":Consolidation links can't have duplicate modifiers at level ?.";
    public static final int PPCC_CONS_DESCR_ALPHA_NUMERIC = 6597;
    public static final String PPCC_CONS_DESCR_ALPHA_NUMERIC_MSG = "Consolidation description is invalid.";
    public static final int PPCC_CONS_MIN_UNIT_TOO_BIG = 6598;
    public static final String PPCC_CONS_MIN_UNIT_TOO_BIG_MSG = "Minimum units can't exceed total of max number of services at level ?.";
    public static final int PPCC_MIN_PT_AGE_MORE_THAN_MAX_PT_AGE = 6599;
    public static final String PPCC_MIN_PT_AGE_MORE_THAN_MAX_PT_AGE_MSG = "Minimum Patient Age cannot be greater than Maximum Patient Age";

    //6600 - 6699: Payments
    public static final    int PMT_RECORD_NOT_FOUND = 6600;
    public static final String PMT_RECORD_NOT_FOUND_MSG = " record(s) not found.";
    public static final    int PMT_INVALID_ACCN_STATUS = 6601;
    public static final String PMT_INVALID_ACCN_STATUS_MSG = "Invalid "+accession+" status for payment posting.";
    public static final    int PMT_PAID_AMTS = 6603;
    public static final String PMT_PAID_AMTS_MSG = "Paid amounts do not match.";
    public static final    int PMT_INVALID_DEP_REMIT_DATE = 6605;
    public static final String PMT_INVALID_DEP_REMIT_DATE_MSG = "Invalid deposit date.";
    public static final    int PMT_DEP_AMT = 6606;
    public static final String PMT_DEP_AMT_MSG = "Deposit Amount does not equal sum of batch amounts.";
    public static final    int PMT_BANK = 6607;
    public static final String PMT_BANK_MSG = "A bank has not been selected.";
    public static final    int PMT_REQUIRED = 6608;
    public static final String PMT_REQUIRED_MSG = "input is required.";
    public static final    int PMT_DEP_REMIT_DATE_ERR = 6609;
    public static final String PMT_DEP_REMIT_DATE_ERR_MSG = "Unable to verify if deposit date is during current accounting period.";
    public static final    int PMT_DEP_REMIT_DATE = 6610;
    public static final String PMT_DEP_REMIT_DATE_MSG = "Deposit date cannot be in the future.";
    public static final    int PMT_NON_AR_AMT = 6611;
    public static final String PMT_NON_AR_AMT_MSG = "Non AR Amount requires a GL code and note.";
    public static final    int PMT_ADJ_AMT_CODE = 6612;
    public static final String PMT_ADJ_AMT_CODE_MSG = "Adjustment amount requires adjustment code ";
    public static final    int PMT_CHK_AMT = 6613;
    public static final String PMT_CHK_AMT_MSG = "Enter a positive check amount.";
    public static final    int PMT_ADJ_CD_REV = 6614;
    public static final String PMT_ADJ_CD_REV_MSG = Accession+" ID can only be entered for revenue adjustment codes.";
    public static final    int PMT_CONTAINS_NO_INFO = 6615;
    public static final String PMT_CONTAINS_NO_INFO_MSG = "Payment must contain a paid amount, copay amount, deductible amount or a denial code.";
    public static final    int PMT_UNITS_PD = 6616;
    public static final String PMT_UNITS_PD_MSG = "Units paid cannot be partial units ";
    public static final    int PMT_ALLOW_EOB = 6617;
    public static final String PMT_ALLOW_EOB_MSG = "The allowed amount cannot exceed the billed amount ";
    public static final    int PMT_ADJ_EOB = 6618;
    public static final String PMT_ADJ_EOB_MSG = "The adjustment amount cannot exceed the billed amount ";
    public static final    int PMT_DEDUCT_ALLOW = 6619;
    public static final String PMT_DEDUCT_ALLOW_MSG = "The deductible amount cannot exceed the allowed amount ";
    public static final    int PMT_COPAY_ALLOW = 6620;
    public static final String PMT_COPAY_ALLOW_MSG = "The copay amount cannot exceed the allowed amount ";
    public static final    int PMT_DEPOSIT_ID = 6621;
    public static final String PMT_DEPOSIT_ID_MSG = " is an invalid deposit ID.";
    public static final    int PMT_CLN_PRC_ACCN = 6622;
    public static final String PMT_CLN_PRC_ACCN_MSG = "Client priced "+accession+"s are not valid for non client payments.";
    public static final    int PMT_PT_PYR_LAST = 6623;
    public static final String PMT_PT_PYR_LAST_MSG = "This "+accession+" has non-patient payors between or after patient " +
            "payors, which is not allowed.  Please correct the payor priorities before entering payments on this "+accession+".";
    public static final    int PMT_MISSING_PROC = 6624;
    public static final String PMT_MISSING_PROC_MSG = "Payment Infomation for missing procedure code ";
    public static final    int PMT_NO_SYSTEM_DATE = 6625;
    public static final String PMT_NO_SYSTEM_DATE_MSG = "Unable to assign fixed date to new errors.";
    public static final    int PMT_PT_PYR_FIRST = 6626;
    public static final String PMT_PT_PYR_FIRST_MSG = "Primary payor cannot be patient if batch payor is not patient.";
    public static final    int PMT_ERR_CLN_INV = 6627;
    public static final String PMT_ERR_CLN_INV_MSG = "Unable to retrieve invoices, check client configuration.";
    public static final    int PMT_DEP_WITH_BATCHES_NO_DELETION = 6628;
    public static final String PMT_DEP_WITH_BATCHES_NO_DELETION_MSG = "Deposit cannot be deleted because it has already been applied to one or more "+accession+"s.";
    public static final    int PMT_PAID_COPAY_DED_ALLOW = 6629;
    public static final String PMT_PAID_COPAY_DED_ALLOW_MSG = "Unless an override code is given, the total of the paid amount, deductible, co-pay, and patient responsibility must equal the allowed amount ";
    public static final    int PMT_DEP_BATCH_NON_AR_AMT_POSTING_ERROR = 6630;
    public static final String PMT_DEP_BATCH_NON_AR_AMT_POSTING_MSG = "An error occurred while posting the non-AR amount";
    public static final    int PMT_DEP_BATCH_RECALC_ERROR = 6631;
    public static final String PMT_DEP_BATCH_RECALC_ERROR_MSG = "An error occurred while validating batch totals";
    public static final    int PMT_CLN_NO_REPRICE_ADJ = 6632;
    public static final String PMT_CLN_NO_REPRICE_ADJ_MSG = "The REPRICE adjustment code is for internal use only and cannot be assigned by the user.";
    public static final    int PMT_REAS_CODE_REQD_FOR_NOT_FULLY_PAID = 6633;
    public static final String PMT_REAS_CODE_REQD_FOR_NOT_FULLY_PAID_MSG = "An override code is required because the balance due does not equal the sum of the deductible, co-pay, and patient responsibility amounts for procedure code ";
    public static final    int PMT_REAS_CODE_NOT_VALID = 6634;
    public static final String PMT_REAS_CODE_NOT_VALID_MSG = "Reason code not valid";
    public static final    int PMT_INVALID_MODIFER = 6635;
    public static final String PMT_INVALID_MODIFER_MSG = "Invalid modifier. ";
    public static final    int PMT_REAS_CODE_ABBREV_MISSING = 6636;
    public static final String PMT_REAS_CODE_ABBREV_MISSING_MSG = "Reason code abbreviation is required.";
    public static final    int PMT_REAS_CODE_SHORTDESC_MISSING = 6637;
    public static final String PMT_REAS_CODE_SHORTDESC_MISSING_MSG = "Reason code short description is required.";
    public static final    int PMT_DUPLICATE_KEY = 6638;
    public static final String PMT_DUPLICATE_KEY_MSG = "Multiple payments exist for same grid row.";
    public static final    int PMT_NO_DETAIL_ENTERED = 6639;
    public static final String PMT_NO_DETAIL_ENTERED_MSG = "At least one client or suspense payment is required.";
    public static final    int PMT_REAS_CODE_EXISTS = 6640;
    public static final String PMT_REAS_CODE_EXISTS_MSG = "Reason code already exists.";
    public static final    int PMT_EXP_ADJ_EXCEPTION = 6641;
    public static final String PMT_EXP_ADJ_EXCEPTION_MSG = "An unexpected exception prevented the system from " +
            "calculating the expect adjustment amount.  If the problem persists, please contact customer support.";
    public static final    int PMT_PT_RESP_ALLOW = 6642;
    public static final String PMT_PT_RESP_ALLOW_MSG = "The patient responsibility amount cannot exceed the allowed amount ";
    public static final    int PMT_DEP_NEED_BATCH = 6643;
    public static final String PMT_DEP_NEED_BATCH_MSG = "A deposit needs at least one batch.";
    public static final    int PMT_CLN_BATCH_HAS_PMTS = 6644;
    public static final String PMT_CLN_BATCH_HAS_PMTS_MSG = "Non-client payments exist. Please delete existing payments or create a new batch for the Client payor. Batch ID: ";
    public static final    int PMT_CONALL_SETTING_ISSUE = 6645;
    public static final String PMT_CONALL_SETTING_ISSUE_MSG = "CONALL Settings issue, please contact customer support.";
    public static final    int PMT_NONCLN_BATCH_HAS_CLN_PMTS = 6646;
    public static final String PMT_NONCLN_BATCH_HAS_CLN_PMTS_MSG = "Client payments exist. Please delete existing payments or create a new batch for the non-client payor. Batch ID: ";
    public static final    int PMT_NON_AR_AMT_AND_BATCH_AMT = 6647;
    public static final String PMT_NON_AR_AMT_AND_BATCH_AMT_MSG = "Zero Non-AR amount cannot be posted when Batch Amount is greater than zero";
    public static final    int PMT_NON_AR_AND_REMIT_ERR = 6648;
    public static final String PMT_NON_AR_AND_REMIT_ERR_MSG = "Post to Non-AR is not allowed for Balancing Batches in Remit Error status";
    public static final    int PMT_UNITS_PAID_NUMBER_FORMAT_ERR = 6649;
    public static final String PMT_UNITS_PAID_NUMBER_FORMAT_ERR_MSG = "Invalid number for units paid";
    public static final    int PMT_UNITS_PAID_NEGATIVE_NUMBER = 6650;
    public static final String PMT_UNITS_PAID_NEGATIVE_NUMBER_ERR_MSG = "Negative number for units paid is not allowed ";
    public static final    int PMT_UNITS_PAID_MORE_THAN_SUBMITTED_NUMBER = 6651;
    public static final String PMT_UNITS_PAID_MORE_THAN_SUBMITTED_ERR_MSG = "Units paid cannot be greater than the submitted units ";
    public static final    int PMT_UNITS_PAID_ZERO_NUMBER = 6652;
    public static final String PMT_UNITS_PAID_ZERO_NUMBER_ERR_MSG = "Units paid cannot be zero while the paid amount is non-zero ";
    public static final    int PMT_NON_AR_AMT_ERR = 6653;
    public static final String PMT_NON_AR_AMT_ERR_MSG = "Non AR Amount requires a GL code.";
    public static final    int PMT_POST_NON_AR_AMT_ERR = 6654;
    public static final String PMT_POST_NON_AR_AMT_ERR_MSG = "Post Non AR Amount requires a GL code and note.";
    public static final    int PMT_BANK_TRANS = 6655;
    public static final String PMT_BANK_TRANS_MSG = "Bank Transaction ID not found.";
    public static final int PMT_CHECK_NUM_REQUIRED = 6656;
    public static final String PMT_CHECK_NUM_REQUIRED_MSG = "Check Number is required.";
    public static final int PMT_PAID_AMT_REQUIRED = 6657;
    public static final String PMT_PAID_AMT_REQUIRED_MSG = "Paid amount cannot be 0.";
    public static final int PMT_INVALID_PAID_AMT = 6658;
    public static final String PMT_INVALID_PAID_AMT_MSG = "Paid amounts do not match.";
    public static final int PMT_INVALID_ADJ_AMT = 6659;
    public static final String PMT_INVALID_ADJ_AMT_MSG = " Adjustment amount cannot exceed the acceptable amount, ";
    public static final int PMT_INVALID_PYR_PRIO = 6660;
    public static final String PMT_INVALID_PYR_PRIO_MSG = "This " + accession + " already has maximum number of 9 payors.";
    public static final int    PMT_SINGLE_BANK_TRANS_AMT_GREATER_THAN_DEP_AMT = 6661;
    public static final String PMT_SINGLE_BANK_TRANS_AMT_GREATER_THAN_DEP_AMT_MSG = "Bank Transaction Amount cannot be greater than the Deposit Amount when there is one Bank Transaction ID assigned";
    public static final int    PMT_MULTIPLE_BANK_TRANS_AMTS_NOT_EQUAL_TO_DEP_AMT = 6662;
    public static final String PMT_MULTIPLE_BANK_TRANS_AMTS_NOT_EQUAL_TO_DEP_AMT_MSG = "Bank Transaction Amounts must equal the Deposit Amount when there is more than one Bank Transaction ID assigned";
    public static final int    PMT_RECONCILE_AMT_GREATER_THAN_BANK_TRANS_AMT = 6663;
    public static final String PMT_RECONCILE_AMT_GREATER_THAN_BANK_TRANS_AMT_MSG = "Reconcile Amount cannot be greater than the Bank Amount";
    public static final int    PMT_SUM_OF_ALL_RECONCILE_AMT_GREATER_THAN_DEP_AMT = 6664;
    public static final String PMT_SUM_OF_ALL_RECONCILE_AMT_GREATER_THAN_DEP_AMT_MSG = "Sum of all Reconcile Amount cannot exceed the Deposit Amount";

    //6700 - 6799: Client submission
    public static final int INVALID_SUBM_SVC = 6700;
    public static final String INVALID_SUBM_SVC_MSG = "Invalid submission service.";
    public static final int SUBM_DEL_NM_REQ = 6701;
    public static final String SUBM_DEL_NM_REQ_MSG = "Submission Delivery name required.";
    public static final int FAX_REQ = 6702;
    public static final String FAX_REQ_MSG = "FAX required.";
    public static final int EMAIL_REQ = 6703;
    public static final String EMAIL_REQ_MSG = "Email required.";
    public static final int NUM_COPIES_REQ = 6704;
    public static final String NUM_COPIES_REQ_MSG = "Number of copies required.";
    public static final int STMNT_FREQ_REQ = 6705;
    public static final String STMNT_FREQ_REQ_MSG = "Statement frequency required.";
    public static final int PULL_LIST_REQ = 6706;
    public static final String PULL_LIST_REQ_MSG = "Pull List Reason required.";
    public static final int SUBM_STMNT_REQ = 6707;
    public static final String SUBM_STMNT_REQ_MSG = "At least one Statement Copy required.";
    public static final int EP_DOC_REQ = 6708;
    public static final String EP_DOC_REQ_MSG = "Error Processing Document required.";
    public static final int LTTRS_REQ = 6709;
    public static final String LTTRS_REQ_MSG = "At least one Day to Print Letters is required.";
    public static final int CLN_STMNT_REQ = 6710;
    public static final String CLN_STMNT_REQ_MSG = "Client Statement is required.";
    public static final int INVALID_DUP_COPY_CLN = 6711;
    public static final String INVALID_DUP_COPY_CLN_MSG = "Duplicate client number";
    public static final int STMNT_FREQ_INV = 6712;
    public static final String STMNT_FREQ_INV_MSG = "Unable to change frequency type due to activity in the current submission period.  Change will take effect in the next accounting period.";
    public static final int MISSING_CORRESP_FAX = 6713;
    public static final String MISSING_CORRESP_FAX_MSG = "You must first specify a Correspondence Fax # via the Client Demographic Screen before you can specify a submission service with a delivery method of 'Fax' for ";
    public static final int MISSING_BILLING_FAX = 6714;
    public static final String MISSING_BILLING_FAX_MSG = "You must first specify a Billing Fax # via the Client Demographic Screen before you can specify a submission service with a delivery method of 'Fax' for ";

    //CR25011: add error codes for when daily charges notification is selected without freq of notification.
    public static final int MISSING_BILLING_EMAIL = 6715;
    public static final String MISSING_BILLING_EMAIL_MSG = "You must first specify an Email Address via the Client Demographic Screen before you can specify 'Email' as a delivery method for ";
    public static final int FREQ_OF_DAILY_CHARGES_NOTIF_REQ = 6716;
    public static final String FREQ_OF_DAILY_CHARGES_NOTIF_REQ_MSG = "You must specify the Frequency of Daily Charges Notification. ";
    public static final int DAILY_CHARGES_NOTIF_CREATION_PROBLEM = 6717;
    public static final String DAILY_CHARGES_NOTIF_CREATION_PROBLEM_MSG = "Unexpected problem occurred while generating the daily/weekly charges notification file.";
    public static final int DAILY_CHARGES_SUBM_SVC_NOTIF_REQ = 6718;
    public static final String DAILY_CHARGES_SUBM_SVC_NOTIF_REQ_MSG = "You must specify the Daily Charges Service ID. ";
    public static final int MISSING_BILLING_ZIP = 6719;
    public static final String MISSING_BILLING_ZIP_MSG = "You must first specify a Billing Zip via the Client Demographic Screen before you can add an additional client statement recipient.";

    //6750 - 6752: XREF Configuration jsp
    public static final int INVALID_XREF_ABBREV = 6744;
    public static final String INVALID_XREF_ABBREV_MSG = "Xref Member Abbrev is invalid";
    public static final int REQUIRED_XREF_MEMBER = 6745;
    public static final String REQUIRED_XREF_MEMBER_MSG = "At least one Xref Member is required";
    public static final int REQUIRED_XREF_MEMBER_DEFAULT = 6746;
    public static final String REQUIRED_XREF_MEMBER_DEFAULT_MSG = "At least one Xref Member should be set to default";
    public static final int INVALID_DUP_XREF = 6747;
    public static final String INVALID_DUP_XREF_MSG = "A Duplicate Xref Member was entered.";
    public static final int INVALID_XREF_MEMBER_DELETE = 6748;
    public static final int INVALID_XREF = 6749;
    public static final String INVALID_XREF_MSG = " The New Xref Member you entered currently exists, please re-enter.";
    public static final String INVALID_XREF_MEMBER_DELETE_MSG = "The Xref Member cannot be deleted. It is assigned to either an Adjustment(s), Client(s), UPIN(s), facility(s) or Payor(s). To delete an xref member:<BR> Delete where the Xref Member is assigned, then delete it from the grid here below.";
    public static final int REQUIRED_XREF_MEMBER_ABBRV = 6750;
    public static final String REQUIRED_XREF_MEMBER_ABBRV_MSG = "Xref Member Abbrev is required";
    public static final int REQUIRED_XREF_MEMBER_DESCR = 6751;
    public static final String REQUIRED_XREF_MEMBER_DESCR_MSG = "Xref Member Descr is required";
    public static final int XREF_XACTION_ROLLBACK_FATAL_ERROR = 2204;
    public static final String XREF_XACTION_ROLLBACK_FATAL_ERROR_MSG = "Fatal error while attempting to rollback transaction. Contact your system administrator.";

    //6800 - 6899: MedUnite Reporting
    public static final int REPORT_NOTE_REQ = 6800;
    public static final String REPORT_NOTE_REQ_MSG = "Note text is required.";

    //6900 - 6999: Accn audit
    public static final int INVALID_PT = 6900;
    public static final String INVALID_PT_MSG = "Patient record not found.";

    //7000 - 7020:Elig roster
    public static final int CLN_A = 7000;
    public static final String CLN_A_MSG = "This client is not editable.  You must use the parent client ";
    public static final int CLN_PRC_SUSP = 7001;
    public static final String CLN_PRC_SUSP_MSG = "Client pricing is suspended.";
    public static final int REQUIRED_REPORT_DATE  = 7002;
    public static final String REQUIRED_REPORT_DATE_MSG  = " Required Report Date";
    public static final int PERFORM_CENSUS_CHECKING  = 7003;
    public static final String PERFORM_CENSUS_CHECKING_MSG  = " not set up to perform eligibility census checking.";
    public static final int MAXIMUM_LARGE_SIZE  = 7004;
    public static final String MAXIMUM_LARGE_SIZE_MSG  = "File upload is too large.";

    //7020 - 7099:MARS Search Result Screens
    public static final int INVALID_SRCH_RSLT = 7020;
    public static final String INVALID_SRCH_RSLT_MSG = "Persistence of search data is not supported for this option or tab change.  A new search must be performed.";

    // 7300 - 7399: Refunds
    public static final int REFUND_ILLEGAL_CHG_AFTER_APPROVAL = 7300;
    public static final String REFUND_ILLEGAL_CHG_AFTER_APPROVAL_MSG = " cannot be changed after refund has been approved.";
    public static final int REFUND_ILLEGAL_CHG_AFTER_POSTING = 7301;
    public static final String REFUND_ILLEGAL_CHG_AFTER_POSTING_MSG = " cannot be changed after refund has been posted.";
    public static final int REFUND_ILLEGAL_ADJ_TYP = 7302;
    public static final String REFUND_ILLEGAL_ADJ_TYP_MSG = "The specified adjustment type is not allowed on refund type ";
    public static final int REFUND_NOT_APPROVED_NO_POSTING = 7303;
    public static final String REFUND_NOT_APPROVED_NO_POSTING_MSG = "Refund is not approved and cannot be posted.";
    public static final int REFUND_AMT_CANNOT_BE_ZERO = 7304;
    public static final String REFUND_AMT_CANNOT_BE_ZERO_MSG = "Refunds cannot be issued in the amount of $0.00.";
    public static final int REFUND_NO_ADJ_CD = 7305;
    public static final String REFUND_NO_ADJ_CD_MSG = "Cannot save a refund with no adjustment code.";
    public static final int REFUND_NO_PYR = 7306;
    public static final String REFUND_NO_PYR_MSG = "A refund must have either a payor specified or payee details entered.";
    public static final int REFUND_PT_PAYEE_ADDRESS_REQ = 7307;
    public static final String REFUND_PT_PAYEE_ADDRESS_REQ_MSG = "is required when refunding.";
    public static final int REFUND_PYR_ID_NOT_FOUND = 7308;
    public static final String REFUND_PYR_ID_NOT_FOUND_MSG = "The specified payor was not found.";
    public static final int REFUND_PYR_VALIDATION_ERROR = 7309;
    public static final String REFUND_PYR_VALIDATION_ERROR_MSG = "An unexpected error occurred while validating the payor on the refund.";
    public static final int REFUND_SUSP_PMT_NOT_FOUND = 7310;
    public static final String REFUND_SUSP_PMT_NOT_FOUND_MSG = "Specified suspense payment was not found.";
    public static final int REFUND_SUSP_PMT_ALREADY_REFUNDED = 7311;
    public static final String REFUND_SUSP_PMT_ALREADY_REFUNDED_MSG = "Cannot refund a suspense payment that has already been refunded.";
    public static final int REFUND_SUSP_PMT_ALREADY_ASSIGNED = 7312;
    public static final String REFUND_SUSP_PMT_ALREADY_ASSIGNED_MSG = "Cannot refund a suspense payment after it has been assigned or adjusted.";
    public static final int REFUND_SUSP_PMT_AMT_MUST_EQUAL_REFUND_AMT = 7313;
    public static final String REFUND_SUSP_PMT_AMT_MUST_EQUAL_REFUND_AMT_MSG = "Refund amount must be equal to suspense payment amount";
    public static final int REFUND_SUSP_PMT_LOAD_ERROR = 7314;
    public static final String REFUND_SUSP_PMT_LOAD_ERROR_MSG = "An unexpected problem occurred while refunding suspense ID ";
    public static final int REFUND_ACCN_NOT_FOUND = 7315;
    public static final String REFUND_ACCN_NOT_FOUND_MSG = Accession+" does not exist.";
    public static final int REFUND_ACCN_HAS_NO_PMTS = 7316;
    public static final String REFUND_ACCN_HAS_NO_PMTS_MSG = "No payments have been made on this "+accession+".";
    public static final int REFUND_ACCN_REFUND_EXCEEDS_PD_AMT = 7317;
    public static final String REFUND_ACCN_REFUND_EXCEEDS_PD_AMT_MSG = "The refund amount exceeds the payor's total paid amount (including earlier refunds) of ";
    public static final int REFUND_CLN_NO_PMTS = 7318;
    public static final String REFUND_CLN_NO_PMTS_MSG = "Client has not made any payments.";
    public static final int REFUND_CLN_REFUND_EXCEEDS_CLN_PMTS = 7319;
    public static final String REFUND_CLN_REFUND_EXCEEDS_CLN_PMTS_MSG = "The refund amount exceeds the client's balance (including unposted payments and adjustments) of $";
    public static final int REFUND_CANNOT_BE_REMOVED = 7320;
    public static final String REFUND_CANNOT_BE_REMOVED_MSG = "Refund cannot be removed ";
    public static final int REFUND_CANNOT_APPROVE_OWN_REFUND = 7321;
    public static final String REFUND_CANNOT_APPROVE_OWN_REFUND_MSG = "Users are not allowed to approve refunds that they created.";
    public static final int REFUND_CANNOT_DETERMINE_APPROVE_OWN_REFUND = 7322;
    public static final String REFUND_CANNOT_DETERMINE_APPROVE_OWN_REFUND_MSG = "Could not determine if users are allowed to approve refunds that they created.";
    public static final int REFUND_UNKNOWN_ERROR_WHILE_SAVING = 7323;
    public static final String REFUND_UNKNOWN_ERROR_WHILE_SAVING_MSG = "An unexpected error occurred while saving the refund.";
    public static final int REFUND_COULD_NOT_LOCK_REFUND = 7324;
    public static final String REFUND_COULD_NOT_LOCK_REFUND_MSG = "Could not lock the refund for updating.";
    public static final int REFUND_CANNOT_POST_IF_ADJ_UNPOSTED = 7325;
    public static final String REFUND_CANNOT_POST_IF_ADJ_UNPOSTED_MSG = "Cannot post refund because its associated adjustment has not been posted.";
    public static final int REFUND_CANNOT_POST_IF_ADJ_NOT_FOUND = 7326;
    public static final String REFUND_CANNOT_POST_IF_ADJ_NOT_FOUND_MSG = "Cannot post refund because its associated adjustment could not be found.";
    public static final int REFUND_CANNOT_POST_IF_SUSP_PMT_NOT_FOUND = 7327;
    public static final String REFUND_CANNOT_POST_IF_SUSP_PMT_NOT_FOUND_MSG = "Cannot post refund because its associated suspense payment could not be found.";
    public static final int REFUND_CANNOT_POST_IF_SUSP_PMT_NOT_POSTED = 7328;
    public static final String REFUND_CANNOT_POST_IF_SUSP_PMT_NOT_POSTED_MSG = "Cannot post refund because its associated suspense payment has not also been posted.";
    public static final int REFUND_CANNOT_DELETE_IF_ADJ_POSTED = 7329;
    public static final String REFUND_CANNOT_DELETE_IF_ADJ_POSTED_MSG = "Cannot remove refund because the associated adjustment has already been posted.";
    public static final int REFUND_NEG_ACCN_REFUND_EXCEEDS_REFUND_AMT = 7330;
    public static final String REFUND_NEG_ACCN_REFUND_EXCEEDS_REFUND_AMT_MSG = "The negative refund amount exceeds the payor's total refund amount of ";
    public static final int REFUND_NEG_CLN_REFUND_EXCEEDS_CLN_PMTS = 7331;
    public static final String REFUND_NEG_CLN_REFUND_EXCEEDS_CLN_PMTS_MSG = "The negative refund amount exceeds the client's total refund amount of $";
    public static final int REFUND_CANNOT_APPROVE_IF_ADJ_NOT_POSTED = 7332;
    public static final String REFUND_CANNOT_APPROVE_IF_ADJ_NOT_POSTED_MSG = "Cannot approve refund because its associated adjustment has not been posted.";
    public static final int REFUND_CANNOT_APPROVE_IF_ADJ_NOT_FOUND = 7333;
    public static final String REFUND_CANNOT_APPROVE_IF_ADJ_NOT_FOUND_MSG = "Cannot approve refund because its associated adjustment could not be found.";
    public static final int BATCH_CANNOT_REMOVE_REFUND_AFTER_POSTED = 7334;
    public static final String BATCH_CANNOT_REMOVE_REFUND_AFTER_POSTED_MSG = "Cannot remove a refund from a batch after the batch is posted.";
    public static final int BATCH_CANNOT_ADD_REFUND_AFTER_POSTED = 7335;
    public static final String BATCH_CANNOT_ADD_REFUND_AFTER_POSTED_MSG = "Cannot add a refund to a batch after the batch is posted.";
    public static final int BATCH_CANNOT_APPROVE_AFTER_POSTED = 7336;
    public static final String BATCH_CANNOT_APPROVE_AFTER_POSTED_MSG = "Cannot change a batch's approval status after the batch is posted.";
    public static final int BATCH_CANNOT_REMOVE_BATCH_AFTER_POSTED = 7337;
    public static final String BATCH_CANNOT_REMOVE_BATCH_AFTER_POSTED_MSG = "Cannot remove a batch after the batch is posted.";
    public static final int REFUND_NO_EDIT_NOT_LOCKED = 7338;
    public static final String REFUND_NO_EDIT_NOT_LOCKED_MSG = "Cannot modify refund because system was unable to lock it for editing.";
    public static final int BATCH_NO_EDIT_NOT_LOCKED = 7339;
    public static final String BATCH_NO_EDIT_NOT_LOCKED_MSG = "Cannot modify refund batch because system was unable to lock it for editing.";
    public static final int BATCH_EMPTY_WILL_DELETE_ON_SAVE = 7340;
    public static final String BATCH_EMPTY_WILL_DELETE_ON_SAVE_MSG = "This batch is empty.  Submitting will delete the batch.";
    public static final int REFUND_ILLEGAL_CHG_AFTER_SAVED = 7341;
    public static final String REFUND_ILLEGAL_CHG_AFTER_SAVED_MSG = " cannot be changed after refund has been created.";
    public static final int REFUND_COULD_NOT_LOAD_ACTIVITY = 7342;
    public static final String REFUND_COULD_NOT_LOAD_ACTIVITY_MSG = "The system was unable to validate prior activity for this account.";
    public static final int REFUND_BAD_CHECK_CLEARED_DATE = 7343;
    public static final String REFUND_BAD_CHECK_CLEARED_DATE_MSG = "An invalid check cleared date was entered.";
    public static final int BATCH_UNKNOWN_ERROR_WHILE_SAVING = 7344;
    public static final String BATCH_UNKNOWN_ERROR_WHILE_SAVING_MSG = "An unexpected error occurred while saving the batch.";
    public static final int BATCH_UNKNOWN_ERROR_WHILE_RESETTING = 7345;
    public static final String BATCH_UNKNOWN_ERROR_WHILE_RESETTING_MSG = "An unexpected error occurred while resetting the batch.  Please close all refund batch search windows and try your search again.";
    public static final int REFUND_CANNOT_DETERMINE_PRIOR_PMTS = 7346;
    public static final String REFUND_CANNOT_DETERMINE_PRIOR_PMTS_MSG = "The system was unable to calculate prior payments/refunds to validate the refund amount.";
    public static final int BATCH_POSTING_ROLLED_BACK = 7347;
    public static final String BATCH_POSTING_ROLLED_BACK_MSG = "Posting of the batch was aborted because not all refunds in the batch could be posted.";
    public static final int REFUND_UNKNOWN_ERROR_WHILE_REMOVING = 7348;
    public static final String REFUND_UNKNOWN_ERROR_WHILE_REMOVING_MSG = "An unexpected error occurred while removing the refund.";
    public static final int BATCH_UNKNOWN_ERROR_WHILE_SEARCHING = 7349;
    public static final String BATCH_UNKNOWN_ERROR_WHILE_SEARCHING_MSG = "An unexpected error occurred while searching for batches.  Please close all refund batch search windows and try your search again.";
    public static final int REFUND_UNKNOWN_ERROR_WHILE_SEARCHING = 7350;
    public static final String REFUND_UNKNOWN_ERROR_WHILE_SEARCHING_MSG = "An unexpected error occurred while searching for refunds.  Please close all refund search windows and try your search again.";
    public static final int REFUND_NOT_SAVED_RESULTS_CLOSED = 7351;
    public static final String REFUND_NOT_SAVED_RESULTS_CLOSED_MSG = "The refund could not be saved.  " +
            "This may happen when the search results window is closed or the search type is changed.  " +
            "Please close all search results windows and perform your search again.";
    public static final int REFUND_NOT_LOADED_RESULTS_CLOSED = 7352;
    public static final String REFUND_NOT_LOADED_RESULTS_CLOSED_MSG = "The refund could not be loaded.  " +
            "This may happen when the search results window is closed or the search type is changed.  " +
            "Please close all search results windows and perform your search again.";
    public static final int REFUND_BATCH_NOT_LOADED_RESULTS_CLOSED = 7353;
    public static final String REFUND_BATCH_NOT_LOADED_RESULTS_CLOSED_MSG = "The batch could not be loaded.  " +
            "This may happen when the search results window is closed or the search type is changed.  " +
            "Please close all search results windows and perform your search again.";
    public static final int REFUND_BATCH_NOT_SAVED_RESULTS_CLOSED = 7354;
    public static final String REFUND_BATCH_NOT_SAVED_RESULTS_CLOSED_MSG = "The batch could not be saved.  " +
            "This may happen when the search results window is closed or the search type is changed.  " +
            "Please close all search results windows and perform your search again.";
    public static final int REFUND_BATCH_FILE_CREATION_PROBLEM = 7355;
    public static final String REFUND_BATCH_FILE_CREATION_PROBLEM_MSG = "The batch cannot be posted because an unexpected problem occurred while " +
            "generating the refund file for accounts payable.";
    public static final int REFUND_BATCH_FILE_REQUIRED_FIELD_MISSING = 7356;
    public static final String REFUND_BATCH_FILE_REQUIRED_FIELD_MISSING_MSG = "Required field missing: ";
    public static final int REFUND_COULD_NOT_LOCK_ACCN = 7357;
    public static final String REFUND_COULD_NOT_LOCK_ACCN_MSG = "The refund could not be reversed because the "+accession+" is currently locked by user ";
    public static final int REFUND_COULD_NOT_LOCK_CLN = 7358;
    public static final String REFUND_COULD_NOT_LOCK_CLN_MSG = "The refund could not be reversed because the client is currently locked by user ";
    public static final int REFUND_COULD_NOT_LOCK_SUSP_PMT = 7359;
    public static final String REFUND_COULD_NOT_LOCK_SUSP_PMT_MSG = "The refund could not be reversed because the suspense payment is currently locked by user ";
    public static final int REFUND_BAD_CHECK_SENT_DATE = 7360;
    public static final String REFUND_BAD_CHECK_SENT_DATE_MSG = "An invalid check cleared date was entered.";
    public static final int REFUND_BAD_CHECK_SENT_AMT = 7361;
    public static final String REFUND_BAD_CHECK_SENT_AMT_MSG = "An invalid check sent amount was entered.";
    public static final int REFUND_MAIN_FAC_ERR = 7362;
    public static final String REFUND_MAIN_FAC_ERR_MSG = "Error processing bulk check payment. Cannot determine the main facility.";
    public static final int    UNAUTHORIZED_UPDATE_REFUND = 7363;
    public static final String UNAUTHORIZED_UPDATE_REFUND_MSG = "User does not have permission to update refund";
    public static final int REFUND_CLN_NOT_FOUND = 7364;
    public static final String REFUND_CLN_NOT_FOUND_MSG = "Client does not exist.";

    //7400 - 7500: Submission and Remittance File Maintenance
    public static final int SUBM_REMIT_FM_CANT_LOAD_REMIT_REPORTS = 7400;
    public static final String SUBM_REMIT_FM_CANT_LOAD_REMIT_REPORTS_MSG = "An error occurred while loading the remittance reports. Please contact the System Administrator.";

    // 7600-7650: Payor Coverage Limitation Req JSP
    public static final int PYR_COV_LIM_REQ_MULT_DIAG_UNEXPECTED_ERROR = 7600;
    public static final String PYR_COV_LIM_REQ_MULT_DIAG_UNEXPECTED_ERROR_MSG = "An unexpected error occurred saving the record.";
    public static final int PYR_COV_LIM_REQ_MULT_DIAG_BAD_DX = 7601;
    public static final String PYR_COV_LIM_REQ_MULT_DIAG_BAD_DX_MSG = "Invalid diagnosis code: ";
    public static final int PYR_COV_LIM_REQ_MULT_DIAG_NO_DX = 7602;
    public static final String PYR_COV_LIM_REQ_MULT_DIAG_NO_DX_MSG = "Diagnosis range not specified.";
    public static final int PYR_COV_LIM_REQ_MULT_DIAG_OUT_OF_ORDER = 7603;
    public static final String PYR_COV_LIM_REQ_MULT_DIAG_OUT_OF_ORDER_MSG = "Diagnosis range is out of order: ";
    public static final int PYR_COV_LIM_REQ_MULT_DIAG_BAD_FORMAT = 7604;
    public static final String PYR_COV_LIM_REQ_MULT_DIAG_BAD_FORMAT_MSG = "Invalid diagnosis format: ";
    public static final int PYR_COV_LIM_REQ_MULT_DIAG_DUPLICATE = 7605;
    public static final String PYR_COV_LIM_REQ_MULT_DIAG_DUPLICATE_MSG = "Duplicate diagnosis range: ";
    public static final int PYR_COV_LIM_REQ_MULT_DIAG_REQ_FIELD_MISSING = 7606;
    public static final String PYR_COV_LIM_REQ_MULT_DIAG_REQ_FIELD_MISSING_MSG = "Required field missing: ";
    public static final int PYR_COV_LIM_REQ_MULT_DIAG_REQ_DATES_OUT_OF_ORDER = 7607;
    public static final String PYR_COV_LIM_REQ_MULT_DIAG_REQ_DATES_OUT_OF_ORDER_MSG = "Effective/Expiration dates are out of order.";
    public static final int PYR_COV_LIM_REQ_MULT_DIAG_OVERLAP = 7608;
    public static final String PYR_COV_LIM_REQ_MULT_DIAG_OVERLAP_MSG = "Overlapping diagnosis/effective date range: ";
    public static final int PYR_COV_LIM_REQ_MULT_DIAG_NOT_LOCKED = 7609;
    public static final String PYR_COV_LIM_REQ_MULT_DIAG_NOT_LOCKED_MSG = "The lock was revoked while trying to save records.  Please try again.";
    public static final int PYR_COV_LIM_SLA_ID_REQ = 7610;
    public static final String PYR_COV_LIM_SLA_ID_REQ_MSG = "ID is required for Service Level Auth";
    public static final int PYR_COV_LIM_SLA_TYPE_REQ = 7611;
    public static final String PYR_COV_LIM_SLA_TYPE_REQ_MSG = "Type is required for Service Level Auth";
    public static final int PYR_COV_LIM_SLA_OVERLAP = 7612;
    public static final String PYR_COV_LIM_SLA_OVERLAP_MSG = "Service exists with an over-lapping effective date range";

    // 8800 - 8899: Electronic Payment
    public static final int     ELP_INVALID_KEY_FILE = 8800;
    public static final String ELP_INVALID_KEY_FILE_MSG = "Encryption key file was not found.";

    public static final int    ELP_UNSUPPORTED_GATEWAY = 8801;
    public static final String ELP_UNSUPPORTED_GATEWAY_MSG = "Payment gateway not supported from this screen";

    public static final int ELP_INVALID_URL = 8802;
    public static final String ELP_INVALID_URL_MSG = "Invalid url";

    public static final int ELP_INVALID_TEMPUS_GATEWAY_CONFIG_URL = 8803;
    public static final String ELP_INVALID_TEMPUS_GATEWAY_CONFIG_URL_MSG = "should not have any path variables";

    // 8300-8400: Procedure Code JSP
    public static final int    INVALID_SINGLE_USE_PROCCD_XREF = 8300;
    public static final String INVALID_SINGLE_USE_PROCCD_XREF_MSG = "This type of cross reference may only be assigned to one proc";
    public static final int REQUIRED_PROCCD_XREF_INFO = 8303;
    public static final String REQUIRED_PROCCD_XREF_INFO_MSG  = "Proc Code Xref Information is Required.";
    public static final int REQUIRED_PROCCD_XREF = 8301;
    public static final String REQUIRED_PROCCD_XREF_MSG  = "Proc Code Xref Type Required.";
    public static final int PROCCD_CONFLICT = 8302;
    public static final String PROCCD_CONFLICT_MSG  = "Procedure Code Data has expired. Please reselect ";

    //
    // Abbrevs, for the unbillable group error codes. tgo 02-Feb-2000  shouldn't be here!
    //
    // 8400-8500: Procedure Code JSP

    // 8400 - 8500: Upin <-> Phys synchronization problems.
    public static final int PHYS_UPIN_SYNC_FAILURE = 8400;
    public static final String PHYS_UPIN_SYNC_FAILURE_MSG = "Synchronization failure: UPIN and Physician records could not be synchronized.";
    public static final int MISSING_UPIN_REC_FOR_SYNC = 8401;
    public static final String MISSING_UPIN_REC_FOR_SYNC_MSG = "Synchronization failure: UPIN record not found for physician.";
    public static final int GENERIC_UPIN_SYNC_FAILURE = 8402;
    public static final String GENERIC_UPIN_SYNC_FAILURE_MSG = "Synchronization failure: UPIN record is generic.";
    public static final int PARENT_PHYSREC_MISSING = 8403;
    public static final String PARENT_PHYSREC_MISSING_MSG = "Synchronization failure: Physician record not found.";

    //FM-Phys Validation Errors
    public static final int FM_PHYS_INVALID_OVERRIDE_SVC_FAC = 8450;
    public static final String FM_PHYS_INVALID_OVERRIDE_SVC_MSG = "Invalid over-ride service facility location.";

    // 8500 - 8550 NPI errors and warnings
    public static final int NPI_INDIVIDUAL_TYP_WARNING = 8501;
    public static final String NPI_INDIVIDUL_TYP_WARNING_MSG = " is an Individual NPI.  Use Submit to assign Individual NPI to facility.";
    public static final int NPI_INDIVIDUAL_TYP_ERROR = 8503;
    public static final String NPI_INDIVIDUAL_TYP_ERROR_MSG = " is an individual NPI.  Use Physician License to setup the individual NPI before assigning to a facility.";

    public static final int NPI_INDIVIDUAL_TYP_CLIENT_WARNING = 8511;
    public static final String NPI_INDIVIDUL_TYP_CLIENT_WARNING_MSG = " is an Individual NPI.  Use Submit to assign Individual NPI to client.";
    public static final int NPI_INDIVIDUAL_TYP_CLIENT_ERROR = 8513;
    public static final String NPI_INDIVIDUAL_TYP_CLIENT_ERROR_MSG = " is an individual NPI.  Use Physician License to setup the individual NPI before assigning to a client.";

    public static final int NPI_NEW_ORGANIZATIONAL_NPI_WARNING = 8515;
    public static final String NPI_NEW_ORGANIZATIONAL_NPI_WARNING_MSG = "Warning: Organization NPI not found.  Submit to create a new organization NPI";

    public static final int NPI_ORGANIZATIONAL_NPI_TYP_ERROR = 8517;
    public static final String NPI_ORGANIZATIONAL_NPI_TYP_ERROR_MSG = " is an Organization NPI and cannot be assigned to an individual";

    //8600 - 8650 EOB Pyr Xref Errors for Pyr Demographics
    public static final int EPX_INVALID_EXT_PYR_ID = 8600;
    public static final String EPX_INVALID_EXT_PYR_ID_MSG = "Duplicate or Invalid Remit Payor ID ";
    public static final int EPX_DUP_DEFAULT_REMIT_PYR = 8601;
    public static final String EPX_DUP_DEFAULT_REMIT_PYR_MSG = "Payor _PyrAbbrv_ is set up as the default for Remit Payor ID :_EobExternalPyrId_. Remove that payor as the default before selecting a new payor as the default"; // This message will have the ? subsituted in.

    // Logo Configuration File Maintenance
    public static final int INVALID_FILE_TYPE = 8700;
    public static final String INVALID_FILE_TYPE_MSG = "Invalid file type. Please ensure that the file has one of the following valid image extensions: 'gif', 'jpeg', 'png', 'tiff', 'jpg'.";

    public static final int FILE_EXISTS = 8701;
    public static final String FILE_EXISTS_MSG = "File name already exists. Please specify a different file name or delete the existing one.";

    public static final int CANNOT_DELETE_CURRENT_LOGO = 8702;
    public static final String CANNOT_DELETE_CURRENT_LOGO_MSG = "Cannot delete current logo file. Please update the current logo before deleting this file.";

    public static final int CANNOT_DELETE_CLN_STMT_LOGO = 8703;
    public static final String CANNOT_DELETE_CLN_STMT_LOGO_MSG = "Cannot delete logo that is currently being used by client statements.";

    public static final int CANNOT_DELETE_EP_LTR_LOGO = 8704;
    public static final String CANNOT_DELETE_EP_LTR_LOGO_MSG = "Cannot delete logo that is currently being used by EP letters.";

    public static final int CANNOT_DELETE_FAC_LOGO = 8705;
    public static final String CANNOT_DELETE_FAC_LOGO_MSG = "Cannot delete logo that is currently being used by a facility.";

    public static final int SIZE_LIMIT_EXCEEDED = 8706;
    public static final String SIZE_LIMIT_EXCEEDED_MSG = "File exceeds size limit of 10 MB.";

    public static final int CANNOT_DELETE_APPEAL_LTR_LOGO = 8707;
    public static final String CANNOT_DELETE_APPEAL_LTR_LOGO_MSG = "Cannot delete logo that is currently being used by Appeal letters.";
    public static final int CANNOT_DELETE_ANNUAL_DISCLOSURE_LTR_LOGO = 8708;
    public static final String CANNOT_DELETE_ANNUAL_DISCLOSURE_LTR_LOGO_MSG = "Cannot delete logo that is currently being used by Annual Disclosure letters.";
    public static final int CANNOT_DELETE_WELCOME_LTR_LOGO = 8709;
    public static final String CANNOT_DELETE_WELCOME_LTR_LOGO_MSG = "Cannot delete logo that is currently being used by Welcome letters.";

    public static final int INVALID_FILE_NAME = 8710;
    public static final String INVALID_FILE_NAME_MSG = "File name contains invalid character(s). Please correct file name and upload again.";

    public static final int CANNOT_DISPLAY_LOGO = 8711;
    public static final String CANNOT_DISPLAY_LOGO_MSG = "Cannot display logo until main lab Correspondence Address/Default Remit To Address is completely setup.";

    public static final int CANNOT_DELETE_PATIENT_STMT_LOGO = 8712;
    public static final String CANNOT_DELETE_PATIENT_STMT_LOGO_MSG = "Cannot delete logo that is currently being used by Patient Statements.";


    //8800-8900 Elig Config JSP
    public static final int    INVALID_ELIG_SVC = 8800;
    public static final String INVALID_ELIG_SVC_MSG = "Invalid Eligibility Service.";

    public static final int    CANNOT_SELECT_ALLOW_SECONDARY = 88001;
    public static final String CANNOT_SELECT_ALLOW_SECONDARY_MSG = "Cannot select Allow for Secondary without Match Type ID.";

    public static final int    CANNOT_SELECT_ALLOW_UNMAPPED = 88002;
    public static final String CANNOT_SELECT_ALLOW_UNMAPPED_MSG = "Cannot select Allow Unmapped without Match Type ID.";

    public static final int    CANNOT_SELECT_ALLOW_UNMAPPED_FOR_DOD = 88003;
    public static final String CANNOT_SELECT_ALLOW_UNMAPPED_FOR_DOD_MSG= "Cannot select Allow Unmapped for Match Type ID Date of Death Before DOS.";

    public static final int CANNOT_POPULATE_RESPONSE_FOR_DOD = 88004;
    public static final String CANNOT_POPULATE_RESPONSE_FOR_DOD_MSG= "Response should be empty for Match Type ID Date of Death Before DOS.";

    public static final int    CANNOT_SELECT_BENEFIT_TYPE = 88005;
    public static final String CANNOT_SELECT_BENEFIT_TYPE_MSG= "Cannot select Benefit Type ID without Match Type ID.";

    public static final int SUBSCRIBER_DETAIL_BENEFIT_TYPE_NOT_VALID = 88006;
    public static final String SUBSCRIBER_DETAIL_BENEFIT_TYPE_NOT_VALID_MSG = "Subscriber Detail Benefit Type can only be used with ID Code Match Types.";

    // Extra Facility Demographic Error Codes for Web services
    public static final int FAC_DEMO_MAIN_LAB_EXISTS = 8901;
    public static final String FAC_DEMO_MAIN_LAB_EXISTS_MSG = "Main Facility already exists.";

    public static final int FAC_DEMO_PRIM_FAC_NOT_ALLOWED = 8902;
    public static final String FAC_DEMO_PRIM_FAC_NOT_ALLOWED_MSG = "Primary Facility can be entered only if Facility Type is Stat Lab.";

    public static final int FAC_DEMO_PRIM_FAC_INVALID = 8903;
    public static final String FAC_DEMO_PRIM_FAC_INVALID_MSG = "Primary Facility can only be a Main Facility or Remote Affiliate.";

    public static final int FAC_DEMO_BILLING_FAC_INVALID = 8904;
    public static final String FAC_DEMO_BILLING_FAC_INVALID_MSG = "Billing Facility can only be a Main Facility or Remote Affiliate.";

    // Payor Billing Rules Error Codes for XP
    public static final int THIRD_PARTY_BILL_TO_PYR_NOT_ALLOWED = 9000;
    public static final String THIRD_PARTY_BILL_TO_PYR_NOT_ALLOWED_MSG = "Bill Payor ID can only be Third Party Payors(non-patient and non-client).";

    public static final int SAME_BILL_TO_PYR_AS_RULE_ID_NOT_ALLOWED = 9001;
    public static final String SAME_BILL_TO_PYR_AS_RULE_ID_NOT_ALLOWED_MSG = "Bill Payor ID cannot be same as Payor Billing Rule ID.";

    public static final int THIRD_PARTY_PYR_BILLING_RULES_NOT_ALLOWED = 9002;
    public static final String THIRD_PARTY_PYR_BILLING_RULES_NOT_ALLOWED_MSG = "Payor Billing Rules are only applicable to Third Party Payors(non-patient and non-client).";

    public static final int PYR_BILLING_RULES_CIRPYR_ERROR = 9003;
    public static final String PYR_BILLING_RULES_CIRPYR_ERROR_MSG = "A Circular Payor error(PBRCIRPYR) was generated for payor priority";

    public static final int PYR_BILLING_RULES_DUPPYR_ERROR = 9004;
    public static final String PYR_BILLING_RULES_DUPPYR_ERROR_MSG = "A Duplicate Payor error(PBRDUPPYR) was generated for payor priority";

    public static final int ACCN_PYRS_NOT_FOUND = 9005;
    public static final String ACCN_PYRS_NOT_FOUND_MSG ="No payors found for "+accession;

    // Document Maintenance File Maintenance
    public static final int CANNOT_DELETE_RTF_IMAGE = 9100;
    public static final String CANNOT_DELETE_RTF_IMAGE_MSG = "The image <b>%s</b> is in use and cannot be deleted.";

    public static final int INVALID_PDF_FIELD_LENGTH = 9101;
    public static final String INVALID_PDF_FIELD_LENGTH_MSG = "Invalid field length";

    public static final int INVALID_PDF_ALPHABET_CHARS = 9102;
    public static final String INVALID_PDF_ALPHABET_CHARS_MSG = "The entered value needs to be a valid letter";

    public static final int INVALID_PDF_FIELD_X_CHAR = 9103;
    public static final String INVALID_PDF_FIELD_X_CHAR_MSG = "Please enter \"X\"";

    //Reason Code File Maintenance
    public static final int REQUIRED_ERRCDXREF = 10051;
    public static final String REQUIRED_ERRCDXREF_MSG = "Error Code Cross Reference Type Required.";
    public static final int REQUIRED_ERRCDXREF_DESCR = 10052;
    public static final String REQUIRED_ERRCDXREF_DESCR_MSG = "Reason Code Cross Reference Description Required";

    //User Account File Maintenance
    public static final int INVALID_USER_PHONE  = 10101;
    public static final String INVALID_USER_PHONE_MSG  = "Invalid user phone number";
    public static final int INVALID_USER_FAX  = 10102;
    public static final String INVALID_USER_FAX_MSG  = "Invalid user fax number";

    // PDF Setup - 10151 - 10200
    public static final int PDF_SETUP_ABBREV_DUPLICATE = 10151;
    public static final String PDF_SETUP_ABBREV_DUPLICATE_MSG = "Invalid Printer ID - already in use";
    public static final int PDF_SETUP_DESCR_DUPLICATE = 10152;
    public static final String PDF_SETUP_DESCR_DUPLICATE_MSG = "Invalid Printer Make/Model - already in use";
    public static final int PDF_SETUP_DESCR_MISSING = 10153;
    public static final String PDF_SETUP_DESCR_MISSING_MSG = "Printer Make/Model missing";
    public static final int PDF_SETUP_ABBREV_MISSING = 10154;
    public static final String PDF_SETUP_ABBREV_MISSING_MSG = "Printer ID missing";
    public static final int PDF_SETUP_NO_DATA_ENTERED = 10155;
    public static final String PDF_SETUP_NO_DATA_ENTERED_MSG = "Data missing, enter a value for: ";
    public static final int PDF_SETUP_INVALID_DATA_ENTERED = 10156;
    public static final String PDF_SETUP_INVALID_DATA_ENTERED_MSG = "Invalid data entered for: ";

    // POS Override 10201 - 10250
    public static final int PYR_PYR_GRP_EXCLUSION = 10201;
    public static final String PYR_PYR_GRP_EXCLUSION_MSG = "Either Payor or Payor Group (not both) can be selected.";

    // SLA Validation 10251 - 10300
    public static final int INVALID_SVC_LVL_PRIOR_AUTH_NUM = 10251;
    public static final String INVALID_SVC_LVL_PRIOR_AUTH_NUM_MSG = "Invalid Service Level Prior Authorization Number: ";

    // HL7 Importer - 10301 - 10314
    public static final int HL7_IMPORTER_INVALID_IMPORT_FILE_TYPE = 10301;
    public static final String HL7_IMPORTER_INVALID_IMPORT_FILE_TYPE_MSG = "Invalid file type. Please ensure that the file is tab delimited and has the extension: 'txt'.";
    public static final int HL7_IMPORTER_FILE_NOT_UPLOADED = 10302;
    public static final String HL7_IMPORTER_FILE_NOT_UPLOADED_MSG = "The file was not uploaded successfully. Please correct and try again.";
    public static final int HL7_IMPORTER_NO_LIS_IMPORT_HEADER_DATA = 10303;
    public static final String HL7_IMPORTER_NO_LIS_IMPORT_HEADER_DATA_MSG = "No column header mapping settings found. Please set up the mapping settings between the column headers and the HL7 segments.";
    public static final int HL7_IMPORTER_NO_HEADER_MATCHES = 10304;
    public static final String HL7_IMPORTER_NO_HEADER_MATCHES_MSG = "No header of the uploaded file matches to the HL7 fields.";
    public static final int HL7_IMPORTER_NO_DATA = 10305;
    public static final String HL7_IMPORTER_NO_DATA_MSG = "The uploaded file is incomplete. Please check the content of the file.";
    public static final int HL7_IMPORTER_FILE_NOT_CONVERTED = 10306;
    public static final String HL7_IMPORTER_FILE_NOT_CONVERTED_MSG = "The file was not converted successfully. Please try again.";
    public static final int HL7_IMPORTER_INVALID_DATE_FORMAT = 10307;
    public static final String HL7_IMPORTER_INVALID_DATE_FORMAT_MSG = "The date format is not valid.";
    public static final int HL7_IMPORTER_REQUIRED_COLUMN_DATA_MISSING = 10308;
    public static final String HL7_IMPORTER_REQUIRED_COLUMN_DATA_MISSING_MSG = "Required column data is missing in the uploaded file.";
    public static final int HL7_IMPORTER_REQUIRED_COLUMN_HEADER_MISSING = 10309;
    public static final String HL7_IMPORTER_REQUIRED_COLUMN_HEADER_MISSING_MSG = "Required column is missing in the uploaded file.";
    public static final int HL7_IMPORTER_DATA_TYPS_COLUMN_HEADER_MISSING = 10310;
    public static final String HL7_IMPORTER_DATA_TYPS_COLUMN_HEADER_MISSING_MSG = "Required data type column is missing in the uploaded file.";
    public static final int HL7_IMPORTER_DATA_TYPS_COLUMN_HEADER_INCOMPLETE = 10311;
    public static final String HL7_IMPORTER_DATA_TYPS_COLUMN_HEADER_INCOMPLETE_MSG = "Data type columns are incomplete in the uploaded file.";
    public static final int HL7_IMPORTER_NO_DATA_TYPS_CHECKED = 10312;
    public static final String HL7_IMPORTER_NO_DATA_TYPS_CHECKED_MSG = "No data type column is checked in the uploaded file.";
    public static final int HL7_IMPORTER_INCORRECT_DATA_TYP = 10313;
    public static final String HL7_IMPORTER_INCORRECT_DATA_TYP_MSG = "Incorrect data type for the first row.";
    public static final int HL7_IMPORTER_MULTI_DATA_TYPS_CHECKED = 10314;
    public static final String HL7_IMPORTER_MULTI_DATA_TYPS_CHECKED_MSG = "Only one of columns A-D can contain an X in any given row.";

    //File maintenance Client Billing Category

    public static final int    UNAUTHORIZED_CREATE_CLN_BILLING_CAT = 105000;
    public static final String UNAUTHORIZED_CREATE_CLN_BILLING_CAT_MSG = "User does not have permission to create a new Client Billing Category";


    public static final int REQUIRED_FIELD_DIALYSIS_MISSING = 105001;
    public static final String REQUIRED_FIELD_DIALYSIS_MISSING_MSG = "Dialysis is required. ";

    public static final int REQUIRED_FIELD_BILLRENALTO_MISSING = 105002;
    public static final String REQUIRED_FIELD_BILLRENALTO_MISSING_MSG = "Bill Renal To is required. ";


    public static final int REQUIRED_FIELD_BILLNONRENALTO_MISSING = 105003;
    public static final String REQUIRED_FIELD_BILLNONRENALTO_MISSING_MSG = "Bill Non-Renal To is required. ";


    public static final int FM_CLIENT_BILLING_CATEGORY_UNEXPECTED_ERROR  = 105004;
    public static final String FM_CLIENT_BILLING_CATEGORY_UNEXPECTED_ERROR_MSG = "An unexpected error occurred loading the Client Billing Categories";


    public static final int    UNAUTHORIZED_CREATE_CLIENT_BILLING_CATEGORY = 105005;
    public static final String UNAUTHORIZED_CREATE_CLIENT_BILLING_CATEGORY_MSG = "User does not have permission to create or update client billing category";

    public static final int CLN_BILLING_CAT_XACTION_ROLLBACK_FATAL_ERROR = 105006;
    public static final String CLN_BILLING_CAT_XACTION_ROLLBACK_FATAL_ERROR_MSG = "Fatal error while attempting to rollback transaction. Contact your system administrator.";

    public static final int CLN_BILLING_CAT_XACTION_ROLLBACK = 105007;
    public static final String CLN_BILLING_CAT_XACTION_ROLLBACK_MSG = "Submit aborted. Transaction rolled back to due to exception. ";


    public static final int REQUIRED_FIELD_ABBREV_MISSING = 105008;
    public static final String REQUIRED_FIELD_ABBREV_MISSING_MSG = "ID is required";

    public static final int INVALID_CHARACTER_LENGTH = 105009;
    public static final String INVALID_CHARACTER_LENGTH_MSG = "More than allowed number of characters entered in field";

    //MPPR ERROR CODES
    public static final int INVALID_MPPR = 106000;
    public static final String INVALID_MPPR_MSG = "Invalid MPPR Rule ID";

    public static final int UNEXPIRED_MPPR = 106001;
    public static final String UNEXPIRED_MPPR_MSG = "MPPR Rule ID being copied from is not expired";

    public static final int MPPR_OVERLAP_EFF_DT = 106002;
    public static final String MPPR_OVERLAP_EFF_DT_ERR_MSG = "? has overlapping dates for period ? ? and ? ?. The date range for effective dates may not overlap.";

    public static final int MPPR_INVALID_EFF_DT = 106003;
    public static final String MPPR_INVALID_EFF_DT_ERR_MSG = "Invalid effective date found on ";
    public static final int MPPR_INVALID_EXP_DT = 106004;
    public static final String MPPR_INVALID_EXP_DT_ERR_MSG = "Invalid expiration date found on ";
    public static final int MPPR_EXP_DT_BEFORE_EFF_DT = 106005;
    public static final String MPPR_EXP_DT_BEFORE_EFF_DT_ERR_MSG = "Expiration date is before the effective date.";
    public static final int MPPR_NOT_FOUND = 106006;
    public static final String MPPR_NOT_FOUND_ERR_MSG = "MPPR Rule ID being copied from does not exist.";
    public static final int    UNAUTHORIZED_CREATE_MPPR_RULE = 106007;
    public static final String UNAUTHORIZED_CREATE_MPPR_RULE_MSG = "User does not have permission to create or update MPPR Rule";
    public static final int MPPR_RULE_XACTION_ROLLBACK_FATAL_ERROR = 105006;
    public static final String MPPR_RULE_XACTION_ROLLBACK_FATAL_ERROR_MSG = "Fatal error while attempting to rollback transaction. Contact your system administrator.";
    public static final int MPPR_RULE_XACTION_ROLLBACK = 105007;
    public static final String MPPR_RULE_XACTION_ROLLBACK_MSG = "Submit aborted. Transaction rolled back to due to exception. ";
    public static final int MPPR_RULE_DELETE = 105008;
    public static final String MPPR_RULE_DELETE_MSG = "MPPRRule cannot be deleted as it is in use.";
    public static final int MPPR_FETCH_ERR = 105009;
    public static final String MPPR_FETCH_ERR_MSG = "Error occurred while fetching MPPRRule= ";
    public static final int MPPR_PROC_CODE_OVERLAP = 105010;
    public static final String MPPR_PROC_CODE_OVERLAP_ERR_MSG = "A procedure code cannot be on more than one rule with the same Payor or Payor Group effective date range. The following are in conflict with the existing rule:";


    // MOLDX ERROR CODES 74044
    public static final int MOLDX_ERROR_CODE = 157293;
    public static final String MOLDX_ERROR_MESSAGE = "Incorrect "+test+"s assigned to Proc Code with ProcSeqId=";
    /**
     * @deprecated Use the variable of the same name in DbErrorMap.
     */
    public static final String BAD_ADDRESS = "ADDRESS";

    /**
     * @deprecated Use the variable of the same name in DbErrorMap.
     */
    public static final String INELIGIBLE = "INELIGIBLE";


    //public static final String NO_ACCN_DIAG_FOUND_ERR = "NODIAG";
    //public static final String NO_NARRATIVE_DIAG = "DIAGNAR";

    // Admission / Discharge Date and Time field messages
    public static final String PYR_REQ_TEMPORAL_ORDER_MSG1  = "The admission date is after the discharge date.";
    public static final String PYR_REQ_TEMPORAL_ORDER_MSG2  = "Admission date must be specified if discharge is specified.";
    public static final String PYR_REQ_FUTURE_ADMIT_MSG     = "The Admission Date/Time cannot be in the future.";
    public static final String PYR_REQ_FUTURE_DISCHARGE_MSG = "The Discharge Date/Time cannot be in the future.";
    public static final String PATH_IP_ADMIT_DT_MSG = "Admission Date required for Hospital Inpatient Pathology Services.";
    public static final String PATH_IP_DISCHRG_DT_MSG = "Discharge Date required for Hospital Inpatient Pathology Services.";

    public static final String HELP_MSG1 = "Please contact the Xifin Help Desk with any problems.";
    public static final String HELP_MSG2 = "Please contact the Xifin Help Desk with ";  // append additional info like accnId
    public static final String HELP_EMAIL = "help@xifin.com";

    // SLA Prior Authorization
    public static final String TESTAUTHPYR = "TESTAUTHPYR";
    public static final String TESTAUTH = "TESTAUTH";
    public static final String PROCAUTHPYR = "PROCAUTHPYR";
    public static final String PROCAUTH = "PROCAUTH";

    public static final String TESTANPYR = "TESTANPYR";
    public static final String TESTAN = "TESTAN";
    public static final String PROCANPYR = "PROCANPYR";
    public static final String PROCAN = "PROCAN";
    public static final List<String> SLA_ERROR_LIST = Arrays.asList(TESTAUTHPYR, TESTAUTH, PROCAUTHPYR, PROCAUTH,
            TESTANPYR, TESTAN, PROCANPYR, PROCAN);

    // Patient Payment
    public static final int    INVALID_DOS = 10401;
    public static final String INVALID_DOS_MSG = "The date of service is not valid.";
    public static final int    MULTI_PMTS_PER_ACCN_AND_DBS = 10402;
    public static final String MULTI_PMTS_PER_ACCN_AND_DBS_1_MSG = Accession+"(s) ";
    public static final String MULTI_PMTS_PER_ACCN_AND_DBS_2_MSG = " has multiple bulk payments in the same "+accession+".  Use the Non-Client Payment screen to modify these payments.";

    //Client - Contact Manager
    public static final int MATCH_USER = 66666;
    public static final String MATCH_USER_MSG = "The existing User ID does not match";

    //Incremental Pricing
    public static final String MULTI_INCLUDE_ERR_1_MSG = "A %s can only be included in one rule per Incremental Table. %s %s is in %s and %s.";
    public static final String MULTI_INCLUDE_ERR_2_MSG = "A %s can only be included in one rule per Incremental Table. %s %s is in %s.";

    public static final String TEST_CODE_LAB_COST_ERROR_MIN_PRICE = "{0}: Min Price must be greater than or equal to "+ fmLab +" Cost";

    public static final int CLN_LOCK = 10403;
    public static final String CLN_LOCK_MSG = "Your ClientLock is no longer present.  You will need to reapply all changes.";

    public static final int PT_NOTIF_LTR_CONFIG_ERROR_DUPLICATE_CONFIG = 11001;
    public static final String PT_NOTIF_LTR_CONFIG_ERROR_DUPLICATE_CONFIG_MSG = "Duplicate configuration";
    public static final int PT_NOTIF_LTR_CONFIG_ERROR_PYRGRP_EXCL = 11002;
    public static final String PT_NOTIF_LTR_CONFIG_ERROR_PYRGRP_EXCL_MSG = "Payor Group Exclusion is not allowed if there is a Payor or Payor Group Inclusion";
    public static final int PT_NOTIF_LTR_CONFIG_ERROR_PYR_EXCL = 11003;
    public static final String PT_NOTIF_LTR_CONFIG_ERROR_PYR_EXCL_MSG = "Excluded Payor must be in an included Payor Group";
    public static final int PT_NOTIF_LTR_CONFIG_PYRGRP_INCLEXCL = 11004;
    public static final String PT_NOTIF_LTR_CONFIG_PYRGRP_INCLEXCL_MSG = "Duplicate Payor Group Inclusion/Exclusion";
    public static final int PT_NOTIF_LTR_CONFIG_PYR_INCLEXCL = 11005;
    public static final String PT_NOTIF_LTR_CONFIG_PYR_INCLEXCL_MSG = "Duplicate Payor Inclusion/Exclusion";
    public static final int PT_NOTIF_LTR_CONFIG_ERROR_CLNACCNTTYP_EXCL = 11006;
    public static final String PT_NOTIF_LTR_CONFIG_ERROR_CLNACCNTTYP_EXCL_MSG = "Client Account Type Exclusion is not allowed if there is a Client or Client Account Type Inclusion";
    public static final int PT_NOTIF_LTR_CONFIG_ERROR_CLN_EXCL = 11007;
    public static final String PT_NOTIF_LTR_CONFIG_ERROR_CLN_EXCL_MSG = "Excluded Client must be in an included Client Account Type";
    public static final int PT_NOTIF_LTR_CONFIG_CLNACCNTTYP_INCLEXCL = 11008;
    public static final String PT_NOTIF_LTR_CONFIG_CLNACCNTTYP_INCLEXCL_MSG = "Duplicate Client Account Type Inclusion/Exclusion";
    public static final int PT_NOTIF_LTR_CONFIG_CLN_INCLEXCL = 11009;
    public static final String PT_NOTIF_LTR_CONFIG_CLN_INCLEXCL_MSG = "Duplicate Client Inclusion/Exclusion";
    public static final int PT_NOTIF_LTR_CONFIG_ERROR_TESTTYP_EXCL = 11010;
    public static final String PT_NOTIF_LTR_CONFIG_ERROR_TESTTYP_EXCL_MSG = "Test Type Exclusion is not allowed if there is a Test or Test Type Inclusion";
    public static final int PT_NOTIF_LTR_CONFIG_ERROR_TEST_EXCL = 11011;
    public static final String PT_NOTIF_LTR_CONFIG_ERROR_TEST_EXCL_MSG = "Excluded Test must be in an included Test Type";
    public static final int PT_NOTIF_LTR_CONFIG_TESTTYP_INCLEXCL = 11012;
    public static final String PT_NOTIF_LTR_CONFIG_TESTTYP_INCLEXCL_MSG = "Duplicate Test Type Inclusion/Exclusion";
    public static final int PT_NOTIF_LTR_CONFIG_TEST_INCLEXCL = 11013;
    public static final String PT_NOTIF_LTR_CONFIG_TEST_INCLEXCL_MSG = "Duplicate Test Inclusion/Exclusion";
    public static final int PT_NOTIF_LTR_CONFIG_TAXONOMY_INCLEXCL = 11014;
    public static final String PT_NOTIF_LTR_CONFIG_TAXONOMY_INCLEXCL_MSG = "Duplicate Taxonomy Code Inclusion/Exclusion";
    public static final int PT_NOTIF_LTR_CONFIG_ERROR_TAXONOMY_EXCL = 11015;
    public static final String PT_NOTIF_LTR_CONFIG_ERROR_TAXONOMY_EXCL_MSG = "Taxonomy Code Exclusion is not allowed if there is a Taxonomy Code Inclusion";
    public static final int PT_NOTIF_LTR_CONFIG_CLNFAC_INCLEXCL = 11016;
    public static final String PT_NOTIF_LTR_CONFIG_CLNFAC_INCLEXCL_MSG = "Duplicate Client Facility Inclusion/Exclusion";
    public static final int PT_NOTIF_LTR_CONFIG_ERROR_CLNFAC_EXCL = 11017;
    public static final String PT_NOTIF_LTR_CONFIG_ERROR_CLNFAC_EXCL_MSG = "Client Facility Exclusion is not allowed if there is a Client Facility Inclusion";
    public static final int PT_NOTIF_LTR_CONFIG_MOD_INCLEXCL = 11018;
    public static final String PT_NOTIF_LTR_CONFIG_MOD_INCLEXCL_MSG = "Duplicate Modifier Inclusion/Exclusion";
    public static final int PT_NOTIF_LTR_CONFIG_CLN_STATE_INCLEXCL = 11019;
    public static final String PT_NOTIF_LTR_CONFIG_CLN_STATE_INCLEXCL_MSG = "Duplicate Client State Inclusion/Exclusion";
    public static final int PT_NOTIF_LTR_CONFIG_CLN_QUESTION_RESPONSE = 11020;
    public static final String PT_NOTIF_LTR_CONFIG_CLN_QUESTION_RESPONSE_MSG = "Client Question requires at least one Response.";
    public static final int PT_NOTIF_LTR_CONFIG_ERROR_CLNSTATE_EXCL = 11021;
    public static final String PT_NOTIF_LTR_CONFIG_ERROR_CLNSTATE_EXCL_MSG = "Client State Exclusion is not allowed if there is a Client State Inclusion";

    // Patient Estimation
    public static final int PT_EST_ELIG_DENIED = 12000;
    public static final String PT_EST_ELIG_DENIED_MSG = "Eligibility was denied";
    public static final int PT_EST_NO_PROCEDURE_CODES = 12001;
    public static final String PT_EST_NO_PROCEDURE_CODES_MSG = "Could not determine procedure codes from test IDs";
    public static final int PT_EST_ELIG_DOB_MISMATCH = 12002;
    public static final String PT_EST_ELIG_DOB_MISMATCH_MSG = "DOB Mismatch";
    public static final int PT_EST_ELIG_UNDETERMINED = 12003;
    public static final String PT_EST_ELIG_UNDETERMINED_MSG = "Eligibility Undetermined";
    public static final int PT_EST_ELIG_INELIGIBLE = 12004;
    public static final String PT_EST_ELIG_INELIGIBLE_MSG = "Ineligible";
    public static final int PT_EST_ELIG_NOT_CHECKED = 12005;
    public static final String PT_EST_ELIG_NOT_CHECKED_MSG = "Not Checked";
    public static final int PT_EST_ELIG_REJECTED = 12006;
    public static final String PT_EST_ELIG_REJECTED_MSG = "Rejected Inquiry";
    public static final int PT_EST_ELIG_FAILED = 12100; // Default error if none of the above apply
    public static final String PT_EST_ELIG_FAILED_MSG = "Eligibility check failed";

    /*
     *   13000 - 13099: Patient Notification Logic
     */
    public static final int PT_NOTIF_MISSING_REQUIRED_PARAMS = 13000;
    public final static String PT_NOTIF_MISSING_REQUIRED_PARAMS_MSG = "Not all required parameters have been provided";
    public static final int PT_NOTIF_INVALID_EMAIL = 13001;
    public final static String PT_NOTIF_INVALID_EMAIL_MSG = "Email address is not valid";
    public static final int PT_NOTIF_INVALID_MOBILE_PHONE = 13002;
    public final static String PT_NOTIF_INVALID_MOBILE_PHONE_MSG = "Mobile phone number is not valid";
    public static final int PT_NOTIF_INVALID_PHONE_TYPE = 13003;
    public final static String PT_NOTIF_INVALID_PHONE_TYPE_MSG = "Phone number is not valid for receiving SMS messages";
    public static final int PT_NOTIF_INVALID_DELIVERY_TYPE = 13004;
    public final static String PT_NOTIF_INVALID_DELIVERY_TYPE_MSG = "The specified delivery type is not supported for delivering patient notifications";
    public static final int PT_NOTIF_SMS_OPTED_OUT = 13005;
    public final static String PT_NOTIF_SMS_OPTED_OUT_MSG = "The specified phone number has already opted out of all SMS messages";
    public static final int PT_NOTIF_MSG_BODY_DATA_NOT_FOUND = 13006;
    public final static String PT_NOTIF_MSG_BODY_DATA_NOT_FOUND_MSG = "Data not found looking for message body contents";
    public static final int PT_NOTIF_URL_CREATION_ERROR = 13007;
    public final static String PT_NOTIF_URL_CREATION_ERROR_MSG = "Unable to create short URL for patient notification";
    public static final int PT_NOTIF_PLAN_CREATION_DISABLED_ERROR = 13008;
    public final static String PT_NOTIF_PLAN_CREATION_DISABLED_ERROR_MSG = "Patient Notification Plan Creation is currently disabled";
    public static final int PT_NOTIF_VERIF_ATTEMPTS_EXCEEDED_MAX_ERROR = 13009;
    public final static String PT_NOTIF_VERIF_ATTEMPTS_EXCEEDED_MAX_ERROR_MSG = "The amount of verification attempts exceeded the maximum allowed";
    public static final int PT_NOTIF_UNDELIVERABLE_ENDPOINT_ERROR = 13010;
    public final static String PT_NOTIF_UNDELIVERABLE_ENDPOINT_ERROR_MSG = "This phone number or email address has been flagged as undeliverable";
    public static final int PT_NOTIF_EMAIL_OPTED_OUT = 13011;
    public final static String PT_NOTIF_EMAIL_OPTED_OUT_MSG = "The specified email address has opted out of receiving messages";
    public static final int PT_NOTIF_AWS_CONNECTION_ERROR = 13012;
    public final static String PT_NOTIF_AWS_CONNECTION_ERROR_MSG = "Error connecting to AWS to send message";

    /*
     *   14000 - 14100: Policy Information
     */
    public static final int REQUIRED_POLICY_TYPE = 14000;
    public final static String REQUIRED_POLICY_TYPE_MSG = "Policy Type is required.";
    public static final int PI_CHK_REV_NUM = 14001;
    public final static String PI_CHK_REV_NUM_MSG = "Enter a positive Revision Number.";
    public static final int INVALID_ORI_EFF_DT = 14002;
    public final static String INVALID_ORI_EFF_DT_MSG = "Invalid original effective date.";
    public static final int INVALID_TERM_DT = 14003;
    public final static String INVALID_TERM_DT_MSG = "Invalid term date.";
    public static final int EFF_DT_AFTER_TERM_DT = 14004;
    public final static String EFF_DT_AFTER_TERM_DT_MSG = "The effective date must be on or before the term date.";

    /*
     *   14000 - 14099: Patient Eligibility Logic
     */
    public static final int PT_ELIG_FAILED = 14000;
    public static final String PT_ELIG_FAILED_MSG = "Eligibility check failed";

    /**
     * 15000 - 15099: File Maintenance - Manual Activity Code
     */
    public static final int MIN_DAYS_GREATER_THAN_MAX_DAY = 15000;
    public static final String MIN_DAYS_GREATER_THAN_MAX_DAY_MSG = "Minimum Days must be less than Maximum Days";

    public static final int REQUIRED_MAN_ACT_CODE_ID = 15001;
    public static final String REQUIRED_MAN_ACT_CODE_ID_MSG = "Manual Activity Code ID is required";

    public static final int REQUIRED_MAN_ACT_CODE_DESCRIPTION = 15002;
    public static final String REQUIRED_MAN_ACT_CODE_DESCRIPTION_MSG = "Description is required";

    public static final int DUPLICATED_MANUAL_ACTIVITY_CODE = 15003;
    public static final String DUPLICATED_MANUAL_ACTIVITY_CODE_MSG = "Manual Activity Code ID <b>%s</b> already exists";

    public static final int DUPLICATED_MANUAL_ACTIVITY_CODE_DESCRIPTION = 15004;
    public static final String DUPLICATED_MANUAL_ACTIVITY_CODE_DESCRIPTION_MSG = "Description <b>%s</b> already exists";

    /**
     * 16000 - 16099: File Maintenance - EP Workgroup
     */
    public static final int REQUIRED_EP_WORKGROUP_ID = 16000;
    public static final String REQUIRED_EP_WORKGROUP_ID_MSG = "Workgroup ID is required";

    public static final int REQUIRED_EP_WORKGROUP_DESCRIPTION = 16001;
    public static final String REQUIRED_EP_WORKGROUP_DESCRIPTION_MSG = "Workgroup Description is required";

    public static final int DUPLICATED_EP_WORKGROUP_ID = 16002;
    public static final String DUPLICATED_EP_WORKGROUP_ID_MSG = "Workgroup ID %s already exists";

    public static final int DUPLICATED_EP_WORKGROUP_DESCRIPTION = 16002;
    public static final String DUPLICATED_EP_WORKGROUP_DESCRIPTION_MSG = "Workgroup Description %s already exists";

    /**
     * 17000 - 17099: File Maintenance - EP Workgroup Configuration
     */
    public static final int OUT_OF_RANGE_PRIORITY = 17000;
    public static final String OUT_OF_RANGE_PRIORITY_MSG = "Priority must be between 1 and 999";

    public static final int INVALID_PRIORITY = 17001;
    public static final String INVALID_PRIORITY_MSG = "“Priority % cannot be assigned, as maximum priority is %. Please reassign priority.";

    public static final int ALREADY_IN_USE_SAVED_SEARCH_ID = 17002;
    public static final String ALREADY_IN_USE_SAVED_SEARCH_ID_MSG = "Saved Search %s can only be assigned to one workgroup";

    public static final int REQUIRED_SAVED_SEARCH_ID = 17003;
    public static final String REQUIRED_SAVED_SEARCH_ID_MSG = "Saved Search is required";

    public static final int OUT_OF_RANGE_TARGET_DAILY_CAPACITY = 17004;
    public static final String OUT_OF_RANGE_TARGET_DAILY_CAPACITY_MSG = "Target Daily Capacity must be between 1 and 999";

    /**
     * Constructor
     */
    public ErrorCodeMap() {
        // Nothing to do here
    }

    /**
     * <p>The scheme for defining "custom strings" depends on the existence a PropertyFileLoader class that
     * knows how to load a nomenclature properties file to provide text substitutions (e.g. "accn" -> "order").
     * This scheme was created in RPM code that was then moved to PF-Persistence, but of course this class
     * is used by both RPM and platform projects. Compatibility with RPM needed to be maintained.
     *
     * <p>The code below now uses reflection to attempt creation of a PropertyFileLoader instance which is then used
     * (again via reflection) to look up a substitution string for various tokens.  In RPM the reflection calls will
     * succeed because the "com.mbasys.common.utility.PropertyFileLoader" class exists; thus the "custom strings"
     * will behave as it always has in RPM.
     *
     * <p>In the platform the reflection calls will fail, as there will be no
     * "com.mbasys.common.utility.PropertyFileLoader" found; this is OK.  In that case we simply fallback to returning
     * input string as the result (e.g. "accn" -> "accn").
     *
     * <p>If we really needed to, in the platform we could create a "com.mbasys.common.utility.PropertyFileLoader"
     * in some project and so enable the substitutions; better yet might be a scheme using something like a message
     * catalogs to lookup error messages by id.
     */
    private static Properties propMap = null;

    /** Detect if we already tried to use reflection to initialize propMap */
    private static boolean initializationAttempted = false;

    private static String getCustomString(String word) {
        if (propMap == null) {
            if( ! initializationAttempted ) {
                try {
                    initializationAttempted = true;

                    // This class exists in the RPM codebase
                    Class clazz = Class.forName("com.mbasys.common.utility.PropertyFileLoader");

                    Method getInstanceMethod = clazz.getMethod("getLoaderInstance");
                    Object propFileLoader = getInstanceMethod.invoke(null);

                    Method getPropsMethod = clazz.getMethod("getProperties");
                    propMap = (Properties) getPropsMethod.invoke(propFileLoader);

                    log.info(String.format("Loaded %d nomenclature properties", propMap.size()));
                } catch (IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {
                    log.info("No PropertyFileLoader class found by reflection; ErrorCode nomenclature overrides will not be enabled");
                    return word;
                }
            } else {
                // OK, we could not use reflection to access the PropertyFileLoader; simply return the input value then
                return word;
            }
        }

        String customString;
        switch (word)
        {
            case "test":
                customString = propMap.getProperty("test").toLowerCase();
                break;
            case "Test":
                customString = propMap.getProperty("test");
                break;
            case "accession":
                customString = propMap.getProperty("accession").toLowerCase();
                break;
            case "Accession":
                customString = propMap.getProperty("accession");
                break;
            case "Accn":
                customString = propMap.getProperty("accn");
                break;
            case "accn":
                customString = propMap.getProperty("accn").toLowerCase();
                break;
            case "Lab":
                customString = propMap.getProperty("lab");
                break;
            case "lab":
                customString = propMap.getProperty("slab");
                break;
            case "Phleb":
                customString = propMap.getProperty("phleb");
                break;
            case "phleb":
                customString = propMap.getProperty("phleb").toLowerCase();
                break;
            case "errPhleb":
                customString = propMap.getProperty("errPhleb");
                break;
            case "Phlebotomy":
                customString = propMap.getProperty("phlebotomy");
                break;
            case "phlebotomy":
                customString = propMap.getProperty("phlebotomy").toLowerCase();
                break;
            case "fmLab":
                customString = propMap.getProperty("fmLab");
                break;
            case "sfmLab":
                customString = propMap.getProperty("fmLab").toLowerCase();
                break;
            default:
                customString = "";
                break;
        }
        //log.debug("message=CustomString:"+customString);
        return customString;
    }

    public static void main(String[] args) {
        System.out.println("REQUIRED_TEST_ID_MSG = " + REQUIRED_TEST_ID_MSG);
        System.out.println("INVALID_ACCN_ID_MSG = " + INVALID_ACCN_ID_MSG);
        System.out.println("INVALID_PHLEB_MSG = " + INVALID_PHLEB_MSG);
        System.out.println("INVALID_PHLEB_FAC_MSG = " + INVALID_PHLEB_FAC_MSG);
        System.out.println("REASSESS_ERR_MSG = " + REASSESS_ERR_MSG);
        System.out.println("ACCN_LOCK_MSG = " + ACCN_LOCK_MSG);
        System.out.println("ACCN_ID_CONFLICT_MSG= " + ACCN_ID_CONFLICT_MSG);
        System.out.println("UB92_BILL_TYPE_REQ_MSG  = " + UB92_BILL_TYPE_REQ_MSG);
        System.out.println("UB92_COMMENT_REQ_MSG) = " + UB92_COMMENT_REQ_MSG);
        System.out.println("UB92_REASON_CD_REQ_MSG= " + UB92_REASON_CD_REQ_MSG);
        System.out.println("UB92_INVALID_REASON_CD_MSG= " + UB92_INVALID_REASON_CD_MSG);
        System.out.println("UB92_CLAIM_TYP_NOT_ALLOWED_MSG= " + UB92_CLAIM_TYP_NOT_ALLOWED_MSG);
        System.out.println("EOM_ERROR_DURING_PENDING_CHECK_MSG = " + EOM_ERROR_DURING_PENDING_CHECK_MSG );
        System.out.println("EOM_PEND_ACCNS_MISSING_LAB_MSGS_MSG = " + EOM_PEND_ACCNS_MISSING_LAB_MSGS_MSG);
        System.out.println("EOM_PEND_ACCNS_MISSING_PYR_MSG = " + EOM_PEND_ACCNS_MISSING_PYR_MSG);
        System.out.println("REQUIRED_STD_ORDR_TST_MSG= " + REQUIRED_STD_ORDR_TST_MSG);
        System.out.println("DUP_STD_ORDR_TST_MSG = " + DUP_STD_ORDR_TST_MSG);
        System.out.println("NO_ACCNS_FOUND_MSG = " + NO_ACCNS_FOUND_MSG);
        System.out.println("AM_WRONG_VER_LAB_TO_PHYS_MSG = " + AM_WRONG_VER_LAB_TO_PHYS_MSG);
        System.out.println("AM_WRONG_VER_PHYS_TO_LAB_MSG = " + AM_WRONG_VER_PHYS_TO_LAB_MSG);
        System.out.println("AM_CREATE_MNFST_ID_ERROR_MSG = " + AM_CREATE_MNFST_ID_ERROR_MSG);
        System.out.println("ACD_REQUIRED_PSC_ID_MSG= " + ACD_REQUIRED_PSC_ID_MSG);
        System.out.println("ACD_REQUIRED_PHLEB_ID_MSG = " + ACD_REQUIRED_PHLEB_ID_MSG);
        System.out.println("NCPS_COULDNT_LOAD_ACCN_DTL_MSG = " + NCPS_COULDNT_LOAD_ACCN_DTL_MSG);
        System.out.println("EP_NONE_SELECTED_MSG = " + EP_NONE_SELECTED_MSG);
        System.out.println("MPR_LOAD_DATA_ERROR_MSG = " + MPR_LOAD_DATA_ERROR_MSG);
        System.out.println("CBR_TST_NOTFND_MSG  = " + CBR_TST_NOTFND_MSG);
        System.out.println("CBR_TST_TYP_NOTFND_MSG = " + CBR_TST_TYP_NOTFND_MSG);
        System.out.println("CBR_TST_IE_INC_EXC_INV_MSG  = " + CBR_TST_IE_INC_EXC_INV_MSG);
        System.out.println("CBR_TST_NOTFND_INCEXC_MSG = " + CBR_TST_NOTFND_INCEXC_MSG);
        System.out.println("CBR_TST_TYP_NOTFND_INCEXC_MSG= " + CBR_TST_TYP_NOTFND_INCEXC_MSG);
        System.out.println("CBR_TST_TYP_INCEXC_NO_ID_MSG= " + CBR_TST_TYP_INCEXC_NO_ID_MSG);
        System.out.println("CBR_TST_TYP_INCEXC_EXTRA_ID_MSG = " + CBR_TST_TYP_INCEXC_EXTRA_ID_MSG);
        System.out.println("CBR_PYR_REC_NOTFND_EPR_PYR_MSG = " + CBR_PYR_REC_NOTFND_EPR_PYR_MSG);
        System.out.println("CBR_PYR_GRP_INV_EPR_MSG = " + CBR_PYR_GRP_INV_EPR_MSG);
        System.out.println("CBR_PYR_PYRGRP_DUP_MSG= " + CBR_PYR_PYRGRP_DUP_MSG);
        System.out.println("CBR_PYR_PYRGRP_MISS_MSG= " + CBR_PYR_PYRGRP_MISS_MSG);
        System.out.println("CBR_INV_ALLOW_PARM_MSG = " + CBR_INV_ALLOW_PARM_MSG);
        System.out.println("CBR_TEST_NOTFND_EPR_MSG= " + CBR_TEST_NOTFND_EPR_MSG);
        System.out.println("CBR_INV_TESTTYP_EPR_MSG = " + CBR_INV_TESTTYP_EPR_MSG);
        System.out.println("CBR_TEST_TESTTYP_MISSING_MSG = " + CBR_TEST_TESTTYP_MISSING_MSG);
        System.out.println("CBR_TEST_TESTTYP_DUP_MSG = " + CBR_TEST_TESTTYP_DUP_MSG);
        System.out.println("CBR_EPR_MISSING_PYRABBRV_EXC_MSG= " + CBR_EPR_MISSING_PYRABBRV_EXC_MSG);
        System.out.println("CBR_EPR_INV_PYRGRP_EXC_MSG = " + CBR_EPR_INV_PYRGRP_EXC_MSG);
        System.out.println("CBR_EPR_NO_PYRGRP_EXC_MSG = " + CBR_EPR_NO_PYRGRP_EXC_MSG);
        System.out.println("CBR_EPR_PYRGRP_EXC_DUP_MSG = " + CBR_EPR_PYRGRP_EXC_DUP_MSG);
        System.out.println("CPI_MISSING_TEST_ID_MSG) = " + CPI_MISSING_TEST_ID_MSG);
        System.out.println("CPI_INVALID_TEST_ID_MSG = " + CPI_INVALID_TEST_ID_MSG);
        System.out.println("CPI_MISSING_FAC_ERROR_MSG = " + CPI_MISSING_FAC_ERROR_MSG);
        System.out.println("CPI_NOT_EFFECTIVE_TEST_ERROR_MSG = " + CPI_NOT_EFFECTIVE_TEST_ERROR_MSG);
        System.out.println("CPI_MISSING_PROC_ERROR_MSG = " + CPI_MISSING_PROC_ERROR_MSG);
        System.out.println("CPC_INVALID_LVL1_DISC_MSG = " + CPC_INVALID_LVL1_DISC_MSG);
        System.out.println("CPC_INVALID_LVL2_DISC_MSG = " + CPC_INVALID_LVL2_DISC_MSG);
        System.out.println("CPC_INVALID_LVL3_DISC_MSG = " + CPC_INVALID_LVL3_DISC_MSG);
        System.out.println("CPC_INVALID_LVL4_DISC_MSG = " + CPC_INVALID_LVL4_DISC_MSG);
        System.out.println("CPC_INVALID_LVL5_DISC_MSG = " + CPC_INVALID_LVL5_DISC_MSG);
        System.out.println("CPC_INVALID_LVL6_DISC_MSG = " + CPC_INVALID_LVL6_DISC_MSG);
        System.out.println("CPC_INVALID_LVL7_DISC_MSG = " + CPC_INVALID_LVL7_DISC_MSG);
        System.out.println("QCPC_INVALID_LVL8_DISC_MSG = " + CPC_INVALID_LVL8_DISC_MSG);
        System.out.println("CPC_INVALID_LVL9_DISC_MSG= " + CPC_INVALID_LVL9_DISC_MSG);
        System.out.println("CPC_INVALID_REF_HNDL_TEST_ID_MSG= " + CPC_INVALID_REF_HNDL_TEST_ID_MSG);
        System.out.println("FM_TESTBASED_MSG = " + FM_TESTBASED_MSG);
        System.out.println("FM_NOTESTNAME_MSG = " + FM_NOTESTNAME_MSG);
        System.out.println("FM_BADPYR_MSG = " + FM_BADPYR_MSG);
        System.out.println("FM_BADPYRGRP_MSG = " + FM_BADPYRGRP_MSG);
        System.out.println("FM_NO_HL7_COMP_OF_PROF = " + FM_NO_HL7_COMP_OF_PROF);
        System.out.println("FM_NO_HL7_COMP_OF_PROF_MSG = " + FM_NO_HL7_COMP_OF_PROF_MSG);
        System.out.println("INVALID_DUP_TSTXREF_MSG= " + INVALID_DUP_TSTXREF_MSG);
        System.out.println("REQUIRED_TSTXREF_MSG = " + REQUIRED_TSTXREF_MSG);
        System.out.println("FM_REFLAB_COST_MSG = " + FM_REFLAB_COST_MSG);
        System.out.println("PS_ACCN_NOT_FOUND_MSG = " + PS_ACCN_NOT_FOUND_MSG);
        System.out.println("PS_ACCN_LOCK_FAILED_MSG = " + PS_ACCN_LOCK_FAILED_MSG);
        System.out.println("PS_BAD_ACCN_STATUS_MSG = " + PS_BAD_ACCN_STATUS_MSG);
        System.out.println("PS_NO_CLN_SUSP_TO_ACCN_MSG = " + PS_NO_CLN_SUSP_TO_ACCN_MSG);
        System.out.println("PS_NO_SUSP_TO_PRIM_CLN_PYR_MSG = " + PS_NO_SUSP_TO_PRIM_CLN_PYR_MSG);
        System.out.println("PS_ONLY_ONE_PT_PYR_MSG = " + PS_ONLY_ONE_PT_PYR_MSG);
        System.out.println("PS_NO_SUSP_TO_PT_PRIM_ACCN_MSG = " + PS_NO_SUSP_TO_PT_PRIM_ACCN_MSG);
        System.out.println("ATU_CANNOT_DELETE_TEST_MSG_MSG = " + ATU_CANNOT_DELETE_TEST_MSG_MSG);
        System.out.println("ATU_ERROR_ADDING_TEST_DATA_MSG = " + ATU_ERROR_ADDING_TEST_DATA_MSG);
        System.out.println("ATU_ERROR_INVALID_TRIP_STOPS_MSG = " + ATU_ERROR_INVALID_TRIP_STOPS_MSG);
        System.out.println("ATU_ERROR_REQUIRED_TRIP_STOPS_MSG = " + ATU_ERROR_REQUIRED_TRIP_STOPS_MSG);
        System.out.println("ATU_ERROR_INVALID_TRIP_PATIENTS_MSG = " + ATU_ERROR_INVALID_TRIP_PATIENTS_MSG);
        System.out.println("ATU_WARNING_PRC_BELOW_COST_MSG = " + ATU_WARNING_PRC_BELOW_COST_MSG);
        System.out.println("TEST_ONLY_AS_COMPONENT_MSG = " + TEST_ONLY_AS_COMPONENT_MSG);
        System.out.println("PPC_TEST_NUM_MSG = " + PPC_TEST_NUM_MSG);
        System.out.println("PPC_TEST_NUM_PROFILE_MSG = " + PPC_TEST_NUM_PROFILE_MSG);
        System.out.println("QMS_INVALID_TEST_ID_MSG = " + QMS_INVALID_TEST_ID_MSG);
        System.out.println("ACCN_PYR_ERROR_MSG = " + ACCN_PYR_ERROR_MSG);
        System.out.println("ACCN_ERROR_MSG= " + ACCN_ERROR_MSG);
        System.out.println("ACCN_PYR_ERRS_MSG = " + ACCN_PYR_ERRS_MSG);
        System.out.println("ACCN_PYR_DATA_MSG = " + ACCN_PYR_DATA_MSG);
        System.out.println("ACD_NO_PYRS_MSG = " + ACD_NO_PYRS_MSG);
        System.out.println("ACD_INVALID_STATUS_FOR_ACTION_MSG = " + ACD_INVALID_STATUS_FOR_ACTION_MSG);
        System.out.println("PT_PYR_SUSP_MSG  = " + PT_PYR_SUSP_MSG);
        System.out.println("PT_PYR_SECONDARY_SUSP_MSG = " + PT_PYR_SECONDARY_SUSP_MSG);
        System.out.println("OE_NOT_PERFORMED_MSG  = " + OE_NOT_PERFORMED_MSG);
        System.out.println("NEEDS_OE_ON_REPORTED_ACCN_MSG = " + NEEDS_OE_ON_REPORTED_ACCN_MSG);
        System.out.println("REQUIRED_REV_ADJ_ACCN_MSG = " + REQUIRED_REV_ADJ_ACCN_MSG);
        System.out.println("INVALID_REV_ADJ_ACCN_MSG= " + INVALID_REV_ADJ_ACCN_MSG);
        System.out.println("INVALID_STMNT_RESCHED_MSG= " + INVALID_STMNT_RESCHED_MSG);
        System.out.println("MISSING_PT_PYRS_MSG = " + MISSING_PT_PYRS_MSG);
        System.out.println("NO_ADJ_PMT_REPRICE_MSG = " + NO_ADJ_PMT_REPRICE_MSG);
        System.out.println("ADJ_AMT_TOO_GREAT_MSG  = " + ADJ_AMT_TOO_GREAT_MSG);
        System.out.println("NO_PYRS_MSG = " + NO_PYRS_MSG);
        System.out.println("ORDERED_TESTS_ERR_MSG = " + ORDERED_TESTS_ERR_MSG);
        System.out.println("TRAVEL_FEE_STOPS_ERR_MSG = " + TRAVEL_FEE_STOPS_ERR_MSG);
        System.out.println("TRAVEL_FEE_PT_COUNT_STOPS_ERR_MSG = " + TRAVEL_FEE_PT_COUNT_STOPS_ERR_MSG);
        System.out.println(" UNPOSTABLE_PAYMENT_ON_ACCN_MSG = " + UNPOSTABLE_PAYMENT_ON_ACCN_MSG);
        System.out.println("ACN_STMNT_PRICED_ACCNS_ALLOWED_REQ_MSG= " + ACN_STMNT_PRICED_ACCNS_ALLOWED_REQ_MSG);
        System.out.println("PMT_INVALID_ACCN_STATUS_MSG = " + PMT_INVALID_ACCN_STATUS_MSG);
        System.out.println("PMT_ADJ_EOB_MSG  = " + PMT_ADJ_EOB_MSG);
        System.out.println("PMT_CLN_PRC_ACCN_MSG = " + PMT_CLN_PRC_ACCN_MSG);
        System.out.println("PMT_PT_PYR_LAST_MSG = " + PMT_PT_PYR_LAST_MSG);
        System.out.println("PMT_DEP_WITH_BATCHES_NO_DELETION_MSG  = " + PMT_DEP_WITH_BATCHES_NO_DELETION_MSG);
        System.out.println("REFUND_ACCN_NOT_FOUND_MSG= " + REFUND_ACCN_NOT_FOUND_MSG);
        System.out.println("REFUND_ACCN_HAS_NO_PMTS_MSG = " + REFUND_ACCN_HAS_NO_PMTS_MSG);
        System.out.println("REFUND_COULD_NOT_LOCK_ACCN_MSG = " + REFUND_COULD_NOT_LOCK_ACCN_MSG);
        System.out.println("MULTI_PMTS_PER_ACCN_AND_DBS_2_MSG= " + MULTI_PMTS_PER_ACCN_AND_DBS_2_MSG);

        //Newly Added
        System.out.println("MULTI_PMTS_PER_ACCN_AND_DBS_1_MSG= " + MULTI_PMTS_PER_ACCN_AND_DBS_1_MSG );
        System.out.println("PMT_ADJ_CD_REV_MSG  = " + PMT_ADJ_CD_REV_MSG );
        System.out.println("DELETE_FAIL_ACCNPHYS_LINKED_MSG  = " + DELETE_FAIL_ACCNPHYS_LINKED_MSG );
        System.out.println("EP_MTCH_CMP_NO_MTCH_MSG  = " + EP_MTCH_CMP_NO_MTCH_MSG );
        System.out.println("NCPS_ERROR_LOADING_ACCN_DTL_MSG  = " + NCPS_ERROR_LOADING_ACCN_DTL_MSG );
        System.out.println("ACD_ACCN_DATA_LOCK_ERROR_MSG   = " + ACD_ACCN_DATA_LOCK_ERROR_MSG );
        System.out.println("EOM_PEND_ACCNS_MISSING_PYR_MSG = " + EOM_PEND_ACCNS_MISSING_PYR_MSG );
        System.out.println("INVALID_TEST_ID_MSG = " + INVALID_TEST_ID_MSG );
        System.out.println("IMPORT_EXISTING_UPDATED  = " + IMPORT_EXISTING_UPDATED );
        System.out.println("IMPORT_EXISTING_NOT_UPDATED = " + IMPORT_EXISTING_NOT_UPDATED );
        System.out.println("OE_NO_TEST_MSG  = " + OE_NO_TEST_MSG  );
        System.out.println("IMPORT_EXISTING_UPDATED  = " + IMPORT_EXISTING_UPDATED );
        System.out.println("MOLDX_ERROR_MESSAGE  = " + MOLDX_ERROR_MESSAGE  );
    }
}

