package com.mycompany.garciacutilasfranciscojose_act01ut05_javadoc.Parte1;

/**
 * Clase para manejar las entradas de un blog.
 *
 * @author Ana López
 * @since 1.0 21/3/1999
 * @version 2.3
 */
public class EntradaBlog {

    /**
     * Atributo separador es el carácter que separa ENTRADA DE del nombre del
     * autor
     */
    public static char separador = ':';
    private int id;
    private String texto;
    private String autor;

    /**
     * Constructor de la clase, crea objetos EntradaBlog
     *
     * @param id Número de entrada al blog
     * @param autor Nombre del autor de la entrada
     * @param texto Texto que contiene la entrada
     * @throws IllegalArgumentException Este objeto lanza la excepción si el
     * número de entrada es negativo
     */
    public EntradaBlog(int id, String autor, String texto) throws IllegalArgumentException {
        if (id <= 0) {
            throw new IllegalArgumentException("El id no puede ser negativo");
        }
        this.id = id;
        this.autor = autor;
        this.texto = texto;
    }

    /**
     * Este método muestra una cadena en la que aparece la información del autor
     * y a continuación el texto de la entrada
     *
     * @return devuelve la información del autor con su entrada correspondiente
     */
    @Override
    public String toString() {
        String cad = "";
        cad += "\nENTRADA DE" + separador + autor;
        cad += "\n " + texto;
        return cad;
    }

    /**
     * Método que devuelve el id de la entrada
     *
     * @return id de la entrada del blog
     */
    public int getId() {
        return this.id;
    }

    /**
     * Método que devuelve el texto de la entrada del blog
     *
     * @return devuelve el texto contenido en la entrada del blog
     */
    public String getTexto() {
        return this.texto;
    }

    /**
     * Método que devuelve el nombre del autor en mayúsculas
     *
     * @return devuelve el nombre del autor en mayúsculas
     */
    public String getAutor() {
        return this.autor.toUpperCase();
    }

    /**
     * Método que devuelve el nombre del autor
     *
     * @deprecated No se recomienda el uso de este método
     * @see #getAutor() se recomienda el uso del método getAutor()
     * @return devuelve el nombre del autor
     */
    @Deprecated
    public String devuelveAutor() {
        return this.autor;
    }

    /**
     * Este método es el encargado de la ejecución del programa
     *
     * @param args No tiene por qué recibir argumentos
     */
    public static void main(String[] args) {
        EntradaBlog e1 = new EntradaBlog(3, "ana", "Últimas noticias, sale a la venta Windows 9");
        System.out.println(e1);
    }

}
