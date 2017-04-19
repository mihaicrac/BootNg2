package com.crac.heroes.controller;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.crac.heroes.domain.Hero;
import com.crac.heroes.repository.HeroRepository;


@Transactional
@org.springframework.web.bind.annotation.RestController
public class HelloController {
	
	HeroRepository db;
	
	@Autowired
	public void setDb(HeroRepository db) {
		this.db = db;
	}
	
	
	@RequestMapping("/api/hello")
	public String greet() {
		
		return "Hello from the other side!!!";
	}
	
	
	

	@RequestMapping(value = "/api/heroes", method = RequestMethod.GET)
	public List<Hero> findAll() {
		return db.findAll();
		
	}
	
	
	
	@RequestMapping(value = "/api/heroes", method = RequestMethod.POST)
	public Hero save(@RequestBody Hero h){
		db.save(h);
		System.out.println(h.getName()+","+h.getId());
		return db.findByName(h.getName());
		
	}
	
	@RequestMapping(value = "/api/heroes/{param}", method = RequestMethod.DELETE)
	public Hero delete(@PathVariable Long param) {
		
		Hero h = db.findById(param);
		System.out.println(h.getName());
		db.delete(h);
		return h;
	}
	
	
	
	@RequestMapping(value = "/api/heroes/{param}", method = RequestMethod.GET)
	public Hero get(@PathVariable Long param) {
		
		Hero h = db.findById(param);
		
		return h;
	}
	
	
	@RequestMapping(value = "/api/heroes/{param}", method = RequestMethod.PUT)
	public Hero update(@RequestBody Hero h) {
		
		System.out.println(h.getName()+"jhkhj"+h.getId());
		
		Hero sH = db.findById(h.getId());
		
		System.out.println(sH.getName()+"jhkhj"+sH.getId());
		
		sH.setName(h.getName());
		
		return sH;
	}
	
	
	@RequestMapping(value = "/api/heroes/", method = RequestMethod.GET)
	public List<Hero> search(@RequestParam String name) {
		System.out.println("asdasd:"+name);
		List<Hero> l = db.findNameLike(name);
		return l;
	}
	
}