/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Nikola
 */
public class Communication {
    
    private static Communication instance;
    
    private Socket socket;
    private Sender sender;
    private Receiver receiver;

    private Communication() {
    }
    
    public static Communication getInstance() {
        if(instance==null){
            instance=new Communication();
        }
        return instance;
    }
    
    public void connect() throws IOException{
        socket=new Socket("localhost", 9000);
        sender=new Sender(socket);
        receiver=new Receiver(socket);
    }
    
    public synchronized Response sendRequest(Request request) throws Exception{
        sender.send(request);
        switch (request.getOperation()) {
            case LOGIN:
                System.out.println("Zahtev za prijavu je poslat...");
                break;
            case GET_ALL_DRZAVA:
                System.out.println("Zahtev za listom svih drzava je poslat...");
                break;
            case ADD_GOST:
                System.out.println("Zahtev za kreiranjem gosta je poslat...");
                break;
            case EDIT_GOST:
                System.out.println("Zahtev za izmenu gosta je poslat...");
                break;
            case GET_GOST_LIST_BY_GOST:
                System.out.println("Zahtev za listom sa gostima prema kriterijumima za gosta je poslat...");
                break;
            case GET_GOST_LIST_BY_DRZAVA:
                System.out.println("Zahtev za listom sa gostima prema kriterijumima za drzavu je poslat...");
                break;
            case GET_GOST:
                System.out.println("Zahtev za gostom je poslat...");
                break;
            case DELETE_GOST:
                System.out.println("Zahtev za brisanjem gosta je poslat...");
                break;
            case ADD_STRUCNA_SPREMA:
                System.out.println("Zahtev za kreiranjem strucne spreme je poslat...");
                break;
            case EDIT_STRUCNA_SPREMA:
                System.out.println("Zahtev za izmenom strucne spreme je poslat...");
                break;
            case GET_ALL_STRUCNA_SPREMA:
                System.out.println("Zahtev za listom svih strucnih sprema je poslat...");
                break;
            case GET_ALL_RECEPCIONER:
                System.out.println("Zahtev za listom svih recepcionera je poslat...");
                break;
            case GET_ALL_GOST:
                System.out.println("Zahtev za listom svih gostiju je poslat...");
                break;
            case GET_ALL_SOBA:
                System.out.println("Zahtev za listom svih soba je poslat...");
                break;
            case ADD_REZERVACIJA:
                System.out.println("Zahtev za kreiranjem rezervacije je poslat...");
                break;
            case EDIT_REZERVACIJA:
                System.out.println("Zahtev za izmenom rezervacije je poslat...");
                break;
            case GET_REZERVACIJA:
                System.out.println("Zahtev za rezervaciju je poslat...");
                break;
            case DELETE_REZERVACIJA:
                System.out.println("Zahtev za brisanjem rezervacije je poslat...");
                break;
            case GET_REZERVACIJA_LIST_BY_REZERVACIJA:
                System.out.println("Zahtev za listom sa rezervacijama prema kriterijumima za rezervaciju je poslat...");
                break;
            case GET_REZERVACIJA_LIST_BY_GOST:
                System.out.println("Zahtev za listom sa rezervacijama prema kriterijumima za gosta je poslat...");
                break;
            case GET_REZERVACIJA_LIST_BY_RECEPCIONER:
                System.out.println("Zahtev za listom sa rezervacijama prema kriterijumima za recepcionera je poslat...");
                break;
            case GET_REZERVACIJA_LIST_BY_SOBA:
                System.out.println("Zahtev za listom sa rezervacijama prema kriterijumima za sobu je poslat...");
                break;
            case LOGOUT:
                System.out.println("Zahtev za odjavu je poslat...");
                break;
            default:
                System.out.println("Greska prilikom slanja zahteva.");
        }
        return (Response) receiver.receive();
    }
    
    
}
