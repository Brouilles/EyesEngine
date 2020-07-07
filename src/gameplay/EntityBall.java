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
package gameplay;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class EntityBall {
	protected float m_ballX, m_ballY;
	protected int m_damage;
	protected SpriteSheet m_ballSheet;
	protected Image[] m_ballTexture = new Image[8];
	
	public  EntityBall(int damage)
	{
		m_damage = damage;
	}
	
	public void ballShoot(float m_x, float m_y)
	{
		m_ballX = m_x;
		m_ballY = m_y;
	}
	
	public void draw(int m_look)
	{
		if(m_look == 0)
			m_ballTexture[0].draw(m_ballX, m_ballY);
	}
	
	public void addBallTexture(String texturPos)
	{
		try {
			m_ballSheet = new SpriteSheet(texturPos, 16, 16);
			
			int x = 0;		
			for(int loop = 0; loop < 7; loop++)
			{
				m_ballTexture[loop] = m_ballSheet.getSprite(x, 0);
				x++;
			}
			m_ballTexture[7] = m_ballSheet.getSprite(7, 0);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
