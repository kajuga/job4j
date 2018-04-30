package ru.job4j.profession;

public class Doctor extends Profession {

    public Diagnose heal(Patient pacient) {
        return new Diagnose();
    }
}


