package com.industry.buying.industryBying.service;

import org.springframework.web.multipart.MultipartFile;

import com.industry.buying.industryBying.response.searchResponse;

public interface ISearchService {

	searchResponse searchQuery(String query);

}
