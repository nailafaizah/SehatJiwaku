package com.example.sehatjiwaku.model;

public class Penyakit {
    private String id;
    private String nama;

    public Penyakit(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public Penyakit() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    //to display object as a string in spinner
    @Override
    public String toString() {
        return nama;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Penyakit){
            Penyakit c = (Penyakit )obj;
            if(c.getNama().equals(nama) && c.getId()==id ) return true;
        }

        return false;
    }
}
