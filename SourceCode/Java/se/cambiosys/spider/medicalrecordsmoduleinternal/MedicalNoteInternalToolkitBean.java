package se.cambiosys.spider.medicalrecordsmoduleinternal;

import se.cambiosys.client.framework.DefaultExceptionHandler;
import se.cambiosys.spider.StructureService.Identifier;
import se.cambiosys.spider.StructureService.IdentifierToolkit;
import se.cambiosys.spider.StructureService.SpiderException;
import se.cambiosys.spider.DataService.InternalToolkit;
import se.cambiosys.spider.medicalrecordsmodule.TrainingMedicalNoteData;

import java.util.List;

/**
 * <p> Title: MedicalNoteInternalToolkitBean.java </p>
 * <p> Description: Internal toolkit bean of Training Project module which handles transactions.</p>
 * <p> Copyright: Copyright (c) </p>
 * <p> Company: Cambio Healthcare Systems </p>
 *
 * @ejbgen:session ejb-name=MedicalNoteInternalToolkit
 * type = Stateless
 * default-transaction=Required
 *
 * @ejbgen:jndi-name
 * remote = medicalrecordsmoduleinternal/MedicalNoteInternalToolkit
 *
 * @author M.Mufarrij
 * @version 1.0
 */
public class MedicalNoteInternalToolkitBean extends InternalToolkit
{
  /**
   * Constructs...
   *
   */
  public MedicalNoteInternalToolkitBean()
  {
    super("", "", "");
    versioned = true;
    external = false;
    hierarchical = false;
  }

  /**
   **
   * ejbCreate()
   *
   * @throws se.cambiosys.spider.StructureService.SpiderException
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
  public String getInternelData() throws SpiderException
  {
    return "Hello you have connected to internel toolkitBean";
  }



  /**
   **
   * Set given {@link se.cambiosys.spider.medicalrecordsmodule.TrainingMedicalNoteData} object.
   *
   * @ejbgen:remote-method
   * @param data
   * @return
   * @throws SpiderException
   */
  public long setData(TrainingMedicalNoteData data) throws SpiderException
  {
    long key = -1L;
    try
    {
      key = MedicalNoteStorageInternelToolkit.getInstance().setData(data);
    }
    catch (Throwable t)
    {
      rollback();
      DefaultExceptionHandler.getInstance().handleThrowable(t);
    }
    return key;
  }

  /**
   **
   * This will create the additional infoFromData by given {@link se.cambiosys.spider.medicalrecordsmodule.TrainingMedicalNoteData}.
   *
   * @ejbgen:remote-method
   * @param data
   * @return
   * @throws SpiderException
   */
  public long createAdditionalInfoFromData(TrainingMedicalNoteData data) throws SpiderException
  {
    long key = -1L;
    try
    {
      key = MedicalNoteStorageInternelToolkit.getInstance().createFromData(data);
    }
    catch(Throwable t)
    {
      rollback();
      DefaultExceptionHandler.getInstance().handleThrowable(t);
    }
    return key;
  }

  /**
   **
   * this method returns TrainingMedicalNoteData object for given primaryKey {@link se.cambiosys.spider.medicalrecordsmodule.TrainingMedicalNoteData}.
   *
   * @ejbgen:remote-method
   * @param primaryKey
   * @return
   * @throws SpiderException
   */
  public TrainingMedicalNoteData getData(long primaryKey)throws SpiderException
  {
   return MedicalNoteStorageInternelToolkit.getInstance().getData(primaryKey);
  }


  /**
   **
   * This will update existing record by given {@link se.cambiosys.spider.medicalrecordsmodule.TrainingMedicalNoteData}.
   *
   * @ejbgen:remote-method
   * @param data
   * @return
   * @throws SpiderException
   */
  public long updateData(TrainingMedicalNoteData data , long p_key) throws SpiderException
  {
    long key = -1L;
    try
    {
      key = MedicalNoteStorageInternelToolkit.getInstance().updateData(data,p_key);
    }
    catch(Throwable t)
    {
      rollback();
      DefaultExceptionHandler.getInstance().handleThrowable(t);
    }
    return key;
  }

  /** this method will return list of TrainingMedicalNoteData objects for given keys
   *
   * @ejbgen:remote-method
   * @param keys
   * @return
   * @throws SpiderException
   */
  public List<TrainingMedicalNoteData> getDataByKeys(long[] keys)throws SpiderException
  {
    return MedicalNoteStorageInternelToolkit.getInstance().getDataByKeys(keys);
  }
}
