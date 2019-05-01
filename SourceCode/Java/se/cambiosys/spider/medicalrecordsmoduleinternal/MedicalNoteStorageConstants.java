package se.cambiosys.spider.medicalrecordsmoduleinternal;

/**
 * <p> Title: MedicalNoteStorageConstants.java </p>
 * <p> Description: This interface holds the TrainProject module  constants and basic SQL constant.</p>
 * <p> Copyright: Copyright (c) </p>
 * <p> Company: Cambio Healthcare Systems </p>
 *
 * @author M.Mufarrij
 * @version 1.0
 * @since Jun 3, 2016
 */
public interface MedicalNoteStorageConstants
{
  String STORAGE = "TrainingMedicalNoteData";

  String STORAGE_AREA = "TrainingMedicalNoteData";

  String PRIMARY_KEY = "primaryKey";

  /* table fields*/

  String ID = "id";

  String CREATOR = "creator";

  String CREATED = "created";

  String REASON = "reason";

  String ACTIVE = "active";

  String LATEST = "latest";

  String SIGNED = "signed";

  String DATE_TIME = "dateTime";

  String NOTETYPE = "noteType";

  String NOTETEXT = "noteText";

  String UNIT = "unit";

  String CONTACT = "contact";

  String CARE_PROVIDER = "careProvider";



  String SQL_IN = " IN ";

  String SQL_LEFT_PARENTHESIS = "(";

  String SQL_RIGHT_PARENTHESIS = ")";

  String SQL_COMMA = ",";

  String SQL_EQUAL = "=";

  String STR_EMPTY = "";

  String STR_SINGLE_SPACE = " ";

  String CREATE_REASON = "createMedicalRecord";

  String UPDATE_REASON = "updateMedicalRecord";

}
