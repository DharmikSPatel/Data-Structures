import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import java.util.*;
public class TextEditor implements ActionListener{
	ArrayList<Component> allComps;
	JFrame frame;
	JPanel buttonPanel, bigPanel;
	JMenuBar menuBar;
	GridLayout glButtonPanel, glMenuBar, g1BigPanel;
	JButton northB, southB, eastB, westB, resetB;
	JMenu fontM, fsM, fcM, textB, buttonO;
	JMenuItem[] fontMI, fsMI, fcMI, textBMI, buttonOMI;
	String[] fontN, fcN, textBN, buttonON;
	JTextArea textf;
	Font curFont;
	int curSize;
	Font[] fonts;
	int[] fontSizes;
	Color[] fontC, borderColor, textBC, buttonOC;
	public TextEditor(){
		allComps = new ArrayList<Component>();
		frame = new JFrame("Text Editor");
		frame.setSize(1500, 700);
		frame.setLayout(new BorderLayout());

		menuBar  = new JMenuBar();
		glMenuBar = new GridLayout(1,6);
		menuBar.setLayout(glMenuBar);

		fontM    = new JMenu("Change Font");
		fsM      = new JMenu("Font Size");
		fcM      = new JMenu("Font Color");
		textB    = new JMenu("Background Color");
		buttonO  = new JMenu("Button Outline Color");

		fontMI    = new JMenuItem[3];
		fsMI      = new JMenuItem[3];
		fcMI      = new JMenuItem[3];
		textBMI   = new JMenuItem[3];
		buttonOMI = new JMenuItem[4];

		fonts     = new Font[3];
		fontSizes = new int[3];

		fontN     = new String[3];
		fcN       = new String[3];
		textBN    = new String[3];
		buttonON  = new String[4];

		fontC         = new Color[3];
		textBC        = new Color[3];
		buttonOC      = new Color[4];


		for(int i = 0; i < fontMI.length; i++){
			switch (i){
				case 0:
					fontN[i] = "Times New Roman";
					break;
				case 1:
					fontN[i] = "Arial";
					break;
				case 2:
					fontN[i] = "Impact";
					break;
			}
			fonts[i] = new Font(fontN[i], Font.PLAIN, 13);
			fontMI[i] = new JMenuItem(fontN[i]);
			fontMI[i].setFont(fonts[i]);
			fontMI[i].addActionListener(this);
			fontM.add(fontMI[i]);
			allComps.add(fontMI[i]);
		}
		curFont = fonts[0];
		for(int i = 0; i < fsMI.length; i++){
			fontSizes[i] = i*2+13;
			fsMI[i] = new JMenuItem(""+fontSizes[i]);
			fsMI[i].addActionListener(this);
			fsMI[i].setFont(new Font(curFont.getFontName(), Font.PLAIN, fontSizes[i]));
			fsM.add(fsMI[i]);
			allComps.add(fsMI[i]);
		}
		curSize = fontSizes[0];
		for(int i = 0; i < fcMI.length; i++){
			switch (i){
				case 0:
					fcN[i] = "Black";
					fontC[i] = Color.BLACK;
					break;
				case 1:
					fcN[i] = "White";
					fontC[i] = Color.WHITE;
					break;
				case 2:
					int r = (int)(Math.random()*256);
					int g = (int)(Math.random()*256);
					int b = (int)(Math.random()*256);
					fcN[i] = "Random Color: "+r+", "+b+", "+g;
					fontC[i] = new Color(r, g, b);
					break;
			}
			fcMI[i] = new JMenuItem(fcN[i]);
			fcMI[i].setForeground(fontC[i]);
			fcMI[i].addActionListener(this);
			fcM.add(fcMI[i]);
			allComps.add(fcMI[i]);
		}
		for(int i = 0; i < textBMI.length; i++){
			switch (i){
				case 0:
					textBN[i] = "White";
					textBC[i] = Color.WHITE;
					break;
				case 1:
					textBN[i] = "Black";
					textBC[i] = Color.BLACK;
					break;
				case 2:
					int r = (int)(Math.random()*256);
					int g = (int)(Math.random()*256);
					int b = (int)(Math.random()*256);
					textBN[i] = "Random Color: "+r+", "+b+", "+g;
					textBC[i] = new Color(r, g, b);
					break;
			}
			textBMI[i] = new JMenuItem(textBN[i]);
			textBMI[i].setForeground(fontC[0]);
			textBMI[i].setBackground(textBC[i]);
			textBMI[i].setOpaque(true);
			textBMI[i].addActionListener(this);
			textB.add(textBMI[i]);
			allComps.add(textBMI[i]);
		}
		for(int i = 0; i < buttonOMI.length; i++){
			switch (i){
				case 0:
					buttonON[i] = "NONE";
					buttonOC[i] = null;
					break;
				case 1:
					buttonON[i] = "Black";
					buttonOC[i] = Color.BLACK;
					break;
				case 2:
					buttonON[i] = "Red";
					buttonOC[i] = Color.RED;
					break;
				case 3:
					int r = (int)(Math.random()*256);
					int g = (int)(Math.random()*256);
					int b = (int)(Math.random()*256);
					buttonON[i] = "Random Color: "+r+", "+b+", "+g;
					buttonOC[i] = new Color(r, g, b);
					break;

			}
			buttonOMI[i] = new JMenuItem(buttonON[i]);
			buttonOMI[i].setForeground(buttonOC[i]);
			buttonOMI[i].addActionListener(this);
			buttonO.add(buttonOMI[i]);
			allComps.add(buttonOMI[i]);
		}
		menuBar.add(fontM);
		menuBar.add(fsM);
		menuBar.add(fcM);
		menuBar.add(textB);
		menuBar.add(buttonO);
		allComps.add(fontM);
		allComps.add(fsM);
		allComps.add(fcM);
		allComps.add(textB);
		allComps.add(buttonO);

		resetB = new JButton("Reset");
		resetB.setBorder(new LineBorder(buttonOC[0], 0));
		resetB.addActionListener(this);
		menuBar.add(resetB);
		allComps.add(resetB);

		northB = new JButton("North");
		northB.setBorder(new LineBorder(buttonOC[0], 0));
		northB.addActionListener(this);

		southB = new JButton("South");
		southB.setBorder(new LineBorder(buttonOC[0], 0));
		southB.addActionListener(this);

		eastB = new JButton("East");
		eastB.setBorder(new LineBorder(buttonOC[0], 0));
		eastB.addActionListener(this);

		westB = new JButton("West");
		westB.setBorder(new LineBorder(buttonOC[0], 0));
		westB.addActionListener(this);

		bigPanel  = new JPanel();
		g1BigPanel = new GridLayout(1,2);
		bigPanel.setLayout(g1BigPanel);

		buttonPanel  = new JPanel();
		glButtonPanel = new GridLayout(1,4);
		buttonPanel.setLayout(glButtonPanel);

		buttonPanel.add(northB);
		buttonPanel.add(southB);
		buttonPanel.add(eastB);
		buttonPanel.add(westB);
		allComps.add(northB);
		allComps.add(southB);
		allComps.add(eastB);
		allComps.add(westB);

		textf = new JTextArea("Here");
		textf.setBackground(textBC[0]);
		textf.setForeground(fontC[0]);
		textf.setFont(curFont);

		bigPanel.add(buttonPanel);
		bigPanel.add(menuBar);

		frame.add(bigPanel, BorderLayout.NORTH);
		frame.add(textf, BorderLayout.CENTER);
		for(int j = 0; j < allComps.size(); j++)
			if(fontMI[0]!=allComps.get(j) && fontMI[1]!=allComps.get(j)&&fontMI[2]!=allComps.get(j)&& fsMI[0]!=allComps.get(j) && fsMI[1]!=allComps.get(j)&&fsMI[2]!=allComps.get(j))
				allComps.get(j).setFont(curFont);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == resetB){
			curSize = 13;
			curFont = new Font(fontN[0], fonts[0].getStyle(), curSize);
			textf.setFont(curFont);
			for(int j = 0; j < allComps.size(); j++)
				if(fontMI[0]==allComps.get(j) || fontMI[1]==allComps.get(j) || fontMI[2]==allComps.get(j))
					allComps.get(j).setFont(new Font(allComps.get(j).getFont().getFontName(), Font.PLAIN, curSize));
				else if(fsMI[0]==allComps.get(j) || fsMI[1]==allComps.get(j) || fsMI[2]==allComps.get(j))
					allComps.get(j).setFont(new Font(curFont.getFontName(), Font.PLAIN, Integer.parseInt(((JMenuItem)allComps.get(j)).getText())));
				else
					allComps.get(j).setFont(curFont);


			textf.setForeground(fontC[0]);
			textf.setBackground(textBC[0]);
			for(int j = 0; j < allComps.size(); j++){
				if(fcMI[0]!=allComps.get(j) && fcMI[1]!=allComps.get(j)&&fcMI[2]!=allComps.get(j)&&buttonOMI[0]!=allComps.get(j) && buttonOMI[1]!=allComps.get(j)&&buttonOMI[2]!=allComps.get(j)&&buttonOMI[3]!=allComps.get(j))
					allComps.get(j).setForeground(fontC[0]);
				if(textBMI[0]!=allComps.get(j) && textBMI[1]!=allComps.get(j)&&textBMI[2]!=allComps.get(j) && !(allComps.get(j) instanceof JButton))
					allComps.get(j).setBackground(textBC[0]);
			}
			northB.setBorder(new LineBorder(buttonOC[0], 0));
			southB.setBorder(new LineBorder(buttonOC[0], 0));
			eastB.setBorder(new LineBorder(buttonOC[0], 0));
			westB.setBorder(new LineBorder(buttonOC[0], 0));
			resetB.setBorder(new LineBorder(buttonOC[0], 0));

		}
		else if(e.getSource() == eastB){
			changeLayout(BorderLayout.EAST, 2, 1, 4, 1, 6, 1);
		}
		else if(e.getSource() == westB){
			changeLayout(BorderLayout.WEST, 2, 1, 4, 1, 6, 1);
		}
		else if(e.getSource() == northB){
			changeLayout(BorderLayout.NORTH, 1, 2, 1, 4, 1, 6);
		}
		else if(e.getSource() == southB){
			changeLayout(BorderLayout.SOUTH, 1, 2, 1, 4, 1, 6);
		}
		for(int i = 0; i < fontMI.length; i++){
			if(e.getSource() == fontMI[i]){
				curFont = new Font(fontN[i], fonts[i].getStyle(), curSize);
				textf.setFont(curFont);
				for(int j = 0; j < allComps.size(); j++)
					if(fontMI[0]!=allComps.get(j) && fontMI[1]!=allComps.get(j)&&fontMI[2]!=allComps.get(j))
						if(fsMI[0]!=allComps.get(j) && fsMI[1]!=allComps.get(j) && fsMI[2]!=allComps.get(j))
							allComps.get(j).setFont(curFont);
						else
							allComps.get(j).setFont(new Font(curFont.getFontName(), Font.PLAIN, Integer.parseInt(((JMenuItem)allComps.get(j)).getText())));
			}
		}
		for(int i = 0; i < fsMI.length; i++){
			if(e.getSource() == fsMI[i]){
				curSize = Integer.parseInt(fsMI[i].getText());
				curFont = new Font(curFont.getFontName(), curFont.getStyle(), curSize);
				textf.setFont(curFont);
				for(int j = 0; j < allComps.size(); j++)
					if(fsMI[0]!=allComps.get(j) && fsMI[1]!=allComps.get(j)&&fsMI[2]!=allComps.get(j))
						if(fontMI[0]!=allComps.get(j) && fontMI[1]!=allComps.get(j)&&fontMI[2]!=allComps.get(j))
							allComps.get(j).setFont(curFont);
						else
							allComps.get(j).setFont(new Font(allComps.get(j).getFont().getFontName(), Font.PLAIN, curSize));
			}
		}
		for(int i = 0; i < fcMI.length; i++){
			if(e.getSource() == fcMI[i]){
				textf.setForeground(fontC[i]);
				for(int j = 0; j < allComps.size(); j++)
					if(fcMI[0]!=allComps.get(j) && fcMI[1]!=allComps.get(j)&&fcMI[2]!=allComps.get(j)&&buttonOMI[0]!=allComps.get(j) && buttonOMI[1]!=allComps.get(j)&&buttonOMI[2]!=allComps.get(j)&&buttonOMI[3]!=allComps.get(j))
						allComps.get(j).setForeground(fontC[i]);
			}
		}
		for(int i = 0; i < textBMI.length; i++){
			if(e.getSource() == textBMI[i]){
				textf.setBackground(textBC[i]);
				for(int j = 0; j < allComps.size(); j++)
					if(textBMI[0]!=allComps.get(j) && textBMI[1]!=allComps.get(j)&&textBMI[2]!=allComps.get(j) && !(allComps.get(j) instanceof JButton))
						allComps.get(j).setBackground(textBC[i]);
			}
		}
		for(int i = 0; i < buttonOMI.length; i++){
			if(e.getSource() == buttonOMI[i]){
				int s = 1;
				if(i == 0)
					s = 0;
				northB.setBorder(new LineBorder(buttonOC[i], s));
				southB.setBorder(new LineBorder(buttonOC[i], s));
				eastB.setBorder(new LineBorder(buttonOC[i], s));
				westB.setBorder(new LineBorder(buttonOC[i], s));
				resetB.setBorder(new LineBorder(buttonOC[i], s));

			}
		}

		frame.revalidate();
	}
	public void changeLayout(String code, int... layouts){
		frame.remove(bigPanel);
		bigPanel.remove(buttonPanel);
		bigPanel.remove(menuBar);
		buttonPanel.remove(northB);
		buttonPanel.remove(southB);
		buttonPanel.remove(eastB);
		buttonPanel.remove(westB);
		menuBar.remove(fontM);
		menuBar.remove(fsM);
		menuBar.remove(fcM);
		menuBar.remove(textB);
		menuBar.remove(buttonO);
		menuBar.remove(resetB);

		g1BigPanel = new GridLayout(layouts[0],layouts[1]);
		glButtonPanel = new GridLayout(layouts[2],layouts[3]);
		glMenuBar = new GridLayout(layouts[4],layouts[5]);
		bigPanel.setLayout(g1BigPanel);
		buttonPanel.setLayout(glButtonPanel);
		menuBar.setLayout(glMenuBar);

		buttonPanel.add(northB);
		buttonPanel.add(southB);
		buttonPanel.add(eastB);
		buttonPanel.add(westB);
		menuBar.add(fontM);
		menuBar.add(fsM);
		menuBar.add(fcM);
		menuBar.add(textB);
		menuBar.add(buttonO);
		menuBar.add(resetB);

		bigPanel.add(buttonPanel);
		bigPanel.add(menuBar);
		frame.add(bigPanel, code);
	}
	public static void main(String[] args){
		TextEditor app = new TextEditor();
	}


}