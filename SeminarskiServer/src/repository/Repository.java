/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;

/**
 *
 * @author Nikola
 */
public interface Repository<T> {
    
    T add(T t) throws Exception;
    void edit(T t) throws Exception;
    void delete(T t) throws Exception;
    List<T> getAll(T t) throws Exception;
    List<T> getList(T t, String query) throws Exception;
    T get(T t, String query) throws Exception;
    
}
