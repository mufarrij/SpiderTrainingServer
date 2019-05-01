package se.cambiosys.spider.medicalrecordsmodule;

import se.cambiosys.spider.DataService.VersionedData;
import se.cambiosys.spider.StructureService.DateTime;
import se.cambiosys.spider.shared.spiderAdaptors.CambioStorageAdaptorService;
import se.cambiosys.spider.shared.spiderAdaptors.CambioStorageAdaptorService.CambioColumn;
import se.cambiosys.spider.shared.spiderAdaptors.CambioStorageAdaptorService.CambioComposite;

import java.io.Serializable;

public class TrainingMedicalNoteData implements Serializable
{
  public static final String CONTEXT = "medicalrecordsmodule.TrainingMedicalNoteData";

  public long primaryKey;

 @CambioComposite(clazz = VersionedData.class)
  public VersionedData versionedData;

  /*@CambioColumn(name = "id")
  public String id;*/

  /*@CambioColumn(name = "creator")
  public String creator;

  @CambioColumn(name = "reason")
  public String reason;

  @CambioColumn(name = "created")
  public DateTime created;*/

  @CambioColumn(name = "active")
  public boolean active;

  /*@CambioColumn(name = "latest")
  public long latest;*/

  @CambioColumn(name = "signed")
  public long signed;

  @CambioColumn(name = "dateTime")
  public DateTime dateTime;

  @CambioColumn(name = "noteType")
  public String noteType;

  @CambioColumn(name = "noteText")
  public String noteText;

  @CambioColumn(name = "unit")
  public long unit;

  @CambioColumn(name = "contact")
  public long contact;

  @CambioColumn(name = "careProvider")
  public long careProvider;

  public TrainingMedicalNoteData()
  {
    versionedData = new VersionedData();
  }

  public TrainingMedicalNoteData(long primaryKey,
                                 boolean active,
                                 long signed,
                                 DateTime dateTime,
                                 String noteType,
                                 String noteText,
                                 long unit,
                                 long contact,
                                 long careProvider)
  {
    versionedData = new VersionedData();
    this.primaryKey = primaryKey;
    /*this.id = id;
    this.creator = creator;
    this.reason = reason;
    this.created = created;*/
    this.active = active;
    //this.latest = latest;
    this.signed = signed;
    this.dateTime = dateTime;
    this.noteType = noteType;
    this.noteText = noteText;
    this.unit = unit;
    this.contact = contact;
    this.careProvider = careProvider;
  }

  public void setActive(boolean active)
  {
    this.active = active;
  }

  public void setPrimaryKey(long primaryKey)
  {
    this.primaryKey = primaryKey;
  }

  /*public void setId(String id)
  {
    this.id = id;
  }

  public void setCreator(String creator)
  {
    this.creator = creator;
  }

  public void setReason(String reason)
  {
    this.reason = reason;
  }

  public void setCreated(DateTime created)
  {
    this.created = created;
  }*/

  /*public void setLatest(long latest)
  {
    this.latest = latest;
  }*/

  public void setSigned(long signed)
  {
    this.signed = signed;
  }

  public void setDateTime(DateTime dateTime)
  {
    this.dateTime = dateTime;
  }

  public void setNoteType(String noteType)
  {
    this.noteType = noteType;
  }

  public void setNoteText(String noteText)
  {
    this.noteText = noteText;
  }

  public void setUnit(long unit)
  {
    this.unit = unit;
  }

  public void setContact(long contact)
  {
    this.contact = contact;
  }

  public void setCareProvider(long careProvider)
  {
    this.careProvider = careProvider;
  }
}
