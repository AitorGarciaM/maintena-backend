package com.maintena.maintena_backend.Specifications;

import java.sql.Date;

import org.springframework.data.jpa.domain.Specification;

import com.maintena.maintena_backend.Entities.Equipment;
import com.maintena.maintena_backend.Enums.State;

public class EquipmentSpecs {

  private EquipmentSpecs() {}
  
  public static Specification<Equipment> hasInternalId(String internalId) {
    return (root, query, criteriaBuilder) -> {
      if(internalId == null) {
        return criteriaBuilder.conjunction();
      }
      return criteriaBuilder.equal(
        criteriaBuilder.lower(root.get("internalId")),
        internalId.toLowerCase() .trim()
      );
    };
  }

  public static Specification<Equipment> hasSerialNumber(String serialNumber) {
    return (root, query, criteriaBuilder) -> {
      if(serialNumber == null) {
        return criteriaBuilder.conjunction();
      }
      return criteriaBuilder.like(
        criteriaBuilder.lower(root.get("serialNumber")),
        "%" + serialNumber.toLowerCase() + "%"
      );
    };
  }

  public static Specification<Equipment> hasName(String name) {
    return (root, query, criteriaBuilder) -> {
      if(name == null) {
        return criteriaBuilder.conjunction();
      }
      return criteriaBuilder.like(
        criteriaBuilder.lower(root.get("name")),
        "%" + name.toLowerCase() + "%"
      );
    };
  }

  public static Specification<Equipment> hasModel(String model) {
    return (root, query, criteriaBuilder) -> {
      if(model == null) {
        return criteriaBuilder.conjunction();
      }
      return criteriaBuilder.like(
        criteriaBuilder.lower(root.get("model")),
        "%" + model.toLowerCase() + "%"
      );
    };
  }

  public static Specification<Equipment> hasManufacturer(String manufacturer) {
    return (root, query, criteriaBuilder) -> {
      if(manufacturer == null) {
        return criteriaBuilder.conjunction();
      }
      return  criteriaBuilder.like(
        criteriaBuilder.lower(root.get("manufacturer")),
        "%" + manufacturer.toLowerCase() + "%"
      );
    };
  }

  public static Specification<Equipment> hasInstallationDate(Date installationDate) {
    return (root, query, criteriaBuilder) -> {
      if(installationDate == null) {
        return criteriaBuilder.conjunction();
      }
      return criteriaBuilder.equal(root.get("installationDate"), installationDate);
    };
  }

  public static Specification<Equipment> hasLocation(String location) {
    return (root, query, criteriaBuilder) -> {
      if (location == null) {
        return criteriaBuilder.conjunction();
      }
      return criteriaBuilder.like(
        criteriaBuilder.lower(root.get("location")),
        "%" + location.toLowerCase() + "%"
      );
    };
  }

  public static Specification<Equipment> hasState(State state) {
    return (root, query, criteriaBuilder) -> {
      if(state == null) {
        return criteriaBuilder.conjunction();
      }
      return criteriaBuilder.equal(root.get("state"), state);
    };
  } 

  public static Specification<Equipment> hasRetired(Boolean retired) {
    return (root, query, criteriaBuilder) -> {
      if (retired == null) {
        return criteriaBuilder.conjunction();
      }
      return criteriaBuilder.equal(root.get("retired"), retired);
    };
  }
}
