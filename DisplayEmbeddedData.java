/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class DisplayEmbeddedData extends JFrame{
    
    public static void toDisplayEmbeddedData(String message){
           JPanel middlePanel = new JPanel ();
           middlePanel.setBorder ( new TitledBorder ( new EtchedBorder (), "Display Embedded Data" ) );

            // create the middle panel components

            JTextArea display = new JTextArea ( 16, 58 );
            display.setText(message);
            display.setEditable (false); // set textArea non-editable
            display.setLineWrap(true);
            display.setWrapStyleWord(true);
            JScrollPane scroll = new JScrollPane ( display );
            scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
             
            //Add Textarea in to middle panel
            middlePanel.add ( scroll );

            // My code
            JFrame frame = new JFrame ();
            frame.add ( middlePanel );
            frame.pack ();
            frame.setLocationRelativeTo ( null );
            frame.setTitle("Embedded Data");
            frame.setResizable(false);
            frame.setVisible ( true );
            
           
    }
    
}
