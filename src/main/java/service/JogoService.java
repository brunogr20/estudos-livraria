package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

import entities.*;
@Named
@ApplicationScoped
public class JogoService {

     
    public List<Livro> createCars(int size) {
        List<Livro> list = new ArrayList<Livro>();
        System.out.println(list);
        for(int i = 0 ; i < size ; i++) {
           //list.add(new Jogo(getRandomId(), getRandomBrand(), getRandomYear(), getRandomColor(), getRandomPrice(), getRandomSoldState()));
       // list.add(new Jogo(i,"xxxxx", "zzzzzzz"));
        }
        return list;
    }
     

}