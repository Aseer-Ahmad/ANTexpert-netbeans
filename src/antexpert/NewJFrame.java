package antexpert;


import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.HashMap;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aseer
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public String componentLabel="";
    public String components = "";
    public DefaultListModel<String> defaultListModel;
    public DefaultListModel<String> defaultListModel_orglabels;
    public DefaultListModel<String> defaultListModel_createdPackagenames;
    
    public String backupDirectoryName = "";
    
    public List<String> metadatalist;
    
    public static String SELECTED_ORG_LABEL = "";
    public static final String newChangeLineComment = "<!--new changes here-->\n";
    public static float VERSION = 41.0f;
    public static final String head = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<Package xmlns=\"http://soap.sforce.com/2006/04/metadata\">\n";
    public static final String version = "<version>" + VERSION + "</version>\n";
    public static final String tail = "</Package>\n";
    
    
    //Package members
    public static String packageString = "";
    public Map<String, String[]> metadata_map;
    public Map<String, MdUtility> org_map;
    
    //folder maps
    public static final String base_path = FileSystems.getDefault().getPath("").toAbsolutePath().toString();
    String retreive = "\\Ant\\retreive";
    String old_pkg = "\\Ant\\old_packages";
    String config = "\\Ant\\config";
    String build_prop = "\\Ant\\build.properties";
         
        
    public NewJFrame() {
        
        initComponents();
        
        init();
       
    }
    
     private void init() {
        jList_createdpackage_names.setVisible(false);
        jLabel_added.setVisible(false);
//        jButton_add.setVisible(false);
       
        jPopupMenu.add(jPanel1);
        
        metadata_map = new HashMap<String, String[]>();
        org_map = new HashMap<String, MdUtility>();
   
        MdUtility mdUtility = new MdUtility();
        metadatalist = Arrays.asList( mdUtility.metadata_list.split("\n"));
     
        
        defaultListModel = new DefaultListModel<>();
        jList_metadata_types.setModel(defaultListModel);
        
        defaultListModel_orglabels = new DefaultListModel<>();
        jList_orgLabels.setModel(defaultListModel_orglabels);
        
        defaultListModel_createdPackagenames  = new DefaultListModel<>();
        jList_createdpackage_names.setModel(defaultListModel_createdPackagenames);
        
        createFolderMap();
        
     
    }
     
     private void createFolderMap(){
        
        
         File file = new File(base_path+retreive);
         if(  !file.isDirectory()){
             file.mkdirs();
         }else{
             //populate list  created package names
             String [] names = file.list();
             for(String name: names)
                 defaultListModel_createdPackagenames.addElement(name);
         }
         
         file = new File(base_path+old_pkg);
         if(  !file.isDirectory()){
             file.mkdirs();
            }
         
         try{
            file = new File(base_path+config);
            if( !file.exists()){
               file.createNewFile();
            }else{
                String line;
                BufferedReader br = new BufferedReader(new FileReader(file));
                while ((line = br.readLine()) != null) {
                    String[] arr = line.split("\t");
                    if( !org_map.containsKey(arr[0])){
                        org_map.put( arr[0], new MdUtility(arr[0], arr[1], arr[2], arr[3], arr[4]));
                        defaultListModel_orglabels.addElement(arr[0]);
                    }
                }
                br.close();
            }
         }catch(IOException ex){
             ex.printStackTrace();
         }
                  
     }    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList_metadata_types = new javax.swing.JList<>();
        jPopupMenu = new javax.swing.JPopupMenu();
        buttonGroup_pkgaction = new javax.swing.ButtonGroup();
        jPanel_pkg_details = new javax.swing.JPanel();
        jButton_add = new javax.swing.JButton();
        jButton_preview = new javax.swing.JButton();
        jLabel_added = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton_save = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList_createdpackage_names = new javax.swing.JList<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_components = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jTextField_metadata = new javax.swing.JTextField();
        jButton_backup_packages = new javax.swing.JButton();
        jComboBox_pkgName = new javax.swing.JComboBox<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3_org_details = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList_orgLabels = new javax.swing.JList<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel_urltype = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel_maxpoll = new javax.swing.JLabel();
        jButton_addOrg = new javax.swing.JButton();
        jButton_selectorg = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButton_removeOrg = new javax.swing.JButton();
        jLabel_selectedOrg = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jComboBox_deploy_retreive = new javax.swing.JComboBox<>();
        jCheckBox_rollbackonerror = new javax.swing.JCheckBox();
        jCheckBox_checkonly = new javax.swing.JCheckBox();
        jCheckBox_testlevelLocal = new javax.swing.JCheckBox();
        jCheckBox_packageNames = new javax.swing.JCheckBox();
        jCheckBox_testLevel_specific = new javax.swing.JCheckBox();

        jList_metadata_types.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jList_metadata_typesMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(jList_metadata_types);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPopupMenu.setFocusable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel_pkg_details.setBorder(javax.swing.BorderFactory.createTitledBorder("Create/ Update Package"));

        jButton_add.setText("Add   Components");
        jButton_add.setEnabled(false);
        jButton_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_addActionPerformed(evt);
            }
        });

        jButton_preview.setText("Preview current Package");
        jButton_preview.setEnabled(false);
        jButton_preview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_previewActionPerformed(evt);
            }
        });

        jLabel_added.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel_added.setForeground(new java.awt.Color(24, 219, 23));
        jLabel_added.setText("Added Components to Package. ");

        buttonGroup_pkgaction.add(jRadioButton1);
        jRadioButton1.setMnemonic(' ');
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("create");
        jRadioButton1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup_pkgaction.add(jRadioButton2);
        jRadioButton2.setText("update");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jButton_save.setText("Save");
        jButton_save.setEnabled(false);
        jButton_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_saveActionPerformed(evt);
            }
        });

        jList_createdpackage_names.setBorder(javax.swing.BorderFactory.createTitledBorder("select package to update"));
        jList_createdpackage_names.setToolTipText("");
        jList_createdpackage_names.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList_createdpackage_namesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jList_createdpackage_names);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Enter Components"));

        jTextArea_components.setColumns(20);
        jTextArea_components.setRows(5);
        jTextArea_components.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextArea_componentsKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea_components);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("select metadata"));

        jTextField_metadata.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_metadataKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField_metadata, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jTextField_metadata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jButton_backup_packages.setText("BACKUP");
        jButton_backup_packages.setEnabled(false);
        jButton_backup_packages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_backup_packagesActionPerformed(evt);
            }
        });

        jComboBox_pkgName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "package", "destructiveChanges", "destructiveChangesPost", "destructiveChangesPre" }));
        jComboBox_pkgName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_pkgNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_pkg_detailsLayout = new javax.swing.GroupLayout(jPanel_pkg_details);
        jPanel_pkg_details.setLayout(jPanel_pkg_detailsLayout);
        jPanel_pkg_detailsLayout.setHorizontalGroup(
            jPanel_pkg_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_pkg_detailsLayout.createSequentialGroup()
                .addGroup(jPanel_pkg_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_pkg_detailsLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2))
                    .addGroup(jPanel_pkg_detailsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(jPanel_pkg_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_pkg_detailsLayout.createSequentialGroup()
                        .addComponent(jComboBox_pkgName, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel_pkg_detailsLayout.createSequentialGroup()
                        .addGroup(jPanel_pkg_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel_pkg_detailsLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel_added)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel_pkg_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_pkg_detailsLayout.createSequentialGroup()
                        .addComponent(jButton_save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_preview))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_pkg_detailsLayout.createSequentialGroup()
                        .addComponent(jButton_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_backup_packages)))
                .addGap(25, 25, 25))
        );
        jPanel_pkg_detailsLayout.setVerticalGroup(
            jPanel_pkg_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_pkg_detailsLayout.createSequentialGroup()
                .addGroup(jPanel_pkg_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel_pkg_detailsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel_pkg_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_add)
                            .addComponent(jButton_backup_packages))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_pkg_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_save)
                            .addComponent(jButton_preview))
                        .addGap(11, 11, 11))
                    .addGroup(jPanel_pkg_detailsLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel_pkg_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2)
                            .addComponent(jComboBox_pkgName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_added)
                        .addGap(6, 6, 6)))
                .addGroup(jPanel_pkg_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_pkg_detailsLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel_pkg_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel_pkg_detailsLayout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3_org_details.setBorder(javax.swing.BorderFactory.createTitledBorder("Select Organization "));

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel6.setText("select org name");

        jList_orgLabels.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList_orgLabelsMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jList_orgLabelsMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(jList_orgLabels);

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel7.setText("sf.serverurl");

        jLabel_urltype.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_urltype.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_urltype.setText("-");

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel9.setText("sf.maxpoll");

        jLabel_maxpoll.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_maxpoll.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_maxpoll.setText("-");

        jButton_addOrg.setText("Add New Org Cred.");
        jButton_addOrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_addOrgActionPerformed(evt);
            }
        });

        jButton_selectorg.setText("Select org.");
        jButton_selectorg.setEnabled(false);
        jButton_selectorg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_selectorgActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jButton_removeOrg.setText("Remove Selected Org.");
        jButton_removeOrg.setEnabled(false);
        jButton_removeOrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_removeOrgActionPerformed(evt);
            }
        });

        jLabel_selectedOrg.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_selectedOrg.setForeground(new java.awt.Color(102, 102, 255));
        jLabel_selectedOrg.setText("--No Org selected--");

        javax.swing.GroupLayout jPanel3_org_detailsLayout = new javax.swing.GroupLayout(jPanel3_org_details);
        jPanel3_org_details.setLayout(jPanel3_org_detailsLayout);
        jPanel3_org_detailsLayout.setHorizontalGroup(
            jPanel3_org_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3_org_detailsLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3_org_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3_org_detailsLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3_org_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_addOrg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_removeOrg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel3_org_detailsLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3_org_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3_org_detailsLayout.createSequentialGroup()
                                .addGroup(jPanel3_org_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel_urltype, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addGroup(jPanel3_org_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel_maxpoll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jButton_selectorg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(jLabel_selectedOrg, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(205, 205, 205))))
        );
        jPanel3_org_detailsLayout.setVerticalGroup(
            jPanel3_org_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3_org_detailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3_org_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3_org_detailsLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3_org_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3_org_detailsLayout.createSequentialGroup()
                                .addGroup(jPanel3_org_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3_org_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel3_org_detailsLayout.createSequentialGroup()
                                            .addComponent(jLabel9)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel_maxpoll))
                                        .addGroup(jPanel3_org_detailsLayout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel_urltype)))
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3_org_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton_selectorg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel_selectedOrg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel3_org_detailsLayout.createSequentialGroup()
                        .addComponent(jButton_addOrg)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_removeOrg)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Select Organization", jPanel3_org_details);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Deploy/ Retreive Package"));

        jComboBox_deploy_retreive.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Deploy", "Retreive" }));
        jComboBox_deploy_retreive.setEnabled(false);

        jCheckBox_rollbackonerror.setText("rollbackonError");

        jCheckBox_checkonly.setText("checkOnly");

        jCheckBox_testlevelLocal.setText("testLevel-local");

        jCheckBox_packageNames.setText("packageNames");

        jCheckBox_testLevel_specific.setText("testLevel-specific");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox_deploy_retreive, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox_packageNames)
                    .addComponent(jCheckBox_testlevelLocal)
                    .addComponent(jCheckBox_checkonly)
                    .addComponent(jCheckBox_rollbackonerror)
                    .addComponent(jCheckBox_testLevel_specific))
                .addContainerGap(657, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox_rollbackonerror)
                    .addComponent(jComboBox_deploy_retreive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox_checkonly)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox_testlevelLocal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox_packageNames)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox_testLevel_specific)
                .addGap(0, 50, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Deploy/Retreive", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1035, Short.MAX_VALUE)
                    .addComponent(jPanel_pkg_details, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_pkg_details, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_addActionPerformed
        // TODO add your handling code here:
        components = jTextArea_components.getText().toString();
        
        if( !jTextField_metadata.getText().isEmpty() ){
            String [] arr = formatComponents(components);
            metadata_map.put( jTextField_metadata.getText().toString() , arr);      

            //label appear
            jLabel_added.setVisible(true);
            
            //clear text fields and area
             jTextArea_components.setText("");
            jTextField_metadata.setText("");
        
            //button enable 
            jButton_save.setEnabled(true);
            jButton_preview.setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(this, "Metadata type not selected!\nSelect one to make package.");
        }
    }//GEN-LAST:event_jButton_addActionPerformed

    public static String[] formatComponents(String cmp){
       
        boolean isTabSeparated = cmp.contains("\t");
        boolean isCommaSeparated = cmp.contains(",");
        boolean isSpaceSeparated = cmp.contains(" ");
        boolean isNewLineSeparated = cmp.contains("\n");
        
        String[] arr = new String[1];

        if(isTabSeparated){
            // System.out.println("Tab separated");
            arr = cmp.split("\t");
        }else if(isSpaceSeparated){
            // System.out.println("Space separated");
            arr = cmp.split(" ");
        }else if(isCommaSeparated){
            // System.out.println("Comma separated");
            arr = cmp.split(",");
        }else if(isNewLineSeparated){
            arr = cmp.split("\n");
        }else{
            arr[0] = cmp;
        }
        
        return arr;
    }
    
    private void jTextField_metadataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_metadataKeyReleased
        // TODO add your handling code here:

        
        if(evt.getKeyCode() == evt.VK_ENTER){
            jTextField_metadata.setText( jList_metadata_types.getSelectedValue() );
        }
        
        String metadata =  jTextField_metadata.getText().trim().toLowerCase();
        
        if(!metadata.equals("")){
            
            jLabel_added.setVisible(false);

            defaultListModel.removeAllElements();
            
            for(String m : metadatalist){
                if(m.toLowerCase().contains(metadata))
                    defaultListModel.addElement(m);
            }
            jList_metadata_types.setSelectedIndex(0);
            jPopupMenu.show(jTextField_metadata, 0 , jTextField_metadata.getHeight());
      
        }

    }//GEN-LAST:event_jTextField_metadataKeyReleased
    
    
    
    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        jList_createdpackage_names.setVisible(false);
        jComboBox_pkgName.setVisible(true);
        
                
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        jComboBox_pkgName.setVisible(false);
        jList_createdpackage_names.setVisible(true);
        
        
        jLabel_added.setVisible(false);
        jButton_add.setEnabled(false);
        jButton_preview.setEnabled(false);
        jButton_save.setEnabled(false);
        jButton_backup_packages.setEnabled(false);
        
        //reset
        metadata_map = new HashMap<>();
        jTextArea_components.setText("");
        jTextField_metadata.setText("");
        

    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jButton_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_saveActionPerformed
        // TODO add your handling code here:
        packageString = createPackageString(metadata_map);
        
        // save to directory
        try{
            BufferedWriter bf = new BufferedWriter( new FileWriter(new File(base_path + retreive +"\\" + jComboBox_pkgName.getSelectedItem()+".xml" )));
            bf.write(packageString);
            bf.close();

            defaultListModel_createdPackagenames.addElement(jComboBox_pkgName.getSelectedItem().toString()+".xml");

        }catch(IOException ex){
            ex.printStackTrace();
        }

        JOptionPane.showMessageDialog( new JFrame(),jComboBox_pkgName.getSelectedItem()+" has been saved.\nBegin creating new package."); 

        jButton_preview.setEnabled(false);
        jButton_save.setEnabled(false);
        jButton_add.setEnabled(false);
        jButton_backup_packages.setEnabled(true);

        //reset
        metadata_map = new HashMap<>();
        jTextArea_components.setText("");
        jTextField_metadata.setText("");
        
        
    }//GEN-LAST:event_jButton_saveActionPerformed

    private void jTextArea_componentsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea_componentsKeyReleased
        // TODO add your handling code here:
        components = jTextArea_components.getText().toString();
        
        if(!components.equals("") && jRadioButton1.isSelected()){
            
            jButton_add.setEnabled(true);
                     
        }else{
            jButton_add.setEnabled(false);
            
        } 
        
    }//GEN-LAST:event_jTextArea_componentsKeyReleased

    private void jButton_previewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_previewActionPerformed
        // TODO add your handling code here:
        
        StringBuilder sb = new StringBuilder();
        sb.append(head);

        for(Map.Entry<String, String[]> entry : metadata_map.entrySet() ){
            
            sb.append("<types>\n");
            String key_name = entry.getKey();
            String [] value_members = entry.getValue();

            if(value_members.length > 0){
                
                for(String member: value_members){
                    if(!member.equals(""))
                        sb.append("\t<members>"+member+"</members>\n");
                }
            }   
            sb.append("\t<name>"+key_name+"</name>\n</types>\n\n");    
        }
        
        sb.append(version);
        sb.append(tail);
        
        //pop up display
        JTextArea textArea = new JTextArea(sb.toString());
        JScrollPane scrollPane = new JScrollPane(textArea);  
        textArea.setLineWrap(true);  
        textArea.setWrapStyleWord(true); 
        scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
        JOptionPane.showMessageDialog(null, scrollPane, "Preview Components List",  
                                               JOptionPane.YES_NO_OPTION);
    }//GEN-LAST:event_jButton_previewActionPerformed

    private void jButton_addOrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_addOrgActionPerformed
        // TODO add your handling code here:
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 2, 2));

        JTextField username = new JTextField(10);
        JTextField password = new JTextField(10);
        JTextField maxpoll = new JTextField(10);
        maxpoll.setText("20");
        JTextField label = new JTextField(10);
        
        ButtonGroup group = new ButtonGroup();
        JRadioButton test_org = new JRadioButton();
        test_org.setText("test");
        test_org.setSelected(true);
        JRadioButton login_org = new JRadioButton();
        login_org.setText("login");
        group.add(test_org);
        group.add(login_org);
        
        panel.add(new JLabel("Label  : "));
        panel.add(label);
        panel.add(new JLabel("username : "));
        panel.add(username);
        panel.add(new JLabel("password : "));
        panel.add(password);
        panel.add(new JLabel("maxpoll : "));
        panel.add(maxpoll);
        panel.add(new JLabel("Select servel url "));
        panel.add(new JLabel("(Sanbox / production): "));
        panel.add(test_org);
        panel.add(login_org);
        
        
        int option =JOptionPane.showConfirmDialog(new JFrame(),
                                                    panel,
                                                    "Add credentials here.",
                                                    JOptionPane.OK_CANCEL_OPTION,
                                                    JOptionPane.INFORMATION_MESSAGE);
        // add security token
        // add null check for username and password
        if(option == JOptionPane.OK_OPTION && !org_map.containsKey(label.getText()) && !label.getText().isEmpty() ){
  
            String l, u, p, m, tg;
            l = label.getText();
            u = username.getText();
            p = password.getText();
            m = maxpoll.getText();
            tg = test_org.isSelected()? "test" : "login";
            
            org_map.put(l, new MdUtility( l, u, p, m,tg) );
            
            try{
               BufferedWriter bw = new BufferedWriter(new FileWriter(base_path + config, true));
               //label username password maxpoll tg
               bw.write(l+"\t"+u+"\t"+p+"\t"+m+"\t"+tg+"\n");
               bw.close();
            }catch(IOException ex){
                ex.printStackTrace();
            }
           
            defaultListModel_orglabels.addElement(l);
            
        }else if( label.getText().isEmpty() && option == JOptionPane.OK_OPTION ){
            JOptionPane.showMessageDialog(this, "Label cannot be empty.");                
        }else if( org_map.containsKey(label.getText()) ){
            JOptionPane.showMessageDialog(this, "An Org exists with the same label !! Try Another.");
        }
        
    }//GEN-LAST:event_jButton_addOrgActionPerformed

    private void jList_orgLabelsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList_orgLabelsMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jList_orgLabelsMouseClicked

    private void jButton_selectorgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_selectorgActionPerformed
        // TODO add your handling code here:
        
        SELECTED_ORG_LABEL = jList_orgLabels.getSelectedValue();
        // make build file
        String buildP_string = org_map.get(SELECTED_ORG_LABEL).getBuildProperties();

        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(base_path + build_prop)));
            bw.write(buildP_string);
            bw.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
        jComboBox_deploy_retreive.setEnabled(true);
        JOptionPane.showMessageDialog(this, "Deployment and retreival will happen through "+SELECTED_ORG_LABEL+" Org.");
        jLabel_selectedOrg.setText( "--"+ SELECTED_ORG_LABEL+" Org selected--");
    }//GEN-LAST:event_jButton_selectorgActionPerformed

    private void jButton_backup_packagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_backup_packagesActionPerformed
        // TODO add your handling code here:
        
        backupDirectoryName = new SimpleDateFormat("yyyy.MM.dd_HH-mm").format(new Date());
        String _path = base_path + old_pkg +"\\"+ backupDirectoryName;
        
        File file = new File(_path);
        file.mkdir();
        
        File file1 = new File(base_path + retreive);
        String [] contents = file1.list();
        
        try{
            for(String content : contents){
                String temp = base_path + retreive + "\\"+ content;
                Files.move( Paths.get(temp), Paths.get(_path + "\\"+ content));
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
    
        defaultListModel_createdPackagenames.removeAllElements();
        
        //joption message shows
        JOptionPane.showMessageDialog(this, "Files have been backed up!!\nFind them in Old_Packages folder by date." );
        jButton_backup_packages.setEnabled(false);
        
    }//GEN-LAST:event_jButton_backup_packagesActionPerformed

    private void jComboBox_pkgNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_pkgNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_pkgNameActionPerformed

    private void jList_createdpackage_namesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList_createdpackage_namesMouseClicked
        // TODO add your handling code here:
        
        if( !defaultListModel_createdPackagenames.isEmpty()){
            String file_name = jList_createdpackage_names.getSelectedValue();
            StringBuilder sb = new StringBuilder();
            String abs_path_file = base_path+retreive+"\\"+file_name;
            File file = new File(abs_path_file);

            try{
                String line;
                BufferedReader br = new BufferedReader(new FileReader(file));
                while((line = br.readLine())!=null ){
                    sb.append(line+"\n");
                } 
                br.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }

            JTextArea textArea = new JTextArea(sb.toString());
            JScrollPane scrollPane = new JScrollPane(textArea);  
            textArea.setLineWrap(true);  
            textArea.setWrapStyleWord(true); 
            scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
            Object[] options = {"Click to save the changes!","Delete", "Cancel"};
            int temp = JOptionPane.showOptionDialog(null, scrollPane, "Edit component",  
                                                   JOptionPane.YES_NO_CANCEL_OPTION,
                                                   JOptionPane.WARNING_MESSAGE,
                                                   null,
                                                   options,
                                                   options[0]);

            if(temp == JOptionPane.YES_OPTION){
                //save edited 
                String edited = textArea.getText();
                BufferedWriter br;
                try {
                    br = new BufferedWriter(new FileWriter(file));
                    br.write(edited);
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                } 
                JOptionPane.showMessageDialog(this, file_name+" ; Changes have been saved!");

            }else if(temp == JOptionPane.NO_OPTION){
                //delete
                 if(file.delete()) 
                    System.out.println("File deleted successfully"); 
                else
                    System.out.println("Failed to delete the file"); 
                //update packagelist
                defaultListModel_createdPackagenames.removeElement(file_name);
                //show confirm dialog
                JOptionPane.showMessageDialog(this, file_name+" has been deleted!");
            }

        }
        
    }//GEN-LAST:event_jList_createdpackage_namesMouseClicked

    private void jButton_removeOrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_removeOrgActionPerformed
        // TODO add your handling code here:
        String org_label = jList_orgLabels.getSelectedValue().toString();
        
        int temp = JOptionPane.showConfirmDialog(this, "Delete "+ org_label+" credentials?");

        if(temp == JOptionPane.YES_OPTION){
            //remove from map and list model
            org_map.remove(org_label);
            defaultListModel_orglabels.removeElement(org_label);
            
            //write to config
            File file = new File(base_path+config);
            try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for(Map.Entry<String, MdUtility> entry : org_map.entrySet()){
                MdUtility mdUtility = entry.getValue();
                
                //label username password maxpoll tg
                bw.write( mdUtility.getLabel()+"\t"+mdUtility.getUsername()+"\t"+mdUtility.getPassword()
                        +"\t"+mdUtility.getMaxpoll()+"\t"+mdUtility.getOrg_type()+"\n");
                
            }
            bw.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
         
            jList_orgLabels.clearSelection();
            
            //delete build
            new File(base_path+build_prop).delete();
            
            //set labels to blank
            jLabel_maxpoll.setText("-");
            jLabel_urltype.setText("-");
            jLabel_selectedOrg.setText( "--No Org selected--");
            
            //disable buttons
            jButton_selectorg.setEnabled(false);
            jButton_removeOrg.setEnabled(false);
            
            //disable combo box deploy retreive
            jComboBox_deploy_retreive.setEnabled(false);
            
        }
        
    }//GEN-LAST:event_jButton_removeOrgActionPerformed

    private void jList_orgLabelsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList_orgLabelsMouseReleased
        // TODO add your handling code here:
        
        if( !defaultListModel_orglabels.isEmpty()){
            MdUtility mdUtility = org_map.get( jList_orgLabels.getSelectedValue() );
            jLabel_urltype.setText( mdUtility.getOrg_type());
            jLabel_maxpoll.setText( mdUtility.getMaxpoll());

            //enable buttons
            jButton_selectorg.setEnabled(true);
            jButton_removeOrg.setEnabled(true);
        }
    }//GEN-LAST:event_jList_orgLabelsMouseReleased

    private void jList_metadata_typesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList_metadata_typesMousePressed
        // TODO add your handling code here:
        jTextField_metadata.setText(jList_metadata_types.getSelectedValue());
    }//GEN-LAST:event_jList_metadata_typesMousePressed
    
     
    public static String createPackageString(Map<String, String[]> allcomp){

        StringBuilder sb = new StringBuilder();
        sb.append(head);

        for(Map.Entry<String, String[]> entry : allcomp.entrySet() ){
            
            sb.append("<types>\n");
            String key_name = entry.getKey();
            String [] value_members = entry.getValue();

            if(value_members.length > 0){
                
                for(String member: value_members){
                    if(!member.equals(""))
                        sb.append("\t<members>"+member+"</members>\n");
                }
            }   
            sb.append("\t<name>"+key_name+"</name>\n</types>\n\n");    
        }
        
        sb.append(version);
        sb.append(tail);

        return new String(sb);

    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup_pkgaction;
    private javax.swing.JButton jButton_add;
    private javax.swing.JButton jButton_addOrg;
    private javax.swing.JButton jButton_backup_packages;
    private javax.swing.JButton jButton_preview;
    private javax.swing.JButton jButton_removeOrg;
    private javax.swing.JButton jButton_save;
    private javax.swing.JButton jButton_selectorg;
    private javax.swing.JCheckBox jCheckBox_checkonly;
    private javax.swing.JCheckBox jCheckBox_packageNames;
    private javax.swing.JCheckBox jCheckBox_rollbackonerror;
    private javax.swing.JCheckBox jCheckBox_testLevel_specific;
    private javax.swing.JCheckBox jCheckBox_testlevelLocal;
    private javax.swing.JComboBox<String> jComboBox_deploy_retreive;
    private javax.swing.JComboBox<String> jComboBox_pkgName;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_added;
    private javax.swing.JLabel jLabel_maxpoll;
    private javax.swing.JLabel jLabel_selectedOrg;
    private javax.swing.JLabel jLabel_urltype;
    private javax.swing.JList<String> jList_createdpackage_names;
    private javax.swing.JList<String> jList_metadata_types;
    private javax.swing.JList<String> jList_orgLabels;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel3_org_details;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel_pkg_details;
    private javax.swing.JPopupMenu jPopupMenu;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea_components;
    private javax.swing.JTextField jTextField_metadata;
    // End of variables declaration//GEN-END:variables

   
}
