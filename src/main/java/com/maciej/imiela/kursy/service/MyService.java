/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maciej.imiela.kursy.service;

import java.util.List;

import javax.inject.Inject;

import com.maciej.imiela.kursy.domain.User;
import com.maciej.imiela.kursy.persistance.KursyDAO;

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

	public List<User> getAllUsers() {
		return null;
	}

	public User getUser(long id) {
		return kursyDAO.getUserByID(id);
	}

	public void saveUser(User u) {
		kursyDAO.addUser(u);
	}
}
