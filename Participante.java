

public class Participante {

        int matricula;
        int idade;
        char genero;
        int qGerais;
        int qEsp;
        String status;
        double mediaP;

        
        public Participante() {
        }

        public Participante (int matricula, int idade, char genero, int qGerais, int qEsp) {
            this.matricula = matricula;
            this.idade = idade;
            this.genero = genero;
            this.qGerais = qGerais;
            this.qEsp = qEsp;
            statusPart(qGerais,qEsp);
        }

        public int getMatricula() {
            return matricula;
        }

        public int getIdade() {
            return idade;
        }

        public char getGenero() {
            return genero;
        }

        public int getqGerais() {
            return qGerais;
        }

        public int getqEsp() {
            return qEsp;
        }
        
        public String getStatus() {
            return status;
        }

        public double getMediaP() {
            return mediaP;
        }

        public void statusPart(int qGerais, int qEsp){
            
            if(qGerais == 0 || qEsp == 0  ){
                this.status = "ELIMINADO";
                calcMedia(qGerais,qEsp);
            } else{
                this.status = "APROVADO";
                calcMedia(qGerais,qEsp);
            }
            
        }
        
        public void calcMedia(int qGerais, int qEsp){
            this.mediaP = ((qGerais*4)+(qEsp*6))/6+4;
        }

        @Override
        public String toString() {
            return "\nMatricula: " + matricula + "\t\t Média: " + mediaP ;
        }
        
}// class
