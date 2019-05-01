package  se.cambiosys.spider.medicalrecordsmodule;

import se.cambiosys.spider.DataService.ManagerBeanBase;
import se.cambiosys.spider.StructureService.SpiderException;

import java.util.List;

/**
 **
 * <p> Title: CacheManagerBean </p>
 * <p> Description: Bean which calls to update cache/fetch data by EC cache.</p>
 * <p> Copyright: Copyright (c) </p>
 * <p> Company: Cambio Healthcare Systems </p>
 *
 * @ejbgen:session
 * ejb-name = MedicalRecordManager
 * type = Stateless
 * default-transaction = Supports
 *
 * @ejbgen:jndi-name
 * remote = medicalrecordsmodule/MedicalRecordManager
 *
 * @author M.Mufarrij
 * @version 1.0
 */
public class MedicalRecordManagerBean extends ManagerBeanBase
{
  /**
   * @throws SpiderException
   */
  public void ejbCreate() throws SpiderException
  {

  }

  /**
   **
   * creates a new data object from the given data.
   * Data will be saved in Priority and as a Medical Record
   *
   * The Contact Status will be also changed according to the Contact Data passed in.
   *    - Responsible Staff available = STATUS_OPEN
   *    - Responsible Staff not available = STATUS_ARRIVED
   *
   * @ejbgen:remote-method
   * @param
   * @return string connection
   */
  public String getData() throws SpiderException
  {
    return MedicalNoteToolkit.getInstance().getDataFromToolKit();
  }

  /**
   **
   * creates a new data object from the given data.
   * Data will be saved in TrainingMedicalNoteData
   *
   * The Contact Status will be also changed according to the Contact Data passed in.
   *    - Responsible Staff available = STATUS_OPEN
   *    - Responsible Staff not available = STATUS_ARRIVED
   *
   * @ejbgen:remote-method
   * @param
   * @return long value of success/fail
   */
  public long setData(TrainingMedicalNoteData data) throws SpiderException
  {
    return MedicalNoteToolkit.getInstance().setData(data);
  }


  /**
   **
   * creates a new data object from the given data.
   * Data will be saved in TrainingMedicalNoteData
   *
   * The Contact Status will be also changed according to the Contact Data passed in.
   *    - Responsible Staff available = STATUS_OPEN
   *    - Responsible Staff not available = STATUS_ARRIVED
   *
   * @ejbgen:remote-method
   * @param
   * @return long value of success/fail
   */
  public long createAdditionalInfoFromData(TrainingMedicalNoteData data) throws SpiderException
  {
    return MedicalNoteToolkit.getInstance().createAdditionalInfoFromData(data);
  }

  /**
   **
   * creates a new data object from the given data.
   * Data will be saved in TrainingMedicalNoteData
   *
   * The Contact Status will be also changed according to the Contact Data passed in.
   *    - Responsible Staff available = STATUS_OPEN
   *    - Responsible Staff not available = STATUS_ARRIVED
   *
   * @ejbgen:remote-method
   * @param
   * @return long value of success/fail
   */
  public TrainingMedicalNoteData getTrainingMedicalNoteData(long key) throws SpiderException
  {
    return MedicalNoteToolkit.getInstance().getTraininMedicalNoteData(key);
  }

  /**
   **
   * update existing data  object from the given data.
   * Data will be saved in TrainingMedicalNoteData
   *
   *
   * @ejbgen:remote-method
   * @param
   * @return long value of success/fail
   */
  public long updateData(TrainingMedicalNoteData data , long key) throws SpiderException
  {
    return MedicalNoteToolkit.getInstance().updateData(data,key);
  }

  /**
   *
   * return TrainingMedicalNoteData list for given keys
   *
   *
   * @ejbgen:remote-method
   * @param keys
   * @return
   * @throws SpiderException
   */
  public List<TrainingMedicalNoteData> getDataByKeys(long[] keys) throws SpiderException
  {
    return MedicalNoteToolkit.getInstance().getDataByKeys(keys);
  }


}
