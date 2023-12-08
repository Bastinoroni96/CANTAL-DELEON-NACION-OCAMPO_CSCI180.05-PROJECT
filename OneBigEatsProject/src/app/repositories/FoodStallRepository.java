package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entities.FoodStall;

public interface FoodStallRepository extends JpaRepository<FoodStall, String>
{ 
	public FoodStall findByName (String name); 
	void deleteByName(String name);
}
