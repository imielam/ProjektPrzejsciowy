/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maciej.imiela.kursy.service;

import com.maciej.imiela.kursy.domain.User;
import com.maciej.imiela.kursy.persistance.KursyDAO;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Maciej
 */
public class MyService {
    private KursyDAO kursyDAO;

    public KursyDAO getKursyDAO() {
        return kursyDAO;
    }

    @Inject
    public void setKursyDAO(KursyDAO kursyDAO) {
        this.kursyDAO = kursyDAO;
    }
    
    public List<User> getAllUsers(){
        return null;
    }
    public User getUser(long id){
        return kursyDAO.getUserByID(id);
    }
}
