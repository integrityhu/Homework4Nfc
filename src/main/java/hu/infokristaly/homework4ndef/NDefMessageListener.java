/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.infokristaly.homework4ndef;

import org.nfctools.tools.json.NdefJsonMessage;

/**
 *
 * @author pzoli
 */
public interface NDefMessageListener {

    public void sendToJavaScript(NdefJsonMessage ndefJsonMessage);
    
}
