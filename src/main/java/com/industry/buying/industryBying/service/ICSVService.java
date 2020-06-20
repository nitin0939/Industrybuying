package com.industry.buying.industryBying.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface ICSVService {

	Map<String, Object> uploadData(MultipartFile file);

}
