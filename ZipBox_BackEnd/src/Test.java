import java.io.File;

public class Test {
    public static void main(String[] args)
    {
        //test file compression
        File testFile = new File("C:\\Users\\Eric\\Desktop\\Java+\\Arrays.docx");
        String result = Zipper.Zip(testFile);

        System.out.print(result);

        //test file compression with destination
        File location = new File("C:\\Users\\Eric\\Desktop");
        result = Zipper.Zip(testFile, location);
        System.out.print(result);




    }
}
