package com.astrotalk.FriendApplication.controller;
import com.astrotalk.FriendApplication.entity.*;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.ByteArrayInputStream;
import java.net.URI;
import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.Map;

import com.astrotalk.FriendApplication.userfriendsrequest.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.astrotalk.FriendApplication.service.FriendsService;

@RestController
public class FriendController {
	
	
@Autowired
private FriendsService friendsService;


	
	@RequestMapping(value ="/getProductDetails", method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> productDetails(@RequestParam String url)
	{
		return this.friendsService.getProductDetails(url);
		
		
	}
	
	@RequestMapping(value ="/downloadPdf", method = RequestMethod.POST,produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> downloadPdf(@RequestBody ProductBean product)
	{
		
		String url = product.getUrl();
		String name = product.getProduct().getName();
		String imageURL = product.getProduct().getImageURL();
		String description = product.getProduct().getDescription();
		String price = product.getProduct().getPrice();
		String totalReviews = product.getProduct().getTotalReviews();
		ByteArrayInputStream bis = this.friendsService.downloadPdf(name, imageURL, description, price, totalReviews);
		
		
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
		
		
	}

}
