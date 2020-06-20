package com.industry.buying.industryBying.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.industry.buying.industryBying.model.SearchDataModel;


public interface SearchRespository {

    List<SearchDataModel> findByQuery(String query);

}
