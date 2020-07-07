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
package windowing;

import gameplay.EntityPlayer;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

import render.Map;
import render.Scroll;

import GUI.BackgroundAnim;
import GUI.HUD;
import GUI.InGameMenu;
import GUI.MainMenu;

public class Window{
	public static boolean enter;
	public static int mouseX;
	public static int mouseY;
	public static boolean leftClick;
	public static boolean spaceEnter;
	
	private BackgroundAnim m_backgroundMenu = new BackgroundAnim();
	private MainMenu m_mainMenu = new MainMenu();
	private InGameMenu m_inGameMenu = new InGameMenu();
	
	public static boolean m_debugMode;
	public static boolean m_inMainMenu;
	public static boolean m_inCampaignMenu;
	public static boolean m_inGameMainMenu;
	
	private UnicodeFont m_font;
	
	private EntityPlayer m_player = new EntityPlayer();
	private HUD m_hud = new HUD(m_player.getLife());
	private Scroll m_scroll = new Scroll();
	
	public void initGL(int height, int width) {
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	 	
		GL11.glEnable(GL11.GL_BLEND);
    	GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
    	
		GL11.glViewport(0,0, width, height);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, width, height, 0, -1, 1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}
	
	public void gameLoop() {
		m_inMainMenu = true;
		m_inGameMainMenu = false;
		m_debugMode = true;
		
		loadResource();
		Map levels = new Map("levels/test/level.tmx");
		
		while(!Display.isCloseRequested()) {
			//Input
			pcInput();
			deallocate();
			
			//OpenGl render
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			GL11.glLoadIdentity();
			
			GL11.glPushMatrix();
			if(m_inMainMenu)
			{
				m_backgroundMenu.draw();
				m_mainMenu.draw();
			}
			else
			{
				GL11.glScaled(4.0, 4.0, 4.0); // Rangradissement
				
				m_scroll.reload(m_player.getPosX(), m_player.getPosY(), levels.getHeight(), levels.getWidth());
				m_scroll.draw();
				
				levels.draw();
				if(levels.mapCollision(m_player.getPosX(), m_player.getPosY()))
					m_player.setPos(m_player.getPosAfterX(), m_player.getPosAfterY());
				m_player.show();
				levels.drawTop();
				
				GL11.glPopMatrix();
				GL11.glPushMatrix();
				m_hud.reload(m_player.getLife());
				m_hud.draw();
				
				if(m_inGameMainMenu)
				{
					GL11.glPopMatrix();
					m_inGameMenu.draw();
				}
			}
			
			if(m_debugMode == true)
			{
				GL11.glPopMatrix();
				m_font.drawString(0, 26, "OpenGL version: "+GL11.glGetString(GL11.GL_VERSION));
				m_font.drawString(0, 42, "Mouse X:"+mouseX);
				m_font.drawString(0, 62, "Mouse Y:"+mouseY);
			}
			
			Display.update();
			Display.sync(60);
		}
	}
		
	/*
	 * Input
	 */
	public void pcInput() // FOR PC Keyboard and Mouse
	{	
		/*
		 * Mouse
		 */
		enter = false;
		spaceEnter = false;
		mouseX = Mouse.getX();
		mouseY = Display.getHeight() - Mouse.getY();
		
		leftClick = Mouse.isButtonDown(0); 
		
		/*
		 * Keyboard
		 */
		//KEY DOWN
		if(Keyboard.isKeyDown(Keyboard.KEY_Z)) //UP
		{
			if(m_inMainMenu)
			{
				
			}
			else
			{
				if(Keyboard.isKeyDown(Keyboard.KEY_D))
				{
					m_player.moveUpRight();
					m_player.gun.moveUpRight();
				}
				else if(Keyboard.isKeyDown(Keyboard.KEY_Q))
				{
					m_player.moveUpLeft();
					m_player.gun.moveUpLeft();
				}
				else
				{
					m_player.moveUp();
					m_player.gun.moveUp();
				}
			}
		}
		else if (Keyboard.isKeyDown(Keyboard.KEY_S)) //Down
		{
			if(m_inMainMenu)
			{
				
			}
			else
			{
				if(Keyboard.isKeyDown(Keyboard.KEY_Q))
				{
					m_player.moveDownLeft();
					m_player.gun.moveDownLeft();
				}
				else if(Keyboard.isKeyDown(Keyboard.KEY_D))
				{
					m_player.moveDownRight();
					m_player.gun.moveDownRight();
				}
				else
				{
					m_player.moveDown();
					m_player.gun.moveDown();
				}
			}
		}
		else if (Keyboard.isKeyDown(Keyboard.KEY_Q)) 
		{
			m_player.moveLeft();
			m_player.gun.moveLeft();
		}
		else if (Keyboard.isKeyDown(Keyboard.KEY_D)) 
		{
			m_player.moveRight();
			m_player.gun.moveRight();
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_A)) 
		{
			m_player.hurt(m_player.getLife() - 1);
		}
		
		while (Keyboard.next()) 
		{
		    if (Keyboard.getEventKeyState()) //Pressed
		    {
		    	if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) 
				{
		    		spaceEnter = true;
				}
		    	
		    	if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE) && m_inMainMenu == false) 
				{
		    		if(m_inGameMainMenu)
		    			m_inGameMainMenu = false;
		    		else
		    			m_inGameMainMenu = true;
				}
		    	
		    	if (Keyboard.isKeyDown(Keyboard.KEY_F1)) 
				{
		    		if(m_debugMode)
		    			m_debugMode = false;
		    		else
		    			m_debugMode = true;
				}
		    } 
		}
	}
	
	@SuppressWarnings("unchecked")
	public void loadResource()
	{
		m_player.addTexture("picture/character/herr_von_speck_sheet.png");
		m_player.addGunTexture();
		m_hud.loadTexture();
		
		try { //GUI texture
			SpriteSheet button = new SpriteSheet("picture/widget/button.png",466, 37);
			m_mainMenu.loadTexture(button);
			m_inGameMenu.loadTexture(button);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try { //Font Texture
			m_font = new UnicodeFont("fonts/BASKVILL.TTF", 20, false, false);
			m_font.addAsciiGlyphs();
			m_font.getEffects().add(new ColorEffect()); 
			m_font.loadGlyphs();
			
			m_mainMenu.loadFont(m_font);
			m_inGameMenu.loadFont(m_font);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deallocate()
	{
		if(m_inMainMenu && m_backgroundMenu.getLoad() == false) //Load background
		{
			m_backgroundMenu.loadTexture();
		}
		else if(m_backgroundMenu.getLoad() == true && m_inMainMenu == false)
		{
			m_backgroundMenu.deallocateTexture();
		}
	}
}
