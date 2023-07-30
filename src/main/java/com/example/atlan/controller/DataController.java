package com.example.atlan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.atlan.entity.ClientDetails;
import com.example.atlan.service.DataService;
import com.example.atlan.controller.ClientController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/*
 * DataController contains all the end point to download data
 */
@RestController
public class DataController {

	private static final Logger logger = LoggerFactory.getLogger(DataController.class);

	@Autowired
	private ClientController clientController;
	@Autowired
	private DataService dataService;

	@GetMapping("/downloadexcel")
	public String generateExcel() throws IOException {
		logger.info("inside generateExcel of DataController class");
		return dataService.generateExcel();
	}

}
