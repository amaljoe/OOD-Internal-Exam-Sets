import java.awt.*;
import java.awt.event.*;

public class RailwayCrossing extends Frame implements ActionListener{
    boolean closed = false;
    boolean shouldClose = false;
    int carX = -60;
    int trainY = -200;
    int gateY = 0;

    RailwayCrossing() {
        setSize(640, 480);
        setVisible(true);
        setLayout(null);
        Button closeButton = new Button("Close");
        add(closeButton);
        closeButton.addActionListener(this);
        closeButton.setBounds(400, 100, 100, 50);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                dispose();
            }
        }); 
    }

    private void paintTrack(Graphics g) {
        g.setColor(Color.GRAY);
        for(int i = 0; i < 480; i += 30) {
            g.fillRect(300, i, 40, 10);
        }
        g.fillRect(290, 0, 5, 480);
        g.fillRect(345, 0, 5, 480);
    }

    private void paintGate(Graphics g) {
        g.setColor(Color.BLACK);
        if(gateY >= 80) {
            closed = true;
        } else if (gateY <= 0) {
            closed = false;
        }
        if(shouldClose) {
            if(!closed) {
                gateY += 10;
            }
        } else {
            if(gateY > 0) {
                gateY -= 10;
            }
        }
        g.fillRect(270, 120 + gateY, 5, 80);
    }

    private void paintCar(Graphics g) {
        g.setColor(Color.RED);
        if(!closed) {
            carX += 10;
        } else if (carX > 270 || carX < 200) {
            carX += 10;
        }
        if(carX > 640) {
            carX = -60;
        }
        g.fillRect(carX, 220, 60, 40);
    }

    private void paintTrain(Graphics g) {
        g.setColor(Color.GREEN);
        if(closed) {
            trainY += 20;
        }
        if(trainY > 480) {
            trainY = -200;
            shouldClose = false;
        }
        g.fillRect(295, trainY, 50, 200);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        paintTrack(g);
        paintGate(g);
        paintCar(g);
        paintTrain(g);
        try {
            Thread.sleep(200);
            repaint();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new RailwayCrossing();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		shouldClose = true;
	}
}