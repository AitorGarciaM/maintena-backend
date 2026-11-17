package com.maintena.maintena_backend.Controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.maintena.maintena_backend.Entities.Equipment;
import com.maintena.maintena_backend.Enums.State;
import com.maintena.maintena_backend.Services.EquipmentService;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController 
public class EquipmentController {
  private final EquipmentService equipmentService;

  EquipmentController(EquipmentService equipmentService) {
    this.equipmentService = equipmentService;
  }

  @GetMapping("/equipment")
  public List<Equipment> getAllEquipment(
    @RequestParam(required = false) String internalID,
    @RequestParam(required = false) String serialNumber,
    @RequestParam(required = false) String name,
    @RequestParam(required = false) String model,
    @RequestParam(required = false) String manufacturer,
    @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date installationDate,
    @RequestParam(required = false) String location,
    @RequestParam(required = false) State state,
    @RequestParam(required = false)  Boolean retired
  ) {
    return equipmentService.searchFilteredEquipment(internalID, serialNumber, name, model, manufacturer, installationDate, location, state, retired);
  }
  
  @GetMapping("/equipment/{id}")
  public Equipment getMethodName(@PathVariable long id) {
      return equipmentService.getEquipmentById(id);
  }

  @PostMapping("/equipment")
  @ResponseStatus(HttpStatus.CREATED)
  public Equipment creaEquipment(@RequestBody Equipment newEquipment) {
    return equipmentService.registerEquipment(newEquipment);
  }

  @PatchMapping("/equipment/{id}")
  public Equipment updateEquipment(@RequestBody Equipment newEquipment, @PathVariable Long id) {
    return equipmentService.updateEquipment(id, newEquipment);
  }

  @PatchMapping("/equipment/{id}/retire")
  public Equipment retireEquipment(@PathVariable Long id) {
    return equipmentService.retireEquipment(id);
  }
  
}
