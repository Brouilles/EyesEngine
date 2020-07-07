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

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import windowing.Window;

public class EntityPlayer extends Entity{
	public EntityGun gun = new EntityGun();
	public EntityPlayer()
	{
		m_moveSpeed = 0.98f;
		m_life = 100;
		
		try {
			m_entityHurt = new Sound("SFX/hurt.wav");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		m_x = 10.0f;
		m_y = 10.0f;
	}
	
	public void show()
	{
		draw();
		gun.setLook(getLook());
		gun.setPos(m_x, m_y);
		gun.draw();
		
		if(Window.spaceEnter)
			gun.shoot();
	}
	
	public void addGunTexture()
	{
		gun.addTexture("picture/character/gun/gun.png");
		gun.addBallTexture("picture/character/gun/bullet.png");
	}
}
