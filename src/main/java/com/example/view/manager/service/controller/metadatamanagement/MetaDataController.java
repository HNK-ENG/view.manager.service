package com.example.view.manager.service.controller.metadatamanagement;


import com.example.view.manager.service.dto.common.AdaptorResponse;
import com.example.view.manager.service.repository.model.CityDetails;
import com.example.view.manager.service.repository.model.CustomerDetails;
import com.example.view.manager.service.repository.model.DistrictDetails;
import com.example.view.manager.service.repository.model.ItemDetails;
import com.example.view.manager.service.serviceinterface.MetaDataServiceInterface;
import com.example.view.manager.service.util.constants.Constants;
import com.example.view.manager.service.util.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/vms/meta-data")
public class MetaDataController {

    @Autowired
    MetaDataServiceInterface metaDataServiceInterface;

    @GetMapping("/items-drop-down")
    ResponseEntity<AdaptorResponse<List<ItemDetails>>> getItems(HttpServletRequest httpServletRequest) throws BaseException, BaseException {
        AdaptorResponse<List<ItemDetails>> adaptorResponse = metaDataServiceInterface.getItems();
        return ResponseEntity.status(HttpStatus.OK).body(adaptorResponse);
    }

    @GetMapping("/district-drop-down")
    ResponseEntity<AdaptorResponse<List<DistrictDetails>>> getDistrict(HttpServletRequest httpServletRequest) throws BaseException, BaseException {
        AdaptorResponse<List<DistrictDetails>> adaptorResponse = metaDataServiceInterface.getDistrict();
        return ResponseEntity.status(HttpStatus.OK).body(adaptorResponse);
    }

    @GetMapping("/city-drop-down")
    ResponseEntity<AdaptorResponse<List<CityDetails>>> getCity(@RequestParam(name = Constants.DISTRICT_ID) Long districtId, HttpServletRequest httpServletRequest) throws BaseException, BaseException {
        AdaptorResponse<List<CityDetails>> adaptorResponse = metaDataServiceInterface.getCity(districtId);
        return ResponseEntity.status(HttpStatus.OK).body(adaptorResponse);
    }






}
