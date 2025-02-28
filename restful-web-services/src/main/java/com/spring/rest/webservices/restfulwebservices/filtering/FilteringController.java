package com.spring.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	@Autowired
	private SomeBeanService service;
	
	@GetMapping(path = "/filtering")
	public MappingJacksonValue retrieveSomeBean() {
		SomeBean someBean = new SomeBean("value1", "value2", "value3");
		
//		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.
//				filterOutAllExcept("field1", "field2");
//		
//		FilterProvider filters = new SimpleFilterProvider().
//				addFilter("SomeBeanFilter", filter);
//		
//		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
//		mapping.setFilters(filters);
		
		MappingJacksonValue mapping = service.filteredSomeBeans(someBean);
		
		return mapping;
	}
	
	@GetMapping(path = "/filtering-list")
	public List<SomeBean> retrieveListOfSomeBeans() {
		return Arrays.asList(new SomeBean("value1", "value2", "value3"),
				new SomeBean("value11", "value22", "value33"));
	}
}
