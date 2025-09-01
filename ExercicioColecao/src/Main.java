public class Main {
    public static void main(String[] args) {
        Acervo acervoPessoal = new AcervoPessoal();
        Cd cd = new Cd("Raul Seixas", "CD do Raul", 1983);
        Musica musica = new Musica("Aquarela", 300, "https://www.youtube.com/watch?v=xT8HIiFQ8Y0");

        cd.addMusica(musica);
        cd.addMusica(new Musica("O Caderno", 250, ));

        acervoPessoal.addCd(cd);

        System.out.println("Quantidade de CD's: "+acervoPessoal.getQuantidade());
        System.out.println("CD's do Toquinho: "+acervoPessoal.getCdsArtista("Toquinho"));
        System.out.println("Busca por músicas que tem a palavra 'Ouro': "+acervoPessoal.getMusicasTitulo);
    }
}