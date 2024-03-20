package fr.btsciel;

import fr.btsciel.GestionModbus.ClassModBus;
import fr.btsciel.GestionModbus.Crc16;
import fr.btsciel.clavier.In;

public class Main {
    public static void main(String[] args) {
        Crc16 crc16;
        ClassModBus classModBus;
        Byte numEsclave;
        String com;

        System.out.print("quel est le numéro de l'esclave ? : ");
        numEsclave = In.readByte();
        System.out.println();

        System.out.print("quel est le com a utiliser ? : ");
        com = In.readString();
        System.out.println();



    }
}
