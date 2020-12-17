package com.codehub.pf.team4.service;

import com.codehub.pf.team4.forms.PropertyForm;
import com.codehub.pf.team4.models.PropertyModel;

import java.util.List;
import java.util.Optional;

public interface PropertyService {

    List<PropertyModel>  getAllProperties();

    Optional<PropertyModel> getPropertyById(Long id);

    Optional<PropertyModel> addProperty(PropertyForm property) throws Exception;

    Optional<PropertyModel> updateProperty(PropertyForm toBeUpdatedProperty);

   boolean deletePropertyById(Long propertyId);

   Optional<PropertyForm> getPropertyByIdAsForm(Long id);
}
