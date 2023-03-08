package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Model.Model;
import com.example.demo.Repository.Repo;

@Service
public class Services {

		@Autowired
		Repo r;
		
		public String add(Model m) {
			r.save(m);
			return "Added";
		}
		
		public List<Model> getDetails() {
			return r.findAll();
		}
		
		public Model updateDetails(Model e1) {
			return r.saveAndFlush(e1);
		}
		
		public void deleteDetails(int id) {
			r.deleteById(id);
		}
		
		public List<Model> getSorted(String field) {
			return r.findAll(Sort.by(Sort.Direction.ASC,field));
		}
		
		public List<Model> getWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
			Page<Model> page =r.findAll(PageRequest.of(offset, pageSize));
			return page.getContent();
		}


}