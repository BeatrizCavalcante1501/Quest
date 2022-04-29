
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IQuest extends Remote {
    public String setQuesti(String resp) throws RemoteException;
}
