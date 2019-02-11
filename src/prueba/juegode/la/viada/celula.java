/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.juegode.la.viada;

/**
 *
 * @author andre
 */
public class celula {
    private boolean estadoCelula;
    private int posicionX;
    private int posicionY;
    private String celula;

    public celula() {
    }

    public boolean isEstadoCelula() {
        return estadoCelula;
    }

    public void setEstadoCelula(boolean estadoCelula) {
        this.estadoCelula = estadoCelula;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    public String getCelula() {
        return celula;
    }

    public void setCelula(String celula) {
        this.celula = celula;
    }
    
    
}
