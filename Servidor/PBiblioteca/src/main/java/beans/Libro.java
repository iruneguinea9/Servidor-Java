/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author dw2
 */
public class Libro {
    private String isbn;
    private String titulo;
    private int paginas;
    private String genero;
    private int id_autor;
    
    public Libro(String isbn,String titulo,int paginas,String genero,int id_autor){
        this.isbn = isbn;
        this.titulo=titulo;
        this.paginas=paginas;
        this.genero=genero;
        this.id_autor=id_autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPaginas() {
        return paginas;
    }

    public String getGenero() {
        return genero;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }
    
}
