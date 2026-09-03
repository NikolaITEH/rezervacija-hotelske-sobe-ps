/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.recepcioner;

import domain.Recepcioner;
import so.AbstractSO;

/**
 *
 * @author Nikola
 */
public class LoginRecepcionerSO extends AbstractSO{

    private Recepcioner recepcioner;
    
    @Override
    protected void precondition(Object param) throws Exception {
        if(!(param instanceof Recepcioner)){
            throw new Exception("Pogresan parametar");
        }
        Recepcioner r=(Recepcioner) param;
        if(r.getKorisnickoIme()==null || r.getKorisnickoIme().trim().isEmpty()){
            throw new Exception("Korisnicko ime je obavezno");
        }
        if(r.getSifra()==null || r.getSifra().trim().length()<=4){
            throw new Exception("Sifra mora imati vise od 4 karaktera");
        }
        
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Recepcioner r=(Recepcioner) param;
        String query = " WHERE BINARY korisnickoIme='" + r.getKorisnickoIme() + "' AND BINARY sifra='" + r.getSifra() + "'";
        recepcioner=(Recepcioner) repository.get(r, query);
        if(recepcioner==null){
            throw new Exception("Pogresno korisnicko ime ili sifra");
        }
    }
    
    public Recepcioner getRecepcioner(){
        return recepcioner;
    }
    
}
