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
