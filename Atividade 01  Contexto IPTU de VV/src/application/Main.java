package application;

//region IMPORTS

//Pegando todas as classes dentro de entities
import model.entities.*;

import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.Locale;



//endregion


public class Main {
    public static void main(String[] args) {

        //region INSTANCIANDO

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        //Instanciando municipio
        Municipio municipio = new Municipio();

        //endregion

        //region ENTRADA


        //Pegando quantos imoveis serão registrados pelo InOut como String
        int n = Integer.parseInt(JOptionPane.showInputDialog("Quantos imóveis serão registrados?"));


        //Pegando dados dos n-imoveis
        for (int i = 0 ; i < n ; i++){

            //Pegando o nome
            String nomeDoProprietario = JOptionPane.showInputDialog("#"+(i+1)+" Nome do proprietário:");

            //Pegando o valor do imposto
            double valorDoImposto = Double.parseDouble(JOptionPane.showInputDialog("#"+(i+1)+" Valor do imposto:"));


            //Retorno: se yes =  0  se nao = 1
            int temAtraso = JOptionPane.showConfirmDialog(null, "#"+(i+1)+" Tem imposto atrasado?");


            //Se tem atraso
            if(temAtraso ==  0){

                //Pegando os meses de atraso
                int mesesDeAtraso = Integer.parseInt(JOptionPane.showInputDialog("#"+(i+1)+" Meses de atraso:"));


                //Instanciado imoveis já dentro da lista de imoveis
                municipio.addImovel(new Imoveis(nomeDoProprietario ,valorDoImposto ,mesesDeAtraso));

            }
            //Senão
            else
            {
                municipio.addImovel(new Imoveis(nomeDoProprietario ,valorDoImposto));
            }

        }




        //endregion

        //region SAIDA DE DADOS
        int count = 1;
        System.out.println("Dados imóveis:");
        //Iterando lista de imoveis
        for(Imoveis imoveis : municipio.getImoveisList()){
            //Exibindo dados dos imóveis em uma interface
            JOptionPane.showMessageDialog(null ,String.format("Dados #%d imóvel: %n%s",count,imoveis));
            count++;
        }
        //endregion

        input.close();
    }


}