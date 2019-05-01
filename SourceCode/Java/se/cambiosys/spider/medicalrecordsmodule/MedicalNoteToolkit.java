package se.cambiosys.spider.medicalrecordsmodule;

import se.cambiosys.client.framework.DefaultExceptionHandler;
import se.cambiosys.spider.DataService.BasicToolkit;
import se.cambiosys.spider.StructureService.SpiderException;
import se.cambiosys.spider.medicalrecordsmoduleinternal.MedicalNoteInternalToolkit;
import se.cambiosys.spider.medicalrecordsmoduleinternal.MedicalNoteInternalToolkitHome;

import java.rmi.RemoteException;
import java.util.List;

/**
 * <p> Title: MedicalNoteToolkit.java </p>
 * <p> Description: This is the public toolkit of training project server module.</p>
 *
 * @author M.Mufarrij
 * @version 1.0
 */
public class MedicalNoteToolkit
{
   private static MedicalNoteToolkit instance = null;

  /**
   * Private constructor to void external inits.
   *
   */
  private MedicalNoteToolkit()
  {

  }

  /**
   * Returns singleton object.
   *
   * @return
   */
  public static MedicalNoteToolkit getInstance()
  {
    if (instance == null)
    {
      instance = new MedicalNoteToolkit();
    }
    return instance;
  }

  /**
   * @return connection string
   * @throws SpiderException
   */
  public String getDataFromToolKit() throws SpiderException
  {
    try
    {
      return getInternalBean().getInternelData();
    }
    catch (RemoteException e)
    {
      DefaultExceptionHandler.getInstance().handleThrowable(e);
    }
    return "";
  }


  /**
   * Set given {@link se.cambiosys.spider.medicalrecordsmodule.TrainingMedicalNoteData} object.
   *
   * @param data
   * @return
   * @throws SpiderException
   */
  public long setData(TrainingMedicalNoteData data) throws SpiderException
  {
    try
    {
      return getInternalBean().setData(data);
    }
    catch (RemoteException e)
    {
      DefaultExceptionHandler.getInstance().handleThrowable(e);
    }
    return 0;
  }


  /**
   * This will create the additional infoFromData by given {@link se.cambiosys.spider.medicalrecordsmodule.TrainingMedicalNoteData}.
   *
   * @param data
   * @return
   * @throws SpiderException
   */
  public long createAdditionalInfoFromData(TrainingMedicalNoteData data) throws SpiderException
  {
    try
    {
      return getInternalBean().createAdditionalInfoFromData(data);
    }
    catch (RemoteException e)
    {
      DefaultExceptionHandler.getInstance().handleThrowable(e);
    }
    // This line is never reached. Just put in for compilation
    return -1;
  }


  public TrainingMedicalNoteData getTraininMedicalNoteData(long key) throws SpiderException
  {
    try
    {
      return getInternalBean().getData(key);
    }catch (RemoteException e)
    {
      DefaultExceptionHandler.getInstance().handleThrowable(e);
    }
    return null;
  }

  public long updateData(TrainingMedicalNoteData data, long key)throws SpiderException
  {
    try
    {
      return getInternalBean().updateData(data,key);
    }catch (RemoteException e)
    {
      DefaultExceptionHandler.getInstance().handleThrowable(e);
    }
    return -1;
  }


  public List<TrainingMedicalNoteData> getDataByKeys(long[] keys)throws SpiderException
  {
    try
    {
      return getInternalBean().getDataByKeys(keys);
    }catch (RemoteException e)
    {
      DefaultExceptionHandler.getInstance().handleThrowable(e);
    }
    return null;
  }




  /**
   * This will fetch the Function Plug-in Internal Bean Component
   *
   * @return
   * @throws SpiderException
   */
    public MedicalNoteInternalToolkit getInternalBean() throws SpiderException
    {
      try
      {
        Object obj = BasicToolkit.getInternalEJB("medicalrecordsmoduleinternal/MedicalNoteInternalToolkit",
                                                 MedicalNoteInternalToolkitHome.class);
        return ((MedicalNoteInternalToolkitHome) obj).create();
      }
      catch (Exception e)
      {
        DefaultExceptionHandler.getInstance().handleThrowable(e);
      }
      throw new Error("Shouldnt reach");
    }

}
