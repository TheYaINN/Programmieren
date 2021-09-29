package de.dhbwka.java.exercise.rmi;

import javax.swing.JOptionPane;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TestJackServer extends UnicastRemoteObject implements TestJackInterface {

    private static final long serialVersionUID = 1L;

    private final Object clientReadyState = new Object();
    private MyJackRunner client;

    protected TestJackServer() throws RemoteException {
        super();
    }

    public static void main(String[] args) {
        try {
            TestJackServer server = new TestJackServer();
            Naming.rebind("//localhost/MyRunner", server);
            System.out.println("Server ready");
            server.waitForReady();
        } catch (RemoteException | MalformedURLException e) {
            System.err.println("Server Exception: " + e.getMessage());
        }
    }

    private void waitForReady() throws RemoteException {
        synchronized (clientReadyState) {
            try {
                System.out.println("Waiting for client");
                clientReadyState.wait();
                System.out.println("finished waiting for client");

                JOptionPane.showMessageDialog(null, "Client is ready");
                client.sendTest(new Test("Test2"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void sendReadyState(MyJackRunner client) throws RemoteException {
        synchronized (clientReadyState) {
            clientReadyState.notifyAll();
        }
        this.client = client;
    }

    @Override
    public void sendTestResult(final String result) throws RemoteException {
        System.out.println(result);
    }
}
