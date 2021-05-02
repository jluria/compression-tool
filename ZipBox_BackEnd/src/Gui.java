import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.awt.Color;
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


  // Instantiate text fields at this scope, to make them available to our event handler
  JTextField filePathField = new JTextField(30);
  JTextField destFilePathField = new JTextField(30);
  JTextField filePathField2 = new JTextField(30);
  JTextField destFilePathField2 = new JTextField(30);
  JTextArea resultFeedback = new JTextArea();

  //method to initialize our gui
  public void initGui()
  {
    // instantiate main window and set key properties
    JFrame mainWindow = new JFrame("Zipbox");
    mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainWindow.setSize(700,300);
    mainWindow.setLayout(new FlowLayout());
    JPanel feedbackPanel = new JPanel();
    feedbackPanel.add(resultFeedback);

    // provide instructions
    JLabel instructionText1 = new JLabel("Welcome to Zipbox. Whether you are looking to compress or decompress a file, simply enter");
    JLabel instructionText2 = new JLabel("a path to the file, and a desired destination path, in the corresponding fields above. Happy Zipping! :)");

    // set up panel to include compression components
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

    // set up panel to include decompression components
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

    // add all the components to the main frame
    mainWindow.add(instructionText1);
    mainWindow.add(instructionText2);
    mainWindow.add(compressionPanel);
    mainWindow.add(compressionPanel2);
    mainWindow.add(decompressionPanel);
    mainWindow.add(decompressionPanel2);
    mainWindow.add(feedbackPanel);

    // lastly, make a frame visible!
    mainWindow.setVisible(true);
  }

  // event handler
  public void actionPerformed(ActionEvent e)
  {
    String source = e.getActionCommand();
    if(source == "Compress")
    {
      // take user input text and instantiate files to be processed on back end
      File file = new File(filePathField.getText());
      File destFile = new File(destFilePathField.getText());
      String result = Zipper.Zip(file, destFile);
      if(result == "SUCCESS") 
      {
        resultFeedback.setText("Compression was a success!!!");
        resultFeedback.setForeground(new Color(0,102,0));
      } else {
        resultFeedback.setText("Something went wrong when trying to compress the file :(");
        resultFeedback.setForeground(Color.red);
      }
    } else {
      // take user input text and instantiate files to be processed on back end
      File file = new File(filePathField2.getText());
      File destFile = new File(destFilePathField2.getText());
      String result = Zipper.Unzip(file, destFile);
      if(result == "SUCCESS")
      {
        resultFeedback.setText("Decompression was a success!!!");
        resultFeedback.setForeground(new Color(0,102,0));
      } else {
        resultFeedback.setText("Something went wrong when trying to decompress the file :(");
        resultFeedback.setForeground(Color.red);
      }
    }
  }
}
