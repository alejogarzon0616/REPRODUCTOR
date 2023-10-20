public class Reproductor {
    public static void main(String[] args) {
        ReproductorMusica musicaThread = new ReproductorMusica();
        Chat chatThread = new Chat(musicaThread);

        musicaThread.start();
        chatThread.start();
    }
}
