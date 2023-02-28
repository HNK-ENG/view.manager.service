package com.example.view.manager.service.serviceinterface;

import com.example.view.manager.service.dto.common.AdaptorResponse;
import com.example.view.manager.service.repository.model.CityDetails;
import com.example.view.manager.service.repository.model.DistrictDetails;
import com.example.view.manager.service.repository.model.ItemDetails;
import com.example.view.manager.service.util.exception.BaseException;

import java.util.List;

public interface MetaDataServiceInterface {
    AdaptorResponse<List<ItemDetails>> getItems() throws BaseException;

    AdaptorResponse<List<DistrictDetails>> getDistrict() throws BaseException;

    AdaptorResponse<List<CityDetails>> getCity(Long districtId) throws BaseException;
}
