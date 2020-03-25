package org.peddi.java.se11.lambdas;

import java.time.LocalDate;
import java.time.Period;

public class Person {

    public Person(String name, LocalDate birthday, SEX gender, String emailAdress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAdress = emailAdress;
    }

    public enum SEX {
        MALE,
        FEMALE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public SEX getGender() {
        return gender;
    }

    public void setGender(SEX gender) {
        this.gender = gender;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public Integer getAge(){
            Period p = Period.between(birthday, LocalDate.now());
            return  p.getYears();
    }

    @Override
    public String toString() {
        return ("\n\n name : " + name+ "\n gender: " + gender + "\n birthday: " + birthday + "\n email:  " + emailAdress + "\n age: "+ getAge());
    }


    String name;
    LocalDate birthday;
    SEX gender;
    String emailAdress;
}
