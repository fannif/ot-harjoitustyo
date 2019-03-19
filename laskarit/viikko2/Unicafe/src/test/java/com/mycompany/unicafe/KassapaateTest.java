/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author f
 */
public class KassapaateTest {
    
    Kassapaate k;
    Maksukortti m;
    
    @Before
    public void setUp() {
        k = new Kassapaate();
        m = new Maksukortti(1000);
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void kassassaAluksiOikeaMaaraRahaa() {
        assertEquals(100000, k.kassassaRahaa());
    }
    
    @Test
    public void syoEdullisestiKasvattaaKassaaOikein() {
        k.syoEdullisesti(240);
        assertEquals(100240, k.kassassaRahaa());
    }
    
    @Test
    public void syoEdullisestiPalauttaaOikeanMaaranRahaa() {
        int tulos = k.syoEdullisesti(250);
        assertEquals(10, tulos);
    }
    
    @Test
    public void edullisestiPalauttaaRahatKunAnnetaanLiianVahan() {
        int tulos = k.syoEdullisesti(100);
        assertEquals(100, tulos);
    }
    
    @Test
    public void edullistenMaaraKasvaa() {
        k.syoEdullisesti(400);
        assertEquals(1, k.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void maukkaidenMaaraKasvaa() {
        k.syoMaukkaasti(400);
        assertEquals(1, k.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void edullistenMaaraEiKasvaJosEiTarpeeksiRahaa() {
        k.syoEdullisesti(100);
        assertEquals(0, k.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void maukkaidenMaaraEiKasvaJosEiTarpeeksiRahaa() {
        k.syoEdullisesti(100);
        assertEquals(0, k.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void syoMaukkaastiKasvattaaKassaaOikein() {
        k.syoMaukkaasti(400);
        assertEquals(100400, k.kassassaRahaa());
    }
    
    @Test
    public void syoMaukkaastiPalauttaaOikeanMaaranRahaa() {
        int tulos = k.syoMaukkaasti(410);
        assertEquals(10, tulos);
    }
    
    @Test
    public void maukkaastiPalauttaaRahatKunAnnetaanLiianVahan() {
        int tulos = k.syoMaukkaasti(100);
        assertEquals(100, tulos);
    }
    
    @Test
    public void alussaMaukkaitaNolla() {
        assertEquals(0, k.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void alussaEdullisiaNolla() {
        assertEquals(0, k.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void syoEdullisestiVahentaaKortinSaldoaOikein() {
        k.syoEdullisesti(m);
        assertEquals(760, m.saldo());
    }
    
    @Test
    public void syoEdullisestiPalauttaaTrueJosSaldoRiittaa() {
        boolean tulos = k.syoEdullisesti(m);
        assertTrue(tulos);
    }
    
    @Test
    public void syoEdullisestiPalauttaaFalseJosSaldoEiRiita() {
        k.syoMaukkaasti(m);
        k.syoMaukkaasti(m);
        boolean tulos = k.syoEdullisesti(m);
        assertTrue(!tulos);
    }
    
    @Test
    public void syoMaukkaastiPalauttaaTrueJosSaldoRiittaa() {
        boolean tulos = k.syoMaukkaasti(m);
        assertTrue(tulos);
    }
    
    @Test
    public void syoMaukkaastiPalauttaaFalseJosSaldoEiRiita() {
        k.syoMaukkaasti(m);
        k.syoMaukkaasti(m);
        boolean tulos = k.syoMaukkaasti(m);
        assertTrue(!tulos);
    }
    
    @Test
    public void edullisestiEiOtaKorttiaJosEiTarpeeksiSaldoa() {
        k.syoEdullisesti(m);
        k.syoEdullisesti(m);
        k.syoEdullisesti(m);
        k.syoEdullisesti(m);
        k.syoEdullisesti(m);
        
        assertEquals(40, m.saldo());
    }
    
    @Test
    public void syoMaukkaastiVahentaaKortinSaldoaOikein() {
        k.syoMaukkaasti(m);
        assertEquals(600, m.saldo());
    }
    
    @Test
    public void maukkaastiEiOtaKorttiaJosEiTarpeeksiSaldoa() {
        k.syoEdullisesti(m);
        k.syoEdullisesti(m);
        k.syoEdullisesti(m);
        k.syoEdullisesti(m);
        k.syoMaukkaasti(m);
        
        assertEquals(40, m.saldo());
    }
    
    @Test
    public void edullistenMaaraKasvaa2() {
        k.syoEdullisesti(m);
        assertEquals(1, k.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void maukkaidenMaaraKasvaa2() {
        k.syoMaukkaasti(m);
        assertEquals(1, k.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void edullistenMaaraEiKasvaJosKortillaEiTarpeeksiRahaa() {
        k.syoMaukkaasti(m);
        k.syoMaukkaasti(m);
        k.syoEdullisesti(m);
        assertEquals(0, k.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void maukkaidenMaaraEiKasvaJosKortillaEiTarpeeksiRahaa() {
        k.syoEdullisesti(m);
        k.syoEdullisesti(m);
        k.syoEdullisesti(m);
        k.syoMaukkaasti(m);
        assertEquals(0, k.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kortillaOstoEiVaikutaKassanRahaan1() {
        k.syoEdullisesti(m);
        assertEquals(100000, k.kassassaRahaa());
    }
    
    @Test
    public void kortillaOstoEiVaikutaKassanRahaan2() {
        k.syoMaukkaasti(m);
        assertEquals(100000, k.kassassaRahaa());
    }
    
    @Test
    public void lataaKortilleKasvattaaKortinSaldoa() {
        k.lataaRahaaKortille(m, 1000);
        assertEquals(2000, m.saldo());
    }
    
    @Test
    public void lataaKortilleKasvattaaKassanRahaMaaraa(){
        k.lataaRahaaKortille(m, 100);
        assertEquals(100100, k.kassassaRahaa());
    }
    
    @Test
    public void kortilleEiVoiLadataNegatiivistaSummaa() {
        k.lataaRahaaKortille(m, -100);
        assertEquals(1000, m.saldo());
    }
       
    
    
}
