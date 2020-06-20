package com.industry.buying.industryBying.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.industry.buying.industryBying.response.searchResponse;
import com.industry.buying.industryBying.service.ICSVService;
import com.industry.buying.industryBying.service.ISearchService;
import com.industry.buying.industryBying.service.impl.SearchServiceImpl;

@RestController
@RequestMapping("/search")
public class SearchController {

	@Autowired
	private ISearchService searchService;
	
    @GetMapping()
    public searchResponse pingSearch(@RequestParam("query") String query) {
        return searchService.searchQuery(query);
    }
}
