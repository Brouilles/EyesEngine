/*
 * EyesEngine Java de Aubega est mis � disposition selon les termes de la licence 
 * Creative Commons Attribution - Partage dans les M�mes Conditions 4.0 International. 
 * Fond�(e) sur une �uvre � http://www.aubega.com/. Les autorisations au-del� du champ de cette licence 
 * peuvent �tre obtenues � http://www.aubega.com/. 
 * 
 * EyesEngine Java de Aubega est mis � disposition selon les termes de la licence 
 * Creative Commons Attribution - Partage dans les M�mes Conditions 4.0 International. 
 * Fond�(e) sur une �uvre � http://eyesengine.esy.es/doku.php?id=start. 
 * Les autorisations au-del� du champ de cette licence peuvent �tre obtenues � http://eyesengine.esy.es/doku.php?id=start. 
 * 
 * Cette oeuvre, cr�ation, site ou texte est sous licence 
 * Creative Commons  Attribution -  Partage dans les M�mes Conditions 4.0 International. 
 * Pour acc�der � une copie de cette licence, merci de vous rendre � l'adresse suivante 
 * http://creativecommons.org/licenses/by-sa/4.0/deed.fr ou envoyez un courrier � Creative Commons, 
 * 444 Castro Street, Suite 900, Mountain View, California, 94041, USA.
 * 
 * Cette oeuvre, cr�ation, site ou texte est sous licence 
 * Creative Commons  Attribution -  Partage dans les M�mes Conditions 4.0 International.
 * Pour acc�der � une copie de cette licence, merci de vous rendre � l'adresse suivante 
 * http://creativecommons.org/licenses/by-sa/4.0/deed.fr ou envoyez un courrier � Creative Commons,
 * 444 Castro Street, Suite 900, Mountain View, California, 94041, USA.
 */
package GUI;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.UnicodeFont;

import windowing.Window;

import Widget.Button;

public class InGameMenu {
	private Image m_background;
	private UnicodeFont m_font;
	public static int m_choose;
	
	private Button m_startButton = new Button();
	private Button m_quitButton = new Button();
	
	public InGameMenu()
	{
		m_startButton.setPos(267, 200);
		m_startButton.text("Menu principal", 180, 10);
		
		m_quitButton.setPos(267, 260);
		m_quitButton.text("Quit", 210, 10);
	}
	
	public void loadTexture(SpriteSheet button)
	{
		m_startButton.loadTexture(button);
		m_quitButton.loadTexture(button);
		
		try {
			m_background = new Image("picture/background/inGameBackground.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadFont(UnicodeFont font)
	{
		m_font = font;
		
		m_startButton.loadFont(m_font);
		m_quitButton.loadFont(m_font);
	}
	
	public void draw()
	{
		m_background.draw();
		
		m_startButton.draw();
		m_quitButton.draw();

		 //Enter Press
		if(m_startButton.draw() && Window.leftClick)
		{
			Window.m_inMainMenu = true;
			Window.m_inGameMainMenu = false;
		}
		else if(m_quitButton.draw() && Window.leftClick)
		{
			System.exit(0);
		}
	}
}
