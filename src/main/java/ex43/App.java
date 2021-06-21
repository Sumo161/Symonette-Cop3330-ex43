package ex43;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Nyles Symonette
 */

import java.io.*;
import java.util.Scanner;

// define WebSite Generator
public class App {

    public static void main(String[] arg)
    {
        //variables to store data and create a scanner object from user
        Scanner SC = new Scanner(System.in);
        String currentPath, author, siteName;
        char js = 'N';
        char css = 'N';

        //asking user to enter website name & author
        System.out.print("Site name: ");
        siteName = SC.nextLine();

        System.out.print("Author: ");
        author = SC.nextLine();

        //ask user that whether it want JavaScript folder or not
        System.out.print("Do you want a folder for JavaScript? ");
        js = SC.next().charAt(0);
        //asking the user that whether it want Css folder or not
        System.out.print("Do you want a folder for CSS? ");
        css = SC.next().charAt(0);

        // get the current directory to make website folder in
        //current directory
        currentPath = System.getProperty("user.dir");
        //append site name to the path of current
        currentPath += "\\"+siteName;

        // create a file object with currentPath
        File website = new File(currentPath);
        //making the directory/folder for entered siteName
        boolean websiteCreated = website.mkdir();
        //if website folder to no exist then it get created and if it is created then
        //creating its sub folders & files
        if(websiteCreated)
        {
            System.out.println("Created " +currentPath);
            //using try catch to handle the exception that can raise due to writing
            //in the index.html file
            try
            {
                //creating an object of filewriter to write to the index.html file
                FileWriter skeletonWriter = new FileWriter(new File(currentPath+ "\\index.html"));

                //writing the required data to the file
                skeletonWriter.write("<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n");
                skeletonWriter.write("\t<meta author=\""+author+"\">\n");
                skeletonWriter.write("\t<title>"+siteName+"</title>\n");
                skeletonWriter.write("<head>\n<body>\n\n</body>\n</html>");

                //closing the writer
                skeletonWriter.close();

                // printing the approved message
                System.out.println("Created" +currentPath+"\\index.html");
                if(js == 'y' || js == 'Y')
                {
                    //method of file
                    File jsFolder = new File(currentPath+"\\js");
                    boolean jsCreated = jsFolder.mkdir();

                    // success message
                    //else print function

                    if(jsCreated)
                    {
                        System.out.println("Create " + jsFolder+"\\");
                    }
                    else
                    {
                        System.out.println("Js folder not created");
                    }
                }
                //checking if user wants Css
                if(css == 'y' || css == 'Y')
                {
                    //if user input folder is created then print message
                    File cssFolder = new File(currentPath+"\\css");
                    boolean cssCreated = cssFolder.mkdir();

                    //else print function
                    if(cssCreated)
                    {
                        System.out.println("Create" + cssFolder+"\\");
                    }
                    else
                    {
                        System.out.println("CSS folder not created");
                    }
                }
            }
            catch (IOException e)
            {
                System.out.println("index.html not created as required");
            }
        }
    else
    {
        System.out.println("Website folder not created ");
    }
    SC.close();
    }
}

