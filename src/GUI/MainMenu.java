/*
 * EyesEngine Java de Aubega est mis à disposition selon les termes de la licence 
 * Creative Commons Attribution - Partage dans les Mêmes Conditions 4.0 International. 
 * Fondé(e) sur une œuvre à http://www.aubega.com/. Les autorisations au-delà du champ de cette licence 
 * peuvent être obtenues à http://www.aubega.com/. 
 * 
 * EyesEngine Java de Aubega est mis à disposition selon les termes de la licence 
 * Creative Commons Attribution - Partage dans les Mêmes Conditions 4.0 International. 
 * Fondé(e) sur une œuvre à http://eyesengine.esy.es/doku.php?id=start. 
 * Les autorisations au-delà du champ de cette licence peuvent être obtenues à http://eyesengine.esy.es/doku.php?id=start. 
 * 
 * Cette oeuvre, création, site ou texte est sous licence 
 * Creative Commons  Attribution -  Partage dans les Mêmes Conditions 4.0 International. 
 * Pour accéder à une copie de cette licence, merci de vous rendre à l'adresse suivante 
 * http://creativecommons.org/licenses/by-sa/4.0/deed.fr ou envoyez un courrier à Creative Commons, 
 * 444 Castro Street, Suite 900, Mountain View, California, 94041, USA.
 * 
 * Cette oeuvre, création, site ou texte est sous licence 
 * Creative Commons  Attribution -  Partage dans les Mêmes Conditions 4.0 International.
 * Pour accéder à une copie de cette licence, merci de vous rendre à l'adresse suivante 
 * http://creativecommons.org/licenses/by-sa/4.0/deed.fr ou envoyez un courrier à Creative Commons,
 * 444 Castro Street, Suite 900, Mountain View, California, 94041, USA.
 */
package GUI;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.UnicodeFont;

import windowing.Window;

import Widget.Button;

public class MainMenu {
	private Image m_aubega;
	private Image m_eyesengine;
	
	private Button m_startButton = new Button();
	private Button m_optionButton = new Button();
	private Button m_quitButton = new Button();
	
	public MainMenu()
	{
		m_startButton.setPos(267, 300);
		m_startButton.text("Campaign", 190, 10);
		
		m_optionButton.setPos(267, 360);
		m_optionButton.text("Option", 200, 10);
		
		m_quitButton.setPos(267, 420);
		m_quitButton.text("Quit", 210, 10);
	}
	
	public void loadTexture(SpriteSheet button)
	{
		m_startButton.loadTexture(button);
		m_quitButton.loadTexture(button);
		m_optionButton.loadTexture(button);
		
		try {
			m_aubega = new Image("picture/background/aubega.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			m_eyesengine = new Image("picture/background/eyesengine.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadFont(UnicodeFont font)
	{
		m_startButton.loadFont(font);
		m_optionButton.loadFont(font);
		m_quitButton.loadFont(font);
	}
	
	public void draw()
	{
		m_aubega.draw(20, 740);
		m_eyesengine.draw(150, 740);
		
		m_startButton.draw();
		m_optionButton.draw();
		m_quitButton.draw();

		 //Enter Press
		if(m_startButton.draw() && Window.leftClick)
		{
			Window.m_inMainMenu = false;
			Window.m_inCampaignMenu = true;
		}
		else if(m_quitButton.draw() && Window.leftClick)
		{
			System.exit(0);
		}
	}
}
