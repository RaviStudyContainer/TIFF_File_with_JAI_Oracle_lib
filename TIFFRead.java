package ravi.study;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.stream.ImageInputStream;

import com.sun.media.imageio.plugins.tiff.BaselineTIFFTagSet;
import com.sun.media.imageio.plugins.tiff.FaxTIFFTagSet;
import com.sun.media.imageio.plugins.tiff.TIFFImageReadParam;

//import javax.imageio.plugins.tiff.*;

public class TIFFRead {

	

	
	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public BufferedImage  getFile() throws IOException {

		InputStream stream = new URL(" file:///G:\\Study\\TIFF_Ravi_Read\\sample_640×426.tiff").openStream();

		ImageReader tiffReader = ImageIO.getImageReadersByFormatName("tiff").next();

		ImageInputStream input = ImageIO.createImageInputStream(stream);

		tiffReader.setInput(input);

		TIFFImageReadParam mTIFFImageReadParam = new TIFFImageReadParam();

		System.out.println("--- TIFFImageReadParam - default TagSets ---");
		mTIFFImageReadParam.getAllowedTagSets().forEach(System.out::println);

		mTIFFImageReadParam.removeAllowedTagSet(BaselineTIFFTagSet.getInstance());
		mTIFFImageReadParam.removeAllowedTagSet(FaxTIFFTagSet.getInstance());

		System.out.println("--- TIFFImageReadParam - after removing 2 TagSets ---");
		mTIFFImageReadParam.getAllowedTagSets().forEach(System.out::println);

		mTIFFImageReadParam.setDestinationOffset(new Point(20, 20));

		// Read primary image and IFD.
		BufferedImage image = tiffReader.read(0, mTIFFImageReadParam);

		System.out.println("--- TIFFImage after retrieving---");
		System.out.println(image);
		System.out.println("- Height: " + image.getHeight());
		System.out.println("- Width: " + image.getWidth());

		IIOMetadata metaData = tiffReader.getImageMetadata(0);
		System.out.println("NativeMetadataFormatName: " + metaData.getNativeMetadataFormatName());
		
		
		
		return image;

	}
	
	
	
	
	/**
	 * Get System date with yyyy-mm-dd hh:mm:ss a  Pattern (e.g. 2020-08-10 10:20:10 AM)
	 * @return
	 */
	public String getSystemdate() {
		
	    Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");  
        String strDate = dateFormat.format(date);
		return strDate;
	}
	
	
	/**
	 * 
	 */
	public String getPCN() {
			
			//Need to call Database to get PCN Number
			return "4444444444";
		}
	
	/**
	 * 
	 */
	public String getDCN() {
			
			//Need to call Database to get PCN Number
			return "4444444444-";
		}
	
	
	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
	
	public Graphics dateText(BufferedImage imagevalue, String DateValue) {
		
	    
		
		// Writing value with font size and position
	    Graphics g = imagevalue.getGraphics();
	    g.setFont(g.getFont().deriveFont(12f));
	    g.drawString(DateValue, 510, 400);
	    g.dispose();
		
		return g;
		
	}
	
	
	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
	
	public Graphics addPCNText(BufferedImage imagevalue) {
		
	    
		
		// Writing value with font size and position
	    Graphics g = imagevalue.getGraphics();
	    g.setFont(g.getFont().deriveFont(12f));
	    g.drawString(getPCN(), 410, 400);
	    g.dispose();
		
		return g;
		
	}
	
	
	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
	
	public Graphics addDCNText(BufferedImage imagevalue) {
		
	    
		
		// Writing value with font size and position
	    Graphics g = imagevalue.getGraphics();
	    g.setFont(g.getFont().deriveFont(12f));
	    g.drawString(getDCN(), 330, 400);
	    g.dispose();
		
		return g;
		
	}
	
	
	
	/**
	 * 
	 * @param args
	 * @throws IOException
	 */

	public static void main(String[] args) throws IOException {
		 
   
		TIFFRead  tIFFReadObj = new TIFFRead();
		
		//Read  .tiff file name 
		BufferedImage imagevalue = tIFFReadObj.getFile();
	
	    /// Adding my user choice value on image 
	    // As Graphics having String arguments thats a reason converting system date into sting 
		tIFFReadObj.dateText(imagevalue,tIFFReadObj.getSystemdate());
		
		
		//Adding my PCN value
		tIFFReadObj.addPCNText(imagevalue);
		
		//
		tIFFReadObj.addDCNText(imagevalue);
		
	    
	    // write Image
	    File newTIFFimage = new File("newTiffImage.tiff");
	    ImageIO.write(imagevalue, "TIFF", newTIFFimage);
	 
	  }

}
