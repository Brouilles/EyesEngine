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

public class BackgroundAnim {
	private Image m_background;
	private boolean m_load = false;
	
	public void loadTexture()
	{	
		try {
			m_background = new Image("picture/background/menuBackground.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m_load = true;
		System.out.println("Chargement");
	}
	
	public void deallocateTexture()
	{	
		try {
			m_background.destroy();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m_load = false;
		System.out.println("deChargement");
	}
	
	public void draw()
	{
		m_background.draw();
	}
	
	public boolean getLoad()
	{
		return m_load;
	}
}
