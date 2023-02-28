package com.example.view.manager.service.service;


import com.example.view.manager.service.dto.common.AdaptorResponse;
import com.example.view.manager.service.dto.common.Result;
import com.example.view.manager.service.repository.CityDetailsRepository;
import com.example.view.manager.service.repository.DistrictDetailsRepository;
import com.example.view.manager.service.repository.ItemsDetailsRepository;
import com.example.view.manager.service.repository.model.CityDetails;
import com.example.view.manager.service.repository.model.CustomerDetails;
import com.example.view.manager.service.repository.model.DistrictDetails;
import com.example.view.manager.service.repository.model.ItemDetails;
import com.example.view.manager.service.serviceinterface.MetaDataServiceInterface;
import com.example.view.manager.service.util.constants.Constants;
import com.example.view.manager.service.util.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetaDataService implements MetaDataServiceInterface {

    @Autowired
    ItemsDetailsRepository itemsDetailsRepository;

    @Autowired
    DistrictDetailsRepository districtDetailsRepository;

    @Autowired
    CityDetailsRepository cityDetailsRepository;

    @Override
    public AdaptorResponse<List<ItemDetails>> getItems() throws BaseException {
        try {
            List<ItemDetails> itemDetails = itemsDetailsRepository.findAll();
            Result result = Result.builder().resultCode(Constants.SUCCESS_CODE).resultDescription(Constants.SUCCESS_DESCRIPTION).build();
            return AdaptorResponse.<List<ItemDetails>>builder().data(itemDetails).result(result).build();

        } catch (Exception ex) {
            throw new BaseException(ex.getMessage(), Constants.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR, Constants.INTERNAL_SERVER_ERROR_CODE, null);
        }
    }

    @Override
    public AdaptorResponse<List<DistrictDetails>> getDistrict() throws BaseException {
        try {
            List<DistrictDetails> districtDetails = districtDetailsRepository.findAll();
            Result result = Result.builder().resultCode(Constants.SUCCESS_CODE).resultDescription(Constants.SUCCESS_DESCRIPTION).build();
            return AdaptorResponse.<List<DistrictDetails>>builder().data(districtDetails).result(result).build();

        } catch (Exception ex) {
            throw new BaseException(ex.getMessage(), Constants.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR, Constants.INTERNAL_SERVER_ERROR_CODE, null);
        }    }

    @Override
    public AdaptorResponse<List<CityDetails>> getCity(Long districtId) throws BaseException {
        try {
            List<CityDetails> cityDetails = cityDetailsRepository.findByDistrictId(districtId);
            Result result = Result.builder().resultCode(Constants.SUCCESS_CODE).resultDescription(Constants.SUCCESS_DESCRIPTION).build();
            return AdaptorResponse.<List<CityDetails>>builder().data(cityDetails).result(result).build();

        } catch (Exception ex) {
            throw new BaseException(ex.getMessage(), Constants.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR, Constants.INTERNAL_SERVER_ERROR_CODE, null);
        }
    }


}
