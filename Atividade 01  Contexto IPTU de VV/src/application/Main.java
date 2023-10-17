package application;

//region IMPORTS

//Pegando todas as classes dentro de entities
import model.entities.*;
import javax.swing.JOptionPane;
import java.util.Locale;



//endregion

/*

NumberFormatException

*/
public class Main {
    public static void main(String[] args) {

        //region ENTRADA

        try{

            Locale.setDefault(Locale.US);

            //Instanciando municipio
            Municipio municipio = new Municipio();

            //Pegando quantos imoveis serão registrados pelo InOut como String
            int n = Integer.parseInt(JOptionPane.showInputDialog("Quantos imóveis serão registrados?"));


            //Pegando dados dos n-imoveis
            for (int i = 0; i < n; i++) {



                // Pegando o nome
                String nomeDoProprietario = JOptionPane.showInputDialog("#" + (i + 1) + " Nome do proprietário:");

                // TRIM() --> remove os espaços em branco no início e no final do nome
                // E se nome  depois da remoção dos espaços em branco não tem nenhum caractere
                // ISEMPTY() --> Ele retorna 1|True ou se tiver caracter ele retorna 0|False

                //OBS: Eu usei isso para checar se o campo do nome está vazio ou não

                // Enquanto o campo do nome estiver vazio...
                while(nomeDoProprietario.trim().isEmpty()){
                    // Exibindo messagem de ajuda
                    JOptionPane.showMessageDialog(null ,"O campo do nome está vazio!");
                    //Pedindo nome novamente
                    nomeDoProprietario = JOptionPane.showInputDialog("#" + (i + 1) + " Nome do proprietário:");
                }



                //Pegando o valor do imposto
                double valorDoImposto = Double.parseDouble(JOptionPane.showInputDialog("#" + (i + 1) + " Valor do imposto:"));


                //Retorno: se yes =  0  se nao = 1
                int temAtraso = JOptionPane.showConfirmDialog(null, "#" + (i + 1) + " Tem imposto atrasado?");


                // Se tem atraso
                if (temAtraso == 0) {

                    // Pegando os meses de atraso
                    int mesesDeAtraso = Integer.parseInt(JOptionPane.showInputDialog("#" + (i + 1) + " Meses de atraso:"));


                    // Instanciado imoveis já dentro da lista de imoveis

                    municipio.addImovel(new Imoveis(nomeDoProprietario, valorDoImposto, mesesDeAtraso));


                }
                // Senão
                else {
                    municipio.addImovel(new Imoveis(nomeDoProprietario, valorDoImposto));
                }

            }


            //endregion

            //region SAIDA DE DADOS
            int count = 1;
            //Iterando lista de imoveis
            for (Imoveis imoveis : municipio.getImoveisList()) {
                    //Exibindo dados dos imóveis em uma interface
                    JOptionPane.showMessageDialog(null, String.format("Dados #%d imóvel: %n%s", count, imoveis));
                    count++;
            }
            //endregion

        }
        catch(RuntimeException runtimeException){
            JOptionPane.showMessageDialog(null ,"Error: " + runtimeException.getMessage());
        }
        finally {
            JOptionPane.showMessageDialog(null ,"Encerrando...");
        }
    }


}