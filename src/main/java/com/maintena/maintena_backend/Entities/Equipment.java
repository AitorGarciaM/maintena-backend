package com.maintena.maintena_backend.Entities;

import java.sql.Timestamp;
import java.sql.Date;

import com.maintena.maintena_backend.Enums.State;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity 
public class Equipment {
  @Id 
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name="internal_id", nullable = false, unique = true)
  private String internalId;
  @Column(name="serial_number", nullable = false)
  private String serialNumber;
  @Column(nullable = false)
  private String name;
  @Column(nullable = false)
  private String model;
  @Column(nullable = false)
  private String manufacturer;
  @Column(name= "installation_date", nullable = false)
  private Date installationDate;
  @Column(nullable = false)
  private String location;
  @Column(nullable = false)
  private State state = State.OPERATIVE;
  @Column(nullable = false)
  private Boolean retired = false;
  @Column(name="created_at", nullable = false)
  private Timestamp createdAt;
  @Column(name = "updated_at")
  private Timestamp updatedAt;
  @Column(name = "retired_at")
  private Timestamp retiredAt;

  protected Equipment() {

  }

  public Equipment(String internalId, String serialNumber, String name, String model, String manufacturer, Date installationDate, String location, State state, Boolean retired) {
    this.internalId = internalId;
    this.serialNumber = serialNumber;
    this.name = name;
    this.model = model;
    this.manufacturer = manufacturer;
    this.installationDate = installationDate;
    this.location = location;
    this.state = (state != null) ? state : State.OPERATIVE;
    this.retired = (retired != null) ? retired : false;
  }

  @PrePersist 
  protected void onCreate() {
    this.createdAt = new Timestamp(System.currentTimeMillis());
    this.updatedAt = createdAt;
  }

  @PreUpdate 
  protected void onUpdate() {
    this.updatedAt = new Timestamp(System.currentTimeMillis());
  }

  @Override
  public String toString() {
    return String.format(
        "Equipment[id=%s, internal id=%s, serial_number=%s, name=%s, model=%s, manufacturer=%s, installation date = %s, location = %s, state = %s, retired = %b]",
        id, internalId, serialNumber, name, model, manufacturer, installationDate, location, state, retired
    );
  }

  // Getters.
  public Long getId() {
    return id;
  }

  public String getInternalId(){
    return internalId;
  }

  public String getSerialNumber() {
    return serialNumber;
  }

  public String getName() {
    return name;
  }

  public String getModel() {
    return model;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public Date getInstallationDate() {
    return installationDate;
  }

  public String getLocation() {
    return location;
  }

  public State getState() {
    return state;
  }

  public Boolean getRetired() {
    return retired;
  }

  public Timestamp getCreatedAt() {
    return createdAt;
  }

  public Timestamp getUpdatedAt() {
    return updatedAt;
  }

  public Timestamp getRetiredAt() {
    return retiredAt;
  }

  //Setters.
  public void setInternalId(String internalId) {
    this.internalId = internalId;
  }

  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public void setInstallationDate(Date installationDate) {
    this.installationDate = installationDate;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public void setState(State state) {
    this.state = state;
  }

  public void retireEquipment() {
    if(!this.retired)
    {
      this.retired = true;
      this.retiredAt = new Timestamp(System.currentTimeMillis());
    }
  }
}
