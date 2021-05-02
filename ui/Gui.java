import javax.swing.*;
import java.awt.FlowLayout;

class Gui
{
  public static void main(String[] args)
  {
    initGui();
  }

  public static void initGui()
  {
    JFrame mainWindow = new JFrame("Zipbox");
    mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainWindow.setSize(700,150);
    mainWindow.setLayout(new FlowLayout());

    JPanel compressionPanel = new JPanel();
    JLabel compressLabel = new JLabel("Path to file to compress:");
    JTextField filePathField = new JTextField(30);
    JButton compressButton = new JButton("Compress");
    compressionPanel.add(compressLabel);
    compressionPanel.add(filePathField);
    compressionPanel.add(compressButton);

    JPanel decompressionPanel = new JPanel();
    JLabel decompressLabel = new JLabel("Path to file to decompress:");
    JTextField filePathField2 = new JTextField(30);
    JButton decompressButton = new JButton("Decompress");
    decompressionPanel.add(decompressLabel);
    decompressionPanel.add(filePathField2);
    decompressionPanel.add(decompressButton);

    mainWindow.add(compressionPanel);
    mainWindow.add(decompressionPanel);

    mainWindow.setVisible(true);
  }
}
