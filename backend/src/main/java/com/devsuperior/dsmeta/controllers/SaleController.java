package com.devsuperior.dsmeta.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.services.SaleService;
import com.devsuperior.dsmeta.services.SmsService;

@Controller
@RequestMapping("/sales")
public class SaleController {
	@Autowired
	private SaleService service;
	@Autowired
	private SmsService smsService;
	
	@GetMapping
//	public ResponseEntity<List<Sale>> findSales(){
	public ResponseEntity<Page<Sale>> findSales(
												@RequestParam(value="minDate",defaultValue = "") String minDate,
												@RequestParam(value="maxDate",defaultValue = "") String maxDate,
												Pageable pageable){
		
		
		return ResponseEntity.ok().body(service.findSales(minDate,maxDate,pageable));
//		return (List<Sale>) ResponseEntity.ok().body(service.findSales());
	}
	@GetMapping("/{id}/notification")
	public ResponseEntity<Sale> notify(@PathVariable Long id) {
		smsService.sendSms(id);
		return ResponseEntity.status(200).body(null);
	}
	
}
