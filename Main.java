import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        Scanner leiaString = new Scanner(System.in);

        ArrayList<Participante> participante = new ArrayList<>(); 
        Participante part = null;

        int matricula = 1;
        int contE = 0; //eliminados
        int contT=0;  //total
        boolean op = true;

        while(op == true){
            //cadastro
            System.out.println("\n\n\n===========CADASTRO================\n");
            System.out.print("Número de matrícula: ");
            matricula = leia.nextInt();
            while(matricula != 0 && (matricula < 100 || matricula > 200)){
                System.out.println("--Matrícula Incorreta.--");
                System.out.println("--Tente novamente--");
                System.out.print("\nNúmero de matrícula: ");
                matricula = leia.nextInt();
                
            }   //while
            if(matricula != 0){  
            System.out.print("\nIdade: ");
            int idade = leia.nextInt();
            while (idade < 18 || idade > 60) {
                System.out.println("-Essa idade não corresponde aos do requisito para o concurso.-");
                System.out.println("--Tente novamente--");
                System.out.print("\nIdade: ");
                idade = leia.nextInt();
            }//while
                
            System.out.print("\nGênero: 'F/M' \t\t");
            char genero = leiaString.next().charAt(0);
            while (!compChar(genero, 'f') && !compChar(genero, 'm')) {
                System.out.println("-Gênero não identificado-");
                System.out.println("-Por Favor tente novamente-");
                System.out.print("\nGênero: 'F/M' \t\t");
                genero = leiaString.next().charAt(0);
            }//while
                
            System.out.println("\nPontuação do participante na prova de quesitos gerais: ");
            int qGerais = leia.nextInt();
            System.out.println("Pontuação do participante na prova de quesitos específicos: ");
            int qEsp = leia.nextInt();

            while ((qEsp<0 ||qEsp>50)||(qGerais<0 ||qGerais>50)) {
                System.out.println("-Nota incorreta-");
                System.out.println("-Por Favor tente novamente-");
                
                System.out.println("\nPontuação do participante na prova de quesitos gerais: ");
                qGerais = leia.nextInt();
                System.out.println("Pontuação do participante na prova de quesitos específicos: ");
                qEsp = leia.nextInt();
            }//while
            part = new Participante(matricula, idade, genero, qGerais, qEsp);
            participante.add(part);

            if( part.getStatus() == "ELIMINADO"){     
                contE++;
            }

        }//if matricula ==0
            else{
                break;
            }//else


            contT++;
        }   //while

        double percElim = (contE * 100)/contT;
        
        double maxMedia = Double.MIN_VALUE; 

        // maior valor de média
        for (Participante parti : participante) {
            if (parti.getMediaP() > maxMedia) {
                maxMedia = parti.getMediaP();
            }
        }//for

        // participante com a maior média
        for (Participante parti : participante) {
            if (parti.getMediaP() == maxMedia) {
                part = parti;
                break; 
            }
        }//for

        int contF = 0;
        int contM = 0;

        // contagem de genero
        for (Participante gen : participante) {
            if (gen.getGenero() == Character.toLowerCase('f')) {
                contF++;
            
            }
            else if (gen.getGenero() == Character.toLowerCase('m')) {
                contM++;
            
            }

        }//for

        System.out.println("\n\n=====Resultado Final==========");
        System.out.println("1° Lugar: "+ part.toString());
        System.out.println("\nPercentual de Eliminados: "+percElim+"%");
        System.out.println("\nNº de Mulheres: "+contF);
        System.out.println("Nº de Homens: "+contM);

    }//main

    public static boolean compChar(char c1, char c2) {
        return Character.toLowerCase(c1) == Character.toLowerCase(c2);
    }//compChar

}//public
