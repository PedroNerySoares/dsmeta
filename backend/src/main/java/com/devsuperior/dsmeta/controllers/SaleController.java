package com.devsuperior.dsmeta.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.services.SaleService;

@Controller
@RequestMapping("/sales")
public class SaleController {
	@Autowired
	private SaleService service;
	
	@GetMapping
	public ResponseEntity<List<Sale>> findSales(){
		
		
		return ResponseEntity.ok().body(service.findSales());
//		return (List<Sale>) ResponseEntity.ok().body(service.findSales());
	}
}
