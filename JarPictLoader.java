/**
 *  @(#)JarPictLoader.java
 *
 *  Centralized location for loading all your image files when
 *  your program is loading from a Jar file.
 *
 *  @author
 *  @version 1.00 2010/5/25
 */
import javax.swing.*;
// access to JFrame and JComponents
import java.net.URL;
// added for JAR file access
import java.io.*;

// for PrintStream to capture error info
public class JarPictLoader {
	private ImageIcon cas,cad,cac,cah,c2s,c2d,c2c,c2h,c3s,c3d,c3c,c3h,c4s,c4d,c4c,c4h,
	c5s,c5d,c5c,c5h,c6s,c6d,c6c,c6h,c7s,c7d,c7c,c7h,c8s,c8d,c8c,c8h,c9s,c9d,c9c,c9h,cts,ctd,ctc,cth,
	cjs,cjd,cjc,cjh,cqs,cqd,cqc,cqh,cks,ckd,ckc,ckh,home,backcard,WonScreen;

	// have one for each image needed
	public JarPictLoader() 
	{
		ClassLoader cldr = this.getClass().getClassLoader();
		// just need to call this once for the whole program
	
		
			// the two steps required to get an images file location
			// and then load it
			URL fishy1IconURL   = cldr.getResource("fish.gif");
			fishy1 = new ImageIcon(fishy1IconURL);
			Then printing the stack trace to an output file.
			URL fishy2IconURL   = cldr.getResource("ERROR.gif");
			fishy2 = new ImageIcon(fishy2IconURL);
		
		

		public ImageIcon getAs() {
			// have a 'get' method for each image
			return as;
		}

		public ImageIcon getAd() {
			// have a 'get' method for each image
			return ad;
		}
		public ImageIcon getAc() {
			// have a 'get' method for each image
			return ac;
		}
		public ImageIcon getAh() {
			// have a 'get' method for each image
			return ah;
		}
		public ImageIcon get2s() {
			// have a 'get' method for each image
			return 2s;
		}
		public ImageIcon get2d() {
			// have a 'get' method for each image
			return 2d;
		}
	}
