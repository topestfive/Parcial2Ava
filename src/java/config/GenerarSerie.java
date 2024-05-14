/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

/**
 *
 * @author buend
 */
public class GenerarSerie {

    int dato;
    String numero;

    public String NumeroSerie(int dato) {
        this.dato = dato + 1;
        if ((this.dato >= 10000000) && (this.dato <= 100000000)) {
            numero = "" + this.dato;
        }
        if ((this.dato >= 1000000) && (this.dato <= 10000000)) {
            numero = "0" + this.dato;
        }
        if ((this.dato >= 100000) && (this.dato <= 1000000)) {
            numero = "00" + this.dato;
        }
        if ((this.dato >= 10000) && (this.dato <= 100000)) {
            numero = "000" + this.dato;
        }
        if ((this.dato >= 1000) && (this.dato <= 10000)) {
            numero = "0000" + this.dato;
        }
        if ((this.dato >= 100) && (this.dato <= 1000)) {
            numero = "00000" + this.dato;
        }
        if ((this.dato >= 10) && (this.dato <= 100)) {
            numero = "000000" + this.dato;
        }
        if (this.dato < 10) {
            numero = "0000000" + this.dato;
        }
        return numero;
    }

    public String VerificarNumeroSerie(String num) {

        if (num == null) {
            return "00000001";
        } else {
            int incrementar = Integer.parseInt(num);
            return NumeroSerie(incrementar);
        }
    }

}
