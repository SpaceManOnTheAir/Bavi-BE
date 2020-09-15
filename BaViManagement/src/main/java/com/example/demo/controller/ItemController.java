package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ItemRepository;
import com.example.demo.dao.SubCategoryRepository;
import com.example.demo.dto.ItemDto;
import com.example.demo.entity.Item;
import com.example.demo.entity.MainCategory;
import com.example.demo.entity.SubCategory;
import com.example.demo.model.ErrorDetails;
import com.example.demo.service.ItemService;
import com.example.demo.service.MainService;
import com.example.demo.service.SubCategoryService;

@RestController
@RequestMapping(value = "/item")
public class ItemController {

	@Autowired
	private  ItemService itemService;
	
	@PostMapping(value = "")
	public Item createItem(@RequestBody @Valid ItemDto anItemDto, BindingResult result) {
		if(result.hasErrors()) throw new IllegalArgumentException("Invalid data Item");
		return itemService.createItem(anItemDto);
	}
	
	@GetMapping(value = "")
	public List<Item> listAllItem(){
		return itemService.listAll();
	}
	
	@GetMapping(value = "/{id}")
	public Item getAnItem(@PathVariable(value = "id") Integer id){
		return itemService.getAnItem(id);
	}
	
	@PutMapping(value = "/{id}")
	public Item updateAnItem(@PathVariable(value = "id") Integer id, @RequestBody ItemDto itemDto){
		return itemService.updateItem(id, itemDto);
	}


	

	
	
	

	
	
	
	

	
	
	
}
