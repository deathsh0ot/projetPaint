package powd;

import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import javax.imageio.*;


public class ConfigFrame extends JFrame //implements ItemListener
{
  private JFrame pframe;
  private CanvasPanel canvasPanel;
  
  private JCheckBox imageOrColor;
  private JButton okBtn,colorBackgroundBtn;
  private JPanel panel;
  private ColorsChooser colorsChooser;
   
  Color color; 
  
  static GraphicsDevice grafica =
    GraphicsEnvironment.getLocalGraphicsEnvironment ().
    getDefaultScreenDevice ();

  
  public ConfigFrame(CanvasPanel inCanvasPanel, JFrame pf )
  {
    super("Configuration");
    setSize(250, 250);
    setLocation(300,500);
    pframe=pf;
    canvasPanel=inCanvasPanel;
        
    panel = new JPanel();
    panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
    panel.setLayout(new GridLayout(0, 1));
    
    imageOrColor = new JCheckBox("Solid Background Color");
    imageOrColor.setMnemonic(KeyEvent.VK_C);
    imageOrColor.setSelected(false);
    //imageOrColor.addItemListener(this);
     
    okBtn =new JButton ("Ok");
    okBtn.addActionListener (new ToolButtonListener ());    
    okBtn.setToolTipText ("Ok");
    
    colorBackgroundBtn =new JButton ("Background Color");
    colorBackgroundBtn.addActionListener (new ToolButtonListener ());    
    colorBackgroundBtn.setToolTipText ("Chose Bacground Color");
    
    
    colorsChooser = new ColorsChooser ();
    color = new Color (0, 0, 255, 150);

    
    
    //this.add(okBtn);
    panel.add(imageOrColor);
    
    panel.add(colorBackgroundBtn);
    panel.add(okBtn);
    //panel.add(label);
    getContentPane().add(BorderLayout.CENTER, panel);
   
  }// constructor
      

/*
  public void itemStateChanged(ItemEvent e)
  {
      Object source = e.getItemSelectable();  
      //if (e.getStateChange() == ItemEvent.DESELECTED)
      
      if ( source == imageOrColor)
	{
	  //canvasPanel.setDrawMode (canvasPanel.LINE);
	  

	}
      
  }
*/
  private class ToolButtonListener implements ActionListener
  {

    public void actionPerformed (ActionEvent event)
    {
      if (event.getSource () == okBtn)
	{
	  //canvasPanel.setDrawMode (canvasPanel.LINE);
	  
	  if(imageOrColor.isSelected())
	  {
	    canvasPanel.properties.setProperty("background","color");
	    canvasPanel.updateBackground();
	    
	  }
	  else
	  {
	    canvasPanel.properties.setProperty("background","image");
	    canvasPanel.updateBackground();
	   
	  }
	  
	  grafica.setFullScreenWindow (pframe);
	}
      
      if (event.getSource () == colorBackgroundBtn)
	{
	  //grafica.setFullScreenWindow (null);

	  color =
	    colorsChooser.showDialog (null, "Choose Background Color");
          
          colorsChooser.setCurrentColor(color);
	  
	  //grafica.setFullScreenWindow (pframe);

	  //canvasPanel.setForeGroundColor (color);
	  canvasPanel.setBackGroundColor(color);
	}      

     } // actionPerformed
    
  } // ToolButtonListener
      
} // end