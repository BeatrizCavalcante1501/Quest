import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Quest extends UnicastRemoteObject implements IQuest {
  Quest() throws RemoteException {
  };

    //Inicializa o gabarito de cada questão
  int acertos = 0;
	int errors = 0;
	String[] gabarito1 = { "V", "V", "F", "F", "V" };
	String[] gabarito2 = { "F", "F", "V", "V", "F" };
	String[] gabarito3 = { "V", "F", "V", "F", "V" };

  @Override
  public String setQuesti(String resposta) throws RemoteException {
    System.out.println("Resposta recebida pelo user: " + resposta);  //lê a resposta do usuário

		String[] respostas = resposta.split(";"); //separa as respostas através do ;
		int i;
		if(Integer.parseInt(respostas[0])==1){ //correção da 1ª questão
			for (i = 0; i < Integer.parseInt(respostas[1]); i++) {
				if (gabarito1[i].equals(String.valueOf(respostas[2].charAt(i)))) {
					acertos++;
				} else {
					errors++;
				}
			}
		}else{
			if(Integer.parseInt(respostas[0])==2){ //correção da 2ª questão
				for (i = 0; i < Integer.parseInt(respostas[1]); i++) {
					if (gabarito2[i].equals(String.valueOf(respostas[2].charAt(i)))) {
						acertos++;
					} else {
						errors++;
					}
				}
			}else{
				if(Integer.parseInt(respostas[0])==3){ //correção da 3ª questão
					for (i = 0; i < Integer.parseInt(respostas[1]); i++) {
						if (gabarito3[i].equals(String.valueOf(respostas[2].charAt(i)))) {
							acertos++;
						} else {
							errors = errors+1;
						}
					}
				}
			}
		}
		//contagem geral dos pontos
		int AcertosFinal = acertos;
		acertos = 0;
		int ErrosFinal= errors;
		errors = 0;
		//<número da questão>;<número acertos>;<número erros>
		return Integer.parseInt(respostas[0]) + ";" + Integer.toString(AcertosFinal) + ";" + Integer.toString(ErrosFinal);
  }

}


