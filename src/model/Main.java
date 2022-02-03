package model;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import view.TelaLogin;

public class Main {
		public static void main(String[] args) {
	
		try {
			
	    	for (LookAndFeelInfo info: UIManager.getInstalledLookAndFeels ()) {
	        	if ("Nimbus" .equals (info.getName ())) {
	            	UIManager.setLookAndFeel (info.getClassName ());
	            	break;
	        	}
	    	}
	    	
		} catch (Exception e) {
			
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
			catch(ClassNotFoundException e1) {
				e1.printStackTrace();
			}catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			} catch (UnsupportedLookAndFeelException e1) {
				e1.printStackTrace();
			}
			
		}

		new TelaLogin();
		
	}
	
}
