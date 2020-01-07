/* Aplication launcher */
package powd;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.*;

public class Powd
{
  public static void main (String args[])
  {

    Painter application = new Painter ();

      application.show ();
      application.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

  }
}
