
package com.crac.heroes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.crac.heroes.domain.Hero;

public interface HeroRepository extends JpaRepository<Hero, Long>{
	public Hero findByName(String name);
	
	public Hero findById(Long id);
	
	public List<Hero> findAllByName(String name);
	
	@Query("select u from Hero u where u.name like %?1%")
	public List<Hero> findNameLike(String name);
}
