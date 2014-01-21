/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maciej.imiela.kursy.domain;

import java.util.Objects;

/**
 *
 * @author Maciej
 */
public class Course {
    private String name;
    private String description;
    private int maxNumber;

    public Course(){}
    
    public Course(String name, String description, int maxNumber) {
        this.name = name;
        this.description = description;
        this.maxNumber = maxNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.name);
        hash = 31 * hash + Objects.hashCode(this.description);
        hash = 31 * hash + this.maxNumber;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Course other = (Course) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (this.maxNumber != other.maxNumber) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Course{" + "name=" + name + ", description=" + description + ", maxNumber=" + maxNumber + '}';
    }
    
    
    
    
}
