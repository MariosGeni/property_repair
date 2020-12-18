package com.codehub.pf.team4.controller.admin;

import com.codehub.pf.team4.enums.HouseType;
import com.codehub.pf.team4.forms.PropertyForm;
import com.codehub.pf.team4.forms.RepairForm;
import com.codehub.pf.team4.models.PropertyModel;
import com.codehub.pf.team4.service.PropertyService;
import com.codehub.pf.team4.service.UserService;
import com.codehub.pf.team4.utils.GlobalAttributes;
import com.codehub.pf.team4.utils.validators.PropertyValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminPropertyController {

    private final String PROPERTY = "property";
    private final String PROPERTIES = "properties";
    private final String IS_PRESENT = "isPresent";
    private final String PROPERTY_FORM = "propertyForm";
    private final String HOUSE_TYPE = "HOUSE_TYPE";

    @Autowired
    private UserService userService;

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private PropertyValidator propertyValidator;

    @InitBinder(PROPERTY_FORM)
    protected  void initBinder(final WebDataBinder binder) { binder.addValidators(propertyValidator); }

    // *************************************************** //
    // ======================= PROPERTIES =================== //
    // *************************************************** //

    @GetMapping(value = "properties")
    public String getAdminPropertiesPage(Model model) {
        // --- properties showcase here --- //
        model.addAttribute(PROPERTIES, propertyService.getAllProperties());
        return "pages/admin-properties-view";
    }

    @GetMapping(value = "properties/{id}")
    public String getAdminPropertyPage(Model model, @PathVariable("id")Long id){
        Optional<PropertyModel> theProperty = propertyService.getPropertyById(id);
        if (theProperty.isEmpty()) return "redirect:/admin/properties";

        model.addAttribute(PROPERTY, theProperty.get());
        return "pages/admin-property-view";
    }

    @GetMapping(value = "properties/search")
    public String getAdminSearchPropertyPAge(Model model, @RequestParam(value = "propertyId", defaultValue = "") String propertyId,
                                             @RequestParam(value = "afm",defaultValue = "") String afm){
        // --- search code here --- //
        List<PropertyModel> properties = new ArrayList<>();
        if(!afm.equals("")) properties = userService.getPropertiesByUserAfm(afm);
        else if(!propertyId.equals("")) properties.add( propertyService.getPropertyByPropertyId(Long.parseLong(propertyId)).get());

        model.addAttribute(PROPERTIES,properties);
        return "pages/admin-search-properties-view";
    }

    @GetMapping(value = "/properties/create")
    public String getAdminCreatePropertiesPage(Model model){
        model.addAttribute(PROPERTY_FORM, new PropertyForm());
        model.addAttribute(HOUSE_TYPE, HouseType.values());
        return "pages/admin-create-properties-view";
    }

    @GetMapping(value = "properties/edit/{id}") //Edit property by its id
    public String getAdminEditPropertiesPage(@PathVariable("id")Long id,Model model){
        Optional<PropertyForm> theProperty =propertyService.getPropertyByIdAsForm(id);
        if (theProperty.isEmpty()) return "redirect:/admin/properties";  // redirect to all properties if property with this id not found

        model.addAttribute(PROPERTY_FORM,theProperty.get());
        model.addAttribute(HOUSE_TYPE, HouseType.values());
        model.addAttribute(IS_PRESENT, theProperty.isPresent());

        return "pages/admin-edit-properties-view";
    }

    @PostMapping("/properties/create")
    public String postAdminCreateProperty(Model model, @Valid @ModelAttribute(PROPERTY_FORM) PropertyForm propertyForm,
                                          BindingResult bindingResult) throws Exception{
        if (bindingResult.hasErrors()) {
            model.addAttribute(GlobalAttributes.ERROR_MESSAGE, "Invalid values caught during creation");
            model.addAttribute(HOUSE_TYPE, HouseType.values());

            return "pages/admin-create-properties-view";
        }
        Optional<PropertyModel> newProperty = propertyService.addProperty(propertyForm);
        if(newProperty.isEmpty()) return "pages/admin-create-properties-view";
        return "redirect:/admin/properties/" + newProperty.get().getId();
    }

    @PostMapping(value = "properties/edit/{id}") //Edit property by id
    public String putPropertyEditOwnersPage(Model model, @Valid @ModelAttribute(PROPERTY_FORM) PropertyForm propertyForm,
                                            BindingResult bindingResult, @PathVariable Long id) {
        if(bindingResult.hasErrors()){
            model.addAttribute(HOUSE_TYPE, HouseType.values());
            model.addAttribute(GlobalAttributes.ERROR_MESSAGE,"Invalid values caught during update");
            return  "pages/admin-edit-properties-view";
        }

        Optional<PropertyModel> theProperty = propertyService.updateProperty(propertyForm);
        if(theProperty.isEmpty()) return "pages/admin-edit-properties-view";
        return "redirect:/admin/properties/" + theProperty.get().getId();
    }
    @PostMapping(value = "properties/delete/{id}")
    public String deleteProperty(@PathVariable("id") Long id,Model model){
        if(propertyService.deletePropertyById(id)){
            model.addAttribute(GlobalAttributes.ERROR_MESSAGE, "The ID you submitted to delete does not exist");
        }
        return "redirect:/admin/properties";
    }
}
