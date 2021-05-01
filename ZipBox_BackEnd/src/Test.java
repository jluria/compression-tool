import java.io.File;

public class Test {
    public static void main(String[] args)
    {
        //test file compression
        File testFile = new File("C:\\Users\\Eric\\Desktop\\Java+\\Arrays.docx");
        String result = Zipper.Zip(testFile);


        //test file compression with destination
        File location = new File("C:\\Users\\Eric\\Desktop");
        result = Zipper.Zip(testFile, location);
        System.out.println(result);

        //test decompression and destination
        File testFile2 = new File("C:\\Users\\Eric\\Desktop\\Arrays.docx.zip");

        result = Zipper.Unzip(testFile2, location);
        System.out.println(result);




    }
}
