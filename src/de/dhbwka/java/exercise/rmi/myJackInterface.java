package de.dhbwka.java.exercise.rmi;

import java.rmi.RemoteException;

public interface myJackInterface {

    /**
     * Should execute the Test and send TestResult back when finished running
     *
     * @param test
     * @throws RemoteException
     */
    void sendTest(Test test) throws RemoteException;

}
