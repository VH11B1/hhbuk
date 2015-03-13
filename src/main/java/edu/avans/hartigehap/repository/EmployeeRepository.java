package edu.avans.hartigehap.repository;

import edu.avans.hartigehap.domain.Restaurant;
import edu.avans.hartigehap.domain.planning.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;
import java.util.List;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long>, EmployeeRepositoryCustom {

    List<Employee> findByRestaurant(Restaurant restaurant);
    Employee findById(long id);

}
