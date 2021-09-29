package de.dhbwka.java.exercise.rmi;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class MyJackRunner implements myJackInterface, Serializable {

    private static TestJackInterface runner;
    private static String SERVER_IP = "//localhost/MyRunner";

    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
        MyJackRunner runner = new MyJackRunner();
    }

    public MyJackRunner() throws RemoteException, MalformedURLException, NotBoundException {
        runner = (TestJackInterface) Naming.lookup(SERVER_IP);
        runner.sendReadyState(this);
    }

    @Override
    public void sendTest(final Test test) throws RemoteException {
        System.out.println("Succesfully sent " + test.toString() + " to client");
    }
}
