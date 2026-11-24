package com.maintena.maintena_backend.Repositories;

import  java.util.List;
import java.sql.Date;

import  org.springframework.data.repository.CrudRepository;
import  org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.maintena.maintena_backend.Entities.Equipment;
import com.maintena.maintena_backend.Enums.State;

public interface EquipmentRepository extends CrudRepository<Equipment, Long>,JpaSpecificationExecutor<Equipment> {

  Equipment findByInternalId(String internalID);
  List<Equipment> findBySerialNumber(String serialNumber);
  List<Equipment> findByName(String name);
  List<Equipment> findByModel(String model);
  List<Equipment> findByManufacturer(String manufacturer);
  List<Equipment> findByInstallationDate(Date installationDate);
  List<Equipment> findByLocation(String location);
  List<Equipment> findByState(State state);
  List<Equipment> findByRetired(Boolean retired);
  boolean existsByInternalId(String internalID);
  boolean existsByInternalIdAndIdNot(String internalId, Long id);
}
