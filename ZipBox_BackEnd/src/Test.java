import java.io.File;

public class Test {
    public static void main(String[] args)
    {
        String FAIL_ERROR = "FAIL";
        File testFile = new File("C:\\Users\\Eric\\Desktop\\Java+\\Arrays.docx");
        String result = Zipper.Zip(testFile);

            System.out.print(result);


    }
}
