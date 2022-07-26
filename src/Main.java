import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
    static JFrame frame = new JFrame();
    static JLayeredPane panel = new JLayeredPane();


    public static void main(String[] args) {
    frame.setSize(600,600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(panel);
    panel.setFocusable(true); // чтобы отлавливать событи€ мыши
    frame.setVisible(true);
    panel.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            add(e);
        }
    });


    }

    private static void add(MouseEvent e) {
        JLabel label = new JLabel("X:" +e.getX() +"Y:"+ e.getY());
        label.setBounds(e.getX(),e.getY(),100,20);
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
            panel.remove((JLabel) e.getSource());//получаем объект, вызвавший событие, кастим его в JLabel и удал€ем из панели
            panel.repaint();//об€зательно обновл€ем панель, иначе изменени€ не отобраз€тс€
        }
    }
}