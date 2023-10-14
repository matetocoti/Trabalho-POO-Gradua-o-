package model.entities;

//region IMPORTS

import model.entities.Imoveis;

import java.util.ArrayList;
import java.util.List;


//endregion


public class Municipio {


    //Lista de imoveis
    //Pois: 1 municipio tem varios imoveis
    List<Imoveis> imoveisList = new ArrayList<>();


    //region CONSTRUTORES

    //Default
    public Municipio(){

    }

    //endregion


    public List<Imoveis> getImoveisList() {
        return imoveisList;
    }


    //region MÉTODOS

    //Método para adicionar imoveis na lista
    public void addImovel(Imoveis imovel){
        imoveisList.add(imovel);
    }

    //Método para remover imoveis na lista
    public void removeImovel(Imoveis imovel){
        imoveisList.remove(imovel);
    }

    //endregion


}
