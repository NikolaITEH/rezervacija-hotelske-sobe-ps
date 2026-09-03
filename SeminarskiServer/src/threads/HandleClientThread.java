/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import controller.Controller;
import domain.Drzava;
import domain.Gost;
import domain.Recepcioner;
import domain.Rezervacija;
import domain.Soba;
import domain.StrucnaSprema;
import java.net.Socket;

/**
 *
 * @author Nikola
 */
public class HandleClientThread extends Thread {

    private final Socket socket;
    private final Sender sender;
    private final Receiver receiver;
    private final ServerThread serverThread;
    private Recepcioner loggedInRecepcioner;

    public HandleClientThread(Socket socket, ServerThread serverThread) {
        this.socket = socket;
        this.sender = new Sender(socket);
        this.receiver = new Receiver(socket);
        this.serverThread=serverThread;
    }

    @Override
    public void run() {
        while (!socket.isClosed()) {
            try {
                Request request = (Request) receiver.receive();
                Response response = handleRequest(request);
                sender.send(response);
            } catch (Exception ex) {
                System.out.println("Klijent je prekinuo vezu: " + ex.getMessage());
                serverThread.removeClient(this);
                try {
                    socket.close();                 //da ne bi bacao exception beskonacno kad se klijent odveze
                } catch (Exception closeEx) {
                    closeEx.printStackTrace();
                }
                return;
            }
        }
    }

    private Response handleRequest(Request request) {
        Response response = new Response();
        try {
            switch (request.getOperation()) {
                case LOGIN:
                    Recepcioner r = (Recepcioner) request.getArgument();
                    r=Controller.getInstance().login(r);
                    if(serverThread.isRecepcionerLoggedIn(r)){
                        throw new Exception("Recepcioner je vec ulogovan na drugom uredjaju");
                    }
                    loggedInRecepcioner=r;
                    response.setResult(r);                  
                    break;
                case GET_ALL_DRZAVA:
                    response.setResult(Controller.getInstance().getAllDrzava());
                    break;
                case ADD_GOST:
                    Gost gAdd=(Gost) request.getArgument();
                    response.setResult(Controller.getInstance().addGost(gAdd));
                    break;
                case EDIT_GOST:
                    Gost gEdit=(Gost) request.getArgument();
                    Controller.getInstance().editGost(gEdit);
                    break;
                case GET_GOST_LIST_BY_GOST:
                    Gost g=(Gost) request.getArgument();
                    response.setResult(Controller.getInstance().getGostListByGost(g));
                    break;
                case GET_GOST_LIST_BY_DRZAVA:
                    Drzava d=(Drzava) request.getArgument();
                    response.setResult(Controller.getInstance().getGostListByDrzava(d));
                    break;
                case GET_GOST:
                    Gost gGet=(Gost) request.getArgument();
                    response.setResult(Controller.getInstance().getGost(gGet));
                    break;
                case DELETE_GOST:
                    Gost gDelete=(Gost) request.getArgument();
                    Controller.getInstance().deleteGost(gDelete);
                    break;
                case ADD_STRUCNA_SPREMA:
                    StrucnaSprema sAdd=(StrucnaSprema) request.getArgument();
                    response.setResult(Controller.getInstance().addStrucnaSprema(sAdd));
                    break;
                case EDIT_STRUCNA_SPREMA:
                    StrucnaSprema sEdit=(StrucnaSprema) request.getArgument();
                    Controller.getInstance().editStrucnaSprema(sEdit);
                    break;
                case GET_ALL_STRUCNA_SPREMA:
                    response.setResult(Controller.getInstance().getAllStrucnaSprema());
                    break;
                case GET_ALL_RECEPCIONER:
                    response.setResult(Controller.getInstance().getAllRecepcioner());
                    break;
                case GET_ALL_GOST:
                    response.setResult(Controller.getInstance().getAllGost());
                    break;
                case GET_ALL_SOBA:
                    response.setResult(Controller.getInstance().getAllSoba());
                    break;
                case ADD_REZERVACIJA:
                    Rezervacija rAdd=(Rezervacija) request.getArgument();
                    response.setResult(Controller.getInstance().addRezervacija(rAdd));
                    break;
                case EDIT_REZERVACIJA:
                    Rezervacija rEdit=(Rezervacija) request.getArgument();
                    Controller.getInstance().editRezervacija(rEdit);
                    break;
                case GET_REZERVACIJA:
                    Rezervacija rGet=(Rezervacija) request.getArgument();
                    response.setResult(Controller.getInstance().getRezervacija(rGet));
                    break;   
                case DELETE_REZERVACIJA:
                    Rezervacija rDelete=(Rezervacija) request.getArgument();
                    Controller.getInstance().deleteRezervacija(rDelete);
                    break;
                case GET_REZERVACIJA_LIST_BY_REZERVACIJA:
                    Rezervacija rGetRez=(Rezervacija) request.getArgument();
                    response.setResult(Controller.getInstance().getRezervacijaListByRezervacija(rGetRez));
                    break;
                case GET_REZERVACIJA_LIST_BY_GOST:
                    Gost rGetGost=(Gost) request.getArgument();
                    response.setResult(Controller.getInstance().getRezervacijaListByGost(rGetGost));
                    break;
                case GET_REZERVACIJA_LIST_BY_RECEPCIONER:
                    Recepcioner rGetRec=(Recepcioner) request.getArgument();
                    response.setResult(Controller.getInstance().getRezervacijaListByRecepcioner(rGetRec));
                    break;
                case GET_REZERVACIJA_LIST_BY_SOBA:
                    Soba rGetSoba=(Soba) request.getArgument();
                    response.setResult(Controller.getInstance().getRezervacijaListBySoba(rGetSoba));
                    break;
                case LOGOUT:
                    loggedInRecepcioner=null;
                    break;
                default:
                    throw new Exception("Greska prilikom izvrsavanja operacije: " + request.getOperation());
            }
        } catch (Exception ex) {
            response.setException(ex);
        }
        return response;
    }

    public Socket getSocket(){
        return socket;
    }
    
    public Recepcioner getLoggedInRecepcioner(){
        return loggedInRecepcioner;
    }
    
}
