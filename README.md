# TIFF_File_with_JAI_lib
Ravi Sharma

1-Let's take it as Java Advanced Imaging (JAI) flow to get required java library, you may download the Native supportive java lib from below given path (Oracle Path) <br>

2- https://www.oracle.com/java/technologies/java-archive-downloads-java-client-downloads.html.<br>
    Java Archive Downloads -Java Client Technologies || Java Client Technology Downloads.  || Go to the Oracle Java Archive page.. <br>
    Java Advanced Imaging API 1.1.2_01; Java Advanced Imaging API Demo 1.1.2; Java Advanced Imaging 1.1.1_01 -->www.oracle.com<br>
    
3-You may have to go to the Window section and click ​jai_imageio-1_0_01-lib-windows-i586-jdk.exe  and download it. (this is a setup file)<br>

4-After installation, you may see the folder as given (C:\Program Files (x86)\Sun Microsystems\JAI Image IO Tools 1.0_01).  <br>
      Note - As this is Native lib, your setup will depend upon 32 bit, generally this will work on a 32-bit JRE environment. <br>
5-Please check your java under Program file X86 folder installation.<br>

6-After successful installation of the above.Exe file, you may see jai_imageio.jar, clibwrapper_jiio.jar, and clib_jiio.dll<br>

7-Now, you can use 'jai_imageio.jar' in your java project as lib (add as Project Lib, Ant, Maven, Gradle, etc.)<br>


<br><br><br>

How to use this Code- <br><br><br>

1- Create your java Project in your eclipse <br>
2- Copy "jai_imageio.jar" from "C:\Program Files (x86)\Sun Microsystems\JAI Image IO Tools 1.0_01" this location to your project library <br>
3- Copy TIFFRead.java file in your java project <br>
4- Copy sample_640×426.tiff file in your java project root folder <br>
5- Change the file path location in TIFFRead.java (currenlty - file:///G:\\Study\\TIFF_Ravi_Read\\sample_640×426.tiff)  <br>
6- Right click of TIFFRead.java and ran as Java Application <br>
7- You may see the newTiffImage.tiff on same location added with System date and other text as bottom of image like (signature) <br>

Thanks !
Ravi Sharma
  
