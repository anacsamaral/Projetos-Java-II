public class Main {
    public static void main(String[] args) {
        BibliotecaCD biblioteca = new BibliotecaCD();

        Artista queen = new Artista("Queen","Banda");
        Artista beatles = new Artista("The Beatles","Banda");

        CD cd1 = new CD("Greatest Hits", 1981, queen);
        cd1.addMusica(new Musica("Bohemian Rhapsody",555,"https://youtu.be/fJ9rUzIMcZQ?list=RDfJ9rUzIMcZQ"));
        cd1.addMusica(new Musica("Another One Bites The Dust",335,"https://youtu.be/rY0WxgSXdEE?si=MdWGkNm8K1VIbR4p"));

        CD cd2 = new CD("Abbey Road",1969,beatles);
        cd2.addMusica(new Musica("Come Together",420,"https://youtu.be/45cYwDMibGo?list=RD45cYwDMibGo"));
        cd2.addMusica(new Musica("Something",303,"https://youtu.be/UelDrZ1aFeY?si=yXjXtWQWiT97IYyn"));

        biblioteca.addCD(cd1);
        biblioteca.addCD(cd2);

        // Listagem de CDs
        biblioteca.listarCDs();

        // CDs do artista queen
        queen.listarCDs();

        // Buscar um CD
        CD buscado = biblioteca.buscarCD("Abbey Road");
        if(buscado != null)
            buscado.listarMusica();

    }
}