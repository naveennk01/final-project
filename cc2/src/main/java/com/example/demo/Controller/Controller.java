package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Model;
import com.example.demo.Service.Services;


@RestController
@CrossOrigin
public class Controller {
		@Autowired
		Services s;

		@GetMapping("/get")
		public List<Model> showDetails() {
			return s.getDetails();
		}

		@PostMapping("/post")
		public String addDetails(@RequestBody Model m) {
			s.add(m);
			return "Added product " + m.getId();
		}
		@PutMapping("/update")
		public Model updateInfo(@RequestBody Model st1) {
			return s.updateDetails(st1);
		}
		
		@DeleteMapping("/delete/{vehicleNo}")
		public String deleteInfo(@PathVariable("vehicleNo") int id) {
			s.deleteDetails(id);
			return "Deleted Details";
		}

		//sorting
		@GetMapping("/product/{field}")
		public List<Model> getWithSort(@PathVariable String field) {
			return s.getSorted(field);
		}

		// pagination
		@GetMapping("/product/{offset}/{pageSize}")
		public List<Model> productsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
			return s.getWithPagination(offset, pageSize);
		}

		

}