package de.dhbwka.java.exercise.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TestJackInterface extends Remote {

    /**
     * Send its own reference, to be able to callback later on it from the server and send tests
     *
     * @param client
     * @throws RemoteException
     */
    void sendReadyState(MyJackRunner client) throws RemoteException;

    void sendTestResult(String result) throws RemoteException; //TODO: change String to TestResult

}
