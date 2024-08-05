/*
 * IUserService.java
 * This is a service for user entity
 * Author: Sinethemba Sithela (219112940)
 * Date: 26/08/2023
 */


package za.ac.cput.service;

import za.ac.cput.domain.User;

import java.util.List;

public interface IUserService extends IService<User, Integer>{
    List<User> getAll();
}
