import java.rmi.registry.*;
import java.util.Scanner;

public class QuestClient {

    public static void main(String[] args) {
        try {
            //obtem uma referencia para o registro do RMI
            Registry registry = LocateRegistry.getRegistry("localhost");
            //obtem a stub do servidor
            IQuest stub = (IQuest) registry.lookup("quest");
            //chama o metodo do servidor e imprime a mensagem
            Scanner in = new Scanner(System.in);
            String resp="";
            System.out.println("Para sair digite \"s\"\n");
           while(!resp.equals("s")){
                System.out.print("Por favor, digite uma resposta: ");
                //<número da questão>;<número alternativas>;<respostas>
                resp = in.next();
                //mostra a correção
                System.out.println("\nResultado: "+stub.setQuesti(resp)+"\n");
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


