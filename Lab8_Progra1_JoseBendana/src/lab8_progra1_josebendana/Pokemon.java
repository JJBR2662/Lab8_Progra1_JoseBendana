package lab8_progra1_josebendana;

import java.util.Scanner;

import java.util.ArrayList;

import java.util.Random;

public class Pokemon {
    
    public String nombre;
    public int vida;
    public int pegar;
    public int luck;

    public Pokemon(String nombre, int vida, int pegar, int luck) {
        this.nombre = nombre;
        this.vida = vida;
        this.pegar = pegar;
        this.luck = luck;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getPegar() {
        return pegar;
    }

    public void setPegar(int pegar) {
        this.pegar = pegar;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    @Override
    public String toString() {
        return "Pokemon{" + "nombre=" + nombre + ", vida=" + vida + ", pegar=" + pegar + ", luck=" + luck + '}';
    }
    
    
    
}
