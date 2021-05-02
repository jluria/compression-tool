import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Zipper
{
    private static final String FAIL_ERROR = "FAIL";

    public static String Zip(String pathToCompress)
    {
        File toCompress = new File(pathToCompress);
        int slashIndex = pathToCompress.lastIndexOf("/");
        String pathName = pathToCompress.substring(0, slashIndex);
        File destination = new File(pathName);
        String separator = System.getProperty("file.separator");
        int BAD_FILE = -1;
        String FAIL_ERROR = "FAIL";
        String sourceFileName = toCompress.getName();
        String zipFileName;
        String zipExt = ".zip";
        int dotIndex = sourceFileName.lastIndexOf(".");
        byte[] bytes = new byte[1024];
        int size;
        if (dotIndex == BAD_FILE)
        {
            return FAIL_ERROR;
        }
        else
        {
            zipFileName = destination.getPath()  + separator + sourceFileName + zipExt;
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

    public static String Unzip(String pathToDecompress)
    {
        File toDecompress = new File(pathToDecompress);
        int slashIndex = pathToDecompress.lastIndexOf("/");
        String restoreDestination = pathToDecompress.substring(0,slashIndex);
        System.out.println(restoreDestination);
        File destination = new File(restoreDestination);
        byte[] bytes = new byte[1024];
        int dotIndex = toDecompress.getName().lastIndexOf(".");
        String restoreName = toDecompress.getName().substring(0,dotIndex);
        try {
            ZipInputStream zipIn = new ZipInputStream(new FileInputStream(toDecompress));
            ZipEntry zipEntry = zipIn.getNextEntry();
            while (zipEntry != null)
            {
                File decompFile = new File(destination, restoreName);
                FileOutputStream fileOut = new FileOutputStream(decompFile);
                int len;
                while ((len = zipIn.read(bytes)) > 0)
                {
                    fileOut.write(bytes, 0, len);
                }
                fileOut.close();
                return restoreName;
            }
            zipIn.closeEntry();
            zipIn.close();

        } catch (IOException e)
        {
            e.printStackTrace();
            return FAIL_ERROR;
        }
        return destination.getAbsolutePath();
    }

}
