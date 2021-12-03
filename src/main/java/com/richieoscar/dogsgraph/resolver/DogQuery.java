package com.richieoscar.dogsgraph.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.richieoscar.dogsgraph.entity.Dog;
import com.richieoscar.dogsgraph.exceptions.DogNotFoundException;
import com.richieoscar.dogsgraph.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DogQuery implements GraphQLQueryResolver {
    private DogRepository dogRepository;

    @Autowired
    public DogQuery(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Iterable<Dog> findAllDogs(){
        return dogRepository.findAll();
    }

    public Dog findDogById(Long id){
        Optional<Dog> dog = dogRepository.findById(id);
        if (dog.isPresent()){
            return dog.get();
        }
        else throw new DogNotFoundException("Dog not found", id);
    }

}
