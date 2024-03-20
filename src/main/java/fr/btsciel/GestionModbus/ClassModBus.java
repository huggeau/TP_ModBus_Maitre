package fr.btsciel.GestionModbus;

import fr.btsciel.liaisonSerie.LiaisonSerie;

public class ClassModBus extends LiaisonSerie {
    BigEndian bigEndian;
    Crc16 crc16;
    Byte numeroEsclave;
    byte[] resultatValeur;

    public ClassModBus(Byte numeroEsclave) {
        this.numeroEsclave = numeroEsclave;
    }
    public ClassModBus() {
    }
    public void fermerLiaisonSerie(){
    }
    public byte[] intDeuxByte(int nombre){
        byte[] nombreOctet = new byte[2];

        nombreOctet[0] =(byte)((nombre & 0xFF00) >> 8);
        nombreOctet[1] =(byte)((nombre & 0xFF));

        return nombreOctet;
    }
    public void connectEsclave(String port, int truc, int truc2, int truc3, int truc4){

    }
    public float lectureCoils(int truc, int quelquechose){

        return 3;
    }
}
