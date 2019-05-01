package se.cambiosys.spider.medicalrecordsmoduleinternal;

import se.cambiosys.spider.DataService.VersionedObjectToolkit;
import se.cambiosys.spider.StorageService.BatchUpdate;
import se.cambiosys.spider.StorageService.Storage;
import se.cambiosys.spider.StorageService.StorageArea;
import se.cambiosys.spider.StorageService.StorageManager;
import se.cambiosys.spider.StorageService.StorageResult;
import se.cambiosys.spider.StructureService.DateTimeToolkit;
import se.cambiosys.spider.StructureService.SpiderException;
import se.cambiosys.spider.medicalrecordsmodule.TrainingMedicalNoteData;
import se.cambiosys.spider.shared.spiderAdaptors.CambioStorageAdaptor;
import sun.security.util.Cache;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static se.cambiosys.spider.medicalrecordsmodule.TrainingMedicalNoteData.CONTEXT;
import static se.cambiosys.spider.medicalrecordsmoduleinternal.MedicalNoteStorageConstants.*;

public class MedicalNoteStorageInternelToolkit implements MedicalNoteStorageInternelToolkitService
{
  private static MedicalNoteStorageInternelToolkit instance = null;

  /**
   * Private constructor to void external initializations.
   *
   */
  private MedicalNoteStorageInternelToolkit()
  {

  }

  /**
   * Returns the singleton object of this.
   *
   * @return
   */
  public static MedicalNoteStorageInternelToolkit getInstance()
  {
    if (instance == null)
    {
      instance = new MedicalNoteStorageInternelToolkit();
    }
    return instance;
  }


  /**
   * Returns the table information.
   *
   * @return
   */
  protected String getStorageArea()
  {
    return STORAGE_AREA;
  }

  /**
   * Returns the table domain information.
   *
   * @return
   */
  protected String getStorage()
  {
    return STORAGE;
  }


  /**
   * Returns the table columns of home care storage.
   *
   * @return
   */
  private String[] getFieldNames()
  {
    //ID , CREATOR , CREATED , REASON
    return new String[] { ACTIVE , LATEST , SIGNED , DATE_TIME , NOTETYPE , NOTETEXT , UNIT , CONTACT , CARE_PROVIDER };
  }

  /**
   * Returns the column values by given {@link TrainingMedicalNoteData} object.
   *
   * @param data
   * @return
   */
  private Object[] getValues(TrainingMedicalNoteData data)
  {
    Object[] objArr = new Object[8];
    /*objArr[0] = data.id;
    objArr[1] = data.creator;
    objArr[2] = data.created;
    objArr[3] = data.reason;*/
    objArr[0] = data.active;
    //objArr[1] = data.latest;
    objArr[2] = data.signed;
    objArr[3] = data.dateTime;
    objArr[4] = data.noteType;
    objArr[5] = data.noteText;
    objArr[6] = data.unit;
    objArr[7] = data.contact;
    objArr[8] = data.careProvider;

    return objArr;
  }



  /* (non-Javadoc)
   * @see se.cambiosys.spider.HomeCareModuleInternal.InternalHomeCareStorageToolkitService#createFromData(se.cambiosys.spider.HomeCareModule.HomeCareData)
   */
  @Override
  public long createFromData(TrainingMedicalNoteData data) throws SpiderException, RemoteException
  {
    final StorageArea storageArea = StorageManager.getStorage(getStorage()).getArea(getStorageArea());

    long key = VersionedObjectToolkit.createVersion(storageArea,CONTEXT,CREATE_REASON);

    CambioStorageAdaptor.getInstance().createOrUpdate(storageArea,data,key);
    data.versionedData.key = key;

    return 0;

    /*long key = storage.insert(getFieldNames(), getValues(data));*/
    /*new method by using CambioStorageAdaptor*/
    //long key = CambioStorageAdaptor.getInstance().create(storage,data);

    //batchMethod
    /*final BatchUpdate batchUpdate = VersionedObjectToolkit.batchVersion(storageArea, CONTEXT, "new data");
    batchUpdate.update(getFieldNames(), getValues(data));
    batchUpdate.execute();
    return batchUpdate.getKey();*/
  }

  /* (non-Javadoc)
   * @see se.cambiosys.spider.HomeCareModuleInternal.InternalHomeCareStorageToolkitService#setData(se.cambiosys.spider.HomeCareModule.HomeCareData)
   */
  @Override
  public long setData(TrainingMedicalNoteData data) throws SpiderException, RemoteException
  {

    final Storage storage = StorageManager.getStorage(getStorage());
    final StorageArea storageArea = StorageManager.getStorage(getStorage()).getArea(getStorageArea());

    long key = VersionedObjectToolkit.createVersion(storage, storageArea, CONTEXT,
                                                    data.versionedData.key,"updating with latest", null, false, false);
    CambioStorageAdaptor.getInstance().createOrUpdate(storageArea,data,key);

    data.versionedData.key = key;
    return 0;


    /*final StringBuffer condition = new StringBuffer();
    condition.append(PRIMARY_KEY).append(STR_SINGLE_SPACE).append(SQL_EQUAL).append(data.primaryKey);
    long key = storage.update(getFieldNames(), getValues(data), condition.toString());*/
    //VersionedObjectToolkit.createVersion(storage, CONTEXT, "");

    //long key = VersionedObjectToolkit.createVersion(storageArea, CONTEXT, "");
    //CambioStorageAdaptor.getInstance().createOrUpdate(storageArea,data,key);

  }


  @Override
  public TrainingMedicalNoteData getData(long primaryKey)throws SpiderException
  {
    final StorageArea storage = StorageManager.getStorage(getStorage()).getArea(getStorageArea());
    final StringBuffer where = new StringBuffer();
    where.append(PRIMARY_KEY).append(SQL_EQUAL).append(primaryKey);
    final StorageResult result = storage.select(where.toString());
    Collection<TrainingMedicalNoteData> dataClasses =
      CambioStorageAdaptor.getInstance().findByClass(result, TrainingMedicalNoteData.class);

    if (dataClasses.size() == 1)
    {
      return dataClasses.iterator().next();
    }

    return null;

    /*final int recCount = result.getRows();
    TrainingMedicalNoteData trainingMedicalNoteData = new TrainingMedicalNoteData();
    if(recCount>0)
    {
      trainingMedicalNoteData.setPrimaryKey(result.getInteger(0,0));*/
      /*trainingMedicalNoteData.setId(result.getString(1,0));
      trainingMedicalNoteData.setCreator(result.getString(2,0));
      trainingMedicalNoteData.setCreated(DateTimeToolkit.getDateTime(result.getString(3,0)));
      trainingMedicalNoteData.setReason(result.getString(4,0));*/
      /*trainingMedicalNoteData.setActive(result.getInteger(5,0));
      trainingMedicalNoteData.setLatest(result.getInteger(6,0));
      trainingMedicalNoteData.setSigned(result.getInteger(7,0));
      trainingMedicalNoteData.setDateTime(DateTimeToolkit.getDateTime(result.getString(8,0)));
      trainingMedicalNoteData.setNoteType(result.getString(9,0));
      trainingMedicalNoteData.setNoteText(result.getString(10,0));
      trainingMedicalNoteData.setUnit(result.getInteger(11,0));
      trainingMedicalNoteData.setContact(result.getInteger(12,0));
      trainingMedicalNoteData.setCareProvider(result.getInteger(13,0));
  }*/

  }

  @Override
  public long updateData(TrainingMedicalNoteData data , long key)throws SpiderException
  {
    final StorageArea area = StorageManager.getStorage(getStorage()).getArea(getStorageArea());
    final StringBuffer condition = new StringBuffer();
    condition.append(PRIMARY_KEY).append(STR_SINGLE_SPACE).append(SQL_EQUAL).append(key);
    String[] fields = { LATEST, REASON };
    Object[] values = {Long.valueOf(0),"updating to latest"};
    area.update(fields,values,condition.toString());
    CambioStorageAdaptor.getInstance().createOrUpdate(area , data , VersionedObjectToolkit.createVersion(area,CONTEXT, "Updated to latest"));
    return 0;
  }

  /** method to return List of TrainingMedicalNoteData for given keyList
   * @param keys
   * @return
   * @throws SpiderException
   */
  @Override
  public List<TrainingMedicalNoteData> getDataByKeys(long[] keys)throws SpiderException
  {
    List<TrainingMedicalNoteData> medicalNoteList = new ArrayList<TrainingMedicalNoteData>();

    final StorageArea storageArea = StorageManager.getStorage(getStorage()).getArea(getStorageArea());
    final StringBuffer where = new StringBuffer();
    Collection<TrainingMedicalNoteData> dbResult =  CambioStorageAdaptor.getInstance().findByClass(storageArea,
                                                                                         TrainingMedicalNoteData.class, getWhereClause(PRIMARY_KEY, keys));

    TrainingMedicalNoteData[] dataArray = dbResult
      .toArray(new TrainingMedicalNoteData[dbResult.size()]);

    for(TrainingMedicalNoteData trainingMedicalNoteData : dataArray)
    {
      medicalNoteList.add(trainingMedicalNoteData);
    }


    /*if(dbResult.size() > 0)
    {
      while(dbResult.iterator().hasNext()){
        TrainingMedicalNoteData obj = dbResult.iterator().next();
        medicalNoteList.add(obj);
      }
    }*/

    return medicalNoteList;
  }


  private String getWhereClause(String keyColumn, long[] key)
  {
    StringBuilder whereClause = new StringBuilder();

    addColumnInSearchToQuery(keyColumn, key, whereClause);

    return whereClause.toString();
  }


  /**
   * Add column in search to where clause
   *
   * @param column      column name
   * @param keys        keys array to add to the where clause
   * @param whereClause where clause {@link StringBuilder}
   */
  private void addColumnInSearchToQuery(String column, long[] keys, StringBuilder whereClause)
  {
    whereClause.append(column);
    whereClause.append(SQL_IN);
    whereClause.append("('");
    whereClause.append(keys[0]);

    for (int i = 1; i < keys.length; i++)
    {
      whereClause.append("','");
      whereClause.append(keys[i]);
    }

    whereClause.append("')");
  }




}
