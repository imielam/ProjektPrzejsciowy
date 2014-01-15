/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maciej.imiela.kursy.persistance;

import com.maciej.imiela.kursy.domain.User;
import java.util.List;

/**
 *
 * @author Maciej
 */
public interface KursyDAO {
    void addUser(User u);
    User getUserByID(long id);
    List<User> getAllUsers();
}
