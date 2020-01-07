/* choose foreground color */

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


public class ColorsChooser extends JColorChooser
{
  Color currentColor;
  JPanel panel;
  public ColorsChooser ()
  {
    super ();
    panel=new JPanel();
    //super.setPreviewPanel(panel);    
  }

  public Color showDialog (Component c, String title)
  {
    Color selected;
    //super.setColor(getCurrentColor());
    
    //setPreviewPanel(panel);
  //  remove(1);
  //  removeChooserPanel(getChooserPanels()[2]);
   // removeChooserPanel(getChooserPanels()[1]);
    selected=super.showDialog (null, title ,currentColor);
    return (selected);
  }
  public void setCurrentColor(Color c)
  {
    currentColor= c;
  }
  public Color getCurrentColor()
  {
    return currentColor; 
  }
  
  				     
}				// end class ColorsChooser
