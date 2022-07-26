import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Main {
    static JFrame frame = new JFrame();
    static JLayeredPane panel = new JLayeredPane(); // многослойная панелька


    public static void main(String[] args) {
    frame.setSize(600,600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(panel);
    panel.setFocusable(true); // чтобы отлавливать события мыши
    frame.setVisible(true);
    panel.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            add(e);
        }
        @Override
        public void mouseEntered(MouseEvent e) { // нахождение мыши в поле
            panel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

    });


    }

    private static void add(MouseEvent e) {
        JLabel label = new JLabel("X:" +e.getX() +" Y:"+ e.getY());
        label.setBounds(e.getX(),e.getY(),100,20);
        label.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int X=e.getX()+label.getX();
                int Y=e.getY()+label.getY();

                label.setBounds( X, Y,100, 20);
                panel.repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                delete(e);
            }

        });
        panel.add(label);
    }

    private static void delete(MouseEvent e) {
        if (e.getButton()==2){//если кнопка колесико
            panel.remove((JLabel) e.getSource());//получаем объект, вызвавший событие, кастим его в JLabel и удаляем из панели
            panel.repaint();//обязательно обновляем панель, иначе изменения не отобразятся
        }

    }
}