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
package windowing;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class WindowDesktop extends Window{
	
	public void start() {
		try {
			Display.setDisplayMode(new DisplayMode(1000,800));
			Display.setFullscreen(false);
			Display.setTitle("EyesEngine Alpha 0.2 | Client v.RPG");
			Display.create();
		} catch(LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		//OpenGl Init
		initGL(Display.getHeight(), Display.getWidth());

		gameLoop();
		Display.destroy();
	}
}
