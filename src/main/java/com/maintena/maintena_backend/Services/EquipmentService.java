package com.maintena.maintena_backend.Services;

import java.util.List;
import java.sql.Date;

import org.springframework.stereotype.Service;

import com.maintena.maintena_backend.Entities.Equipment;
import com.maintena.maintena_backend.Enums.State;
import com.maintena.maintena_backend.Repositories.EquipmentRepository;
import com.maintena.maintena_backend.Specifications.EquipmentSpecs;

import  org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

@Service 
public class EquipmentService {
  
  @Autowired
  EquipmentRepository equipmentRepository;

  public EquipmentService(EquipmentRepository equipmentRepository) {
    this.equipmentRepository = equipmentRepository;
  }

  // Register new equipment.
  public Equipment registerEquipment(Equipment equipment) {
    return equipmentRepository.save(equipment);
  }

  // Get equipment by ID.
  public Equipment getEquipmentById(long id) {
    return equipmentRepository.findById(id).orElseThrow(() -> new RuntimeException("The Equipment with id: " + id + " is not found."));
  }

  // Get active equipment.
  public List<Equipment> getActiveEquipments() {
    return equipmentRepository.findByRetired(false);
  }

  // Update the equipment fields.
  public Equipment updateEquipment(long id, Equipment newEquipment) {
    Equipment oldEquipment = getEquipmentById(id);

    oldEquipment.setInternalId(newEquipment.getInternalId());
    oldEquipment.setSerialNumber(newEquipment.getSerialNumber());
    oldEquipment.setName(newEquipment.getName());
    oldEquipment.setModel(newEquipment.getModel());
    oldEquipment.setManufacturer(newEquipment.getManufacturer());
    oldEquipment.setInstallationDate(newEquipment.getInstallationDate());
    oldEquipment.setLocation(newEquipment.getLocation());
    oldEquipment.setState(newEquipment.getState());

    equipmentRepository.save(oldEquipment);

    return oldEquipment;
  }

  // Retire equipment.
  public Equipment retireEquipment(long id) {
    Equipment retiredEquipment = getEquipmentById(id);
    
    if(retiredEquipment.getRetired())
    {
      return retiredEquipment;
    }

    retiredEquipment.retireEquipment();

    equipmentRepository.save(retiredEquipment);

    return retiredEquipment;
  }

  // Filter equipment by fields.
  public List<Equipment> searchFilteredEquipment(String internalId, String serialNumber, String name, String model, String manufacturer, Date installationDate, State state, Boolean retired) {
    
    Boolean retiredField = (retired != null && retired) ? null : false;
    
    Specification<Equipment> spec = Specification.where(EquipmentSpecs.hasInternalId(internalId))
                                                 .and(EquipmentSpecs.hasSerialNumber(serialNumber))
                                                 .and(EquipmentSpecs.hasName(name))
                                                 .and(EquipmentSpecs.hasModel(model))
                                                 .and(EquipmentSpecs.hasManufacturer(manufacturer))
                                                 .and(EquipmentSpecs.hasInstallationDate(installationDate))
                                                 .and(EquipmentSpecs.hasState(state))
                                                 .and(EquipmentSpecs.hasRetired(retiredField));
    return equipmentRepository.findAll(spec);
  } 
}
