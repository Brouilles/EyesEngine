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

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SpriteSheet;

public class Entity {
	protected float m_moveSpeed;	
	protected float m_x, m_y;
	protected float m_after_x, m_after_y;
	protected int m_look; //several value: 0 = Down / 6 = down left / 12 = right / 18 = up left /24 = top / 30 = top right / 36 = left / 42 = down right
	
	protected SpriteSheet m_sheet;
	protected Image[] m_playerTexture = new Image[48];
	
	protected Animation m_leftAnimation = new Animation();
	protected Animation m_rightAnimation = new Animation();
	protected Animation m_topAnimation = new Animation();
	protected Animation m_downAnimation = new Animation();
	
	protected Animation m_topLeftDiagonalAnimation = new Animation();
	protected Animation m_topRightDiagonalAnimation = new Animation();
	protected Animation m_bottomLeftDiagonalAnimation = new Animation();
	protected Animation m_bottomRightDiagonalAnimation = new Animation();
	
	boolean m_left = false;
	boolean m_right = false;
	boolean m_top = false;
	boolean m_down = false;
	
	boolean m_topRight = false;
	boolean m_topLeft = false;
	boolean m_bottomLeft = false;
	boolean m_bottomRight = false;
	
	protected int m_life;
	
	protected Sound m_entityHurt;
	protected Sound m_entityDead;
	
	public Entity()
	{ m_look = 0;}
	
	public void draw()
	{
		m_after_x = m_x;
		m_after_y = m_y;

		entityLook();
	}
	
	public void entityLook()
	{
		if(m_down)
		{
			m_downAnimation.draw(m_x, m_y);
			m_down = false;
			m_look = 0;
		}
		else if(m_left)
		{
			m_leftAnimation.draw(m_x, m_y);
			m_left = false;
			m_look = 12;
		}
		else if(m_right)
		{
			m_rightAnimation.draw(m_x, m_y);
			m_right = false;
			m_look = 36;
		}
		else if(m_top)
		{
			m_topAnimation.draw(m_x, m_y);	
			m_top = false;
			m_look = 24;
		}
		else if(m_topRight)
		{
			m_topRightDiagonalAnimation.draw(m_x, m_y);	
			m_topRight = false;
			m_look = 30;
		}
		else if(m_topLeft)
		{
			m_topLeftDiagonalAnimation.draw(m_x, m_y);	
			m_topLeft = false;
			m_look = 18;
		}
		else if(m_bottomLeft)
		{
			m_bottomLeftDiagonalAnimation.draw(m_x, m_y);	
			m_bottomLeft = false;
			m_look = 6;
		}
		else if(m_bottomRight)
		{
			m_bottomRightDiagonalAnimation.draw(m_x, m_y);	
			m_bottomRight = false;
			m_look = 42;
		}
		else
			m_playerTexture[m_look].draw(m_x, m_y);
	}
	
	public void addTexture(String texturPos)
	{
		try {
			m_sheet = new SpriteSheet(texturPos, 32, 32);
			
			int x = 0;
			int y = 0;
			
			for(int loop = 0; loop < 47; loop++)
			{
				if(x == 6 && y < 8)
				{
					x = 0;
					y++;
				}
				m_playerTexture[loop] = m_sheet.getSprite(x, y);
				x++;
			}
			m_playerTexture[47] = m_sheet.getSprite(5, 7);
			
			m_downAnimation.setAutoUpdate(true);				 /*  DOWN */
			m_downAnimation.addFrame(m_playerTexture[0], 230);
			m_downAnimation.addFrame(m_playerTexture[1], 230);
			m_downAnimation.addFrame(m_playerTexture[2], 230);
			m_downAnimation.addFrame(m_playerTexture[3], 230);
			m_downAnimation.addFrame(m_playerTexture[4], 230);
			m_downAnimation.addFrame(m_playerTexture[5], 230);
			
			m_leftAnimation.setAutoUpdate(true);				/*   LEFT  */
			m_leftAnimation.addFrame(m_playerTexture[12], 230);
			m_leftAnimation.addFrame(m_playerTexture[13], 230);
			m_leftAnimation.addFrame(m_playerTexture[14], 230);
			m_leftAnimation.addFrame(m_playerTexture[15], 230);
			m_leftAnimation.addFrame(m_playerTexture[16], 230);
			m_leftAnimation.addFrame(m_playerTexture[17], 230);
			
			m_rightAnimation.setAutoUpdate(true);				/*   RIGHT */
			m_rightAnimation.addFrame(m_playerTexture[36], 230);
			m_rightAnimation.addFrame(m_playerTexture[37], 230);
			m_rightAnimation.addFrame(m_playerTexture[38], 230);
			m_rightAnimation.addFrame(m_playerTexture[39], 230);
			m_rightAnimation.addFrame(m_playerTexture[40], 230);
			m_rightAnimation.addFrame(m_playerTexture[41], 230);
			
			m_topAnimation.setAutoUpdate(true);					/*   TOP  */
			m_topAnimation.addFrame(m_playerTexture[24], 230);
			m_topAnimation.addFrame(m_playerTexture[25], 230);
			m_topAnimation.addFrame(m_playerTexture[26], 230);
			m_topAnimation.addFrame(m_playerTexture[27], 230);
			m_topAnimation.addFrame(m_playerTexture[28], 230);
			m_topAnimation.addFrame(m_playerTexture[29], 230);
			
			m_topRightDiagonalAnimation.setAutoUpdate(true);  	/*   TOP-RIGHT */
			m_topRightDiagonalAnimation.addFrame(m_playerTexture[30], 230);
			m_topRightDiagonalAnimation.addFrame(m_playerTexture[31], 230);
			m_topRightDiagonalAnimation.addFrame(m_playerTexture[32], 230);
			m_topRightDiagonalAnimation.addFrame(m_playerTexture[33], 230);
			m_topRightDiagonalAnimation.addFrame(m_playerTexture[34], 230);
			m_topRightDiagonalAnimation.addFrame(m_playerTexture[35], 230);
			
			m_topLeftDiagonalAnimation.setAutoUpdate(true);  	/*   TOP-LEFT */
			m_topLeftDiagonalAnimation.addFrame(m_playerTexture[18], 230);
			m_topLeftDiagonalAnimation.addFrame(m_playerTexture[19], 230);
			m_topLeftDiagonalAnimation.addFrame(m_playerTexture[20], 230);
			m_topLeftDiagonalAnimation.addFrame(m_playerTexture[21], 230);
			m_topLeftDiagonalAnimation.addFrame(m_playerTexture[22], 230);
			m_topLeftDiagonalAnimation.addFrame(m_playerTexture[23], 230);
			
			m_bottomLeftDiagonalAnimation.setAutoUpdate(true);  	/*   BOTTOM-LEFT */
			m_bottomLeftDiagonalAnimation.addFrame(m_playerTexture[6], 230);
			m_bottomLeftDiagonalAnimation.addFrame(m_playerTexture[7], 230);
			m_bottomLeftDiagonalAnimation.addFrame(m_playerTexture[8], 230);
			m_bottomLeftDiagonalAnimation.addFrame(m_playerTexture[9], 230);
			m_bottomLeftDiagonalAnimation.addFrame(m_playerTexture[10], 230);
			m_bottomLeftDiagonalAnimation.addFrame(m_playerTexture[11], 230);
						
			m_bottomRightDiagonalAnimation.setAutoUpdate(true);  	/*   BOTTOM-RIGHT */
			m_bottomRightDiagonalAnimation.addFrame(m_playerTexture[42], 230);
			m_bottomRightDiagonalAnimation.addFrame(m_playerTexture[43], 230);
			m_bottomRightDiagonalAnimation.addFrame(m_playerTexture[44], 230);
			m_bottomRightDiagonalAnimation.addFrame(m_playerTexture[45], 230);
			m_bottomRightDiagonalAnimation.addFrame(m_playerTexture[46], 230);
			m_bottomRightDiagonalAnimation.addFrame(m_playerTexture[47], 230);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void hurt(int life)
	{
		m_life = life;
		m_entityHurt.play();
	}
	
	public void moveUp()
	{
		m_top = true;
		m_y = m_y - m_moveSpeed;
	}
	
	public void moveUpRight()
	{
		m_topRight = true;
		m_y = m_y - m_moveSpeed/2;
		m_x = m_x + m_moveSpeed/2;
	}
	
	public void moveUpLeft()
	{
		m_topLeft = true;
		m_y = m_y - m_moveSpeed/2;
		m_x = m_x - m_moveSpeed/2;
	}
	
	public void moveDown()
	{
		m_down = true;
		m_y = m_y + m_moveSpeed;
		//m_down = false;
	}
	
	public void moveDownLeft()
	{
		m_bottomLeft = true;
		m_y = m_y + m_moveSpeed/2;
		m_x = m_x - m_moveSpeed/2;
	}
	
	public void moveDownRight()
	{
		m_bottomRight = true;
		m_y = m_y + m_moveSpeed/2;
		m_x = m_x + m_moveSpeed/2;
	}
	
	public void moveLeft()
	{
		m_left = true;
		m_x = m_x - m_moveSpeed;
	}
	
	public void moveRight()
	{
		m_right = true;
		m_x = m_x + m_moveSpeed;
	}
	
	public void setPosX(double x)
	{
		m_x = (float) x;
	}

	public void setPosY(double y)
	{
		m_x = (float) y;
	}

	public void setPos(double x, double y)
	{
		m_x = (float) x;
		m_y = (float) y;
	}

	public void setLife(int life)
	{
		m_life = life;
	}
	
	public void setLook(int look)
	{
		m_look = look;
	}
	
	public double getPosX()
	{
		return  m_x;
	}

	public double getPosY()
	{
		return m_y;
	}
	
	public double getPosAfterX()
	{
		return  m_after_x;
	}

	public double getPosAfterY()
	{
		return m_after_y;
	}
	
	public int getLife()
	{
		return m_life;
	}
	
	public int getLook()
	{
		return m_look;
	}
}
