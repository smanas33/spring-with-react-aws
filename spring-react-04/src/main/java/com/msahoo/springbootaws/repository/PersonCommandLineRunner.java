package com.msahoo.springbootaws.repository;

import com.msahoo.springbootaws.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PersonCommandLineRunner implements CommandLineRunner {
    @Autowired
    private PersonJpaRepository repository;

    @Autowired
    private PersonSpringJPARepository springJPARepository;

    @Override
    public void run(String... args) throws Exception {
        /*******************************/
        /** JPA Repository usage       */
        /*******************************/

        repository.insert(new Person(11, "Manas", "BBSR"));
        repository.insert(new Person(22, "Shubham", "Pune"));
        repository.insert(new Person(33, "Rakesh", "Bengaluru"));

        repository.deleteByID(22);

        System.out.println(repository.findById(11));
        System.out.println(repository.findById(33));

        /******************************/
        /**Spring JPA Repository usage*/
        /******************************/

        springJPARepository.save(new Person(44, "Amol", "Akola"));
        springJPARepository.save(new Person(55, "Banty", "Kolkata"));
        springJPARepository.save(new Person(66, "Litan", "Jajpur"));

        springJPARepository.deleteById(44L);

        System.out.println(springJPARepository.findById(55L));
        System.out.println(springJPARepository.findById(66L));
        System.out.println("*****************************************");
        System.out.println(springJPARepository.findByAddress("Kolkata"));
        System.out.println(springJPARepository.findByAddress(""));
    }
}
