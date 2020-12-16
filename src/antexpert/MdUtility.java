package antexpert;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cepheus
 */
public class MdUtility {
    
    private String label;
    private String username;
    private String password;
    private String maxpoll;
    private String org_type;
      
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMaxpoll() {
        return maxpoll;
    }

    public void setMaxpoll(String maxpoll) {
        this.maxpoll = maxpoll;
    }

    public String getOrg_type() {
        return org_type;
    }

    public void setOrg_type(String org_type) {
        this.org_type = org_type;
    }

    public MdUtility(String label, String username, String password, String maxpoll, String org_type) {
        this.label = label;
        this.username = username;
        this.password = password;
        this.maxpoll = maxpoll;
        this.org_type = org_type;
    }
    
    public MdUtility(){}
    
    public String getBuildProperties(){
        
        return "# build.properties\n" +
                "#\n" +
                "\n" +
                "# Specify the login credentials for the desired Salesforce organization\n" +
                "sf.username = "+ getUsername() + "\n" +
                "sf.password = "+ getPassword()+ "\n" +
                "#sf.sessionId = <Insert your Salesforce session id here.  Use this or username/password above.  Cannot use both>\n" +
                "#sf.pkgName = <Insert comma separated package names to be retrieved>\n" +
                "#sf.zipFile = <Insert path of the zipfile to be retrieved>\n" +
                "#sf.metadataType = <Insert metadata type name for which listMetadata or bulkRetrieve operations are to be performed>\n" +
                "\n" +
                "sf.serverurl = https://"+ getOrg_type() +".salesforce.com\n" +
                "\n" +
                "sf.maxPoll = "+  getMaxpoll() +"\n" +
                "# If your network requires an HTTP proxy, see http://ant.apache.org/manual/proxy.html for configuration.\n" +
                "#";
    }
    
    public String build_xml = "<project name=\"Sample usage of Salesforce Ant tasks\" default=\"test\" basedir=\".\" xmlns:sf=\"antlib:com.salesforce\">\n" +
                "\n" +
                "    <property file=\"build.properties\"/>\n" +
                "    <property environment=\"env\"/>\n" +
                "\n" +
                "    <!-- Setting default value for username, password and session id properties to empty string \n" +
                "         so unset values are treated as empty. Without this, ant expressions such as ${sf.username}\n" +
                "         will be treated literally.\n" +
                "    -->\n" +
                "    <condition property=\"sf.username\" value=\"\"> <not> <isset property=\"sf.username\"/> </not> </condition>\n" +
                "    <condition property=\"sf.password\" value=\"\"> <not> <isset property=\"sf.password\"/> </not> </condition>\n" +
                "    <condition property=\"sf.sessionId\" value=\"\"> <not> <isset property=\"sf.sessionId\"/> </not> </condition>\n" +
                "\n" +
                "    <taskdef resource=\"com/salesforce/antlib.xml\" uri=\"antlib:com.salesforce\">\n" +
                "        <classpath>\n" +
                "            <pathelement location=\"../ant-salesforce.jar\" />        	\n" +
                "        </classpath>\n" +
                "    </taskdef>\n" +
                "    <target name=\"deploy\">\n" +
                "      <sf:deploy username=\"${sf.username}\" password=\"${sf.password}\" sessionId=\"${sf.sessionId}\" serverurl=\"${sf.serverurl}\"\n" +
                "      maxPoll=\"${sf.maxPoll}\" deployRoot=\"retreivedSource\" checkOnly=\"true\" rollbackOnError=\"true\"/>\n" +
                "    </target>\n"+
                "\n"+
                "<!-- Retrieve metadata for all the packages specified under packageNames -->\n" +
                "    <target name=\"retreive\">\n" +
                "      <sf:retrieve username=\"${sf.username}\" password=\"${sf.password}\" sessionId=\"${sf.sessionId}\" serverurl=\"${sf.serverurl}\" " +
                "maxPoll=\"${sf.maxPoll}\" retrieveTarget=\"retrieveOutput\" packageNames=\"${sf.pkgName}\"/>\n" +
                "    </target>";
    
    public String metadata_list = "AccountSettings\n" +
                            "ActionOverride\n" +
                            "ActivitiesSettings\n" +
                            "AddressSettings\n" +
                            "AnalyticSnapshot\n" +
                            "ApexClass\n" +
                            "ApexComponent\n" +
                            "ApexPage\n" +
                            "ApexTrigger\n" +
                            "AppMenu\n" +
                            "ApprovalProcess\n" +
                            "ArticleType\n" +
                            "AssignmentRules\n" +
                            "AuthProvider\n" +
                            "AutoResponseRules\n" +
                            "BaseSharingRule\n" +
                            "BusinessHoursSettings\n" +
                            "BusinessProcess\n" +
                            "CallCenter\n" +
                            "CaseSettings\n" +
                            "ChatterAnswersSettings\n" +
                            "CompanySettings\n" +
                            "Community (Zone)\n" +
                            "CompactLayout\n" +
                            "ConnectedApp\n" +
                            "ContractSettings\n" +
                            "CriteriaBasedSharingRule\n" +
                            "CustomApplication\n" +
                            "CustomApplicationComponent\n" +
                            "CustomField\n" +
                            "CustomLabels\n" +
                            "CustomObject\n" +
                            "CustomObjectTranslation\n" +
                            "CustomPageWebLink\n" +
                            "CustomSite\n" +
                            "CustomTab\n" +
                            "Dashboard\n" +
                            "DataCategoryGroup\n" +
                            "Document\n" +
                            "EmailTemplate\n" +
                            "EntitlementProcess\n" +
                            "EntitlementSettings\n" +
                            "EntitlementTemplate\n" +
                            "ExternalDataSource\n" +
                            "FieldSet\n" +
                            "FlexiPage\n" +
                            "Flow\n" +
                            "Folder\n" +
                            "FolderShare\n" +
                            "ForecastingSettings\n" +
                            "Group\n" +
                            "HomePageComponent\n" +
                            "HomePageLayout\n" +
                            "IdeasSettings\n" +
                            "InstalledPackage\n" +
                            "KnowledgeSettings\n" +
                            "Layout\n" +
                            "Letterhead\n" +
                            "ListView\n" +
                            "LiveAgentSettings\n" +
                            "LiveChatAgentConfig\n" +
                            "LiveChatButton\n" +
                            "LiveChatDeployment\n" +
                            "Metadata\n" +
                            "MetadataWithContent\n" +
                            "MilestoneType\n" +
                            "MobileSettings\n" +
                            "NamedFilter\n" +
                            "Network\n" +
                            "OpportunitySettings\n" +
                            "OrderSettings\n" +
                            "OwnerSharingRule\n" +
                            "Package\n" +
                            "PermissionSet\n" +
                            "Picklist\n" +
                            "Portal\n" +
                            "PostTemplate\n" +
                            "ProductSettings\n" +
                            "Profile\n" +
                            "Queue\n" +
                            "QuickAction\n" +
                            "QuoteSettings\n" +
                            "RecordType\n" +
                            "RemoteSiteSetting\n" +
                            "Report\n" +
                            "ReportType\n" +
                            "Role\n" +
                            "SamlSsoConfig\n" +
                            "Scontrol\n" +
                            "SearchLayouts\n" +
                            "SecuritySettings\n" +
                            "SharingReason\n" +
                            "SharingRecalculation\n" +
                            "SharingRules\n" +
                            "SharingSet\n" +
                            "SiteDotCom\n" +
                            "Skill\n" +
                            "StaticResource\n" +
                            "Territory\n" +
                            "Translations\n" +
                            "ValidationRule\n" +
                            "Weblink\n" +
                            "Workflow";
    
}
