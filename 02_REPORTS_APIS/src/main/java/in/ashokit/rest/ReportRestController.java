package in.ashokit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.request.SearchRequest;
import in.ashokit.response.SearchResponse;
import in.ashokit.service.ReportService;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class ReportRestController {

	@Autowired
	private ReportService reportService;

	@GetMapping("/plans")
	public ResponseEntity<List<String>> getPlanNames() {
		List<String> planNames = reportService.getUniquePlanNames();
		return new ResponseEntity<>(planNames, HttpStatus.OK);
	}
	
	@GetMapping("/statuses")
	public ResponseEntity<List<String>> getPlanStatuses(){
		List<String> planStatuses = reportService.getUniquePlanStatuses();
		return new ResponseEntity<>(planStatuses, HttpStatus.OK);
	}
	
	@PostMapping("/search")
	public ResponseEntity<List<SearchResponse>> search(@RequestBody SearchRequest request){
		List<SearchResponse> response = reportService.search(request);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping("/excel")
	public void excelReport(HttpServletResponse response) throws Exception {
		
		response.setContentType("application/octet-stream");
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=data.xls";
		
		response.setHeader(headerKey, headerValue);
		
		reportService.generateExcel(response);
		
	}
	
	@GetMapping("/pdf")
	public void pdfReport(HttpServletResponse response) throws Exception {
		
		response.setContentType("application/pdf");
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=data.pdf";
		
		response.setHeader(headerKey, headerValue);
		
		reportService.generatePdf(response);
	}
}
