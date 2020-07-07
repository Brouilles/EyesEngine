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
