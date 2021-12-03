package com.richieoscar.dogsgraph.repository;

import com.richieoscar.dogsgraph.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long>{

}
