import java.rmi.registry.*;

public class QuestServer {
	public static void main(String[] args) {
		try {
			System.out.println("Iniciando Servidor...");
			IQuest stub = new Quest();
			Registry registry = LocateRegistry.getRegistry();
			//cria o registro quest
			registry.rebind("quest", stub);
			System.out.println("Servidor pronto");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


