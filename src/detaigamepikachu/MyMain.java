package detaigamepikachu;

public class MyMain {

    MyFrame frame;

    public MyMain() {
        frame = new MyFrame();
        MyTimeCount timeCount = new MyTimeCount();
        timeCount.start();
        new Thread(frame).start();
    }

    public static void main(String[] args) {
         new MyMain();
    }

    class MyTimeCount extends Thread {

        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                 if (frame.isPause()) {
                    if (frame.isResume()) {
                        frame.time--;
                    }
                } else {
                    frame.time--;
                }
                if (frame.getTime() == 0) {
                    frame.showDialogNewGame(
                            "Time out!\nDo you want play again?", "Lose", 1);
                }
            }
        }
    }
}
