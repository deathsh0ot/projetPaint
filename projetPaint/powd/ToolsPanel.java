package powd;

import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;
import javax.swing.*;

import javax.imageio.*;
import java.awt.image.*;
import java.lang.Object.*;

import java.io.File;

import java.io.*;
import java.awt.geom.*;
import java.lang.Object.*;

import javax.imageio.*;


public class ToolsPanel extends JPanel
{
  private JButton lineBtn, transparentBtn, quitBtn, saveScreenBtn, arrowBtn,
    freeHandBtn, colorBtn, strokeBtn, clearBtn, configBtn;
  private JCheckBox fullChk;
  private JSlider alphaSlider, strokeSlider;
  private ColorsChooser colorsChooser;
  private CanvasPanel canvasPanel;
  ConfigFrame configFrame;
  
  Color color;
 
  String pathIconos = "icons/";
  private JFrame pframe;
  /*hhhhhh*/

  static GraphicsDevice grafica =
    GraphicsEnvironment.getLocalGraphicsEnvironment ().
    getDefaultScreenDevice ();


  public ToolsPanel (CanvasPanel inCanvasPanel, JFrame pf)
  {
    pframe = pf;
    canvasPanel = inCanvasPanel;
    
    configFrame=new ConfigFrame(canvasPanel, pframe);
	  
    lineBtn =new JButton ("", new ImageIcon (pathIconos + "line_normal_begin.png"));
    lineBtn.setBackground(Color.PINK);
    transparentBtn =new JButton ("", new ImageIcon (pathIconos + "14_rectangle.png"));
    transparentBtn.setBackground(Color.MAGENTA);
    quitBtn = new JButton ("", new ImageIcon (pathIconos + "exit22.png"));
    quitBtn.setBackground(Color.GRAY);
    saveScreenBtn = new JButton ("", new ImageIcon (pathIconos + "camera21.png"));
    saveScreenBtn.setBackground(Color.GRAY);
    arrowBtn = new JButton ("", new ImageIcon (pathIconos + "arrow21.png"));
    arrowBtn.setBackground(Color.GRAY);
    freeHandBtn =new JButton ("", new ImageIcon (pathIconos + "pencil191.png"));
    freeHandBtn.setBackground(Color.PINK);
    colorBtn =new JButton ("", new ImageIcon (pathIconos +"art-brush-color-drawing22.png"));
    colorBtn.setBackground(Color.GRAY);
    strokeBtn = new JButton ("", new ImageIcon (pathIconos + "stroke22.png"));
    clearBtn = new JButton ("", new ImageIcon (pathIconos + "Neweraser.png"));
    clearBtn.setBackground(Color.PINK);

    configBtn = new JButton ("", new ImageIcon (pathIconos + "cog2.png"));
    configBtn.setBackground(Color.PINK);


    lineBtn.addActionListener (new ToolButtonListener ());
    //lineBtn.setToolTipText ("Line");
    lineBtn.setText("Line");

    
    transparentBtn.addActionListener (new ToolButtonListener ());
   // transparentBtn.setToolTipText ("Move");
    transparentBtn.setText("Move");
    
    quitBtn.addActionListener (new ToolButtonListener ());
   // quitBtn.setToolTipText ("Quit");
    quitBtn.setText("Quit");
    
    saveScreenBtn.addActionListener (new ToolButtonListener ());
   // saveScreenBtn.setToolTipText ("Take a Photo");
    saveScreenBtn.setText("Save screen");
    
    arrowBtn.addActionListener (new ToolButtonListener ());
   // arrowBtn.setToolTipText ("Arrow");
    arrowBtn.setText("Arrow");
    
    //Lllllj
    freeHandBtn.addActionListener (new ToolButtonListener ());
   // freeHandBtn.setToolTipText ("Free Hand");
    freeHandBtn.setText("Free Hand");
    
    colorBtn.addActionListener (new ToolButtonListener ());
   // colorBtn.setToolTipText ("Chose Color");
    colorBtn.setText("Choose color");

    
    strokeBtn.addActionListener (new ToolButtonListener ());
    //strokeBtn.setToolTipText ("Stroke");
    strokeBtn.setText("Stroke");

    
    clearBtn.addActionListener (new ToolButtonListener ());
   // clearBtn.setToolTipText ("Clear");
    clearBtn.setText("Clear");

    
    configBtn.addActionListener (new ToolButtonListener ());
    //configBtn.setToolTipText ("Config");
    configBtn.setText("Config");


    alphaSlider = new JSlider (JSlider.VERTICAL, 0, 255, 150);
    alphaSlider.setMajorTickSpacing (100);
    alphaSlider.setMinorTickSpacing (20);
    Font font = new Font("Serif", Font.ITALIC, 15);
    //alphaSlider.setFont(font);
    
    
    alphaSlider.setPaintTicks(false);
    alphaSlider.setPaintLabels (false);
    alphaSlider.addChangeListener (new ToolButtonListener ());
  //         alphaSlider.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));

    strokeSlider = new JSlider (JSlider.VERTICAL, 0, 30, 10);
    strokeSlider.setMajorTickSpacing (3);
    strokeSlider.setMinorTickSpacing (1);
    strokeSlider.setPaintTicks(false);
    strokeSlider.setPaintLabels (false);
    strokeSlider.addChangeListener (new ToolButtonListener ());
//           strokeSlider.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));




	/*
		fullChk = new JCheckBox("Rellenar");
		fullChk.addItemListener(
			new ItemListener()
			{
				public void itemStateChanged(ItemEvent event)
				{
					if(fullChk.isSelected()) {
						canvasPanel.setTransparency(Boolean.TRUE);}
					else {
						canvasPanel.setSolidMode(Boolean.FALSE);
					}
			}

		);
/*

/*----------------------------------------------------------------------------*/
    this.setLayout (new GridLayout (0, 1));	// 8 Buttons & 1 CheckBox
    JPanel sliders=new JPanel();
    sliders.setLayout(new GridLayout (0, 2));
    sliders.setBounds (0, 0, 150, 200);
    sliders.add (alphaSlider);
    sliders.add (strokeSlider);

    this.add (freeHandBtn);
    this.add (arrowBtn);
    this.add (lineBtn);
    this.add (colorBtn);

    this.add (sliders);

//    this.add (strokeBtn);
    this.add (clearBtn);
    
    
    this.add (saveScreenBtn);
    //        this.add(transparentBtn);
    
    this.add (configBtn);
    this.add (quitBtn);

    colorsChooser = new ColorsChooser ();
    color = new Color (0, 0, 255, 150);

  }
/*----------------------------------------------------------------------------*/
  private class ToolButtonListener implements ActionListener, ChangeListener
  {
    int i = 0;
    public void actionPerformed (ActionEvent event)
    {
      if (event.getSource () == lineBtn)
	{
	  canvasPanel.setDrawMode (canvasPanel.LINE);
	}


      if (event.getSource () == freeHandBtn)
	{
	  canvasPanel.setDrawMode (canvasPanel.FREE_HAND);
	}

      if (event.getSource () == arrowBtn)
	{
	  canvasPanel.setDrawMode (canvasPanel.ARROW);
	}


      if (event.getSource () == colorBtn)
	{
	  grafica.setFullScreenWindow (null);

	  color =
	    colorsChooser.showDialog (null, "Choose Background Color");
          
          colorsChooser.setCurrentColor(color);
	  
	  grafica.setFullScreenWindow (pframe);

	  canvasPanel.setForeGroundColor (color);

	}
	
	
	if (event.getSource () == configBtn)
	{
	
	  
	  
	  
          grafica.setFullScreenWindow (null);

          configFrame.setVisible(true);
	
	  //grafica.setFullScreenWindow (pframe);

	
	  /*grafica.setFullScreenWindow (null);

	  color =
	    colorsChooser.showDialog (null, "Choose Background Color");
          
          colorsChooser.setCurrentColor(color);
	  
	  grafica.setFullScreenWindow (pframe);

	  canvasPanel.setForeGroundColor (color);
	  */
	  // Write properties file.
	  /*
	  try {
	      properties.store(new FileOutputStream("filename.properties"), null);
	      } catch (IOException e) {
	      }
          */
	}
	
/*
      if (event.getSource () == strokeBtn)
	{
	  if (i == 0)
	    {
	      canvasPanel.setStroke (canvasPanel.thinStroke);
	      i++;
	    }
	  else if (i == 1)
	    {
	      canvasPanel.setStroke (canvasPanel.mediumStroke);
	      i++;
	    }
	  else
	    {
	      canvasPanel.setStroke (canvasPanel.wideStroke);
	      i = 0;
	    }
	}
*/

      if (event.getSource () == clearBtn)
	{
	  canvasPanel.clearCanvas ();
	}

      if (event.getSource () == saveScreenBtn)
	{

	  saveCapture(CaptureWhiteboard(grafica.getDefaultConfiguration().getBounds()));

	}
      if (event.getSource () == transparentBtn)
	{
	  Color newColor = canvasPanel.getForeGroundColor ();
	  canvasPanel.setForeGroundColor (new
					  Color (newColor.getRed (),
						 newColor.getGreen (),
						 newColor.getBlue (), 150));
	  //setLocation(canvasPanel.getPosMouseX()-100,canvasPanel.getPosMouseY());
	}


      if (event.getSource () == quitBtn)
	{
	  System.exit (0);

	}

    }				//action listener


    public void stateChanged (ChangeEvent e)
    {

      JSlider source = (JSlider) e.getSource ();
      if(source==alphaSlider)
      if (!source.getValueIsAdjusting ())
	{
	  canvasPanel.setAlpha ((int) source.getValue ());
	  canvasPanel.setForeGroundColor (canvasPanel.getForeGroundColor ());
	}
      
      if(source==strokeSlider)
      if(!source.getValueIsAdjusting ())
       {
        
         canvasPanel.setStroke((float) source.getValue ());
       }
          
    }
  }
  private BufferedImage CaptureWhiteboard(Rectangle captureArea)
  {
    //File selFile;
    BufferedImage capture;
    try
    {
      Robot rbt = new Robot ();
//      Toolkit tk = Toolkit.getDefaultToolkit ();
//      Dimension dim = tk.getScreenSize ();
//      capture =
//	rbt.createScreenCapture (new Rectangle(dim));
      capture = (BufferedImage)canvasPanel.createImage((int)captureArea.getWidth(), (int)captureArea.getHeight());
//	rbt.createScreenCapture (captureArea);
      return capture;
    }
    catch (Exception ex)
    {
      ex.printStackTrace ();
    }
    return null;

  }


  private void saveConfig()
  {
  }
  
  private void saveCapture (BufferedImage capture)
  {
    File selFile;

    try
    {

      String filename = File.separator + System.getProperty ("user.home");
      JFileChooser fc = new JFileChooser (new File (filename));
      // Show save dialog; this method does not return until the dialog is closed
      fc.setDialogTitle ("Save As");
      File default_name = new File ("capture.png");
      fc.setSelectedFile (default_name);

      grafica.setFullScreenWindow (null);

      int returnVal = fc.showSaveDialog (null);

      grafica.setFullScreenWindow (pframe);

      if (returnVal == JFileChooser.APPROVE_OPTION)
	{
	  //getSelectedFile().getName());
	  selFile = fc.getSelectedFile ();

	  if (selFile.exists ())
	    {

	    }
	  else
	    {
                ImageIO.write((RenderedImage) capture, "JPG", selFile);
                // File or directory does not exist
	    }




	}			// if

    }
    catch (IOException e)
    {

    }

  }

}
