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
	private ImageIcon as,ad,ac,ah,2s,2d,2c,2h,3s,3d,3c,3h,4s,4d,4c,4h,
	5s,5d,5c,5h,6s,6d,6c,6h,7s,7d,7c,7h,8s,8d,8c,8h,9s,9d,9c,9h,ts,td,tc,th,
	js,jd,jc,jh,qs,qd,qc,qh,ks,kd,kc,kh,home,backcard,WonScreen;

	// have one for each image needed
	public JarPictLoader() 
	{
		ClassLoader cldr = this.getClass().getClassLoader();
		// just need to call this once for the whole program
		try 
		{
			// the two steps required to get an images file location
			// and then load it
			URL fishy1IconURL   = cldr.getResource("fish.gif");
			fishy1 = new ImageIcon(fishy1IconURL);
			Then printing the stack trace to an output file.
			URL fishy2IconURL   = cldr.getResource("ERROR.gif");
			fishy2 = new ImageIcon(fishy2IconURL);
		}  
		catch (Exception e)
		{
			try
			{
				// PrintStream methods need to be in a
				// try-catch 
				blockPrintStream p = new PrintStream(new FileOutputStream(new File("trace.txt")));
				p.println("got here"); 
				// sample output to file
				e.printStackTrace(p);  
				// print stack trace to output file
			}
			catch(Exception e1)    
				// need this empty section for PrintStream{}
			}   
		}

		public ImageIcon getFishy1() {
			// have a 'get' method for each image
			return fishy1;
		}

		public ImageIcon getFishy2() {
			// have a 'get' method for each image
			return fishy2;
		}
	}
