package miniTennis;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Frame {

	private JFrame frmSample;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame window = new Frame();
					window.frmSample.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSample = new JFrame();
		frmSample.setTitle("Sample");
		frmSample.setBounds(100, 100, 450, 300);
		frmSample.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
