package com.codehub.pf.team4.service;

import com.codehub.pf.team4.domains.Property;
import com.codehub.pf.team4.forms.PropertyForm;
import com.codehub.pf.team4.mappers.PropertyFormMapper;
import com.codehub.pf.team4.mappers.PropertyMapper;
import com.codehub.pf.team4.models.PropertyModel;
import com.codehub.pf.team4.repository.PropertyRepository;
import com.codehub.pf.team4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<PropertyModel> getAllProperties() {
        return PropertyMapper.mapToPropertyModelList(propertyRepository.findAll());
    }

    @Override
    public Optional<PropertyModel> getPropertyById(Long id) {
        return PropertyMapper.mapToPropertyModelOptional(propertyRepository.findById(id).orElse(null));
    }


    @Override
    public Optional<PropertyModel> addProperty(PropertyForm newProperty) {
        Property property = PropertyFormMapper.mapToProperty(newProperty);
        property.setUser(userRepository.findById(property.getUser().getId()).get());
        return PropertyMapper.mapToPropertyModelOptional(propertyRepository.save(property));
    }

    @Override
    public Optional<PropertyModel> updateProperty(PropertyForm toBeUpdatedProperty) {
        Property property = PropertyFormMapper.mapToProperty(toBeUpdatedProperty);
        Property originalProperty = propertyRepository.findById(Long.parseLong(toBeUpdatedProperty.getId())).get();

        if (property.equals(originalProperty)) {
            return PropertyMapper.mapToPropertyModelOptional(property);
        }
        property.setUser(originalProperty.getUser());
        return PropertyMapper.mapToPropertyModelOptional(propertyRepository.save(property));
    }

    @Override
    public boolean deletePropertyById(Long propertyId) {
        if (propertyId == null || getPropertyById(propertyId).isEmpty()) {
            System.out.println("Property not found");
            return false;
        }
        propertyRepository.deleteById(propertyId);
        return true;
    }



}
