package pl.edu.uksw.si.se.edytafraszczak;

import javax.swing.*;

public class GuiNarzedzia {
	public static boolean pokazDialogTrueFalse(String wiadomosc) {
		Object[] opcje = { "Tak", "Nie" };
		int answer = JOptionPane.showOptionDialog(null, wiadomosc, "Pytanie systemu eksperckiego",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, // do not use a custom Icon
				opcje, 
				opcje[0]);
		if (answer == JOptionPane.YES_OPTION) {
			return true;
		} else if (answer == JOptionPane.NO_OPTION) {
			return false;
		}

		throw new RuntimeException("User skonczyl prace");
	}

	public static void pokazDialog(String message) {
		JOptionPane.showMessageDialog(null, message, "Wiadomość z Systemu Ekspreckiego",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
