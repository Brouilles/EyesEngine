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
package math;

public class Collision {
	
	public boolean calculate(double EntityX, double EntityY, double EntityHeight, double EntityWidth, double BoxX, double BoxY, double BoxHeight, double BoxWidth)
	{
		if(EntityY < BoxY + BoxHeight && EntityY + EntityHeight > BoxY && EntityX < BoxX + BoxWidth && EntityX > BoxX - BoxWidth)
			return true; 
		else
			return false;
	}

	public boolean calculate(int EntityX, int EntityY, int EntityHeight, int EntityWidth, int BoxX, int BoxY, int BoxHeight, int BoxWidth) 
	{
		if(EntityY < BoxY + BoxHeight && EntityY + EntityHeight > BoxY && EntityX < BoxX + BoxWidth && EntityX > BoxX)
			return true; 
		else
			return false;
	}
}
