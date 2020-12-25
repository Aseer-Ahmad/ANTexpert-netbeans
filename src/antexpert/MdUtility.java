package antexpert;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aseer
 */
public class MdUtility {
    
    private String label;
    private String username;
    private String password;
    private String security_token;

    private String maxpoll;
    private String org_type;
      
    public String getSecurity_token() {
        return security_token;
    }

    public void setSecurity_token(String security_token) {
        this.security_token = security_token;
    }
    
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

    public MdUtility(String label, String username, String password, String security_token, String maxpoll, String org_type) {
        this.label = label;
        this.username = username;
        this.password = password;
        this.security_token = security_token;
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
                "sf.password = "+ getPassword() + getSecurity_token()+ "\n" +
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
