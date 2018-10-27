package FingerGame;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;

import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class FingerGameServer {

	protected JFrame frame;
	protected JPanel imagePanel;
	protected static JButton btn_l1;
	protected static JButton btn_r1;
	protected static JButton btn_l2;
	protected static JButton btn_r2;
	protected static JButton piano;
	protected static JLabel i_hand_label;
	protected static JButton btn_cg;
	protected static JButton btn_piano;
	protected static JButton btn_poking;

	protected static int connected_state = 0;
	// score
	protected static int p1 = 0;
	protected static int p2 = 0;

	protected static int number_left1 = 1;
	protected static int number_right1 = 1;
	protected static int number_left2 = 1;
	protected static int number_right2 = 1;

	protected static boolean l1_bool = false;
	protected static boolean r1_bool = false;
	protected static boolean l2_bool = false;
	protected static boolean r2_bool = false;

	protected static boolean Broken_l1 = false;
	protected static boolean Broken_r1 = false;
	protected static boolean Broken_l2 = false;
	protected static boolean Broken_r2 = false;

	// 連線
	protected static ServerSocket server;
	protected static Socket client;
	protected static DataInputStream in;
	protected static DataOutputStream out;

	// 聊天室
	private static JTextField textField;
	private static JTextArea textArea;
	private JScrollPane scrollPane;

	// image
	protected static ImageIcon bcg = new ImageIcon("bcg.png");
	protected static ImageIcon bpiano = new ImageIcon("bp.png");
	protected static ImageIcon bpoking = new ImageIcon("bpo.png");
	protected static ImageIcon bcg1 = new ImageIcon("bcg1.png");
	protected static ImageIcon bpiano1 = new ImageIcon("bp1.png");
	protected static ImageIcon bpoking1 = new ImageIcon("bpo1.png");
	protected static ImageIcon r1_0 = new ImageIcon("r1_0.png");
	protected static ImageIcon l1_0 = new ImageIcon("l1_0.png");
	protected static ImageIcon r1_1 = new ImageIcon("r1_1.png");
	protected static ImageIcon l1_1 = new ImageIcon("l1_1.png");
	protected static ImageIcon r1_2 = new ImageIcon("r1_2.png");
	protected static ImageIcon l1_2 = new ImageIcon("l1_2.png");
	protected static ImageIcon r1_3 = new ImageIcon("r1_3.png");
	protected static ImageIcon l1_3 = new ImageIcon("l1_3.png");
	protected static ImageIcon r1_4 = new ImageIcon("r1_4.png");
	protected static ImageIcon l1_4 = new ImageIcon("l1_4.png");
	protected static ImageIcon r2_0 = new ImageIcon("r2_0.png");
	protected static ImageIcon l2_0 = new ImageIcon("l2_0.png");
	protected static ImageIcon r2_1 = new ImageIcon("r2_1.png");
	protected static ImageIcon l2_1 = new ImageIcon("l2_1.png");
	protected static ImageIcon r2_2 = new ImageIcon("r2_2.png");
	protected static ImageIcon l2_2 = new ImageIcon("l2_2.png");
	protected static ImageIcon r2_3 = new ImageIcon("r2_3.png");
	protected static ImageIcon l2_3 = new ImageIcon("l2_3.png");
	protected static ImageIcon r2_4 = new ImageIcon("r2_4.png");
	protected static ImageIcon l2_4 = new ImageIcon("l2_4.png");
	protected static ImageIcon l1_5 = new ImageIcon("l1_5.png");
	protected static ImageIcon r1_5 = new ImageIcon("r1_5.png");
	protected static ImageIcon l2_5 = new ImageIcon("l2_5.png");
	protected static ImageIcon r2_5 = new ImageIcon("r2_5.png");
	protected static ImageIcon p = new ImageIcon("piano.png");
	protected static ImageIcon pc = new ImageIcon("pc.png");
	protected static ImageIcon pd = new ImageIcon("pd.png");
	protected static ImageIcon pe = new ImageIcon("pe.png");
	protected static ImageIcon pf = new ImageIcon("pf.png");
	protected static ImageIcon pg = new ImageIcon("pg.png");
	protected static ImageIcon i_hand = new ImageIcon("hand.png");
	protected static ImageIcon broken = new ImageIcon("broken.png");
	protected static ImageIcon note0 = new ImageIcon("note.png");
	protected static ImageIcon note1 = new ImageIcon("note.png");
	protected static ImageIcon note2 = new ImageIcon("do.png");
	protected static ImageIcon note3 = new ImageIcon("note.png");
	protected static ImageIcon note4 = new ImageIcon("note.png");
	protected static ImageIcon note5 = new ImageIcon("note.png");
	protected static ImageIcon note6 = new ImageIcon("note.png");
	protected static ImageIcon note7 = new ImageIcon("note.png");
	protected static ImageIcon note8 = new ImageIcon("note.png");
	protected static ImageIcon note9 = new ImageIcon("note.png");
	protected static ImageIcon note10 = new ImageIcon("note.png");
	protected static ImageIcon note11 = new ImageIcon("note.png");
	protected static ImageIcon note12 = new ImageIcon("note.png");
	protected static ImageIcon note13 = new ImageIcon("note.png");
	protected static ImageIcon note14 = new ImageIcon("note.png");
	protected static ImageIcon note15 = new ImageIcon("do.png");
	protected static ImageIcon note16 = new ImageIcon("note.png");
	protected static ImageIcon note17 = new ImageIcon("note.png");
	protected static ImageIcon note18 = new ImageIcon("note.png");
	protected static ImageIcon note19 = new ImageIcon("note.png");
	protected static ImageIcon note20 = new ImageIcon("note.png");
	protected static ImageIcon note21 = new ImageIcon("note.png");
	protected static ImageIcon note22 = new ImageIcon("note.png");
	protected static ImageIcon note23 = new ImageIcon("note.png");
	protected static ImageIcon note24 = new ImageIcon("do.png");
	protected static JLabel label[] = new JLabel[25];
	protected static int x_note = 350;
	protected static int y_do = 87;
	protected static int y_re = 77;
	protected static int y_mi = 72;
	protected static int y_fa = 64;
	protected static int y_sol = 57;
	protected static int grade = 0;
	protected static int cflag = 0;
	protected static int dflag = 0;
	protected static int eflag = 0;
	protected static int fflag = 0;
	protected static int gflag = 0;
	protected static ImageIcon stave = new ImageIcon("stave.png");
	protected static JLabel stave_label;
	protected static JLabel hand;
	protected static ImageIcon handc = new ImageIcon("1_1.png");
	
	public static final Toolkit toolkit = Toolkit.getDefaultToolkit();

	int num = 0;
	String game = "didi";

	public void connectedGame() {
		game = "cg";
		btn_l2 = new JButton(l2_1);
		btn_l2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// button做的事
				String btn = "l2";
				try {
					out.writeUTF(btn);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				l2_bool = true;
				connected_state++;
				if (connected_state == 1) {
					num = number_left2;
					disableRandomButtons();
					p2_enableButtons();
				} else if (connected_state == 2) {
					connected_state = 0;
					if (r2_bool == true)
						changeSelfWrite();
					else
						number_left2 += num;
					falseBools();
					disableButtons();
				}
				checkDisableButtonsforever();
				changePic();
				Checkwin();
			}
		});
		btn_l2.setContentAreaFilled(false);
		btn_l2.setBorderPainted(false);
		btn_l2.setBounds(280, 0, 200, 200);
		frame.getContentPane().add(btn_l2);

		btn_r2 = new JButton(r2_1);
		btn_r2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// button做的事
				String btn = "r2";
				try {
					out.writeUTF(btn);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				r2_bool = true;
				connected_state++;
				if (connected_state == 1) {
					num = number_right2;
					disableRandomButtons();
					p2_enableButtons();
				} else if (connected_state == 2) {
					connected_state = 0;
					if (l2_bool == true)
						changeSelfWrite();
					else
						number_right2 += num;
					falseBools();
					disableButtons();
				}
				checkDisableButtonsforever();
				changePic();
				Checkwin();
			}
		});
		btn_r2.setContentAreaFilled(false);
		btn_r2.setBorderPainted(false);
		btn_r2.setBounds(60, 0, 200, 200);
		frame.getContentPane().add(btn_r2);

		// server hand
		btn_l1 = new JButton(l1_1);
		btn_l1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// button做的事
				String btn = "l1";
				try {
					out.writeUTF(btn);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				l1_bool = true;
				connected_state++;
				if (connected_state == 1) {
					num = number_left1;
					disableRandomButtons();
					p2_enableButtons();
				} else if (connected_state == 2) {
					connected_state = 0;
					if (r1_bool == true)
						changeSelfWrite();
					else
						number_left1 += num;
					falseBools();
					disableButtons();
				}
				checkDisableButtonsforever();
				changePic();
				Checkwin();
			}
		});
		btn_l1.setContentAreaFilled(false);
		btn_l1.setBorderPainted(false);
		btn_l1.setBounds(60, 260, 200, 200);
		frame.getContentPane().add(btn_l1);

		btn_r1 = new JButton(r1_1);
		btn_r1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// button做的事
				String btn = "r1";
				try {
					out.writeUTF(btn);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				r1_bool = true;
				connected_state++;
				if (connected_state == 1) {
					num = number_right1;
					disableRandomButtons();
					p2_enableButtons();
				} else if (connected_state == 2) {
					connected_state = 0;
					if (l1_bool == true)
						changeSelfWrite();
					else
						number_right1 += num;
					falseBools();
					disableButtons();
				}
				checkDisableButtonsforever();
				changePic();
				Checkwin();
			}
		});

		btn_r1.setContentAreaFilled(false);
		btn_r1.setBorderPainted(false);
		btn_r1.setBounds(280, 260, 200, 200);
		frame.getContentPane().add(btn_r1);

		disableButtons();
		p1_enableButtons();// server move first
	}

	public void pianoGame() {
		game = "piano";
		stave_label = new JLabel();
		stave_label.setBounds(70, 15, stave.getIconWidth(), stave.getIconHeight());
		stave_label.setVisible(true);
		frame.getContentPane().add(stave_label);
		hand = new JLabel();
		hand.setBounds(80, 290, 200, 200);
		hand.setVisible(true);
		frame.getContentPane().add(hand);
		piano = new JButton();
		piano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				start_piano();
			}
		});
		piano.setContentAreaFilled(false);
		piano.setBorderPainted(false);
		piano.setBounds(70, 200, 330, 200);
		frame.getContentPane().add(piano);

		piano.setIcon(p);
		hand.setIcon(handc);
		stave_label.setIcon(stave);

		piano.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_C) {
					System.out.println("c");
					piano.setIcon(pc);
					Thread soundThread = playSound(new File("pianoC.wav"));
					try {
						Thread.sleep(1);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					for (int i = 0; i < label.length; i++) {
						if (label[i].getY() == y_do && i >= cflag) {
							label[i].setVisible(false);
							cflag = i + 1;
							System.out.println(cflag);
							break;
						}
					}
				}
				if (keyCode == KeyEvent.VK_V) {
					System.out.println("v");
					piano.setIcon(pd);
					Thread soundThread = playSound(new File("pianoD.wav"));
					try {
						Thread.sleep(1);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					for (int i = 0; i < label.length; i++) {
						if (label[i].getY() == y_re && i >= dflag) {
							label[i].setVisible(false);
							dflag = i + 1;
							System.out.println(dflag);
							break;
						}
					}
					// flag=0;
				}
				if (keyCode == KeyEvent.VK_B) {
					System.out.println("b");
					piano.setIcon(pe);
					Thread soundThread = playSound(new File("pianoE.wav"));
					try {
						Thread.sleep(1);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					for (int i = 0; i < label.length; i++) {
						if (label[i].getY() == y_mi && i >= eflag) {
							label[i].setVisible(false);
							eflag = i + 1;
							System.out.println(eflag);
							break;
						}
					}
				}
				if (keyCode == KeyEvent.VK_N) {
					System.out.println("n");
					piano.setIcon(pf);
					Thread soundThread = playSound(new File("pianoF.wav"));
					try {
						Thread.sleep(1);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					for (int i = 0; i < label.length; i++) {
						if (label[i].getY() == y_fa && i >= fflag) {
							label[i].setVisible(false);
							fflag = i + 1;
							System.out.println(fflag);
							break;
						}
					}
				}
				if (keyCode == KeyEvent.VK_M) {
					System.out.println("m");
					piano.setIcon(pg);
					Thread soundThread = playSound(new File("pianoG.wav"));
					try {
						Thread.sleep(1);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					for (int i = 0; i < label.length; i++) {
						if (label[i].getY() == y_sol && i >= gflag) {
							label[i].setVisible(false);
							gflag = i + 1;
							System.out.println(gflag);
							break;
						}
					}
				}
			}
		});
	}

	private static void start_piano() {
		final Timer timer = new Timer();
		for (int i = 0; i < label.length; i++) {
			label[i] = new JLabel();
			System.out.println(i);
		}
		int x[] = new int[] { 360, 400, 440, 480, 520, 560, 600, 640, 680, 720, 760, 800, 840, 880, 920, 960, 1000,
				1040, 1080, 1120, 1160, 1200, 1240, 1280, 1320 };
		timer.scheduleAtFixedRate(new TimerTask() {
			int i = 0;
			int over=0;
			public void run() {
				// 0
				label[0].setBounds(x[0], y_mi, 150, 100);
				window.frame.getContentPane().add(label[0]);
				label[0].setIcon(note0);
				x[0] -= 20;
				if (x[0] < 120) {
					label[0].setVisible(false);
				}
				// 1
				if (x[1] < 360) {
					label[1].setBounds(x[1], y_re, 150, 100);
					window.frame.getContentPane().add(label[1]);
					label[1].setIcon(note1);

					if (x[1] < 120) {
						label[1].setVisible(false);
					}
				}
				x[1] -= 20;
				// 2
				if (x[2] < 360) {
					label[2].setBounds(x[2], y_do, 150, 100);
					window.frame.getContentPane().add(label[2]);
					label[2].setIcon(note2);

					if (x[2] < 120) {
						label[2].setVisible(false);
					}
				}
				x[2] -= 20;
				// 3
				if (x[3] < 360) {
					label[3].setBounds(x[3], y_re, 150, 100);
					window.frame.getContentPane().add(label[3]);
					label[3].setIcon(note3);

					if (x[3] < 120) {
						label[3].setVisible(false);
					}
				}
				x[3] -= 20;
				// 4
				if (x[4] < 360) {
					label[4].setBounds(x[4], y_mi, 150, 100);
					window.frame.getContentPane().add(label[4]);
					label[4].setIcon(note4);

					if (x[4] < 120) {
						label[4].setVisible(false);
					}
				}
				x[4] -= 20;
				// 5
				if (x[5] < 360) {
					label[5].setBounds(x[5], y_mi, 150, 100);
					window.frame.getContentPane().add(label[5]);
					label[5].setIcon(note5);

					if (x[5] < 120) {
						label[5].setVisible(false);
					}
				}
				x[5] -= 20;
				// 6
				if (x[6] < 360) {
					label[6].setBounds(x[6], y_mi, 150, 100);
					window.frame.getContentPane().add(label[6]);
					label[6].setIcon(note6);

					if (x[6] < 120) {
						label[6].setVisible(false);
					}
				}
				x[6] -= 20;

				// 7
				if (x[7] < 360) {
					label[7].setBounds(x[7], y_re, 150, 100);
					window.frame.getContentPane().add(label[7]);
					label[7].setIcon(note7);

					if (x[7] < 120) {
						label[7].setVisible(false);
					}
				}
				x[7] -= 20;
				// 8
				if (x[8] < 360) {
					label[8].setBounds(x[8], y_re, 150, 100);
					window.frame.getContentPane().add(label[8]);
					label[8].setIcon(note8);

					if (x[8] < 120) {
						label[8].setVisible(false);
					}
				}
				x[8] -= 20;
				// 9
				if (x[9] < 360) {
					label[9].setBounds(x[9], y_re, 150, 100);
					window.frame.getContentPane().add(label[9]);
					label[9].setIcon(note9);

					if (x[9] < 120) {
						label[9].setVisible(false);
					}
				}
				x[9] -= 20;
				// 10
				if (x[10] < 360) {
					label[10].setBounds(x[10], y_mi, 150, 100);
					window.frame.getContentPane().add(label[10]);
					label[10].setIcon(note10);

					if (x[10] < 120) {
						label[10].setVisible(false);
					}
				}
				x[10] -= 20;
				// 11
				if (x[11] < 360) {
					label[11].setBounds(x[11], y_sol, 150, 100);
					window.frame.getContentPane().add(label[11]);
					label[11].setIcon(note11);

					if (x[11] < 120) {
						label[11].setVisible(false);
					}
				}
				x[11] -= 20;
				// 12
				if (x[12] < 360) {
					label[12].setBounds(x[12], y_sol, 150, 100);
					window.frame.getContentPane().add(label[12]);
					label[12].setIcon(note12);

					if (x[12] < 120) {
						label[12].setVisible(false);
					}
				}
				x[12] -= 20;
				// 13
				if (x[13] < 360) {
					label[13].setBounds(x[13], y_mi, 150, 100);
					window.frame.getContentPane().add(label[13]);
					label[13].setIcon(note13);

					if (x[13] < 120) {
						label[13].setVisible(false);
					}
				}
				x[13] -= 20;
				// 14
				if (x[14] < 360) {
					label[14].setBounds(x[14], y_re, 150, 100);
					window.frame.getContentPane().add(label[14]);
					label[14].setIcon(note14);

					if (x[14] < 120) {
						label[14].setVisible(false);
					}
				}
				x[14] -= 20;
				// 15
				if (x[15] < 360) {
					label[15].setBounds(x[15], y_do, 150, 100);
					window.frame.getContentPane().add(label[15]);
					label[15].setIcon(note15);

					if (x[15] < 120) {
						label[15].setVisible(false);
					}
				}
				x[15] -= 20;
				// 16
				if (x[16] < 360) {
					label[16].setBounds(x[16], y_re, 150, 100);
					window.frame.getContentPane().add(label[16]);
					label[16].setIcon(note16);

					if (x[16] < 120) {
						label[16].setVisible(false);
					}
				}
				x[16] -= 20;
				// 17
				if (x[17] < 360) {
					label[17].setBounds(x[17], y_mi, 150, 100);
					window.frame.getContentPane().add(label[17]);
					label[17].setIcon(note17);

					if (x[17] < 120) {
						label[17].setVisible(false);
					}
				}
				x[17] -= 20;
				// 18
				if (x[18] < 360) {
					label[18].setBounds(x[18], y_mi, 150, 100);
					window.frame.getContentPane().add(label[18]);
					label[18].setIcon(note18);

					if (x[18] < 120) {
						label[18].setVisible(false);
					}
				}
				x[18] -= 20;
				// 19
				if (x[19] < 360) {
					label[19].setBounds(x[19], y_mi, 150, 100);
					window.frame.getContentPane().add(label[19]);
					label[19].setIcon(note19);

					if (x[19] < 120) {
						label[19].setVisible(false);
					}
				}
				x[19] -= 20;
				// 20
				if (x[20] < 360) {
					label[20].setBounds(x[20], y_re, 150, 100);
					window.frame.getContentPane().add(label[20]);
					label[20].setIcon(note14);

					if (x[20] < 120) {
						label[20].setVisible(false);
					}
				}
				x[20] -= 20;
				// 21
				if (x[21] < 360) {
					label[21].setBounds(x[21], y_re, 150, 100);
					window.frame.getContentPane().add(label[21]);
					label[21].setIcon(note21);

					if (x[21] < 120) {
						label[21].setVisible(false);
					}
				}
				x[21] -= 20;
				// 22
				if (x[22] < 360) {
					label[22].setBounds(x[22], y_mi, 150, 100);
					window.frame.getContentPane().add(label[22]);
					label[22].setIcon(note22);

					if (x[22] < 120) {
						label[22].setVisible(false);
					}
				}
				x[22] -= 20;
				// 23
				if (x[23] < 360) {
					label[23].setBounds(x[23], y_re, 150, 100);
					window.frame.getContentPane().add(label[23]);
					label[23].setIcon(note23);

					if (x[23] < 120) {
						label[23].setVisible(false);
					}
				}
				x[23] -= 20;
				// 24
				if (x[24] < 360) {
					label[24].setBounds(x[24], y_do, 150, 100);
					window.frame.getContentPane().add(label[24]);
					label[24].setIcon(note24);

					if (x[24] < 120) {
						label[24].setVisible(false);
						over=1;
					}
				}
				x[24] -= 20;
				if(over==1) {
					JOptionPane.showMessageDialog(null, "Finish! Congradulation!");
					window.changeGame();
					timer.cancel();
				}
			}		
		}, 0, 400); // 0.5s a time
	}

	public void pokingGame() throws IOException {
		game = "poking";
		i_hand_label = new JLabel();
		i_hand_label.setBounds(60, 80, 410, 400);
		BufferedImage image = ImageIO.read(new File("hand.png"));
		i_hand_label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println(image.getRGB(e.getX(), e.getY()));
				@SuppressWarnings("unused")
				Thread soundThread = playSound(new File("stabbing.wav"));
				try {
					Thread.sleep(1);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if (image.getRGB(e.getX(), e.getY()) != 0) {
					i_hand_label.setIcon(broken);
					soundThread = playSound(new File("scream.wav"));
					try {
						Thread.sleep(1);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "You Lose !");
					changeGame();
				}
			}
		});
		frame.getContentPane().add(i_hand_label);
		i_hand_label.setIcon(i_hand);
		Image img = Toolkit.getDefaultToolkit().getImage("knife.png");
		setCursor1(frame, img);
		i_hand_label.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("press");
				setCursor2(frame, img);
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("release");
				setCursor1(frame, img);
			}
		});
	}
	
	public void changeGame() {
		// remove
		if (game.equals("cg")) {
			btn_l1.setVisible(false);
			btn_l2.setVisible(false);
			btn_r1.setVisible(false);
			btn_r2.setVisible(false);
		}
		if (game.equals("piano")) {
			piano.setVisible(false);
			stave_label.setVisible(false);
			hand.setVisible(false);
		}			
		if (game.equals("poking")) {
			i_hand_label.setVisible(false);
		}
	}
	
	public static void setCursor1(Component c, Image image) {
		Cursor cursor = toolkit.createCustomCursor(image, new Point(0, 270), null);
		c.setCursor(cursor);
	}

	public static void setCursor2(Component c, Image image) {
		Cursor cursor = toolkit.createCustomCursor(image, new Point(0, 250), null);
		c.setCursor(cursor);
	}

	protected static void changePic() {
		switch (number_left1) {
		case 0:
			btn_l1.setIcon(l1_0);
			break;
		case 1:
			btn_l1.setIcon(l1_1);
			break;
		case 2:
			btn_l1.setIcon(l1_2);
			break;
		case 3:
			btn_l1.setIcon(l1_3);
			break;
		case 4:
			btn_l1.setIcon(l1_4);
			break;
		case 5:
			btn_l1.setIcon(l1_5);
			break;
		}
		switch (number_right1) {
		case 0:
			btn_r1.setIcon(r1_0);
			break;
		case 1:
			btn_r1.setIcon(r1_1);
			break;
		case 2:
			btn_r1.setIcon(r1_2);
			break;
		case 3:
			btn_r1.setIcon(r1_3);
			break;
		case 4:
			btn_r1.setIcon(r1_4);
			break;
		case 5:
			btn_r1.setIcon(r1_5);
			break;
		}
		switch (number_left2) {
		case 0:
			btn_l2.setIcon(l2_0);
			break;
		case 1:
			btn_l2.setIcon(l2_1);
			break;
		case 2:
			btn_l2.setIcon(l2_2);
			break;
		case 3:
			btn_l2.setIcon(l2_3);
			break;
		case 4:
			btn_l2.setIcon(l2_4);
			break;
		case 5:
			btn_l2.setIcon(l2_5);
			break;
		}
		switch (number_right2) {
		case 0:
			btn_r2.setIcon(r2_0);
			break;
		case 1:
			btn_r2.setIcon(r2_1);
			break;
		case 2:
			btn_r2.setIcon(r2_2);
			break;
		case 3:
			btn_r2.setIcon(r2_3);
			break;
		case 4:
			btn_r2.setIcon(r2_4);
			break;
		case 5:
			btn_r2.setIcon(r2_5);
			break;
		}
	}

	public static void player_1_win() {
		JOptionPane.showMessageDialog(null, "You Win."); // debug

		disableButtons(); // not include btn_retry
		retry();

		p1++;
		textArea.setText(textArea.getText().trim() + "\nWin: " + p1 + " Lose: " + p2 + "\n");
	}

	public static void player_2_win() {
		JOptionPane.showMessageDialog(null, "You Lose!"); // debug

		disableButtons();
		retry();

		p2++;
		textArea.setText(textArea.getText().trim() + "\nWin: " + p1 + " Lose: " + p2 + "\n");
	}

	protected static void retry() {
		// 讓四隻手都歸1，並且讓四隻手都可以按,並且四個boolean設為false
		number_left1 = 1;
		number_right1 = 1;
		number_left2 = 1;
		number_right2 = 1;
		falseBools();
		Broken_l1 = false;
		Broken_r1 = false;
		Broken_l2 = false;
		Broken_r2 = false;
		connected_state = 0;
		disableButtons();
		p1_enableButtons();
		changePic();
		window.changeGame();
	}

	public static void falseBools() {
		// 每回合結束
		r1_bool = false;
		l1_bool = false;
		r2_bool = false;
		l2_bool = false;
	}

	public static void p1_enableButtons() {
		// 除了爆掉的手，其他打開
		if (!Broken_l1)
			btn_l1.setEnabled(true);
		if (!Broken_r1)
			btn_r1.setEnabled(true);
	}

	public static void p2_enableButtons() {
		// 除了爆掉的手，其他打開
		if (!Broken_l2)
			btn_l2.setEnabled(true);
		if (!Broken_r2)
			btn_r2.setEnabled(true);
	}

	public static void disableButtons() {
		// 遊戲結束或換對方時，都不能按
		btn_l1.setEnabled(false);
		btn_r1.setEnabled(false);
		btn_l2.setEnabled(false);
		btn_r2.setEnabled(false);
	}

	public static void disableRandomButtons() {
		// 選到的手
		if (l1_bool)
			btn_l1.setEnabled(false);
		if (r1_bool)
			btn_r1.setEnabled(false);
		if (l2_bool)
			btn_l2.setEnabled(false);
		if (r2_bool)
			btn_r2.setEnabled(false);
	}

	public static void checkDisableButtonsforever() {
		if (number_left1 >= 5) {
			Broken_l1 = true;
			number_left1 = 5;
		}
		if (number_right1 >= 5) {
			Broken_r1 = true;
			number_right1 = 5;
		}
		if (number_left2 >= 5) {
			Broken_l2 = true;
			number_left2 = 5;
		}
		if (number_right2 >= 5) {
			Broken_r2 = true;
			number_right2 = 5;
		}
	}

	public static void changeSelfWrite() {

		Object[] obj = { "" };
		if (l2_bool && r2_bool) {
			if (number_left2 == 4 && number_right2 == 4) {
				obj = new Object[] { "4,4" };
			} else if (number_left2 == 4 && number_right2 == 3) {
				obj = new Object[] { "3,4" };
			} else if (number_left2 == 4 && number_right2 == 2) {
				obj = new Object[] { "2,4", "3,3" };
			} else if (number_left2 == 4 && number_right2 == 1) {
				obj = new Object[] { "1,4", "2,3" };
			} else if (number_left2 == 4 && number_right2 == 0) {
				obj = new Object[] { "1,3", "2,2", "0,4" };
			} else if (number_left2 == 3 && number_right2 == 0) {
				obj = new Object[] { "1,2", "0,3" };
			} else if (number_left2 == 3 && number_right2 == 1) {
				obj = new Object[] { "2,2", "4,0", "1,3" };
			} else if (number_left2 == 3 && number_right2 == 2) {
				obj = new Object[] { "1,4", "2,3" };
			} else if (number_left2 == 3 && number_right2 == 3) {
				obj = new Object[] { "2,4", "3,3" };
			} else if (number_left2 == 2 && number_right2 == 0) {
				obj = new Object[] { "1,1", "2,0" };
			} else if (number_left2 == 2 && number_right2 == 1) {
				obj = new Object[] { "0,3", "1,2" };
			} else if (number_left2 == 2 && number_right2 == 2) {
				obj = new Object[] { "0,4", "1,3", "2,2" };
			} else if (number_left2 == 1 && number_right2 == 1) {
				obj = new Object[] { "0,2", "1,1" };
			} else if (number_left2 == 3 && number_right2 == 4) {
				obj = new Object[] { "3,4" };
			} else if (number_left2 == 2 && number_right2 == 4) {
				obj = new Object[] { "2,4", "3,3" };
			} else if (number_left2 == 1 && number_right2 == 4) {
				obj = new Object[] { "1,4", "2,3" };
			} else if (number_left2 == 0 && number_right2 == 4) {
				obj = new Object[] { "1,3", "2,2", "0,4" };
			} else if (number_left2 == 0 && number_right2 == 3) {
				obj = new Object[] { "1,2", "0,3" };
			} else if (number_left2 == 1 && number_right2 == 3) {
				obj = new Object[] { "2,2", "4,0", "1,3" };
			} else if (number_left2 == 2 && number_right2 == 3) {
				obj = new Object[] { "1,4", "2,3" };
			} else if (number_left2 == 0 && number_right2 == 2) {
				obj = new Object[] { "1,1", "2,0" };
			} else if (number_left2 == 1 && number_right2 == 2) {
				obj = new Object[] { "0,3", "1,2" };
			}

			String s;
			s = (String) JOptionPane.showInputDialog(null, "選擇你的分配:\n", "分配", JOptionPane.PLAIN_MESSAGE, null, obj,
					obj[0]);
			// 把s拆成 var1 var2
			number_left2 = s.charAt(0) - 48;
			number_right2 = s.charAt(2) - 48;

			try {
				out.writeUTF(Integer.toString(number_left2));
				out.writeUTF(Integer.toString(number_right2));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		if (l1_bool && r1_bool) {
			if (number_left1 == 4 && number_right1 == 4) {
				obj = new Object[] { "4,4" };
			} else if (number_left1 == 4 && number_right1 == 3) {
				obj = new Object[] { "3,4" };
			} else if (number_left1 == 4 && number_right1 == 2) {
				obj = new Object[] { "2,4", "3,3" };
			} else if (number_left1 == 4 && number_right1 == 1) {
				obj = new Object[] { "1,4", "2,3" };
			} else if (number_left1 == 4 && number_right1 == 0) {
				obj = new Object[] { "1,3", "2,2", "0,4" };
			} else if (number_left1 == 3 && number_right1 == 0) {
				obj = new Object[] { "1,2", "0,3" };
			} else if (number_left1 == 3 && number_right1 == 1) {
				obj = new Object[] { "2,2", "4,0", "1,3" };
			} else if (number_left1 == 3 && number_right1 == 2) {
				obj = new Object[] { "1,4", "2,3" };
			} else if (number_left1 == 3 && number_right1 == 3) {
				obj = new Object[] { "2,4", "3,3" };
			} else if (number_left1 == 2 && number_right1 == 0) {
				obj = new Object[] { "1,1", "2,0" };
			} else if (number_left1 == 2 && number_right1 == 1) {
				obj = new Object[] { "0,3", "1,2" };
			} else if (number_left1 == 2 && number_right1 == 2) {
				obj = new Object[] { "0,4", "1,3", "2,2" };
			} else if (number_left1 == 1 && number_right1 == 1) {
				obj = new Object[] { "0,2", "1,1" };
			} else if (number_left1 == 3 && number_right1 == 4) {
				obj = new Object[] { "3,4" };
			} else if (number_left1 == 2 && number_right1 == 4) {
				obj = new Object[] { "2,4", "3,3" };
			} else if (number_left1 == 1 && number_right1 == 4) {
				obj = new Object[] { "1,4", "2,3" };
			} else if (number_left1 == 0 && number_right1 == 4) {
				obj = new Object[] { "1,3", "2,2", "0,4" };
			} else if (number_left1 == 0 && number_right1 == 3) {
				obj = new Object[] { "1,2", "0,3" };
			} else if (number_left1 == 1 && number_right1 == 3) {
				obj = new Object[] { "2,2", "4,0", "1,3" };
			} else if (number_left1 == 2 && number_right1 == 3) {
				obj = new Object[] { "1,4", "2,3" };
			} else if (number_left1 == 0 && number_right1 == 2) {
				obj = new Object[] { "1,1", "2,0" };
			} else if (number_left1 == 1 && number_right1 == 2) {
				obj = new Object[] { "0,3", "1,2" };
			}

			String s;
			s = (String) JOptionPane.showInputDialog(null, "選擇你的分配:\n", "分配", JOptionPane.PLAIN_MESSAGE, null, obj,
					obj[0]);
			// 把s拆成 var1 var2
			number_left1 = s.charAt(0) - 48;
			number_right1 = s.charAt(2) - 48;

			try {
				out.writeUTF(Integer.toString(number_left1));
				out.writeUTF(Integer.toString(number_right1));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	public static void changeSelfRead() {

		if (l2_bool && r2_bool) {

			try {
				number_left2 = Integer.valueOf(in.readUTF());
				number_right2 = Integer.valueOf(in.readUTF());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		if (l1_bool && r1_bool) {
			try {
				number_left1 = Integer.valueOf(in.readUTF());
				number_right1 = Integer.valueOf(in.readUTF());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	public static void Checkwin() {
		// player1 win
		if (Broken_l1 == true && Broken_r1 == true)
			player_2_win();
		// player2 win
		else if (Broken_l2 == true && Broken_r2 == true)
			player_1_win();
	}

	static FingerGameServer window;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new FingerGameServer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		try {
			server = new ServerSocket(5000);
			client = server.accept();
			in = new DataInputStream(client.getInputStream());
			out = new DataOutputStream(client.getOutputStream());
			textArea.setText(textArea.getText().trim() + "Connected !");

			int i = 0;
			while (true) {
				String btn = in.readUTF();
				if (btn.equals("l1") == true) {
					l1_bool = true;
					connected_state++;
					if (connected_state == 1) {
						i = number_left1;
					} else if (connected_state == 2) {
						connected_state = 0;
						if (r1_bool == true)
							changeSelfRead();
						else
							number_left1 += i;
						falseBools();
						p1_enableButtons();
					}
					checkDisableButtonsforever();
					changePic();
					Checkwin();
				} else if (btn.equals("r1") == true) {
					r1_bool = true;
					connected_state++;
					if (connected_state == 1) {
						i = number_right1;
					} else if (connected_state == 2) {
						connected_state = 0;
						if (l1_bool == true)
							changeSelfRead();
						else
							number_right1 += i;
						falseBools();
						p1_enableButtons();
					}
					checkDisableButtonsforever();
					changePic();
					Checkwin();
				} else if (btn.equals("l2") == true) {
					l2_bool = true;
					connected_state++;
					if (connected_state == 1) {
						i = number_left2;
					} else if (connected_state == 2) {
						connected_state = 0;
						if (r2_bool == true)
							changeSelfRead();
						else
							number_left2 += i;
						falseBools();
						p1_enableButtons();
					}
					checkDisableButtonsforever();
					changePic();
					Checkwin();
				} else if (btn.equals("r2") == true) {
					r2_bool = true;
					connected_state++;
					if (connected_state == 1) {
						i = number_right2;
					} else if (connected_state == 2) {
						connected_state = 0;
						if (l2_bool == true)
							changeSelfRead();
						else
							number_right2 += i;
						falseBools();
						p1_enableButtons();
					}
					checkDisableButtonsforever();
					changePic();
					Checkwin();
				} else if (btn.equals("cgb") == true) {
					window.connectedGame();
				} else {
					textArea.setText(textArea.getText().trim() + "\nYou: " + btn);
				}
			}
		} catch (IOException e) {
			textArea.setText(textArea.getText().trim() + "\nunconnected...");
			JOptionPane.showMessageDialog(null, "Client is no longer connected");
		}
	}

	/**
	 * Create the application.
	 * 
	 * @throws IOException
	 */

	public FingerGameServer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws IOException
	 */

	@SuppressWarnings("deprecation")
	protected void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		// add background
		ImageIcon img = new ImageIcon("bg2.png");
		JLabel bg = new JLabel(img); // 背景
		bg.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		imagePanel = (JPanel) frame.getContentPane();
		imagePanel.setOpaque(false);
		frame.getLayeredPane().add(bg, new Integer(Integer.MIN_VALUE));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(img.getIconWidth(), img.getIconHeight());
		frame.setResizable(false);
		frame.setVisible(true);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(510, 135, 170, 250);
		frame.getContentPane().add(scrollPane);

		textArea = new JTextArea();
		textArea.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);

		textField = new JTextField();
		textField.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_ENTER) {
					try {
						String msgout = "";
						msgout = textField.getText().trim();
						out.writeUTF(msgout);
						textArea.setText(textArea.getText().trim() + "\nMe: " + msgout);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					textField.setText("");
				}
			}
		});
		textField.setBounds(510, 400, 150, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		// send button
		Font f = new Font("Century Gothic", Font.BOLD, 16);
		JButton btn_send = new JButton();
		btn_send.setText("send");
		btn_send.setFont(f);
		btn_send.setBorder(BorderFactory.createEtchedBorder());
		btn_send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String msgout = "";
					msgout = textField.getText().trim();
					out.writeUTF(msgout);
					textArea.setText(textArea.getText().trim() + "\nMe: " + msgout);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				textField.setText("");
			}
		});
		btn_send.setContentAreaFilled(false);
		btn_send.setBorderPainted(false);
		btn_send.setBounds(662, 400, 45, 30);
		frame.getContentPane().add(btn_send);

		// connected game button
		btn_cg = new JButton(bcg);
		btn_cg.setBorder(BorderFactory.createEtchedBorder());
		btn_cg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					connectedGame();
					out.writeUTF("cgb");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				btn_cg.setIcon(bcg1);
				btn_piano.setIcon(bpiano);
				btn_poking.setIcon(bpoking);
			}
		});
		btn_cg.setContentAreaFilled(false);
		btn_cg.setBorderPainted(false);
		btn_cg.setBounds(680, 145, 30, 70);
		frame.getContentPane().add(btn_cg);

		// little game button
		btn_piano = new JButton(bpiano);
		btn_piano.setBorder(BorderFactory.createEtchedBorder());
		btn_piano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					pianoGame();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				btn_cg.setIcon(bcg);
				btn_piano.setIcon(bpiano1);
				btn_poking.setIcon(bpoking);
			}
		});
		btn_piano.setContentAreaFilled(false);
		btn_piano.setBorderPainted(false);
		btn_piano.setBounds(680, 215, 30, 70);
		frame.getContentPane().add(btn_piano);

		btn_poking = new JButton(bpoking);
		btn_poking.setBorder(BorderFactory.createEtchedBorder());
		btn_poking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					pokingGame();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				btn_cg.setIcon(bcg);
				btn_piano.setIcon(bpiano);
				btn_poking.setIcon(bpoking1);
			}
		});
		btn_poking.setContentAreaFilled(false);
		btn_poking.setBorderPainted(false);
		btn_poking.setBounds(680, 285, 30, 80);
		frame.getContentPane().add(btn_poking);
	}

	public static synchronized Thread playSound(final File file) {

		Thread soundThread = new Thread() {
			@Override
			public void run() {
				try {
					Clip clip = null;
					AudioInputStream inputStream = null;
					clip = AudioSystem.getClip();
					inputStream = AudioSystem.getAudioInputStream(file);
					AudioFormat format = inputStream.getFormat();
					long audioFileLength = file.length();
					int frameSize = format.getFrameSize();
					float frameRate = format.getFrameRate();
					long durationInMiliSeconds = (long) (((float) audioFileLength / (frameSize * frameRate)) * 1000);
					clip.open(inputStream);
					clip.start();
					Thread.sleep(durationInMiliSeconds);
					while (true) {
						if (!clip.isActive()) {
							break;
						}
						long fPos = (long) (clip.getMicrosecondPosition() / 1000);
						long left = durationInMiliSeconds - fPos;
						if (left > 0)
							Thread.sleep(left);
					}
					clip.stop();
					clip.close();
					inputStream.close();
				} catch (LineUnavailableException e) {
					e.printStackTrace();
				} catch (UnsupportedAudioFileException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
				}
			}
		};
		soundThread.setDaemon(true);
		soundThread.start();
		return soundThread;
	}
}
