package com.example.atlan.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atlan.controller.ClientController;
import com.example.atlan.controller.DataController;
import com.example.atlan.entity.ClientDetails;

@Service
public class DataServiceImp implements DataService {

	private static final Logger logger = LoggerFactory.getLogger(DataServiceImp.class);

	@Autowired
	private ClientController clientController;

	@Override
	public String generateExcel() throws IOException {
		logger.info("inside generateExcel of DataController class");
		List<ClientDetails> dataList = clientController.fetchAllClient();
		logger.info("response from dataList " + dataList.toString());
		// Create a new Excel workbook and sheet
		String filePath = "D:\\Project\\Atlan_project\\output.xlsx";
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Data Sheet");

		// Create a header row
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("Client ID");
		headerRow.createCell(1).setCellValue("Client Name");
		headerRow.createCell(2).setCellValue("Client Email");
		headerRow.createCell(3).setCellValue("Income Per Annum");
		headerRow.createCell(4).setCellValue("Savings Per Annum");
		headerRow.createCell(5).setCellValue("Mobile Number");

		CellStyle headerCellStyle = workbook.createCellStyle();
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerCellStyle.setFont(headerFont);

		for (int i = 0; i < dataList.size(); i++) {
			Row row = sheet.createRow(i + 1);
			Cell cell = row.createCell(0);
			row.createCell(0).setCellValue(dataList.get(i).getClientID());
			row.createCell(1).setCellValue(dataList.get(i).getClientName());
			row.createCell(2).setCellValue(dataList.get(i).getClientEmail());
			row.createCell(3).setCellValue(dataList.get(i).getIncomePerAnnum());
			row.createCell(4).setCellValue(dataList.get(i).getSavingsPerAnnum());
			row.createCell(5).setCellValue(dataList.get(i).getMobileNumber());
		}

		// Auto-size the columns for better appearance
		for (int i = 0; i < dataList.size(); i++) {
			sheet.autoSizeColumn(i);
		}

		// Write the Excel data to a file
		try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
			workbook.write(fileOut);
		} catch (IOException e) {
			// Handle the IOException here or rethrow it if necessary
			e.printStackTrace();
			throw e;
		} finally {
			// Close the workbook to release resources
			try {
				workbook.close();
				return "File Download";
			} catch (IOException e) {
				// Handle any exception that may occur while closing the workbook
				e.printStackTrace();
				logger.warn(e.getMessage());
				return "File Download Failed";

			}
		}
		// return filePath;
	}
}
