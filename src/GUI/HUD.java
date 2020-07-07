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

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class HUD {
	protected SpriteSheet m_sheet;
	protected Image[] m_lifeTexture = new Image[6];
	
	protected int m_x;
	protected int m_y;
	protected int m_originalPlayerLife;
	
	protected int m_playerLife;
	
	public HUD(int playerLife)
	{
		m_y = 6;
		m_originalPlayerLife = playerLife;
	}
	
	public void reload(int playerLife)
	{
		m_playerLife = playerLife;
	}
	
	public void draw()
	{
		GL11.glScaled(2.0, 2.0, 2.0);
		
		//gray life
		m_x = 6;
		m_lifeTexture[3].draw(m_x, m_y);	
		for(int loop = 0; loop < m_originalPlayerLife; loop++)
		{
			m_x++;
			m_lifeTexture[4].draw(m_x, m_y);
		}
		m_lifeTexture[5].draw(m_x+1, m_y);
		
		//Red life
		m_x = 6;	
		m_lifeTexture[0].draw(m_x, m_y);	
		for(int loop = 0; loop < m_playerLife; loop++)
		{
			m_x++;
			m_lifeTexture[1].draw(m_x, m_y);
		}
		m_lifeTexture[2].draw(m_x+1, m_y);
	}
	
	public void loadTexture()
	{
		try {
				m_sheet = new SpriteSheet("picture/HUD/life2.png", 1, 6);

				int x = 0;	
				for(int loop = 0; loop < 5; loop++)
				{
					m_lifeTexture[loop] = m_sheet.getSprite(x, 0);
					x++;
				}
				m_lifeTexture[5] = m_sheet.getSprite(x, 0);
			}catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
