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
			return cas;
		}
		public ImageIcon getAd() {
			// have a 'get' method for each image
			return cad;
		}
		public ImageIcon getAc() {
			// have a 'get' method for each image
			return cac;
		}
		public ImageIcon getAh() {
			// have a 'get' method for each image
			return cah;
		}
		public ImageIcon get2s() {
			// have a 'get' method for each image
			return c2s;
		}
		public ImageIcon get2d() {
			// have a 'get' method for each image
			return c2d;
		}
		public ImageIcon get2c() {
			// have a 'get' method for each image
			return c2c;
		}
		public ImageIcon get2h() {
			// have a 'get' method for each image
			return c2h;
		}
		public ImageIcon get3s() {
			// have a 'get' method for each image
			return c3s;
		}
		public ImageIcon get3d() {
			// have a 'get' method for each image
			return c3d;
		}
		public ImageIcon get3c() {
			// have a 'get' method for each image
			return c3c;
		}
		public ImageIcon get3h() {
			// have a 'get' method for each image
			return c3h;
		}
		public ImageIcon get4s() {
			// have a 'get' method for each image
			return c4s;
		}
		public ImageIcon get4d() {
			// have a 'get' method for each image
			return c4d;
		}
		public ImageIcon get4c() {
			// have a 'get' method for each image
			return c4c;
		}
		public ImageIcon get4h() {
			// have a 'get' method for each image
			return c4h;
		}
		public ImageIcon get5s() {
			// have a 'get' method for each image
			return c5s;
		}
		public ImageIcon get5d() {
			// have a 'get' method for each image
			return c5d;
		}
		public ImageIcon get5c() {
			// have a 'get' method for each image
			return c5c;
		}
		public ImageIcon get5h() {
			// have a 'get' method for each image
			return c5h;
		}
		public ImageIcon get6s() {
			// have a 'get' method for each image
			return c6s;
		}
		public ImageIcon get6d() {
			// have a 'get' method for each image
			return c6d;
		}
		public ImageIcon get6c() {
			// have a 'get' method for each image
			return c6c;
		}
		public ImageIcon get6h() {
			// have a 'get' method for each image
			return c6h;
		}
		public ImageIcon get7s() {
			// have a 'get' method for each image
			return c7s;
		}
		public ImageIcon get7d() {
			// have a 'get' method for each image
			return c7d;
		}
		public ImageIcon get7c {
			// have a 'get' method for each image
			return c7c;
		}
		public ImageIcon get7h) {
			// have a '' method for each image
			return c7h;
		}
		public ImageIcon get8s {
			// have a 'get' method for each image
			return c8s;
		}
		public ImageIcon get8d {
			// have a 'get' method for each image
			return c8d;
		}
		public ImageIcon get8c {
			// have a 'get' method for each image
			return c8c;
		}
		public ImageIcon get8h {
			// have a 'get' method for each image
			return c8h;
		}
		public ImageIcon get9s {
			// have a 'get' method for each image
			return c8s;
		}
		public ImageIcon get9d {
			// have a 'get' method for each image
			return c9;
		}
		public ImageIcon get9c {
			// have a 'get' method for each image
			return c9c;
		}
		public ImageIcon get9h {
			// have a 'get' method for each image
			return c9h;
		}
		public ImageIcon getts {
			// have a 'get' method for each image
			return cts;
		}
		public ImageIcon gettd {
			// have a 'get' method for each image
			return ctd;
		}
		public ImageIcon gettc {
			// have a 'get' method for each image
			return ctc;
		}
		public ImageIcon getth {
			// have a 'get' method for each image
			return cth;
		}
		public ImageIcon getjs {
			// have a 'get' method for each image
			return cjs;
		}
		public ImageIcon getjd {
			// have a 'get' method for each image
			return cjd;
		}
		public ImageIcon getjc {
			// have a 'get' method for each image
			return cjc;
		}
		public ImageIcon getjh {
			// have a 'get' method for each image
			return cjh;
		}
		public ImageIcon getqs {
			// have a 'get' method for each image
			return cqs;
		}
		public ImageIcon getqd {
			// have a 'get' method for each image
			return cqd;
		}
		public ImageIcon getqc {
			// have a 'get' method for each image
			return cqc;
		}
		public ImageIcon getqh {
			// have a 'get' method for each image
			return cqh;
		}
		public ImageIcon getks {
			// have a 'get' method for each image
			return cks;
		}
		public ImageIcon getkd {
			// have a 'get' method for each image
			return ckd;
		}
		public ImageIcon getkc {
			// have a 'get' method for each image
			return ckc;
		}
		public ImageIcon getkh {
			// have a 'get' method for each image
			return ckh;
		}
	}
