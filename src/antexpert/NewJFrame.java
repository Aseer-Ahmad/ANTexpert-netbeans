package antexpert;


import java.awt.Color;
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
import java.util.ArrayList;

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
    
    public static final int CHECKONLY = 1;
    public static final int ROLLBACK = 2;
    public static final int TESTSPECIFIC = 3;
    public static final int TESTLOCAL = 4;
    
    public static String SELECTED_ORG_LABEL = "";
    public static final String newChangeLineComment = "<!--new changes here-->\n";
    public static float VERSION = 41.0f;
    public static String version = "<version>" + VERSION + "</version>\n";
    public static final String head = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<Package xmlns=\"http://soap.sforce.com/2006/04/metadata\">\n";
    public static final String tail = "</Package>\n";
    
    
    //Package members
    public static String packageString = "";
    public Map<String, String[]> metadata_map;
    public Map<String, MdUtility> org_map;
    
    //folder maps
    public static final String base_path = FileSystems.getDefault().getPath("").toAbsolutePath().toString();
    String retreive = "\\Ant\\retreive";
    String retreivedSource = "\\Ant\\retreivedSource";
    String old_pkg = "\\Ant\\old_packages";
    String config = "\\Ant\\config";
    String build_prop = "\\Ant\\build.properties";
    String build_xml = "\\Ant\\build.xml";     
        
    public NewJFrame() {
        
        initComponents();
        
        init();
       
    }
    
     private void init() {
        this.setTitle("ANT Expert");
        jPanel_pkg_create.setVisible(true);
        jPanel_deploy.setVisible(false);
        
        jTextArea_specifictests_deploy.setVisible(false);
         
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
             //populate list with previous created packages names
             String [] names = file.list();
             for(String name: names)
                 defaultListModel_createdPackagenames.addElement(name);
             if(names.length > 0)
                 jButton_backup_packages.setEnabled(true);
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
                        org_map.put( arr[0], new MdUtility(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]));
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
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel_showPanelCreate = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel_showDeploy = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton_addOrg = new javax.swing.JButton();
        jButton_removeOrg = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList_orgLabels = new javax.swing.JList<>();
        jButton_selectorg = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel_selectedOrg = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel_urltype = new javax.swing.JLabel();
        jLabel_maxpoll = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel_deploy = new javax.swing.JPanel();
        jComboBox_deploy_retreive = new javax.swing.JComboBox<>();
        jCheckBox_rollbackonerror = new javax.swing.JCheckBox();
        jCheckBox_checkonly = new javax.swing.JCheckBox();
        jCheckBox_testlevelLocal = new javax.swing.JCheckBox();
        jCheckBox_testLevel_specific = new javax.swing.JCheckBox();
        jButton_deploy_retreive = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea_specifictests_deploy = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jPanel_pkg_create = new javax.swing.JPanel();
        jButton_add = new javax.swing.JButton();
        jButton_preview = new javax.swing.JButton();
        jLabel_added = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton_save = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_components = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jTextField_metadata = new javax.swing.JTextField();
        jButton_backup_packages = new javax.swing.JButton();
        jComboBox_pkgName = new javax.swing.JComboBox<>();
        jList_createdpackage_names = new javax.swing.JList<>();

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
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPopupMenu.setFocusable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setLocation(new java.awt.Point(0, 0));
        setMaximumSize(new Dimension(100, 100));
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(0, 51, 102));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ant Expert");

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        jPanel_showPanelCreate.setBackground(new java.awt.Color(46, 69, 113));
        jPanel_showPanelCreate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_showPanelCreateMouseClicked(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Create/Update Package");

        javax.swing.GroupLayout jPanel_showPanelCreateLayout = new javax.swing.GroupLayout(jPanel_showPanelCreate);
        jPanel_showPanelCreate.setLayout(jPanel_showPanelCreateLayout);
        jPanel_showPanelCreateLayout.setHorizontalGroup(
            jPanel_showPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_showPanelCreateLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_showPanelCreateLayout.setVerticalGroup(
            jPanel_showPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_showPanelCreateLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel6)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel_showDeploy.setBackground(new java.awt.Color(0, 51, 102));
        jPanel_showDeploy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_showDeployMouseClicked(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Deploy & Retreive");

        javax.swing.GroupLayout jPanel_showDeployLayout = new javax.swing.GroupLayout(jPanel_showDeploy);
        jPanel_showDeploy.setLayout(jPanel_showDeployLayout);
        jPanel_showDeployLayout.setHorizontalGroup(
            jPanel_showDeployLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_showDeployLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel_showDeployLayout.setVerticalGroup(
            jPanel_showDeployLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_showDeployLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel5)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_showPanelCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel_showDeploy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addComponent(jPanel_showPanelCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel_showDeploy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(376, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(102, 153, 255));

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Select Organization");

        jButton_addOrg.setBackground(new java.awt.Color(243, 15, 15));
        jButton_addOrg.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_addOrg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/antexpert/add.png"))); // NOI18N
        jButton_addOrg.setText("Add Org");
        jButton_addOrg.setToolTipText("Add new Organization Credentials");
        jButton_addOrg.setBorder(null);
        jButton_addOrg.setContentAreaFilled(false);
        jButton_addOrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_addOrgActionPerformed(evt);
            }
        });

        jButton_removeOrg.setBackground(new java.awt.Color(51, 51, 51));
        jButton_removeOrg.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton_removeOrg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/antexpert/rubbish.png"))); // NOI18N
        jButton_removeOrg.setContentAreaFilled(false);
        jButton_removeOrg.setEnabled(false);
        jButton_removeOrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_removeOrgActionPerformed(evt);
            }
        });

        jList_orgLabels.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jList_orgLabels.setFont(new java.awt.Font("Arial Narrow", 0, 16)); // NOI18N
        jList_orgLabels.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList_orgLabelsMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jList_orgLabelsMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(jList_orgLabels);

        jButton_selectorg.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton_selectorg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/antexpert/tap.png"))); // NOI18N
        jButton_selectorg.setText("Select Org");
        jButton_selectorg.setActionCommand("Select Org");
        jButton_selectorg.setBorder(new javax.swing.border.MatteBorder(null));
        jButton_selectorg.setEnabled(false);
        jButton_selectorg.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton_selectorg.setIconTextGap(1);
        jButton_selectorg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_selectorgActionPerformed(evt);
            }
        });

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel_selectedOrg.setBackground(new java.awt.Color(153, 153, 153));
        jLabel_selectedOrg.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_selectedOrg.setForeground(new java.awt.Color(204, 199, 199));
        jLabel_selectedOrg.setText("--No Org selected--");

        jLabel7.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        jLabel7.setText("sf.serverurl");

        jLabel9.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        jLabel9.setText("sf.maxpoll");

        jLabel_urltype.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_urltype.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_urltype.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_urltype.setText("-");

        jLabel_maxpoll.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_maxpoll.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_maxpoll.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_maxpoll.setText("-");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel4.setText("Remove");
        jLabel4.setToolTipText("Remove selected org credentials");

        jLabel8.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel8.setText("click to select org.");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_addOrg, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jButton_removeOrg, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel4)))))
                .addGap(33, 33, 33)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_urltype, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel_maxpoll, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton_selectorg, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel_selectedOrg, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(24, 24, 24))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_addOrg, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_removeOrg)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel4))))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton_selectorg, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel_selectedOrg, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8))
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel_urltype))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel_maxpoll)))
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addGap(0, 0, 0)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel6.setLayout(new java.awt.CardLayout());

        jPanel_deploy.setBackground(new java.awt.Color(189, 216, 252));
        jPanel_deploy.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Deploy/ Retreive Package", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 20), new java.awt.Color(51, 51, 51))); // NOI18N
        jPanel_deploy.setForeground(new java.awt.Color(51, 51, 51));
        jPanel_deploy.setEnabled(false);

        jComboBox_deploy_retreive.setFont(new java.awt.Font("Arial Black", 0, 15)); // NOI18N
        jComboBox_deploy_retreive.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "deploy", "retreive" }));
        jComboBox_deploy_retreive.setEnabled(false);
        jComboBox_deploy_retreive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_deploy_retreiveActionPerformed(evt);
            }
        });

        jCheckBox_rollbackonerror.setBackground(new java.awt.Color(189, 216, 252));
        jCheckBox_rollbackonerror.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jCheckBox_rollbackonerror.setText("rollbackonError");
        jCheckBox_rollbackonerror.setEnabled(false);

        jCheckBox_checkonly.setBackground(new java.awt.Color(189, 216, 252));
        jCheckBox_checkonly.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jCheckBox_checkonly.setText("checkOnly");
        jCheckBox_checkonly.setEnabled(false);

        jCheckBox_testlevelLocal.setBackground(new java.awt.Color(189, 216, 252));
        jCheckBox_testlevelLocal.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jCheckBox_testlevelLocal.setText("testLevel-local");
        jCheckBox_testlevelLocal.setEnabled(false);
        jCheckBox_testlevelLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_testlevelLocalActionPerformed(evt);
            }
        });

        jCheckBox_testLevel_specific.setBackground(new java.awt.Color(189, 216, 252));
        jCheckBox_testLevel_specific.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jCheckBox_testLevel_specific.setText("testLevel-specific");
        jCheckBox_testLevel_specific.setEnabled(false);
        jCheckBox_testLevel_specific.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_testLevel_specificActionPerformed(evt);
            }
        });

        jButton_deploy_retreive.setBackground(new java.awt.Color(0, 0, 0));
        jButton_deploy_retreive.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton_deploy_retreive.setForeground(new java.awt.Color(255, 255, 255));
        jButton_deploy_retreive.setText("Create Target Action");
        jButton_deploy_retreive.setEnabled(false);
        jButton_deploy_retreive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_deploy_retreiveActionPerformed(evt);
            }
        });

        jTextArea_specifictests_deploy.setColumns(20);
        jTextArea_specifictests_deploy.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
        jTextArea_specifictests_deploy.setRows(5);
        jTextArea_specifictests_deploy.setToolTipText("Line Separated Tests");
        jScrollPane5.setViewportView(jTextArea_specifictests_deploy);

        jLabel1.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("line separated tests-specify");

        javax.swing.GroupLayout jPanel_deployLayout = new javax.swing.GroupLayout(jPanel_deploy);
        jPanel_deploy.setLayout(jPanel_deployLayout);
        jPanel_deployLayout.setHorizontalGroup(
            jPanel_deployLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_deployLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jComboBox_deploy_retreive, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel_deployLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox_testLevel_specific)
                    .addComponent(jCheckBox_rollbackonerror)
                    .addComponent(jCheckBox_testlevelLocal)
                    .addComponent(jCheckBox_checkonly))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_deployLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_deployLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel_deployLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                        .addComponent(jButton_deploy_retreive)
                        .addGap(40, 40, 40))))
        );
        jPanel_deployLayout.setVerticalGroup(
            jPanel_deployLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_deployLayout.createSequentialGroup()
                .addGroup(jPanel_deployLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_deployLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel_deployLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_deploy_retreive)
                            .addGroup(jPanel_deployLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel_deployLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel_deployLayout.createSequentialGroup()
                                        .addComponent(jComboBox_deploy_retreive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_deployLayout.createSequentialGroup()
                                        .addComponent(jCheckBox_checkonly)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addComponent(jCheckBox_testlevelLocal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox_testLevel_specific)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox_rollbackonerror))))
                    .addGroup(jPanel_deployLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 148, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel_deploy, "card4");

        jPanel_pkg_create.setBackground(new java.awt.Color(188, 216, 253));
        jPanel_pkg_create.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Package Management", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 20))); // NOI18N

        jButton_add.setBackground(new java.awt.Color(51, 51, 51));
        jButton_add.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButton_add.setForeground(new java.awt.Color(255, 255, 255));
        jButton_add.setText("Add Components");
        jButton_add.setToolTipText("");
        jButton_add.setEnabled(false);
        jButton_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_addActionPerformed(evt);
            }
        });

        jButton_preview.setBackground(new java.awt.Color(51, 51, 51));
        jButton_preview.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButton_preview.setForeground(new java.awt.Color(255, 255, 255));
        jButton_preview.setText("Preview Package");
        jButton_preview.setEnabled(false);
        jButton_preview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_previewActionPerformed(evt);
            }
        });

        jLabel_added.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel_added.setForeground(new java.awt.Color(220, 251, 190));
        jLabel_added.setText("Added Components to Package");

        jRadioButton1.setBackground(new java.awt.Color(189, 216, 252));
        buttonGroup_pkgaction.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jRadioButton1.setMnemonic(' ');
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Create");
        jRadioButton1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setBackground(new java.awt.Color(189, 216, 252));
        buttonGroup_pkgaction.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jRadioButton2.setText("Update");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jButton_save.setBackground(new java.awt.Color(51, 51, 51));
        jButton_save.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton_save.setForeground(new java.awt.Color(255, 255, 255));
        jButton_save.setText("Save");
        jButton_save.setEnabled(false);
        jButton_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_saveActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(189, 216, 252));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Enter Components Full Name (line separated)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 14), new java.awt.Color(0, 51, 102))); // NOI18N

        jTextArea_components.setColumns(20);
        jTextArea_components.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel5.setBackground(new java.awt.Color(189, 216, 252));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Select metadata", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 14), new java.awt.Color(0, 51, 102))); // NOI18N

        jTextField_metadata.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_metadataKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField_metadata, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jTextField_metadata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jButton_backup_packages.setBackground(new java.awt.Color(51, 51, 51));
        jButton_backup_packages.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton_backup_packages.setForeground(new java.awt.Color(255, 255, 255));
        jButton_backup_packages.setText("BACKUP");
        jButton_backup_packages.setEnabled(false);
        jButton_backup_packages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_backup_packagesActionPerformed(evt);
            }
        });

        jComboBox_pkgName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "package", "destructiveChangesPost", "destructiveChangesPre" }));
        jComboBox_pkgName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_pkgNameActionPerformed(evt);
            }
        });

        jList_createdpackage_names.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "select package to update", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16), new java.awt.Color(153, 51, 0))); // NOI18N
        jList_createdpackage_names.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        jList_createdpackage_names.setForeground(new java.awt.Color(0, 51, 102));
        jList_createdpackage_names.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList_createdpackage_namesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel_pkg_createLayout = new javax.swing.GroupLayout(jPanel_pkg_create);
        jPanel_pkg_create.setLayout(jPanel_pkg_createLayout);
        jPanel_pkg_createLayout.setHorizontalGroup(
            jPanel_pkg_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_pkg_createLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel_pkg_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_pkg_createLayout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_pkg_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_added)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_pkgName, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel_pkg_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_pkg_createLayout.createSequentialGroup()
                        .addGap(18, 19, Short.MAX_VALUE)
                        .addGroup(jPanel_pkg_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel_pkg_createLayout.createSequentialGroup()
                                .addComponent(jButton_add)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addComponent(jButton_backup_packages))
                            .addGroup(jPanel_pkg_createLayout.createSequentialGroup()
                                .addComponent(jButton_save, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_preview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(27, 27, 27))
                    .addGroup(jPanel_pkg_createLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jList_createdpackage_names, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel_pkg_createLayout.setVerticalGroup(
            jPanel_pkg_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_pkg_createLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel_pkg_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton2)
                    .addGroup(jPanel_pkg_createLayout.createSequentialGroup()
                        .addGroup(jPanel_pkg_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_add)
                            .addComponent(jComboBox_pkgName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_save))
                    .addComponent(jRadioButton1)
                    .addGroup(jPanel_pkg_createLayout.createSequentialGroup()
                        .addComponent(jButton_backup_packages)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_preview)))
                .addGap(10, 10, 10)
                .addComponent(jLabel_added)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_pkg_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jList_createdpackage_names, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel_pkg_create, "card4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        
    
    
    
    private void jList_metadata_typesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList_metadata_typesMousePressed
        // TODO add your handling code here:
        jTextField_metadata.setText(jList_metadata_types.getSelectedValue());
    }//GEN-LAST:event_jList_metadata_typesMousePressed

    private void jButton_deploy_retreiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_deploy_retreiveActionPerformed
        // TODO add your handling code here:
        if( jComboBox_deploy_retreive.isEnabled() ){

            String temp = jComboBox_deploy_retreive.getSelectedItem().toString();
            ArrayList<Integer> l = new ArrayList<Integer>();
            String xmlString = "";
            boolean NO_ACITON = false;

            if(jCheckBox_checkonly.isSelected()){
                l.add(CHECKONLY);
            }
            if(jCheckBox_rollbackonerror.isSelected()){
                l.add(ROLLBACK);
            }
            if(jCheckBox_testLevel_specific.isSelected()){
                l.add(TESTSPECIFIC);
            }
            if(jCheckBox_testlevelLocal.isSelected()){
                l.add(TESTLOCAL);
            }

            if(jComboBox_deploy_retreive.getSelectedItem() == "deploy"){
                xmlString = DeployProp.getDeployBuildString(l);
                //check if files available
                if( !new File(base_path+retreivedSource).exists() || new File(base_path + retreivedSource).list().length == 0){
                    NO_ACITON = true;
                    JOptionPane.showMessageDialog(null, "There are no files to Deploy.");
                }else{
                    //move any post pre deployment files to folder
                    String pre_path = base_path + retreive + "\\destructiveChangesPre.xml";
                    String post_path = base_path + retreive + "\\destructiveChangesPost.xml";
                    
                    try{
                    if(new File(pre_path).exists() )
                        Files.move( Paths.get(pre_path), Paths.get(base_path + retreivedSource + "\\destructiveChangesPre.xml") );
                    if(new File(post_path).exists() )
                        Files.move( Paths.get(post_path), Paths.get(base_path + retreivedSource + "\\destructiveChangesPost.xml") );
                    }catch(IOException ex){
                        System.out.println( " Moving pre/post xml to retreived Source:\n"+ ex.getMessage());
                    }
                }
                
            }else if( jComboBox_deploy_retreive.getSelectedItem() == "retreive"){
                xmlString = DeployProp.getRetreiveBuildString(l);
                //check for packages
                if( new File(base_path + retreive).list().length == 0){
                   NO_ACITON = true;
                   JOptionPane.showMessageDialog(null, "There are no packages created. Create packages to retreive.");
                }else{
                    try{
                        deleteDirectory( new File(base_path+retreivedSource));
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                }
            }

            //write build.xml
            writeTobuildProp(xmlString);

            //use command stored in temp.
            try{
                //Runtime.getRuntime().exec(new String[] {"cmd", "/K", "Start"});
                if(!NO_ACITON)
                    Runtime.getRuntime().exec("cmd /K start ant " + temp, null , new File(base_path+"\\Ant"));

            }catch(Exception ex){
                ex.printStackTrace();
            }

        }

    }//GEN-LAST:event_jButton_deploy_retreiveActionPerformed

    //recursive delete files and folders
    public boolean deleteDirectory(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        return directoryToBeDeleted.delete();
    }
    
    private void jCheckBox_testLevel_specificActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_testLevel_specificActionPerformed
        // TODO add your handling code here:

        if(jCheckBox_testLevel_specific.isSelected()){
            jTextArea_specifictests_deploy.setVisible(true);
            jCheckBox_testlevelLocal.setEnabled(false);
        }else{
            jCheckBox_testlevelLocal.setEnabled(true);
            jTextArea_specifictests_deploy.setVisible(false);
        }

    }//GEN-LAST:event_jCheckBox_testLevel_specificActionPerformed

    private void jCheckBox_testlevelLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_testlevelLocalActionPerformed
        // TODO add your handling code here:
        if(jCheckBox_testlevelLocal.isSelected()){
            jCheckBox_testLevel_specific.setEnabled(false);
        }else{
            jCheckBox_testLevel_specific.setEnabled(true);
        }
    }//GEN-LAST:event_jCheckBox_testlevelLocalActionPerformed

    private void jComboBox_deploy_retreiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_deploy_retreiveActionPerformed
        // TODO add your handling code here:

        String temp = jComboBox_deploy_retreive.getSelectedItem().toString();
        if(temp == "deploy"){
            jCheckBox_checkonly.setEnabled(true);
            jCheckBox_rollbackonerror.setEnabled(true);
            jCheckBox_testLevel_specific.setEnabled(true);
            jCheckBox_testlevelLocal.setEnabled(true);

            clearCheckBoxSelection();

        }else if(temp == "retreive"){
            jCheckBox_checkonly.setEnabled(false);
            jCheckBox_rollbackonerror.setEnabled(false);
            jCheckBox_testLevel_specific.setEnabled(false);
            jCheckBox_testlevelLocal.setEnabled(false);

            clearCheckBoxSelection();
        }

    }//GEN-LAST:event_jComboBox_deploy_retreiveActionPerformed

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

        JOptionPane.showMessageDialog(this, "Deployment and retreival will happen through "+SELECTED_ORG_LABEL+" Org.");
        jLabel_selectedOrg.setText( "--"+ SELECTED_ORG_LABEL+" Org selected--");

        //deploy retreive tab function enable
        jComboBox_deploy_retreive.setEnabled(true);
        String temp = jComboBox_deploy_retreive.getSelectedItem().toString();
        if(temp == "deploy"){
            jCheckBox_checkonly.setEnabled(true);
            jCheckBox_rollbackonerror.setEnabled(true);
            jCheckBox_testLevel_specific.setEnabled(true);
            jCheckBox_testlevelLocal.setEnabled(true);
        }else if(temp == "retreive"){
            jCheckBox_checkonly.setEnabled(false);
            jCheckBox_rollbackonerror.setEnabled(false);
            jCheckBox_testLevel_specific.setEnabled(false);
            jCheckBox_testlevelLocal.setEnabled(false);
        }
        jButton_deploy_retreive.setEnabled(true);
        //////////////////////////////////////////

    }//GEN-LAST:event_jButton_selectorgActionPerformed

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

    private void jList_orgLabelsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList_orgLabelsMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jList_orgLabelsMouseClicked

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

            //disable combo box, checkbox, button deploy_retreive
            jComboBox_deploy_retreive.setEnabled(false);
            clearCheckBoxSelection();
            jButton_deploy_retreive.setEnabled(false);

        }

    }//GEN-LAST:event_jButton_removeOrgActionPerformed

    private void jButton_addOrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_addOrgActionPerformed
        // TODO add your handling code here:

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 2, 2));

        JTextField username = new JTextField(15);
        JTextField password = new JTextField(15);
        JTextField securitytoken = new JTextField(15);
        JTextField maxpoll = new JTextField(15);
        maxpoll.setText("20");
        JTextField label = new JTextField(15);

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
        panel.add(new JLabel("Security Token : "));
        panel.add(securitytoken);
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

            String l, u, p, m, tg, st;
            l = label.getText();
            u = username.getText();
            p = password.getText();
            st = securitytoken.getText();
            m = maxpoll.getText();
            tg = test_org.isSelected()? "test" : "login";

            org_map.put(l, new MdUtility( l, u, p, st, m,tg) );

            try{
                BufferedWriter bw = new BufferedWriter(new FileWriter(base_path + config, true));
                //label username password security_token maxpoll tg
                bw.write(l+"\t"+u+"\t"+p+"\t"+st+"\t"+m+"\t"+tg+"\n");
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
                JOptionPane.showMessageDialog(this, "Changes have been saved to "+ file_name);

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

    private void jComboBox_pkgNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_pkgNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_pkgNameActionPerformed

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

    private void jTextArea_componentsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea_componentsKeyReleased
        // TODO add your handling code here:
        components = jTextArea_components.getText().toString();

        if(!components.equals("") && jRadioButton1.isSelected()){

            jButton_add.setEnabled(true);

        }else{
            jButton_add.setEnabled(false);

        }

    }//GEN-LAST:event_jTextArea_componentsKeyReleased

    private void jButton_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_saveActionPerformed
        // TODO add your handling code here:
        packageString = createPackageString(metadata_map);

        // save to directory
        try{
            BufferedWriter bf = new BufferedWriter( new FileWriter(new File(base_path + retreive +"\\" + jComboBox_pkgName.getSelectedItem()+".xml" )));
                bf.write(packageString);
                bf.close();

                String temp = jComboBox_pkgName.getSelectedItem().toString()+".xml";
                if(!defaultListModel_createdPackagenames.contains(temp)){
                    defaultListModel_createdPackagenames.addElement(temp);
                }
            }catch(IOException ex){
                ex.printStackTrace();
            }

            JOptionPane.showMessageDialog( new JFrame(),jComboBox_pkgName.getSelectedItem()+" has been saved.\nBegin creating new package.\nTo edit, switch to update mode.");

            jButton_preview.setEnabled(false);
            jButton_save.setEnabled(false);
            jButton_add.setEnabled(false);
            jButton_backup_packages.setEnabled(true);

            //reset
            metadata_map = new HashMap<>();
            jTextArea_components.setText("");
            jTextField_metadata.setText("");

    }//GEN-LAST:event_jButton_saveActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:

        if( metadata_map.isEmpty()){
            jComboBox_pkgName.setVisible(false);
            jList_createdpackage_names.setVisible(true);

            jLabel_added.setVisible(false);
            jButton_add.setEnabled(false);
            jButton_preview.setEnabled(false);
            jButton_save.setEnabled(false);

            //reset
            metadata_map = new HashMap<>();
            jTextArea_components.setText("");
            jTextField_metadata.setText("");
        }else{
            int temp = JOptionPane.showConfirmDialog(this, "You have a package in making,\nchanges "
                + "will be lost if continued.\nClick Yes to continue. ", "Warning!!", JOptionPane.YES_NO_OPTION);
            if(temp == JOptionPane.YES_OPTION){
                jComboBox_pkgName.setVisible(false);
                jList_createdpackage_names.setVisible(true);

                jLabel_added.setVisible(false);
                jButton_add.setEnabled(false);
                jButton_preview.setEnabled(false);
                jButton_save.setEnabled(false);

                //reset
                metadata_map = new HashMap<>();
                jTextArea_components.setText("");
                jTextField_metadata.setText("");
            }else{
                jRadioButton1.setSelected(true);
            }
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        jList_createdpackage_names.setVisible(false);
        jComboBox_pkgName.setVisible(true);
        jTextArea_components.setText("");

        //activate backup if retreive folder contains files
        String path = base_path + retreive;
        File file = new File(path);
        int len  = file.list().length ;
        if(len > 0)
        jButton_backup_packages.setEnabled(true);

    }//GEN-LAST:event_jRadioButton1ActionPerformed

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
                    sb.append("\t<members>"+member.trim()+"</members>\n");
                }
            }
            sb.append("\t<name>"+key_name+"</name>\n</types>\n\n");
        }

        //        VERSION = Float.parseFloat(jTextField_pkg_version.getText().toString());
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

    private void jButton_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_addActionPerformed
        // TODO add your handling code here:
        components = jTextArea_components.getText().toString();

        if( !jTextField_metadata.getText().isEmpty() && !jTextArea_components.getText().isEmpty()  ){
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

            //button disable
            jButton_add.setEnabled(false);
        }else{
            JOptionPane.showMessageDialog(this, "Metadata or components is Empty!!\nAdd components to a metadata type to continue.");
        }
    }//GEN-LAST:event_jButton_addActionPerformed

    private void jPanel_showPanelCreateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_showPanelCreateMouseClicked
        // TODO add your handling code here:
        jPanel_showPanelCreate.setBackground( new Color(46, 69, 113));
        jPanel_pkg_create.setVisible(true);
        jPanel_deploy.setVisible(false);
        jPanel_showDeploy.setBackground(new Color(0, 51, 102));
    }//GEN-LAST:event_jPanel_showPanelCreateMouseClicked

    private void jPanel_showDeployMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_showDeployMouseClicked
        // TODO add your handling code here:
        jPanel_showDeploy.setBackground(new Color(46, 69, 113));
        jPanel_pkg_create.setVisible(false);
        jPanel_deploy.setVisible(true);
        jPanel_showPanelCreate.setBackground(new Color(0, 51, 102));
    }//GEN-LAST:event_jPanel_showDeployMouseClicked

    public void writeTobuildProp(String str){
        
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(base_path + build_xml)));
            bw.write(str);
            bw.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
    }
        
    public void clearCheckBoxSelection(){
        jCheckBox_checkonly.setSelected(false);
        jCheckBox_rollbackonerror.setSelected(false);
        jCheckBox_testLevel_specific.setSelected(false);
        jTextArea_specifictests_deploy.setVisible(false);
        jCheckBox_testlevelLocal.setSelected(false);
    }
    
    public String createPackageString(Map<String, String[]> allcomp){

        StringBuilder sb = new StringBuilder();
        sb.append(head);

        for(Map.Entry<String, String[]> entry : allcomp.entrySet() ){
            
            sb.append("<types>\n");
            String key_name = entry.getKey();
            String [] value_members = entry.getValue();

            if(value_members.length > 0){
                
                for(String member: value_members){
                    if(!member.equals(""))
                        sb.append("\t<members>"+member.trim()+"</members>\n");
                }
            }   
            sb.append("\t<name>"+key_name+"</name>\n</types>\n\n");    
        }
        
//        VERSION = Float.parseFloat(jTextField_pkg_version.getText().toString());
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
    private javax.swing.JButton jButton_deploy_retreive;
    private javax.swing.JButton jButton_preview;
    private javax.swing.JButton jButton_removeOrg;
    private javax.swing.JButton jButton_save;
    private javax.swing.JButton jButton_selectorg;
    private javax.swing.JCheckBox jCheckBox_checkonly;
    private javax.swing.JCheckBox jCheckBox_rollbackonerror;
    private javax.swing.JCheckBox jCheckBox_testLevel_specific;
    private javax.swing.JCheckBox jCheckBox_testlevelLocal;
    private javax.swing.JComboBox<String> jComboBox_deploy_retreive;
    private javax.swing.JComboBox<String> jComboBox_pkgName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_added;
    private javax.swing.JLabel jLabel_maxpoll;
    private javax.swing.JLabel jLabel_selectedOrg;
    private javax.swing.JLabel jLabel_urltype;
    private javax.swing.JList<String> jList_createdpackage_names;
    private javax.swing.JList<String> jList_metadata_types;
    private javax.swing.JList<String> jList_orgLabels;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel_deploy;
    private javax.swing.JPanel jPanel_pkg_create;
    private javax.swing.JPanel jPanel_showDeploy;
    private javax.swing.JPanel jPanel_showPanelCreate;
    private javax.swing.JPopupMenu jPopupMenu;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextArea jTextArea_components;
    private javax.swing.JTextArea jTextArea_specifictests_deploy;
    private javax.swing.JTextField jTextField_metadata;
    // End of variables declaration//GEN-END:variables

   
}
