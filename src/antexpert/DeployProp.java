/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antexpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author aseer
 */
public class DeployProp {
    
    public static final int CHECK = 1;
    public static final int ROLLBACK = 2;
    public static final int TESTSPECIFIC = 3;
    public static final int TESTLOCAL = 4;
    
    
    public static String isCheck = "checkOnly=\"true\"";
    public static String isRollback = "rollbackOnError=\"true\"";
    public static String istestlevelSpecific = "testLevel=\"RunSpecifiedTests\"";
    public static String specifictests = "";
    public static String istestlevelLocal = "testlevel=\"RunLocalTests\"";
    
    public static Map<Integer, String> map = new HashMap<Integer, String>(){{
                                                                            put(CHECK, isCheck);
                                                                            put(ROLLBACK, isRollback);
                                                                            put(TESTSPECIFIC, istestlevelSpecific);
                                                                            put(TESTLOCAL, istestlevelLocal);
                                                                            
    }};
        
    public void setSpecificTests(String specifictests){ //build string in main method
        this.specifictests = specifictests;
    }
 
    public static String getDeployBuildString( ArrayList<Integer> list){
        
        StringBuilder sb = new StringBuilder();
        for(Integer i : list){
            sb.append( map.get(i)+" ");
        }
       
        return "<project name=\"Sample usage of Salesforce Ant tasks\" default=\"test\" basedir=\".\" xmlns:sf=\"antlib:com.salesforce\">\n" +
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
            "	\n" +
            "   \n" +
            "    <target name=\"retreive\">\n" +
            "      <mkdir dir=\"retreivedSource\"/>\n" +
            "      <!-- Retrieve the contents listed in the file codepkg/package.xml into the codepkg directory -->\n" +
            "      <sf:retrieve username=\"${sf.username}\" password=\"${sf.password}\" sessionId=\"${sf.sessionId}\"\n" +
            "   serverurl=\"${sf.serverurl}\" maxPoll=\"${sf.maxPoll}\" retrieveTarget=\"retreivedSource\" unpackaged=\"retreive/package.xml\"/>\n" +
            "    </target>\n" +
            "	\n" +
            "    <target name=\"deploy\">\n" +
            "      <sf:deploy username=\"${sf.username}\" password=\"${sf.password}\" sessionId=\"${sf.sessionId}\" serverurl=\"${sf.serverurl}\"\n" +
            "	 maxPoll=\"${sf.maxPoll}\" deployRoot=\"retreivedSource\" "+  sb.toString() +"  >\n" +
                    specifictests +
            "      </sf:deploy>\n" +
            "    </target>\n" +
            "	\n" +
            "\n" +
            "	\n" +
            "   \n" +
            "\n" +
            "\n" +
            "</project>";
            }
            
            
//            public static String getRetreiveBuildString(){
//                
//            }
    
    
    
    
}
