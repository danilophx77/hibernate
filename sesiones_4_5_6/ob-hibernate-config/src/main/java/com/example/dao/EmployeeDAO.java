package com.example.dao;

import com.example.entities.Employee;

import java.util.List;

/**
 * Data Access Object
 *
 * Métodos CRUD - Create Retrieve Update Delete
 */
public interface EmployeeDAO {

    /**
     * Recuperar todos los empleados de base de datos de la tabla employees
     * Utiliza HQL
     * @return lista de empleados
     */
    List<Employee> findAll();

    /**
     * Recuperar todos los empleados de base de datos de la tabla employees
     * Utiliza Criteria
     * @return lista de empleados
     */
    List<Employee> findAllCriteria();

    /**
     * Busca un empleado por su id
     * Utiliza métodos de Hibernate
     * @return empleado
     */
    Employee findById(Long id);

    /**
     * Busca un empleado por su id
     * Criteria
     * @return empleado
     */
    Employee findByIdCriteria(Long id);

    /**
     * Busca todos los empleados por edad
     * @param age
     * @return
     */
    List<Employee> findByAge(Integer age);

    /**
     * Filtrar por apellido
     * Criteria utilizando like
     * @param lastName
     * @return
     */
    List<Employee> findByLastNameLikeCriteria(String lastName);

    /**
     * Filtrar por edad. Mayor de determinado número
     * Criteria
     * @param age
     * @return
     */
    List<Employee> findByAgeGreaterCriteria(Integer age);

    /**
     * Filtrar por rango de edad entre dos números
     * Criteria
     * @param min
     * @param max
     * @return
     */
    List<Employee> findByAgeBetweenCriteria(Integer min, Integer max);

    /**
     * Inserta un nuevo registro en la tabla employees
     * @param employee
     * @return
     */
    Employee create(Employee employee);

    /**
     * Actualiza un registro existente en la tabla employees
     * @param employee
     * @return
     */
    Employee update(Employee employee);

    /**
     * Borra un empleado de la tabla employees
     * @param id
     * @return
     */
    boolean deleteById(Long id);//se devuelve un bollean si tiene que borrarse

}
