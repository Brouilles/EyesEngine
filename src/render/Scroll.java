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
package render;

import org.lwjgl.opengl.GL11;

public class Scroll {
	private double m_x, m_y;
	
	public void reload(double x, double y, int mapHeight, int mapWidth)
	{
		m_x = x;
		m_y = y;
	}
	
	public void draw()
	{
		if(m_x-110 <= 0 && m_y-80 <=0)
			GL11.glTranslated(0, 0, 0);
		/*else if(m_x-110 <= 0 && m_y+110 >= m_mapHeight)
			GL11.glTranslated(0, m_mapHeight-80, 0);*/
		else if(m_x-110 <= 0)
			GL11.glTranslated(0, 80-m_y, 0);
		else if(m_y-80 <=0)
			GL11.glTranslated(110-m_x, 0, 0);
		else
			GL11.glTranslated(110-m_x, 80-m_y, 0);
	}
}
