package com.richieoscar.dogsgraph.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.richieoscar.dogsgraph.entity.Dog;
import com.richieoscar.dogsgraph.exceptions.DogNotFoundException;
import com.richieoscar.dogsgraph.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
public class DogMutation implements GraphQLMutationResolver {


    @Autowired
    private DogRepository repository;

    public DogMutation(){

    }

    public Dog addDog(String name, String breed, String origin){
        Dog dog = new Dog();
        dog.setName(name);
        dog.setBreed(breed);
        dog.setOrigin(origin);
         repository.save(dog);
         return dog;
    }

    public boolean deleteDog(Long id){
        repository.deleteById(id);
        return true;

    }

    public Dog updateDog(Long id, String name, String breed, String origin){
        Optional<Dog> dog = repository.findById(id);
        if(dog.isPresent()){
            Dog newDOg = dog.get();
            newDOg.setName(name);
            newDOg.setBreed(breed);
            newDOg.setOrigin(origin);
            repository.save(newDOg);
            return newDOg;
        }
        else{
            throw new DogNotFoundException("Dog not Found", id);
        }
    }
}
