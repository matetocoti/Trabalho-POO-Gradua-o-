package model.entities;

//region IMPORTS

//import model.exception.DomainException;

//endregion


public class Imoveis {

    //region ATRIBUTOS
    private String nomeDoProprietario;
    private Double imposto;
    private Integer mesesDeAtraso;
    //endregion

    //region CONSTRUTORES

    //Default
    public Imoveis(){

    }
    //Caso não tenha Meses de atraso
    public Imoveis(String nomeDoProprietario, Double imposto) {
        this.nomeDoProprietario = nomeDoProprietario;
        this.imposto = imposto;
    }
    //Caso tenha
    public Imoveis(String nomeDoProprietario, Double imposto, Integer mesesDeAtraso) {
        this.nomeDoProprietario = nomeDoProprietario;
        this.imposto = imposto;
        this.mesesDeAtraso = mesesDeAtraso;
    }
    //endregion

    //region GETTERS AND SETTERS

    public String getNomeDoProprietario() {
        return nomeDoProprietario;
    }

    public void setNomeDoProprietario(String nomeDoProprietario) {
        this.nomeDoProprietario = nomeDoProprietario;
    }

    public Double getImposto() {
        return imposto;
    }

    public void setImposto(Double imposto) {
        this.imposto = imposto;
    }

    public Integer getMesesDeAtraso() {
        return mesesDeAtraso;
    }

    public void setMesesDeAtraso(Integer mesesDeAtraso) {
        this.mesesDeAtraso = mesesDeAtraso;
    }


    //endregion

    //region MÉTODOS

    public Double calcularMulta() {

        double percentualMulta;

        //Se houver atraso checando o percentual Multa da multa
        if (mesesDeAtraso < 6)
        {
            percentualMulta = 0.01;
        }
        else if (mesesDeAtraso >= 6 && mesesDeAtraso < 9)
        {
            percentualMulta = 0.023;
        }
        else if (mesesDeAtraso >= 9 && mesesDeAtraso < 11)
        {
            percentualMulta = 0.03;
        }
        else if (mesesDeAtraso >= 11 && mesesDeAtraso < 12)
        {
            percentualMulta = 0.054;
        }
        else if (mesesDeAtraso >= 12)
        {
            percentualMulta = 0.10;
        }
        else
        {
            // Se não houver multa
            //Retornando apenas o valor do imposto sem acrecimos
            return imposto;
        }

        //Calculando e retornando o valor da multa
        return (imposto * percentualMulta);
    }

    //Subscrevendo Método to string
    //meu Tostring personalizado
    @Override
    public String toString() {
        //Se tem atraso...
       if(mesesDeAtraso != null){
           return
                   "Nome Do Proprietário: " + nomeDoProprietario + "\n" +
                           "Imposto: R$" + String.format("%.2f",imposto) + "\n" +
                           "Multa: R$" + String.format("%.2f",calcularMulta()) + "\n"+
                           "Meses De Atraso: " + mesesDeAtraso + "\n";
       }
       else//Senão
       {
           return
                   "Nome Do Proprietário: " + nomeDoProprietario + "\n"+
                           "Imposto: R$" + String.format("%.2f" ,imposto)+"\n";
       }
    }

    //endregion
}
