package com.example.demo.DTO;

import java.io.Serializable;
import java.util.ArrayList;


public class VoziloDTO implements Serializable {

    public String godinaProizvodnje;
    public String brojTablica;
    public String brojSasije;
    public OsobaDTO vlasnik;
    public String markaTip;
    public ArrayList<RizikDTO> rizici;
}
