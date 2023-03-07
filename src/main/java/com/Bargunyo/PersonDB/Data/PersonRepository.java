package com.Bargunyo.PersonDB.Data;

import com.Bargunyo.PersonDB.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

/*
 * Before we extended from CRUDRepository, but now we extend from PagingAnSorting
 * so we can have more space and pages for the data
 */

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long>, CrudRepository<Person,Long> {


    /*
    * We can create custom querys using sql language and springData.
    * In this case, we pass the ids as parameters to find de fileNames
    * */
    @Query(nativeQuery = true, value = "select photo_file_name from person where id in:ids")
    public Set<String> findFileNamesByIds (@Param("ids")Iterable<Long> ids);

}
