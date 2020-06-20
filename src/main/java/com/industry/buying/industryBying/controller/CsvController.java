package com.industry.buying.industryBying.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.industry.buying.industryBying.service.ICSVService;

@RestController
@RequestMapping("/csv/*")
public class CsvController {

	@Autowired
	private ICSVService csvService;
	
    @PostMapping("uploadData")
    public Map<String, Object> pingFileName(@RequestParam("file") MultipartFile file) {
        return csvService.uploadData(file);
    }
}
