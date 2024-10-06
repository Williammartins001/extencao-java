import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Gestão {
    private static Scanner input = new Scanner(System.in);


    // MENSAGEM DE BOAS VINDA AOS USUARIO COM DATA EW HORA

   // public static void inicio (String[] args) {
        // Criar um objeto Date com a data atual
     //   Date dataAtual = new Date();
       // System.out.println("OLÁ SEJA BEM VINDO AO SISTEMA DE COLETORES \n" + dataAtual);
    //}


    // MONTANDO UM ARRAY PARA ARMAZENAR OS COLETORES EM USO
    private static ArrayList <Coletor> coletores;

    //MAP PARA VISUALIZAR OS COLETOES E FAZER INSERÇÃO E REMOÇÃO
    private static HashMap <Coletor, Integer> usando;

    public static void main (String [] args){

        Date dataAtual = new Date();
        System.out.println("OLÁ SEJA BEM VINDO AO SISTEMA DE COLETORES \n" + dataAtual);

        coletores = new ArrayList<>();
        usando = new HashMap<>();
        menu ();
    }

    private static void menu () {
        System.out.println("--------------------------------------");
        System.out.println("------- GESTÃO DOS COLETORES ---------");
        System.out.println("--------------------------------------");
        System.out.println("---QUAL OPÇÃO VOCÊ DESEJA REALIZAR?---");
        System.out.println("--------------------------------------");
        System.out.println("|   OPÇÃO 1 - USAR COLETOR       |");
        System.out.println("|   OPÇÃO 2 - DEVOLVER COLETOR   |");
        System.out.println("|   OPÇÃO 3 - COLETORES EM USO   |");
        System.out.println("|   OPÇÃO 4 - EVENTUALIDADE      |");
        System.out.println("|   OPÇÃO 5 - SAIR               |");

        int option = input.nextInt();

// OPÇOES BASEADAS NA ESCOLA DO USUARIO USANDO SWITCH
        switch (option) {
            case 1:
                usarColetores();
                break;
            case 2:
                devolverColetor();
                break;
            case 3:
                procurarColetor();
                break;
            case 4:
               // eventualidadeColetores();
                break;
            case 5:
                System.out.println("TURNO ENCERRADO");
                System.exit(0);
            default:
                System.out.println("OPÇAO INVALIDA!");
                menu();
                break;
        }

    }
// ADICIONANDO UM COLETOR A LISTA:
    private static void  usarColetores (){
        System.out.println("NOME DO COLETOR:");
        String nome = input.next();

        System.out.println("MATRICULA DO USUARIO:");
        int matricula = input.nextInt();

        System.out.println("COLABORADOR:");
        String funcionario = input.next();

        System.out.println("TURNO:");
        String turno = input.next();

        Coletor coletor = new Coletor(nome,matricula,funcionario,turno);
        coletores.add(coletor);

        System.out.println(coletor.getNome() + "COLETOR REGISTRADO COM SUCESSO!");
        menu();
    }
// DEVOLVENDO UM COLETOR QUE QUE FOU USADO
    private static void devolverColetor () {
        System.out.println( coletores + "COLETORES QUE ESTÃO SENDO USADOS");
        coletores.remove(input.next());
        System.out.println("COLETOR REMOVIDO COM SUCESSO AGORA RESTA:" + coletores);
        menu();

    }
//COLETORES QUE ESTÃO SENDO USADOS
    private static void procurarColetor() {
        System.out.println("COLETORES EM OPERAÇÃO \n");
        for (Coletor c : coletores) {
            System.out.println(c + "\n");
            menu();
        }
    }
}




