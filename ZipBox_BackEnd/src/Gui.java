import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.File;

class Gui implements ActionListener
{
  public static void main(String[] args)
  {
    Gui guiEx = new Gui();
  }

  public Gui()
  {
    initGui();
  }

    JTextField filePathField = new JTextField(30);
    JTextField destFilePathField = new JTextField(30);
    JTextField filePathField2 = new JTextField(30);
    JTextField destFilePathField2 = new JTextField(30);

  public void initGui()
  {
    JFrame mainWindow = new JFrame("Zipbox");
    mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainWindow.setSize(700,250);
    mainWindow.setLayout(new FlowLayout());

    JPanel compressionPanel = new JPanel();
    JPanel compressionPanel2 = new JPanel();
    JLabel compressLabel = new JLabel("Path to file to compress:");
    JLabel compressDest = new JLabel("Path for compressed file:");
    JButton compressButton = new JButton("Compress");
    compressButton.addActionListener(this);

    compressionPanel.add(compressLabel);
    compressionPanel.add(filePathField);
    compressionPanel2.add(compressDest);
    compressionPanel2.add(destFilePathField);
    compressionPanel2.add(compressButton);

    JPanel decompressionPanel = new JPanel();
    JPanel decompressionPanel2 = new JPanel();
    JLabel decompressLabel = new JLabel("Path to file to decompress:");
    JLabel decompressLabel2 = new JLabel("Path for decompressed file:");
    JButton decompressButton = new JButton("Decompress");
    decompressButton.addActionListener(this);

    decompressionPanel.add(decompressLabel);
    decompressionPanel.add(filePathField2);
    decompressionPanel2.add(decompressLabel2);
    decompressionPanel2.add(destFilePathField2);
    decompressionPanel2.add(decompressButton);

    mainWindow.add(compressionPanel);
    mainWindow.add(compressionPanel2);
    mainWindow.add(decompressionPanel);
    mainWindow.add(decompressionPanel2);

    mainWindow.setVisible(true);
  }

  public void actionPerformed(ActionEvent e)
  {
    String source = e.getActionCommand();
    if(source == "Compress")
    {
      File file = new File(filePathField.getText());
      File destFile = new File(destFilePathField.getText());
      Zipper.Zip(file, destFile);
    } else {
      File file = new File(filePathField2.getText());
      File destFile = new File(destFilePathField2.getText());
      Zipper.Unzip(file, destFile);
    }
  }
}
