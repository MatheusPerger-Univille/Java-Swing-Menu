package br.com.univille.poo.application;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setTitle("Conversor Universal");
		frame.setSize(600,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Layout ly = new Layout(frame);
		frame = ly.setandoLayout();
				
		frame.show();

	}

}

