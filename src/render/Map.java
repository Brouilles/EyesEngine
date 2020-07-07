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
package render;

import math.Collision;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import windowing.Window;

public class Map {
	private TiledMap m_map;
	private int m_cloud;
	
	public Map(String mapPos)
	{
		m_cloud = 0;
		try {
			m_map = new TiledMap(mapPos);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void draw()
	{
		m_map.render(0, 0, 0);
		
		if(Window.m_debugMode)
			m_map.render(0, 0, 1);
		
		m_map.render(0, 0, 2);
	}
	
	public void drawTop()
	{

		m_map.render(0, 0, 3);
		m_map.render(0, 0, 4);
		m_map.render(0, 0, 5);
		
		if(m_cloud > getHeight())
		{
			m_cloud = -getHeight();
		}
		m_map.render(m_cloud, 0, 6); // Cloud
		m_cloud++;
	}
	
	public boolean mapCollision(double PlayerX, double PlayerY)
	{
		Collision collision = new Collision();
		for (int xAxis=0;xAxis<m_map.getWidth(); xAxis++)
		{
		             for (int yAxis=0;yAxis<m_map.getHeight(); yAxis++)
		             {
		                 int tileID = m_map.getTileId(xAxis, yAxis, 1);
		                 String value = m_map.getTileProperty(tileID, "blocked", "false");
		                 if ("true".equals(value))
		                 {
		                	if(collision.calculate(PlayerX, PlayerY, 32, 32, xAxis*m_map.getTileHeight(), yAxis*m_map.getTileWidth(), m_map.getTileHeight()/2, m_map.getTileWidth()))
		                	{
		                		return true;
		                	}
		                 }
		             }
		 }
		
		return false;
	}
	
	public int getHeight()
	{
		return  m_map.getHeight()*m_map.getTileHeight();
	}

	public int getWidth()
	{
		return m_map.getWidth()*m_map.getTileHeight();
	}
	
	public int getTileHeight()
	{
		return  m_map.getTileHeight();
	}
}
