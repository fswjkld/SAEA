import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel(LayoutManager layoutManager, String imagePath) {
        super(layoutManager);
        try {
            backgroundImage = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
            setBackground(Color.LIGHT_GRAY); // 设置默认背景色
        }
        setOpaque(false); // 确保面板的背景透明，以显示背景图片
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            // 根据面板大小缩放图片
            Image scaledImage = backgroundImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
            g.drawImage(scaledImage, 0, 0, this);
        }
    }
}