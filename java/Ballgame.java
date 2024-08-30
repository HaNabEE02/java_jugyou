import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Ballgame extends JPanel implements ActionListener, KeyListener {

    private Random r = new Random();
    private int playerX = 250;
    private int playerY = 500;
    private Timer timer;
    private Timer spawnTimer;
    private boolean g_state = false;
    private boolean gameOver = false; // 게임 오버 상태

    private Image backgroundImage;
    private ArrayList<int[]> balls = new ArrayList<>(); // 공의 위치를 저장할 리스트
    private ArrayList<Integer> ballStates = new ArrayList<>(); // 공의 상태를 저장할 리스트

    public Ballgame() {
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        addKeyListener(this);

        // 공의 위치 업데이트 타이머 설정
        timer = new Timer(10, this);
        timer.start();

        // 1초마다 새로운 공을 추가하는 타이머 설정
        spawnTimer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewBall(); // 새로운 공 추가
            }
        });
        spawnTimer.start();

        // 배경 이미지 로드
        try {
            URL imageUrl = getClass().getResource("/test1.jpg"); // 이미지 파일 경로 수정 필요
            if (imageUrl != null) {
                backgroundImage = ImageIO.read(imageUrl);
            } else {
                System.err.println("Background image not found!");
                backgroundImage = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            backgroundImage = null;
        }
    }

    private void addNewBall() {
        int width = getWidth();
        int ballSize = 20;
        if (width > ballSize) {
            int x = r.nextInt(width - ballSize);
            int y = 0;
            int state = r.nextInt(2); // 0 또는 1을 무작위로 선택
            balls.add(new int[]{x, y}); // 새로운 공의 위치를 리스트에 추가
            ballStates.add(state); // 새로운 공의 상태를 리스트에 추가
        }
    }

    public void play() {
        g_state = true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        } else {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());
        }

        if (g_state) {
            if (gameOver) {
                g.setColor(Color.BLACK);
                g.drawString("Game Over", getWidth() / 2 - 50, getHeight() / 2);
            } else {
                // 공을 그립니다
                g.setColor(Color.RED);
                for (int i = 0; i < balls.size(); i++) {
                    int[] ball = balls.get(i);
                    g.fillOval(ball[0], ball[1], 40, 40);
                }

                // 플레이어
                g.setColor(Color.GREEN);
                g.fillRect(playerX, playerY, 30, 30);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            // 공의 위치를 업데이트
            for (int i = 0; i < balls.size(); i++) {
                int[] ball = balls.get(i);
                int ballState = ballStates.get(i);

                if (ballState == 0) {
                    ball[1] += 5; // 공이 아래로 이동
                } else if (ballState == 1) {
                    ball[1] += 5; // 공이 아래로 이동
                    ball[0] += (r.nextInt(3) - 1) * 5; // 좌우로 흔들리기
                }

                // 공이 화면을 넘어가면 제거
                if (ball[1] > getHeight()) {
                    balls.remove(i);
                    ballStates.remove(i);
                    i--; // 인덱스 조정
                }
            }

            // 충돌 검사
            for (int[] ball : balls) {
                if (ball[0] < playerX + 40 && ball[0] + 20 > playerX &&
                    ball[1] < playerY + 40 && ball[1] + 20 > playerY) {
                    gameOver = true;
                    timer.stop(); // 공의 위치 업데이트 타이머 정지
                    spawnTimer.stop(); // 공 생성 타이머 정지
                }
            }

            repaint(); // 화면을 다시 그립니다.
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // 키 입력이 있을 때 처리할 내용을 여기에 작성합니다.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!gameOver) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    playerX -= 20;
                    break;
                case KeyEvent.VK_RIGHT:
                    playerX += 20;
                    break;
                case KeyEvent.VK_UP:
                    playerY -= 20;
                    break;
                case KeyEvent.VK_DOWN:
                    playerY += 20;
                    break;
            }
            repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        Ballgame ballgame = new Ballgame();
        ballgame.play();
        JFrame frame = new JFrame("공피하기게임");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.add(ballgame); // Ballgame 패널을 JFrame에 추가
        frame.setVisible(true);
    }
}
