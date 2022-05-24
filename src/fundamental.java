public class fundamental {
    public static void main(String[] args) {
        passwordpanel passwordpanel=  new passwordpanel();
        passwordpanel.setVisible(true);

        Music audioPlayWave = new Music("bgm.wav");// 开音乐 音樂名
        audioPlayWave.start();
        @SuppressWarnings("unused")
        int musicOpenLab = 1;

    }
}
