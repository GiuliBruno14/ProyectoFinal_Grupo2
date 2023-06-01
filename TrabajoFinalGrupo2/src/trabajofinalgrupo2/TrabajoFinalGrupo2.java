/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabajofinalgrupo2;

import Controladores.ClientesData;
import Modelo.Cliente;

/**
 *
 * @author Giulietta
 */
public class TrabajoFinalGrupo2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Cliente cl2 =new Cliente("Bruno","Giulietta", "sucre 321", 2664256466);
    Cliente cl3 =new Cliente(3,"Bruno","Giulietta", "sucre 32", 0);
    ClientesData cd =new ClientesData();
//    cd.agregarCliente(cl); agregar cliente
    cd.editarCliente(cl3);
    
    
    
    }
    
}
