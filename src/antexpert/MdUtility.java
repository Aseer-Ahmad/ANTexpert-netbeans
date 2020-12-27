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
    
    
    public String metadata_list = "ActionLinkGroupTemplate\n" +
                                "AnalyticSnapshot\n" +
                                "AnimationRule\n" +
                                "ApexClass\n" +
                                "ApexComponent\n" +
                                "ApexEmailNotifications\n" +
                                "ApexPage\n" +
                                "ApexTestSuite\n" +
                                "ApexTrigger\n" +
                                "AppMenu\n" +
                                "ApprovalProcess\n" +
                                "AssignmentRule\n" +
                                "AssignmentRules\n" +
                                "Audience\n" +
                                "AuraDefinitionBundle\n" +
                                "AuthProvider\n" +
                                "AutoResponseRule\n" +
                                "AutoResponseRules\n" +
                                "BlacklistedConsumer\n" +
                                "BrandingSet\n" +
                                "BusinessProcess\n" +
                                "CallCenter\n" +
                                "CallCoachingMediaProvider\n" +
                                "CampaignInfluenceModel\n" +
                                "CanvasMetadata\n" +
                                "CaseSubjectParticle\n" +
                                "Certificate\n" +
                                "ChannelLayout\n" +
                                "ChatterExtension\n" +
                                "CleanDataService\n" +
                                "CMSConnectSource\n" +
                                "Community\n" +
                                "CommunityTemplateDefinition\n" +
                                "CommunityThemeDefinition\n" +
                                "CompactLayout\n" +
                                "ConnectedApp\n" +
                                "ContentAsset\n" +
                                "CorsWhitelistOrigin\n" +
                                "CspTrustedSite\n" +
                                "CustomApplication\n" +
                                "CustomApplicationComponent\n" +
                                "CustomFeedFilter\n" +
                                "CustomField\n" +
                                "CustomHelpMenuSection\n" +
                                "CustomLabel\n" +
                                "CustomMetadata\n" +
                                "CustomNotificationType\n" +
                                "CustomObject\n" +
                                "CustomObjectTranslation\n" +
                                "CustomPageWebLink\n" +
                                "CustomPermission\n" +
                                "CustomSite\n" +
                                "CustomTab\n" +
                                "Dashboard\n" +
                                "DataCategoryGroup\n" +
                                "DelegateGroup\n" +
                                "Document\n" +
                                "DuplicateRule\n" +
                                "EclairGeoData\n" +
                                "EmailServicesFunction\n" +
                                "EmailTemplate\n" +
                                "EmbeddedServiceBranding\n" +
                                "EmbeddedServiceConfig\n" +
                                "EmbeddedServiceFlowConfig\n" +
                                "EmbeddedServiceMenuSettings\n" +
                                "EntityImplements\n" +
                                "EscalationRule\n" +
                                "EscalationRules\n" +
                                "ExternalDataSource\n" +
                                "ExternalServiceRegistration\n" +
                                "FieldSet\n" +
                                "FlexiPage\n" +
                                "Flow\n" +
                                "FlowCategory\n" +
                                "FlowDefinition\n" +
                                "GlobalValueSet\n" +
                                "GlobalValueSetTranslation\n" +
                                "Group\n" +
                                "HomePageComponent\n" +
                                "HomePageLayout\n" +
                                "IframeWhiteListUrlSettings\n" +
                                "InboundNetworkConnection\n" +
                                "Index\n" +
                                "InstalledPackage\n" +
                                "KeywordList\n" +
                                "Layout\n" +
                                "LeadConvertSettings\n" +
                                "Letterhead\n" +
                                "LightningBolt\n" +
                                "LightningComponentBundle\n" +
                                "LightningExperienceTheme\n" +
                                "LightningMessageChannel\n" +
                                "LightningOnboardingConfig\n" +
                                "ListView\n" +
                                "ManagedContentType\n" +
                                "ManagedTopic\n" +
                                "ManagedTopics\n" +
                                "MatchingRule\n" +
                                "MatchingRules\n" +
                                "MobileApplicationDetail\n" +
                                "ModerationRule\n" +
                                "MutingPermissionSet\n" +
                                "MyDomainDiscoverableLogin\n" +
                                "NamedCredential\n" +
                                "NavigationMenu\n" +
                                "Network\n" +
                                "NetworkBranding\n" +
                                "NotificationTypeConfig\n" +
                                "OauthCustomScope\n" +
                                "OutboundNetworkConnection\n" +
                                "PathAssistant\n" +
                                "PermissionSet\n" +
                                "PermissionSetGroup\n" +
                                "PlatformCachePartition\n" +
                                "PlatformEventChannel\n" +
                                "PlatformEventChannelMember\n" +
                                "PostTemplate\n" +
                                "Profile\n" +
                                "ProfilePasswordPolicy\n" +
                                "ProfileSessionSetting\n" +
                                "Prompt\n" +
                                "Queue\n" +
                                "QuickAction\n" +
                                "RecommendationStrategy\n" +
                                "RecordActionDeployment\n" +
                                "RecordType\n" +
                                "RedirectWhitelistUrl\n" +
                                "RemoteSiteSetting\n" +
                                "Report\n" +
                                "ReportType\n" +
                                "Role\n" +
                                "SamlSsoConfig\n" +
                                "Scontrol\n" +
                                "Settings\n" +
                                "SharingCriteriaRule\n" +
                                "SharingGuestRule\n" +
                                "SharingOwnerRule\n" +
                                "SharingReason\n" +
                                "SharingRules\n" +
                                "SharingSet\n" +
                                "SiteDotCom\n" +
                                "StandardValueSet\n" +
                                "StandardValueSetTranslation\n" +
                                "StaticResource\n" +
                                "SynonymDictionary\n" +
                                "TopicsForObjects\n" +
                                "UserCriteria\n" +
                                "UserProvisioningConfig\n" +
                                "ValidationRule\n" +
                                "WebLink\n" +
                                "Workflow\n" +
                                "WorkflowAlert\n" +
                                "WorkflowFieldUpdate\n" +
                                "WorkflowOutboundMessage\n" +
                                "WorkflowRule\n" +
                                "WorkflowSend\n" +
                                "WorkflowTask" ;
    
}