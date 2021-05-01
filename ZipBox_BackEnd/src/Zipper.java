import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zipper
{
    public static String Zip(File toCompress)
    {
        int BAD_FILE = -1;
        String FAIL_ERROR = "FAIL";
        String sourceFileName = toCompress.getName();
        String zipFileName;
        String zipExt = "zip";
        int dotIndex = sourceFileName.lastIndexOf(".");
        byte[] bytes = new byte[1024];
        int size;
        if (dotIndex == BAD_FILE)
        {
            return FAIL_ERROR;
        }
        else
        {
            zipFileName = sourceFileName.substring(0, dotIndex + 1) + zipExt;
        }


        try
        {
            FileOutputStream fileOut = new FileOutputStream(zipFileName);
            ZipOutputStream zipOut = new ZipOutputStream(fileOut);
            FileInputStream fileIn = new FileInputStream(toCompress);
            ZipEntry zipEntry = new ZipEntry(sourceFileName);
            zipOut.putNextEntry(zipEntry);
            while((size = fileIn.read(bytes)) >= 0)
            {
                zipOut.write(bytes, 0, size);
            }
            zipOut.close();
            fileIn.close();
            fileOut.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
            return FAIL_ERROR;
        }
        return zipFileName;

    }
}
