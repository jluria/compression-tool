
/*
Student:     Eric VonCannon
Class:       CSC 251 201
Assignment:  Group Project, Group 2
Purpose:     Simple compression utility class
*/
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Zipper
{
    private static final String FAIL_ERROR = "FAIL";
    private static final String SUCCESS = "SUCCESS";


    /*Compression method w/o destination
      will place compressed file into active directory.
     */

    public static String Zip(File toCompress)
    {
        int BAD_FILE = -1;
        String sourceFileName = toCompress.getName();
        String zipFileName;
        String zipExt = ".zip";
        int dotIndex = sourceFileName.lastIndexOf(".");
        byte[] bytes = new byte[1024];
        int size;

        //Returns FAIL_ERROR if file does not have an extension. i.e. is folder or directory.
        if (dotIndex == BAD_FILE)
        {
            return FAIL_ERROR;
        }

        //Adds ".zip" extension to the filename
        else
        {
            zipFileName = sourceFileName + zipExt;

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
        return SUCCESS;

    }


    /* Recommended method for compressing and choosing compressed
        file destination. Will work with Windows or Unix file paths.
     */
    public static String Zip(File toCompress, File destination)
    {
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
        return SUCCESS;

    }
    // Decompression method. Returns result string to indicate success or failure
    //
    public static String Unzip(File toDecompress, File destination)
    {
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
        return SUCCESS;
    }

}
