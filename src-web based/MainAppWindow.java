package randomthoughtgenerator;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Window.Type;

public class MainAppWindow {

	private JFrame frmRandomThoughtGenerator;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainAppWindow window = new MainAppWindow();
					window.frmRandomThoughtGenerator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public MainAppWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		frmRandomThoughtGenerator = new JFrame();
		frmRandomThoughtGenerator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRandomThoughtGenerator.setSize(580,380);
		frmRandomThoughtGenerator.setAutoRequestFocus(false);
		frmRandomThoughtGenerator.setAlwaysOnTop(true);
		frmRandomThoughtGenerator.setTitle("Random Thought Generator");
		frmRandomThoughtGenerator.getContentPane().setLayout(null);
		frmRandomThoughtGenerator.setVisible(true);
		
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setBounds(102, 12, 365, 172);
		frmRandomThoughtGenerator.getContentPane().add(textArea);
		
		JButton btnthought = new JButton("Generate Random Thought");
		btnthought.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					new RandomThoughtGenerator();
					textArea.setText(RandomThoughtGenerator.thought+"-----"+RandomThoughtGenerator.creator);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnthought.setBounds(172, 202, 227, 25);
		frmRandomThoughtGenerator.getContentPane().add(btnthought);
		
		JButton btnclear = new JButton("Clear");
		btnclear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea.setText("");
				
			}
		});
		btnclear.setBounds(219, 239, 117, 25);
		frmRandomThoughtGenerator.getContentPane().add(btnclear);
		
		JButton btnclose = new JButton("Close");
		btnclose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnclose.setBounds(219, 276, 117, 25);
		frmRandomThoughtGenerator.getContentPane().add(btnclose);
		
		JButton btnauto = new JButton("Auto");
		btnauto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnthought.setEnabled(false);
				btnauto.setText("Stop");
				Runnable run=new Runnable() {
					@Override
					public void run() {
						try {
							new RandomThoughtGenerator();
							textArea.setText(RandomThoughtGenerator.thought+"-----"+RandomThoughtGenerator.creator);
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}						
					}
				};
				executor.scheduleAtFixedRate(run, 0, 5, TimeUnit.SECONDS);
				if(btnauto.getText()=="Stop") {
					btnauto.addMouseListener(new MouseAdapter() {
						    public void mouseClicked(MouseEvent e) {
						    	btnauto.setText("Auto");
						    	btnthought.setEnabled(true);
						    	executor.shutdown();
						    }
					});
					
				}
			}
		});
		btnauto.setBounds(219, 313, 117, 25);
		frmRandomThoughtGenerator.getContentPane().add(btnauto);
	}
}
