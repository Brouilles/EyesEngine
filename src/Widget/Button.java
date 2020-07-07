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
package Widget;

import math.Collision;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.UnicodeFont;

import windowing.Window;

public class Button {
	protected int m_x, m_y;
	protected Collision m_collision = new Collision();
	protected SpriteSheet m_texture;
	
	protected UnicodeFont m_font;
	protected int m_fontX, m_fontY;
	protected String m_text;
	
	public Button()
	{
		m_x = 0;
		m_y = 0;
	}
	
	public Button(SpriteSheet texture, String text)
	{
		m_texture = texture;
		m_text = text;
		
		m_x = 0;
		m_y = 0;
	}
	
	public Button(SpriteSheet texture, String text, int x, int y)
	{
		m_texture = texture;
		m_text = text;
		
		m_x = x;
		m_y = y;
	}
	
	public void loadTexture(SpriteSheet texture)
	{
		m_texture = texture;
	}
	
	public void deallocateTexture()
	{
		try {
			m_texture.destroy();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadFont(UnicodeFont font)
	{
		m_font = font;
	}
	
	public void text(String text, int x, int y)
	{
		m_text = text;
		
		m_fontX = m_x+x;
		m_fontY = m_y+y;
	}
	
	public boolean draw()
	{
		if(m_collision.calculate(Window.mouseX, Window.mouseY, 1, 1, m_x, m_y, m_texture.getHeight()/2, m_texture.getWidth()))
		{
			m_texture.getSprite(0, 1).draw(m_x, m_y);
			m_font.drawString(m_fontX, m_fontY, m_text);
			return true;
		}
		else
		{
			m_texture.getSprite(0, 0).draw(m_x, m_y);
			m_font.drawString(m_fontX, m_fontY, m_text);
		}
		return false;
	}
	
	public void setPosY(int y)
	{
		m_x = y;
	}

	public void setPosX(int x)
	{
		m_x = x;
	}
	
	public void setPos(int x, int y)
	{
		m_x = x;
		m_y = y;
	}
	
	public double getPosX()
	{
		return  m_x;
	}

	public double getPosY()
	{
		return m_y;
	}
}
