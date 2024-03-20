package fr.btsciel.GestionModbus;

import fr.btsciel.liaisonSerie.LiaisonSerie;
import jssc.SerialPortException;

public class ClassModBus extends LiaisonSerie {
    BigEndian bigEndian;
    Crc16 crc16 = new Crc16();
    Byte numeroEsclave;
    byte[] resultatValeur;

    public ClassModBus(Byte numeroEsclave) {
        this.numeroEsclave = numeroEsclave;
    }
    public ClassModBus() {
    }
    public void fermerLiaisonSerie(){
        super.fermerPort();
    }
    public byte[] intDeuxByte(int nombre){
        byte[] nombreOctet = new byte[2];

        nombreOctet[0] =(byte)((nombre & 0xFF00) >> 8);
        nombreOctet[1] =(byte)((nombre & 0xFF));

        return nombreOctet;
    }
    public void connectEsclave(String port, int vitesse, int data, int parite, int stop) throws SerialPortException {
        super.initCom(port);
        super.configurerParametres(vitesse, data, parite, stop);
    }
    public float lectureCoils(int registre, int bloc){
        byte[] tabRegistre = intDeuxByte(registre);
        byte[]  longueur = intDeuxByte(bloc);
        byte[] tabSansCrc16 = {numeroEsclave, (byte) 0x03, tabRegistre[0], tabRegistre[1], longueur[0], longueur[1]};
        byte[] tabAvecCrc16 = intDeuxByte(crc16.calculCrc16(tabSansCrc16));
        byte[] tabCrc16 = {numeroEsclave, (byte) 0x03, tabRegistre[0], tabRegistre[1], longueur[0], longueur[1]};
        super.ecrire(tabAvecCrc16);
        return 0f;
    }
}
