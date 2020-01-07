/* creates frame in full screen */

package powd;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.image.*;
import java.lang.Object.*;

import javax.imageio.*;

import java.io.File;


import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Painter extends JFrame
{


  final static BasicStroke wideStroke = new BasicStroke (8.0f);

  private JLayeredPane layers;

  private CanvasPanel canvasPanel;

  private ToolsPanel toolsPanel;

  private Container mainContainer;
  

  // To get Full screen windows 
  static GraphicsDevice grafica =
    GraphicsEnvironment.
    getLocalGraphicsEnvironment().getDefaultScreenDevice();

  public Painter ()
  {
    super ("Paint on Whiteboard Desktop");


    layers = new JLayeredPane ();

    canvasPanel = new CanvasPanel ();
    
    InputStream is = null;
     
                      
    int monitor= canvasPanel.getMonitorIndex();
     
    try
     {
       grafica = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[monitor];
     }
    catch(MissingResourceException ex)
     {
       grafica = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
     }

    // set canvas panel dimensions 
      canvasPanel.setBounds (0, 0, grafica.getDisplayMode().getWidth(), grafica.getDisplayMode().getHeight());

      canvasPanel.captureImageBackground(grafica);	// take snapshow for Desktop
      canvasPanel.loadBackground();  // load  background from propieties object
      
    // add canvasPane to layer 1
      layers.add (canvasPanel, new Integer (1));

    // create Tool Panel
      ToolsPanel.grafica = grafica;
      toolsPanel = new ToolsPanel (canvasPanel, this);
      toolsPanel.setBounds (0, 100, 30, 370);


      layers.add (toolsPanel, new Integer (2));

      mainContainer = getContentPane ();
      mainContainer.add (layers, BorderLayout.CENTER);
      setUndecorated (true);

      setVisible (true);

    // start full screen mode
      grafica.setFullScreenWindow(this);


    // Mode Draw
      canvasPanel.setDrawMode (canvasPanel.FREE_HAND);

  }

}				// end class Painter
